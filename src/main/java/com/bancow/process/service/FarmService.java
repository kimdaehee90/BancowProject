package com.bancow.process.service;

import com.bancow.process.domain.Farm;
import com.bancow.process.dto.*;
import com.bancow.process.dto.PageNumUpdateRequestDto;
import com.bancow.process.domain.InProgress;
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
    @Builder
    public ResponseStep1 check(Long id){
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new NullPointerException("농장이 없습니다. ")
        );

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
            List<ResponseStep2> responseStep2List = new ArrayList<>();

        }
        return null;
    }

    public void updateFarmInfo(Long id, FarmInfoDto farmInfoDto) {
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );
        farm.updateFarmInfo(farmInfoDto);

    }

    public void updateFarmInfoCheck(Long id, FarmInfoCheckDto farmInfoCheckDto) {
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );
        farm.updateFarmInfoCheck(farmInfoCheckDto);
    }

    public void updateFarmFilesCheck(Long id, FarmFilesCheckDto farmFilesCheckDto) {
        Farm farm = farmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + id)
        );
        farm.updateFilesInfoCheck(farmFilesCheckDto);
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
