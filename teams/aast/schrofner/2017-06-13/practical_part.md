Copy the Read.py found inside /home/pi/ulnoiot/pi-nfc/MFRC522-python.

Install a python mqtt library with "pip install paho-mqtt"
Import the mqtt library into the newly copied file "import paho.mqtt.client as mqtt"

Create a mqtt client and connect to the mqtt server at the beginning of the file with:

client = mqtt.Client()
client.connect("192.168.12.1")

To test unlocking the lock, you can send an mqtt message with:

client.publish("lock/relay/set", "on")

This should be added in the section, where a nfc tag is detected.

We then created the following script to function as a broker:
```
import paho.mqtt.client as mqtt
from threading import Timer

authorized_keys = ["b'102-247-124-65'"]

# The callback for when the client receives a CONNACK response from the server.                                                                                                                                    
def on_connect(client, userdata, flags, rc):
        print("Connected with result code "+str(rc))
        # Subscribing in on_connect() means that if we lose the connection and                                                                                                                                     
        # reconnect then subscriptions will be renewed.                                                                                                                                                            
        client.subscribe("nfc-id")

def lock():
        client.publish("lock/relay/set", "off")

def unlock():
        client.publish("lock/relay/set", "on")


# The callback for when a PUBLISH message is received from the server.                                                                                                                                             
def on_message(client, userdata, msg):
        print("checking if key: " + str(authorized_keys))
        print("received key: " + str(msg.payload))
        if str(msg.payload) in authorized_keys:
                print("valid key detected")
                unlock()
                timer = Timer(5.0, lock)
                timer.start()


client = mqtt.Client()
client.on_connect = on_connect
client.on_message = on_message

client.connect("192.168.12.1")

client.loop_forever()
```

To send the nfc id to the broker script, we adapted the mqtt code(inside Nfc-Lock.py) to the following:

```
data = str(uid[0])+"-"+str(uid[1])+"-"+str(uid[2])+"-"+str(uid[3])
client.publish("nfc-id", data)
```

Using those two scripts, you can unlock the lock with the hardcoded nfc tag and it will automatically lock after 5 seconds.


