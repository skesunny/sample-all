package com.honcz.sample.springextensionapi.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author honc.z
 * @date 2019/4/11
 */
@Component
public class MyFactoryBean implements FactoryBean<Object> {
    @Override
    public Object getObject() throws Exception {
        return new ProxyPeople();
    }

    @Override
    public Class<?> getObjectType() {
        return MyFactoryBean.class;
    }
}
