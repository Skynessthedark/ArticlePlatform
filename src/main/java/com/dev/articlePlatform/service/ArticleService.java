package com.dev.articlePlatform.service;

import com.dev.articlePlatform.model.ArticleModel;

public interface ArticleService {

    ArticleModel getById(long id);

    boolean saveOrUpdate(ArticleModel articleModel);

    boolean delete(ArticleModel articleModel);
}
