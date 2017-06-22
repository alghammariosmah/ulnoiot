package at.fhooe.mc.clickdummy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

/**
 * Created by christian on 20.06.2017.
 */

public class MediaActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Media");
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

    @OnCheckedChanged(R.id.btn_lock)
    public void doorLock(CompoundButton buttonView, boolean isChecked) {
        String msgText;
        if(isChecked) {
            msgText = "lock 1 on";
        } else {
            msgText = "lock 1 off";
        }
        MainActivity.publish(msgText);
    }

    @OnCheckedChanged(R.id.btn_media)
    public void media(CompoundButton buttonView, boolean isChecked) {
        String msgText;
        if(isChecked) {
            msgText = "media 1 play";
        } else {
            msgText = "media 1 pause";
        }
        MainActivity.publish(msgText);
    }
}
