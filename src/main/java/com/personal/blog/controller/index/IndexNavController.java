package com.personal.blog.controller.index;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personal.blog.entity.Blog;
import com.personal.blog.entity.Columnist;
import com.personal.blog.entity.Tag;
import com.personal.blog.service.BlogService;
import com.personal.blog.service.ColumnistService;
import com.personal.blog.service.TagService;
import com.personal.blog.utils.MarkdownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class IndexNavController {

    @Autowired
    ColumnistService columnistService;

    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public String indexPage(Model model) {

        // 首页的专栏显示10个
        List<Columnist> cList = columnistService.getColumnistByTop();
        model.addAttribute("cList", cList);

        List<Tag> tagList = tagService.getAll();
        model.addAttribute("tList", tagList);

        // 默认显示8条博客
        // 参数一：第几页
        // 参数二：每页多少条数据
        PageHelper.startPage(1, 8);
        PageInfo<Blog> pageInfo = blogService.getBlogByCondition(null);
        List<Blog> newest = blogService.getBlogNewest();

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("newest", newest);
        model.addAttribute("blogNav", 1);

        return "index";
    }

    @GetMapping("/columnistPage")
    public String columnistPage(Model model) {

        PageHelper.startPage(1, 8);
        // 专栏
        PageInfo<Columnist> pageInfo = columnistService.getColumnistByCondition(null);

        Columnist columnist = pageInfo.getList().get(0);
        int cid = columnist.getId();
        HashMap<String, Object> map = new HashMap<>();
        map.put("columnId", cid);
        PageInfo<Blog> blogList = blogService.getBlogByCondition(map);

        // 对应第一个专栏ID的博客
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("typeId", cid);
        model.addAttribute("blogList", blogList);
        model.addAttribute("blogNav", 2);

        return "columnist";
    }

    @GetMapping("/archivesPage")
    public String archivesPage(Model model) {
        model.addAttribute("blogNav", 4);

        PageInfo<Blog> pageInfo = blogService.getBlogByCondition(null);

        model.addAttribute("number", pageInfo.getTotal());
        HashMap<Integer, List<Blog>> years = new HashMap<>();
        List<Blog> blogList = pageInfo.getList();

        // 按照年份进行hashMap归档
        // key=年份,value=博客列表(List<Blog>)
        for (Blog blog : blogList) {
            Date blogDate = blog.getCreateTime();
            // yyyy
            Integer year = DateUtil.year(blogDate);
            // list --> yyyy
            if (years.get(year) == null) {
                List<Blog> list = new ArrayList<>();
                list.add(blog);
                years.put(year, list);
            } else {
                List<Blog> list = years.get(year);
                list.add(blog);
            }
        }
        // 2020 blogList
        // 2019 blogList
        model.addAttribute("years", years);

        return "archives";
    }

    @GetMapping("/aboutPage")
    public String aboutPage(Model model) {
        model.addAttribute("blogNav", 5);
        return "about";
    }

    @GetMapping("/tagPage")
    public String tagPage(Model model) {

        PageHelper.startPage(1, 8);
        // 专栏
        PageInfo<Tag> pageInfo = tagService.getTagByCondition(null);

        Tag tag = pageInfo.getList().get(0);
        int tid = tag.getId();
        HashMap<String, Object> map = new HashMap<>();
        map.put("tags", tid);
        PageInfo<Blog> blogList = blogService.getBlogByCondition(map);

        // 对应第一个专栏ID的博客
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tagId", tid);
        model.addAttribute("blogList", blogList);
        model.addAttribute("blogNav", 3);

        return "tags";
    }

    // 博客的条件查询
    @GetMapping("/getPaging")
    public String getPaging(@RequestParam Map<String, Object> map, Model model) {

        int pageNum = Convert.toInt(map.get("pageNum"));
        PageHelper.startPage(pageNum, 8);

        PageInfo<Blog> pageInfo = blogService.getBlogByCondition(map);

        model.addAttribute("pageInfo", pageInfo);

        // 返回指定片段
        return "index::table_refresh";
    }

    @GetMapping("/blogPage/{id}")
    public String blogPage(@PathVariable Integer id, Model model) {

        Blog blog = blogService.getBlog(id);

        // TODO 需要更新博客的查看次数

        // 格式转换
        blog.setContent(MarkdownUtil.markdownToHtmlExtens(blog.getContent()));
        model.addAttribute("blog", blog);

        return "blog";
    }

}
