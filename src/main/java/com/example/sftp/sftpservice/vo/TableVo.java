package com.example.sftp.sftpservice.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TableVo {
    // 自增主键ID.
    private String id;
    // 终端编码.
    private String clientCode;
    // 租户编码  表与数据源的关联是通过租户编码和数据源编码关联起来的.
    private String tenantCode;
    // 数据源编码  表与数据源的关联是通过租户编码和数据源编码关联起来的.
    private String datasourceCode;
    // 表名称.
    private String name;
    // 类型：内部表，外部表.
    private String type;
    // 分区键数组
    private String partitionKeys;
    // 分区键值
    private String partitionKeyValues;
    // 备注.
    private String remark;
    // 创建人.
    private String createUser;
    // 创建时间.
    private Date createTime;
    // 修改人.
    private String modifyUser;
    // 修改时间.
    private Date modifyTime;
    // 字段信息.
    private List<ColumnVo> columnVOList = new ArrayList<ColumnVo>();
    // 表名.
    private String tableName;
}
