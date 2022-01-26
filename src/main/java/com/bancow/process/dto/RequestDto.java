package com.bancow.process.dto;

import com.bancow.process.domain.Farm;
import lombok.Data;

@Data
public class RequestDto {

    private String phoneNumber;
    private String password;


    public Farm toEntity() {
        return Farm.builder()
                .userName(phoneNumber)
                .password(password)
                .build();
    }
}
