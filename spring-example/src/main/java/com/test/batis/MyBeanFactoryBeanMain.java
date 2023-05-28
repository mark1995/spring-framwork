package com.test.batis;

import com.test.batis.service.SService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@MyScan
public class MyBeanFactoryBeanMain {


	public static void main(String[] args) {


		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BatisConfig.class);
		SService sService = applicationContext.getBean(SService.class);
		sService.queryForList();
	}
}
