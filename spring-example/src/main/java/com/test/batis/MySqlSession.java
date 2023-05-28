package com.test.batis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


@Slf4j
public class MySqlSession {

	public static Object getMapper(Class clazz) {
		ClassLoader classLoader = MySqlSession.class.getClassLoader();
		Class[] classes = new Class[]{clazz};
		Object proxy = Proxy.newProxyInstance(classLoader, classes, new MyTestInvocationHandler());
		return proxy;
	}

	static class MyTestInvocationHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (Object.class.equals(method.getDeclaringClass())) {
				return method.invoke(this, args);
			}
			Select select = method.getAnnotation(Select.class);
			String sql = select.value()[0];
			log.debug("test connection db");
			log.debug("test executor sql {}", sql);
			log.debug("test return sql result");
			return null;
		}
	}
}
