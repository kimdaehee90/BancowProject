package com.bancow.process.dto.response;

import com.bancow.process.constant.InProgress;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class InprogressResponseDto {

    private InProgress inProgress;

    public InprogressResponseDto(InProgress inProgress) {
        this.inProgress = inProgress;
    }
}
