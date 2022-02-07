package com.bancow.process.service;

import com.bancow.process.constant.InProgress;
import com.bancow.process.domain.Farm;
import com.bancow.process.dto.request.*;
import com.bancow.process.dto.response.*;
import com.bancow.process.repository.FarmFileRepository;
import com.bancow.process.repository.FarmImageRepository;
import com.bancow.process.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

import static com.bancow.process.util.LocalDateTimeConverter.*;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmService {

    private final FarmRepository farmRepository;
    private final FarmFileRepository farmFileRepository;
    private final CertificationService certificationService;
    private final PasswordEncoder passwordEncoder;
    private final FarmImageRepository farmImageRepository;
    private final FarmMapper farmMapper;


    @Transactional
    public PasswordResponseDto join(String phoneNumber) {

        // userName으로 번호가 있는지 조회
        Optional<Farm> user = farmRepository.findByPhoneNumber(phoneNumber);

        //인증번호 생성z
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
            Farm farm = new Farm(phoneNumber, password);
            farmRepository.save(farm);

        } else {
            Farm farm = user.get();
            farm.updateFarm(password);
            farmRepository.save(farm);

        }

        // userName(폰 번호)과 인증번호 발송
        certificationService.certifiedPhoneNumber(phoneNumber, numStr);

        PasswordResponseDto passwordResponseDto = new PasswordResponseDto(numStr);

        return passwordResponseDto;
    }

    @Transactional
    public void updatePageNum(Long farmId, PageNumUpdateRequestDto pageNumUpdateRequestDto) {
        Farm farm = farmRepository.findById(farmId).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + farmId)
        );

        farm.updatePageNum(pageNumUpdateRequestDto.getPageNum());

    }

//    @Transactional
//    @Builder
//    public Object check(String phoneNumber){
//
//        Farm farm = farmRepository.findByPhoneNumber(phoneNumber).orElseThrow(
//                () -> new NullPointerException("농장이 없습니다. ")
//        );
//
//        if(InProgress.getStep1InProgressList().contains(farm.getInProgress())){
//            return  farmMapper.createResponseStep1FarmEntity(farm.getId());
//        }
//
//        if(InProgress.getStep2InProgressList().contains(farm.getInProgress())){
//             return farmMapper.createResponseStep2FarmEntity(farm.getId());
//        }
//
//        LoginResponseDto loginResponseDto = new LoginResponseDto(farm.getId(),farm.getPhoneNumber(),farm.getInProgress());
//        return loginResponseDto;
//    }
    public Step1ResponseDto getStep1(InProgressRequestDto inProgressRequestDto){

        Farm farm = farmRepository.findById(inProgressRequestDto.getId()).orElseThrow(
                () -> new NullPointerException("농장이 없습니다. ")
        );

        if(InProgress.getStep1InProgressList().contains(inProgressRequestDto.getInProgress())){
            return farmMapper.createResponseStep1FarmEntity(inProgressRequestDto.getId());
        }else
            throw new IllegalArgumentException("잘못된 inprogress 입니다. ");

    }
    public Step2ResponseDto getStep2(InProgressRequestDto inProgressRequestDto) {

        Farm farm = farmRepository.findById(inProgressRequestDto.getId()).orElseThrow(
                () -> new NullPointerException("농장이 없습니다. ")
        );

        if(InProgress.getStep2InProgressList().contains(inProgressRequestDto.getInProgress())){
            return farmMapper.createResponseStep2FarmEntity(inProgressRequestDto.getId());
        }else
            throw new IllegalArgumentException("잘못된 inprogress 입니다. ");
    }

    public void updateFarmAgreement(Long id, FarmAgreementRequestDto farmAgreementDto){

        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );

        farm.updateFarmAgreement(
                farmAgreementDto.getServiceTerms1(),
                farmAgreementDto.getServiceTerms2(),
                farmAgreementDto.getServiceTerms3(),
                farmAgreementDto.getPageNum());
    }

    public void updateFarmOwnerInfo(Long id, FarmOwnerInfoRequestDto farmOwnerInfoDto) {
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );

        farm.updateFarmOwnerInfo(
                farmOwnerInfoDto.getName(),
                farmOwnerInfoDto.getEmail(),
                farmOwnerInfoDto.getPageNum());
    }

    public void updateFarmInfo(Long id, FarmInfoRequestDto farmInfoDto) {
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );

        farm.updateFarmInfo(farmInfoDto.getFarmName(),
                farmInfoDto.getFarmAddress(),
                extractProvince(farmInfoDto),
                farmInfoDto.getFarmPostCode(),
                farmInfoDto.getFodder(),
                farmInfoDto.getPageNum());

    }

    public void updateFarmInfoCheck(Long id, FarmInfoCheckRequestDto farmInfoCheckDto) {

        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );
        farm.updateFarmInfoCheck(
                farmInfoCheckDto.getIdentification(),
                farmInfoCheckDto.getOwnFarm(),
                farmInfoCheckDto.getBreedingType(),
                farmInfoCheckDto.getPopulation(),
                farmInfoCheckDto.getCctv(),
                farmInfoCheckDto.getPageNum());
    }

    public void updateFarmFilesCheck(Long id, FarmFilesCheckRequestDto farmFilesCheckDto) {
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
                LocalDateToLocalDateTime(investigationRequestUpdateRequestDto.getInvestigationRequest()));
    }

    public void updateInProgress(Long farmId, InProgressUpdateRequestDto inProgressUpdateRequestDto) {
        Farm farm = farmRepository.findById(farmId).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + farmId)
        );

        farm.updateInProgress(inProgressUpdateRequestDto.getPageNum(),
                              inProgressUpdateRequestDto.getInProgress());
    }

    public void creatFarm(LoginRequestDto loginRequestDto){
        String password = passwordEncoder.encode(loginRequestDto.getPassword());
        Farm farm = new Farm(loginRequestDto.getPhoneNumber(),password);
        farmRepository.save(farm);
    }

    public String extractProvince(FarmInfoRequestDto farmInfoDto){
        return farmInfoDto.getFarmAddress().substring(0, 2);
    }

    public InProgressResponseDto getInprogress(String phoneNumber) {
        Farm farm = farmRepository.findByPhoneNumber(phoneNumber).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. phoneNumber =" + phoneNumber)
        );
        InProgressResponseDto inProgressResponseDto = new InProgressResponseDto(farm.getId(), farm.getInProgress(),farm.getPageNum());
        return inProgressResponseDto;
    }
}
