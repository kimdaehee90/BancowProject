package com.bancow.process.dto;

import com.bancow.process.domain.FarmFile;
import com.bancow.process.constant.FileType;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FarmFileTypeResponseDto {

    private Long farmFileId;
    private FileType fileType;

    public FarmFileTypeResponseDto(FarmFile o) {
        this.farmFileId = o.getId();
        this.fileType = o.getFileType();
    }
}
