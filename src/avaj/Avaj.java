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

package avaj;

// import avaj.aircraft;
import avaj.exceptions.NoFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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