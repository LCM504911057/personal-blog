package com.personal.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.personal.blog.dao.TagMapper;
import com.personal.blog.entity.Tag;
import com.personal.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> getAll() {
        return tagMapper.findTagAll();
    }

    @Override
    public PageInfo<Tag> getTagByCondition(Map<String, Object> map) {
        List<Tag> list;
        if (map == null) {
             list = tagMapper.findTagAll();
        }else {
            list = tagMapper.findTagByCondition(map);
        }
        return new PageInfo<>(list);
    }

    @Override
    public int addTag(Tag tag) {
        tag.setBlogCount(0);
        tag.setTagState(0);
        tag.setCreateTime(new Date());
        return tagMapper.insertTag(tag);
    }

    @Override
    public int delTag(int id) {
        ArrayList ids = new ArrayList();
        ids.add(id);
        List<Tag> list = tagMapper.findTagByIds(ids);
        if (list == null || list.size() == 0) {
            return 0;
        }
        Tag t = list.get(0);
        t.setTagState(-1);

        return tagMapper.updateTag(t);
    }

    @Override
    public Tag getTag(int id) {
        ArrayList ids = new ArrayList();
        ids.add(id);
        List<Tag> list = tagMapper.findTagByIds(ids);
        if (list == null || list.size() == 0) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }
}
