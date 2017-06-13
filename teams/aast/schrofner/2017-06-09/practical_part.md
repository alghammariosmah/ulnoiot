#Practical part
Plugin pi, connect to strongest ap using password: internetofthings

Open a terminal and use:
ssh pi@192.168.12.1

Using the password: ulnoiot

Once connected a byobu will open up
f2 can be used to create a new session

You can verify that you're connected with the correct pi by issuing "lsblk", then plugin a usb stick and run "lsblk" again to verify that the usb stick is detected

You can add your ssh key by adding your pub key to: /home/pi/.ssh/authorized_keys

Start the ulnoiot environment by using the "ulnoiot" command
Then you can flash wemosd1mini with the "flash_wemosd1mini" command
You can create the system by issuing the "deploy_wemosd1mini" command (twice as some folders are not created in the right order)

You can rename the wifi network and change the password by editing the /home/pi/ulnoiot/etc/ulnoiot.conf file

Using "console" you can connect to the wemosd1mini
Initialise the led by using "onboardled.init(Pin.OUT)"
Switch it on and off with: "onboardled.on()" and "onboardled.off()"

You can connect the wemosd1mini with the wifi of the raspberry pi by issuing:
wifi("teuschro","schroteu") replacing the two values with the name and the password of the wifi

You can make sure that the wifi is detected by issuing "wscan"

Once connected to the wifi, you need to take note of the ip address with "wip".
in our case: 192.168.12.18

You can change the address by editing the "wifi_config.py" with "lineedit("wifi_config.py", 3)"

"git pull" pulls the newest firmware changes onto the raspberry pi
"download_firmware" downloads the newest firmware
"fix_bin" to fix the binary
"flash_esp8266" to flash the new firmware onto the wimos
"deploy_wemosd1mini" to deploy the python scripts again

To turn on the onboard led, first initialise it with "onboardled.init(Pin.OUT)"

Then to turn it on and off use "onboardled.on()" and "onboardled.off()"

"reset" should be executed before connecting to the mqtt server

IMPORTANT: first connect to the mqtt server, before importing. otherwise it wouldn't work for us. 

To connect to the MQTT server on the raspberry pi, you can use "mqtt("192.168.12.1","test")"

To load the functions to control the led shield use "import devkit1_2led3but"

Finally use the "run" command so that the mqtt messages can be received

To turn on an LED, use "mqtt_send test/red/set on"
