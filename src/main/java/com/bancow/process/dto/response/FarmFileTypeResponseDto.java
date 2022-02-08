package com.bancow.process.dto.response;

import com.bancow.process.constant.FileType;
import com.bancow.process.domain.FarmFile;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FarmFileTypeResponseDto {

    private Long farmFileId;
    private FileType fileType;

    public FarmFileTypeResponseDto(FarmFile farmFile) {
        this.farmFileId = farmFile.getId();
        this.fileType = farmFile.getFileType();
    }
}
