#!/usr/bin/env bash

GREEN='\033[0;32m'
NC='\033[0m' # No Color

echo -e "${GREEN}Hello, we will update your code.${NC}"
git config --global user.name "Aymane REIDA"
git config --global user.email "aymanerei53@gmail.com"
git checkout master
git pull
echo -e "${GREEN}Write your branch name to delete : ${NC}"
read -r delete
git branch --delete $delete
echo -e "${GREEN}Write your branch name to checkout : ${NC}"
read -r checkout
git checkout -b $checkout
clear
echo -e "${GREEN}Code updated successfully.${NC}"