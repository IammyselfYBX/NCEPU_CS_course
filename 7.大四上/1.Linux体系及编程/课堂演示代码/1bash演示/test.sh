#!/bin/sh
echo -n "Enter your login name:"
read name
if [ "$name" = "$USER" ];
then
        echo "Hello, $name , how are you today?"

else
        echo "Your are not $USER , so who are you ?"
fi
