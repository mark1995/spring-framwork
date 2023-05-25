package com.test.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Component
public class PropagationUserService2 {

	@Autowired
	JdbcTemplate jdbcTemplate;
	//
	@Transactional(propagation = Propagation.NEVER)
	public void update(){
		jdbcTemplate.update("update t set v=? where k=?","n2","k2");
		//int i = 1 / 0;
	}
}
