package com.avaj.aircraft;

import com.avaj.coordinates.Coordinates;
import com.avaj.weather_tower.WeatherTower;

import java.util.logging.Logger;

public class Jetplane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private Logger logger = Logger.getLogger("Logger");

    public Jetplane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        switch (this.weatherTower.getWeather(this.coordinates)) {
            case "RAIN":
                coordinates = new Coordinates(longitude, latitude + 5, height);
                logger.info(toString() + "  Let's be wet.");
                break;
            case "FOG":
                coordinates = new Coordinates(longitude, latitude + 1, height);
                logger.info(toString() + "  Let's sit down and no one will know.");
                break;
            case "SUN":
                coordinates = new Coordinates(longitude, latitude + 10, height + 2);
                logger.info(toString() + "  Very good.");
                break;
            case "SNOW":
                coordinates = new Coordinates(longitude, latitude, height - 7);
                logger.info(toString() + "  I turn on the wipers.");
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
        return "JetPlane " + super.toString();
    }
}