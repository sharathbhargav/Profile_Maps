package com.sharingan.sharathbhargav.maps2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Sharath Bhargav on 9/12/2016.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashlayout);
        Thread clock = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch (InterruptedException i){
                    i.printStackTrace();
                }finally {
                    Intent i = new Intent(getApplicationContext(),CustomViewIconTextTabsActivity.class);
                    startActivity(i);
                }
            }
        };
        clock.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

