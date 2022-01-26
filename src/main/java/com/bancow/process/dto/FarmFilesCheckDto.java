package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmFilesCheckDto {
    private Boolean livestockFarmingBusinessRegistration;
    private Boolean facilitiesStructure;
    private Boolean annualFodderCostSpecification;
    private Boolean annualInspectionReport;
    private Boolean businessLicense;
    private Long pageNum;

}
