package com.teamA.spring.rest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource); //тут смотрит уже из базы данных инфу
        // храним пароли прям тут(но лучше в базе)
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder
//                        .username("anatoli")
//                         .password("anatoli")
//                        .roles("EMPLOYEE"))
//                .withUser(userBuilder
//                        .username("vitaliy")
//                        .password("vitaliy")
//                        .roles("HR"))
//                .withUser(userBuilder
//                        .username("nikita")
//                        .password("nikita")
//                        .roles("MANAGER", "HR"))
//                .withUser(userBuilder
//                        .username("dmitry")
//                        .password("dmitry")
//                        .roles("EMPLOYEE"))
//                 .withUser(userBuilder
//                    .username("aleksandr")
//                    .password("aleksandr")
//                    .roles("EMPLOYEE"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/employees").hasAnyRole("EMPLOYEE", "HR", "MANAGER") //всем доступна страница

                .and().formLogin().permitAll(); //логин и пароль будет запрашиватья у всех
    }
}
