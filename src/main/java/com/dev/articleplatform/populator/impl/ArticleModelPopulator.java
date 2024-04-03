package com.dev.articleplatform.populator.impl;

import com.dev.articleplatform.data.ArticleData;
import com.dev.articleplatform.model.ArticleModel;
import com.dev.articleplatform.populator.Populator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArticleModelPopulator implements Populator<ArticleData, ArticleModel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleModelPopulator.class);

    @Override
    public void populate(ArticleData source, ArticleModel target) {
        try {
            target.setTitle(source.getTitle());
            target.setContent(source.getContent());
        }catch (Exception ex){
            LOGGER.error("populateExp: ", ex);
        }
    }
}
