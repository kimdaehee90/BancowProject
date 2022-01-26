package com.bancow.process.dto;

import com.bancow.process.domain.FileType;
import com.bancow.process.domain.InProgress;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InProgressUpdateRequestDto {

    private Long pageNum;
    private InProgress inProgress;

    @Builder
    public InProgressUpdateRequestDto(Long pageNum, InProgress inProgress) {
        this.pageNum = pageNum;
        this.inProgress = inProgress;
    }
}
