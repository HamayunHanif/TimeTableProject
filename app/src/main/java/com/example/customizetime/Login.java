package com.example.customizetime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username,password;
    Button btnlogin;
    TextView signup, forgot;
    DBHelper DB;
    CheckBox showcheck_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin =(Button) findViewById(R.id.btnsignin1);
        signup = (TextView) findViewById(R.id.txtsignup1);
        forgot = (TextView) findViewById(R.id.txtforgot);
        showcheck_btn = (CheckBox) findViewById(R.id.checkbox_btn);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")||pass.equals(""))
                    Toast.makeText(Login.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.Checkusernamepassword(user,pass);
                    if (checkuserpass==true){
                        Toast.makeText(Login.this,"Sign in successfull",Toast.LENGTH_SHORT).show();
                        Intent int2 = new Intent(getApplicationContext(),Main_Dashboard.class);
                        startActivity(int2);
                    }else {
                        Toast.makeText(Login.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3 = new Intent(getApplicationContext(),Register.class);
                startActivity(int3);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4 = new Intent(getApplicationContext(), password.class);
                startActivity(int4);
            }
        });
        showcheck_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton ButtonView, boolean isChecked) {
                if (isChecked){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }
}