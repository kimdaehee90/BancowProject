package com.bancow.process.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginResponseDto {

    private Long id;
    private String userName;

}
