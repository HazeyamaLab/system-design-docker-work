#!/bin/bash

echo Initializing Ubuntu
sudo apt-get update && sudo apt-get install wget ca-certificates
git clone https://github.com/HazeyamaLab/system-design-docker.git
cd system-design-docker
code .