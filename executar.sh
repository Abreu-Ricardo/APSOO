#!/bin/bash

#DIRECTORY=$(cd `dirname $0` && pwd)

DIRECTORY=$(pwd);

caminhoFx="$DIRECTORY/javafx/lib";
caminhoJdbc="mysql-connector/mysql-connector.jar";

echo $caminhoFx;
echo $caminhoJdbc;

javac -classpath $caminhoJdbc --module-path $caminhoFx --add-modules javafx.controls *.java;
java  -classpath .:$caminhoJdbc --module-path $caminhoFx --add-modules javafx.controls Interface;

rm *.class;