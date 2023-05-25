package com.test.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class PlatformTransactionManagerUserService {

	/**
	 * 这个对象 需要我们去配置 默认不存在spring容器当中
	 * 1、注解
	 * 2、xml
	 * （PlatformTransactionManager 对象放到容器当中）
	 *
	 * 这个对象的注入方式 1或者2 没有区别
	 * 但是实现spring的事务方式注解和xml以及他们混合开发是由区别的
	 */
	@Autowired
	PlatformTransactionManager transactionManager;


	@Autowired
	JdbcTemplate jdbcTemplate;

	//@Transactional
	public void update(){
		/**
		 * 定义
		 * 1、名字
		 * 2、隔离级别
		 * 3、传播行为
		 * 4、是否只读
		 * 5、超时
		 */
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setName("子路很帅");


		TransactionStatus transaction = transactionManager.getTransaction(definition);

		try {
			jdbcTemplate.update("update t set v='n' where k='k1'");
			int i = 1/0;
			jdbcTemplate.update("update t set v='n' where k='k2'");
			transactionManager.commit(transaction);

		}catch (Exception e){
			e.printStackTrace();
			transactionManager.rollback(transaction);
		}
	}
}
