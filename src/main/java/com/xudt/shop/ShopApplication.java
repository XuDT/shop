package com.xudt.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: SpringBoot启动类
 */
@SpringBootApplication
//mapper接口类扫描包配置，用这个注解可以注册mybatis mapper接口类
@MapperScan("com.xudt.shop.dao")
public class ShopApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ShopApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 这里指向原先用main方法执行的Application启动类
        return builder.sources(ShopApplication.class);
    }
}
