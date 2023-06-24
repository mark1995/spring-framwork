package com.test.scan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScanMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.addBeanFactoryPostProcessor(new MyScanBeanPostProcessor());
		applicationContext.refresh();
	}
}
