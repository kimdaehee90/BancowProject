package com.bancow.process.dto;

import com.bancow.process.domain.ImageType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class ImageUpdateRequestDto {

    @NotBlank
    private String originalImageName;

    @NotBlank
    private String changedImageName;

    @NotBlank
    private String imageUrl;

    @NotNull
    private ImageType imageType;

    @Builder
    public ImageUpdateRequestDto(String originalImageName,
                                 String changedImageName,
                                 String imageUrl,
                                 ImageType imageType) {
        this.originalImageName = originalImageName;
        this.changedImageName = changedImageName;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
    }
}
