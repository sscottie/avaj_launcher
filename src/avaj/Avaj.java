/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Avaj.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 13:56:40 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 16:58:09 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj;

// import avaj.aircraft;
import avaj.exceptions.NoFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Avaj {
	private static int iterations;

	public static void main(String[] args) {
		if (args.length != 1) {
			throw new NoFileException("There is no scenario.txt file");
		}
		
	}
}