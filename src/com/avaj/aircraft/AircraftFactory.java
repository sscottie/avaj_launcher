/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   AircraftFactory.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 19:19:47 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 21:06:54 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package com.avaj.aircraft;

import com.avaj.exceptions.AircraftCreateException;
import com.avaj.coordinates.Coordinates;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name,
                                    int longitude, int latitude, int height) {
        if (AircraftType.BALLOON.getType().equals(type) || AircraftType.BALLOON.getMd5().equals(type)) {
            return new Baloon(name, new Coordinates(longitude, latitude, height));
        } else if (AircraftType.HELICOPTER.getType().equals(type) || AircraftType.HELICOPTER.getMd5().equals(type)) {
            return new Helicopter(name, new Coordinates(longitude, latitude, height));
        } else if (AircraftType.JETPLANE.getType().equals(type) || AircraftType.JETPLANE.getMd5().equals(type)) {
            return new Jetplane(name, new Coordinates(longitude, latitude, height));
        } else {
            throw new AircraftCreateException("Aircraft of type \"" + type + "\"... is that legal?");
        }
    }
}