package com.shasoft.motoclub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.HapticFeedbackConstants;
import android.widget.Toast;

public class splash extends AppCompatActivity {
    public static int SPLASH_TIME_OUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        android.net.ConnectivityManager cm = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);

        android.net.NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            Toast.makeText(splash.this, "connected !", Toast.LENGTH_SHORT).show();
            new Handler(). postDelayed(new Runnable(){
                @Override
                public  void run()
                {
                    Intent intent = new Intent(splash.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_TIME_OUT);

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.internet_logo);
            builder.setTitle("NO INTERNET");
            builder.setMessage("Please Check Your Internet Connection.Enable Internet connection and Restart ");
            builder.show();

        }
    }
}