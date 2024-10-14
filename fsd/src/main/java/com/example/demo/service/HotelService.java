package com.example.demo.service;


import com.example.demo.Exception.CustomException;
import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public List<Hotel> getAll() throws CustomException {
        try{
            return hotelRepository.findAll();
        }catch (Exception exception){
            throw new CustomException("Exception while fetching all hotels", "fsd-001", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Hotel create(Hotel hotel) throws CustomException {
        try{
            return hotelRepository.save(hotel);
        }catch (Exception exception){
            throw new CustomException("Exception while adding new hotel", "fsd-002", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Hotel update(Integer id, Hotel hotelUpdateReq) throws CustomException {
        try{
            Optional<Hotel> optionalHotel = hotelRepository.findById(id);
            if(optionalHotel.isPresent()){
                return hotelRepository.save(hotelUpdateReq);
            }else{
                throw new CustomException("Hotel not found", "fsd-003", HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            throw new CustomException("Exception while adding new hotel", "fsd-002", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public String delete(Integer id) throws CustomException {
        try{
            Optional<Hotel> optionalHotel = hotelRepository.findById(id);
            if(optionalHotel.isPresent()){
                hotelRepository.delete(optionalHotel.get());
                return "Hotel deleted successfully from database";
            }else{
                throw new CustomException("Hotel not found", "fsd-003", HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            throw new CustomException("Exception while adding new hotel", "fsd-002", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
