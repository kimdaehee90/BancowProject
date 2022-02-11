package com.bancow.process.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper(){
        getSerializerProvider().setNullValueSerializer(new NullSerializer());
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 없는 필드로 인한 오류 무시
    }
}