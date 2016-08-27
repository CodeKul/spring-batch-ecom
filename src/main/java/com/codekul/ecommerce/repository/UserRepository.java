package com.codekul.ecommerce.repository;

import com.codekul.ecommerce.domain.User;

/**
 * Created by aniruddha on 27/8/16.
 */
public interface UserRepository extends BaseRepository<User> {

    User findOne(Long id) throws Exception;
}
