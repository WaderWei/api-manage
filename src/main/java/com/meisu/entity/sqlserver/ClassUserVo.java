package com.meisu.entity.sqlserver;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassUserVo {
    private Integer id;

    private String lastName;

    private Integer studyStatus;

    private Long classId;
}
