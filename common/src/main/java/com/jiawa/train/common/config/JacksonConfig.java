package com.jiawa.train.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2024-03-03 12:46
 * @description: 解决前后端交互Long类型精度丢失的问题
 **/
public class JacksonConfig {

    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }
}
