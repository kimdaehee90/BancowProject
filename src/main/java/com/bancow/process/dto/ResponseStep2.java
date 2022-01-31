package com.bancow.process.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseStep2 {
    private Long id;
    private List<FarmFileTypeResponseDto> farmFile;

    public ResponseStep2(Long id, List<FarmFileTypeResponseDto> farmFile) {
        this.id = id;
        this.farmFile = farmFile;
    }
}
