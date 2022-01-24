package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmFilesCheckDto {
    private Long id;
    private Boolean livestockFarmingBusinessRegistration;
    private Boolean facilitiesStructure;
    private Boolean annualFodderCostSpecification;
    private Boolean annualInspectionReport;
    private Boolean businessLicense;
    private Long pageNum;

    public void FarmFilesCheck(Boolean livestockFarmingBusinessRegistration, Boolean facilitiesStructure,
                                  Boolean annualFodderCostSpecification, Boolean annualInspectionReport,
                                  Boolean businessLicense, Long pageNum){
        this.livestockFarmingBusinessRegistration = livestockFarmingBusinessRegistration;
        this.facilitiesStructure = facilitiesStructure;
        this.annualFodderCostSpecification = annualFodderCostSpecification;
        this.annualInspectionReport = annualInspectionReport;
        this.businessLicense = businessLicense;
        this.pageNum = pageNum;

    }
}
