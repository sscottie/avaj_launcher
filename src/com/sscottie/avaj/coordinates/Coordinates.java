/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Coordinates.java                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 19:32:29 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 19:37:37 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package com.sscottie.avaj.coordinates;

public class Coordinates {
    private final int longitude;
    private final int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        setHeight(height);
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = Math.max(Math.min(height, 0), 100);
    }
}