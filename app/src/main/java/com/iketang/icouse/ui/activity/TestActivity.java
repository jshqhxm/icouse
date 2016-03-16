package com.iketang.icouse.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.iketang.icouse.R;
import com.tendcloud.tenddata.TCAgent;

import java.util.HashMap;
import java.util.Map;

public class TestActivity extends AppCompatActivity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mContext = this;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Map<String, String> kv = new HashMap<String, String>();
            kv.put("商品类型", "休闲食品");
            kv.put("价格","5～10元" );
            TCAgent.onEvent(mContext, "New Activity", "TestActivity"  ,kv);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
