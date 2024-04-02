package com.dev.articlePlatform.controller;

import com.dev.articlePlatform.data.ArticleData;
import com.dev.articlePlatform.data.ArticleResponse;
import com.dev.articlePlatform.data.ResultData;
import com.dev.articlePlatform.facade.ArticleFacade;
import com.dev.articlePlatform.model.UserModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Resource
    private ArticleFacade articleFacade;

    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultData saveArticle(@RequestBody ArticleData articleData) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return articleFacade.save(articleData, getPrincipal());
    }

    @RequestMapping(value = "/get/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArticleResponse saveArticle(@PathVariable(value = "id") String articleId) {
        return articleFacade.get(articleId);
    }

    private String getPrincipal(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (String) authentication.getPrincipal();
    }
}
