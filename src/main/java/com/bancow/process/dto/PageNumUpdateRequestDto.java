package com.bancow.process.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class PageNumUpdateRequestDto {

    @NotNull
    private Long pageNum;

    @Builder
    public PageNumUpdateRequestDto(Long pageNum) {
        this.pageNum = pageNum;
    }

}
