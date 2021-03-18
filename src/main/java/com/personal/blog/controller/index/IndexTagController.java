package com.personal.blog.controller.index;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personal.blog.entity.Blog;
import com.personal.blog.entity.Tag;
import com.personal.blog.service.BlogService;
import com.personal.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class IndexTagController {

    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;

    @GetMapping("/tagIdPage")
    public String columnistIdPage(Model model, int tagId) {

        PageHelper.startPage(1, 8);
        // 专栏
        PageInfo<Tag> pageInfo = tagService.getTagByCondition(null);

        HashMap<String, Object> map = new HashMap<>();
        map.put("tags", tagId);
        PageInfo<Blog> blogList = blogService.getBlogByCondition(map);

        // 对应第一个专栏ID的博客
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tagId", tagId);
        model.addAttribute("blogList", blogList);
        model.addAttribute("blogNav", 3);

        return "tags";
    }
}
