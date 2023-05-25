package com.test.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	//@Transactional
	public void update(){
		jdbcTemplate.update("update t set v=? where k=?","n","k1");
		int i = 1/0;
		//throw new NullPointerException();
	}
}
