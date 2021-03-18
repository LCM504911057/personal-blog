package com.personal.blog.controller.admin;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personal.blog.entity.Columnist;
import com.personal.blog.service.ColumnistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ColumnistController {

    @Autowired
    ColumnistService columnistService;

    // 删除专栏
    // 使用restful的delete请求，默认是关闭的，需要开启
    @DeleteMapping("/delColumnist")
    public String delColumnist(@RequestParam Map<String, Object> map, Model model) {
        int id = Convert.toInt(map.get("id"));
        // 删除对应专栏
        int code = columnistService.delColumnist(id);

        int pageNum = Convert.toInt(map.get("pageNum"));
        PageHelper.startPage(pageNum, 8);

        PageInfo<Columnist> pageInfo = columnistService.getColumnistByCondition(map);
        model.addAttribute("pageInfo", pageInfo);

        return "admin/columnist::table_refresh";
    }

    @GetMapping("/columnistAddPage")
    public String columnistAddPage(Model model) {

        return "admin/columnist_add";
    }

    @PostMapping("/columnistAdd")
    public String columnistAdd(Columnist columnist) {

        int code = columnistService.addColumnist(columnist);

        if (code < 1) {
            // 添加博客失败
        }

//        System.out.println(code);
        return "redirect:/admin/columnistPage";
    }

    // 分类的条件查询
    @GetMapping("/findConditionByColumnist")
    public String findConditionByColumnist(@RequestParam Map<String, Object> map, Model model) {

        int pageNum = Convert.toInt(map.get("pageNum"));
        PageHelper.startPage(pageNum, 8);

        PageInfo<Columnist> pageInfo = columnistService.getColumnistByCondition(map);

        model.addAttribute("pageInfo", pageInfo);

        // "admin/manage::table_refresh"
        // 返回指定片段
        return "admin/columnist::table_refresh";
    }



    @GetMapping("/editColumnist/{id}")
    public String editColumnist(@PathVariable int id, Model model) {
        Columnist col = columnistService.getColumnist(id);
        if (col == null) {
//            return ;
        }

        model.addAttribute("col", col);
        return "admin/columnist_edit";
    }

    @PostMapping("/updateColumnist")
    public String updateColumnist(Columnist columnist) {

        int code = columnistService.updateColumnist(columnist);

        return "redirect:/admin/columnistPage";
    }
}
