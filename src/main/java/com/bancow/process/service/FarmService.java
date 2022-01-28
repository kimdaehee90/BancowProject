package com.bancow.process.service;

import com.bancow.process.domain.Farm;
import com.bancow.process.domain.FileType;
import com.bancow.process.dto.*;
import com.bancow.process.exception.CustomException;
import com.bancow.process.exception.ErrorCode;
import com.bancow.process.repository.FarmFileRepository;
import com.bancow.process.repository.FarmImageRepository;
import com.bancow.process.repository.FarmRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.management.RuntimeErrorException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

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
    @Builder
    public Object check(Long id){

        String step1 = "STEP1_COMPLETED";
        String step2 = "STEP2_COMPLETED";
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new NullPointerException("농장이 없습니다. ")
        );

        // Inprogress가 비어 있다면 null 리턴하고 정보 동의부터 시작
        if(farm.getInProgress() == null){
            return null;
        }

        if(farm.getInProgress().toString().equals(step1)){
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
            List<String> farmImages = farmImageRepository.findUrl(id);
            List<FarmImageResponseDto> collect = farmImages.stream()
                    .map(o -> new FarmImageResponseDto(o))
                    .collect(Collectors.toList());
            HashMap<String,Object> responseMap = new HashMap<>();
            responseMap.put("responseStep1",responseStep1);
            responseMap.put("collect",collect);
            return responseMap;
        }
        if(farm.getInProgress().toString().equals(step2)){

            List<FileType> farmfile = farmFileRepository.fileType(id);
            List<FarmFileTypeResponseDto> collect = farmfile.stream()
                    .map(o -> new FarmFileTypeResponseDto(o))
                    .collect(Collectors.toList());
            return collect;

        }
        return farm.getInProgress();
    }


    public void updateFarmAgreement(Long id, FarmAgreementDto farmAgreementDto){

        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );

        farm.updateFarmAgreement(
                farmAgreementDto.getServiceTerms1(),
                farmAgreementDto.getServiceTerms2(),
                farmAgreementDto.getServiceTerms3(),
                farmAgreementDto.getPageNum());

    }
    public void updateFarmOwnerInfo(Long id, FarmOwnerInfoDto farmOwnerInfoDto) {
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );
        farm.updateFarmOwnerInfo(
                farmOwnerInfoDto.getName(),
                farmOwnerInfoDto.getEmail(),
                farmOwnerInfoDto.getPageNum());
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


    public void updateFarmInfoCheck(Long id, FarmInfoCheckDto farmInfoCheckDto) {

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
