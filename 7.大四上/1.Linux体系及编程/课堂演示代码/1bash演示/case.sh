#! /bin/sh
if [ $# < 1 ]
then 
        echo Usage:$0 number
        exit
fi

case $1 in 
        1)
                echo monday;;
        2)
                echo tuesday;;
        3)
                echo wednesday;;
        *)
                echo invalidate;;
esac


