package com.bancow.process.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FarmOwnerInfoDto {
    private Long id;
    private String name;
    private String email;
    private Long pageNum;

    @Builder
    public void FarmAgreementDto(String name, String email, Long pageNum){
        this.name = name;
        this.email = email;
        this.pageNum = pageNum;
    }


}
