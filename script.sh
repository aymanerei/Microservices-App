#!/usr/bin/env bash

GREEN='\033[0;32m'
NC='\033[0m' # No Color

echo -e "${GREEN}Hello, we will push the code source to Gitlab.${NC}"
git config --global user.name "Aymane REIDA"
git config --global user.email "aymanerei53@gmail.com"
echo -e "${GREEN}Write your commit message : ${NC}"
read -r message
git status
git add .
git commit -m "$message"
echo -e "${GREEN}Write your branch to push : ${NC}"
read -r branch
git push -u origin $branch
clear
echo -e "${GREEN}Code source pushed to Gitlab.${NC}"