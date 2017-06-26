To make sure the lock is only locked/unlocked when the button state is changed, add this to fhem's config:

attr mqtt_button event-on-change-reading state

This also allows to use the client android application along with the button.
