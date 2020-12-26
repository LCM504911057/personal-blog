package com.personal.blog.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.personal.blog.dao.UserMapper;
import com.personal.blog.entity.User;
import com.personal.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String name, String password) {

        if (StrUtil.isEmpty(name) || StrUtil.isEmpty(password)) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("password", DigestUtil.md5Hex(password));

        User user = userMapper.findUserByCondition(map);
        return user;
    }
}
