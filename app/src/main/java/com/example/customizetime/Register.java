package com.example.customizetime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText username,password,repassword;
    Button signup;
    TextView signin;
    DBHelper DB;
    CheckBox showcheck_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (TextView) findViewById(R.id.txtsignin);
        showcheck_btn = (CheckBox) findViewById(R.id.checkbox_btn);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                if (user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(Register.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Register.this, "Registered Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else{
                            Toast.makeText(Register.this, "User Already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1 = new Intent(getApplicationContext(),Login.class);
                startActivity(in1);

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
        showcheck_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton ButtonView, boolean isChecked) {
                if (isChecked){
                    repassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    repassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });




    }
}