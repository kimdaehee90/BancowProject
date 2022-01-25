package com.bancow.process.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "farm_image")
@Data
public class FarmImage extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 원래 이미지 이름
    @Column(name = "original_image_name")
    private String originalImageName;

    // 식별 번호가 적용된 이미지 이름
    @Column(name = "changed_image_name")
    private String changedImageName;

    // 이미지 경로
    @Column(name = "image_url")
    private String imageUrl;

    // 이미지 타입
    @Enumerated(EnumType.STRING)
    @Column(name = "image_type")
    private ImageType imageType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id")
    @JsonManagedReference
    private Farm farm;

    @Builder
    public FarmImage(Farm farm, String originalImageName, String changedImageName, String imageUrl, ImageType imageType) {
        this.farm = farm;
        this.originalImageName = originalImageName;
        this.changedImageName = changedImageName;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
    }

    public void updateImage(String originalImageName, String changedImageName, String imageUrl, ImageType imageType) {
        this.originalImageName = originalImageName;
        this.changedImageName = changedImageName;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
    }
}
