package com.bancow.process.dto;

import com.bancow.process.domain.FileType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseStep2 {
    private List<FileType> fileType;
}
