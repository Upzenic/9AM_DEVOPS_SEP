#!/bin/bash
Container_name="chinna"
for i in {1..10}
do
docker container ls | grep $Container_name$i
if [ $? == 0 ]
then
docker container rm -f $Container_name$i
docker container run -d --name $Container_name$i nginx
else
docker container run -d --name $Container_name$i nginx
fi
done
