package com.example.customizetime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Teacher extends AppCompatActivity {
    RecyclerView recyclerView2;
    FloatingActionButton add_button;
    MyDatabaseHelper1 Db1;
    ArrayList<String> book_id, book_title, book_author, book_pages;
    CustomAdapter2 customAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        recyclerView2 = findViewById(R.id.recyclerView2);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Teacher.this, AddTeacher.class);
                startActivity(intent);

            }
        });

        Db1 = new MyDatabaseHelper1(Teacher.this);
        book_id = new ArrayList<>();
        book_title = new ArrayList<>();
        book_author = new ArrayList<>();
        book_pages = new ArrayList<>();
        storeDataInArrays();

        customAdapter2 = new CustomAdapter2(Teacher.this,this, book_id, book_title, book_author,
                book_pages);
        recyclerView2.setAdapter(customAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(Teacher.this));
    }
    void storeDataInArrays(){
        Cursor cursor = Db1.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"NO DATA",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                book_id.add(cursor.getString(0));
                book_title.add(cursor.getString(1));
                book_author.add(cursor.getString(2));
                book_pages.add(cursor.getString(3));
            }

        }
    }
}