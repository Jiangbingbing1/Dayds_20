package com.bawei.dayds_20;

import android.content.Context;

import javax.security.auth.callback.Callback;

public interface Icunt {

    interface IView{
        void getData(String json);
    }
    interface IModel{
        void getData(Context context, String url, Callback callback);
    }
    interface Callback{
        void getData(String url);
    }
    interface IPresenter{
        void onAttach(IView iView);
        void startFrimdata(Context context,String url);
        void onDeach();
    }

}
