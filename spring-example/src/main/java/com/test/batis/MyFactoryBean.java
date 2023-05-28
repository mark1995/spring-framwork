package com.test.batis;

import org.springframework.beans.factory.FactoryBean;

/**
 * factoryBean类产生两个bean,一个是factoryBean,一个是getObject产生的bean
 *
 *
 * 1. 如何把一个类 交给spring容器
 * 	a xml
 * 	b 注解
 * 	c beanDefinition交给spring 如何动态注册beanDefinition, 什么是beanDefinition
 */
//@Component
public class MyFactoryBean implements FactoryBean {

	Class mapperInterface;

	public void setMapperInterface(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {
//		Object mapper = MySqlSession.getMapper(SMapper.class);
//		return (SMapper)mapper;
		return MySqlSession.getMapper(mapperInterface);
	}

	@Override
	public Class<?> getObjectType() {
//		return SMapper.class;
		return mapperInterface;
	}
}
