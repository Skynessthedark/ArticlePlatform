package com.dev.articleplatform.dao;

import com.dev.articleplatform.model.UserModel;

public interface UserDao {
    UserModel findByUsername(String username);
}
