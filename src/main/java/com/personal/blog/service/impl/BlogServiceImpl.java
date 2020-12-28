package com.personal.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.personal.blog.dao.BlogMapper;
import com.personal.blog.entity.Blog;
import com.personal.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public int addBlog(Blog blog) {

        if (blog.getBlogState() == 1) {
            // 直接保存+发布
            blog.setPublishDate(new Date());
        }

        // 创建时间
        blog.setCreateTime(new Date());
        // 最后修改时间
        blog.setUpdateTime(new Date());

        return blogMapper.insertBlog(blog);
    }


    @Override
    public PageInfo<Blog> getBlogPaging() {

        // 调用查询之前，必须设置
        // PageHelper.startPage(1, 2);
        // 哪一页，每页多少数据，就可以自动完成sql分页功能
        // 原理是基于mybatis拦截器在最终statement，最终sql语句上拼接limit
        List<Blog> list = blogMapper.findBlogAll();
        PageInfo<Blog> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public PageInfo<Blog> getBlogByCondition(Map<String, Object> map) {

        List<Blog> list = blogMapper.findBlogByCondition(map);
        PageInfo<Blog> pageInfo = new PageInfo<>(list);

        return pageInfo;
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
        return list.get(0);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }
}
