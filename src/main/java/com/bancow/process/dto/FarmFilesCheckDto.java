package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmFilesCheckDto {
    @NotNull
    private Boolean livestockFarmingBusinessRegistration;
    @NotNull
    private Boolean facilitiesStructure;
    @NotNull
    private Boolean annualFodderCostSpecification;
    @NotNull
    private Boolean annualInspectionReport;
    @NotNull
    private Boolean businessLicense;
    @NotNull
    private Long pageNum;

}
