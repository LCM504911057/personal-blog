package com.personal.blog.controller;

import com.personal.blog.entity.Blog;
import com.personal.blog.entity.Columnist;
import com.personal.blog.entity.Tag;
import com.personal.blog.service.BlogService;
import com.personal.blog.service.ColumnistService;
import com.personal.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ColumnistService columnistService;

    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;

    @GetMapping("/blogAddPage")
    public String blogAddPage(Model model) {
        // 专栏
        List<Columnist> cList = columnistService.getAll();
        // 标签
        List<Tag> tList = tagService.getAll();

        model.addAttribute("cList", cList);
        model.addAttribute("tList", tList);

        return "admin/blog_add";
    }

    @PostMapping("/blogAdd")
    public String blogAdd(Blog blog) {
        int code = blogService.addBlog(blog);

        if (code < 1) {
            // 添加博客失败
        }

        System.out.println(code);
        return "redirect:/admin/index";
    }

    @GetMapping("/index")
    public String index() {
        return "admin/manage";
    }
}
