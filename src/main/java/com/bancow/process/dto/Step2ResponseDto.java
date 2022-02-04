package com.bancow.process.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Step2ResponseDto {
    private Long id;
    private List<FarmFileTypeResponseDto> farmFile;

    public Step2ResponseDto(Long id, List<FarmFileTypeResponseDto> farmFile) {
        this.id = id;
        this.farmFile = farmFile;
    }
}
