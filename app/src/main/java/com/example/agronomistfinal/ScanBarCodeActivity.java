//package com.example.myapplication14;
//package com.example.agronomistfinal;
package com.example.agronomistfinal;
//mport androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.provider.MediaStore;
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
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;
//   DatabaseReference databaseReference8;

public class ScanBarCodeActivity extends AppCompatActivity {

    SurfaceView surfaceView;
    TextView txtBarcodeValue;
    Button button;
    String name;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    DatabaseReference databaseReference3;

    DatabaseReference databaseReference;

    private static final int REQUEST_CAMERA_PERMISSION = 201;







    Button btnAction;
    String intentData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = findViewById(R.id.button);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_scan_bar_code);
        Intent intent = getIntent();
         name = intent.getStringExtra("message4");
        Toast.makeText(ScanBarCodeActivity.this, name, Toast.LENGTH_SHORT).show();
//        DatabaseReference databaseReference8;
//        databaseReference8 = FirebaseDatabase.getInstance().getReference("/tokenjk");
        initViews();

    }



    private void initViews() {

        txtBarcodeValue = findViewById(R.id.txtBarcodeValue);
        surfaceView = findViewById(R.id.surfaceView);
        Button button2 = findViewById(R.id.button);
        btnAction = findViewById(R.id.btnAction);
        button = findViewById(R.id.button3);
        databaseReference3 = FirebaseDatabase.getInstance().getReference("/Token1");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                databaseReference3.child("lalitmehta@gmail.com").setValue("roshan");
                Intent intent = new Intent(ScanBarCodeActivity.this, RegisterActivity.class);


                startActivity(intent);
                finish();
            }
        });

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intentData.length() > 0) {
                    startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse(intentData)));
                }
            }
        });
    }

    private void initialiseDetectorsAndSources() {

//        Toast.makeText(getApplicationContext() , "Barcode scanner started" , Toast.LENGTH_SHORT).show();
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();

        cameraSource = new CameraSource.Builder(this , barcodeDetector)
                .setRequestedPreviewSize(1920 , 1080)
                .setAutoFocusEnabled(true) //you should add this feature
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(ScanBarCodeActivity.this , Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        cameraSource.start(surfaceView.getHolder());
                    } else {
                        ActivityCompat.requestPermissions(ScanBarCodeActivity.this , new
                                String[]{Manifest.permission.CAMERA} , REQUEST_CAMERA_PERMISSION);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder , int format , int width , int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });


        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
//                Toast.makeText(getApplicationContext() , "To prevent memory leaks barcode scanner has been stopped" , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if (barcodes.size() != 0) {
                    txtBarcodeValue.post(new Runnable() {
                        @Override
                        public void run() {
                            btnAction.setText("LAUNCH URL");
                            intentData = barcodes.valueAt(0).displayValue;
                            txtBarcodeValue.setText(intentData);
                            databaseReference = FirebaseDatabase.getInstance().getReference("/"+name);
                            databaseReference.setValue(intentData);
                            Intent intent = new Intent(ScanBarCodeActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();

//                            Intent intent = new Inten(ScanBarCodeActivity.this, RegisterActivity.class);
//                            startActivity(intent);
//                            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
//                            intent.putExtra("message4", intentData);
//                            startActivity(intent);
//                            databaseReference3.child("lalitmehta@gmail.com").setValue("roshan");
//                                databaseReference3.child("Lalit").setValue("superfamous");
//                                databaseReference3.child("Ram").setValue("God");
//                            Toast.makeText(ScanBarCodeActivity.this, intentData, Toast.LENGTH_SHORT).show();
//                            finish();
                            Toast.makeText(ScanBarCodeActivity.this, intentData, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        cameraSource.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initialiseDetectorsAndSources();
    }
}