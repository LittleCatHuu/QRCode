package com.example.n9262.qrcode.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.n9262.qrcode.R;
import com.example.n9262.qrcode.ScanCodeActivity;
import com.example.n9262.qrcode.activity.BaseActivity;
import com.example.n9262.qrcode.util.QRCode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.etInputMessage)
    EditText etInputMessage;
    @BindView(R.id.ivCreateCode)
    ImageView ivCreateCode;
    @BindView(R.id.ivBarCode)
    ImageView ivBarCode;
    @BindView(R.id.ivLogoBarCode)
    ImageView ivLogoBarCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        title = getString(R.string.app_name);
        inits();
    }

    private void inits() {
        Bitmap bitmap = QRCode.createQRCode("just say goodbye", 500);
        ivBarCode.setImageBitmap(bitmap);
        Bitmap bitmap1 = QRCode.createQRCodeWithLogo("http://www.sina.com.cn/", 500, BitmapFactory.decodeResource(
                getResources(), R.mipmap.ic_launcher
        ));
        ivLogoBarCode.setImageBitmap(bitmap1);
    }

    @OnClick({R.id.btnScanCode, R.id.btnCreateCode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnScanCode:
                startActivity(new Intent(this, ScanCodeActivity.class));
                break;
            case R.id.btnCreateCode:
                String inputString = etInputMessage.getText().toString().trim();
                if (inputString != null && !inputString.equals("")){
                    Bitmap bitmap = QRCode.createQRCode(inputString,500);
                    ivCreateCode.setImageBitmap(bitmap);
                }

                break;
        }
    }

}
