package com.th.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * MybatisPlus配置
 *
 */
@Configuration
//@EnableTransactionManagement(order = 2)//多数据源让spring事务的aop在多数据源aop后面
@MapperScan(basePackages = {"com.th.demo.**.dao"})
public class MybatisPlusConfig {

//    @Autowired
//    private MutiDataSourceProperties properties;

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


//    /**
//     * 另外一个数据源
//     * @return
//     */
//    private DruidDataSource otherDatasource(){
//        DruidDataSource source = new DruidDataSource();
//        source.setMaxActive(200);
//        source.setInitialSize(20);
//        properties.datasourceTwoConfig(source);
//        return source;
//    }
//
//    /**
//     * 主数据源
//     * @return
//     */
//    private DruidDataSource defaultDatasource(){
//        DruidDataSource source = new DruidDataSource();
//        source.setMaxActive(200);
//        source.setInitialSize(20);
//        properties.datasourceOneConfig(source);
//        return source;
//    }

}
