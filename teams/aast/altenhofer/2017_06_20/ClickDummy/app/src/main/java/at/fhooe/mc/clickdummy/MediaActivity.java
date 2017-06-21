package at.fhooe.mc.clickdummy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by christian on 20.06.2017.
 */

public class MediaActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        getSupportActionBar().setTitle("Room 1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
