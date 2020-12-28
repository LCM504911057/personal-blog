package com.personal.blog.controller;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personal.blog.entity.Blog;
import com.personal.blog.entity.Columnist;
import com.personal.blog.entity.Tag;
import com.personal.blog.service.BlogService;
import com.personal.blog.service.ColumnistService;
import com.personal.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

        System.out.println("blogState:" + blog.getBlogState());

        int code = blogService.addBlog(blog);

        if (code < 1) {
            // 添加博客失败
        }

//        System.out.println(code);
        return "redirect:/admin/index";
    }

    @GetMapping("/findCondition")
    public String findByCondition(@RequestParam Map<String, Object> map, Model model) {

        int pageNum = Convert.toInt(map.get("pageNum"));
        PageHelper.startPage(pageNum, 8);

        PageInfo<Blog> pageInfo = blogService.getBlogByCondition(map);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("maxPage", pageInfo.getPages());
        // "admin/manage::table_refresh"
        // 返回指定片段
        return "admin/manage::table_refresh";
    }

    /**
     * 后台首页
     * @return
     */
    @GetMapping("/index")
    public String index(Model model) {
        // 获取博客数据
        // 专栏
        List<Columnist> cList = columnistService.getAll();
        model.addAttribute("cList", cList);

        // 默认显示8条博客
        // 参数一：第几页，参数二：每页多少条数据
        PageHelper.startPage(1, 8);
        PageInfo<Blog> pageInfo = blogService.getBlogPaging();
        List<Blog> blogList = pageInfo.getList();
//        List<Blog> blogList = blogService.getBlogPage();

        model.addAttribute("blogList", blogList);
        model.addAttribute("pageInfo", pageInfo);

        return "admin/manage";
    }

    // 删除博客
    // 使用restful的delete请求，默认是关闭的，需要开启
    @DeleteMapping("/delBlog")
    public String del(@RequestParam Map<String, Object> map, Model model) {
        int id = Convert.toInt(map.get("id"));
        // 删除对应博客
        int code = blogService.delBlog(id);

        int pageNum = Convert.toInt(map.get("pageNum"));
        PageHelper.startPage(pageNum, 8);

        PageInfo<Blog> pageInfo = blogService.getBlogByCondition(map);
        model.addAttribute("pageInfo", pageInfo);

        return "admin/manage::table_refresh";
    }

    @GetMapping("/editBlog/{id}")
    public String editBlog(@PathVariable int id, Model model) {
        Blog blog = blogService.getBlog(id);
        if (blog == null) {
//            return ;
        }
        // 专栏
        List<Columnist> cList = columnistService.getAll();
        // 标签
        List<Tag> tList = tagService.getAll();

        model.addAttribute("cList", cList);
        model.addAttribute("tList", tList);

        model.addAttribute("blog", blog);
        return "admin/blog_edit";
    }

    @PostMapping("/updateBlog")
    public String updateBlog(Blog blog) {

        int code = blogService.updateBlog(blog);

        return "redirect:/admin/index";
    }
}
