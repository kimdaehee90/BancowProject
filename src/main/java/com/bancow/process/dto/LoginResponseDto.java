package com.bancow.process.dto;

import com.bancow.process.domain.InProgress;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginResponseDto {

    private Long id;
    private String phoneNumber;
    private InProgress inProgress;

}
