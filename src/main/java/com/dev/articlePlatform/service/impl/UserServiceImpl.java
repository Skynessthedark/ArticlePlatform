package com.dev.articlePlatform.service.impl;

import com.dev.articlePlatform.dao.UserDao;
import com.dev.articlePlatform.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDetails findByUsername(String username){
        return userDao.findByUsername(username);
    }
}
