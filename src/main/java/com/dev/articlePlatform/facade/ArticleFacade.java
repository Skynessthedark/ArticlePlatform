package com.dev.articlePlatform.facade;

import com.dev.articlePlatform.data.ArticleData;
import com.dev.articlePlatform.data.response.ArticleListResponse;
import com.dev.articlePlatform.data.response.ArticleResponse;
import com.dev.articlePlatform.data.ResultData;

public interface ArticleFacade {
    ResultData save(ArticleData articleData, String username);

    ArticleResponse get(String articleId);

    ArticleListResponse getAllArticles();
}
