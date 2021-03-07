package com.app.BlopApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jca.support.LocalConnectionFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class JpaConfigurations {

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();

    }

    /*@Bean
    public DataSource dataSource(){
    //If we dont want to cnfigurations in application.properties then we can give the configurations here also.
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setPassword("$29052000");
        dataSource.setUsername("postgres");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/technicalblog");
        return dataSource;
    }*/
}
