#!/usr/bin/env bash

GREEN='\033[0;32m'
NC='\033[0m' # No Color

echo -e "${GREEN}Hello, we will push the code source to Gitlab.${NC}"
git config --global user.name "Aymane REIDA"
git config --global user.email "aymanerei53@gmail.com"
git init --initial-branch=master
echo -e "${GREEN}Write your Gitlab repository url : ${NC}"
read -r message
git remote add origin "$message"
git add .
git commit -m ":gift: Initial commit"
git push -u origin master
clear
echo -e "${GREEN}Code source pushed to Gitlab${NC}"