package com.bancow.process.repository;

import com.bancow.process.domain.FarmFile;
import com.bancow.process.constant.FileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  FarmFileRepository extends JpaRepository<FarmFile, Long> {

    @Query("select ff from FarmFile ff " +
           "where ff.farm.id = :id and ff.fileType = :fileType")
    FarmFile findFile(@Param("id") Long id, @Param("fileType") FileType fileType);

    List<FarmFile> findByFarmId(Long id);
}
