package com.xudt.shop.config.shiro;

import com.xudt.shop.config.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: FreeMarker配置类
 */
@Configuration
public class FreeMarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

    /**
     * 添加共享变量
     */
    @PostConstruct
    public void setSharedVariable() {
        try {
            //setSharedVariable()方法向配置实例中添加共享变量
            configuration.setSharedVariable("shiro", new ShiroTags());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
