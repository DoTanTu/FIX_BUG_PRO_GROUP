package com.example.baick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterSanphan extends RecyclerView.Adapter<AdapterSanphan.SPViewHoler> {
    private List<SanPham> listlsp;

    public AdapterSanphan(List<SanPham> listlsp) {
        this.listlsp = listlsp;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterSanphan.SPViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listout,parent,false);
        return new SPViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSanphan.SPViewHoler holder, int position) {
        SanPham SP = listlsp.get(position);
        if(SP == null){
            return;
        }
        holder.tvname.setText("Tên sản phẩm :" + SP.getName());
        holder.tvmota.setText("Mô tả :" + SP.getMota());
        holder.tvprice.setText("Mô tả :" + SP.getPrice());


    }

    @Override
    public int getItemCount() {
        if (listlsp != null){
            return listlsp.size();
        }
        return 0;
    }

    public class SPViewHoler  extends RecyclerView.ViewHolder {
        private TextView tvname;
        private TextView tvmota;
        private TextView tvprice;
        private ImageView hinh;
        public SPViewHoler(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tv_name);
            tvmota = itemView.findViewById(R.id.tv_mota);
            tvprice = itemView.findViewById(R.id.tv_price);
            hinh = itemView.findViewById(R.id.imgsp);
        }
    }
}


