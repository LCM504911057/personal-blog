package com.personal.blog.service;

import com.github.pagehelper.PageInfo;
import com.personal.blog.entity.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {

    int addBlog(Blog blog);

    List<Blog> getBlogNewest();

    PageInfo<Blog> getBlogByCondition(Map<String, Object> map);

    int delBlog(int id);

    Blog getBlog(int id);

    int updateBlog(Blog blog);

}
