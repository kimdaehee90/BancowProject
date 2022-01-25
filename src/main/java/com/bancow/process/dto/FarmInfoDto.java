package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FarmInfoDto {
    private Long id;
    private String farmName;
    private String farmAddress;
    private String fodder;
    private Long pageNum;

    @Builder
    public void FarmInfoDto(String farmName, String farmAddress, String fodder, Long pageNum){
        this.farmName = farmName;
        this.farmAddress = farmAddress;
        this.fodder = fodder;
        this.pageNum = pageNum;
    }


}
