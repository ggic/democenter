package com.snoweagle.dc.shadingjdbc.app;


import com.snoweagle.dc.shadingjdbc.infra.dal.dataObject.OrderDO;
import com.snoweagle.dc.shadingjdbc.infra.dal.mapper.OrderDOMapper;
import com.snoweagle.dc.shadingjdbc.infra.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController  {
    @Autowired
    OrderDOMapper orderDOMapper;

    @GetMapping(value = "/get/{userId}")
    public String get(@PathVariable Long userId){
        OrderDO params = new OrderDO();
        params.setUserId(userId);
        List<OrderDO> orderDOS = orderDOMapper.selectByCondition(params);
        log.info("resp:{}",orderDOS);
        return GsonUtils.BeanToJson(orderDOS);
    }
    @GetMapping(value = "/put/{serviceName}")
    public void put(@PathVariable String serviceName)  {
        OrderDO params = new OrderDO();
        params.initBaseData();
        params.setOrderNo(UUID.randomUUID().toString());
        params.setId(System.currentTimeMillis());
        params.setServiceName(serviceName);
        orderDOMapper.insertSelective(params);
    }
}
