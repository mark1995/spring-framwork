package com.test.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class TestBean {

	@Component("aa")
	public static class AA {

	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BeanConfig.class);
		applicationContext.refresh();
		Object aa = applicationContext.getBean("testAA");
		System.out.println(aa);
	}
}
