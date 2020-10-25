package com.codeblack.movealong;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class MyWebView extends AppCompatActivity {


    private android.webkit.WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        String url = "https://www.airbnb.ca/";

        webView = findViewById(R.id.web_view);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(url);

        AssetManager mAssetManager = this.getAssets();
        try
        {
            InputStream mInputStream = mAssetManager.open("");
            int size = mInputStream.available();
            byte[] buffer = new byte[size];
            mInputStream.read(buffer);
            mInputStream.close();
            String content = new String(buffer, "UTF-8");

            Log.d("DATA", content);
            //webView.loadData(content, "text/html", "utf-8");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
