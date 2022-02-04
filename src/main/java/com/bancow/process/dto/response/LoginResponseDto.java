package com.bancow.process.dto.response;

import com.bancow.process.constant.InProgress;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginResponseDto {

    private Long id;
    private String phoneNumber;
    private InProgress inProgress;

}
