package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmAgreementDto {
    @NotNull
    private Boolean serviceTerms1;
    @NotNull
    private Boolean serviceTerms2;
    @NotNull
    private Boolean serviceTerms3;
    @NotNull
    private Long pageNum;
}
