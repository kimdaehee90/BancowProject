package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmAgreementDto {
    private Boolean serviceTerms1;
    private Boolean serviceTerms2;
    private Boolean serviceTerms3;
    private Long pageNum;
}
