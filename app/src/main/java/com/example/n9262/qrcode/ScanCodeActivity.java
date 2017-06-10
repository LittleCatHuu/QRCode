package com.example.n9262.qrcode;

import android.os.Bundle;
import android.widget.TextView;

import com.example.n9262.qrcode.activity.BaseActivity;

/**
 * Created by n9262 on 2017/6/4.
 */
public class ScanCodeActivity extends BaseActivity{
    public static final int REQUEST_CODE=111;
    public static final int  REQUSET_IMAGE = 112;
    public static final int  REQUEST_CAMERA_PERM = 101;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);
        title = getString(R.string.title_activity_scan_code);
        initView();
    }

    private void initView() {
        tvResult = (TextView) findViewById(R.id.tvReuslt);
    }
}
