package com.avaj.aircraft;



import com.avaj.coordinates.Coordinates;
import com.avaj.weather_tower.WeatherTower;

import java.util.logging.Logger;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private Logger logger = Logger.getLogger("Logger");

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        switch (this.weatherTower.getWeather(this.coordinates)) {
            case "RAIN":
                coordinates = new Coordinates(longitude, latitude, height - 5);
                logger.info(toString() + "  Good");
                break;
            case "FOG":
                coordinates = new Coordinates(longitude, latitude, height - 3);
                logger.info(toString() + "  Good");
                break;
            case "SUN":
                coordinates = new Coordinates(longitude + 2, latitude, height + 4);
                logger.info(toString() + "  Good)");
                break;
            case "SNOW":
                coordinates = new Coordinates(longitude, latitude, height - 15);
                logger.info(toString() + "  Good");
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}