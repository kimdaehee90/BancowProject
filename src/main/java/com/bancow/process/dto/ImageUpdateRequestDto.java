package com.bancow.process.dto;

import com.bancow.process.domain.ImageType;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ImageUpdateRequestDto {

    @NotBlank
    private String originalImageName;

    @NotBlank
    private String changedImageName;

    @NotBlank
    private String imageUrl;

    @NotNull
    private ImageType imageType;

}
