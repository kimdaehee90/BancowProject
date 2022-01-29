package com.bancow.process.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    FARM_NOT_FOUND(INTERNAL_SERVER_ERROR, "C001"),
    ARGUMENT_NOT_VALID(BAD_REQUEST, "C002"),
    MIS_INFORMATION(BAD_REQUEST, "C003"),
    NOT_SUPPORTED_HTTP_REQUEST_METHOD(METHOD_NOT_ALLOWED, "C004");

    private final HttpStatus httpStatus;
    private final String code;
}
