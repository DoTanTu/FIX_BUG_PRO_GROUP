package com.example.baick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import SP.Adapter;
import SP.ThongTin;


public class MainActivity extends AppCompatActivity {
    ListView listView,listView1;
    ArrayList<ThongTin> arrayList;
    Adapter adapter;
    Button btn_gy,btn_ta,btn_pk,btn_qa;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.rcv);
        btn_gy = findViewById(R.id.btn_goiy);
        btn_pk = findViewById(R.id.btn_phukien);
        btn_qa = findViewById(R.id.btn_quanao);
        btn_ta = findViewById(R.id.btn_thucan);


        arrayList = new ArrayList<>();
        arrayList.add(new ThongTin("Áo sweatshirt", "Áo sweatshirt cho thú cưng được làm từ chất liệu lông cừu cao cấp", "đ 79.000 - đ 89.000", R.drawable.gy_ao));
        arrayList.add(new ThongTin("CATSRANG 5KG", "Thức ăn cho mèo Catsrang được nhập khẩu trực tiếp từ Hàn Quốc chuyên dụng dành cho mèo giúp phòng ngừa loại bỏ lông thừa trong ruột", "đ 187.000", R.drawable.gy_catsrang));
        arrayList.add(new ThongTin("Mũ xinh xắn", "Tên sản phẩm : mũ thú cưng Chất liệu: Cotton, nhung", "đ 17.000 - đ 35.000", R.drawable.gy_mu));
        arrayList.add(new ThongTin("Balo đựng thú cưng", "Trọng lượng : 510g/17.89oz", "R$7,00", R.drawable.gy_balo));
        adapter = new Adapter(MainActivity.this, R.layout.listout, arrayList);

        listView.setAdapter(adapter);
        btn_ta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThucAn.class);
                startActivity(intent);
            }
        });
        btn_pk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhuKien.class);
                startActivity(intent);
            }
        });
        btn_qa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuanAo.class);
                startActivity(intent);
            }
        });
    }




    }





