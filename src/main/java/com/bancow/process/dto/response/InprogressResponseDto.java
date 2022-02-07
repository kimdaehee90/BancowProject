package com.bancow.process.dto.response;

import com.bancow.process.constant.InProgress;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class InprogressResponseDto {

    private Long id;
    private InProgress inProgress;
    private Long pageNum;

    public InprogressResponseDto(Long id, InProgress inProgress, Long pageNum) {
        this.id = id;
        this.inProgress = inProgress;
        this.pageNum = pageNum;
    }

}
