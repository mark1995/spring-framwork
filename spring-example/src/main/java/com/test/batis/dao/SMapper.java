package com.test.batis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

//@Mapper
public interface SMapper {


//	@Select("select * from s1")
	@Select("select * from geek_test")
	List<Map<String, Object>> queryForList();


	@Select("select * from t1 where id = {id}")
	Map<String, Object> queryForMapById(Integer id);
}
