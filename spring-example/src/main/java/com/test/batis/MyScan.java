package com.test.batis;


import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import({MyBeanDefinition.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyScan {
}
