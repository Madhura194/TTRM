#!/bin/sh

# Author : Madhura Gondhalekar

sudo su
docker stop ttrm-bcknd-server
docker rm -v ttrm-bcknd-server
docker rmi ttrm-bcknd:latest
docker build -t ttrm-bcknd .
docker run -p 8088:8088 ttrm-bcknd --name=ttrm-bcknd-server
echo "TTRM Java server started successfully ...."


