package com.example.project_app_thu_cung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class login extends AppCompatActivity {
    private LinearLayout txtdangki_dn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtdangki_dn = findViewById(R.id.txtDangki_dn);
        txtdangki_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oppenDangki();
            }
        });
    }
    private void oppenDangki(){
        Intent intent = new Intent(login.this, MainActivity.class);
        startActivity(intent);
    }
}