##Using the noise sensor on the Wemos

Connect ground with ground and use 3.3v on the + pin.
Finally connect A0 with A0 to be able to read the values from the analog port.
Start up the wemos and try reading the value on the analog port with "a0.read()".

To publish updates you can connect to the mqtt server with
mqtt("192.168.12.1", "noise")

And then set the analog port to publish mqtt messages with:
analog("noise1", threshold=None, precision=1)

Finally call run() to publish the updates.
