package com.meisu.config;

import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.meisu.mapper.*")
public class MybatisPlusConfig {

    @Bean
    public H2KeyGenerator h2KeyGenerator() {
        return new H2KeyGenerator();
    }
    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        //开启count的join 优化，只针对left join
        return new PaginationInterceptor().setCountSqlParser(new JsqlParserCountOptimize(true));
    }
}
