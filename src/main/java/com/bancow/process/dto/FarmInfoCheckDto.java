package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmInfoCheckDto {
    private String identification;
    private String ownFarm;
    private String breedingType;
    private String population;
    private Long pageNum;

}
