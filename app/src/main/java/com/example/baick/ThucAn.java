package com.example.baick;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import SP.Adapter;
import SP.ThongTin;

public class ThucAn extends AppCompatActivity {

    ListView listView;
    ArrayList<ThongTin> arrayList;
    Adapter adapter;
    Button btn_gy,btn_ta,btn_pk,btn_qa;
    private DrawerLayout mDrawerLayout;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thucan);
        listView = findViewById(R.id.rcv);
        btn_gy =findViewById(R.id.btn_goiy);
        btn_pk = findViewById(R.id.btn_phukien);
        btn_qa = findViewById(R.id.btn_quanao);
        btn_ta = findViewById(R.id.btn_thucan);

        arrayList = new ArrayList<>();
        arrayList.add(new ThongTin( "Xúc xích cho chó mèo","Xúc xích cho chó mèo hasmter.Sản phẩm được làm từ nguyên vật liệu tự nhiên đã qua tuyển lựa cận thận.","đ 1.600 - đ 2.500",R.drawable.ta_xucxich));
        arrayList.add(new ThongTin( "Súp thưởng cho mèo","Súp thưởng cho mèo Ciao Wang, thú cừng (15gr) - lutpet - 3 Vị : Gà(vàng) - Cá Ngừ (Đỏ) - Cá Hồi (Xanh Lá)","đ 1.000",R.drawable.ta_supthuong));
        arrayList.add(new ThongTin( "Bánh thưởng cho mèo","Hàm lượng chất béo, muối và calo thấp giúp ngăn ngừa béo phì. Hàm lượng protein cao, hỗ trợ hệ tiêu hóa và khả năng hấp thụ dưỡng chất","đ 7.000 - đ 25.000",R.drawable.ta_banhthuong));
        arrayList.add(new ThongTin( "Sũa bột cao cấp","Đối tượng sử dụng : Chó mèo sơ sinh dưới 2 tháng tuổi","R$ 7,00",R.drawable.ta_suabot));
        adapter = new Adapter( ThucAn.this,R.layout.listout, arrayList);

        listView.setAdapter(adapter);
        btn_gy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ThucAn.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_pk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ThucAn.this, PhuKien.class);
                startActivity(intent);
            }
        });
        btn_qa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ThucAn.this, QuanAo.class);
                startActivity(intent);
            }
        });
        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );



    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.bottom_nav,menu);
        return true;
    }




}

