package com.personal.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.personal.blog.dao.ColumnistMapper;
import com.personal.blog.entity.Columnist;
import com.personal.blog.service.ColumnistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ColumnistServiceImpl implements ColumnistService {

    @Autowired
    ColumnistMapper columnistMapper;

    @Override
    public List<Columnist> getAll() {
        return columnistMapper.findColumnistAll();
    }

    @Override
    public List<Columnist> getColumnistByTop() {
        return columnistMapper.findColumnistByTop();
    }

    @Override
    public Columnist getColumnist(int id) {
        ArrayList ids = new ArrayList();
        ids.add(id);
        List<Columnist> list = columnistMapper.findColumnistByIds(ids);
        if (list == null || list.size() == 0) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public int delColumnist(int id) {
        ArrayList ids = new ArrayList();
        ids.add(id);
        List<Columnist> list = columnistMapper.findColumnistByIds(ids);
        if (list == null || list.size() == 0) {
            return 0;
        }
        Columnist columnist = list.get(0);
        columnist.setColumnistState(-1);
        columnist.setUpdateTime(new Date());

        return columnistMapper.updateColumnist(columnist);
    }

    @Override
    public PageInfo<Columnist> getColumnistByCondition(Map<String, Object> map) {
        List<Columnist> list;
        if (map == null) {
            // 调用查询之前，必须设置
            // PageHelper.startPage(1, 2);
            // 哪一页，每页多少数据，就可以自动完成sql分页功能
            // 原理是基于mybatis拦截器在最终statement，最终sql语句上拼接limit
            list = columnistMapper.findColumnistAll();
        }else {
            list = columnistMapper.findColumnistByCondition(map);
        }
        return new PageInfo<>(list);
    }

    @Override
    public int updateColumnist(Columnist columnist) {
        return columnistMapper.updateColumnist(columnist);
    }

    @Override
    public int addColumnist(Columnist columnist) {
        columnist.setBlogCount(0);
        columnist.setUpdateTime(new Date());
        columnist.setCreateTime(new Date());
        return columnistMapper.insertColumnist(columnist);
    }
}
