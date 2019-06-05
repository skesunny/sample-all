package com.honc.sample.sampledatasource;

/**
 * @author honc.z
 * @date 2019/4/3
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MyBatisConfig implements InitializingBean, ApplicationContextAware {
    @Autowired
    private Environment environment;

    public static List<String> urlList = new ArrayList<>();

    private ApplicationContext applicationContext;

    /**
     * 本bean初始化时，根据数据源个数，动态生成数据源bean
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        String urls = environment.getProperty("mutiljdbc.url");
        if (urls != null) {
            String[] urlArray = urls.split(",");
            for (String url : urlArray) {
                urlList.add(url);
            }
            for (String url : urlList) {
                BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(DruidDataSource.class);
                beanDefinitionBuilder.addPropertyValue("driverClassName", environment.getProperty("mutiljdbc.driverClassName"));
                beanDefinitionBuilder.addPropertyValue("username", environment.getProperty("mutiljdbc.username"));
                beanDefinitionBuilder.addPropertyValue("password", environment.getProperty("mutiljdbc.password"));
                beanDefinitionBuilder.addPropertyValue("url", url);
                BeanDefinition dataBeanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
                BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();
                //不知道怎么给bean取名字，直接用url作为bean的名字,去掉冒号和斜扛
                url = url.replace("/", "").replace(":", "");
                beanFactory.registerBeanDefinition(url, dataBeanDefinition);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        String defaultUrl = null;
        //将所有数据源注册到动态数据源map里，key为去掉冒号和斜扛的url，value为对应的datasource所形成的bean
        for (String url : urlList) {
            url = url.replace("/","").replace(":","");
            targetDataSources.put(url, applicationContext.getBean(url));
            defaultUrl = url;
        }

        DynamicDataSource dataSource = new DynamicDataSource();
        // 该方法是AbstractRoutingDataSource的方法
        dataSource.setTargetDataSources(targetDataSources);
        // 默认的datasource设置为最后一个数据源
        dataSource.setDefaultTargetDataSource(applicationContext.getBean(defaultUrl));

        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        // 指定数据源(这个必须有，否则报错)
        fb.setDataSource(this.dataSource());
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        // fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
        // 指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapper-locations")));

        //把可能定义的拦截器扔进去
        try {
            String[] interceptors = applicationContext.getBeanNamesForType(Interceptor.class);
            if (interceptors != null){
                Interceptor[] interceptorsArray = new Interceptor[interceptors.length];
                for (int i = 0;i<interceptors.length;i++){
                    Interceptor interceptor = (Interceptor) applicationContext.getBean(interceptors[i]);
                    interceptorsArray[i] = interceptor;
                }
                fb.setPlugins(interceptorsArray);
            }
        }catch (Exception e){

        }
        return fb.getObject();
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
