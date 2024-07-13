package com.imooc.RiskCtrlSys.utils.hbase;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * zxj
 * description: Hbase配置信息读取类
 * date: 2023
 */

@Data
@ConfigurationProperties(prefix = "hbase.conf")
public class HbaseProperties {

    private Map<String, String> confMaps;
}
