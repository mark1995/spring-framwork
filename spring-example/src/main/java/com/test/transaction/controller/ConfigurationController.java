package com.test.transaction.controller;

import com.test.transaction.service.ConfigurationService1;
import com.test.transaction.service.ConfigurationService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

//@Component
public class ConfigurationController {

	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	ConfigurationService1 service1;
	@Autowired
	ConfigurationService2 service2;

	public void update(){
		System.out.println("xxxx");
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setName("子路很帅");
		//conn1
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		try {
			//conn2
			service1.update();
			service2.update();
			int i = 1 / 0;
			transactionManager.commit(transaction);
		}catch (Exception e){
			e.printStackTrace();
			//conn1
			transactionManager.rollback(transaction);
		}


	}
}
