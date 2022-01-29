package com.bancow.process.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponseDto {
    private Long id;
    private String userName;

    public LoginResponseDto(Long id) {
        this.id = id;
    }

    public LoginResponseDto(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}
