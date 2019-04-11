package com.honcz.sample.springextensionapi;

import com.honcz.sample.springextensionapi.common.ApplicationHelper;
import com.honcz.sample.springextensionapi.factorybean.MyFactoryBean;
import com.honcz.sample.springextensionapi.factorybean.ProxyPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringExtensionApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExtensionApiApplication.class, args);
        ProxyPeople proxyPeople = SpringExtensionApiApplication.getProxyPeople();
    }

    public static ProxyPeople getProxyPeople(){
        ProxyPeople proxyPeople = (ProxyPeople) ApplicationHelper.getBean("myFactoryBean");
        return proxyPeople;
    }

}
