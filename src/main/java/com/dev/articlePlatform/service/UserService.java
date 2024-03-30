package com.dev.articlePlatform.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails findByUsername(String username);
}
