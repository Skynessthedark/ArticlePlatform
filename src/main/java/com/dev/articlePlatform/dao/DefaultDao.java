package com.dev.articlePlatform.dao;

public interface DefaultDao {

    Object findById(Class entityClass, long id);

    Boolean saveOrUpdate(Object model);

    Boolean delete(Object model);
}
