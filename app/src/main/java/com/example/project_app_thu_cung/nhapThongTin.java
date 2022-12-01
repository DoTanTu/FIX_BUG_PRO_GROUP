package com.example.project_app_thu_cung;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class nhapThongTin extends AppCompatActivity {
    private Spinner txt_gioitinh,txt_diachi;
   private Button btnxacnhan;
   private EditText txt_hten,txt_ngaysinh;
    private TextView txt_trove;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_thong_tin);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        txt_hten = findViewById(R.id.txt_ntt_hoten);
        txt_ngaysinh = findViewById(R.id.txt_ntt_ngaysinh);
        txt_diachi = findViewById(R.id.txt_ntt_diachi);
        txt_trove =findViewById(R.id.txt_ntt_trove);
        txt_gioitinh = (Spinner) findViewById(R.id.cbb_ntt_gtinh);
        btnxacnhan = findViewById(R.id.btn_ntt_xacnhan);
        txt_trove =findViewById(R.id.txt_ntt_trove);






        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apunti.hoten =txt_hten.getText().toString();
                apunti.ngaysinh =txt_ngaysinh.getText().toString();
                apunti.diachi=txt_diachi.getSelectedItem().toString();
                apunti.gioitinh=txt_gioitinh.getSelectedItem().toString();
                if(txt_hten.getText().toString().equals("")||txt_ngaysinh.getText().toString().equals("")||txt_diachi.getSelectedItem().toString().equals("")||txt_gioitinh.getSelectedItem().toString().equals("")){
                    oppendialog(Gravity.CENTER,"Bạn cần nhập đầy đủ thông tin");

                }else{
                    taikhoan tk = new taikhoan(apunti.sdt,apunti.matkhau,apunti.hoten,apunti.gioitinh,apunti.ngaysinh,apunti.diachi);
                        mDatabase.child("users").push().setValue(tk);
                        openhome();
                    }
                }
        });
        txt_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendangki();
            }
        });
    }

     //có thể sử dụng lại
    private void oppendialog(int gravity,String x){
        final Dialog dialog =new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.diglog_ntt);
        Window window = dialog.getWindow();
        if(window ==null)   {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowactibu = window.getAttributes();
        windowactibu.gravity=gravity;
        window.setAttributes(windowactibu);
        if(Gravity.BOTTOM==gravity){
            dialog.setCancelable(true);
        }
        else {
            dialog.setCancelable(false);
        }
        EditText txtcontent =dialog.findViewById(R.id.txt_dialog_content);
        Button btnyes =dialog.findViewById(R.id.btn_diglog_yes);
        Button btnno =dialog.findViewById(R.id.btn_diglogn_No);

        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });
       txtcontent.setText(x);
        dialog.show();
      }
    public void openlogin(){
        Intent intent = new Intent(this ,login.class);
        startActivity(intent);
    }
    public void openhome(){
        Intent intent = new Intent(this ,Home.class);
        startActivity(intent);
    }
    public void opendangki(){
        Intent intent = new Intent(this ,MainActivity.class);
        startActivity(intent);
    }


}