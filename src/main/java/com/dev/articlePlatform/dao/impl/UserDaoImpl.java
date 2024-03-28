package com.dev.articlePlatform.dao.impl;

import com.dev.articlePlatform.dao.UserDao;
import com.dev.articlePlatform.model.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private static final String FROM = "FROM UserModel";
    private static final String FIND_BY_USERNAME = " WHERE username=:username";

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public UserModel findByUsername(String username) {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery(FROM + FIND_BY_USERNAME, UserModel.class)
                    .setParameter("username",username)
                    .getResultList().get(0);
        }catch (Exception e){
            LOGGER.error("getUserByUsernameExp: ", e);
            return null;
        }
    }
}
