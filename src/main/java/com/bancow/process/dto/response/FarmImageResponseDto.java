package com.bancow.process.dto.response;

import com.bancow.process.domain.FarmImage;
import com.bancow.process.constant.ImageType;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FarmImageResponseDto {

    private Long farmImageId;
    private String originalImageName;
    private String changedImageName;
    private String imageUrl;
    private ImageType imageType;


    public FarmImageResponseDto(FarmImage o) {
        this.farmImageId = o.getId();
        this.originalImageName = o.getOriginalImageName();
        this.changedImageName = o.getChangedImageName();
        this.imageUrl = o.getImageUrl();
        this.imageType = o.getImageType();
    }
}
