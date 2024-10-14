package com.example.demo.controller;

import com.example.demo.Exception.CustomException;
import com.example.demo.bean.ErrorBean;
import com.example.demo.bean.ResposneBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> bookingException(CustomException customException){
        ErrorBean errorBean = new ErrorBean();
        errorBean.setErrorCode(customException.getErrorCode());
        errorBean.setErrorMessage(customException.getMessage());
        ResposneBean resposneBean = new ResposneBean(errorBean);
        return new ResponseEntity<>(resposneBean,customException.getHttpStatus());
    }
}
