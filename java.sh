#!/bin/bash
JAR="mysql-connector-j-9.3.0.jar"

echo -e "Compiling Java files... \n" 
javac -cp "$JAR" *.java

if [ $? -eq 0 ]; then
    echo -e "Compilation successful! \n " 
else
    echo -e "Compilation failed! \n"
    exit 1
fi

echo -e "Running program... \n"
java -cp ".:$JAR" Main
