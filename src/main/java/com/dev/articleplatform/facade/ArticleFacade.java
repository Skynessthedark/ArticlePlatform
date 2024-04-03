package com.dev.articleplatform.facade;

import com.dev.articleplatform.data.ArticleData;
import com.dev.articleplatform.data.PaginationData;
import com.dev.articleplatform.data.response.ArticleListResponse;
import com.dev.articleplatform.data.response.ArticleResponse;
import com.dev.articleplatform.data.ResultData;

public interface ArticleFacade {
    ResultData save(ArticleData articleData, String username);

    ArticleResponse get(String articleId);

    ArticleListResponse getAllArticles(PaginationData paginationData);

    ResultData delete(String articleId);
}
