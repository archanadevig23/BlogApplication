package com.practice.blogmanagement.model.exceptions;

import com.practice.blogmanagement.model.error.Errors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppException extends RuntimeException{

    private Errors error;

}
