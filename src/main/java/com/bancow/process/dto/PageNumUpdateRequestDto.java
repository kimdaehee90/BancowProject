package com.bancow.process.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PageNumUpdateRequestDto {

    @NotNull
    private Long pageNum;

}
