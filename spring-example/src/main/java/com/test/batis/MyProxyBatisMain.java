package com.test.batis;

import com.test.batis.dao.SMapper;
import com.test.batis.service.SService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyProxyBatisMain {

	public static void main(String[] args) {
//		SMapper mapper = (SMapper)MySqlSession.getMapper(SMapper.class);
//		mapper.queryForList();

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BatisConfig.class);
		SService sService = applicationContext.getBean(SService.class);
		sService.queryForList();


	}
}
