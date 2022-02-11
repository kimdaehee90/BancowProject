package com.bancow.process.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ImageResponseDto {

    private FarmOutside farmOutside;
    private Floor floor;
    private Bucket bucket;
}
