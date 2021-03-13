# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    clear_class.sh                                     :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: sscottie <sscottie@student.42.fr>          +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2021/03/13 17:01:12 by sscottie          #+#    #+#              #
#    Updated: 2021/03/13 17:01:48 by sscottie         ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

#!/bin/bash

rm -rf sources.txt
find * -name "*.class" > sources.txt
while read LINE
    do rm -rf $LINE
done < sources.txt
rm -rf sources.txt
rm -rf simulation.txt