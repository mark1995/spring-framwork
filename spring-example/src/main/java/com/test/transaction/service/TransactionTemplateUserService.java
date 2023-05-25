package com.test.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionTemplateUserService {



	@Autowired
	TransactionTemplate transactionTemplate;


	@Autowired
	JdbcTemplate jdbcTemplate;

	//@Transactional
	public void update(){

		Object execute = transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					jdbcTemplate.update("update t set v=? where k=?", "n", "k1");
					int i = 1/0;
					jdbcTemplate.update("update t set v=? where k=?", "n", "k2");
				}catch (Exception e){
					e.printStackTrace();
					status.setRollbackOnly();
				}
			}
		});

	}
}
