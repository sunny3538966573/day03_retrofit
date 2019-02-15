package com.bw.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.bean.Goods;
import com.bw.day03_retrofit.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 1607c王晴
 * date 2019/2/15
 * Describe:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<Goods.ResultBean> result;

    public MyAdapter(Context context, List<Goods.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.goods_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.item_img.setImageURI(result.get(i).getMasterPic());
        viewHolder.item_price.setText(result.get(i).getPrice()+"元");
        viewHolder.item_content.setText(result.get(i).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  final SimpleDraweeView item_img;
        private final TextView item_price;
        private final TextView item_content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_img = itemView.findViewById(R.id.item_img);
            item_price = itemView.findViewById(R.id.item_price);
            item_content = itemView.findViewById(R.id.item_content);
        }
    }


}
