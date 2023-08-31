//package com.example.myapplication14;

package com.example.agronomistfinal;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import java.text.DateFormat;
import android.app.AlertDialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import android.provider.MediaStore;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import android.speech.RecognizerIntent;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import java.util.Date;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;



import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {

    Handler mHandler;
    Button button,button2,button53,button5,button41,button4,button7,button99,button6,button88;
    ImageView imageView,imageView2, imageView4,imageView6,imageView3;
    TextView textview,textView16,textView17,textView16b,textView17b,textView19,textView19b,textView221;
    SharedPreferences sharedpreferences;
    Vibrator vibrator;
    String strr;
    String checking = "";
    String TOKEN;
    String hrs;
    String pm;
    int ttt;
    String token = "token3467";
    String mins;
    String  strr2;
    int time2;
    int alarm_hour2;
    String online;
    String online2;
    int data23;
    int t;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser currentUser = auth.getCurrentUser();

    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    DatabaseReference databaseReference3;
    DatabaseReference databaseReference4;
    DatabaseReference databaseReference5;
    DatabaseReference databaseReference6;
    DatabaseReference databaseReference7;
    DatabaseReference databaseReference9;
    DatabaseReference databaseReference8;
    DatabaseReference databaseReference12;
    DatabaseReference databaseReference10;
    DatabaseReference databaseReference11;
    DatabaseReference databaseReference15;
    DatabaseReference databaseReference101;
    DatabaseReference databaseReference49;
    DatabaseReference databaseReference50;
    DatabaseReference databaseReference51;
    DatabaseReference databaseReference567;
    DatabaseReference databaseReference102;
    DatabaseReference databaseReference52;
    DatabaseReference databaseReference53;
    DatabaseReference databaseReference19;

    MediaPlayer mediaPlayer;


    int i =1;
    private int mYear, mMonth, mDay, mHour, mMinute;
    protected static final int RESULT_SPEECH =1;
    int auto = 13;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_main2);


//     api for webhost service


//        EditText editText = findViewById(R.id.editTextTextPersonName2);


        this.mHandler = new Handler();
        m_Runnable.run();
        MediaPlayer mediaPlayer;
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
//        Toast.makeText(this, currentDateTimeString, Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getSharedPreferences("mySharepref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        showPrivateData();




//        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        final MediaPlayer mp2 = MediaPlayer.create(this,R.raw.bandhu);
        final MediaPlayer on = MediaPlayer.create(this,R.raw.motoron);
        final MediaPlayer off = MediaPlayer.create(this,R.raw.motorofff);
        Button button = findViewById(R.id.button3);
        Button button6 = findViewById(R.id.button6);
//        Button button53 = findViewById(R.id.button53);
        Button button99 = findViewById(R.id.button99);
        Button button41 = findViewById(R.id.button41);
        Button button91 = findViewById(R.id.button91);
        Button button5 = findViewById(R.id.button5);
        Button button7= findViewById(R.id.button7);
        Button button4 = findViewById(R.id.button4);
//        Button button88= findViewById(R.id.button88);


        ImageView imageView4 = findViewById(R.id.imageView4);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView6 = findViewById(R.id.imageView6);
        TextView textView = findViewById(R.id.textView22);
        TextView textView16= findViewById(R.id.textView16);
        TextView textView16b= findViewById(R.id.textView16b);
        TextView textView17= findViewById(R.id.textView17);
        TextView textView17b= findViewById(R.id.textView17b);
        TextView textView19= findViewById(R.id.textView19);
        TextView textView19b= findViewById(R.id.textView19b);
        TextView textView221= findViewById(R.id.textView221);
//
//


        final Handler handler = new Handler();
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        databaseReference15 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/alarm_hour1");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/alarm_min1");
        databaseReference3 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/endalarmhour");
        databaseReference4 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/endalarm_min1");
        databaseReference5 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/end");
        databaseReference12 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/YPHASE");
        databaseReference7 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/CONTROLL");

        databaseReference8 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/CONTROLL");
        databaseReference10 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/ON");
        databaseReference11 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/minute3");
        databaseReference19 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/Auto1");


        databaseReference9 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/CONTROLL2");

        Intent intent4 = getIntent();
//        String name = intent4.getStringExtra("message2");
//        Toast.makeText(this,"hello",Toast.LENGTH_LONG).show();
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

//        TOKE NUMBER GENERATION CODE

//        TOKEN NUMBER GENERATION CODE



        textView19.setText("offline");
//
//        for(int i=1300;i<1350;i++){
//
//String j = String.valueOf(i);
//            databaseReference8 = FirebaseDatabase.getInstance().getReference("/token"+j);
//            databaseReference8.child("AUTO").setValue(true);
//            databaseReference8.child("B-Phase").setValue(true);
//            databaseReference8.child("Auto1").setValue(0);
//            databaseReference8.child("R-Phase").setValue(true);
//            databaseReference8.child("Y-Phase").setValue(true);
//            databaseReference8.child("CONTROLL").setValue(0);
//            databaseReference8.child("CONTROLL2").setValue(14);
//            databaseReference8.child("/STATUS").setValue(true);
//            databaseReference8.child("alarm_hour1").setValue(12);
//            databaseReference8.child("alarm_min1").setValue(13);
//            databaseReference8.child("endalarm_min1").setValue(14);
//            databaseReference8.child("endalarmhour").setValue(23);
//            databaseReference8.child("hour1").setValue(34);
//            databaseReference8.child("minute2").setValue(14);
//            databaseReference8.child("minute3").setValue(23);
//            databaseReference8.child("online").setValue("Tuesday , 7 : 39 PM");
//            databaseReference8.child("online2").setValue("Tuesday , 7 : 39 PM");
//
//
//
//        }


