package com.appnucleus.abrarjahin.hello8920;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if ( isNetworkAvailable() )     //check if internet available or not
        {
            Toast.makeText(
                                ActivityMain.this,
                                "Internet Connected",
                                Toast.LENGTH_LONG
                            ).show();
            WebView webview = (WebView)findViewById(R.id.webView);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl(getString(R.string.sound_cloud_url));
        }
        else    //Not connected
        {
            Toast.makeText(
                    ActivityMain.this,
                    "Internet Disconnected",
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    //<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    //<uses-permission android:name="android.permission.INTERNET"/>
    public boolean isNetworkAvailable()
    {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
