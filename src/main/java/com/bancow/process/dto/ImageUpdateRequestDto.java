package com.bancow.process.dto;

import com.bancow.process.domain.ImageType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ImageUpdateRequestDto {

    private String originalImageName;
    private String changedImageName;
    private String imageUrl;
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
