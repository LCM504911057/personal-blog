package com.personal.blog.service.impl;

import com.personal.blog.dao.TagMapper;
import com.personal.blog.entity.Tag;
import com.personal.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> getAll() {
        return tagMapper.findTagAll();
    }
}
