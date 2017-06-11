package com.example.n9262.qrcode.app;

import android.app.Application;
import android.util.DisplayMetrics;

import com.example.n9262.qrcode.zxing.DisplayUtil;

/**
 * Created by n9262 on 2017/6/11.
 */

public class AppConfig extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initDisplayOption();
    }

    private void initDisplayOption() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        DisplayUtil.density = dm.density;
        DisplayUtil.densityDPI = dm.densityDpi;
        DisplayUtil.screenHightDip = DisplayUtil.px2dip(getApplicationContext(),dm.heightPixels);
        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(getApplicationContext(),dm.widthPixels);
        DisplayUtil.screenhightPx = dm.heightPixels;
        DisplayUtil.screenWidthPx = dm.widthPixels;
    }
}
