package com.seek.h5callandroiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


    }

    private void initViews() {
        webView = (WebView) findViewById(R.id.webview);
        this.webView.getSettings().setJavaScriptEnabled(true);

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowFileAccess(true);// 设置允许访问文件数据
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        String url = "http://www.funtownenglish.com/teacherh5/addMyTask.html?userid=152 ";

        this.webView.setWebChromeClient(new WebChromeClient());
        this.webView.loadUrl(url);
        //android添加javascript代码，让H5页面能够调用，第二个参数对应的是H5的
        this.webView.addJavascriptInterface(new PayJavaScriptInterface(), "js");
    }

    private class PayJavaScriptInterface {

        /**
         * h5调用相册上传图片
         */
        @JavascriptInterface
        private void callAlbum() {
            Toast.makeText(MainActivity.this, "callAlbum()已经被调用了", Toast.LENGTH_SHORT).show();

            Log.i("CallPiatureInterface", "callAlbum()已经被调用了");
        }
    }
    }

