package com.bancow.process.service;

import com.bancow.process.domain.Farm;
import com.bancow.process.dto.*;
import com.bancow.process.domain.InProgress;
import com.bancow.process.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmService {

    private final FarmRepository farmRepository;
    private final CertificationService certificationService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void join(String userName) {

        // userName으로 번호가 있는지 조회
        Optional<Farm> user = farmRepository.findByUserName(userName);

        //인증번호 생성
        Random rand = new Random();
        String numStr = "";
        for (int i = 0; i < 4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr += ran;
        }

        // 생성한 랜덤 인증번호를 인코딩
        String password = passwordEncoder.encode(numStr);

        if (user.isEmpty()) {
            //farm 객체 생성해서 userName과 인코딩한 password 저장
            Farm farm = new Farm(userName, password);
            farmRepository.save(farm);

        } else {
            Farm farm = user.get();
            farm.updateFarm(password);
            farmRepository.save(farm);

        }

        // userName(폰 번호)과 인증번호 발송
        certificationService.certifiedPhoneNumber(userName, numStr);

    }

    @Transactional
    public void createFarm(RequestDto requestDto) {
        farmRepository.save(requestDto.toEntity());
    }


    @Transactional
    public void updatePageNum(Long farmId, PageNumUpdateRequestDto pageNumUpdateRequestDto) {
        Farm farm = farmRepository.findById(farmId).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + farmId)
        );

        farm.updatePageNum(pageNumUpdateRequestDto.getPageNum());

    }

    @Transactional
    public void login(RequestDto requestDto) {

    }

    @Transactional
    public void check(Long id) {
        Optional<Farm> farm = farmRepository.findById(id);

        InProgress farmInprogress = farm.get().getInProgress();

        if (farmInprogress == null) {

        }

    }

    public void updateFarmInfo(Long id, FarmInfoDto farmInfoDto) {
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new NullPointerException("농장이 없습니다.")
        );

        farm.setFarmName(farmInfoDto.getFarmName());
        farm.setFarmAddress(farmInfoDto.getFarmAddress());
        farm.setFodder(farmInfoDto.getFodder());
        farm.setPageNum(farmInfoDto.getPageNum());
        farmRepository.save(farm);
    }

    public void updateFarmInfoCheck(Long id, FarmInfoCheckDto farmInfoCheckDto) {
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new NullPointerException("농장이 없습니다.")
        );

        farm.setIdentification(farmInfoCheckDto.getIndentification());
        farm.setOwnFarm(farmInfoCheckDto.getOwnFarm());
        farm.setBreedingType(farmInfoCheckDto.getBreedingType());
        farm.setPopulation(farmInfoCheckDto.getPopulation());
        farm.setPageNum(farmInfoCheckDto.getPageNum());

        farmRepository.save(farm);
    }

    public void updateFarmFilesCheck(Long id, FarmFilesCheckDto farmFilesCheckDto) {
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new NullPointerException("농장이 없습니다.")
        );

        farm.setLivestockFarmingBusinessRegistration(farmFilesCheckDto.getLivestockFarmingBusinessRegistration());
        farm.setFacilitiesStructure(farmFilesCheckDto.getFacilitiesStructure());
        farm.setAnnualFodderCostSpecification(farmFilesCheckDto.getAnnualFodderCostSpecification());
        farm.setAnnualInspectionReport(farmFilesCheckDto.getAnnualInspectionReport());
        farm.setBusinessLicense(farmFilesCheckDto.getBusinessLicense());
        farm.setPageNum(farmFilesCheckDto.getPageNum());

        farmRepository.save(farm);
    }

    public void updateInvestigationRequest(Long farmId, InvestigationRequestUpdateRequestDto investigationRequestUpdateRequestDto) {
        Farm farm = farmRepository.findById(farmId).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + farmId)
        );

        farm.updateInvestigationRequest(investigationRequestUpdateRequestDto.getPageNum(),
                investigationRequestUpdateRequestDto.getInvestigationRequest());
    }

}
