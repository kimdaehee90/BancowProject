package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmInfoCheckDto {
    @NotBlank
    private String identification;
    @NotBlank
    private String ownFarm;
    @NotBlank
    private String breedingType;
    @NotBlank
    private String population;
    @NotNull
    private Long pageNum;

}
