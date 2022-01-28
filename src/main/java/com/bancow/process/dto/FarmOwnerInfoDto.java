package com.bancow.process.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmOwnerInfoDto {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotNull
    private Long pageNum;

}
