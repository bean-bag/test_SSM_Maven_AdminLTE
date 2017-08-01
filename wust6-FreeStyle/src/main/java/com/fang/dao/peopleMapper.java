package com.fang.dao;

import com.fang.domain.people;

public interface peopleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(people record);

	int insertSelective(people record);

	people selectByPrimaryKey(Long id);

	people selectByUsername(String username);// 根据用户名取得用户信息

	int updateByPrimaryKeySelective(people record);

	int updateByPrimaryKey(people record);
}