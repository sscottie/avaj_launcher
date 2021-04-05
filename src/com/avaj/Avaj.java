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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class Avaj {
	private static int iterations;

	public static void main(String[] args) {
		if (args.length != 1) {
			throw new NoFileException("There is no scenario.txt file");
		}
		logger();
		WeatherTower weatherTower = WeatherTower.getWeatherTower();
		List<Flyable> aircrafts = readScenario(args[0]);
		for (Flyable aircraft : aircrafts) {
			aircraft.registerTower(weatherTower);
		}
		for (int i = 0; i < iterations; i++) {
			weatherTower.simulate();
		}
	}

	private static List<Flyable> readScenario(String fileName) {
		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			List<Flyable> airCrafts = new ArrayList<Flyable>();
			iterations = Integer.parseInt(sc.nextLine());
			if (iterations <= 0) {
				throw new IncorrectScenarioFileException("The number of iteration is less or equal 0");
			}
			while (sc.hasNext()) {
				airCrafts.add(getAircraft(sc.nextLine().split(" ")));
			}
			sc.close();
			return airCrafts;
		} catch (NoFileException e) {
			throw new NoFileException("Scenario file not found");
		} catch (NumberFormatException e) {
			throw new IncorrectScenarioFileException("Incorrect number of iteration");
		} catch (FileNotFoundException e) {
			throw new NoFileException("Scenario file not found");
		}
	}

	private static Flyable getAircraft(String[] aircraftData) {
		if (aircraftData.length != 5) {
			throw new AircraftCreateException("Incorrect aircraft data");
		}
		String name = aircraftData[1];
		Coordinates coordinates = checkAndGetCoordinates(aircraftData[2], aircraftData[3], aircraftData[4]);

		return AircraftFactory.newAircraft(aircraftData[0], name, coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
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

	public static void logger() {
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