package com.personal.blog.service;

import com.github.pagehelper.PageInfo;
import com.personal.blog.entity.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {

    List<Comment> getAll();

    PageInfo<Comment> getCommentByCondition(Map<String, Object> map);

    int addComment(Comment comment);

    int delComment(int id);

    Comment getComment(int id);

    int updateComment(Comment comment);

}
