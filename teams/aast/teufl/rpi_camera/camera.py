import os
import paho.mqtt.client as mqtt

def on_connect(client, userdata, flags, rc):
	print("Connected to broker 192.168.12.1")
	client.subscribe("camera/rpi")

def camera_init():
	os.system("sudo modprobe bcm2835-v4l2")

def camera_off():
	os.system("sudo killall motion")

def camera_on():
	os.system("sudo motion")

def on_message(client, userdata, msg):
	if str(msg.payload) == "b'on'":
		print("Camera on")
		camera_on()
		client.publish("camera/rpi/status", "on")
	elif str(msg.payload) == "b'off'":
		print("Camera off")
		camera_off()
		client.publish("camera/rpi/status", "off")

camera_init()

client = mqtt.Client()
client.on_connect = on_connect
client.on_message = on_message

client.connect("192.168.12.1")
client.loop_forever()
