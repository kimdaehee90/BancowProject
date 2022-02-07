package com.bancow.process.dto.request;

import com.bancow.process.constant.InProgress;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class InprogressRequestDto {

    private Long id;
    private InProgress inProgress;

    public InprogressRequestDto(Long id, InProgress inProgress) {
        this.id = id;
        this.inProgress = inProgress;
    }
}
