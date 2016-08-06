package com.codekul.ecommerce.config;

import com.codekul.ecommerce.tool.FileTool;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by aniruddha on 31/7/16.
 */
@Configuration
public class AppConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**");

            }
        };
    }

    /*@Bean
    public ServletRegistrationBean servletRegistrationBean(){

        DispatcherServlet s = new DispatcherServlet();

        ServletRegistrationBean bean =
                new ServletRegistrationBean();
        bean.setServlet(s);
        bean.
        return bean;
    }*/

    @Bean
    @Scope("singleton")
    public FileTool fileTool(){
        return new FileTool();
    }

    @Bean(name = "myTool")
    public FileTool myTool(){
        return new FileTool();
    }
}
