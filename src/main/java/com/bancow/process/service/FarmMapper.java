package com.bancow.process.service;

import com.bancow.process.domain.Farm;
import com.bancow.process.domain.FarmFile;
import com.bancow.process.domain.FarmImage;
import com.bancow.process.dto.response.FarmFileTypeResponseDto;
import com.bancow.process.dto.response.FarmImageResponseDto;
import com.bancow.process.dto.response.Step1ResponseDto;
import com.bancow.process.dto.response.Step2ResponseDto;
import com.bancow.process.repository.FarmFileRepository;
import com.bancow.process.repository.FarmImageRepository;
import com.bancow.process.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FarmMapper {

    private final FarmImageRepository farmImageRepository;
    private final FarmRepository farmRepository;
    private final FarmFileRepository farmFileRepository;

    public Step1ResponseDto createResponseStep1FarmEntity(Farm farm){

        List<FarmImage> farmImageList = farmImageRepository.findByFarmId(farm.getId());

        return new Step1ResponseDto(
                farm.getId(),
                farm.getPageNum(),
                farm.getFarmName(),
                farm.getName(),
                farm.getEmail(),
                farm.getFarmAddress(),
                farm.getFarmPostCode(),
                farm.getFodder(),
                farm.getIdentification(),
                farm.getOwnFarm(),
                farm.getBreedingType(),
                farm.getPopulation(),
                farm.getCctv(),
                farm.getLivestockFarmingBusinessRegistration(),
                farm.getFacilitiesStructure(),
                farm.getAnnualFodderCostSpecification(),
                farm.getAnnualInspectionReport(),
                farm.getBusinessLicense(),
                farmImageList.stream().map(o -> new FarmImageResponseDto(o))
                        .collect(Collectors.toList())
        );
    }

    public Step2ResponseDto createResponseStep2FarmEntity(Farm farm){

        List<FarmFile> farmFileList = farmFileRepository.findByFarmId(farm.getId());

        return new Step2ResponseDto(
                farm.getId(),
                farmFileList.stream().map(o -> new FarmFileTypeResponseDto(o))
                        .collect(Collectors.toList())
        );

    }
}
