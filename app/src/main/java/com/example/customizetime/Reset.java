package com.example.customizetime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Reset extends AppCompatActivity {
    TextView username;
    EditText pass,repass;
    Button confirm;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        username = (TextView) findViewById(R.id.username_reset_text);
        pass =(EditText) findViewById(R.id.password_reset);
        repass = (EditText) findViewById(R.id.repassword_reset);
        confirm = (Button) findViewById(R.id.btnconfirm);
        DB = new DBHelper(this);
        Intent intent = getIntent();
        username.setText(intent.getStringExtra("username"));


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String password = pass.getText().toString();
                String repassword = repass.getText().toString();
                if (password.equals(repassword)) {
                    Boolean checkpasswordupdate = DB.updatepassword(user, password);
                    if (checkpasswordupdate == true) {
                        Intent int2 = new Intent(getApplicationContext(), Reset_Name.class);
                        startActivity(int2);
                        Toast.makeText(Reset.this, "Password Updated Sucessfully", Toast.LENGTH_SHORT).show();
                    } else
                        {
                        Toast.makeText(Reset.this, "Password not updated successfully", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Reset.this, "Password Not Matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
    }

