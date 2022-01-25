package com.bancow.process.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageNumUpdateRequestDto {

    private Long pageNum;

    @Builder
    public PageNumUpdateRequestDto(Long pageNum) {
        this.pageNum = pageNum;
    }

}
