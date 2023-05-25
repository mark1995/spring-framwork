package com.test.transaction.controller;

import com.test.transaction.service.ConfigurationService1;
import com.test.transaction.service.ConfigurationService2;
import com.test.transaction.service.PropagationUserService1;
import com.test.transaction.service.PropagationUserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

//@Component
public class PropagationController {



	@Autowired
	PropagationUserService1 service1;
	@Autowired
	PropagationUserService2 service2;

	public void update(){
		try {
			//conn2
			//create transaction1
			service1.update();
			//create transaction2
			service2.update();
		}catch (Exception e){

		}


	}
}
