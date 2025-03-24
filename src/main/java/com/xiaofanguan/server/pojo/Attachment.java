package com.xiaofanguan.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("attachment")
public class Attachment {
    @TableId
    private String id; // 主键

    @TableField("file_name")
    private String fileName; // MinIO中的文件名

    @TableField("create_time")
    private LocalDateTime createTime; // 创建时间

    @TableField("created_by")
    private String createdBy; // 创建者 ID
}