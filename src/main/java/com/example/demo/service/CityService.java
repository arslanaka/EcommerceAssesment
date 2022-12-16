package com.example.demo.service;

import com.example.demo.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CityService {

    Boolean addCity(City city);

    boolean updateCity(City city);

    Boolean deleteCity(City city);

    Optional<List<City>> findAllCities();

}
