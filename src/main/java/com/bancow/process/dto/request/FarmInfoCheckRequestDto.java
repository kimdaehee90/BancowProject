package com.bancow.process.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class FarmInfoCheckRequestDto {

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
