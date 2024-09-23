#!/bin/zsh

alias open-chrome="python ~/Documents/GitHub/chrome-multi-profile-link-opener/main.py"

open-chrome https://weibo.com/login.php
sleep 2
#龚俊
open-chrome https://weibo.com/p/100808b503e94e4f2f272c6e1cf79b59c41085
sleep 2
# #电视剧暗河传
# open-chrome https://weibo.com/p/100808241b9ceecb561bd8de83d5e2f69b3beb
# sleep 2
# #龚俊温客行
# open-chrome https://weibo.com/p/100808d3fa73b65abd6f2e91cf143c1726319f
# sleep 2
# #全世界最好的龚俊
# open-chrome https://weibo.com/p/1008085ec028479406bb9a4d3aa6fce4a2eb40
# sleep 2

cd ~/Documents/GitHub/bonus-bot
conda activate myselenium
python main.py
sleep 2

open -n -a "Google Chrome" --args --profile-directory="Default" "https://baike.baidu.com/item/%E9%BE%9A%E4%BF%8A/19919509"
sleep 1
open -n -a "Google Chrome" --args --profile-directory="Default" "https://www.hifini.com"
sleep 1
open -n -a "Google Chrome" --args --profile-directory="Default" "https://www.lvhtebook.com/?act=signinlst"
sleep 1
open -n -a "Google Chrome" --args --profile-directory="Default" "https://tieba.baidu.com/f?ie=utf-8&kw=%E9%BE%9A%E4%BF%8A&fr=search"
sleep 1
open -n -a "Google Chrome" --args --profile-directory="Default" "https://weibo.com/p/100808b503e94e4f2f272c6e1cf79b59c41085/super_index"
sleep 1
open -n -a "Google Chrome" --args --profile-directory="Default" "https://tjupt.org/torrents.php"
sleep 1
open -n -a "Google Chrome" --args --profile-directory="Default" "https://totheglory.im/browse.php?c=M"