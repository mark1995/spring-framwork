package com.test.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

//@Component
public class PropagationUserService1 {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PropagationUserService2 service2;

	//@Transactional
	public void update() {
		jdbcTemplate.update("update t set v=? where k=?","n1","k1");

		//对异常进行了处理
//		try {
//			int i = 1 / 0;
//		}catch (Exception e){
//			e.printStackTrace();
//		}
		service2.update();


	}
}
