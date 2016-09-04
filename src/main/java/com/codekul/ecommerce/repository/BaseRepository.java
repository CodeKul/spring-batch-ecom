package com.codekul.ecommerce.repository;

/**
 * Created by aniruddha on 27/8/16.
 */
@Deprecated
public interface BaseRepository<T>{

    void insert(T obj) throws Exception;

    void update(T obj) throws Exception;

    void delete(T obj) throws Exception;

    T query(T id) throws Exception;
}
