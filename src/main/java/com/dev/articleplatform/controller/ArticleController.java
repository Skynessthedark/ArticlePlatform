package com.dev.articleplatform.controller;

import com.dev.articleplatform.data.ArticleData;
import com.dev.articleplatform.data.PaginationData;
import com.dev.articleplatform.data.response.ArticleListResponse;
import com.dev.articleplatform.data.response.ArticleResponse;
import com.dev.articleplatform.data.ResultData;
import com.dev.articleplatform.facade.ArticleFacade;
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
    public ResultData saveArticle(@RequestBody ArticleData articleData) {
        return articleFacade.save(articleData, getPrincipal());
    }

    @RequestMapping(value = "/get/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleResponse getArticle(@PathVariable(value = "id") String articleId) {
        return articleFacade.get(articleId);
    }

    @RequestMapping(value = "/get",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleListResponse getAllArticles(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false) String sort) {
        return articleFacade.getAllArticles(new PaginationData(page, size, sort));
    }

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData deleteArticle(@PathVariable(value = "id") String articleId) {
        return articleFacade.delete(articleId);
    }

    private String getPrincipal(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (String) authentication.getPrincipal();
    }
}
