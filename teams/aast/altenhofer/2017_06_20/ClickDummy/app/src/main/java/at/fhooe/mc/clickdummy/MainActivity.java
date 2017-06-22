package at.fhooe.mc.clickdummy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static MqttClient client;
    private static String TOPIC = "client/endpoint";
    private static int QOS = 2;
    private String broker = "tcp://192.168.1.104:1883"; // tcp: is necessary
    private String clientId = "android_client";
    private MemoryPersistence persistence = new MemoryPersistence();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Overview");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initConnection();
    }



    @Override
    protected void onDestroy() {
        closeConnection();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.button_light)
    public void lightBtn() {
        startActivity(new Intent(MainActivity.this, LightActivity.class));
    }

    @OnClick(R.id.button_media)
    public void lightMedia() {
        startActivity(new Intent(MainActivity.this, MediaActivity.class));
    }

    private void initConnection() {
        try {
            client = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            client.connect(connOpts);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            if (client.isConnected()) {
                client.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void publish(String _msg) {
        try {
            if(client.isConnected()) {
                MqttMessage message = new MqttMessage(String.valueOf(_msg).getBytes());
                message.setQos(QOS);
                client.publish(TOPIC, message);
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
