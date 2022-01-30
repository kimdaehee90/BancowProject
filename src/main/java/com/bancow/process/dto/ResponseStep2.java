package com.bancow.process.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseStep2 {
    private Long id;
    private List<FarmFileTypeResponseDto> farmFiles;

    public ResponseStep2(Long id, List<FarmFileTypeResponseDto> farmFiles) {
        this.id = id;
        this.farmFiles = farmFiles;
    }
}
