package com.personal.blog.service;

import com.personal.blog.entity.User;

public interface UserService {

    User login(String name, String password);
}
