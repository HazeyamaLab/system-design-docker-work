#!/bin/bash

echo Initializing Ubuntu
sudo apt-get update && sudo apt-get install wget ca-certificates
git clone https://github.com/sato064/inspection-gpt.git
cd inspection-gpt
code .