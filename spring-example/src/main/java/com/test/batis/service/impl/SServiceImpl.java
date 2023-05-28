package com.test.batis.service.impl;

import com.test.batis.dao.SMapper;
import com.test.batis.dao.UserMapper;
import com.test.batis.service.SService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SServiceImpl implements SService {

	// 1. 代理对象
	// 2. 谁产生了这个对象
	// 3. 如何把第三方产生的对象(实例化好的) 注入到spring管理 （@Service @Component 这个是把类交给spring, 动态生成beanDefinition , <bean> xml配置，不可以，
	// 注解bean， factoryBean, spring api）
	// 4. mybatis 采用factoryBean注入bean
	@Autowired
	private SMapper sMapper;

	@Autowired(required = false)
	private UserMapper userMapper;

	@Override
	public List<Map<String, Object>> queryForList() {
		if (userMapper != null) {
			userMapper.queryForList();
		}
		return sMapper.queryForList();
	}
}
