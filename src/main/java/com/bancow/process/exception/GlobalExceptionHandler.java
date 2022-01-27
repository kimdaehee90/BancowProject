package com.bancow.process.exception;

import com.bancow.process.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.bancow.process.exception.ErrorCode.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { CustomException.class })
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }

//    // 특정 Exception 처리 예제
//    @ExceptionHandler(IllegalArgumentException.class)
//    protected ResponseEntity<ErrorResponse> illegalargumentexception() {
//        log.error("handleCustomException throw CustomException : {}", FARM_NOT_FOUND);
//        return ErrorResponse.toResponseEntity(FARM_NOT_FOUND);
//    }

}
