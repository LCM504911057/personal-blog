package com.personal.blog.dao;

import com.personal.blog.entity.Columnist;

import java.util.List;
import java.util.Map;

public interface ColumnistMapper {

    List<Columnist> findColumnistAll();

    Columnist findColumnistByCondition(Map<String, Object> map);

    int insertColumnist(Columnist columnist);

    int updateColumnist(Columnist columnist);
}
