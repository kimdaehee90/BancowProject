package com.bancow.process.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseStep1 {

    private Long id;
    private Long pageNum;
    private String farmName;
    private String name;
    private String email;
    private String farmAddress;
    private String farmPostCode;
    private String fodder;
    private String identification;
    private String ownFarm;
    private String breedingType;
    private String population;
    private Boolean livestockFarmingBusinessRegistration;
    private Boolean facilitiesStructure;
    private Boolean annualFodderCostSpecification;
    private Boolean annualInspectionReport;
    private Boolean businessLicense;
    private List<FarmImageResponseDto> farmImageUrl;
//    private List<FarmImageResponseDto> farmImage;
    public ResponseStep1(Long id,Long pageNum, String farmName, String name, String email, String farmAddress, String farmPostCode,String fodder,
                         String identification, String ownFarm, String breedingType,
                         String population, Boolean livestockFarmingBusinessRegistration,
                         Boolean facilitiesStructure, Boolean annualFodderCostSpecification,
                         Boolean annualInspectionReport, Boolean businessLicense,
                         List<FarmImageResponseDto> farmImageUrl) {
        this.id = id;
        this.pageNum = pageNum;
        this.farmName = farmName;
        this.name = name;
        this.email = email;
        this.farmAddress = farmAddress;
        this.farmPostCode = farmPostCode;
        this.fodder = fodder;
        this.identification = identification;
        this.ownFarm = ownFarm;
        this.breedingType = breedingType;
        this.population = population;
        this.livestockFarmingBusinessRegistration = livestockFarmingBusinessRegistration;
        this.facilitiesStructure = facilitiesStructure;
        this.annualFodderCostSpecification = annualFodderCostSpecification;
        this.annualInspectionReport = annualInspectionReport;
        this.businessLicense = businessLicense;
//        this.farmImageUrl = farmImageUrl;
        this.farmImageUrl = farmImageUrl;
    }

}
