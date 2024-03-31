package com.dev.articlePlatform.facade;

import com.dev.articlePlatform.data.ArticleData;
import com.dev.articlePlatform.data.ResultData;

public interface ArticleFacade {
    ResultData save(ArticleData articleData, String username);
}
