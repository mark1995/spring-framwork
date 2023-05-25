package com.test.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration("a")
@ComponentScan("com.test.aop")
@EnableAspectJAutoProxy
public class App {

}
