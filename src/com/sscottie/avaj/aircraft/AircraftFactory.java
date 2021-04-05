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

package com.sscottie.avaj.aircraft;

import com.sscottie.avaj.exceptions.AircraftCreateException;
import com.sscottie.avaj.coordinates.Coordinates;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name,
                                      int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        AircraftType aircraftType = AircraftType.from(type);
        if (aircraftType == null) {
            throw new AircraftCreateException("Aircraft of type \"" + type + "\"... is that legal?");
        }

        switch (aircraftType) {
            case BALLOON:
                return new Baloon(name, coordinates);
            case HELICOPTER:
                return new Helicopter(name, coordinates);
            case JET_PLANE:
                return new JetPlane(name, coordinates);
            default:
                return null;
        }
    }
}