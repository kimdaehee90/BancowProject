package com.bancow.process.dto;

import com.bancow.process.domain.FarmImage;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseStep1 {

    private Long id;
    private Long pageNum;
    private String farmName;
    private String farmAddress;
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
    private List<FarmImageResponseDto> farmImageResponseDtoList;


    public ResponseStep1(Long id,Long pageNum, String farmName, String farmAddress, String fodder,
                         String identification, String ownFarm, String breedingType,
                         String population, Boolean livestockFarmingBusinessRegistration,
                         Boolean facilitiesStructure, Boolean annualFodderCostSpecification,
                         Boolean annualInspectionReport, Boolean businessLicense) {
        this.id = id;
        this.pageNum = pageNum;
        this.farmName = farmName;
        this.farmAddress = farmAddress;
        this.fodder = fodder;
        this.identification = identification;
        this.ownFarm = ownFarm;
        this.breedingType = breedingType;
        this.population = population;
        this.livestockFarmingBusinessRegistration = livestockFarmingBusinessRegistration;
        this.facilitiesStructure = facilitiesStructure;
        this.annualFodderCostSpecification = annualFodderCostSpecification;
        this.annualInspectionReport = annualInspectionReport;
        this.businessLicense = businessLicense
        ;
    }

    public ResponseStep1(Long id,Long pageNum, String farmName, String farmAddress, String fodder,
                         String identification, String ownFarm, String breedingType,
                         String population, Boolean livestockFarmingBusinessRegistration,
                         Boolean facilitiesStructure, Boolean annualFodderCostSpecification,
                         Boolean annualInspectionReport, Boolean businessLicense,
                         List<FarmImageResponseDto> farmImageResponseDtoList) {
        this.id = id;
        this.pageNum = pageNum;
        this.farmName = farmName;
        this.farmAddress = farmAddress;
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
        this.farmImageResponseDtoList = farmImageResponseDtoList;
    }
}
