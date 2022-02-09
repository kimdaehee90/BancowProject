package com.bancow.process.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Step3ResponseDto {
    private Long id;
    private List<RequestDateResponseDto> noReservationDate;

    public Step3ResponseDto(Long id, List<RequestDateResponseDto> requestDateResponseDtoList) {
        this.id = id;
        this.noReservationDate = requestDateResponseDtoList;
    }
}
