package com.imooc.RiskCtrlSys.utils.hbase;

import com.imooc.RiskCtrlSys.utils.Application;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * zxj
 * description: Hbase工具类单元测试
 * date: 2023
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 生命周期
@SpringBootTest(classes = Application.class)
public class HbaseUtilTest {

    @Autowired
    private HbaseUtil hbaseUtil;

    @DisplayName("测试生成hbase Connection对象")
    @BeforeAll
    @Test
    public void testGetConnection() throws Exception {
        Connection conn = hbaseUtil.getConnection();
        System.out.println(conn);
        System.out.println("conn.isClosed() = "+conn.isClosed());
        System.out.println("conn.isAborted() = "+conn.isAborted());

        conn.close();

    }

    @DisplayName("测试生成hbase Admin对象")
    @Test
    public void testGetAdmin() throws Exception {
        Admin admin = hbaseUtil.getAdmin();
        System.out.println(admin);
    }

}
