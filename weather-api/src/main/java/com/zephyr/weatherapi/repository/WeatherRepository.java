package com.zephyr.weatherapi.repository;

import com.zephyr.weatherapi.model.Weather;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<Weather, Long> {
    Weather findTopByOrderByCreatedAtDesc();
}
