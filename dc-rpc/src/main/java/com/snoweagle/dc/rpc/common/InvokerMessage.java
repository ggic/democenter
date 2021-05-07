package com.snoweagle.dc.rpc.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @Author: snoweagle
 * @Date: 2021/4/24 11:15 PM
 */
@Data
public class InvokerMessage implements Serializable {
    private String className; // 服务名称
    private String methodName; // 调用哪个方法
    private Class<?>[] params; // 参数列
    private Object[] values; // 参数值
}