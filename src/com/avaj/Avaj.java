/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Avaj.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 13:56:40 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 17:11:15 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package com.avaj;

import com.avaj.aircraft.AircraftFactory;
import com.avaj.aircraft.Flyable;
import com.avaj.coordinates.Coordinates;
import com.avaj.exceptions.AircraftCreateException;
import com.avaj.exceptions.IncorrectScenarioFileException;
import com.avaj.exceptions.NoFileException;
import com.avaj.weather_tower.WeatherTower;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class Avaj {
	private static int iterations;

	public static void main(String[] args) {
		try {
			if (args.length != 1) {
				throw new NoFileException("There is no scenario.txt file");
			}
			createLogger();
			WeatherTower weatherTower = WeatherTower.getWeatherTower();
			List<Flyable> aircrafts = readScenario(args[0]);
			for (Flyable aircraft : aircrafts) {
				aircraft.registerTower(weatherTower);
			}
			for (int i = 0; i < iterations; i++) {
				weatherTower.simulate();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static List<Flyable> readScenario(String fileName) {
		try {
			File file = new File(fileName);
			BufferedReader sc = new BufferedReader(new FileReader(file));
			List<Flyable> airCrafts = new ArrayList<>();
			iterations = Integer.parseInt(sc.readLine());
			if (iterations <= 0) {
				throw new IncorrectScenarioFileException("The number of iteration is less or equal 0");
			}
			String line;
			do {
				line = sc.readLine();
				if (line != null) {
					airCrafts.add(getAircraft(line.split("\\s+")));
				}
			} while (line != null);
			sc.close();
			return airCrafts;
		} catch (NoFileException | IOException e) {
			throw new NoFileException("Scenario file not found");
		} catch (NumberFormatException e) {
			throw new IncorrectScenarioFileException("Incorrect number of iteration");
		}
	}

	private static Flyable getAircraft(String[] aircraftData) {
		if (aircraftData.length != 5) {
			throw new AircraftCreateException("Incorrect aircraft data");
		}
		Coordinates coordinates = checkAndGetCoordinates(aircraftData[2], aircraftData[3], aircraftData[4]);

		return AircraftFactory.newAircraft(aircraftData[0], aircraftData[1], coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
	}

	private static Coordinates checkAndGetCoordinates(String strLongitude, String strLatitude, String strHeight) {
		try {
			int longitude = Integer.parseInt(strLongitude);
			int latitude = Integer.parseInt(strLatitude);
			int height = Math.min(Integer.parseInt(strHeight), 100);
			if (longitude < 0 || latitude < 0 || height < 0) {
				throw new IncorrectScenarioFileException("Incorrect coordinates");
			}
			return new Coordinates(longitude, latitude, height);
		} catch (Exception e) {
			throw new IncorrectScenarioFileException("Incorrect coordinates");
		}
	}

	public static void createLogger() {
		Logger logger = Logger.getLogger("Logger");
		try {
			FileHandler fileHandler = new FileHandler("./../simulation.txt");
			logger.addHandler(fileHandler);
			fileHandler.setFormatter(new Formatter() {
				@Override
				public String format(LogRecord record) {
					return record.getMessage() + "\n";
				}
			});
			logger.setUseParentHandlers(false);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}