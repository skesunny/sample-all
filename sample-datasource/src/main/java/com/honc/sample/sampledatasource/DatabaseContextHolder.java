package com.honc.sample.sampledatasource;

/**
 * @author honc.z
 * @date 2019/4/3
 * <p>
 * 线程安全的datebase容器
 * threadlocal实现
 */
public class DatabaseContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(String type) {
        contextHolder.set(type);
    }

    public static String getDatabaseType() {
        return contextHolder.get();
    }

    public static void remove(){
        contextHolder.remove();
    }
}
