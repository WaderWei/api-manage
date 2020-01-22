package com.meisu.selfproperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * cors配置参数
 */
@Configuration
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {

    /**
     * 预检请求的有效期，单位为秒
     */
    @Getter
    @Setter
    private Long maxAge;

    /**
     * 允许的源服务
     */
    private String allowedOrigins;

    @Getter
    private List<String> allowedOriginList;

    /**
     * 拿到参数进行拆分
     *
     * @param allowedOrigins
     */
    public void setAllowedOrigins(String allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
        this.allowedOriginList = Arrays.asList(allowedOrigins.split(","));
    }
}
