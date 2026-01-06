package com.atguigu.gulimall.ware.confiig;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @BelongsProject: gulimall
 * @BelongsPackage: com.atguigu.gulimall.ware.confiig
 * @Author: GuoXiaofeng
 * @CreateTime: 2025-12-29  23:03
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.atguigu.gulimall.ware.dao")
public class MyBatisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setOverflow(true);
        paginationInterceptor.setLimit(100);
        return paginationInterceptor;
    }

}
