package com.honc.sample.sampledatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author honc.z
 * @date 2019/4/3
 *
 * 动态数据源（需要继承AbstractRoutingDataSource）
 * 读写分离核心
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabaseType();
    }
}
