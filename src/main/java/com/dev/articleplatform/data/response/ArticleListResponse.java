package com.dev.articleplatform.data.response;

import com.dev.articleplatform.data.ArticleData;
import com.dev.articleplatform.data.ResultData;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleListResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<ArticleData> articles;
    private ResultData result;

    public List<ArticleData> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleData> articles) {
        this.articles = articles;
    }

    public ResultData getResult() {
        return result;
    }

    public void setResult(ResultData result) {
        this.result = result;
    }
}
