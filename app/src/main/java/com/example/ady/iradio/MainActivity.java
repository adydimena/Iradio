package com.example.ady.iradio;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyBondService myBondService;
    private boolean isBound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void stop(View view) {
        Intent boundIntent = new Intent(this,MyBondService.class);
        stopService(boundIntent);
    }
    
    public void pause(View view) {
       // radio.pause();
    }
    public void play(View view) {
        Intent boundIntent = new Intent(this,MyBondService.class);
        bindService(boundIntent,serviceConnection, Context.BIND_AUTO_CREATE);
    }
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            isBound = true;
            MyBondService.Mybinder  mybinder= (MyBondService.Mybinder) iBinder;
            myBondService = mybinder.getService();
            //myBondService.initData();

           // Toast.makeText(myBondService,"Bound", Toast.LENGTH_LONG).show();
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // radio.release();
       // handler.removeCallbacks(runnable);
    }
}
