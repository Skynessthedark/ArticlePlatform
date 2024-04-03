package com.dev.articleplatform.service;

import com.dev.articleplatform.data.PaginationData;
import com.dev.articleplatform.model.ArticleModel;

import java.util.List;

public interface ArticleService {

    ArticleModel getById(long id);

    boolean saveOrUpdate(ArticleModel articleModel);

    boolean delete(ArticleModel articleModel);

    List<ArticleModel> getAll(PaginationData paginationData);
}
