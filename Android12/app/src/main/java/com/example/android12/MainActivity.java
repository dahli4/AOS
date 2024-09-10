package com.example.android12;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnGo = (Button) findViewById(R.id.btnGo);
        Button btnGoBack = (Button) findViewById(R.id.btnGoBack);
        EditText etUrl = (EditText) findViewById(R.id.etUrl);
        WebView wvBrowser = (WebView) findViewById(R.id.wvBrowser);

        wvBrowser.setWebViewClient(new WebViewClient());
        WebSettings webSet = wvBrowser.getSettings();
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);

        btnGo.setOnClickListener(v -> wvBrowser.loadUrl(etUrl.getText().toString()));

        btnGoBack.setOnClickListener(v -> wvBrowser.goBack());
    }
}