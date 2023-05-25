package com.test.observer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestListener {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				context= new AnnotationConfigApplicationContext(ListenerConfig.class);
	}
}
