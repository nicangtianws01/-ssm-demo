package com.ws.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

@PropertySource("classpath:db.properties")
@MapperScan("com.ws.dao")
@Configuration
public class SpringRepoConfig {
	@Value("${db.jdbcUrl}")
	private String jdbcUrl;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;

	@Bean("dataSource")
	public DataSource newDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	@Bean("sqlSessionFactory")
	public SqlSessionFactoryBean newSqlSessionFactory(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
		factoryBean.setMapperLocations(mapperLocations);
		return factoryBean;
	}
}
