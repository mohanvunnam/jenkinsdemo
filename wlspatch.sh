#!/bin/bash
echo "Hello from $HOSTNAME"
export DIR=/home/mvunnam
export WL_VERSION=`ls $DIR/Jenkins/jenkinsdemo | grep -i wlspatch | awk -F\- '{print $NF}'`

echo "$WL_VERSION"

echo "$WL_VERSION at `date`" >> /tmp/testwls.txt
