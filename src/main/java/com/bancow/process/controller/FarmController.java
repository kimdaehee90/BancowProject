package com.bancow.process.controller;

import com.bancow.process.dto.*;
import com.bancow.process.service.FarmFileService;
import com.bancow.process.service.FarmImageService;
import com.bancow.process.service.FarmService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;
    private final FarmFileService farmFileService;
    private final FarmImageService farmImageService;

    @PostMapping("/api/sendSMS")
    public ApiResponseDto sendUsername(@RequestParam String userName){
        farmService.join(userName);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @GetMapping("/api/farm/checkInfo/{userName}")
    public ApiResponseDto checkInfo(@PathVariable String userName){
        Object result = farmService.check(userName);
        return ApiResponseDto.of(result);
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
    public ApiResponseDto farmAgreement(@PathVariable Long id, @RequestBody @Valid FarmAgreementDto farmAgreementDto){
        farmService.updateFarmAgreement(id, farmAgreementDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/owner-info")
    public ApiResponseDto farmOwnerInfo(@PathVariable Long id, @RequestBody @Valid FarmOwnerInfoDto farmOwnerInfoDto){
        farmService.updateFarmOwnerInfo(id, farmOwnerInfoDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/info")
    public ApiResponseDto farmInfo(@PathVariable Long id, @RequestBody @Valid FarmInfoDto farmInfoDto) {
        farmService.updateFarmInfo(id, farmInfoDto);
        return ApiResponseDto.of(HttpStatus.OK);

    }

    @PutMapping("/api/farm/{id}/info-check")
    public ApiResponseDto farmInfoCheck(@PathVariable Long id, @RequestBody @Valid FarmInfoCheckDto farmInfoCheckDto){
        farmService.updateFarmInfoCheck(id, farmInfoCheckDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/files-check")
    public ApiResponseDto farmFilesCheck(@PathVariable Long id, @RequestBody @Valid FarmFilesCheckDto farmFilesCheckDto){
        farmService.updateFarmFilesCheck(id, farmFilesCheckDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/request-date")
    public ApiResponseDto updateInvestigationRequest(@PathVariable Long id,
                                           @RequestBody @Valid InvestigationRequestUpdateRequestDto investigationRequestUpdateRequestDto){
        farmService.updateInvestigationRequest(id, investigationRequestUpdateRequestDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/in-progress")
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

}
