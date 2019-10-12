package com.meisu.selfproperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
@ConfigurationProperties(prefix = "file")
@Configuration
public class FileProperties {
    /**
     * 文件上传的位置
     */
    @Setter
    @Getter
    private String uploadDir;

    /**
     * 允许的类型
     */
    private String uploadAllowFileType;

    @Getter
    private List<String> uploadAllowFileTypeList;

    /**
     * 拿到参数时拆分
     * @param uploadAllowFileType
     */
    public void setUploadAllowFileType(String uploadAllowFileType) {
        this.uploadAllowFileType = uploadAllowFileType;
        this.uploadAllowFileTypeList = Arrays.asList(uploadAllowFileType.split(","));
    }
}
