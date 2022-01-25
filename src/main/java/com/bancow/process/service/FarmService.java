package com.bancow.process.service;

import com.bancow.process.domain.Farm;
import com.bancow.process.domain.FarmFile;
import com.bancow.process.domain.FileType;
import com.bancow.process.dto.*;
<<<<<<< HEAD
=======
import com.bancow.process.dto.PageNumUpdateRequestDto;
import com.bancow.process.domain.InProgress;

import com.bancow.process.dto.FarmFilesCheckDto;
import com.bancow.process.dto.FarmInfoCheckDto;
import com.bancow.process.dto.FarmInfoDto;
import com.bancow.process.dto.RequestDto;
import com.bancow.process.repository.FarmFileRepository;

>>>>>>> 3bbfc9cf9b2f642d4e95f97fd07d2c6f26f573be
import com.bancow.process.repository.FarmRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmService {

    private final FarmRepository farmRepository;
    private final FarmFileRepository farmFileRepository;
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

<<<<<<< HEAD
//    @Transactional
//    @Builder
//    public ResponseStep1 check(Long id) {
//        Farm farm = farmRepository.findById(id).orElseThrow(
//                () -> new NullPointerException("농장이 없습니다. ")
//        );
//
//        // Inprogress가 비어 있다면 null 리턴하고 정보 동의부터 시작
//        if (farm.getInProgress() == null) {
//            return null;
//        }
//
//        if (farm.getInProgress().equals("STEP1_COMPLETED")) {
//            ResponseStep1 responseStep1 = new ResponseStep1(
//                    farm.getPageNum(),
//                    farm.getFarmName(),
//                    farm.getFarmAddress(),
//                    farm.getFodder(),
//                    farm.getIdentification(),
//                    farm.getOwnFarm(),
//                    farm.getBreedingType(),
//                    farm.getPopulation(),
//                    farm.getLivestockFarmingBusinessRegistration(),
//                    farm.getFacilitiesStructure(),
//                    farm.getAnnualFodderCostSpecification(),
//                    farm.getAnnualInspectionReport(),
//                    farm.getBusinessLicense()
//            );
//            return responseStep1;
//        }
//        if (farm.getInProgress().equals("STEP2_COMPLETED")) {
//            List<ResponseStep2> responseStep2List = new ArrayList<>();
//
//        }
//
//    }

    public void updateFarmAgreement(Long id, FarmAgreementDto farmAgreementDto){
=======
    @Transactional
    @Builder
    public Object check(Long id){
>>>>>>> 3bbfc9cf9b2f642d4e95f97fd07d2c6f26f573be
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );

<<<<<<< HEAD
        farm.updateFarmAgreement(
                farmAgreementDto.getServiceTerms1(),
                farmAgreementDto.getServiceTerms2(),
                farmAgreementDto.getServiceTerms3(),
                farmAgreementDto.getPageNum());
    }

    public void updateFarmOwnerInfo(Long id, FarmOwnerInfoDto farmOwnerInfoDto){
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );

        farm.updateFarmOwnerInfo(
                farmOwnerInfoDto.getName(),
                farmOwnerInfoDto.getEmail(),
                farmOwnerInfoDto.getPageNum());
=======
        // Inprogress가 비어 있다면 null 리턴하고 정보 동의부터 시작
        if(farm.getInProgress() == null){
            return null;
        }

        if(farm.getInProgress().equals("STEP1_COMPLETED")){
            ResponseStep1 responseStep1 = new ResponseStep1(
                    farm.getPageNum(),
                    farm.getFarmName(),
                    farm.getFarmAddress(),
                    farm.getFodder(),
                    farm.getIdentification(),
                    farm.getOwnFarm(),
                    farm.getBreedingType(),
                    farm.getPopulation(),
                    farm.getLivestockFarmingBusinessRegistration(),
                    farm.getFacilitiesStructure(),
                    farm.getAnnualFodderCostSpecification(),
                    farm.getAnnualInspectionReport(),
                    farm.getBusinessLicense()
            );
            return responseStep1;
        }
        if(farm.getInProgress().equals("STEP2_COMPLETED")){

            FarmFile farmfile = farmFileRepository.findByFarmId(id);





        }
        return null;
>>>>>>> 3bbfc9cf9b2f642d4e95f97fd07d2c6f26f573be
    }

    public void updateFarmInfo(Long id, FarmInfoDto farmInfoDto) {
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );

        farm.updateFarmInfo(farmInfoDto.getFarmName(),
                farmInfoDto.getFarmAddress(),
                farmInfoDto.getFodder(),
                farmInfoDto.getPageNum());

    }

<<<<<<< HEAD

    public void updateFarmInfoCheck(Long id, FarmInfoCheckDto farmInfoCheckDto){
=======
    public void updateFarmInfoCheck(Long id, FarmInfoCheckDto farmInfoCheckDto) {
>>>>>>> 3bbfc9cf9b2f642d4e95f97fd07d2c6f26f573be
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );
        farm.updateFarmInfoCheck(
                farmInfoCheckDto.getIdentification(),
                farmInfoCheckDto.getOwnFarm(),
                farmInfoCheckDto.getBreedingType(),
                farmInfoCheckDto.getPopulation(),
                farmInfoCheckDto.getPageNum());
    }

    public void updateFarmFilesCheck(Long id, FarmFilesCheckDto farmFilesCheckDto) {
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );
        farm.updateFilesInfoCheck(farmFilesCheckDto.getLivestockFarmingBusinessRegistration(),
                farmFilesCheckDto.getFacilitiesStructure(),
                farmFilesCheckDto.getAnnualFodderCostSpecification(),
                farmFilesCheckDto.getAnnualInspectionReport(),
                farmFilesCheckDto.getBusinessLicense(),
                farmFilesCheckDto.getPageNum());
    }

    public void updateInvestigationRequest(Long farmId, InvestigationRequestUpdateRequestDto investigationRequestUpdateRequestDto) {
        Farm farm = farmRepository.findById(farmId).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + farmId)
        );

        farm.updateInvestigationRequest(investigationRequestUpdateRequestDto.getPageNum(),
                investigationRequestUpdateRequestDto.getInvestigationRequest());
    }

    public void updateInProgress(Long farmId, InProgressUpdateRequestDto inProgressUpdateRequestDto) {
        Farm farm = farmRepository.findById(farmId).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + farmId)
        );

        farm.updateInProgress(inProgressUpdateRequestDto.getPageNum(),
                              inProgressUpdateRequestDto.getInProgress());
    }

}