//        button88.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//
//
////                int time =Integer.parseInt(editText.getText().toString());
//                long triggerTime = System.currentTimeMillis()+(30*1000);
//                Intent iBroadCast =new Intent(MainActivity2.this,MyReceiver.class);
//                iBroadCast.putExtra("token", TOKEN);
//                PendingIntent pi = PendingIntent.getBroadcast(MainActivity2.this,100,iBroadCast,PendingIntent.FLAG_UPDATE_CURRENT);
//                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pi);
//
//
//
//
//            }
//        });

        Handler handler3= new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run(){
//                                databaseReference6.setValue(0);





        databaseReference = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/CONTROLL2");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = snapshot.getValue().toString();
                if(snapshot.exists()){


//        button91.setText(data);
                    if(data.equalsIgnoreCase("13")){
////                button91.setBackground(@drawable/Color);
                        databaseReference19.setValue(1);
                        textView221.setText("AUTO");
//                        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
//                        Toast.makeText(MainActivity2.this, d, Toast.LENGTH_SHORT).show();
//                        button4.setBackgroundResource(R.drawable.rounder_corner);
//                        Toast.makeText(MainActivity2.this, data, Toast.LENGTH_SHORT).show();
                        button4.setBackgroundResource(R.drawable.rounder_corner);
                    }
                    else{
                        databaseReference19.setValue(0);
                        textView221.setText("button");
                        button4.setBackgroundResource(R.drawable.lightred);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


            }
        }, 6000);
        databaseReference101 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/minute3");
        databaseReference101.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Handler handler3= new Handler();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run(){
//                                databaseReference6.setValue(0);



                        String data = snapshot.getValue().toString();
                        if(snapshot.exists()){

//                    String string = "004-034556";

                            time2 = Integer.parseInt(data);
                            String string = DateFormat.getDateTimeInstance().format(new Date());

                            String[] parts = string.split(":");
                            String part1 = parts[0]; // 004
                            String part2 = parts[1]; // 034556
                            if(time2==t){
//    Toast.makeText(MainActivity2.this, "online", Toast.LENGTH_SHORT).show();


                                textView19.setText("online");
                                textView19b.setText("since : "+ online);
                                button6.setBackgroundResource(R.drawable.colorchange);

                            }

                            Handler handler3= new Handler();
                            handler3.postDelayed(new Runnable() {
                                @Override
                                public void run(){

                                    if(time2!=t) {

//    Toast.makeText(MainActivity2.this, "offline", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(MainActivity2.this, part2, Toast.LENGTH_SHORT).show();
                                        textView19.setText("offline");
                                        textView19b.setText("since : "+online2);
                                        button6.setBackgroundResource(R.drawable.redcolor);
                                    }
                                }
                            }, 5000);




//                    Toast.makeText(MainActivity2.this, part2, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(MainActivity2.this, data, Toast.LENGTH_SHORT).show();



//                    splitt= email.substring(0,email.indexOf("@"));
//                    String minn = currentDateTimeString.substring(0,currentDateTimeString.indexOf(":"));


//        button91.setText(data);


                        }
                    }
                }, 100);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        databaseReference102 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/online");
        databaseReference102.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = snapshot.getValue().toString();
                if(snapshot.exists()){

//                    Strin

                    online = data;




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        databaseReference102 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/alarm_hour1");
        databaseReference102.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = snapshot.getValue().toString();
                if(snapshot.exists()){

//                    Strin

                    alarm_hour2 = Integer.parseInt(data);




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference102 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/online2");
        databaseReference102.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = snapshot.getValue().toString();
                if(snapshot.exists()){

//                    Strin

                    online2 = data;




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference102 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/Auto1");
        databaseReference102.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = snapshot.getValue().toString();
                if(snapshot.exists()){

                    ttt = Integer.parseInt(data);

                    if(ttt==1){
                        databaseReference9.setValue(13);
                        databaseReference8.setValue(13);
                    }
                    if(ttt==0){
                        databaseReference9.setValue(14);
                        databaseReference8.setValue(14);
                    }

//                    Strin






                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        databaseReference567 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/minute2");
        databaseReference567.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Handler handler3= new Handler();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run(){
                        String data = snapshot.getValue().toString();
                        if(snapshot.exists()){

//                    String string = "004-034556";
                            String string = DateFormat.getDateTimeInstance().format(new Date());

                            String[] parts = string.split(":");
                            String part1 = parts[0]; // 004
                            String part2 = parts[1]; // 034556
                            t = Integer.parseInt(data);

                            if(time2==t){
//    Toast.makeText(MainActivity2.this, "online", Toast.LENGTH_SHORT).show();


                                textView19.setText("online");
                                textView19b.setText("since : "+online);
                                button6.setBackgroundResource(R.drawable.colorchange);

                            }

                            Handler handler3= new Handler();
                            handler3.postDelayed(new Runnable() {
                                @Override
                                public void run(){
//                                databaseReference6.setValue(0);
                                    if(time2!=t) {

//    Toast.makeText(MainActivity2.this, "offline", Toast.LENGTH_SHORT).show();
//                                Toast.makeText(MainActivity2.this, part2, Toast.LENGTH_SHORT).show();
                                        textView19.setText("offline");
                                        textView19b.setText("since : "+online2);
                                        button6.setBackgroundResource(R.drawable.redcolor);
                                    }

                                }
                            }, 5000);



//                    Toast.makeText(MainActivity2.this, part2, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(MainActivity2.this, data, Toast.LENGTH_SHORT).show();


//                    splitt= email.substring(0,email.indexOf("@"));
//                    String minn = currentDateTimeString.substring(0,currentDateTimeString.indexOf(":"));


//        button91.setText(data);


                        }

                    }
                }, 100);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference49 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/endalarmhour");
        databaseReference49.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = snapshot.getValue().toString();
                if(snapshot.exists()){


//        button91.setText(data);
                    if(data.equalsIgnoreCase("999")){
//                button91.setBackground(@drawable/Color);
                        textView16.setText("- | - - | -");


                        textView17.setText("- | - - | -");
//                        button4.setBackgroundResource(R.drawable.rounder_corner);
//                        Toast.makeText(MainActivity2.this, data, Toast.LENGTH_SHORT).show();
//                        button4.setBackgroundResource(R.drawable.rounder_corner);
                    }
                    else{



                        databaseReference50= FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/alarm_hour1");
                        databaseReference50.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String data = snapshot.getValue().toString();
                                int data2 = Integer.parseInt(data);
                                if(snapshot.exists()){

                                    if(data2==999){
                                        textView16.setText("- | - ");
                                        textView16b.setText("- | - ");
                                        textView17.setText("- | - ");
                                        textView17b.setText("- | - ");
                                    }
                                    else{


//        button91.setText(data);
                                        if(data2>=12){
//                                       int hrss = Integer.toString(data2-12);
                                            pm = "PM";
                                            String data3 = Integer.toString(data2-12);
//                                        String tim2 = Integer.toString(minute);
                                            textView16.setText(data3+" : "+"         PM");
                                        }
                                        else{
                                            String s= Integer.toString(data2);
                                            pm = "AM";
                                            textView16.setText(s+" : "+"         AM");
//                                        String tim2 = Integer.toString(minute);
//                                        textView16.setText(tim+" : "+"  AM");
//                                    textView16.setText(tim+"  AM");
                                        }
                                    }

                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                        databaseReference51= FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/endalarmhour");
                        databaseReference51.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String data = snapshot.getValue().toString();
                                data23 = Integer.parseInt(data);
                                if(snapshot.exists()){
                                    if(data23==999){
                                        textView16.setText("- | - ");
                                        textView16b.setText("- | - ");
                                        textView17.setText("- | - ");
                                        textView17b.setText("- | - ");
                                    }
                                    else{


//        button91.setText(data);
                                        if(data23>=12){
//                                       int hrss = Integer.toString(data2-12);
                                            pm = "PM";
                                            String data3 = Integer.toString(data23-12);
//                                        String tim2 = Integer.toString(minute);
                                            textView17.setText(data3+" : "+"         PM");
                                        }
                                        else{
                                            String s= Integer.toString(data23);
                                            pm = "AM";
                                            textView17.setText(s+" : "+"         AM");
//                                        String tim2 = Integer.toString(minute);
//                                        textView16.setText(tim+" : "+"  AM");
//                                    textView16.setText(tim+"  AM");
                                        }

                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                        databaseReference51= FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/endalarm_min1");
                        databaseReference51.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String data = snapshot.getValue().toString();
                                int data2 = Integer.parseInt(data);
                                if(snapshot.exists()){


//        button91.setText(data);

                                    textView17b.setText(data);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                        databaseReference51 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/alarm_min1");
                        databaseReference51.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String data = snapshot.getValue().toString();

                                if(snapshot.exists()){


//        button91.setText(data);
                                    mins = data;
                                    textView16b.setText(data);


                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
//                        textView16.setText(hrs+" :"+mins+" "+pm);
//                        button4.setBackgroundResource(R.drawable.lightred);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                strr = intent.getStringExtra("message2");
                if(auto ==13){
                    databaseReference8.setValue(auto);
                    databaseReference9.setValue(auto);
                    databaseReference19.setValue(0);
                    button4.setBackgroundResource(R.drawable.rounder_corner);
                    auto=14;


                }
                else if(auto==14){
                    databaseReference8.setValue(auto);
                    databaseReference9.setValue(auto);
                    button4.setBackgroundResource(R.drawable.lightred);
                    auto =13;
                    Toast.makeText(MainActivity2.this, "", Toast.LENGTH_SHORT).show();
                }

            }
            
        });





        databaseReference = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/R-Phase");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String data = snapshot.getValue().toString();
//        button91.setText(data);
                    if(data=="false"){
//                button91.setBackground(@drawable/Color);
                        button91.setBackgroundResource(R.drawable.redd);
//                Toast.makeText(MainActivity2.this, data, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        button91.setBackgroundResource(R.drawable.lightred);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        databaseReference = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/STATUS");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String data = snapshot.getValue().toString();
//        button91.setText(data);
                    if(data=="false"){
//                button91.setBackground(@drawable/Color);
                        textView.setText(":               Running/चालू");
//                        button41.setBackgroundResource(R.drawable.rounder_corner);
                    }
                    else{
//                        button41.setBackgroundResource(R.drawable.lightred);
                        textView.setText(":               OFF/बंद");
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        databaseReference = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/Y-Phase");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String data = snapshot.getValue().toString();
//        button91.setText(data);
                    if(data=="false"){
//                button91.setBackground(@drawable/Color);
                        button7.setBackgroundResource(R.drawable.yellow);
                    }
                    else{
                        button7.setBackgroundResource(R.drawable.lightred);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/B-Phase");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String data = snapshot.getValue().toString();
//        button91.setText(data);
                    if(data=="false"){
//                button91.setBackground(@drawable/Color);
                        button99.setBackgroundResource(R.drawable.lightreddd);
//                        button.setTextColor(@ColorInt);
                    }
                    else{
                        button99.setBackgroundResource(R.drawable.lightred);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/R-Phase");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot){
                if(snapshot.exists()){
                    String data = snapshot.getValue().toString();
//        button91.setText(data);
                    if(data=="false"){
//                button91.setBackground(@drawable/Color);
//                        button5.setBackgroundResource(R.drawable.redcolor);
//                        button.setTextColor(@ColorInt);
                    }
                    else{
//                        button5.setBackgroundResource(R.drawable.lightred);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



//        button.setOnTouchListener(new View.OnTouchListener() {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//
//            int eventPadTouch = event.getAction();
//
//            switch (eventPadTouch) {
//
//                case MotionEvent.ACTION_DOWN:
//                    // start playing sound , in your case:
////                    mp.setLooping(true);
////
//
////               strr2 = intent4.getStringExtra("message");
////               if(strr2!=null){
////                   databaseReference12.setValue(strr2);
////               }
//
////                    mp.start();
////                    vibrator.vibrate(1);
////                    databaseReference6 = FirebaseDatabase.getInstance().getReference("/"+strr2+"ON");
////                    Toast.makeText(MainActivity2.this, strr2, Toast.LENGTH_SHORT).show();
////                    databaseReference6 = FirebaseDatabase.getInstance().getReference("CONTROLL");
//                    long[] pattern = { 0, 200, 0 }; //0 to start now, 200 to vibrate 200 ms, 0 to sleep for 0 ms.
//                    vibrator.vibrate(pattern, 0);
////                    databaseReference6.setValue("ON");
//                    databaseReference6.setValue(44);
//
//                    button.setBackgroundResource(R.drawable.lightred);
//
//
//                    return true;
//
//
//                case MotionEvent.ACTION_UP:
//                    // stop playing sound , in your case:
////                    mp.pause();
//                    button.setBackgroundResource(R.drawable.colorchange);
////                    databaseReference6.setValue("OFF");
//                    vibrator.cancel();
//                    return true;
//
//            }
//            return false;
//        }
//    });
//
//



        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp2.start();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        // Do something after 5s = 5000ms
//            buttons[inew][jnew].setBackgroundColor(Color.BLACK);

                        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
                        try {
                            startActivityForResult(intent, RESULT_SPEECH);
//                    tvText.setText("");
                        } catch (ActivityNotFoundException e) {
                            Toast.makeText(getApplicationContext(), "Your device doesn't support Speech to Text", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                }, 2300);


            }
        });



        button5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventPadTouch = event.getAction();
                switch (eventPadTouch) {
                    case MotionEvent.ACTION_DOWN:




                        // start playing sound , in your case:
//                        mp.setLooping(true);
//                        mp.start();
                        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

                        // geeksData represent the file data that is saved publicly
                        File file = new File(folder, "geeksData.txt");
                        String data = getdata(file);
                        if (data != null){
//                            Toast.makeText(MainActivity2.this, data, Toast.LENGTH_SHORT).show();
                        } else {
//            textView.setText("No Data Found");
//                            Toast.makeText(MainActivity2.this, "no data found", Toast.LENGTH_SHORT).show();
                        }
                        long[] pattern = { 0, 200, 0 }; //0 to start now, 200 to vibrate 200 ms, 0 to sleep for 0 ms.
                        vibrator.vibrate(pattern, 0);
                        databaseReference8.setValue(12);

                        button5.setBackgroundResource(R.drawable.redcolor);



                        return true;


                    case MotionEvent.ACTION_UP:
                        // stop playing sound , in your case:
//                        mp.pause();
                        databaseReference11.setValue(1);

                        button5.setBackgroundResource(R.drawable.lightred);
//                        databaseReference7.setValue(1);
                        vibrator.cancel();


                        return true;
                }
                return false;
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                databaseReference11.setValue(0);

//timer()

                Handler handler3 = new Handler();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run(){

//                         databaseReference10.setValue(1);
//                         mp6.start();
                        databaseReference11.setValue(1);

                    }
                }, 20);

            }
        });





        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                int eventPadTouch = event.getAction();
                switch (eventPadTouch) {
                    case MotionEvent.ACTION_DOWN:
                        button.setBackgroundResource(R.drawable.colorchange);

                        // start playing sound , in your case:
//                        mp.setLooping(true);
//                        mp.start();

                        long[] pattern = { 0, 200, 0 }; //0 to start now, 200 to vibrate 200 ms, 0 to sleep for 0 ms.
                        vibrator.vibrate(pattern, 0);
                        strr2 = intent4.getStringExtra("message");
                        if(strr2!=null){
                            databaseReference12.setValue(strr2);
                            checking = intent4.getStringExtra("message");
                        }
                        if(checking!=null){
                            String check = checking;
                            if(check!=null){
                                myEdit.putString("NAME",check);
                                myEdit.commit();
                            }

                        }

                        SharedPreferences sh = getSharedPreferences("mySharepref",MODE_PRIVATE);
                        String name = sh.getString("NAME","");
//                   Toast.makeText(MainActivity2.this, name, Toast.LENGTH_SHORT).show();

                        databaseReference8.setValue(11);
                        Handler handler3= new Handler();
                        handler3.postDelayed(new Runnable() {
                            @Override
                            public void run(){
//                                databaseReference6.setValue(0);
                                databaseReference8.setValue(0);

                            }
                        }, 10000);




                        return true;


                    case MotionEvent.ACTION_UP:
                        // stop playing sound , in your case:
//                        mp.pause();
                        databaseReference10.setValue(0);

                        button.setBackgroundResource(R.drawable.lightred);
//                        databaseReference7.setValue(1);
                        vibrator.cancel();


                        return true;
                }


                return false;
            }
        });
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                databaseReference10.setValue(1);
//
////
//                Handler handler99 = new Handler();
//                handler99.postDelayed(new Runnable() {
//                    @Override
//                    public void run(){
//
////                         databaseReference10.setValue(1);
////                         mp6.start();
//                        databaseReference10.setValue(0);
//
//                    }
//                }, 3000);
//
//            }
//        });




//        button.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                int eventPadTouch = event.getAction();
//
//                switch (eventPadTouch) {
//
//                    case MotionEvent.ACTION_DOWN:
//                        // start playing sound , in your case:
//                        mp.setLooping(true);
//                        mp.start();
//                        button.setBackgroundResource(R.drawable.lightred);
//                        return true;
//
//
//                    case MotionEvent.ACTION_UP:
//                        // stop playing sound , in your case:
//                        mp.pause();
//                        button.setBackgroundResource(R.drawable.colorchange);
//                        return true;
//
//                }
//                return false;
//            }
//        });
//




        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

//         button.findViewById(R.id.button);
//        Button button = findViewById(R.id.button);







//        button53.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(i == 1){
////                    button53.setBackgroundResource(R.drawable.redcolor);
//                    button53.setText("Reset Timer");
////                    databaseReference.child("users").child("child").child("hemant").setValue("osho");
//
////                    Intent intent = new Intent(MainActivity2.this,  LoginActivity.class);
////                    startActivity(intent);
//
//                    databaseReference5.setValue(1);
//                    i=0;
//                }
//                else if(i==0){
//                    button53.setBackgroundResource(R.drawable.lightred);
//
//
//
//                    button53.setText("Reset Timer");
//
//                    databaseReference5.setValue(0);
//
//                    i =1;
//                }
//
//            }

//        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog2,null);
//                View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
                final ImageView imageView = (ImageView)mView.findViewById(R.id.imageView12);
//                final EditText txt_inputText = (EditText)mView.findViewById(R.id.txt_input);
//                Button btn_cancel = (Button)mView.findViewById(R.id.btn_cancel);
//                View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
                final ImageView imageView55 = (ImageView)mView.findViewById(R.id.imageView12);
                final ImageView imageView56 = (ImageView)mView.findViewById(R.id.imageView11);
                final Button button = (Button)mView.findViewById(R.id.button4);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView16.setText("- | - ");
                        textView16b.setText("- | - ");
                        textView17.setText("- | - ");
                        textView17b.setText("- | - ");
                        databaseReference15.setValue(999);
                        databaseReference3.setValue(999);
                    }
                });
