package com.example.sftp.sftpservice.controller;

import com.example.sftp.sftpservice.service.TableSyncMetaData;
import com.example.sftp.sftpservice.tool.ResponseResult;
import com.example.sftp.sftpservice.vo.ColumnVo;
import com.example.sftp.sftpservice.vo.TableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/v1/xtag/label")
public class DataSync {

    @Autowired
    TableSyncMetaData tableSyncMetaData;

    @RequestMapping(value = "/addTable", method = RequestMethod.POST)
    public ResponseResult addTable(@RequestBody TableVo tableVo) {
        return tableSyncMetaData.addTable(tableVo);
    }

    @RequestMapping(value = "/addColumn",method = RequestMethod.POST)
    public ResponseResult addColumn(@RequestBody List<ColumnVo> columnVoList) {
        return tableSyncMetaData.addColumnList(columnVoList);
    }

    @RequestMapping(value = "/addMapQuerys",method = RequestMethod.POST)
    public ResponseResult addMap(@RequestBody Map queryParams) {
        return tableSyncMetaData.addListMap(queryParams);
    }

    @RequestMapping(value = "/status",method = RequestMethod.POST,consumes = "application/json")
    public ResponseResult addSendPostStatus(String tableName) {
        System.out.println("hello!");
        return tableSyncMetaData.addMetaDataStatus(tableName);
    }
}
