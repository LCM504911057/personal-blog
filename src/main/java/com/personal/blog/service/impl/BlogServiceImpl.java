package com.personal.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.personal.blog.dao.BlogMapper;
import com.personal.blog.dao.ColumnistMapper;
import com.personal.blog.dao.TagMapper;
import com.personal.blog.entity.Blog;
import com.personal.blog.entity.Columnist;
import com.personal.blog.entity.Tag;
import com.personal.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    ColumnistMapper columnistMapper;

    @Autowired
    TagMapper tagMapper;

    private boolean updateCount(Blog blog, int count){
        // 1选择对应专栏，更新对应专栏的博客数量,一对一(Columnist)
        ArrayList cIds = new ArrayList();
        cIds.add(blog.getColumnId());
        List<Columnist> cList = columnistMapper.findColumnistByIds(cIds);
        if (cList == null || cList.size() == 0) {
            // 没有对应的专栏
            return false;
        }

        Columnist col = cList.get(0);
        int blogCount = col.getBlogCount();
        col.setBlogCount(blogCount + count);
        columnistMapper.updateColumnist(col);

        // 2选择对应标签，更新对应标签的博客数量,一对多(Tag)
        // 1,3,5

        String tags = blog.getTags();
        List tIds = Arrays.asList(tags.split(","));
        List<Tag> tagList = tagMapper.findTagByIds(tIds);
        if (tagList == null || tagList.size() == 0) {
            // 没有对应的标签
            return false;
        }
        for (Tag tag : tagList) {
            int bc = tag.getBlogCount();
            tag.setBlogCount(bc + count);
            tagMapper.updateTag(tag);
        }

        return true;
    }

    // 添加事务，保证数据的一致性
    @Override
    @Transactional
    public int addBlog(Blog blog) {



        if (blog.getBlogState() == 1) {
            // 直接保存+发布
            blog.setPublishDate(new Date());

            // 1选择对应专栏，更新对应专栏的博客数量,一对一(Columnist)


            // 只有发布状态的博客，才更新对应的数量+1
            if (!updateCount(blog, 1)) {
                // 没有对应的专栏或标签
                return -2;
            }
        }

        // 创建时间
        blog.setCreateTime(new Date());
        // 最后修改时间
        blog.setUpdateTime(new Date());

        return blogMapper.insertBlog(blog);
    }

    @Override
    public List<Blog> getBlogNewest() {
        return blogMapper.findBlogNewest();
    }

    private void getBlogColumnist(List<Blog> bList) {
        if (bList == null || bList.size() == 0) {
            return;
        }
        for (Blog blog : bList) {
            ArrayList cIds = new ArrayList();
            cIds.add(blog.getColumnId());
            List<Columnist> cList = columnistMapper.findColumnistByIds(cIds);
            if (cList == null || cList.size() == 0) {
                // 没有对应的专栏
                return;
            }

            Columnist col = cList.get(0);
            blog.setColumnist(col);
//            blogMapper.updateBlog(blog);
        }
    }

    @Override
    public PageInfo<Blog> getBlogByCondition(Map<String, Object> map) {
        List<Blog> list;
        if (map == null) {
            // 调用查询之前，必须设置
            // PageHelper.startPage(1, 2);
            // 哪一页，每页多少数据，就可以自动完成sql分页功能
            // 原理是基于mybatis拦截器在最终statement，最终sql语句上拼接limit
            list = blogMapper.findBlogAll();
        }else {
            list = blogMapper.findBlogByCondition(map);
        }
        getBlogColumnist(list);
        return new PageInfo<>(list);
    }

    @Override
    public int delBlog(int id) {

        ArrayList ids = new ArrayList();
        ids.add(id);
        List<Blog> list = blogMapper.findBlogByIds(ids);
        if (list == null || list.size() == 0) {
            return 0;
        }
        Blog blog = list.get(0);
        blog.setBlogState(-1);

        return blogMapper.updateBlog(blog);
    }

    @Override
    public Blog getBlog(int id) {
        ArrayList ids = new ArrayList();
        ids.add(id);

        List<Blog> list = blogMapper.findBlogByIds(ids);
        if (list == null || list.size() == 0) {
            return null;
        }
        getBlogColumnist(list);
        return list.get(0);
    }

    @Override
    public int updateBlog(Blog blog) {
        // TODO 专栏或标签对应下的博客数量，在草稿状态下，数量更新问题
//        if (blog.getBlogState() != 1) {
//
//        }
        return blogMapper.updateBlog(blog);
    }
}
