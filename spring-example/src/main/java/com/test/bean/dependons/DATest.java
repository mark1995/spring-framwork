package com.test.bean.dependons;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DATest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("com.test.bean.dependons");
		applicationContext.refresh();

	}
}
