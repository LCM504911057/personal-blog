package com.personal.blog.controller.admin;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personal.blog.entity.Comment;
import com.personal.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class CommentController {

    @Autowired
    CommentService commentService;

    // 标签的条件查询
    @GetMapping("/findConditionByComment")
    public String findConditionByTag(@RequestParam Map<String, Object> map, Model model) {

        int pageNum = Convert.toInt(map.get("pageNum"));
        PageHelper.startPage(pageNum, 8);

        PageInfo<Comment> pageInfo = commentService.getCommentByCondition(map);

        model.addAttribute("pageInfo", pageInfo);

        // "admin/manage::table_refresh"
        // 返回指定片段
        return "admin/tags::table_refresh";
    }



    @GetMapping("/commentAddPage")
    public String tagAddPage() {

        return "admin/tag_add";
    }

    @PostMapping("/commentAdd")
    public String tagAdd(Comment comment) {

        int code = commentService.addComment(comment);

        if (code < 1) {
            // 添加博客失败
        }

//        System.out.println(code);
        return "redirect:/admin/tagPage";
    }

//    @DeleteMapping("/delComment")
//    public String delTag(@RequestParam Map<String, Object> map, Model model) {
//        int id = Convert.toInt(map.get("id"));
//        // 删除对应专栏
//        int code = tagService.delTag(id);
//
//        int pageNum = Convert.toInt(map.get("pageNum"));
//        PageHelper.startPage(pageNum, 8);
//
//        PageInfo<Tag> pageInfo = tagService.getTagByCondition(map);
//        model.addAttribute("pageInfo", pageInfo);
//
//        return "admin/tags::table_refresh";
//    }
//
//    @GetMapping("/editComment/{id}")
//    public String editTag(@PathVariable int id, Model model) {
//        Tag tag = tagService.getTag(id);
//        if (tag == null) {
////            return ;
//        }
//
//        model.addAttribute("tag", tag);
//        return "admin/tag_edit";
//    }
//
//    @PostMapping("/updateTag")
//    public String updateTag(Tag tag) {
//
//        int code = tagService.updateTag(tag);
//
//        return "redirect:/admin/tagPage";
//    }
}
