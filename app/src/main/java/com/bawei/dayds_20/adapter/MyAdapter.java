package com.bawei.dayds_20.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dayds_20.R;
import com.bawei.dayds_20.bean.UserBean;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Handel> {
   private List<UserBean.ResultBean> list;
   private Context context;

    public MyAdapter(List<UserBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Handel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.recycle, null);
        Handel handel=new Handel(inflate);
        return handel;
    }

    @Override
    public void onBindViewHolder(@NonNull Handel handel, int i) {
        Glide.with(context).load(list.get(i).getImageUrl()).into(handel.imageView);
           handel.textView.setText(list.get(i).getSummary());
           handel.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Handel extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public Handel(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            textView=itemView.findViewById(R.id.name);
        }
    }
}
