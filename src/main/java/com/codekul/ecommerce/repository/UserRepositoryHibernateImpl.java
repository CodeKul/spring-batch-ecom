package com.codekul.ecommerce.repository;

import com.codekul.ecommerce.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aniruddha on 27/8/16.
 */
@Deprecated
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserRepositoryHibernateImpl implements UserRepository{

    @Autowired
    private SessionFactory factory;

    @Override
    public void insert(User obj) throws Exception {
        factory.getCurrentSession().save(obj);
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

    @Override
    public User findByUserNameAndPassword(String userName, String password) throws Exception {

        Criteria criteria = factory.getCurrentSession()
                .createCriteria(User.class)
                .add(Restrictions.eq("userName",userName))
                .add(Restrictions.eq("password",password));
        User user = (User) criteria.uniqueResult();
        System.out.println("User - "+user);

        return user;
    }

    @Override
    public Boolean isValid(String userName, String password) throws Exception{
        return findByUserNameAndPassword(userName,password) != null;
    }
}
