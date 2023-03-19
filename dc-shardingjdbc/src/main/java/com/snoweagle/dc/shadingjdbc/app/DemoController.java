package com.snoweagle.dc.shadingjdbc.app;


import com.snoweagle.dc.shadingjdbc.infra.dal.dataObject.OrderDO;
import com.snoweagle.dc.shadingjdbc.infra.dal.mapper.OrderDOMapper;
import com.snoweagle.dc.shadingjdbc.infra.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController  {
    @Autowired
    OrderDOMapper orderDOMapper;

    @GetMapping(value = "/get/{userNo}")
    @ResponseBody
    public Object get(@PathVariable String userNo){
        OrderDO params = new OrderDO();
        params.setUserNo(userNo);
        List<OrderDO> orderDOS = orderDOMapper.selectByCondition(params);
        log.info("resp:{}",orderDOS);
        return (orderDOS);
    }
    @GetMapping(value = "/put/{userNo}")
    @ResponseBody
    public void put(@PathVariable String userNo)  {
        try {
            OrderDO params = new OrderDO();
            params.initBaseData();
            params.setUserNo(userNo);
            params.setOrderNo(UUID.randomUUID().toString());
            orderDOMapper.insertSelective(params);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @ResponseBody
    @GetMapping(value = "/putOne")
    public Object putOne()  {
        try {
            for(int i=0;i<10;i++) {
                OrderDO params = new OrderDO();
                params.initBaseData();
                params.setOrderNo(UUID.randomUUID().toString());
                orderDOMapper.insertSelective(params);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Ok";
    }
}