//              textView16.setText("- | - ");
//              textView16b.setText("- | - ");
                imageView56.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this,
                                new TimePickerDialog.OnTimeSetListener() {

                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay,
                                                          int minute) {


//
                                        databaseReference3.setValue(hourOfDay);
                                        databaseReference4.setValue(minute);
                                        if(hourOfDay>=12){
                                            String tim = Integer.toString(hourOfDay-12);
                                            String tim2 = Integer.toString(minute);
//                                    textView17.setText(tim+" : "+ tim2 +"  PM");
                                        }
                                        else{
                                            String tim = Integer.toString(hourOfDay);
                                            String tim2 = Integer.toString(minute);
//                                    textView17.setText(tim+" : "+ tim2 +"  AM");
//                                    textView16.setText(tim+"  AM");
                                        }


                                    }
                                }, mHour, mMinute, false);
                        timePickerDialog.show();

                    }
                });

//        View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
//        final ImageView imageView = (ImageView)mView.findViewById(R.id.imageView12);
                imageView55.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                Toast.makeText(MainActivity2.this, "hello evryone", Toast.LENGTH_SHORT).show();

                        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this,
                                new TimePickerDialog.OnTimeSetListener() {

                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay,
                                                          int minute) {


                                        databaseReference15.setValue(hourOfDay);
                                        databaseReference2.setValue(minute);
                                        if(hourOfDay>=12){
                                            String tim = Integer.toString(hourOfDay-12);
                                            String tim2 = Integer.toString(minute);
//                                    textView16.setText(tim+" : "+ tim2 +"  PM");
                                        }
                                        else{
                                            String tim = Integer.toString(hourOfDay);
                                            String tim2 = Integer.toString(minute);
//                                    textView16.setText(tim+" : "+ tim2 +"  AM");
//                                    textView16.setText(tim+"  AM");
                                        }

//                                textView16.setText(tim);


                                    }
                                }, mHour, mMinute, false);
                        timePickerDialog.show();

                    }
                });



                Button btn_okay = (Button)mView.findViewById(R.id.btn_okay);

                alert.setView(mView);
                final AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
