package com.iketang.icouse.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.iketang.icouse.R;
import com.iketang.icouse.ui.adapter.IcMainFmAdapter;
import com.tendcloud.tenddata.TCAgent;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Bind(R.id.fragment_main_tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    public IcMainFmAdapter adapter;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            /**https://developer.android.com/intl/zh-cn/samples/ImmersiveMode/src/com.example.android.immersivemode/ImmersiveModeFragment.html
             * https://developer.android.com/training/system-ui/navigation.html*/
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // Translucent navigation bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            int colorPrimaryDark = ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark);
            window.setStatusBarColor(colorPrimaryDark);
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Drawable upArrow = toolbar.getNavigationIcon();
        upArrow.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DST_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        if (adapter == null)
            adapter = new IcMainFmAdapter(this.getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);








    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        TCAgent.onPageStart(mContext, "主页面");
    }

    @Override
    protected void onStop() {
        super.onStop();
        TCAgent.onPageEnd(mContext, "主页面");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            startActivity(intent);

            TCAgent.onEvent(mContext, "New Activity", "TestActivity");

            return true;
        }
        if (id == R.id.action_login) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
