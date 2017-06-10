package com.example.n9262.qrcode.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.n9262.qrcode.R;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    protected String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public void onClick(View v) {

    }
}
