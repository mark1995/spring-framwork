package com.test.batis;

import com.test.batis.dao.SMapper;
import com.test.batis.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MyBeanDefinition implements ImportBeanDefinitionRegistrar {


	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {


		/**
		 * 多mapper注入
		 */
		Map<String, BeanDefinition> maps = new HashMap<>();
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserMapper.class);
		maps.put("userMapper", builder.getBeanDefinition());
		maps.put("sMapper", BeanDefinitionBuilder.genericBeanDefinition(SMapper.class).getBeanDefinition());
		maps.keySet().forEach(key -> {
			AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition)maps.get(key);
			Class<?> beanClass = beanDefinition.getBeanClass();
			log.debug("before {}", beanClass.getName());
			beanDefinition.setBeanClass(MyFactoryBean.class);
			log.debug("after {}", beanDefinition.getBeanClass().getName());
			beanDefinition.getPropertyValues().add("mapperInterface", beanClass.getName());
			registry.registerBeanDefinition(key, beanDefinition);
		});



		/**
		 * 注册 beanDefinition
		 */
//		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
//		AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
////		beanDefinition.getPropertyValues().add("mapperInterface", SMapper.class);
//		beanDefinition.getPropertyValues().add("mapperInterface", "com.test.batis.dao.SMapper");
//		registry.registerBeanDefinition("myFactoryBean", beanDefinition);
//
//		BeanDefinitionBuilder other = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
//		AbstractBeanDefinition beanDefinition1 = other.getBeanDefinition();
//		beanDefinition1.getPropertyValues().add("mapperInterface", "com.test.batis.dao.UserMapper");
//		registry.registerBeanDefinition("userMapperFactory", beanDefinition1);

	}
}
