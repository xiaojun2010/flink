package com.imooc.RiskCtrlSys.flink.kafka;

import com.imooc.RiskCtrlSys.model.KafkaMessagePO;
import com.imooc.RiskCtrlSys.utils.json.JsonUtil;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.connectors.kafka.KafkaDeserializationSchema;
import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * zxj
 * description: 自定义Kafka反序列化类
 * date: 2023
 */

/* **********************
 *
 * 知识点
 *
 * 一:
 *
 * 自定义Kafka反序列化类的方法：
 *
 * 1. 若使用 setValueOnlyDeserializer() , 方法内的参数必须是实现 DeserializationSchema 接口的对象
 * 2. 若使用 setDeserializer() , 方法内的参数必须是实现 KafkaDeserializationSchema 接口的对象
 *
 *
 * *********************/

public class ImoocDeserializationSchema implements KafkaDeserializationSchema<KafkaMessagePO> {

    private static final String ENCODEING = "UTF8";
    /**
     * zxj
     * description: 判断当前位置是否到达数据流的末尾
     * @param o:
     * @return boolean
     */
    @Override
    public boolean isEndOfStream(KafkaMessagePO o) {
        return false;
    }

    /**
     * zxj
     * description: 自定义反序列化的主要逻辑
     * @param consumerRecord:
     * @return java.lang.Object
     */
    @Override
    public KafkaMessagePO deserialize(ConsumerRecord<byte[],byte[]> consumerRecord) throws Exception {

        KafkaMessagePO kafkaMessagePO = null;
        if(consumerRecord != null) {
            String value =  new String(consumerRecord.value(),ENCODEING);
            long offset = consumerRecord.offset();
            int partition = consumerRecord.partition();
            kafkaMessagePO = JsonUtil.jsonStr2Obj(value,KafkaMessagePO.class);
            //携带上offset和partition
            kafkaMessagePO.setOffset(offset);
            kafkaMessagePO.setPartition(partition);
        }

        return kafkaMessagePO;
    }

    /**
     * zxj
     * description: 指定反序列之后的数据类型
     * @param :
     * @return org.apache.flink.api.common.typeinfo.TypeInformation
     */
    @Override
    public TypeInformation getProducedType() {
        return TypeInformation.of(KafkaMessagePO.class);
    }
}
