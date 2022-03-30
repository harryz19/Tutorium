package com.example.tutorium;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class NotesListActivity extends AppCompatActivity {

    SearchView sv_searchnotes;
    RecyclerView recyclernotes;
    ArrayList<Courses> noteList;
    NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        sv_searchnotes = findViewById(R.id.sv_searchnotes);
        recyclernotes = findViewById(R.id.recyclernotes);
        recyclernotes.setHasFixedSize(true);
        recyclernotes.setLayoutManager(new LinearLayoutManager(this));

        noteList = new ArrayList<>();

        noteList.add(new Courses("C Programming"));
        noteList.add(new Courses("C++"));
        noteList.add(new Courses("JAVA"));
        noteList.add(new Courses("Javascript"));
        noteList.add(new Courses("HTML 5"));
        noteList.add(new Courses("Dart"));
        noteList.add(new Courses("Python"));
        notesAdapter = new NotesAdapter(this, noteList);

        recyclernotes.setAdapter(notesAdapter);

        sv_searchnotes.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String newText) {
        ArrayList<Courses> filteredlist = new ArrayList<>();
        for (Courses item : noteList) {
            if (item.getCoursename().toLowerCase().contains(newText.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        notesAdapter.filterlist(filteredlist);
    }
}