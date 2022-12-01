package com.example.project_app_thu_cung;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.GioHangViewHolder>{

    Context context;
    List<GioHang> gioHangList;
    FirebaseFirestore fdb = FirebaseFirestore.getInstance();
    ShoppingCartActivity shoppingCartActivity = new ShoppingCartActivity();

    public GioHangAdapter (ShoppingCartActivity shoppingCartActivity, List<GioHang> gioHangList){
        this.shoppingCartActivity = shoppingCartActivity;
        this.gioHangList = gioHangList;
    }

    @NonNull
    @Override
    public GioHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(shoppingCartActivity).inflate(R.layout.activity_item_shopping_cart,parent,false);
       return new GioHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangViewHolder holder, int position) {
        GioHang gioHang = gioHangList.get(position);
        if (gioHang ==null){
            return;
        }
        holder.tensp.setText(gioHang.getTensp());
        holder.phanloai.setText(gioHang.getPhanloai());
        holder.soluong.setText(gioHang.getSoluong());
        holder.tongtien.setText(gioHang.getTongtien());
        //Glide.with(shoppingCartActivity).load(gioHang.getHinhanh()).into(holder.hinhanh);
    }

    @Override
    public int getItemCount() {
        if (gioHangList != null){
            return gioHangList.size();
        }
        return 0;
    }

    public class GioHangViewHolder extends RecyclerView.ViewHolder {
        TextView tensp, soluong, phanloai, tongtien;
        ImageView hinhanh;
        LinearLayout the;
        public GioHangViewHolder(@NonNull View itemView) {
            super(itemView);
            tensp = itemView.findViewById(R.id.textviewTensp);
            soluong = itemView.findViewById(R.id.textviewsoluong);
            phanloai =itemView.findViewById(R.id.textviewsize);
            the = itemView.findViewById(R.id.the);
            hinhanh = itemView.findViewById(R.id.imgGioHang);
        }
    }



}
