/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   AircraftCreateException.java                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 19:27:21 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 19:29:27 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package com.avaj.exceptions;

public class AircraftCreateException extends RuntimeException {
    public AircraftCreateException(String message) {
        super(message);
    }
}