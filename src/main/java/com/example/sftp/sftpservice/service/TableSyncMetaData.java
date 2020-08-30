package com.example.sftp.sftpservice.service;

import com.alibaba.fastjson.JSONObject;
import com.example.sftp.sftpservice.tool.ResponseResult;
import com.example.sftp.sftpservice.util.HttpClientUtil;
import com.example.sftp.sftpservice.vo.ColumnVo;
import com.example.sftp.sftpservice.vo.TableVo;
import com.sun.deploy.net.HttpUtils;
import org.apache.http.client.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class TableSyncMetaData {

    @Value("${postMetaDataStatusUrl}")
    private String postMetaDataStatusUrl;

    private static final Logger LOG = LoggerFactory.getLogger(TableSyncMetaData.class);

    public ResponseResult addTable(TableVo tableVo) {
        String tenantCode = tableVo.getTenantCode();
        String replace = tenantCode.replace("-", "_");
        List<ColumnVo> columnVOList = tableVo.getColumnVOList();

        return ResponseResult.success("success1",columnVOList);

    }

    public ResponseResult addColumnList(List<ColumnVo> columnVoList) {
        boolean flag = false;
        if (columnVoList==null) {
            return ResponseResult.error("column is null!");
        } else {
            for (ColumnVo v:columnVoList) {
                String tenantCode = v.getTenantCode();
                String columnCode = v.getColumnCode();
                String dataType = v.getDataType();
            }
            return ResponseResult.success("success",columnVoList);
        }
    }

    public ResponseResult addListMap(Map queryParams) {
        Object tenantCode = queryParams.get("tenantCode");
        // Set set = queryParams.keySet();
        return ResponseResult.success("SUCCESS!",tenantCode);
    }


    public ResponseResult addMetaDataStatus(String tableName) {
        Map<String, Object> objectHashMap = new HashMap<>();

        List<ColumnVo> vos = new ArrayList<>();
        ColumnVo vo = new ColumnVo();
        vo.setColumnCode("sid");
        vo.setColumnName("sid");
        vo.setDataType("varchar");
        ColumnVo vo1 = new ColumnVo();
        vo1.setColumnCode("dept");
        vo1.setColumnName("dept");
        vo1.setDataType("varchar");
        ColumnVo vo2 = new ColumnVo();
        vo2.setColumnCode("age");
        vo2.setColumnName("age");
        vo2.setDataType("integer");
        vos.add(vo);
        vos.add(vo1);
        vos.add(vo2);
        objectHashMap.put("tableName",tableName);
        objectHashMap.put("columnVOList",vos);
        HttpClientUtil.sendPostReq(postMetaDataStatusUrl,objectHashMap,"utf-8");
        //HttpClientUtil.doPost(postMetaDataStatusUrl,objectHashMap);
        return ResponseResult.success("success!",objectHashMap);
    }
}
