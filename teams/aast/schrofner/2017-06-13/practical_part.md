Copy the Read.py found inside /home/pi/ulnoiot/pi-nfc/MFRC522-python.

Install a python mqtt library with "pip install paho-mqtt"
Import the mqtt library into the newly copied file "import paho.mqtt.client as mqtt"

Create a mqtt client and connect to the mqtt server at the beginning of the file with:

client = mqtt.Client()
client.connect("192.168.12.1")

To test unlocking the lock, you can send an mqtt message with:

client.publish("lock/relay/set", "on")

