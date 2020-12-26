package com.personal.blog.service.impl;

import com.personal.blog.dao.BlogMapper;
import com.personal.blog.entity.Blog;
import com.personal.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public int addBlog(Blog blog) {

        blog.setCreateTime(new Date());

        return blogMapper.insertBlog(blog);
    }
}
