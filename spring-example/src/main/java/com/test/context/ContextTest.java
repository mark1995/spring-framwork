package com.test.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class ContextTest {

	public static void main(String[] args) {
		/**
		 * 这里容器 也没有autowired注解的解析
		 */
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(A.class);
		// 可以让A的c属性走setter注入模式
//		builder.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);
		beanFactory.registerBeanDefinition("a", builder.getBeanDefinition());

		BeanDefinitionBuilder cBuilder = BeanDefinitionBuilder.genericBeanDefinition(C.class);
		beanFactory.registerBeanDefinition("c", cBuilder.getBeanDefinition());

//		A bean = beanFactory.getBean(A.class);
//		log.debug("[bean={}]", bean);
//		log.debug("[a.c={}]", bean.getC());

		AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
		autowiredAnnotationBeanPostProcessor.setBeanFactory(beanFactory);
		// 让beanFactory支持autowired的注入解析
		beanFactory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);
		beanFactory.getBean(C.class);
		A bean1 = beanFactory.getBean(A.class);
		log.debug("after [a={}]", bean1);
		log.debug("after [a.c={}]", bean1.getC());


		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("com.test.context");
		applicationContext.refresh();

	}
}
