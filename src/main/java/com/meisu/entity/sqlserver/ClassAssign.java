package com.meisu.entity.sqlserver;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("MS_PX_CLASS_ASSIGN")
public class ClassAssign {
    @TableField("user_id")
    private String userId;

    @TableField("class_id")
    private Long classId;

    @TableField("study_status")
    private Integer studyStatus;
}
