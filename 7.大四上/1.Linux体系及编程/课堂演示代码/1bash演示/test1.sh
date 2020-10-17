#!/bin/sh

echo -n "Enter a path:"; read x
if cd $x; then
        echo "Iam in $x and it contains"; ls
else
        echo "The directory $x does not exist";
        exit 1
fi
