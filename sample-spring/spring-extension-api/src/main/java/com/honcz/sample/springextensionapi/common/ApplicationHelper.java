package com.honcz.sample.springextensionapi.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author honc.z
 * @date 2019/4/11
 */
@Component
public class ApplicationHelper implements ApplicationContextAware {
    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        applicationContext = ctx;
    }

    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }
}
