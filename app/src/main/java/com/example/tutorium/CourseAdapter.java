package com.example.tutorium;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    Context context;
    ArrayList<Courses> courselist;

    public CourseAdapter(Context context, ArrayList<Courses> courselist) {
        this.context = context;
        this.courselist = courselist;
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_course, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        holder.txt_coursename.setText(courselist.get(position).getCoursename());
        holder.course_img.setImageResource(courseimages[position]);

        holder.itemView.setOnClickListener(view -> {
//            Toast.makeText(context,holder.txt_coursename.getText(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context,TutActivity.class);
            intent.putExtra("tut",tuts[position]);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return courselist.size();
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
        courselist = filteredList;
        notifyDataSetChanged();

    }
    int[] courseimages = {R.drawable.c,R.drawable.cpp,R.drawable.java,R.drawable.js,R.drawable.html,R.drawable.dart,R.drawable.python};
    String[] tuts = {"https://www.youtube.com/watch?v=ZSPZob_1TOk","https://www.youtube.com/watch?v=yGB9jhsEsr8",
    "https://www.youtube.com/watch?v=rV_3Lewxx6o","https://www.youtube.com/watch?v=hKB-YGF14SY",
            "https://www.youtube.com/watch?v=BsDoLVMnmZs","https://www.youtube.com/watch?v=R2sRhDq7qKk",
    "https://www.youtube.com/watch?v=gfDE2a7MKjA"};
}
