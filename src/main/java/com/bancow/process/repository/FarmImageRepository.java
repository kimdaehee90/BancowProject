package com.bancow.process.repository;

import com.bancow.process.domain.Farm;
import com.bancow.process.domain.FarmImage;
import com.bancow.process.domain.ImageType;
import com.bancow.process.dto.FarmImageResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FarmImageRepository extends JpaRepository<FarmImage, Long> {

    @Query("select fi from FarmImage fi " +
           "where fi.farm.id = :id and fi.imageType = :imageType")
    FarmImage findImage(@Param("id") Long id, @Param("imageType") ImageType imageType);

    @Query("select fi.imageUrl from FarmImage fi " +
            "where fi.farm.id = :id")
    List<String> findUrl(@Param("id") Long id);

//    @Query("select fi from FarmImage fi " +
//            "where fi.farm.id = :id")
//   FarmImage findImage(@Param("id") Long id);
//    List<FarmImage> findByFarmId(Long id);
//    FarmImage findByImageType(String imageType);
}

