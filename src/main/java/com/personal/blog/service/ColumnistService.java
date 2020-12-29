package com.personal.blog.service;

import com.github.pagehelper.PageInfo;
import com.personal.blog.entity.Columnist;

import java.util.List;
import java.util.Map;

public interface ColumnistService {

    List<Columnist> getAll();

    Columnist getColumnist(int id);

    int delColumnist(int id);

    PageInfo<Columnist> getColumnistPaging();

    PageInfo<Columnist> getColumnistByCondition(Map<String, Object> map);

    int updateColumnist(Columnist columnist);

    int addColumnist(Columnist columnist);
}
