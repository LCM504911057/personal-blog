package com.personal.blog.service;

import com.github.pagehelper.PageInfo;
import com.personal.blog.entity.Columnist;

import java.util.List;
import java.util.Map;

public interface ColumnistService {

    List<Columnist> getAll();

    List<Columnist> getColumnistByTop();

    Columnist getColumnist(int id);

    int delColumnist(int id);

    PageInfo<Columnist> getColumnistByCondition(Map<String, Object> map);

    int updateColumnist(Columnist columnist);

    int addColumnist(Columnist columnist);


}
