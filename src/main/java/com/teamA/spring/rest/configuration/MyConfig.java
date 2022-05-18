package com.teamA.spring.rest.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.teamA.spring.rest")
@EnableWebMvc //включение спринг-mvc
@EnableTransactionManagement
public class MyConfig implements WebMvcConfigurer {

    @Bean
    public DataSource dataSource(){  //подключение к базе
        ComboPooledDataSource dataSource = new ComboPooledDataSource(); //этот класс находится в c3p0
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?useSSL=false");
            dataSource.setUser("root"); // пропишем здесь данные того с чьего компьютера запустим
            dataSource.setPassword("admin");//  пропишем здесь данные того с чьего компьютера запустим
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());  //прописываем тут подключение наше
        sessionFactory.setPackagesToScan("com.teamA.spring.rest.entity"); //пакет для сканирования

        Properties hibernateProperties = new Properties(); //создаем объект свойств (свойства для хайбернейт) и сетим нужные свойства
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"); //диалект
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        sessionFactory.setHibernateProperties(hibernateProperties); //присвоить св-ва объекту
        return sessionFactory;

    }
    @Bean
    public  HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject()); //назначаем объекту sessionFactory
        return transactionManager;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
