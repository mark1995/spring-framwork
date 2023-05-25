package com.test.aop.aspect;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "e")
public class XmlAdvice {

	public void before(){
		log.debug(" xml before");
	}

	public void afterReturning(){
		log.debug(" xml afterReturning");
	}

	public void after(){
		log.debug(" xml after");
	}

	// 正常情况下 未抛出异常： 前置通知(before)->目标方法->后置通知(after-returning)->最终通知(after)
	// 正常情况下 抛出异常： 前置通知(before)->目标方法(抛出异常)->异常通知(after-throwing)->最终通知(after)
	// 注意！！！ 如果在xml中交换 后置通知after-returning和最终通知after的配置顺序,就会导致 最终通知 after先于after-returning执行 ， 但是注意，这是不规范的，按照标准应该是让 after最终通知最后执行才正确
}
