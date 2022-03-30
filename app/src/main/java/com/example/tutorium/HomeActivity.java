package com.example.tutorium;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recycler;
    CourseAdapter courseAdapter;
    ArrayList<Courses> coursesArrayList;
    SearchView sv_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        sv_search = findViewById(R.id.sv_search);
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        coursesArrayList  = new ArrayList<>();

        coursesArrayList.add(new Courses("C Programming"));
        coursesArrayList.add(new Courses("C++"));
        coursesArrayList.add(new Courses("JAVA"));
        coursesArrayList.add(new Courses("Javascript"));
        coursesArrayList.add(new Courses("HTML 5"));
        coursesArrayList.add(new Courses("Dart"));
        coursesArrayList.add(new Courses("Python"));
        courseAdapter = new CourseAdapter(this,coursesArrayList);

        recycler.setAdapter(courseAdapter);

        sv_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        for(Courses item : coursesArrayList){
            if(item.getCoursename().toLowerCase().contains(newText.toLowerCase())){
                filteredlist.add(item);}
        }
        courseAdapter.filterlist(filteredlist);
    }


}