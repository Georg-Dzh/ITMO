#!/bin/bash

chmod -R 777 lab0
rm -r lab0

mkdir lab0
mkdir lab0/bellsprout
mkdir lab0/bellsprout/dragonite
touch lab0/bellsprout/slakoth
mkdir lab0/bellsprout/graveler
touch lab0/bellsprout/tranquill
touch lab0/gabite
touch lab0/slowking
touch lab0/snivy
mkdir lab0/tympole
mkdir lab0/tympole/hydreigon
touch lab0/tympole/servine
mkdir lab0/tympole/electrode
touch lab0/tympole/machoke
mkdir lab0/tympole/scolipede
mkdir lab0/ursaring
touch lab0/ursaring/starmie
mkdir lab0/ursaring/togetic
touch lab0/ursaring/jigglypuff
mkdir lab0/ursaring/magneton
touch lab0/ursaring/chimecho
echo "Способности = Scratch Yawn Encore Slack
Off Faint Attack Amnesia Covet Chip Away
Counter Flail" > lab0/bellsprout/slakoth
echo "Тип покемона = NORMAL FLYING" > lab0/bellsprout/tranquill
echo "Развитые способности = Rough Skin" > lab0/gabite
echo "Тип покемона = WATER PSYCHIC" > lab0/slowking
echo "Возможности = Overland=6 Surface=4
Burrow=2 Jump=1 Power=2 Intelligence=4
Sprouter=0 Stealth=0" > lab0/snivy
echo "Способности = Leer Vine Whip Wrap Growth
Leaf Tornado Leech Seed Mega Drain Slam
Leaf Blade Coil Giga Drain Wring Out
Gastro Acid Leaf Storm" > lab0/tympole/servine
echo "Способности = Focus Guts No Guard" > lab0/tympole/machoke
echo "Способности = Torrent Mind Mold Natural
Cure Illuminate" > lab0/ursaring/starmie
echo "Тип диеты = Herbivore" > lab0/ursaring/jigglypuff
echo "Тип покемона = PSYCHIC NONE" > lab0/ursaring/chimecho


chmod u=wx,g=x,o=rx lab0/bellsprout
chmod 570 lab0/bellsprout/dragonite
chmod 064 lab0/bellsprout/slakoth
chmod 751 lab0/bellsprout/graveler
chmod 046 lab0/bellsprout/tranquill
chmod 066 lab0/gabite
chmod u=r,g=r,o= lab0/slowking
chmod u=rw,g=rw,o= lab0/snivy
chmod 500 lab0/tympole
chmod 711 lab0/tympole/hydreigon
chmod 600 lab0/tympole/servine
chmod 317 lab0/tympole/electrode
chmod 006 lab0/tympole/machoke
chmod 305 lab0/tympole/scolipede
chmod 711 lab0/ursaring
chmod 664 lab0/ursaring/starmie
chmod u=rwx,g=rwx,o= lab0/ursaring/togetic
chmod 666 lab0/ursaring/jigglypuff
chmod 755 lab0/ursaring/magneton
chmod 664 lab0/ursaring/chimecho

chmod 715 lab0/bellsprout
chmod 446 lab0/bellsprout/tranquill
chmod 464 lab0/bellsprout/slakoth
chmod 466 lab0/gabite
chmod 717 lab0/tympole/electrode
chmod 700 lab0/tympole
chmod 406 lab0/tympole/machoke
chmod 705 lab0/tympole/scolipede
ln -s /home/studs/s561154/lab0/bellsprout lab0/Copy_49
ln lab0/snivy lab0/ursaring/starmiesnivy
cat lab0/ursaring/jigglypuff lab0/tympole/servine > lab0/slowking_56
ln -s /home/studs/s561154/lab0/slowking lab0/ursaring/starmieslowking
cp lab0/gabite lab0/tympole/electrode
cp -r lab0/bellsprout lab0/tympole/hydreigon
cat lab0/slowking > lab0/tympole/servineslowking
ls -lR lab0

wc -l lab0/bellsprout/slakoth lab0/bellsprout/tranquill lab0/tympole/servine lab0/tympole/machoke lab0/ursaring/starmie > /tmp/lab0_wc_result.txt 2>&1
ls -ldt lab0/m* lab0/*/m* lab0/*/*/m* lab0/*/*/*/m* 2>&1
cat lab0/*e lab0/*/*e lab0/*/*/*e lab0/*/*/*/*e | sort | cat -n
ls -ldct lab0/s* lab0/*/s* lab0/*/*/s* lab0/*/*/*/s* 2>/dev/null
ls -ldut lab0/*e lab0/*/*e lab0/*/*/*e lab0/*/*/*/*e 2>/dev/null | head -n 4
cat lab0/bellsprout/slakoth lab0/bellsprout/tranquill lab0/tympole/servine lab0/tympole/machoke 2>/dev/null | grep "NO"

rm -f lab0/slowking
rm -f lab0/tympole/machoke
rm -f lab0/ursaring/starmieslowki*
rm -f lab0/ursaring/starmiesni*
rm -r lab0/ursaring/magneton
rm -r lab0/ursaring
chmod u=wx,g=x,o=rx lab0/bellsprout
chmod 046 lab0/bellsprout/tranquill
chmod 064 lab0/bellsprout/slakoth
chmod 066 lab0/gabite
chmod 317 lab0/tympole/electrode
chmod 500 lab0/tympole
chmod 305 lab0/tympole/scolipede




