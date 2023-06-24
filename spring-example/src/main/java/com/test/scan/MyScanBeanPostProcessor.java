package com.test.scan;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

public class MyScanBeanPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		MyScanner myScanner = new MyScanner();
		try {
			myScanner.scanPackages("com.test.scan.bean");
			for (String beanName : myScanner.getListName()) {
				if (!registry.containsBeanDefinition(beanName)) {
					registry.registerBeanDefinition(beanName, myScanner.getBeanDefinitionMap().get(beanName));
				}
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