//                btn_cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v){
//                        alertDialog.dismiss();
//                    }
//                });
                btn_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        myCustomMessage.setText(txt_inputText.getText().toString());
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();


            }
        });



//        button53.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int eventPadTouch = event.getAction();
//                switch (eventPadTouch) {
//                    case MotionEvent.ACTION_DOWN:
//                        long[] pattern = { 0, 200, 0 }; //0 to start now, 200 to vibrate 200 ms, 0 to sleep for 0 ms.
//                        vibrator.vibrate(pattern, 0);
//                        button.setBackgroundResource(R.drawable.rounder_corner);
//
//
//                        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
//                        View mView = getLayoutInflater().inflate(R.layout.custom_dialog2,null);
////                View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
//                        final ImageView imageView = (ImageView)mView.findViewById(R.id.imageView12);
////                final EditText txt_inputText = (EditText)mView.findViewById(R.id.txt_input);
////                Button btn_cancel = (Button)mView.findViewById(R.id.btn_cancel);
////                View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
//                        final ImageView imageView55 = (ImageView)mView.findViewById(R.id.imageView12);
//                        final ImageView imageView56 = (ImageView)mView.findViewById(R.id.imageView11);
//                        imageView56.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this,
//                                        new TimePickerDialog.OnTimeSetListener() {
//
//                                            @Override
//                                            public void onTimeSet(TimePicker view, int hourOfDay,
//                                                                  int minute) {
//
//
////
//                                                databaseReference3.setValue(hourOfDay);
//                                                databaseReference4.setValue(minute);
//                                                if(hourOfDay>=12){
//                                                    String tim = Integer.toString(hourOfDay-12);
//                                                    String tim2 = Integer.toString(minute);
////                                    textView17.setText(tim+" : "+ tim2 +"  PM");
//                                                }
//                                                else{
//                                                    String tim = Integer.toString(hourOfDay);
//                                                    String tim2 = Integer.toString(minute);
////                                    textView17.setText(tim+" : "+ tim2 +"  AM");
////                                    textView16.setText(tim+"  AM");
//                                                }
//
//
//                                            }
//                                        }, mHour, mMinute, false);
//                                timePickerDialog.show();
//
//                            }
//                        });
//
////        View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
////        final ImageView imageView = (ImageView)mView.findViewById(R.id.imageView12);
//                        imageView55.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
////                Toast.makeText(MainActivity2.this, "hello evryone", Toast.LENGTH_SHORT).show();
//
//                                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this,
//                                        new TimePickerDialog.OnTimeSetListener() {
//
//                                            @Override
//                                            public void onTimeSet(TimePicker view, int hourOfDay,
//                                                                  int minute) {
//
//
//                                                databaseReference15.setValue(hourOfDay);
//                                                databaseReference2.setValue(minute);
//                                                if(hourOfDay>=12){
//                                                    String tim = Integer.toString(hourOfDay-12);
//                                                    String tim2 = Integer.toString(minute);
////                                    textView16.setText(tim+" : "+ tim2 +"  PM");
//                                                }
//                                                else{
//                                                    String tim = Integer.toString(hourOfDay);
//                                                    String tim2 = Integer.toString(minute);
////                                    textView16.setText(tim+" : "+ tim2 +"  AM");
////                                    textView16.setText(tim+"  AM");
//                                                }
//
////                                textView16.setText(tim);
//
//
//                                            }
//                                        }, mHour, mMinute, false);
//                                timePickerDialog.show();
//
//                            }
//                        });
//
//
//
//                        Button btn_okay = (Button)mView.findViewById(R.id.btn_okay);
//
//                        alert.setView(mView);
//                        final AlertDialog alertDialog = alert.create();
//                        alertDialog.setCanceledOnTouchOutside(false);
////                btn_cancel.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v){
////                        alertDialog.dismiss();
////                    }
////                });
//                        btn_okay.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
////                        myCustomMessage.setText(txt_inputText.getText().toString());
//                                alertDialog.dismiss();
//                            }
//                        });
//                        alertDialog.show();
//
//
//
//
//
//
////                Toast.makeText(MainActivity2.this, "hello boy", Toast.LENGTH_SHORT).show();
//                    case MotionEvent.ACTION_UP:
//
//
//                        // stop playing sound , in your case:
////                        mp.pause();
////                Toast.makeText(MainActivity2.this, "hello guy", Toast.LENGTH_SHORT).show();
//
//                        button.setBackgroundResource(R.drawable.lightred);
////                        databaseReference7.setValue(1);
//                        textView17.setText("- | - ");
//                        textView17b.setText("- | - ");
//                        vibrator.cancel();
//                        return true;
//                }
//                return false;
//            }
//        });

        imageView4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        }));





    }

    private void showMainActivity(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity2.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void logoutUser() {



        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity2.this);

        alertDialog.setTitle("Logout"); // Sets title for your alertbox

        alertDialog.setMessage("Are you sure you want to Logout ?"); // Message to be displayed on alertbox

        alertDialog.setIcon(R.drawable.logoo); // Icon for your alertbox


        /* When positive (yes/ok) is clicked */
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity2.this, LoginActivity.class);
                startActivity(intent);
                finish();
