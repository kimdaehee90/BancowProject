package com.bancow.process.dto.response;

import com.bancow.process.constant.InProgress;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class InProgressResponseDto {

    private Long id;
    private InProgress inProgress;
    private Long pageNum;

}
