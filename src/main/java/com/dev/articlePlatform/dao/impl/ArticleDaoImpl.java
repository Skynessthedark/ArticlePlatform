package com.dev.articlePlatform.dao.impl;

import com.dev.articlePlatform.dao.ArticleDao;
import com.dev.articlePlatform.dao.UserDao;
import com.dev.articlePlatform.model.ArticleModel;
import com.dev.articlePlatform.model.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class ArticleDaoImpl implements ArticleDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDaoImpl.class);
    private static final String FROM = "FROM ArticleModel as art";

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<ArticleModel> getAll() {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery(FROM, ArticleModel.class).getResultList();
        } catch (Exception e) {
            LOGGER.error("getAllExp: ", e);
            return Collections.emptyList();
        }
    }
}
