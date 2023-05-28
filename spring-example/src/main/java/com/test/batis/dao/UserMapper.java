package com.test.batis.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {


	@Select("select * from tb_users")
	List<Map<String, Object>> queryForList();
}
