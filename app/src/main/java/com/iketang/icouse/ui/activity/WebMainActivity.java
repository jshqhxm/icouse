package com.iketang.icouse.ui.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.iketang.icouse.R;
import com.jockeyjs.Jockey;
import com.jockeyjs.JockeyImpl;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 项目名称 icouse
 * <p/>
 * Created by hexiaomin on 2016/4/18.
 */
public class WebMainActivity extends BaseActivity {


    @Bind(R.id.webView)
    WebView webView;

    private Jockey jockey;


    String router ="http://kt.cufehl.com/wap5/";
//    String router ="http://demo.bw-xt.com/wap5/";

    @Override
    public int getLayoutRes() {
        return R.layout.activity_web_main;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        webView.getSettings().setAllowFileAccess(true);

        String ua = webView.getSettings().getUserAgentString();
//        webView.getSettings().setUserAgentString(ua + "; 5iApp/11.11");

        jockey = JockeyImpl.getDefault();
        jockey.configure(webView);

        jockey.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.d(TAG, "TITLE=" + title);

            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        webView.loadUrl(router);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
