package com.bawei.dayds_20.mvp;

import android.content.Context;

import com.bawei.dayds_20.Icunt;
import com.bawei.dayds_20.MyVolley;

public class RegisModel implements Icunt.IModel {
    @Override
    public void getData(Context context, String url, Icunt.Callback callback) {
        MyVolley.getInstance().getVolley(context,url,callback);
    }
}
