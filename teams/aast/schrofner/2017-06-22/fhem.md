##Adding advanced triggers to fhem

We also added our temperature simulator to fhem with the following commands:

```
define mqtt_temp MQTT_DEVICE
attr mqtt_temp subscribeReading_temp tempchan/temperature
```

Then we defined a trigger to automatically unlock the mqtt lock, when the temperature is over 25 degrees.
To do so, we used the method "define temp_lock notify mqtt_temp". Followed by this definition comes a method, which is called everytime mqtt_temp sends an event.
To only open the lock, when the temperature is higher than 25 degrees, we created the following condition:

```
mqtt_temp {
if($EVTPART1 > 25){
  fhem "set mqtt_lock on"
} else {
  fhem "set mqtt_lock off"
  }
}
```

##Integrating Kodi into fhem
Kodi is super simple to add. Just enter:

```
define kodi KODI 192.168.1.104 tcp 
```

And it can be controlled via fhem.
To play the media currently paused, for example, one can execute "set kodi play all". To pause the currently played media, use "set kodi pause all".

Also it is possible to react on events published by Kodi. For example to do something, when the playStatus on the mediacenter changes, the following method can be used:

```
define kodi_lock notify kodi {
 if($EVTPART0 eq "playStatus:") {
    if($EVTPART1 eq "playing"){
      fhem "set mqtt_lock on"
    } else {
      fhem "set mqtt_lock off"
    }
  }
}
```

##Adding the LED to fhem

```
define mqtt_led MQTT_DEVICE
attr mqtt_led subscribeReading_state led/1/state
attr mqtt_led subscribeReading_color led/1/color
attr mqtt_led publishSet_state on off led/1/turn
attr mqtt_led publishSet_color led/1
```
