package com.test.transaction.service;

import org.springframework.jdbc.core.JdbcTemplate;

public class XMLUserService {

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void update(){
		jdbcTemplate.update("update t set v=? where k=?","n","k1");
		throw new NullPointerException();
	}
}
