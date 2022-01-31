package com.bancow.process.dto;

import com.bancow.process.domain.FarmImage;
import com.bancow.process.domain.ImageType;
import lombok.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

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