//                    Toast.makeText(MainActivity2.this,"Successfully Logged Out", Toast.LENGTH_LONG).show();
            }
        });
        /* When negative (No/cancel) button is clicked*/
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();


    }
    private void timer() {



        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity2.this);

        alertDialog.setTitle("Set Timer"); // Sets title for your alertbox

//        alertDialog.setMessage("Are you sure you want to Logout ?"); // Message to be displayed on alertbox

        alertDialog.setIcon(R.drawable.logoo); // Icon for your alertbox


        /* When positive (yes/ok) is clicked */
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity2.this, LoginActivity.class);
                startActivity(intent);
                finish();
//                    Toast.makeText(MainActivity2.this,"Successfully Logged Out", Toast.LENGTH_LONG).show();
            }
        });
        /* When negative (No/cancel) button is clicked*/
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.radhe);

        MediaPlayer mp10 = MediaPlayer.create(this,R.raw.radhe2);
        if(mp10.isPlaying()){

            mp10.stop();
            mp10.release();
            mp10.pause();
        }



        switch (requestCode){
            case RESULT_SPEECH:
                if(resultCode == RESULT_OK && data != null){
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//                    tvText.setText(text.get(0));
                    String motor = text.get(0);
//                     MediaPlayer mp10 = MediaPlayer.create(this,R.raw.radhe);
                    Toast.makeText(this, motor, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "motor has started", Toast.LENGTH_SHORT).show();

                    String[] strAr = {"vandu kaise ho", "banduk kaise ho", "kaise ho","bandook kaise ho","kaise Ho Bandhu"};


                    if((text.get(0).toString().toLowerCase().contains("kaise") && text.get(0).toString().toLowerCase().contains("ho"))||(text.get(0).toString().toLowerCase().contains("kaisa") && text.get(0).toString().toLowerCase().contains("ho"))){
                        final MediaPlayer mp5 = MediaPlayer.create(this,R.raw.bandhuhaal);


                        mp5.start();
                    }
                    if((text.get(0).toString().toLowerCase().contains("Bhajan"))||(text.get(0).toString().toLowerCase().contains("bhajan"))||(text.get(0).toString().toLowerCase().contains("gaana") && text.get(0).toString().toLowerCase().contains("sunao"))){

//                        mp10.start();
                        String urll = "https://firebasestorage.googleapis.com/v0/b/hello-f532f.appspot.com/o/jai-radhe-jai-radhe-zpdYqcfQ.mp3?alt=media&token=3aca118e-b779-493c-bf12-026bab5226ba";
//                        mp.start();
                        playAudio();
                    }





                    if(text.get(0).toString().equalsIgnoreCase("Motorola Caro")|| (text.get(0).toString().toLowerCase().contains("motor") && text.get(0).toString().toLowerCase().contains("chalu") )||text.get(0).toString().equalsIgnoreCase("motor chalu kar de")|| text.get(0).toString().equalsIgnoreCase("motor chalu karo") || text.get(0).toString().equalsIgnoreCase("motor chalu kar do ") || text.get(0).toString().equalsIgnoreCase("motorcycle")){

//                        databaseReference6.setValue("ON");
//                            final Handler handler2 = new Handler();
                        final MediaPlayer mp3 = MediaPlayer.create(this,R.raw.motorchaluhog);
                        final MediaPlayer mp4 = MediaPlayer.create(this,R.raw.motoroffing);

                        mp4.start();
                        databaseReference8.setValue(11);

                        Handler handler2 = new Handler();
                        handler2.postDelayed(new Runnable() {
                            @Override
                            public void run(){


                                mp3.start();

                            }
                        }, 3000);
                        Handler handler3= new Handler();
                        handler3.postDelayed(new Runnable() {
                            @Override
                            public void run(){
//                                databaseReference6.setValue(0);


                            }
                        }, 5000);


                    }



                    if(text.get(0).toString().equalsIgnoreCase("motor bandh karo")|| (text.get(0).toString().toLowerCase().contains("motor") && text.get(0).toString().toLowerCase().contains("band") )||text.get(0).toString().equalsIgnoreCase("motor band kar de")|| text.get(0).toString().equalsIgnoreCase("motor band karo") || text.get(0).toString().equalsIgnoreCase("motor bandh kar do ") || text.get(0).toString().equalsIgnoreCase("motorcycle")){

//                        databaseReference6.setValue("ON");
//                            final Handler handler2 = new Handler();
                        final MediaPlayer mp5 = MediaPlayer.create(this,R.raw.motorgettingoff);
                        final MediaPlayer mp6 = MediaPlayer.create(this,R.raw.motorooof);



                        mp5.start();
                        databaseReference8.setValue(12);

                        Handler handler2 = new Handler();
                        handler2.postDelayed(new Runnable() {
                            @Override
                            public void run(){

//                                mp6.start();

                            }
                        }, 3000);

                        Handler handler3= new Handler();
                        handler3.postDelayed(new Runnable() {
                            @Override
                            public void run(){
//                                databaseReference6.setValue(0);


                            }
                        }, 5000);








                    }


                }

        }
    }

    private void showPrivateData() {

        // GeeksForGeeks represent the folder name to access privately saved data
        File folder = getExternalFilesDir("AGRONOMIST");

        // gft.txt is the file that is saved privately
        File file = new File(folder, "agro.txt");
        String data = getdata(file);

        if (data != null){
            TOKEN= getdata(file);
//            textView.setText(data);
//            Toast.makeText(this, data+"this is the real data", Toast.LENGTH_SHORT).show();
        } else {
            TOKEN = "token3467";
//            textView.setText("No Data Found");
//            Toast.makeText(this, "data not found for privatae data show", Toast.LENGTH_SHORT).show();
        }
    }
    private String getdata(File myfile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myfile);
            int i = -1;
            StringBuffer buffer = new StringBuffer();
            while ((i = fileInputStream.read()) != -1){
                buffer.append((char) i);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private void playAudio(){

        String audioUrl =  "https://firebasestorage.googleapis.com/v0/b/hello-f532f.appspot.com/o/jai-radhe-jai-radhe-zpdYqcfQ.mp3?alt=media&token=3aca118e-b779-493c-bf12-026bab5226ba";

        String audioUrl2 = "https://firebasestorage.googleapis.com/v0/b/hello-f532f.appspot.com/o/Har%20Har%20Shambhu%20Shiv%20Mahadeva_64(PagalWorld.com.se).mp3?alt=media&token=25ee079d-ab27-4b63-82c4-0e4d3fe1ddbf";
        // initializing media player
        String audioUrl3 = "https://firebasestorage.googleapis.com/v0/b/hello-f532f.appspot.com/o/Lagaan%202001%20-%20Radha%20Kaise%20Na%20Jale%20(1).mp3?alt=media&token=6ec8dc6e-55cc-4ff7-9d23-593081665c18";
        String audioUrl4 = "https://firebasestorage.googleapis.com/v0/b/hello-f532f.appspot.com/o/Har%20Har%20Shambhu%20Shiv%20Mahadeva_64(PagalWorld.com.se).mp3?alt=media&token=25ee079d-ab27-4b63-82c4-0e4d3fe1ddbf";
        mediaPlayer = new MediaPlayer();
        String rando[] = {audioUrl,audioUrl2,audioUrl3,audioUrl4};
        int upperBound = 0;
        int lowerBound = 3;
        int range = (upperBound - lowerBound) + 1;

//        System.out.println("Random Numbers between 10 and 20:");



        // generate random number
        // (int) convert double value to int
        // Math.random() generate value between 0.0 and 1.0
        int random = (int)(Math.random() * range) + lowerBound;

//        Toast.makeText(this, random+"is the random data", Toast.LENGTH_SHORT).show();

        // below line is use to set the audio
        // stream type for our media player.
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        // below line is use to set our
        // url to our media player.
        try {
            mediaPlayer.setDataSource(rando[random]);
            // below line is use to prepare
            // and start our media player.
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
//            e.printStackTrace();
//            Toast.makeText(this, "Audio started playing..", Toast.LENGTH_SHORT).show();
        }
        // below line is use to display a toast message.
//        Toast.makeText(this, "Audio started playing..", Toast.LENGTH_SHORT).show();
    }
    private final Runnable m_Runnable = new Runnable()
    {
        public void run()

        {
//            String string = DateFormat.getDateTimeInstance().format(new Date());
            String string = DateFormat.getDateTimeInstance().format(new Date());

            String[] parts = string.split(":");
            String part1 = parts[0]; // 004
            String part2 = parts[1]; // 034556
            int t = Integer.parseInt(part2);
//            Toast.makeText(MainActivity2.this, string, Toast.LENGTH_SHORT).show();
//            DatabaseReference databaseReference11;
//            Toast.makeText(MainActivity.this,"in runnable",Toast.LENGTH_SHORT).show();
            databaseReference11 = FirebaseDatabase.getInstance().getReference("/"+TOKEN+"/minute3");
            databaseReference11.setValue(t);
//            Toast.makeText(MainActivity2.this, "hello", Toast.LENGTH_SHORT).show();
            RequestQueue requestQueue;
            requestQueue = Volley.newRequestQueue(MainActivity2.this);

            Button button41 = findViewById(R.id.button41);
//        /RequestQueue requestQueue2;
//        requestQueue2 = Volley.newRequestQueue(MainActivity2.this);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                    "https://shopcartee.000webhostapp.com/api/weather/specific.php?id=1", null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {

//                    Toast.makeText(MainActivity.this,, Toast.LENGTH_SHORT).show();
//                    Log.d("myapp", "The response is" + response.ge.tString("led"));
//                    Toast.makeText(MainActivity.this, response.getString("led"), Toast.LENGTH_SHORT).show();
//                    String  hel =  response.getString("weather").substring(0,response.getString("weather").indexOf(":"));
//                    String hel2 = hel[1]l
                        String[] hel = response.getString("weather").split(":", 2);
//                    String[] hel2= hel[1].split("}", 1);
                        String hel2 = hel[1].substring(1,2);

                        if(hel2.toString().equalsIgnoreCase("1")){
//                            Toast.makeText(MainActivity2.this, "lalit mehta", Toast.LENGTH_SHORT).show();

                            button41.setBackgroundResource(R.drawable.redcolor);
//                        button5.setBackgroundResource(R.drawable.redcolor);

                        }
                        else{
                            button41.setBackgroundResource(R.drawable.rounder_corner);
                        }

//                        Toast.makeText(MainActivity2.this,  hel2, Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {


                }
            });

            requestQueue.add(jsonObjectRequest);

//            recreate();
//            Toast.makeText(MainActivity2.this, "refreshing acitivty after 10 second", Toast.LENGTH_SHORT).show();

            MainActivity2.this.mHandler.postDelayed(m_Runnable,1000);
        }

    };


}



//READING DATA FROM FIREBASE
//
//
// databaseReference = FirebaseDatabase.getInstance().getReference("/endalarm/Lalit");
//         databaseReference.addValueEventListener(new ValueEventListener() {
//@Override
//public void onDataChange(@NonNull DataSnapshot snapshot) {
//        if(snapshot.exists()){
//        String data = snapshot.getValue().toString();
//        button53.setText(data);
//        }
//        }
//
//@Override
//public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//        });


//SETTING VALUE IN CHILD OF FIREBASE
//        databaseReference3.child("kapilll").setValue("famous");
//                                databaseReference3.child("Lalit").setValue("superfamous");
//                                databaseReference3.child("Ram").setValue("God");


//command for sha shh key
//
//
//    gradlew signinReport
