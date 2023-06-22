package com.practice.blogmanagement.controller.advice;

import com.practice.blogmanagement.model.error.ErrorResponse;
import com.practice.blogmanagement.model.error.Errors;
import com.practice.blogmanagement.model.exceptions.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(AppException.class)
    public Mono<ResponseEntity<Object>> handleAppException(AppException e) {
        Errors error = e.getError();
        return Mono.fromSupplier(() ->
            ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ErrorResponse.builder()
                                .code(error.code)
                                .message(error.message)
                                .build()));
    }

}
