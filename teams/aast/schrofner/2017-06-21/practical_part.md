##Using the noise sensor on the Wemos

Connect ground with ground and use 3.3v on the + pin.
Finally connect A0 with A0 to be able to read the values from the analog port.
Start up the wemos and try reading the value on the analog port with "a0.read()".

To publish updates you can connect to the mqtt server with
mqtt("192.168.12.1", "noise")

And then set the analog port to publish mqtt messages with:
analog("noise1", threshold=None, precision=1)

Finally call run() to publish the updates.

##Using the motion sensor on the Wemos
Plug in the motion sensor. We connected it to 3.3v, GRD and D2.

Subscribe to the mqtt server:
mqtt("192.168.12.1", "motion")

Send mqtt messages with:
button("motion1", d2, "detected", "not detected") 
run()

##Installing FHEM
DEPRECATED
On Arch Linux it can be installed with:
sudo aura -A fhem

Before fhem can be launched as normal user, the configuration has to be changed, so that it uses directories for its log, which are writable for normal users.

I just pointed it towards a "fhem" folder inside my home directory.

```
attr global logfile /home/flosch/fhem/fhem-%Y-%m.log
attr global statefile /home/flosch/fhem/fhem.save

attr autocreate filelog /home/flosch/fhem/%NAME-%Y.log
```

I had the problem, that it was missing the RTypes module, so i downloaded it from:
https://github.com/mhop/fhem-mirror/blob/master/fhem/FHEM/RTypes.pm
And placed it in: /usr/share/fhem/FHEM

Then you can launch fhem with:
perl /bin/fhem.pl /etc/fhem.cfg

After that fhem booted and was accessible through: 127.0.0.1:8083.

NEW
As the method using the user repository seems quite buggy, I decided to clone the current version from github.

git clone https://github.com/mhop/fhem-mirror.git

Then I installed the dependencies, which I knew of.
sudo aura -S perl-json
sudo aura -S perl-xml-sax-expat
sudo aura -S perl-xml-simple

Also (in order to be able to use mqtt) install Net::MQTT::Message (maybe also Net::MQTT::Simple) using CPAN: cpan -> install Net::MQTT::Message

Then add the following to fhem.cfg
attr global motd none

Then start fhem by issuing:
perl ./fhem.pl ./fhem.cfg

Update fhem by issuing:

```
attr global backup_before_update 0
save
update
```

To kill fhem, the quite brutal but effective "killall perl" can be used.

With the "help" command, one can get an overview over the available commands.

To define our lock inside fhem over mqtt use:

```
define mqtt MQTT 192.168.12.1:1883
attr mqtt_lock publishSet on off lock/relay/set
attr mqtt_lock subscribeReading_state lock/relay
```

To save the current settings to the configuration file, use "save".

The device can then be controlled via the web interface.

Next connect a button to the Wemos and publish its state via MQTT with:
```
mqtt("192.168.12.1", "button")
button("lower", d1, "depressed", "pressed")
run()
```

You can then add this button the fhem as well:

```
define mqtt_button MQTT_DEVICE
attr mqtt_button subscribeReading_state button/lower
```

Finally you can link the button and the lock with the following snippet:

```
define button_unlock notify mqtt_button:pressed set mqtt_lock on
define button_lock notify mqtt_button:depressed set mqtt_lock off
```

This will unlock the lock as long as the button is pressed and lock it again if the button is depressed.
