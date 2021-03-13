/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Aircraft.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 19:04:33 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 19:13:59 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.aircraft;

import avaj.coordinates.Coordinates;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    public Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return ++idCounter;
    }

    @Override
    public String toString() {
        return " #" + name + " (" + id +")";
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}