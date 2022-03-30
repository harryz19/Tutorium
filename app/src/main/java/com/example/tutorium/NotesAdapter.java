package com.example.tutorium;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    Context context;
    ArrayList<Courses> notesList;

    public NotesAdapter(Context context, ArrayList<Courses> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout_notes,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder holder, int position) {
        holder.txt_coursename.setText(notesList.get(position).getCoursename());
        holder.course_img.setImageResource(courseimages[position]);

        holder.itemView.setOnClickListener(view -> {
//            Toast.makeText(context,holder.txt_coursename.getText(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context,NotesActivity.class);
            intent.putExtra("docs",docs[position]);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_coursename;
        ImageView course_img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_coursename = itemView.findViewById(R.id.txt_coursename);
            course_img = itemView.findViewById(R.id.course_img);
        }
    }
    public void filterlist(ArrayList<Courses> filteredList){
        notesList = filteredList;
        notifyDataSetChanged();

    }
    int[] courseimages = {R.drawable.c,R.drawable.cpp,R.drawable.java,R.drawable.js,R.drawable.html,R.drawable.dart,R.drawable.python};
    String[] docs = {"https://www.programiz.com/c-programming","https://www.programiz.com/cpp-programming",
            "https://www.programiz.com/java-programming","https://www.programiz.com/javascript","https://www.w3schools.com/html/","https://www.geeksforgeeks.org/dart-tutorial/"
            ,"https://www.programiz.com/python-programming"};

}
