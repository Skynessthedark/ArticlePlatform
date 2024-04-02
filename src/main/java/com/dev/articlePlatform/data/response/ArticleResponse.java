package com.dev.articlePlatform.data.response;

import com.dev.articlePlatform.data.ArticleData;
import com.dev.articlePlatform.data.ResultData;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArticleData article;
    private ResultData result;

    public ArticleResponse(ArticleData article, ResultData result) {
        this.article = article;
        this.result = result;
    }

    public ArticleResponse(ResultData result) {
        this.result = result;
    }

    public ArticleResponse() {
    }

    public ArticleData getArticle() {
        return article;
    }

    public void setArticle(ArticleData article) {
        this.article = article;
    }

    public ResultData getResult() {
        return result;
    }

    public void setResult(ResultData result) {
        this.result = result;
    }
}
