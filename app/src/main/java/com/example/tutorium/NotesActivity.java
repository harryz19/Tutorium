package com.example.tutorium;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class NotesActivity extends AppCompatActivity {

    WebView notesweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        notesweb = findViewById(R.id.notesweb);

        String notesurl = getIntent().getExtras().getString("docs");
        notesweb.loadUrl(notesurl);
    }
}