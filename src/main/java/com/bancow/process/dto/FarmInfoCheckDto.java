package com.bancow.process.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
