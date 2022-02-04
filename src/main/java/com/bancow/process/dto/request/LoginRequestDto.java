package com.bancow.process.dto.request;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginRequestDto{

    private String phoneNumber;

    private String password;

}
