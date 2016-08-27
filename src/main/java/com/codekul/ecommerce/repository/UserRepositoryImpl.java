package com.codekul.ecommerce.repository;

import com.codekul.ecommerce.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by aniruddha on 27/8/16.
 */
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public void insert(User obj) throws Exception {

        template.update("", new Object[]{},new Object[]{});
    }

    @Override
    public void update(User obj) throws Exception {
    }

    @Override
    public void delete(User obj) throws Exception {
    }

    @Override
    public User query(User id) throws Exception {
        return null;
    }

    @Override
    public User findOne(Long id) throws Exception {
        return null;
    }
}
