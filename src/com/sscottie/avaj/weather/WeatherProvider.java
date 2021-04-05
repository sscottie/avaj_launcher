/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherProvider.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 19:38:56 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 20:09:31 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package com.sscottie.avaj.weather;

import com.sscottie.avaj.coordinates.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherSimulator;
    private static String[] weather = new String[]{"SUN", "SNOW", "RAIN", "FOG"};

    private WeatherProvider() {}

    public static WeatherProvider provideWeather() {
        if (weatherSimulator == null) {
            weatherSimulator = new WeatherProvider();
        }
        return weatherSimulator;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int randomInt = ((int) (Math.random() * (coordinates.getLongitude()) + coordinates.getLatitude() + coordinates.getHeight())) % 4;
        return weather[randomInt];
    }
}