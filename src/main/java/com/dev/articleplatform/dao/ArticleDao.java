package com.dev.articleplatform.dao;

import com.dev.articleplatform.data.PaginationData;
import com.dev.articleplatform.model.ArticleModel;

import java.util.List;

public interface ArticleDao {
    List<ArticleModel> getAll(PaginationData paginationData);
}
