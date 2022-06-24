#!/bin/bash
echo "Hello from $HOSTNAME"
export DIR=/home/mvunnam
export WL_VERSION=`ls /tmp/ | grep -i wlspatch | awk -F\- '{print $NF}'`

echo "$WL_VERSION"
sleep 60
echo "$WL_VERSION and $DIR at `date`" >> /tmp/testwls.txt
