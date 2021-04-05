/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherTower.java                                  :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 17:39:22 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 20:10:27 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package com.avaj.weather_tower;

import com.avaj.coordinates.Coordinates;
import com.avaj.weather.WeatherProvider;

public class WeatherTower extends Tower {
	private static WeatherTower weatherTower;
	private static WeatherProvider weatherSimulator = WeatherProvider.provideWeather();

	private WeatherTower() {}

	public String getWeather(Coordinates coordinates) {
		return weatherSimulator.getCurrentWeather(coordinates);
	}

	public void simulate() {
		changeWeather();
	}

	private void changeWeather() {
		this.conditionsChanged();
	}

	public static WeatherTower getWeatherTower() {
		if (weatherTower == null) {
			weatherTower = new WeatherTower();
		}
		return weatherTower;
	}
}
