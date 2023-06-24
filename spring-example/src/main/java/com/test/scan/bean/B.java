package com.test.scan.bean;


import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

@Slf4j
public class B {

	@PostConstruct
	public void initMethod() {
		log.info("B init");
	}
}
