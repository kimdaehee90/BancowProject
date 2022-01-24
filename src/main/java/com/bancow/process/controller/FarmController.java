package com.bancow.process.controller;

<<<<<<< HEAD
import com.bancow.process.domain.Farm;
import com.bancow.process.dto.FarmInfoDto;
import com.bancow.process.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/farm")
@RequiredArgsConstructor
public class FarmController {

//    private final FarmRepository farmRepository;

//    @PutMapping("/{id}/info")
//    public Long farmInfo(@PathVariable Long id, @RequestBody FarmInfoDto farmInfoDto){
//        return FarmService.putFarminfo(id, farmInfoDto);
=======


import com.bancow.process.service.FarmService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    @PostMapping("/login")
    public void sendUsername(@RequestParam String userName){
        farmService.join(userName);
    }
>>>>>>> 6e83b9710b003a5e84dd27e7b8dc94a7466abc75


}
