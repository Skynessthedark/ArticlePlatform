package com.dev.articlePlatform.service.impl;

import com.dev.articlePlatform.dao.UserDao;
import com.dev.articlePlatform.model.UserModel;
import com.dev.articlePlatform.service.UserService;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserModel findByUsername(String username){
        return userDao.findByUsername(username);
    }
}
