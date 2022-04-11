package com.example.customizetime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {
    CardView cd2,cd3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);
        cd2 = (CardView) findViewById(R.id.card2);
        cd3 = (CardView) findViewById(R.id.card3);
    }


    public void section(View view) {
        CardView cd;
        cd= (CardView) findViewById(R.id.card1);
        cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openaddsection();
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in9 = new Intent(Dashboard.this,Teacher.class);
                startActivity(in9);
            }
        });
        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in7 = new Intent(Dashboard.this,Setting.class);
                startActivity(in7);
            }
        });
    }
    private void openaddsection(){
        Intent i = new Intent(Dashboard.this,Addsection.class);
        startActivity(i);
    }

}