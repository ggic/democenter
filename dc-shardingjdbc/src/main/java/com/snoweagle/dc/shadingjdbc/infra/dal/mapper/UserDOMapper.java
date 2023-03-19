package com.snoweagle.dc.shadingjdbc.infra.dal.mapper;

import com.snoweagle.dc.shadingjdbc.infra.dal.dataObject.UserDO;

public interface UserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);
}