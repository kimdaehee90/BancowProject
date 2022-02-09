package com.bancow.process.controller;

import com.bancow.process.constant.InProgress;
import com.bancow.process.dto.ApiResponseDto;
import com.bancow.process.dto.request.*;
import com.bancow.process.dto.response.InProgressResponseDto;
import com.bancow.process.dto.response.PasswordResponseDto;
import com.bancow.process.dto.response.Step1ResponseDto;
import com.bancow.process.dto.response.Step2ResponseDto;
import com.bancow.process.service.FarmFileService;
import com.bancow.process.service.FarmImageService;
import com.bancow.process.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;
    private final FarmFileService farmFileService;
    private final FarmImageService farmImageService;

    @PostMapping("/api/sendSMS")
    public ApiResponseDto sendUsername(@RequestParam String phoneNumber){
        PasswordResponseDto certificationNumber = farmService.join(phoneNumber);
        return ApiResponseDto.of(certificationNumber);
    }

    @GetMapping("api/farm/checkInProgress/{phoneNumber}")
    public ApiResponseDto checkInprogress(@PathVariable String phoneNumber){
        InProgressResponseDto inProgressResponseDto = farmService.getInprogress(phoneNumber);
        return ApiResponseDto.of(inProgressResponseDto);

    }

    @GetMapping("api/farm/checkStep1")
    public ApiResponseDto checkStep1(@RequestParam Long id,@RequestParam InProgress inProgress){

        InProgressRequestDto inProgressRequestDto = new InProgressRequestDto(id,inProgress);
        Step1ResponseDto step1Info = farmService.getStep1(inProgressRequestDto);

        return ApiResponseDto.of(step1Info);
    }

    @GetMapping("api/farm/checkStep2")
    public ApiResponseDto checkStep2(@RequestBody InProgressRequestDto inProgressRequestDto){
        Step2ResponseDto step2Info = farmService.getStep2(inProgressRequestDto);
        return ApiResponseDto.of(step2Info);
    }

    @PutMapping("/api/farm/{id}/files")
    public ApiResponseDto updateFile(@PathVariable Long id,
                           @RequestBody @Valid FileUpdateRequestDto fileUpdateRequestDto) {
        farmFileService.saveFile(id, fileUpdateRequestDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/move")
    public ApiResponseDto updatePageNum(@PathVariable Long id,
                              @RequestBody @Valid PageNumUpdateRequestDto pageNumUpdateRequestDto) {
        farmService.updatePageNum(id, pageNumUpdateRequestDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/agreement")
    public ApiResponseDto farmAgreement(@PathVariable Long id, @RequestBody @Valid FarmAgreementRequestDto farmAgreementDto){
        farmService.updateFarmAgreement(id, farmAgreementDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/ownerInfo")
    public ApiResponseDto farmOwnerInfo(@PathVariable Long id, @RequestBody @Valid FarmOwnerInfoRequestDto farmOwnerInfoDto){
        farmService.updateFarmOwnerInfo(id, farmOwnerInfoDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/info")
    public ApiResponseDto farmInfo(@PathVariable Long id, @RequestBody @Valid FarmInfoRequestDto farmInfoDto) {
        farmService.updateFarmInfo(id, farmInfoDto);
        return ApiResponseDto.of(HttpStatus.OK);

    }

    @PutMapping("/api/farm/{id}/infoCheck")
    public ApiResponseDto farmInfoCheck(@PathVariable Long id, @RequestBody @Valid FarmInfoCheckRequestDto farmInfoCheckDto){
        farmService.updateFarmInfoCheck(id, farmInfoCheckDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/filesCheck")
    public ApiResponseDto farmFilesCheck(@PathVariable Long id, @RequestBody @Valid FarmFilesCheckRequestDto farmFilesCheckDto){
        farmService.updateFarmFilesCheck(id, farmFilesCheckDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/requestDate")
    public ApiResponseDto updateInvestigationRequest(@PathVariable Long id,
                                           @RequestBody @Valid InvestigationRequestUpdateRequestDto investigationRequestUpdateRequestDto){
        farmService.updateInvestigationRequest(id, investigationRequestUpdateRequestDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/inProgress")
    public ApiResponseDto updateInProgress(@PathVariable Long id,
                                 @RequestBody @Valid InProgressUpdateRequestDto inProgressUpdateRequestDto) {
        farmService.updateInProgress(id, inProgressUpdateRequestDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping(value = "/api/farm/{id}/images")
    public ApiResponseDto updateImage(@PathVariable Long id,
                            @RequestBody @Valid ImageUpdateRequestDto imageUpdateRequestDto) {
        farmImageService.saveImage(id, imageUpdateRequestDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PostMapping("/api/test")
    public void test(@RequestBody LoginRequestDto loginRequestDto){farmService.creatFarm(loginRequestDto);
    }

    @GetMapping("/api/farm/checkStep3")
    public ApiResponseDto checkStep3() throws IOException, ParseException {
        return ApiResponseDto.of(farmService.getNoReservationAllowedList());
    }


}
