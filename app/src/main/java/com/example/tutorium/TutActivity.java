package com.example.tutorium;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.VideoView;

public class TutActivity extends AppCompatActivity {

    WebView webview;
    Button btn_notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tut);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        webview = findViewById(R.id.webview);
        btn_notes = findViewById(R.id.btn_notes);

        String tuturl = getIntent().getExtras().getString("tut");
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl(tuturl);

        WebViewClient webViewClient = new WebViewClient();
        webview.setWebViewClient(webViewClient);

        btn_notes.setOnClickListener(view -> {
            Intent intent = new Intent(this,NotesListActivity.class);
            startActivity(intent);
        });
    }
}