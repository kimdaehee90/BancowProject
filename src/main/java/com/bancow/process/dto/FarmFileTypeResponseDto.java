package com.bancow.process.dto;

import com.bancow.process.domain.FileType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmFileTypeResponseDto {
    private FileType fileType;

//    public static FarmFileTypeResponseDto from(FileType type){
//        return FarmFileTypeResponseDto.builder()
//                .fileType(type)
//                .build();
//    }
}
