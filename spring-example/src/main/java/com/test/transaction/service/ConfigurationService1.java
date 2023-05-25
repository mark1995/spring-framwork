package com.test.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

public class ConfigurationService1 {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void update(){
		jdbcTemplate.update("update t set v='n' where k='k1'");
	}
}
