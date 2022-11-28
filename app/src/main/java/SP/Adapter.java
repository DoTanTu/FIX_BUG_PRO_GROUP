package SP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baick.R;

import java.util.List;

import SP.ThongTin;

public class Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ThongTin> arraylist;


    public Adapter(Context context, int layout, List<ThongTin> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;

    }
    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        ThongTin thongtin = arraylist.get(i);


        TextView text1 = view.findViewById(R.id.tv_name);
        TextView text2 = view.findViewById(R.id.tv_mota);
        TextView text3 = view.findViewById(R.id.tv_price);
        ImageView imageV = view.findViewById(R.id.imgsp);


        text1.setText(thongtin.getName());
        text2.setText(thongtin.getMota());
        text3.setText(thongtin.getGia());
        imageV.setImageResource(thongtin.getHinh());


        return view;
    }
}
