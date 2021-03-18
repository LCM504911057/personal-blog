package com.personal.blog.service;

import com.github.pagehelper.PageInfo;
import com.personal.blog.entity.Tag;

import java.util.List;
import java.util.Map;

public interface TagService {

    List<Tag> getAll();

    PageInfo<Tag> getTagByCondition(Map<String, Object> map);

    int addTag(Tag tag);

    int delTag(int id);

    Tag getTag(int id);

    int updateTag(Tag tag);

}
