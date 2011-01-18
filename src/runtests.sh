#!/bin/sh

if [ $# -eq 0 ] ; then 
    echo "Missing parameter. Usage: runtests.sh [TESTFILES]"
    exit 1;
fi

export CLASSPATH=../sp3files/libs/junit.jar:.
java org.junit.runner.JUnitCore $@
