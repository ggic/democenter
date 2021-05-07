package com.snoweagle.dc.shadingjdbc.infra.dal.dataObject;


import com.snoweagle.dc.shadingjdbc.infra.common.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDO extends BaseDO {
    private Long id;

    private Long userId;

    private String orderNo;

    private String serviceName;

    public OrderDO(){

    }
}