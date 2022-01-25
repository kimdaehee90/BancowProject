package com.bancow.process.repository;

import com.bancow.process.domain.Farm;
import com.bancow.process.domain.FarmFile;
import com.bancow.process.domain.FileType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import javax.transaction.Transactional;

import static com.bancow.process.domain.FileType.ID_CARD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class FarmRepositoryTest {

    @Autowired
    FarmRepository farmRepository;

    @Test
    public void test(){
        Farm farm = new Farm();
        farm.setFarmName("농장명");
        farmRepository.save(farm);

        System.out.println(farmRepository.findAll());

    }

}