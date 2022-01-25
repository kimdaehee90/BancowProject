package com.bancow.process.controller;

import com.bancow.process.domain.Farm;
import com.bancow.process.domain.FarmFile;
import com.bancow.process.domain.FileType;
import com.bancow.process.dto.FileUpdateRequestDto;
import com.bancow.process.dto.PageNumUpdateRequestDto;
import com.bancow.process.dto.RequestDto;
import com.bancow.process.dto.*;
import com.bancow.process.repository.FarmFileRepository;
import com.bancow.process.repository.FarmRepository;
import com.bancow.process.service.FarmFileService;
import com.bancow.process.service.FarmImageService;
import com.bancow.process.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FarmController {
    private final FarmService farmService;
    private final FarmFileService farmFileService;
    private final FarmImageService farmImageService;

    private final FarmFileRepository farmFileRepository;

    @PostMapping("/login")
    public void sendUsername(@RequestParam String userName){
        farmService.join(userName);
    }

    // 김광현 사용중
    @PostMapping("/api/post")
    public void save(@RequestBody RequestDto requestDto) {
        farmService.createFarm(requestDto);
    }

    @PutMapping("/api/farm/{id}/files")
    public void updateFile(@PathVariable Long id,
                       @RequestBody FileUpdateRequestDto fileUpdateRequestDto) {
        farmFileService.updateFile(id, fileUpdateRequestDto);
    }

    @PutMapping("/api/farm/{id}/move")
    public void updatePageNum(@PathVariable Long id,
                              @RequestBody PageNumUpdateRequestDto pageNumUpdateRequestDto) {
        farmService.updatePageNum(id, pageNumUpdateRequestDto);
    }

    @PutMapping("login/auth/{id}")
    public void login(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        farmService.login(requestDto);
    }

    @PutMapping("/api/farm/{id}/info")
    public void farmInfo(@PathVariable Long id, @RequestBody FarmInfoDto farmInfoDto) {
        farmService.updateFarmInfo(id, farmInfoDto);

    }

    @PutMapping("/api/farm/{id}/info-check")
    public void farmInfoCheck(@PathVariable Long id, @RequestBody FarmInfoCheckDto farmInfoCheckDto){
        farmService.updateFarmInfoCheck(id, farmInfoCheckDto);
    }

    @PutMapping("/api/farm/{id}/files-check")
    public void farmInfoCheck(@PathVariable Long id, @RequestBody FarmFilesCheckDto farmFilesCheckDto){
        farmService.updateFarmFilesCheck(id, farmFilesCheckDto);
    }

    @PutMapping("/api/farm/{id}/request-date")
    public void updateInvestigationRequest(@PathVariable Long id,
                                           @RequestBody InvestigationRequestUpdateRequestDto investigationRequestUpdateRequestDto){
        farmService.updateInvestigationRequest(id, investigationRequestUpdateRequestDto);
    }

    @PutMapping("/api/farm/{id}/in-progress")
    public void updateInProgress(@PathVariable Long id,
                                 @RequestBody InProgressUpdateRequestDto inProgressUpdateRequestDto) {
        farmService.updateInProgress(id, inProgressUpdateRequestDto);
    }

    @PutMapping("/api/farm/{id}/images")
    public void updateImage(@PathVariable Long id,
                            @RequestBody ImageUpdateRequestDto imageUpdateRequestDto) {
        farmImageService.updateImage(id, imageUpdateRequestDto);
    }


}
