package com.example.demo.controllers.City;

import com.example.demo.entity.City;
import com.example.demo.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CityController {


    private static final Logger log = LoggerFactory.getLogger(CityController.class);
    @Autowired
    CityService cityService;

    @PostMapping("/addCity")
    public ResponseEntity addCity(@RequestBody City city){
        ResponseEntity responseEntity = null;
        try {
            log.info("Controller");
            boolean saved = cityService.addCity(city);
            if (saved){
                responseEntity = ResponseEntity.status(200).body("City Added Successfully");
                log.info("city saved");
            }else {
                responseEntity = ResponseEntity.status(400).body("could not add city, make sure you fill in the correctly");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Exception :: "+e.getLocalizedMessage());
            responseEntity = ResponseEntity.status(400).body("Some error occurred, Please try again later.");
        }
        return responseEntity;
    }

    @PostMapping("/editCity")
    public ResponseEntity updateCity(City city){
        ResponseEntity responseEntity = null;
        try {
            boolean updated = cityService.updateCity(city);
            if (updated){
                responseEntity = ResponseEntity.status(200).body("City Updated Successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseEntity = ResponseEntity.status(400).body("Unable to update City, please try again later.");
            log.error("Exception :: "+e.getLocalizedMessage());
        }
        return responseEntity;
    }

    @PostMapping("/deleteCity")
    public ResponseEntity deleteCity(City city){
        ResponseEntity responseEntity = null;
        try {
            Boolean isDeleted = cityService.deleteCity(city);
            if (isDeleted){
                responseEntity = ResponseEntity.status(200).body("City Deleted");
            }else
                responseEntity = ResponseEntity.status(400).body("Unable to delete city, City ID or City Name cannot be empty");
        }catch (Exception e){
            e.printStackTrace();
            log.error("Exception :: "+e.getLocalizedMessage());
            responseEntity = ResponseEntity.status(400).body("Unable to delete city");
        }
        return responseEntity;
    }

    @PostMapping("/getAllCities")
    public ResponseEntity getAllCities(){
        ResponseEntity responseEntity = null;
        try {
            Optional<List<City>> optionalCities = cityService.findAllCities();
            responseEntity = ResponseEntity.status(200).body(optionalCities);
            if (optionalCities.isEmpty()){
                responseEntity = ResponseEntity.status(404).body("Np cities were found");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseEntity = ResponseEntity.status(400).body("Some error occurred, please try again later");
            log.error("Exception  :: "+e.getLocalizedMessage());
        }
        return responseEntity;
    }




}
