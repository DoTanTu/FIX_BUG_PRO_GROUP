package com.example.project_app_thu_cung;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MainAdapter extends FirebaseRecyclerAdapter<GioHang,MainAdapter.myViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<GioHang> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull GioHang model) {

        //Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.accelerate_decelerate_interpolator);
        //holder.itemView.startAnimation(animation);
        holder.tensp.setText(model.getTensp());
        holder.tvsoluong.setText(model.getSoluong());
        holder.tvsize.setText(model.getPhanloai());
        holder.tvtongtien.setText(model.getTongtien());

        Glide.with(holder.img.getContext())
                .load(model.getHinhanh())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_shopping_cart,parent,false);
        return new myViewHolder(view);
    }

    class  myViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tensp,tvsize,tvsoluong,tvtongtien;
        RelativeLayout relativeLayout;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgGioHang);
            tensp=(TextView) itemView.findViewById(R.id.textviewTensp);
            tvsize=(TextView) itemView.findViewById(R.id.textviewsize);
            tvsoluong=(TextView) itemView.findViewById(R.id.textviewsoluong);
            tvtongtien=(TextView) itemView.findViewById(R.id.textviewtongtien);
        }
    }
}
