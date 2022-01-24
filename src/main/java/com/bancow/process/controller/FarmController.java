package com.bancow.process.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import com.bancow.process.dto.FileUpdateRequestDto;
import com.bancow.process.dto.RequestDto;
import com.bancow.process.service.FarmFileService;
import com.bancow.process.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FarmController {
    //    private final FarmRepository farmRepository;
    private final FarmService farmService;
    private final FarmFileService farmFileService;

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
    public void update(@PathVariable Long id,
                       @RequestBody FileUpdateRequestDto fileUpdateRequestDto) {
        farmFileService.updateFile(id, fileUpdateRequestDto);
    }

//    @PutMapping("/api/farm/{id}/info")
//    public Long farmInfo(@PathVariable Long id, @RequestBody FarmInfoDto farmInfoDto){
//        return FarmService.putFarminfo(id, farmInfoDto);


}
