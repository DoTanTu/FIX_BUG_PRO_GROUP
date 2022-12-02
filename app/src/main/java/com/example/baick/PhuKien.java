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

public class PhuKien extends AppCompatActivity {

    ListView listView;
    ArrayList<ThongTin> arrayList;
    Adapter adapter;
    Button btn_gy,btn_ta,btn_pk,btn_qa;
    private DrawerLayout mDrawerLayout;


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


