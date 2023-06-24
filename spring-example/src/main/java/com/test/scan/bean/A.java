package com.test.scan.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class A {

	@PostConstruct
	public void initMethod() {
		log.info("A init");
	}
}
