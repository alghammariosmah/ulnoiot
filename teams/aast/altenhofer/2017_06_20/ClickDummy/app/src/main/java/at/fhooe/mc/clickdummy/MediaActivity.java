package at.fhooe.mc.clickdummy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by christian on 20.06.2017.
 */

public class MediaActivity extends AppCompatActivity {

    private String ipAddress;

    @BindView(R.id.webview)
    WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Media");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        ipAddress = bundle.getString(MainActivity.IP_EXTRA);

        setUpWebView("http://" + ipAddress + ":8081");
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

    @OnClick(R.id.btn_refresh)
    public void refresh() {
        Toast.makeText(this, "Refresh...", Toast.LENGTH_SHORT).show();
        webView.reload();
    }

    private void setUpWebView(String url) {
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        setTitle(url);
        webView.loadUrl(url);
    }
}
