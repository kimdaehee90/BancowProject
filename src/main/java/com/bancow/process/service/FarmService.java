package com.bancow.process.service;


import com.bancow.process.domain.Farm;
import com.bancow.process.dto.FarmInfoDto;
import com.bancow.process.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmService {
    private final FarmRepository farmRepository;

    public void putFarmInfo(Long id, FarmInfoDto farmInfoDto){

        Farm farm = farmRepository.findById(id).orElseThrow();
        farm.putFarmInfo(farmInfoDto);


    }

}
