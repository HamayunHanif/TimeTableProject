package com.example.customizetime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity {
    Button btnDial,btnMsg,btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        btnDial = findViewById(R.id.btnDial);
        btnMsg = findViewById(R.id.btnMsg);
        btnEmail = findViewById(R.id.btnEmail);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idial = new Intent(Intent.ACTION_DIAL);
                idial.setData(Uri.parse("tel: +923004176056"));
                startActivity(idial);
            }
        });
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in9 = new Intent(Intent.ACTION_SENDTO);
                in9.setData(Uri.parse("smsto:"+Uri.encode("+923004176056")));
                in9.putExtra("sms_body","Please Solve this issue asap.");
                startActivity(in9);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iemail = new Intent(Intent.ACTION_SEND);
                iemail.setType("messege/rfc822");
                iemail.putExtra(Intent.EXTRA_EMAIL, new String[]{" Bitm-f19-078@superior.edu.pk,"," Bitm-f19-091@superior.edu.pk"});
                iemail.putExtra(Intent.EXTRA_SUBJECT," Queries");
                iemail.putExtra(Intent.EXTRA_TEXT," Please Resolve this Issue");
                startActivity(Intent.createChooser(iemail," Email via"));
            }
        });
    }
}