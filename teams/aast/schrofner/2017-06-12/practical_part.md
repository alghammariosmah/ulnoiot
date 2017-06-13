#Practical part

There are two power cables, connect one to the lock and the other one to the relay.
Then connect the relay with the lock with another cable.

To control the lock, first connect to the pi, then to the wemos using "console"
Connect to the mqtt server by issuing "mqtt("192.168.12.1", "lock")"
Call "reset" and "import ulnoiot.shield.relay"
Check if the device is recognised by calling "devices"
And finally call "run" to listen for messages

Switch to the pi again and issue "mqtt_send lock/relay/set on" "mqtt_send lock/relay/set off" to lock and unlock the lock.

Found out that the order of "mqtt" and "import" is important. It was not working, when we tried to execute the import statement first!

Follow the steps defined in nfc-install.txt to setup the NFC reader.
In pi-config look under "Interface Options" to find the SPI option.
