package com.bancow.process.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private Long id;
    private String userName;

    public LoginResponseDto(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}
