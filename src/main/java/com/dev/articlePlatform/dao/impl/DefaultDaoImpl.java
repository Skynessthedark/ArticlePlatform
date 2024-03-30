package com.dev.articlePlatform.dao.impl;

import com.dev.articlePlatform.dao.DefaultDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Transactional
@Repository
public class DefaultDaoImpl implements DefaultDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultDaoImpl.class);

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Object findById(Class entityClass, long id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.get(entityClass, id);
            return true;
        } catch (Exception e) {
            LOGGER.error("saveOrUpdateExp: ", e);
            return false;
        }
    }

    @Override
    public Boolean saveOrUpdate(Object model) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(model);
            return true;
        } catch (Exception e) {
            LOGGER.error("saveOrUpdateExp: ", e);
            return false;
        }
    }

    @Override
    public Boolean delete(Object model) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(model);
            return true;
        } catch (Exception e) {
            LOGGER.error("deleteExp: ", e);
            return false;
        }
    }

}
