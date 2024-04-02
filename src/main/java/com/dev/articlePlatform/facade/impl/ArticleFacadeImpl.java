package com.dev.articlePlatform.facade.impl;

import com.dev.articlePlatform.data.ArticleData;
import com.dev.articlePlatform.data.ArticleResponse;
import com.dev.articlePlatform.data.ResultData;
import com.dev.articlePlatform.facade.ArticleFacade;
import com.dev.articlePlatform.model.ArticleModel;
import com.dev.articlePlatform.model.UserModel;
import com.dev.articlePlatform.populator.impl.ArticleDataPopulator;
import com.dev.articlePlatform.populator.impl.ArticleModelPopulator;
import com.dev.articlePlatform.service.ArticleService;
import com.dev.articlePlatform.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

public class ArticleFacadeImpl implements ArticleFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleFacadeImpl.class);

    @Value("${status.success}")
    private String successStatus;

    @Value("${status.error}")
    private String errorStatus;

    @Value("${message.error}")
    private String errorMessage;

    @Value("${message.success}")
    private String successMessage;

    @Value("${article.create.message.success}")
    private String createSuccessMessage;

    @Value("${user.not.found}")
    private String userNotFoundMessage;

    @Value("${article.not.found}")
    private String articleNotFoundMessage;

    @Value("${username.not.found}")
    private String usernameNotFoundMessage;

    @Resource
    private ArticleService articleService;

    @Resource
    private UserService userService;

    @Resource
    private ArticleModelPopulator articleModelPopulator;

    @Resource
    private ArticleDataPopulator articleDataPopulator;

    @Override
    public ResultData save(ArticleData articleData, String username) {
        try {
            UserModel userModel = getUser(username);
            ArticleModel articleModel = createOrGetArticle(articleData.getId());
            articleModelPopulator.populate(articleData, articleModel);
            articleModel.setAuthor(userModel);
            articleService.saveOrUpdate(articleModel);
            return generateResult(successStatus, createSuccessMessage);
        }catch (Exception ex){
            LOGGER.error("saveExp: ", ex);
            return generateResult(errorStatus, ex.getMessage());
        }
    }

    @Override
    public ArticleResponse get(String articleId) {
        ArticleResponse response = new ArticleResponse();
        try {
            ArticleModel articleModel;
            try {
                articleModel = createOrGetArticle(articleId);
            }catch (EntityNotFoundException enfEx){
                response.setResult(generateResult(errorStatus, articleNotFoundMessage));
                return response;
            }
            ArticleData articleData = new ArticleData();
            articleDataPopulator.populate(articleModel, articleData);
            response.setArticle(articleData);
            response.setResult(generateResult(successStatus, successMessage));
            return response;
        }catch (Exception ex){
            LOGGER.error("getExp: ", ex);
            response.setResult(generateResult(errorStatus, ex.getMessage()));
            return response;
        }
    }

    private ResultData generateResult(String status, String message){
        return new ResultData(status, message);
    }

    private ArticleModel createOrGetArticle(String id){
        if(StringUtils.hasText(id)){
            ArticleModel articleModel = articleService.getById(Long.parseLong(id));
            if(articleModel == null){
                throw new EntityNotFoundException(articleNotFoundMessage);
            }
            return articleModel;
        }
        return new ArticleModel();
    }

    private UserModel getUser(String username){
        if(StringUtils.isEmpty(username)){
            throw new UsernameNotFoundException(usernameNotFoundMessage);
        }
        UserModel userModel = (UserModel) userService.findByUsername(username);
        if(userModel == null){
            throw new UsernameNotFoundException(userNotFoundMessage);
        }
        return userModel;
    }
}
