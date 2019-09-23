package com.leqi.goods.service.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lwep
 * @dareTime 2019/9/19 10:26
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.leqi.goods.service.mapper")
public class MybatisPlusConfiguration {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();
    }
}
