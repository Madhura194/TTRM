#!/bin/sh

# Author : Madhura Gondhalekar

sudo docker stop ttrm-dispredict
sudo docker rm -v ttrm-dispredict
sudo docker rmi dispredict:latest
sudo docker build -t dispredict .
sudo docker run -p 5000:5000 -d --name ttrm-dispredict dispredict