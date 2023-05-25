package com.test.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("bb")
@Slf4j(topic = "bb")
public class TestBB {


//	@Resource
	@Autowired
	private TestAA testAA;

	public TestBB() {
		log.debug("testBB default const");
		log.debug("{}" , testAA);
		System.out.println(testAA);
	}
}
