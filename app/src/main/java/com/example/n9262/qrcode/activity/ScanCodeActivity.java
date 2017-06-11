package com.example.n9262.qrcode.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n9262.qrcode.R;
import com.example.n9262.qrcode.activity.BaseActivity;
import com.example.n9262.qrcode.util.ImageUtil;
import com.example.n9262.qrcode.zxing.activity.CaptureActivity;
import com.example.n9262.qrcode.zxing.activity.CodeUtils;

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

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btnScan:
                Intent intent = new Intent();
                intent.setClass(getApplication(), CaptureActivity.class);
//                Intent intent = new Intent(getAppcation(),CaptureActivity.class)
                startActivityForResult(intent,REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (data != null){
                Bundle bundle = data.getExtras();
                if (bundle == null){
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS){
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this,"result:" + result,Toast.LENGTH_LONG).show();
                    tvResult.setText(result);
                }else if(bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED){
                    Toast.makeText(ScanCodeActivity.this,"failed",Toast.LENGTH_LONG).show();
                }
            }
        }
        else if (requestCode == REQUSET_IMAGE){
            if (data != null){
                try {
                    Uri uri = data.getData();
                    CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, uri), new CodeUtils.AnalyzeCallback() {
                        @Override
                        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                            Toast.makeText(ScanCodeActivity.this,"result:"+result,Toast.LENGTH_LONG).show();
                            tvResult.setText(result);
                        }

                        @Override
                        public void onAnalyzeFailed() {
                            Toast.makeText(ScanCodeActivity.this,"failed",Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (requestCode == REQUEST_CAMERA_PERM){
                Toast.makeText(this,"return from setting",Toast.LENGTH_LONG).show();
            }
        }
    }
}
