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

public class QuanAo extends AppCompatActivity {

    ListView listView;
    ArrayList<ThongTin> arrayList;
    Adapter adapter;
    Button btn_gy,btn_ta,btn_pk,btn_qa;
    private DrawerLayout mDrawerLayout;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanao);
        listView = findViewById(R.id.rcv);
        btn_gy =findViewById(R.id.btn_goiy);
        btn_pk = findViewById(R.id.btn_phukien);
        btn_qa = findViewById(R.id.btn_quanao);
        btn_ta = findViewById(R.id.btn_thucan);

        arrayList = new ArrayList<>();
        arrayList.add(new ThongTin( "Áo thun hai dây","Áo Vest Trái Cây này Đơn Giản Và Hào Dạng, Làm Cho Chó / Mèo trở nên Thời Trang Hơn và Dễ thương.","đ 36.000",R.drawable.qa_aothun));
        arrayList.add(new ThongTin( "Áo Noel","Chất liệu mềm mại, êm ái, không kích ứng da, phù hợp cho cún yêu nhà bạn.","đ 87.000",R.drawable.qa_aonoel));
        arrayList.add(new ThongTin( "Áo cổ tròn in họa tiết","Chiếc áo này sẽ khiến chú chó nhà bạn trở nên nổi bật với thiết kế cổ tròn, in họa tiết hoạt hình và màu sắc tươi tắn.","đ 99.000 - đ 105.000",R.drawable.qa_aocotron));
        arrayList.add(new ThongTin("Thời trang thú cưng", "Danh mục sản phẩm: Quần áo Cotton năm mới cho thú cưng Màu sắc: Váy cá Koi màu đỏ lớn Kích thước: XS, S, M, L", "R$7,00", R.drawable.qa_tttc));
        adapter = new Adapter( QuanAo.this,R.layout.listout, arrayList);

        listView.setAdapter(adapter);
        btn_gy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(QuanAo.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_ta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(QuanAo.this, ThucAn.class);
                startActivity(intent);
            }
        });
        btn_qa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(QuanAo.this, PhuKien.class);
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

