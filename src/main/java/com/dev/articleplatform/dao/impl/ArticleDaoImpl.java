package com.dev.articleplatform.dao.impl;

import com.dev.articleplatform.dao.ArticleDao;
import com.dev.articleplatform.data.PaginationData;
import com.dev.articleplatform.model.ArticleModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class ArticleDaoImpl implements ArticleDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDaoImpl.class);
    private static final String FROM = "FROM ArticleModel as art ";
    private static final String TOTAL_COUNT_CLAUSE = "SELECT count (art.id) ";
    private static final String ORDER_BY_ID = "ORDER BY art.id ";
    private static final String DESC = "desc ";

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<ArticleModel> getAll(PaginationData paginationData) {
        try {
            Session session = sessionFactory.getCurrentSession();
            StringBuilder sb = new StringBuilder(FROM);
            sb.append(ORDER_BY_ID);
            if(DESC.trim().equalsIgnoreCase(paginationData.getSort())){
                sb.append(DESC);
            }
            Query<ArticleModel> query = session.createQuery(sb.toString(), ArticleModel.class);
            paginateQuery(query, paginationData, session);
            return query.list();
        } catch (Exception e) {
            LOGGER.error("getAllExp: ", e);
            return Collections.emptyList();
        }
    }

    private void paginateQuery(Query<ArticleModel> query, PaginationData paginationData, Session session) {
        int size = paginationData.getSize();
        int page = paginationData.getPage();
        query.setMaxResults(size);
        Query<Long> countQuery = session.createQuery(TOTAL_COUNT_CLAUSE + FROM, Long.class);
        Long countResults = countQuery.uniqueResult();
        int lastPage = (int) (Math.ceil((double) countResults / size));
        int lastPageNumber = Math.min(lastPage, page);
        query.setFirstResult(lastPageNumber > 0 ?(lastPageNumber - 1) * size: 0);
    }
}
