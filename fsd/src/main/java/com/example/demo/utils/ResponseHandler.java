package com.example.demo.utils;

import com.example.demo.bean.ResposneBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {


    private static ResponseEntity<?> responseEntity(String message, Object payload, HttpStatus httpStatus){
        ResposneBean resposneBean = new ResposneBean(payload, message);
        return new ResponseEntity<>(resposneBean,httpStatus);
    }
}
