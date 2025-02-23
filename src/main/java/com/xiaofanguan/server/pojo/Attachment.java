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
    private String fileName; // 文件名

    @TableField("file_type")
    private String fileType; // 文件类型

    @TableField("file_size")
    private Long fileSize; // 文件大小（单位：字节）

    @TableField("base64_content")
    private String base64Content; // 文件的 Base64 编码内容

    @TableField("create_time")
    private LocalDateTime createTime; // 创建时间

    @TableField("created_by")
    private String createdBy; // 创建者 ID
}