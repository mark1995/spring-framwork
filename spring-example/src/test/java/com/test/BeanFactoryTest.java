package com.test;

import com.test.bean.MyTestBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest extends Assert {


	@Test
	public void testSimpleLoad() {
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
		MyTestBean myTestBean = (MyTestBean)beanFactory.getBean("myTestBean");
		assertEquals("testStr", myTestBean.getTestStr());
	}
}
