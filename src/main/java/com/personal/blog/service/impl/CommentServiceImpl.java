package com.personal.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.personal.blog.dao.CommentMapper;
import com.personal.blog.entity.Comment;
import com.personal.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getAll() {
        return commentMapper.findCommentAll();
    }

    @Override
    public int addComment(Comment comment) {
        comment.setCreateTime(new Date());
        return commentMapper.insertComment(comment);
    }

    @Override
    public PageInfo<Comment> getCommentByCondition(Map<String, Object> map) {
        List<Comment> list;
        if (map == null) {
            list = commentMapper.findCommentAll();
        }else {
            list = commentMapper.findCommentByCondition(map);
        }
        return new PageInfo<>(list);
    }

    @Override
    public int delComment(int id) {
        ArrayList ids = new ArrayList();
        ids.add(id);
        List<Comment> list = commentMapper.findCommentByIds(ids);
        if (list == null || list.size() == 0) {
            return 0;
        }
        Comment c = list.get(0);
        c.setReplyState(-1);

        return commentMapper.updateComment(c);
    }

    @Override
    public Comment getComment(int id) {
        ArrayList ids = new ArrayList();
        ids.add(id);

        List<Comment> list = commentMapper.findCommentByIds(ids);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentMapper.updateComment(comment);
    }
}
