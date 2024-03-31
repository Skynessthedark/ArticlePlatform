package com.dev.articlePlatform.service.impl;

import com.dev.articlePlatform.dao.DefaultDao;
import com.dev.articlePlatform.model.ArticleModel;
import com.dev.articlePlatform.service.ArticleService;

import javax.annotation.Resource;

public class ArticleServiceImpl implements ArticleService {

    @Resource
    private DefaultDao defaultDao;

    @Override
    public ArticleModel getById(long id) {
        return (ArticleModel) defaultDao.findById(ArticleModel.class, id);
    }

    @Override
    public boolean saveOrUpdate(ArticleModel articleModel) {
        return defaultDao.saveOrUpdate(articleModel);
    }

    @Override
    public boolean delete(ArticleModel articleModel) {
        return defaultDao.delete(articleModel);
    }
}
