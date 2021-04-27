package com.snoweagle.dc.rpc.client;

import com.snoweagle.dc.rpc.api.BizApi;
import lombok.extern.slf4j.Slf4j;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @Author: snoweagle
 * @Date: 2021/4/24 11:17 PM
 */
@Slf4j
public class RpcConsumer {
    public static void main(String[] args) {

        BizApi bizApi = RpcClientProxy.create(BizApi.class);
        log.info("response:{}",bizApi.dosomething("搞事情"));

    }
}
