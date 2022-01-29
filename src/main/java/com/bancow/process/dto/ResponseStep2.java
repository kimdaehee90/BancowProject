package com.bancow.process.dto;

import com.bancow.process.domain.FarmFile;
import com.bancow.process.domain.FileType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseStep2 {
    private Long id;
    private List<FarmFileTypeResponseDto> farmFiles;

    public ResponseStep2(Long id, List<FarmFileTypeResponseDto> farmFiles) {
        this.id = id;
        this.farmFiles = farmFiles;
    }
}
