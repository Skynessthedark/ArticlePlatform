package com.dev.articleplatform.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails findByUsername(String username);
}
