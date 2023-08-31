package com.example.agronomistfinal;

//package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.SettingInjectorService;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    Button button1, button2;
    private Object Setting;
    String TOKEN;




    DatabaseReference databaseReference;



    @Override
    public void onReceive(Context context, Intent intent) {


        TOKEN = intent.getStringExtra("token");
//        Toast.makeText(context, keyid, Toast.LENGTH_SHORT).show();





        mp = MediaPlayer.create(context,Settings.System.DEFAULT_RINGTONE_URI);



        Handler handler = new Handler();
// Define the code block to be executed
        Runnable runnableCode = new Runnable() {
            @Override
            public void run() {
                // Do something here on the main thread

                databaseReference = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/Y-Phase");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            String data = snapshot.getValue().toString();
                            Toast.makeText(context, data, Toast.LENGTH_SHORT).show();

                            if(data=="false"){
                                mp.setLooping(true);
                                mp.start();
                            }
                            else{
                                mp.pause();
                            }


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


//                Toast.makeText(context, "hare ram hare krishna", Toast.LENGTH_SHORT).show();
//                Log.d("Handlers", "Called on main thread");
                // Repeat this the same runnable code block again another 2 seconds
                // 'this' is referencing the Runnable object
                handler.postDelayed(this, 100);
            }
        };
// Start the initial runnable task by posting through the handler
        handler.post(runnableCode);

//        while(1 == 1) {
        Handler handler3= new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run(){
//          databaseReference6.setValue(0);


//                mp.setLooping(true);
//                mp.start();

                Handler handler3= new Handler();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run(){
//mp
//                        mp.stop();

                    }
                }, 5000);



            }
        }, 5000);
////
        handler.post(runnableCode);

//    S
////


////
//        }
        Toast.makeText(context, "my name is lakhan", Toast.LENGTH_SHORT).show();









//        Toast.makeText(context, "hello buddy", Toast.LENGTH_SHORT).show();



    }
}
