package com.example.baick;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import SP.Adapter;
import SP.ThongTin;

public class PhuKien extends AppCompatActivity {

    ListView listView;
    ArrayList<ThongTin> arrayList;
    Adapter adapter;
    Button btn_gy,btn_ta,btn_pk,btn_qa;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phukien);
        listView = findViewById(R.id.rcv);
        btn_gy =findViewById(R.id.btn_goiy);
        btn_pk = findViewById(R.id.btn_phukien);
        btn_qa = findViewById(R.id.btn_quanao);
        btn_ta = findViewById(R.id.btn_thucan);

        arrayList = new ArrayList<>();
        arrayList.add(new ThongTin( "Giường cho thú cưng","Kích thước giường kiểu cung mèo -S:28 * 28cm -M:33 * 33cm","đ 199.000 - đ 299.000",R.drawable.pk_giuongtc));
        arrayList.add(new ThongTin( "Vòng đeo cổ","Vòng cổ chuông với thiết kế dày dặn và chắc chắn, chiếc vòng cổ này sẽ nằm thật gọn gàng và êm ái trên cổ thú cưng của bạn.","đ 12.000",R.drawable.pk_vdc));
        arrayList.add(new ThongTin( "Bát ăn nhựa đơn","Sản phẩm được làm từ chất liêu nhựa cao cấp, không gây hại, không làm ảnh hưởng đến chất lượng thức ăn","đ 6.000",R.drawable.pk_batnhua));
        arrayList.add(new ThongTin("Balo đựng thú cưng", "Trọng lượng : 510g/17.89oz", "R$7,00", R.drawable.gy_balo));
        adapter = new Adapter( PhuKien.this,R.layout.listout, arrayList);

        listView.setAdapter(adapter);
        btn_gy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PhuKien.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_ta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PhuKien.this, ThucAn.class);
                startActivity(intent);
            }
        });
        btn_qa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PhuKien.this, QuanAo.class);
                startActivity(intent);
            }
        });


    }
}
