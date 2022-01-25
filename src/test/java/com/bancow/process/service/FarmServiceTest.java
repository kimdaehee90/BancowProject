package com.bancow.process.service;

import com.bancow.process.domain.Farm;
import com.bancow.process.dto.FarmFilesCheckDto;
import com.bancow.process.dto.FarmInfoCheckDto;
import com.bancow.process.dto.FarmInfoDto;
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
    public void updateFarmInfoTest(){

        FarmInfoDto testDto = new FarmInfoDto();
        testDto.builder()
                .farmName("농장이름")
                .farmAddress("농장주소")
                .fodder("사료")
                .pageNum(2L)
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
                .pageNum(3L)
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
                .pageNum(4L)
                .build();

        farmService.updateFarmFilesCheck(1L, testDto);

        System.out.println(farmRepository.findAll());

    }
}
