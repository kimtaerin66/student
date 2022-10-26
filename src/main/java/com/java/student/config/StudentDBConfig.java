package com.java.student.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan(value = "com.java.student.mappers" , sqlSessionFactoryRef="SqlSessionFactory")
@EnableTransactionManagement
public class StudentDBConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory pomApiSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:config/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mappers/pomApi/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean( name= "SqlSessionTemplate")
    public SqlSessionTemplate pomApiSqlSessionTemplate(@Qualifier("SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws IOException {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
