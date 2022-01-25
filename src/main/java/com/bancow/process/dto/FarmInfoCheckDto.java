package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class FarmInfoCheckDto {
    private Long id;
    private String identification;
    private String ownFarm;
    private String breedingType;
    private String population;
    private Long pageNum;

    @Builder
    public void FarmInfoCheckDto(String identification, String ownFarm, String breedingType,
                                 String population, Long pageNum){
        this.identification = identification;
        this.ownFarm = ownFarm;
        this.breedingType = breedingType;
        this.population = population;
        this.pageNum = pageNum;
    }


}
