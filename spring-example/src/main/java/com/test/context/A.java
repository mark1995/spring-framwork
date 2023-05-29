package com.test.context;

import com.test.context.event.ABeanInitEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component("a")
public class A implements InitializingBean, ApplicationContextAware {


//	@Autowired
	private C c;

//	@Autowired
	private ApplicationContext applicationContext;

	@PostConstruct
	public void init() {
		log.debug("a init executor");
		applicationContext.publishEvent(new ABeanInitEvent(applicationContext));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("a class executor after properties");
	}


	public void setC(C c) {
		log.debug("set c method executor");
		this.c = c;
	}

	public C getC() {
		return c;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.debug("callback applicationContext aware");
		this.applicationContext = applicationContext;
	}
}
