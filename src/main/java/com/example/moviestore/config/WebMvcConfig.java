package com.example.moviestore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.moviestore")
@PropertySource(value = { "classpath:application.properties"})
public class WebMvcConfig implements WebMvcConfigurer {

//    @Autowired
//    private Environment environment;

    @Bean
    public JdbcTemplate getJdbcTemplate() throws ClassNotFoundException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/moviestore");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234asdf");
        return new JdbcTemplate(dataSource);
    }
}
