package com.example.ady.iradio;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.os.Binder;
import android.os.IBinder;
import android.widget.SeekBar;

public class MyBondService extends Service {
    MediaPlayer radio;
    Handler handler;
    Runnable runnable;
    public MyBondService() {
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
    IBinder iBinder = new Mybinder();
    public class Mybinder extends Binder{
        MyBondService getService(){
            return MyBondService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        handler = new Handler();
        radio = MediaPlayer.create(getApplicationContext(),R.raw.birds);
        radio.setAudioStreamType(AudioManager.STREAM_MUSIC);
        radio.start();
       return iBinder;
    }
    public  void initData()
    {
    }
    public String getData(){
        return "";
    }
}
