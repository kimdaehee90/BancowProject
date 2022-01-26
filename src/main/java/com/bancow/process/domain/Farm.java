package com.bancow.process.domain;

import com.bancow.process.dto.FarmInfoDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "farm")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 전화번호(필드이름 대체 예정)
    @Column(name = "phone_number")
    private String userName;

    // 인증번호(필드이름 대체 예정)
    private String password;

    // 이용 약관 동의
    @Column(name = "service_terms1")
    private Boolean serviceTerms1;

    // 개인정보 취금 위탁 동의
    @Column(name = "service_terms2")
    private Boolean serviceTerms2;

    // 개인정보 선택/수집 이용
    @Column(name = "service_terms3")
    private Boolean serviceTerms3;

    // 이메일
    @Column(name = "email")
    private String email;

    // 페이지 저장
    @Column(name = "page_num")
    private Long pageNum;


    // 농장주 이름
    @Column(name = "name")
    private String name;

    // 사료
    @Column(name = "fodder")
    private String fodder;

    // 농장 주소
    @Column(name = "farm_address")
    private String farmAddress;

    // 농장 이름
    @Column(name = "farm_name")
    private String farmName;


    // 농장주 본인 확인
    @Column(name = "identification")
    private String identification;

    // 농장 자가 조사
    @Column(name = "own_farm")
    private String ownFarm;

    // 농장 사육 형태 조사
    @Column(name = "breeding_type")
    private String breedingType;

    // 가축의 수
    @Column(name = "population")
    private String population;


    // 가축 사육업 등록증 유무
    @Column(name = "livestock_farming_business_registration")
    private Boolean livestockFarmingBusinessRegistration;

    // 축사시설 구조도 유무
    @Column(name = "facilities_structure")
    private Boolean facilitiesStructure;

    // 1년간 사료비 명세서 유무
    @Column(name = "annual_fodder_cost_specification")
    private Boolean annualFodderCostSpecification;

    // 1년간 출하 성적서 유무
    @Column(name = "annual_inspection_report")
    private Boolean annualInspectionReport;

    // 사업자 등록증 유무
    @Column(name = "business_license")
    private Boolean businessLicense;


    // 입점 상태
    @Enumerated(EnumType.STRING)
    @Column(name = "in_progress")
    private InProgress inProgress;

    // 1차 제출 완료
    @Column(name = "step1_completed")
    private LocalDateTime step1Completed;

    // 2차 제출 완료
    @Column(name = "step2_completed")
    private LocalDateTime step2Completed;

    // 실사 요청일
    @Column(name = "investigation_request")
    private LocalDateTime investigationRequest;

    // 실사 확정일
    @Column(name = "investigation_confirm")
    private LocalDateTime investigationConfirm;

    // 입점 완료
    @Column(name = "process_done")
    private LocalDateTime processDone;


    @JsonBackReference
    @OneToMany(mappedBy = "farm", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FarmImage> farmImage = new ArrayList<>();


    @JsonBackReference
    @OneToMany(mappedBy = "farm", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FarmFile> farmFile = new ArrayList<>();

    @Builder
    public Farm(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void updateFarm(String password) {
        this.password = password;
    }

    public void updatePageNum(Long pageNum) {
        this.pageNum = pageNum;
    }
    public void updateInvestigationRequest(Long pageNum, LocalDateTime investigationRequest) {
        this.pageNum = pageNum;
        this.investigationRequest = investigationRequest;
    }

    public void updateFarmAgreement(Boolean serviceTerms1, Boolean serviceTerms2, Boolean serviceTerms3, Long pageNum){
        this.serviceTerms1 = serviceTerms1;
        this.serviceTerms2 = serviceTerms2;
        this.serviceTerms3 = serviceTerms3;
        this.pageNum = pageNum;
    }

    public void updateFarmOwnerInfo(String name, String email, Long pageNum){
        this.name = name;
        this.email = email;
        this.pageNum = pageNum;
    }

    public void updateFarmInfo(String farmName, String farmAddress, String fodder, Long pageNum) {
        this.farmName = farmName;
        this.farmAddress = farmAddress;
        this.fodder = fodder;
        this.pageNum = pageNum;
    }


    public void updateFarmInfo(FarmInfoDto farmInfoDto){
        this.farmName = farmInfoDto.getFarmName();
        this.farmAddress = farmInfoDto.getFarmAddress();
        this.fodder = farmInfoDto.getFodder();
        this.pageNum = farmInfoDto.getPageNum();
    }

    public void updateFarmInfoCheck(String identification, String ownFarm, String breedingType, String population, Long pageNum){
        this.identification = identification;
        this.ownFarm = ownFarm;
        this.breedingType = breedingType;
        this.population = population;
        this.pageNum = pageNum;
    }

    public void updateFilesInfoCheck(Boolean livestockFarmingBusinessRegistration, Boolean facilitiesStructure,
                                     Boolean annualFodderCostSpecification, Boolean annualInspectionReport,
                                     Boolean businessLicense, Long pageNum){
        this.livestockFarmingBusinessRegistration = livestockFarmingBusinessRegistration;
        this.facilitiesStructure = facilitiesStructure;
        this.annualFodderCostSpecification = annualFodderCostSpecification;
        this.annualInspectionReport = annualInspectionReport;
        this.businessLicense = businessLicense;
        this.pageNum = pageNum;
    }

    public void updateInProgress(Long pageNum, InProgress inProgress) {
        this.pageNum = pageNum;
        this.inProgress = inProgress;
    }
}
