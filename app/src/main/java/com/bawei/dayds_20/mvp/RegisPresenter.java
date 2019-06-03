package com.bawei.dayds_20.mvp;

import android.content.Context;

import com.bawei.dayds_20.Icunt;

public class RegisPresenter implements Icunt.IPresenter {

    private Icunt.IView iView;
    private Icunt.IModel iModel;

    public RegisPresenter(Icunt.IView iView){
         iModel=new RegisModel();
         this.iView=iView;
    }
    @Override
    public void onAttach(Icunt.IView iView) {
        this.iView=iView;
    }

    @Override
    public void startFrimdata(Context context, String url) {
         iModel.getData(context, url, new Icunt.Callback() {
             @Override
             public void getData(String url) {
                 iView.getData(url);
             }
         });
    }

    @Override
    public void onDeach() {
           if (iModel!=null){
               iModel=null;
           }
           if (iView!=null){
               iView=null;
           }
    }
}
