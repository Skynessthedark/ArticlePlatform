package com.dev.articlePlatform.service;

import com.dev.articlePlatform.model.ArticleModel;

import java.util.List;

public interface ArticleService {

    ArticleModel getById(long id);

    boolean saveOrUpdate(ArticleModel articleModel);

    boolean delete(ArticleModel articleModel);

    List<ArticleModel> getAll();
}
