package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmFileCheckDto {
    private Long id;
    private Boolean livestockFarmingBusinessRegistration;
    private Boolean facilitiesStructure;
    private Boolean annualFodderCostSpecification;
    private Boolean annualInspectionReport;
    private Boolean businessLicense;
    private Boolean pageNum;
}
