package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmInfoCheckDto {
    private Long id;
    private String indentification;
    private String ownFarm;
    private String breedingType;
    private String population;
    private Long pageNum;

}
