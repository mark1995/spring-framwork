package com.test.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j(topic = "e")
public class AopAspect {
	@Pointcut("execution(* com.test.aop.service.*.*(..))")
	public void pointCut(){

	}

	@Pointcut("execution(* com.test.transaction.*.*(..))")
	public void pointCutOut(){

	}

	@After("pointCut()")
	public void after(){
		log.debug("anno after");
	}

	@Before("pointCut()")
	public void before(){
		log.debug("anno before");
	}

	@AfterReturning("pointCut()")
	public void afterReturning(){
		log.debug("anno afterReturning");
	}







	@Before("pointCutOut()")
	public void testMethod(){
		log.debug("testMethod");
	}


//	public static void main(String[] args) {
//		Method[] declaredMethods = AopAspect.class.getDeclaredMethods();
//		System.out.println();
//	}
}
