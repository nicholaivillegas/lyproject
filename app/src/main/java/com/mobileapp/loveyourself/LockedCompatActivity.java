package com.mobileapp.loveyourself;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.orangegangsters.lollipin.lib.PinCompatActivity;

/**
 * Created by callmepeanut on 16-1-14.
 */
public class LockedCompatActivity extends PinCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compat_locked);
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Title");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setSubtitle("SubTitle");
        toolbar.setSubtitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setLogo(R.drawable.ic_launcher);
    }
}
