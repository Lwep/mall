package com.leqi.admin.service.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lwep
 * @dareTime 2019/9/3 17:04
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.leqi.admin.service.mapper")
public class MybatisPlusConfiguration {
/**
 * 分页插件
 */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
