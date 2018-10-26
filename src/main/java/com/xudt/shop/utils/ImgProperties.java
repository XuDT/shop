package com.xudt.shop.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 图片上传信息配置
 */
@Component
@ConfigurationProperties(prefix="message")
@PropertySource("classpath:img_message.properties")
public class ImgProperties {

    /**
     * 压缩大小
     */
    private long fileSize;

    /**
     * 压缩比例
     */
    private double scaleRatio;

    /**
     * 保存路径
     */
    private String upPath;

    /**
     * 图片类型
     */
    private String imageType;

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public double getScaleRatio() {
        return scaleRatio;
    }

    public void setScaleRatio(double scaleRatio) {
        this.scaleRatio = scaleRatio;
    }

    public String getUpPath() {
        return upPath;
    }

    public void setUpPath(String upPath) {
        this.upPath = upPath;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

}

