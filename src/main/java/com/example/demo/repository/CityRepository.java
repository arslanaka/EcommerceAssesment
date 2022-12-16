package com.example.demo.repository;

import com.example.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    @Query(value = "select * from cities where city_id = ?1",nativeQuery = true)
    City findCityByCityId(String cityId);
}
