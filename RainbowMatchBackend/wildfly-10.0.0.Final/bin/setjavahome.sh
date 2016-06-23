#!/bin/bash

OLD_JAVA_HOME=$JAVA_HOME

JAVA_HOME=/c/Program\ Files/Java/jdk1.8.0_51

$1

JAVA_HOME=$OLD_JAVA_HOME
