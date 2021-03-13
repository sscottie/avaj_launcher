/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   AircraftFactory.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 19:19:47 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 21:00:38 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.aircraft;

import avaj.exceptions.AircraftCreateEsception;
import avaj.coordinates.Coordinates;

public class AircraftFactory {
    private static final BALOON_MD5 = "994736b4f0aec72f6e5ae580051d012f";
    private static final HELICOPTER_MD5 = "e999487829c0fe97e0dea0d03a1417e9";
    private static final JETPLANE_MD5 = "554cd647d6b135f7e36ab1214c5e816a";

    public static Flyable newAircraft(String type, String name, 
                                    int longitude, int latitude, int height) {
        if (AircraftType.BALLOON.getType().equals(type) || BALOON_MD5.equals(type)) {
            return new Baloon(name, new Coordinates(longitude, latitude, height));
        } else if (AircraftType.HELICOPTER.getType().equals(type) || HELICOPTER_MD5.equals(type)) {
            return new Helicopter(name, new Coordinates(longitude, latitude, height));
        } else if (Aircraft.JETPLANE.getType().equals(type) || JETPLANE_MD5.equals(type)) {
            return new JetPlane(name, new Coordinates(longitude, latitude, height));
        } else {
            throw new AircraftCreateException("Aircraft of type \"" + type + "\"... is that legal?");
        }
    }
}