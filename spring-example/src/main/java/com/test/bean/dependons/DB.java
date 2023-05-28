package com.test.bean.dependons;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component("db")
public class DB {

	static {
		log.debug("db static code executor");
	}

	public DB() {
		log.debug("db constructor");
	}


	@PostConstruct
	public void initMethod() {
		log.debug("db init method ");
	}
}
