package com.test.bean.dependons;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component("da")
@DependsOn("db")
public class DA {

	static {
		log.debug("da static code executor");
	}

	public DA() {
		log.debug("ad constructor");
	}

	@PostConstruct
	public void initMethod() {
		log.debug("ad init method");
	}
}
