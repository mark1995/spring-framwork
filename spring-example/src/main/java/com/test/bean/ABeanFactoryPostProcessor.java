package com.test.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Order(6)
@Component
public class ABeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public ABeanFactoryPostProcessor() {
		log.debug("ABeanFactoryPostProcessor construct");
	}

	@PostConstruct
	public void initMethod() {
		log.debug("annotation init method bean a ");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		int orderValue = 0;
		if (this.getClass().isAnnotationPresent(Order.class)) {

		}
	}
}
