package com.bancow.process.service;

import com.bancow.process.domain.Farm;
import com.bancow.process.domain.FarmFile;
import com.bancow.process.domain.FarmImage;
import com.bancow.process.dto.*;
import com.bancow.process.repository.FarmFileRepository;
import com.bancow.process.repository.FarmImageRepository;
import com.bancow.process.repository.FarmRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

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

    @Transactional
    public void join(String phoneNumber) {

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

    }

    @Transactional
    public void updatePageNum(Long farmId, PageNumUpdateRequestDto pageNumUpdateRequestDto) {
        Farm farm = farmRepository.findById(farmId).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + farmId)
        );

        farm.updatePageNum(pageNumUpdateRequestDto.getPageNum());

    }

    @Transactional
    @Builder
    public Object check(String phoneNumber){

        String step1InProgress = "STEP1_IN_PROGRESS";
        String step1Completed = "STEP1_COMPLETED";
        String step2InProgress = "STEP2_IN_PROGRESS";
        String step2Completed = "STEP2_COMPLETED";
        Farm farm = farmRepository.findByPhoneNumber(phoneNumber).orElseThrow(
                () -> new NullPointerException("농장이 없습니다. ")
        );

        System.out.println(phoneNumber);
        // Inprogress가 비어 있다면 null 리턴하고 정보 동의부터 시작
//        if(farm.getInProgress() == null){
//            LoginResponseDto loginResponseDto = new LoginResponseDto(farm.getId(),farm.getPhoneNumber(),farm.getInProgress());
//            return loginResponseDto;
//        }

        if(farm.getInProgress().toString().equals(step1InProgress) || farm.getInProgress().toString().equals(step1Completed)){
           return step1Info(farm.getId());

        }

        if(farm.getInProgress().toString().equals(step2InProgress) || farm.getInProgress().toString().equals(step2Completed) ){

            return step2Info(farm.getId());

        }
        LoginResponseDto loginResponseDto = new LoginResponseDto(farm.getId(),farm.getPhoneNumber(),farm.getInProgress());
        return loginResponseDto;
//        return farm.getInProgress();
    }

    public Step1ResponseDto step1Info(Long id){
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );

        List<FarmImage> farmImageList = farmImageRepository.findByFarmId(id);

        Step1ResponseDto responseStep1 = new Step1ResponseDto(
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
                farm.getLivestockFarmingBusinessRegistration(),
                farm.getFacilitiesStructure(),
                farm.getAnnualFodderCostSpecification(),
                farm.getAnnualInspectionReport(),
                farm.getBusinessLicense(),
                farmImageList.stream().map(o -> new FarmImageResponseDto(o))
                        .collect(Collectors.toList())
        );

        return responseStep1;
    }

    public Step2ResponseDto step2Info(Long id){
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );

        List<FarmFile> farmFileList = farmFileRepository.findByFarmId(id);

        Step2ResponseDto responseStep2 = new Step2ResponseDto(
                farm.getId(),
                farmFileList.stream().map(o -> new FarmFileTypeResponseDto(o))
                        .collect(Collectors.toList())
        );

        return responseStep2;
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
}
