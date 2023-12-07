package com.zephyr.weatherapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zephyr.weatherapi.model.Weather;
import com.zephyr.weatherapi.repository.WeatherRepository;
import com.zephyr.weatherapi.service.WeatherApiRequest;
import com.zephyr.weatherapi.service.WeatherNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class MainController {
    private final WeatherRepository weatherRepository;

    MainController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @GetMapping("/actualWeather")
    Weather getActualWeather() throws IOException, InterruptedException {

//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=Minsk"))
//                .header("X-RapidAPI-Key", "9b1737a979mshb8a1d339680b8bfp1b1c50jsn7f3a6a1f381f")
//                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
////        weatherRepository.save(response.body());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = response.body();
//        Weather weather = objectMapper.readValue(json, Weather.class);
//        System.out.println("\nJson to object:" + weather);

        return weatherRepository.findTopByOrderByCreatedAtDesc();
    }

    @GetMapping("/{id}")
    Weather getWeather(@PathVariable long id) throws IOException, InterruptedException {
//        WeatherApiRequest weatherApiRequest = new WeatherApiRequest();
//        weatherApiRequest.apiQuery();
        return weatherRepository.findById(id).orElseThrow(() -> new WeatherNotFoundException(id));
    }

    @PostMapping("/weather")
    Weather newWeather(@RequestBody Weather newWeather) {
        return weatherRepository.save(newWeather);
    }
}