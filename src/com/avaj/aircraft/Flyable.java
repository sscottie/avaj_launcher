package com.avaj.aircraft;

import com.avaj.coordinates.Coordinates;
import com.avaj.weather_tower.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    Coordinates getCoordinates();
}