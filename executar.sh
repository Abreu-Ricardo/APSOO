#!/bin/bash

#DIRECTORY=$(cd `dirname $0` && pwd)
DIRECTORY=$(pwd);
caminho="$DIRECTORY/javafx/lib";

export JAVA=/home/ricardo/Documents/APSOO/Trabalho/javafx/lib;

echo $JAVA;

javac --module-path $PATH_TO_FX --add-modules javafx.controls Prot.java;
java --module-path $PATH_TO_FX  --add-modules javafx.controls Prot;