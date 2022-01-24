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

        Farm farm = new Farm();
        farm.setId(1L);
        farm.setFarmName("농장명");
        farmRepository.save(farm);

        FarmInfoDto testDto = new FarmInfoDto();
        testDto.setFarmName("농장이름");
        testDto.setFarmAddress("농장주소");
        testDto.setFodder("사료");
        testDto.setPageNum(2L);

        farmService.updateFarmInfo(1L, testDto);

        System.out.println(farmRepository.findAll());

    }

    @Test
    public void updateFarmInfoCheckTest(){

//        Farm farm = new Farm();
//        farm.setId(1L);
//        farm.setFarmName("농장명");
//        farmRepository.save(farm);

        FarmInfoCheckDto testDto = new FarmInfoCheckDto();
        testDto.setIndentification("본인");
        testDto.setOwnFarm("자가");
        testDto.setBreedingType("비육");
        testDto.setPopulation("100마리 이상");
        testDto.setPageNum(3L);

        farmService.updateFarmInfoCheck(1L, testDto);

        System.out.println(farmRepository.findAll());

    }

    @Test
    public void updateFarmFilesCheckTest(){

//        Farm farm = new Farm();
//        farm.setId(1L);
//        farm.setFarmName("농장명");
//        farmRepository.save(farm);

        FarmFilesCheckDto testDto = new FarmFilesCheckDto();
        testDto.setLivestockFarmingBusinessRegistration(true);
        testDto.setFacilitiesStructure(true);
        testDto.setAnnualFodderCostSpecification(true);
        testDto.setAnnualInspectionReport(true);
        testDto.setBusinessLicense(true);
        testDto.setPageNum(4L);

        farmService.updateFarmFilesCheck(1L, testDto);

        System.out.println(farmRepository.findAll());

    }
}
