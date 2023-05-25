package com.test.aop.service.impl;

import com.test.aop.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("s")
@Slf4j(topic = "e")
public class StudentServiceImpl implements StudentService {
    public void add(String name){
    	log.debug("name-[{}]",name);
    }
}
