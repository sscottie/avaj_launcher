/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   AircraftFactory.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 19:19:47 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 19:27:00 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.aircraft;

import avaj.exceptions.AircraftCreateEsception;
import avaj.coordinates.Coordinates;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, 
                                    int longitude, int latitude, int height) {
        if (AircraftType.BALLOON.getType().equals(type)) {
            return new Baloon(name, new Coordinates(longitude, latitude, height));
        } else if (AircraftType.HELICOPTER.getType().equals(type)) {
            return new Helicopter(name, new Coordinates(longitude, latitude, height));
        } else if (Aircraft.JETPLANE.getType().equals(type)) {
            return new JetPlane(name, new Coordinates(longitude, latitude, height));
        } else {
            throw new AircraftCreateException("Aircraft of type \"" + type + "\"... is that legal?");
        }
    }
}