package com.snoweagle.dc.shadingjdbc.infra.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @Author: snoweagle
 * @Date: 2021/5/4 5:17 PM
 */
@Component
public class TablePreciseShardingAlgorithm implements PreciseShardingAlgorithm {

    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        System.out.println("collection:" + collection+ ",shardingValues:" + preciseShardingValue);
        Collection<String> tables = collection;
        String shardingValue = getShardingValue(preciseShardingValue);
        return tables.stream().filter((table) -> table.endsWith(shardingValue)).findFirst().get();
    }

    /**
     * 获取倒数第2~3位
     *
     * @return
     */
    private String getShardingValue(PreciseShardingValue preciseShardingValue) {
        String tempShardingValue = String.valueOf(preciseShardingValue.getValue());
        return StringUtils.substring(tempShardingValue, tempShardingValue.length() - 3, tempShardingValue.length() - 1);
    }
}
