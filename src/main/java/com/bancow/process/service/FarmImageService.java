package com.bancow.process.service;

import com.bancow.process.domain.Farm;
import com.bancow.process.domain.FarmImage;
import com.bancow.process.dto.ImageUpdateRequestDto;
import com.bancow.process.exception.CustomException;
import com.bancow.process.constant.ErrorCode;
import com.bancow.process.repository.FarmImageRepository;
import com.bancow.process.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmImageService {

    private final FarmRepository farmRepository;
    private final FarmImageRepository farmImageRepository;

    @Transactional
    public void saveImage(Long farmId, ImageUpdateRequestDto imageUpdateRequestDto) {
        Farm farm = farmRepository.findById(farmId).orElseThrow(
                () -> new CustomException(ErrorCode.FARM_NOT_FOUND)
        );

        // farmId 와 farmImage.getImageType() 을 파라미터로 이미지를 검색한다.
        FarmImage farmImage
                = farmImageRepository.findImage(farmId, imageUpdateRequestDto.getImageType());

        // 이미지이 없다면 FarmImage 객체를 생성한다.
        if (farmImage == null) {
            farmImageRepository.save(new FarmImage(farm,
                    imageUpdateRequestDto.getOriginalImageName(),
                    imageUpdateRequestDto.getChangedImageName(),
                    imageUpdateRequestDto.getImageUrl(),
                    imageUpdateRequestDto.getImageType()));

        // 이미지이 있다면 FarmImage 객체를 업데이트한다.
        } else {
            farmImage.updateImage(imageUpdateRequestDto.getOriginalImageName(),
                    imageUpdateRequestDto.getChangedImageName(),
                    imageUpdateRequestDto.getImageUrl(),
                    imageUpdateRequestDto.getImageType());
        }

    }
}
