package com.zephyr.weatherapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class WeatherNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(WeatherNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String weatherNotFoundHandler(WeatherNotFoundException ex) {
        return ex.getMessage();
    }
}