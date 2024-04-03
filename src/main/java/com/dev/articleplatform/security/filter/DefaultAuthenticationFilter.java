package com.dev.articleplatform.security.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DefaultAuthenticationFilter extends OncePerRequestFilter {
    private static final String BASIC = "basic";
    private static final String AUTHORIZATION = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = attemptAuthentication(httpServletRequest);
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private Authentication attemptAuthentication(HttpServletRequest httpServletRequest) throws AuthenticationException {
        String authHeader = httpServletRequest.getHeader(AUTHORIZATION);
        if(StringUtils.isEmpty(authHeader) || !authHeader.toLowerCase().startsWith(BASIC)){
            return null;
        }
        byte[] decodedHeader = Base64.getDecoder()
                .decode(authHeader.substring(BASIC.length()).trim());
        String credentials = new String(decodedHeader, StandardCharsets.UTF_8);
        String[] parts = credentials.split(":", 2);
        String username = parts[0];
        String password = parts[1];
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) ){
            throw new DefaultAuthenticationException("Username and Password cannot be empty.");
        }
        return new UsernamePasswordAuthenticationToken(username, password);
    }

    public static class DefaultAuthenticationException extends AuthenticationException{
        public DefaultAuthenticationException(String msg) {
            super(msg);
        }
    }
}
