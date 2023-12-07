package com.zephyr.weatherapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zephyr.weatherapi.controller.MainController;
import com.zephyr.weatherapi.model.Weather;
import com.zephyr.weatherapi.repository.WeatherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

@Component
public class WeatherApiRequest {

    @Scheduled(fixedRate = 60000)
    public void apiQuery() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=Minsk"))
                .header("X-RapidAPI-Key", "9b1737a979mshb8a1d339680b8bfp1b1c50jsn7f3a6a1f381f")
                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(LocalDateTime.now() + "\t" + response.body());

//
//        ObjectMapper objectMapper = new ObjectMapper();
//        RestTemplate restTemplate = new RestTemplate();
//
//        ResponseEntity<String> responseEntity
//                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
//
//        Weather weather = objectMapper.readValue(response.body(), Weather.class);
//        System.out.println(weather);
//
//        // 3
//
//        final WeatherRepository weatherRepository;
//        WeatherApiRequest(WeatherRepository weatherRepository) {
//            this.weatherRepository = weatherRepository;
//        }
//        weatherRepository.save(response.body());
//
    }
}