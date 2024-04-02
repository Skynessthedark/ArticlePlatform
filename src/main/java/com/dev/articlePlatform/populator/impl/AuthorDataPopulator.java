package com.dev.articlePlatform.populator.impl;

import com.dev.articlePlatform.data.ArticleData;
import com.dev.articlePlatform.data.AuthorData;
import com.dev.articlePlatform.model.ArticleModel;
import com.dev.articlePlatform.model.UserModel;
import com.dev.articlePlatform.populator.Populator;
import com.dev.articlePlatform.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorDataPopulator extends ItemPopulator<UserModel, AuthorData> implements Populator<UserModel, AuthorData>{

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorDataPopulator.class);

    @Override
    public void populate(UserModel source, AuthorData target) {
        try {
            super.populate(source, target);
            target.setId(String.valueOf(source.getId()));
            target.setName(source.getName());
            target.setSurname(source.getSurname());
        }catch (Exception ex){
            LOGGER.error("populateExp: ", ex);
        }
    }
}
