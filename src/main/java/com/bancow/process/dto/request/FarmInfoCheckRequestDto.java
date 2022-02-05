package com.bancow.process.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class FarmInfoCheckRequestDto {

    @NotNull
    private Boolean identification;

    @NotNull
    private Boolean ownFarm;

    @NotBlank
    private String breedingType;

    @NotBlank
    private String population;

    @NotNull
    private Long pageNum;

}
