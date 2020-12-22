package com.personal.blog.dao;

import com.personal.blog.entity.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    int insertBlog(Blog blog);

    List<Blog> findBlogByCondition(Map<String, Object> map);

    int updateBlog(Blog blog);

    List<Blog> findBlogAll();
}
