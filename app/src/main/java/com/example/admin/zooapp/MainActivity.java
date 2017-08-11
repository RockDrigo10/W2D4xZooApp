package com.example.admin.zooapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    WebView wvZoo;
    Button btnCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://zooatlanta.org/";
        wvZoo = (WebView) findViewById(R.id.wwZoo);
        btnCategories = (Button) findViewById(R.id.btnCategories);
        if (savedInstanceState == null) {
            wvZoo.loadUrl(url);
        }
        // Enable Javascript
        WebSettings webSettings = wvZoo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Force links and redirects to open in the WebView instead of in a browser
        wvZoo.setWebViewClient(new WebViewClient());
        wvZoo.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    WebView webView = (WebView) v;
                    switch(keyCode)
                    {
                        case KeyEvent.KEYCODE_BACK:
                            if(webView.canGoBack())
                            {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }
                return false;
            }
        });
    }

    public void goToCategories(View view) {
        Intent intent = new Intent(this, CategoriesActivity.class);
        intent.putExtra("person", "pasa");
        startActivity(intent);
    }
}
