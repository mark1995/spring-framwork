package com.test.transaction;

import com.test.transaction.config.App;
import com.test.transaction.controller.ConfigurationController;
import com.test.transaction.controller.PropagationController;
import com.test.transaction.service.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TransactionTest {
	@Test
	public void defaultTest(){
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:appTransaction4Xml.xml");
		UserService bean = context.getBean(UserService.class);
		bean.update();
	}


	@Test
	public void testJdbcTempdate(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);
		UserService bean = context.getBean(UserService.class);
		bean.update();
	}


	/**
	 * 第一种实现编程式事务的方法
	 * TransactionManager
	 *
	 */
	@Test
	public void testTransactionManager(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);
		PlatformTransactionManagerUserService bean = context.getBean(PlatformTransactionManagerUserService.class);
		bean.update();
	}

	/**
	 * 第一种实现编程式事务的方法
	 * TransactionTemplate
	 *
	 */
	@Test
	public void testTransactionTemplate(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);
		TransactionTemplateUserService bean = context.getBean(TransactionTemplateUserService.class);
		bean.update();
	}

	/**
	 * 加了 @Configuration 和不加的区别
	 * 事务失效
	 */
	@Test
	public void testConfiguration(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);
		ConfigurationController controller = context.getBean(ConfigurationController.class);
		controller.update();
	}

	/**
	 * 全xml
	 */
	@Test
	public void testXmlTx(){
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:appTransaction4Xml.xml");
		XMLUserService bean = context.getBean(XMLUserService.class);
		bean.update();
	}

	/**
	 * 全anno
	 */
	@Test
	public void testAnnoTx(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);
		AnnoUserService bean = context.getBean(AnnoUserService.class);
		bean.update();
	}


	/**
	 *
	 *
	 *
	 *
	 * bean:
	 * public  class Bean extends AnnoUserService?  代理对象 cglib
	 * 	Object target;
	 *  public void update(){
	 *  	//事务的开启  -conn1
	 * 		//jdbc conn	-conn2
	 *      target.update();
	 *  }
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */


	/**
	 * 混合声明式事务
	 */

	@Test
	public void testAnnoAndXmlTx(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);
		AnnoAndXmlUserService bean = context.getBean(AnnoAndXmlUserService.class);
		bean.update();
	}

	/**
	 * 如果异常被处理了则不会回滚
	 *
	 * Participating
	 */
	@Test
	public void testPropagationREQUIRED() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);
//		PropagationController bean = context.getBean(PropagationController.class);
//		bean.update();

		PropagationUserService1 service1 = context.getBean(PropagationUserService1.class);
		service1.update();
	}

	/**
	 * Suspending current transaction1, creating new transaction2
	 *
	 * tx1 update t set field0 where filed1
	 * 如果where 的 field1他不是一个索引字段就会执行表锁
	 * 如果where 的 field1 加了注释则是行锁
	 */
	@Test
	public void testPropagationREQUIRES_NEW() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);

		PropagationUserService1 service1 = context.getBean(PropagationUserService1.class);
		service1.update();
	}


	/**
	 * 如果有事务 Creating nested transaction
	 */
	@Test
	public void testPropagationREQUIRES_Nested() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);

		PropagationUserService1 service1 = context.getBean(PropagationUserService1.class);
		service1.update();
	}


	/**
	 * 没有事务  No existing transaction found for transaction marked with propagation 'mandatory'
	 * 有事务：Participating
	 *
	 */
	@Test
	public void testPropagationREQUIRES_Mandatory() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);

		PropagationUserService1 service1 = context.getBean(PropagationUserService1.class);
		service1.update();
	}

	/**
	 * 有事务 Participating in existing transaction
	 * 没有事务 不加入 非事务运行
	 */

	@Test
	public void testPropagationREQUIRES_SUPPORTS() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);

		PropagationUserService1 service1 = context.getBean(PropagationUserService1.class);
		service1.update();
	}

	/**
	 * 没有事务 不加入 非事务运行
	 * 有事务 Suspending current transaction
	 */

	@Test
	public void testPropagationREQUIRES_NOT_SUPPORTS() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);

		PropagationUserService1 service1 = context.getBean(PropagationUserService1.class);
		service1.update();
	}

	@Test
	public void testPropagationREQUIRES_NEVER() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);

		PropagationUserService1 service1 = context.getBean(PropagationUserService1.class);
		service1.update();
	}


	@Test
	public void testPropagationRule() throws IOException {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(App.class);

		RuleUserService ruleUserService = context.getBean(RuleUserService.class);
		ruleUserService.update();
	}

}
