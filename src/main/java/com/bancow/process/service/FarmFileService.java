package com.bancow.process.service;

import com.bancow.process.domain.Farm;
import com.bancow.process.domain.FarmFile;
import com.bancow.process.dto.FileUpdateRequestDto;
import com.bancow.process.repository.FarmFileRepository;
import com.bancow.process.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmFileService {

    private final FarmRepository farmRepository;
    private final FarmFileRepository farmFileRepository;

    @Transactional
    public void updateFile(Long farmId, FileUpdateRequestDto fileUpdateRequestDto) {
        Farm farm = farmRepository.findById(farmId).orElseThrow(
                () -> new IllegalArgumentException("해당 농장이 없습니다. farmId =" + farmId)
        );

        // farmId 와 farmFile.getFileType() 을 파라미터로 파일을 검색한다.
        Optional<FarmFile> farmFile
                = Optional.ofNullable(farmFileRepository.findFile(farmId, fileUpdateRequestDto.getFileType()));

        // 파일이 없다면 FarmFile 객체를 생성한다.
        if (farmFile.isEmpty()) {
            FarmFile createFile = new FarmFile(farm,
                    fileUpdateRequestDto.getOriginalFileName(),
                    fileUpdateRequestDto.getChangedFileName(),
                    fileUpdateRequestDto.getFileUrl(),
                    fileUpdateRequestDto.getFileType());

            farmFileRepository.save(createFile);

        // 파일이 있다면 FarmFile 객체를 업데이트한다.
        } else {
            farmFile.get().updateFile(fileUpdateRequestDto.getOriginalFileName(),
                    fileUpdateRequestDto.getChangedFileName(),
                    fileUpdateRequestDto.getFileUrl(),
                    fileUpdateRequestDto.getFileType());
        }

    }
}
