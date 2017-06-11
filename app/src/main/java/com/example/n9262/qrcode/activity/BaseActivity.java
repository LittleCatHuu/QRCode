package com.example.n9262.qrcode.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.n9262.qrcode.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected String title,centertitle,subtitle;
    protected boolean isShowToolbar,isSetNavigationIcon,isShowEmail = true;
    protected boolean isSetLogo = false;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_center_title)
    TextView toolbarCenterTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (toolbar != null){
            if (isShowToolbar){
                setSupportActionBar(toolbar);
            }else {
                toolbar.setVisibility(View.GONE);
            }
            if (title != null && !title.equals("")){
                toolbar.setTitle(title);
            }else {
                toolbar.setTitle("");
            }
            if (subtitle != null && !subtitle.equals("")){
                toolbar.setSubtitle(subtitle);
            }if (isSetNavigationIcon){
                toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }if (isSetLogo){
                toolbar.setLogo(getResources().getDrawable(R.mipmap.ic_launcher));
            }if(toolbarCenterTitle != null){
                if (centertitle != null && !centertitle.equals("")){
                    toolbarCenterTitle.setText(centertitle);
                }else {
                    toolbarCenterTitle.setText("");
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_base,menu);
        if (toolbar != null){
            MenuItem menuItem = toolbar.getMenu().getItem(0);
            if (menuItem != null){
                menuItem.setVisible(false);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
