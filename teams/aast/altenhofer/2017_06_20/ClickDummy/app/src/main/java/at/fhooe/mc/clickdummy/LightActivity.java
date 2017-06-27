package at.fhooe.mc.clickdummy;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

/**
 * Created by christian on 20.06.2017.
 */

public class LightActivity extends AppCompatActivity {

    @BindView(R.id.btn_lamp_1)
    ToggleButton btnLamp1;
    @BindView(R.id.btn_lamp_2)
    ToggleButton btnLamp2;
    @BindView(R.id.btn_lamp_3)
    ToggleButton btnLamp3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Lights");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    @OnCheckedChanged(R.id.btn_lamp_all)
    public void allLamp(CompoundButton buttonView, boolean isChecked) {
        String msgText;
        if(isChecked) {
            msgText = "led all off";

            btnLamp1.setChecked(true);
            btnLamp2.setChecked(true);
            btnLamp3.setChecked(true);
        } else {
            msgText = "led all on";

            btnLamp1.setChecked(false);
            btnLamp2.setChecked(false);
            btnLamp3.setChecked(false);
        }
        MainActivity.publish(msgText);
    }

    @OnCheckedChanged(R.id.btn_lamp_1)
    public void firstLamp(CompoundButton buttonView, boolean isChecked) {
        String msgText;
        if(isChecked) {
            msgText = "led 1 off";
        } else {
            msgText = "led 1 on";
        }
        MainActivity.publish(msgText);
    }

    @OnCheckedChanged(R.id.btn_lamp_2)
    public void secondLamp(CompoundButton buttonView, boolean isChecked) {
        String msgText;
        if(isChecked) {
            msgText = "led 2 off";
        } else {
            msgText = "led 2 on";
        }
        MainActivity.publish(msgText);
    }

    @OnCheckedChanged(R.id.btn_lamp_3)
    public void thridLamp(CompoundButton buttonView, boolean isChecked) {
        String msgText;
        if(isChecked) {
            msgText = "led 3 off";
        } else {
            msgText = "led 3 on";
        }
        MainActivity.publish(msgText);
    }
}
