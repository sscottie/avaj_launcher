# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    launch.sh                                          :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2021/03/13 16:41:23 by sscottie          #+#    #+#              #
#    Updated: 2021/03/13 16:52:44 by sscottie         ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

#!/bin/bash

find * -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
cd src
java avaj.Avaj ../scenario.txt