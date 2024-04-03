package com.dev.articleplatform.populator.impl;

import com.dev.articleplatform.data.ArticleData;
import com.dev.articleplatform.data.AuthorData;
import com.dev.articleplatform.model.ArticleModel;
import com.dev.articleplatform.populator.Populator;
import com.dev.articleplatform.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class ArticleDataPopulator extends ItemPopulator<ArticleModel, ArticleData> implements Populator<ArticleModel, ArticleData> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDataPopulator.class);

    @Resource
    private AuthorDataPopulator authorDataPopulator;

    @Override
    public void populate(ArticleModel source, ArticleData target) {
        try {
            super.populate(source, target);
            target.setId(String.valueOf(source.getId()));
            target.setTitle(source.getTitle());
            target.setContent(source.getContent());
            target.setCreationDate(DateUtil.date2String(source.getCreationDate()));
            target.setAuthor(getAuthorData(source));
        }catch (Exception ex){
            LOGGER.error("populateExp: ", ex);
        }
    }

    private AuthorData getAuthorData(ArticleModel source){
        AuthorData authorData = new AuthorData();
        authorDataPopulator.populate(source.getAuthor(), authorData);
        return authorData;
    }
}
