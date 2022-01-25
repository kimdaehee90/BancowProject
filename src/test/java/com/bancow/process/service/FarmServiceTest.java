package com.bancow.process.service;

import com.bancow.process.domain.Farm;
import com.bancow.process.dto.*;
import com.bancow.process.repository.FarmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class FarmServiceTest {

    @Autowired
    private FarmService farmService;

    @Autowired
    private FarmRepository farmRepository;

    @Test
    public void updateFarmAgreementTest(){

        FarmAgreementDto testDto = new FarmAgreementDto();
        testDto.builder()
                .serviceTerms1(true)
                .serviceTerms2(true)
                .serviceTerms3(false)
                .pageNum(1L)
                .build();

        farmService.updateFarmAgreement(1L, testDto);

        System.out.println(farmRepository.findAll());
    }

    @Test
    public void updateFarmOwnerInfoTest(){

        FarmOwnerInfoDto testDto = new FarmOwnerInfoDto();
        testDto.builder()
                .name("농장주 이름")
                .email("email@naver.com")
                .pageNum(1L)
                .build();

        farmService.updateFarmOwnerInfo(1L, testDto);

        System.out.println(farmRepository.findAll());
    }

    @Test
    public void updateFarmInfoTest(){

        FarmInfoDto testDto = new FarmInfoDto();
        testDto.builder()
                .farmName("농장이름")
                .farmAddress("농장주소")
                .fodder("사료")
                .pageNum(3L)
                .build();

        farmService.updateFarmInfo(1L, testDto);

        System.out.println(farmRepository.findAll());

    }

    @Test
    public void updateFarmInfoCheckTest(){

        FarmInfoCheckDto testDto = new FarmInfoCheckDto();
        testDto.builder()
                .identification("본인")
                .ownFarm("자가")
                .breedingType("비육")
                .population("100마리 이상")
                .pageNum(4L)
                .build();

        farmService.updateFarmInfoCheck(1L, testDto);

        System.out.println(farmRepository.findAll());

    }

    @Test
    public void updateFarmFilesCheckTest(){

        FarmFilesCheckDto testDto = new FarmFilesCheckDto();
        testDto.builder()
                .livestockFarmingBusinessRegistration(true)
                .facilitiesStructure(true)
                .annualFodderCostSpecification(true)
                .annualInspectionReport(true)
                .businessLicense(true)
                .pageNum(5L)
                .build();

        farmService.updateFarmFilesCheck(1L, testDto);

        System.out.println(farmRepository.findAll());

    }
}
