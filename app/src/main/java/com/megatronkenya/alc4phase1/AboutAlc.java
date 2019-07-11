package com.megatronkenya.alc4phase1;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutAlc extends AppCompatActivity {
    private WebView aboutAlc;
    private JavascriptInterface jsInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
       aboutAlc = findViewById(R.id.aboutAlcWeb);
        WebSettings webSettings = aboutAlc.getSettings();
        webSettings.setJavaScriptEnabled(true);
        aboutAlc.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                Toast.makeText(AboutAlc.this, description,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReceivedSslError(WebView view,
                                           SslErrorHandler handler, SslError error) {
                // TODO Auto-generated method stub
                // this method will proceed your url however if certification issues are there or not
                handler.proceed();
            }

        });





        aboutAlc.loadUrl("https://andela.com/alc/ ");
    }
}
