package com.bancow.process.dto;

import com.bancow.process.domain.FileType;
import com.bancow.process.domain.InProgress;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class InProgressUpdateRequestDto {

    @NotNull
    private Long pageNum;

    @NotBlank
    private InProgress inProgress;

    @Builder
    public InProgressUpdateRequestDto(Long pageNum, InProgress inProgress) {
        this.pageNum = pageNum;
        this.inProgress = inProgress;
    }
}
