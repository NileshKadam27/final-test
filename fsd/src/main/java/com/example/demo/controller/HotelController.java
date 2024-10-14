package com.example.demo.controller;

import com.example.demo.Exception.CustomException;
import com.example.demo.bean.ResposneBean;
import com.example.demo.entity.Hotel;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/api/hotel")
    public ResponseEntity<?> getAll() throws CustomException {
        ResposneBean resposneBean = new ResposneBean(hotelService.getAll(),"Success");
        return new ResponseEntity<>(resposneBean, HttpStatus.OK);
    }

    @PostMapping("/api/hotel")
    public ResponseEntity<?> create(@RequestBody Hotel hotel) throws CustomException {
        ResposneBean resposneBean = new ResposneBean(hotelService.create(hotel),"Success");
        return new ResponseEntity<>(resposneBean, HttpStatus.OK);
    }

    @PutMapping("/api/hotel/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody Hotel hotel) throws CustomException {
        ResposneBean resposneBean = new ResposneBean(hotelService.update(id,hotel),"Success");
        return new ResponseEntity<>(resposneBean, HttpStatus.OK);
    }

    @DeleteMapping("/api/hotel/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws CustomException {
        ResposneBean resposneBean = new ResposneBean(hotelService.delete(id),"Success");
        return new ResponseEntity<>(resposneBean, HttpStatus.OK);
    }
}
