package com.personal.blog.service;

import com.github.pagehelper.PageInfo;
import com.personal.blog.entity.Blog;

import java.util.Map;

public interface BlogService {

    int addBlog(Blog blog);

    PageInfo<Blog> getBlogPaging();

    PageInfo<Blog> getBlogByCondition(Map<String, Object> map);

    int delBlog(int id);

    Blog getBlog(int id);

    int updateBlog(Blog blog);

}
