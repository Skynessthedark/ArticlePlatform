package com.dev.articlePlatform.dao;

import com.dev.articlePlatform.model.UserModel;

public interface UserDao {
    UserModel findByUsername(String username);
}
