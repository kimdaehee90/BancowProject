package com.bancow.process.controller;

import com.bancow.process.dto.*;
import com.bancow.process.repository.FarmFileRepository;
import com.bancow.process.repository.FarmImageRepository;

import com.bancow.process.repository.FarmRepository;
import com.bancow.process.security.config.auth.PrincipalDetails;
import com.bancow.process.security.config.auth.PrincipalDetailsService;

import com.bancow.process.service.FarmFileService;
import com.bancow.process.service.FarmImageService;
import com.bancow.process.service.FarmService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class FarmController {
    private final FarmService farmService;
    private final FarmFileService farmFileService;
    private final FarmImageService farmImageService;
    private final FarmImageRepository farmImageRepository;
    private final FarmRepository farmRepository;
    private final FarmFileRepository farmFileRepository;

    @PostMapping("/api/sendSMS")
    public void sendUsername(@RequestParam String userName){
        farmService.join(userName);
    }


    @GetMapping("api/farm/checkInfo/{userName}")
    public Object test(@PathVariable String userName){
        Object result = farmService.check(userName);
        return result;
    }

    // 김광현 사용중
    @PostMapping("/api/post")
    public void save(@RequestBody RequestDto requestDto) {
        farmService.createFarm(requestDto);
    }

    @PutMapping("/api/farm/{id}/files")
    public ApiResponseDto updateFile(@PathVariable Long id,
                           @RequestBody @Valid FileUpdateRequestDto fileUpdateRequestDto) {
        farmFileService.updateFile(id, fileUpdateRequestDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("/api/farm/{id}/move")
    public ApiResponseDto updatePageNum(@PathVariable Long id,
                              @RequestBody @Valid PageNumUpdateRequestDto pageNumUpdateRequestDto) {
        farmService.updatePageNum(id, pageNumUpdateRequestDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @PutMapping("login/auth/{id}")
    public void login(@PathVariable Long id, @RequestBody RequestDto requestDto) {
//        farmService.login(requestDto);
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
        farmImageService.updateImage(id, imageUpdateRequestDto);
        return ApiResponseDto.of(HttpStatus.OK);
    }

    @GetMapping("/api/login/auth/checkInfo/{userName}")
    public ApiResponseDto<Object> test1(@RequestParam String userName) {
        Object result = farmService.check(userName);
        return ApiResponseDto.of(result);
    }


}
