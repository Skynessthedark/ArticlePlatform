package com.dev.articlePlatform.dao;

import com.dev.articlePlatform.model.ArticleModel;
import com.dev.articlePlatform.model.UserModel;

import java.util.List;

public interface ArticleDao {
    List<ArticleModel> getAll();
}
