package com.test.batis;

import com.test.batis.service.SService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

@Slf4j
public class BatisMain {

	/**
	 * 1. ImportBeanDefinitionRegistrar 工作原理  怎么回调，如何回调
	 * 2. mybatis如何扩展Spring的扫描器
	 * 3. MyFactoryBean的工作原理
	 * 		BeanDefinitionRegistryPostProcessor
	 * 4. BeanFactoryPostProcessor的工作原理
	 *    a. BeanFactoryPostProcessor怎么回调的
	 *    b. BeanFactoryPostProcessor执行时机
	 *    c. BeanFactoryPostProcessor的来源（怎么给到Spring）
	 *    d. BeanFactoryPostProcessor的子类和本身的原理
	 *    e. 为啥不能自己注册beanDefinition
	 *    f. List<BeanDefinition>的实例对象为啥会有list
	 * 5. 什么是单例池，扫描是beanDefinitionMap, Import是如何工作的
	 * @param args
	 */

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BatisConfig.class);

		SService ss = applicationContext.getBean(SService.class);
		List<Map<String, Object>> maps = ss.queryForList();
		log.debug("query sql result {}", maps);


	}
}
