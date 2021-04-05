package com.avaj.aircraft;

import com.avaj.coordinates.Coordinates;
import com.avaj.weather_tower.WeatherTower;

import java.util.logging.Logger;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private Logger logger = Logger.getLogger("Logger");

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        switch (this.weatherTower.getWeather(this.coordinates)) {
            case "RAIN":
                coordinates = new Coordinates(longitude + 5, latitude, height);
                logger.info(toString() + "  The turntable will save me.");
                break;
            case "FOG":
                coordinates = new Coordinates(longitude + 1, latitude, height);
                logger.info(toString() + "  Not a damn thing in sight");
                break;
            case "SUN":
                coordinates = new Coordinates(longitude + 10, latitude, height + 2);
                logger.info(toString() + "  Okay, skip the solarium");
                break;
            case "SNOW":
                coordinates = new Coordinates(longitude, latitude, height - 12);
                logger.info(toString() + "  " +
                        "Great, I'll go snowboarding this weekend.");
                break;
        }
    }

    // Можно перенсти в AirCraft, требования UML
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

    @Override
    public String toString() {
        return "Helicopter " + super.toString();
    }
}