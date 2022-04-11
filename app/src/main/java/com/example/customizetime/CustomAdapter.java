package com.example.customizetime;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    Activity activity;
    private ArrayList id, subject_name, teacher_name, date_time;

    CustomAdapter(Activity activity, Context context, ArrayList id, ArrayList subject_name, ArrayList teacher_name,
                  ArrayList date_time){
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.subject_name = subject_name;
        this.teacher_name = teacher_name;
        this.date_time = date_time;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.book_id_txt.setText(String.valueOf(id.get(position)));
        holder.book_title_txt.setText(String.valueOf(subject_name.get(position)));
        holder.book_author_txt.setText(String.valueOf(teacher_name.get(position)));
        holder.book_pages_txt.setText(String.valueOf(date_time.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5 = new Intent(context, UpdateActivity.class);
                int5.putExtra("id", String.valueOf(id.get(position)));
                int5.putExtra("subject", String.valueOf(subject_name.get(position)));
                int5.putExtra("teacher", String.valueOf(teacher_name.get(position)));
                int5.putExtra("date", String.valueOf(date_time.get(position)));
                activity.startActivityForResult(int5,1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView book_id_txt, book_title_txt, book_author_txt, book_pages_txt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_txt);
            book_title_txt = itemView.findViewById(R.id.book_title_txt);
            book_author_txt = itemView.findViewById(R.id.book_author_txt);
            book_pages_txt = itemView.findViewById(R.id.book_pages_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
