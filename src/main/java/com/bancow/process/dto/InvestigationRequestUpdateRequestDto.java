package com.bancow.process.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class InvestigationRequestUpdateRequestDto {

    private Long pageNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime investigationRequest;

    @Builder
    public InvestigationRequestUpdateRequestDto(Long pageNum,
                                                LocalDateTime investigationRequest) {
        this.pageNum = pageNum;
        this.investigationRequest = investigationRequest;
    }
}
