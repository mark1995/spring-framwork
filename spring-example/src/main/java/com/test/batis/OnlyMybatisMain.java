package com.test.batis;

import com.test.batis.dao.SMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
public class OnlyMybatisMain {

	public static void main(String[] args) {
//
//		BatisConfig batisConfig = new BatisConfig();
//		DataSource dataSource = batisConfig.dataSource();
//		TransactionFactory  transactionFactory = new JdbcTransactionFactory();
//		Environment environment = new Environment("development", transactionFactory, dataSource);
//		Configuration configuration = new Configuration(environment);
//		configuration.addMapper(SMapper.class);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//
//		// java代理实现
//		SMapper mapper = sqlSession.getMapper(SMapper.class);
//		List<Map<String, Object>> resultMap = mapper.queryForList();
//		log.debug("resultMap:{}", resultMap);
	}
}
