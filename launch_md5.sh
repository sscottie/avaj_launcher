#!/bin/bash

./clear_class.sh
find * -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
cd src
java com.avaj.Avaj ../scenario_md5.txt