#!/bin/bash

#caminho=$(pwd);
caminho='javafx/lib';

javac --module-path $caminho --add-modules javafx.controls Interface.java;
java --module-path $caminho  --add-modules javafx.controls Interface;
rm *.class;