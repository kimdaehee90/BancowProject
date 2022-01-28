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
public class FarmInfoDto {
    @NotBlank
    private String farmName;
    @NotBlank
    private String farmAddress;
    @NotBlank
    private String fodder;
    @NotNull
    private Long pageNum;

}
