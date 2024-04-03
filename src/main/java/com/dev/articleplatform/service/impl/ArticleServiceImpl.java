package com.dev.articleplatform.service.impl;

import com.dev.articleplatform.dao.ArticleDao;
import com.dev.articleplatform.dao.DefaultDao;
import com.dev.articleplatform.data.PaginationData;
import com.dev.articleplatform.model.ArticleModel;
import com.dev.articleplatform.service.ArticleService;

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
    public List<ArticleModel> getAll(PaginationData paginationData) {
        return articleDao.getAll(paginationData);
    }
}
