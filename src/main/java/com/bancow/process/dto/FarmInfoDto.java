package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmInfoDto {
    private Long id;
    private String farmName;
    private String farmAddress;
    private String fodder;
    private Long pageNum;
}
