package com.imooc.RiskCtrlSys.flink.utils;

/**
 * zxj
 * description: Redis 键名工具类
 * date: 2023
 */

public class RedisKeyUtil {

    /**
     * zxj
     * description: 指标 Redis Key组装
     * @return java.lang.String
     */
    public static String redisKeyFormatForMetric(String keyby) {

        /* **********************
         *
         * a.
         * Redis Key格式: 指标id:分组:指标主维度:计算方式:指标版本号+编号
         *
         * b.
         * Redis Key格式设计思路：
         * 1. 能够快速获取到规则对应的指标值 (根据指标id和分组)
         * 2. 能够快速获取到指定的最近时间段的指标值 (根据编号)
         * 3. 能够快速将单位指标值进行计算 (因为Redis存放的只是单位指标值, 根据指标主纬度和计算方式)
         * 4. 能够快速获取到最新(更新后)的指标值 (根据版本号)
         *
         * c.
         * 难点是根据编号获取到指定的最近时间段的指标值,
         * 根据编号获取到指定的最近时间段的指标值 算法思路：
         * 例如要获取最近10分钟的指标值:
         * 1. 指标计算是会每20秒计算一次指标, 并将指标值存入Redis
         *    (单位指标值是20秒,)
         *    (最近10分钟的指标值, 就是将最近30个20秒的单位指标值进行相加)
         * 2. 那么问题就是要获取到最近20秒的这个单位指标值, 再根据编号往上取30个单位指标值就可以了
         * 3. Redis的每个key的存储是有个时间戳的,
         *    采样窗口 = 当前时间戳 - 指标最后的单位指标值存储的时间戳,
         *    如果采样窗口的时间大于 10 分钟, 那么表明最近10分钟没有新指标值, 无需获取,
         *    如果采样窗口的时间小于 10 分钟, 那么表明最近10分钟有新指标值, 需要获取,
         * 4. 那么问题就转化为要获取多少个单位指标值, 才符合最近的10分钟内
         *    计算公式： (指定时间-采样窗口) ÷ 采样间隔 = 采样次数
         *    指定时间：10分钟
         *    采样间隔：20秒
         *    采样次数：要获取的单位指标值数量
         *
         * *********************/
        String key = "";
        //TODO 指标的Redis Key组装

        //Redis Key 键名大写
        return key.toUpperCase();
    }
}
