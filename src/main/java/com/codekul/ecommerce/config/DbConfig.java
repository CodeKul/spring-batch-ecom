package com.codekul.ecommerce.config;

import com.codekul.ecommerce.tool.FileTool;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.SessionFactoryUtils;

import java.util.Properties;

/**
 * Created by aniruddha on 27/8/16.
 */
@Configuration
@Deprecated
public class DbConfig {

    @Bean
    public SessionFactory sessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(getDataSource());

        sessionFactory.setHibernateProperties(getHibernateProperties());
        sessionFactory
                .setPackagesToScan(new String[]{"com.codekul.ecommerce.domain"});

        try {
            sessionFactory.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory.getObject();
    }

    private Properties getHibernateProperties() {

        Properties propreties = new Properties();
        propreties.setProperty("hibernate.show_sql", "true");
        propreties.setProperty("hibernate.format_sql", "true");
        propreties.setProperty("hibernate.hbm2ddl.auto", "update");

        propreties.setProperty("hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect");

        return propreties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {

        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sessionFactory());
        return manager;
    }

    @Bean
    public DriverManagerDataSource getDataSource() {
        return localDataSource();
    }

    private DriverManagerDataSource localDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springdb");
        dataSource.setUsername("root");
        dataSource.setPassword("iamandroid");

        return dataSource;
    }
}
