#!/bin/bash

# USAGE:
# Script testing main class of package PACK,
# comparing its output files with those found in direction DIR

if [ $# != 2 ]
then
  echo "Usage: $0
  <package name>
  <direction where input and proper output can be found>." >&2
  exit 1
fi

PACK=$1
DIR=$2

COUNT=0

echo "Odpalam $PACK.Main na plikach *.in z folderu $DIR"

OUT=$(mktemp $DIR/out.XXXX)

time for f in $(ls $DIR/*.in)
do
  echo "Przetwarzam $(basename $f):"
  java $PACK.Main <$f 1>$OUT
  diff ${f%in}out $OUT
  if diff ${f%in}out $OUT >/dev/null
  then
    echo "TEST OK"
  else
    echo "TEST WRONG"
#    exit 1
    COUNT=$((COUNT+1))
  fi
done

echo "Liczba błędnych testów: $COUNT"

rm $DIR/out*
