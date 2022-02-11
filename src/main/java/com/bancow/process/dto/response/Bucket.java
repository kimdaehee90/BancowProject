package com.bancow.process.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Bucket {
    private Long id;
    private String originalInageName;
    private String changeImageName;
    private String imageUrl;
}
