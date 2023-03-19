package com.snoweagle.dc.shadingjdbc.infra.dal.mapper;

import com.snoweagle.dc.shadingjdbc.infra.dal.dataObject.OrderDO;

import java.util.List;

public interface OrderDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderDO record);

    int insertSelective(OrderDO record);

    OrderDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDO record);

    int updateByPrimaryKey(OrderDO record);

    List<OrderDO> selectByCondition(OrderDO params);
}