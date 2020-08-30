package com.example.sftp.sftpservice.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ColumnVo {

    // 自增主键ID.
    private Integer id;
    // 终端编码.
    private String clientCode;
    // 租户编码 字段与表的关联，是通过租户编码、数据源编码、表名进行关联的.
    private String tenantCode;
    // 模型市场VAPP模型配置表的编码.
    private String modelConfigCode;
    // 数据源编码 字段与表的关联，是通过租户编码、数据源编码、表名进行关联的.
    private String datasourceCode;
    // 物理表名称 字段与表的关联，是通过租户编码、数据源编码、表名进行关联的.
    private String tableName;
    // 字段编码.
    private String columnCode;
    // 字段名称.
    private String columnName;
    // 数据类型.
    private String dataType;
    // 长度.
    private String dataLength;
    // 小数长度.
    private int dataPrecision;
    // 是否主键.
    private byte isPk;
    // 是否自增.
    private byte isAi;
    // 是否唯一.
    private byte isUq;
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

}
