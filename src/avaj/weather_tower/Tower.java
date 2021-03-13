/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Tower.java                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 17:39:25 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 17:50:05 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.weather_tower;

// import avaj.aircraft.Flyable;

import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

public abstract class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();
	private Logger logger = Logger.getLogger("Logger");

	public void register(Flyable flyable) {
		observers.add(flyable);
		logger.info("Tower says: " + flyable.toString() + " registered to weather tower");
	}

	void unregister(Flyable flyable) {
		observers.remove(flyable);
		logger.info("Tower says: " + flyable.toString() + " landed without surprises. Congrats!")
	}

	protected void conditionsChanged() {
		List<Flyable> unregistered = new ArrayList<Flyable>();
		for (Flyable flyable : observers) {
			flyable.updateConditions();
			if (flyable.getCoordinates().getHeight() <=) {
				unregistered.add(flyable);
			}
		}
		for (Flyable flyable: unregister) {
			unregister(flyable);
		}
	}
}
