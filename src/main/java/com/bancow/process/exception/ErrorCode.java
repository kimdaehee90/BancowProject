package com.bancow.process.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    FARM_NOT_FOUND(INTERNAL_SERVER_ERROR, "해당 농장 정보를 찾을 수 없습니다."),
    MIS_INFORMATION(BAD_REQUEST, "잘못된 정보를 입력하셨습니다.");


    private final HttpStatus httpStatus;
    private final String message;
}
