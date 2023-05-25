package com.test.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestAA {


	public TestAA() {
		log.debug("default constractor");
	}

	/**
	 * 构造器注入 优先参数多的构造函数使用，
	 * 如果有依赖冲突，在退让到其他构造器注入bean
	 * 因为TestBB 使用了resource依赖了TestAA,如果使用了TestBB这个构造函数注入bean,就会导致循环依赖，Spring会报错
	 * 如果此时把默认构造函数注释掉，就会报错
	 * 	Error creating bean with name 'testAA': Requested bean is currently in creation: Is there an unresolvable circular reference?
	 * @param bb
	 */
	public TestAA(TestBB bb) {
		log.debug("TestBB const");
	}

}
