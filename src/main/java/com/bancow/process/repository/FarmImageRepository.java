package com.bancow.process.repository;

import com.bancow.process.domain.FarmImage;
import com.bancow.process.constant.ImageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FarmImageRepository extends JpaRepository<FarmImage, Long> {

    @Query("select fi from FarmImage fi " +
           "where fi.farm.id = :id and fi.imageType = :imageType")
    FarmImage findImage(@Param("id") Long id, @Param("imageType") ImageType imageType);

    List<FarmImage> findByFarmId(Long id);


}

