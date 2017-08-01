package com.fang.dao;

import com.fang.domain.prize;

public interface prizeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(prize record);

    int insertSelective(prize record);

    prize selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(prize record);

    int updateByPrimaryKey(prize record);
}