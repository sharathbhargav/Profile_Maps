package com.sharingan.sharathbhargav.maps2;

import android.app.IntentService;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.media.AudioManager;
import android.media.audiofx.BassBoost;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.security.Policy;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by Sharath Bhargav on 8/24/2016.
 */
public class myService  extends IntentService{
    public myService(){
        super("myService");
    }

    AudioManager myAudioManager;
    WifiManager myWifimanager;
    String s;
    Camera camera;
    private static final int REQUEST_ENABLE_BT = 0;

    @Override
    public void onStart(Intent intent, int startId) {

        super.onStart(intent, startId);
        Toast.makeText(getApplicationContext(),"service started",Toast.LENGTH_SHORT).show();
        Log.v("In sevice", "isdgj");



    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
myWifimanager= (WifiManager) getSystemService(getApplicationContext().WIFI_SERVICE);
        s=intent.getStringExtra("name1");

      //  Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
        if((s.compareTo("general"))==0) {
            myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
         //   myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            myAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, myAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            myWifimanager.setWifiEnabled(true);
            Settings.System.putInt(this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 255);
            stopSelf();
        }
        else if((s.compareTo("meet")==0))
        {
            myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            myAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, myAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            myWifimanager.setWifiEnabled(true);

            Settings.System.putInt(this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 255);
            stopSelf();

        }
        else if((s.compareTo("silent")==0))
        {
            myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            myAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, myAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            myWifimanager.setWifiEnabled(true);
            Settings.System.putInt(this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 255);
            stopSelf();
        }
        else if((s.compareTo("home")==0))
        {
            myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            myAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, myAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            myWifimanager.setWifiEnabled(true);
            Settings.System.putInt(this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 255);
            stopSelf();
        }
        else if((s.compareTo("custom")==0))
        {
            myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            myAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, myAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            myWifimanager.setWifiEnabled(true);
            Settings.System.putInt(this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 255);
            stopSelf();
        }



        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        //TODO for communication return IBinder implementati6on
        return null;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent==null)
            Toast.makeText(getApplicationContext(),"Intent null",Toast.LENGTH_SHORT).show();


    }
}