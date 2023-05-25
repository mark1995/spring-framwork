package com.test.transaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
//2、开启注解支撑
@EnableTransactionManagement
@ComponentScan("com.test.transaction")
//@ImportResource("classpath:appTransaction4XmlAndAnno.xml")
public class App {

	@Bean
	public JdbcTemplate jdbcTemplate(){
		return  new JdbcTemplate(dataSource());
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setPassword("123456");
		dataSource.setUrl("jdbc:mysql://localhost:3306/shadow?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
		dataSource.setUsername("root");
		return dataSource;
	}

	/**
	 * 1、声明命事务管理器
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager(){
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}

//	@Bean
//	public TransactionTemplate transactionTemplate(){
//		TransactionTemplate transactionTemplate = new TransactionTemplate();
//		transactionTemplate.setTransactionManager(transactionManager());
//		return transactionTemplate;
//	}


}
