package com.test.bean;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public class XmlBeanFactoryTest {

	public static void main(String[] args) {
		ClassPathResource classPathResource = new ClassPathResource("spring-context.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(classPathResource);
		val bean = beanFactory.getBean(C.class);
		A a = bean.getA();
		// xmlBeanFactory 方式不能解析autowired的注入方式
		log.debug("[a={}]", a);
	}
}
