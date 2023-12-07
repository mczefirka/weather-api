package com.zephyr.weatherapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Table(name = "weather")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, name = "weather_id")
    private int id;

    private int temperature;

    @Column(updatable = false, name = "wind_speed")
    private int windSpeed;

    @Column(updatable = false, name = "atmo_pressure")
    private int atmoPressure;

    @Column(updatable = false, name = "air_humidity")
    private int airHumidity;

    @Column(name = "weather_type")
    private String weatherType;
    private String location;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;
}