#Practical part

There are two power cables, connect one to the lock and the other one to the relay.
Then connect the relay with the lock with another cable.

To control the lock, first connect to the pi, then to the wemos using "console"
Call "reset" and "import ulnoiot.shield.relay"
Check if the device is recognised by calling "devices"
Connect to the mqtt server by issuing "mqtt("192.168.12.1", "lock")"
And finally call "run" to listen for messages

Switch to the pi again and issue "mqtt_send lock/relay/set on" "mqtt_send lock/relay/set off" to lock and unlock the lock.
