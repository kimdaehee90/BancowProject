package com.bancow.process.dto.response;

import com.bancow.process.constant.InProgress;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class InprogressResponseDto {

    private Long id;
    private InProgress inProgress;

    public InprogressResponseDto(Long id, InProgress inProgress) {
        this.id = id;
        this.inProgress = inProgress;
    }
}
