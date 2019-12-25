#!/bin/sh
java -XX:InitialRAMPercentage=${JAVA_MIN_PERCENTAGE} -XX:MaxRAMPercentage=${JAVA_MAX_PERCENTAGE} $(echo $args) -jar $executable $jarAr