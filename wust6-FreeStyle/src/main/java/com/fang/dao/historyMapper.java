package com.fang.dao;

import java.util.List;

import com.fang.domain.dataTable;
import com.fang.domain.history;

public interface historyMapper {
	int deleteByPrimaryKey(Long id);

	int insert(history record);

	int insertSelective(history record);

	List<history> selectByTable(dataTable dt);// 根据排序结果取得数据

	int countResult(Long userid);// 根据当前用户取得所有的数据

	history selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(history record);

	int updateByPrimaryKey(history record);
}