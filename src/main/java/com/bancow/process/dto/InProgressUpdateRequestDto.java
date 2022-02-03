package com.bancow.process.dto;

import com.bancow.process.constant.InProgress;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class InProgressUpdateRequestDto {

    @NotNull
    private Long pageNum;

    @NotNull
    private InProgress inProgress;

}
