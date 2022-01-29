package com.bancow.process.dto;

import com.bancow.process.domain.FileType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class FileUpdateRequestDto {

    @NotBlank
    private String originalFileName;

    @NotBlank
    private String changedFileName;

    @NotBlank
    private String fileUrl;

    @NotNull
    private FileType fileType;

    @Builder
    public FileUpdateRequestDto(String originalFileName, String changedFileName, String fileUrl, FileType fileType) {
        this.originalFileName = originalFileName;
        this.changedFileName = changedFileName;
        this.fileUrl = fileUrl;
        this.fileType = fileType;

    }
}

