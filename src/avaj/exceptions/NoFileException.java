/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   NoFileException.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2021/03/13 16:55:11 by sscottie          #+#    #+#             */
/*   Updated: 2021/03/13 16:57:29 by sscottie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.exceptions;

public class NoFileException extends RuntimeException {
    public NoFileException(String message) {
        super(message);
    }
}