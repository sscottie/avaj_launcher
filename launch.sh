# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    launch.sh                                          :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2021/03/13 16:41:23 by sscottie          #+#    #+#              #
#    Updated: 2021/03/13 17:11:05 by sscottie         ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

#!/bin/bash

./clear_class.sh
find * -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
cd src
java avaj.Avaj ../scenario.txt