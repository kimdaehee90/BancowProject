package com.bancow.process.dto;

import com.bancow.process.domain.FileType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FarmFileTypeResponseDto {
    private FileType fileType;
}
