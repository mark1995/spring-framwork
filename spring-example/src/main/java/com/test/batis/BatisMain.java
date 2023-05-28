package com.test.batis;

import com.test.batis.service.SService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

@Slf4j
public class BatisMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BatisConfig.class);

		SService ss = applicationContext.getBean(SService.class);
		List<Map<String, Object>> maps = ss.queryForList();
		log.debug("query sql result {}", maps);


	}
}
