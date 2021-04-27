package com.snoweagle.dc.rpc.api;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @Author: snoweagle
 * @Date: 2021/4/24 8:50 PM
 */
@Slf4j
public class BizApiImpl implements BizApi {
    @Override
    public Map dosomething(String req) {
        log.info("获取请求：{}",req);
        Map map = new HashMap();
        map.put("result",req);
        return map;
    }
}
