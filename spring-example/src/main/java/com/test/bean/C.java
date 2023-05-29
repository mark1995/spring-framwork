package com.test.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("c")
public class C {


	@Autowired
	private A a;


	public A getA() {
		return a;
	}
}
