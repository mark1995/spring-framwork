package com.test.batis;


import com.test.batis.dao.SMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@ComponentScan("com.test.batis")
@MapperScan("com.test.batis.dao")
//@ImportResource("classpath:spring-batis.xml")
@MyScan
public class BatisConfig {


	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setPassword("gxk19950115");
		dataSource.setUsername("mark");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_apiserver?useSSL=false");
		return dataSource;
	}


	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		return factoryBean.getObject();
	}


	@Bean
	public SMapper getMapper() {
		return (SMapper) MySqlSession.getMapper(SMapper.class);
	}
}
