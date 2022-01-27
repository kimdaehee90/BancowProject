package com.bancow.process.dto;

import com.bancow.process.domain.FarmFile;
import com.bancow.process.domain.FileType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmFileTypeResponseDto {
    private FileType fileType;

    public FarmFileTypeResponseDto(FarmFile farmFile) {
        fileType = farmFile.getFileType();
    }
//    public static FarmFileTypeResponseDto from(FileType type){
//        return FarmFileTypeResponseDto.builder()
//                .fileType(type)
//                .build();
//    }
}
