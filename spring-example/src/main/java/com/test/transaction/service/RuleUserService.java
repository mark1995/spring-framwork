package com.test.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Component
public class RuleUserService {

	@Autowired
	JdbcTemplate jdbcTemplate;

//	@Autowired
//	PropagationUserService2 service2;

	@Transactional
	public void update(){
		jdbcTemplate.update("update t set v=? where k=?","n1","k1");
		//throw new IOException();
		int i = 1/0;
//		try {
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
