package com.bancow.process.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FarmAgreementDto {
    private Long id;
    private Boolean serviceTerms1;
    private Boolean serviceTerms2;
    private Boolean serviceTerms3;
    private Long pageNum;

    @Builder
    public void FarmAgreementDto(Boolean serviceTerms1, Boolean serviceTerms2, Boolean serviceTerms3, Long pageNum){
        this.serviceTerms1 = serviceTerms1;
        this.serviceTerms2 = serviceTerms2;
        this.serviceTerms3 = serviceTerms3;
        this.pageNum = pageNum;
    }


}
