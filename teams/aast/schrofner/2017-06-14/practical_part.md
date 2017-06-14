To use the display import the driver for the shield with:
import ulnoiot.shield.devkit1_display

It will automatically display the current IP of the device on the display.

If you want to print text, you can use:
devices["dp1"].print("text")

To light up individual pixels use
devices["dp1"].pixel(x,y,True)
devices["dp1"].show()

x and y being the coordinates of the pixel you want to light up.
By handing over False you can also turn off the specified pixel again.
"show" has to be called, as otherwise the display would not be updated.

##Homeassistant
Install and launch home assistant with:
pip3 install homeassistant
hass --open-ui

To add the lock to homeassistant:
```yaml
lock:
  - platform: mqtt
    command_topic: "lock/relay/set"
    payload_lock: "on"
    payload_unlock: "off"
    name: "Lock"
```

So that mqtt works, we need to define the mqtt broker:
```yaml
mqtt:
  broker: 192.168.12.1
  client_id: home-assistant-flo
```

