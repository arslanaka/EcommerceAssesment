package com.example.demo.service.serviceImpl;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImplementation implements CityService {

    private static final Logger log = LoggerFactory.getLogger(CityServiceImplementation.class);

    @Autowired
    CityRepository cityRepository;


    @Override
    public Boolean addCity(City city) {

        try {
            if (city.getCity() !=null && city.getActive() != null && city.getCountry() != null && city.getCountryCode() != null && city.getCityId() !=null){
                cityRepository.save(city);
                log.info("city saved");
                return true;
            }
        }catch (NullPointerException exception){
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateCity(City city) {

        try {
            if (city.getCity() !=null && city.getActive() != null && city.getCountry() != null && city.getCountryCode() != null && city.getCityId() !=null) {
                City existingCity = cityRepository.findCityByCityId(city.getCityId());

                existingCity.setCityId(city.getCityId());
                existingCity.setCity(city.getCity());
                existingCity.setActive(city.getActive());
                existingCity.setCountry(city.getCountry());
                existingCity.setCountryCode(city.getCountryCode());

                cityRepository.save(existingCity);
            }
            return true;
        }catch (NullPointerException e){
            e.printStackTrace();
            log.error("Exception :: "+e.getLocalizedMessage());
        }
        return false;
    }

    @Override
    public Boolean deleteCity(City city) {

        try {
            if (city.getCity() != null || city.getCityId() != null){
                cityRepository.delete(city);
                return true;
            }else {
                return false;
            }

        }catch (NullPointerException e){
            e.printStackTrace();
            log.error("Exception :: "+e.getLocalizedMessage());

        }

        return false;
    }

    @Override
    public Optional<List<City>> findAllCities() {
        Optional<List<City>> cityList = Optional.empty();
        try {
            cityList = Optional.of(cityRepository.findAll());
        }catch (Exception e){
            e.printStackTrace();
            log.error("Exception :: "+e.getLocalizedMessage());
        }
        return cityList;
    }
}
