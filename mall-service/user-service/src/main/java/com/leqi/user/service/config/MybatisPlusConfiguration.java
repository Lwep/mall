package com.leqi.user.service.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lwep
 * @dareTime 2019/9/16 16:47
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.leqi.user.service.mapper")
public class MybatisPlusConfiguration {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();
    }
}
