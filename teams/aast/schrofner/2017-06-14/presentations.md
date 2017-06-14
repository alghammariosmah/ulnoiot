#Presentations

##CAN Bus
controller area network
automotive field
use it in vehicles
standardised in 1994
reliable protocol in harsh conditions

up to ~1000 meters, but then only 50kbit/s
CRC for data protection, can detect errors

CSMA/CA collision avoidance, using priorities to resolve collisions

arduino shield available, ~10$

##SPI (our own)
normally a few centimetres
~ 12mbit/s

##X10
for electronic devices, home automation
uses electrical wiring of household
120 khz
3 rooms distance
up to 256 devices

unit code consists of:
house code (A-P), unit code(1-16)

4bit command

20-50€ 

there exist bridges which allow to translate the x10 protocol to web service API

##Zigbee
standard developed in 2003
control & sensor networks
based on IEEE standard
created by zigbee alliance

low data rate, low power consumption, small packet devices
unlicensed bands
2.4 ghz
868 mhz

topologies: star, cluster tree, mesh

states: active sleep
modes: beacon, non-beacon

environmental monitoring, home monitoring, agricultural monitoring

##Z-Wave
developed by danish startup zen-sys
proprietary
wireless
full mesh networks, no coordinator
sub 1ghz
up to 100 kbps
supports AES123 encryption, IPv6

most used solution in wireless control
used in residential area

##1wire
bidirectional, half duplex
master/slave
slaves have unique id
2.8v to 5.25v
usage: temp sensors, timers, memory, battery, authentication
in comparison to nfc: need physical connection, no air gap
standard speed: 16kbps
overdrive mode: 125kpbs
no collision avoidance

##I^2C
normal mode: 100kbps
fast mode: 400kbps
ultra fast mode: 5mbits

master-slave

hardware internally used
low-speed
monitors, displays, reading sensors
wemos natively support

##KNX
OSI-based network communication
for building automation
several communication media: twisted pair wiring, powerline networking, radio, infrared, ethernet
16 bit address space -> 65.536 nodes
divided into lines, each line 256 devices
15 lines can be combined, 1 line used as backbone
30v supply voltage

##RS232 / RS422 / RS485 / DMX-512
serial bus systems
1960
lost a lot of use-cases to usb
reliable and cheap
transmission rates not as good as usb or ethernet

RS232
256kbps
15m length
full-duplex

RS422
up to 10mbps
widespread on early macintosh
full-duplex

RS485
multipoint systems supported
also up to 10mbps
half or full-duplex
collision detection in half-duplex

DMX512
control stage lighting/fog machines
topology: daisy chaining
5 pins recommended, but 3 pins often used (cheaper)
