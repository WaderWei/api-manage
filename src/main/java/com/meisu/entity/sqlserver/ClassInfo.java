package com.meisu.entity.sqlserver;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("MS_PX_CLASSINFO")
public class ClassInfo {
    @TableId(value = "class_id", type = IdType.ID_WORKER_STR)
    private Long classId;

    @TableField("class_name")
    private String className;

    @TableField("class_speaker")
    private String classSpeaker;

    @TableField("class_dep")
    private String classDep;

    @TableField("class_test_status")
    private Integer classTestStatus;

    @TableField(exist = false)
    private String classTestTest;

    @TableField(exist = false)
    private List<ClassUserVo> classUserVos = new ArrayList<>();

    public void setClassTestStatus(Integer classTestStatus) {
        switch (classTestStatus){
            case 0:{
                this.classTestTest = "未提交";
                break;
            }
            case 1:{
                this.classTestTest = "提交";
                break;
            }
        }
        this.classTestStatus = classTestStatus;
    }
}
