package com.bancow.process.dto.request;

import com.bancow.process.constant.InProgress;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class InProgressRequestDto {

    private Long id;
    private InProgress inProgress;

    public InProgressRequestDto(Long id, InProgress inProgress) {
        this.id = id;
        this.inProgress = inProgress;
    }
}
