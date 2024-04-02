package com.dev.articlePlatform.service.impl;

import com.dev.articlePlatform.dao.ArticleDao;
import com.dev.articlePlatform.dao.DefaultDao;
import com.dev.articlePlatform.model.ArticleModel;
import com.dev.articlePlatform.service.ArticleService;
import org.hibernate.Session;

import javax.annotation.Resource;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    @Resource
    private DefaultDao defaultDao;

    @Resource
    private ArticleDao articleDao;

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

    @Override
    public List<ArticleModel> getAll() {
        return articleDao.getAll();
    }
}
