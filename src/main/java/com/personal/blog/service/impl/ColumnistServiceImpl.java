package com.personal.blog.service.impl;

import com.personal.blog.dao.ColumnistMapper;
import com.personal.blog.entity.Columnist;
import com.personal.blog.service.ColumnistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnistServiceImpl implements ColumnistService {

    @Autowired
    ColumnistMapper columnistMapper;

    @Override
    public List<Columnist> getAll() {
        return columnistMapper.findColumnistAll();
    }
}
