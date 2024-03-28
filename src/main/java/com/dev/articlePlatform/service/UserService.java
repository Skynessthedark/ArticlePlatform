package com.dev.articlePlatform.service;

import com.dev.articlePlatform.model.UserModel;

public interface UserService {

    UserModel findByUsername(String username);
}
