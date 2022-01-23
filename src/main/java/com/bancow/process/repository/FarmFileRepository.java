package com.bancow.process.repository;

import com.bancow.process.domain.FarmFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmFileRepository extends JpaRepository<FarmFile, Long> {
}
