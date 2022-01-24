package com.bancow.process.controller;

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

    private final FarmRepository farmRepository;

    @PutMapping("/{id}/info")
    public Long farmInfo(@PathVariable Long id, @RequestBody FarmInfoDto farmInfoDto){
        return FarmService.putFarminfo(id, farmInfoDto);

    }
}
