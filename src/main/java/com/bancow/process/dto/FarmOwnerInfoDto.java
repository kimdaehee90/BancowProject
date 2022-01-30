package com.bancow.process.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
