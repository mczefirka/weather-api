package com.zephyr.weatherapi.service;

public class WeatherNotFoundException extends RuntimeException {
    public WeatherNotFoundException() {
        super("Could not find weather");
    }

    public WeatherNotFoundException(long id) {
        super("Could not find weather " + id);
    }
}