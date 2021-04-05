package com.sscottie.avaj.aircraft;

import com.sscottie.avaj.coordinates.Coordinates;
import com.sscottie.avaj.weather_tower.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    Coordinates getCoordinates();
}