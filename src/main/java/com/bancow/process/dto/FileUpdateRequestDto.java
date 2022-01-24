package com.bancow.process.dto;

import com.bancow.process.domain.FileType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FileUpdateRequestDto {

    private String originalFileName;
    private String changedFileName;
    private String fileUrl;
    private FileType fileType;

    @Builder
    public FileUpdateRequestDto(String originalFileName, String changedFileName, String fileUrl, FileType fileType) {
        this.originalFileName = originalFileName;
        this.changedFileName = changedFileName;
        this.fileUrl = fileUrl;
        this.fileType = fileType;

    }
}

