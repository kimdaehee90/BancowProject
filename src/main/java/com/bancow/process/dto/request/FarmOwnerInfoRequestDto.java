package com.bancow.process.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class FarmOwnerInfoRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotNull
    private Long pageNum;

}
