package com.example.customizetime;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder2> {
    private Context context2;
    private Activity activity2;
    private ArrayList book_id, book_title, book_author, book_pages;





    CustomAdapter2(Activity activity, Context context, ArrayList book_id, ArrayList book_title, ArrayList book_author,
                   ArrayList book_pages){
        this.activity2 = activity;
        this.context2 = context;
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_pages = book_pages;

    }
    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context2);
        View view = inflater.inflate(R.layout.my_row1, parent, false);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.book_id_txt2.setText(String.valueOf(book_id.get(position)));
        holder.book_title_txt2.setText(String.valueOf(book_title.get(position)));
        holder.book_author_txt2.setText(String.valueOf(book_author.get(position)));
        holder.book_pages_txt2.setText(String.valueOf(book_pages.get(position)));


    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView book_id_txt2, book_title_txt2, book_author_txt2, book_pages_txt2;
        LinearLayout mainLayout2;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            book_id_txt2 = itemView.findViewById(R.id.book_id_txt2);
            book_title_txt2 = itemView.findViewById(R.id.book_title_txt2);
            book_author_txt2 = itemView.findViewById(R.id.book_author_txt2);
            book_pages_txt2 = itemView.findViewById(R.id.book_pages_txt2);
        }
    }
}