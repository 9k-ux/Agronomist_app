//package com.example.myapplication14;
package com.example.agronomistfinal;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    ImageView imageView8;
    EditText editText;
    String himmat;
    String email;
    String splitt;
    String data1;
    private int EXTERNAL_STORAGE_PERMISSION_CODE = 23;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser currentUser = auth.getCurrentUser();

    private static final int REQUEST_CAMERA_PERMISSION = 201;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_login);
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        ActivityCompat.requestPermissions(LoginActivity.this , new
                String[]{Manifest.permission.CAMERA} , REQUEST_CAMERA_PERMISSION);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            finish();
            return;
        }








        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticateUser();
            }
        });

        Button tvSwitchToRegister = findViewById(R.id.tvSwitchToRegister);
        tvSwitchToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToRegister();
            }
        });
    }

    private void authenticateUser() {
        EditText etLoginEmail = findViewById(R.id.etLoginEmail);
        EditText etLoginPassword = findViewById(R.id.etLoginPassword);

        email = etLoginEmail.getText().toString();

        String password = etLoginPassword.getText().toString();
        if (email.isEmpty() || password.isEmpty()) {

            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
            findViewById(R.id.loadingPanel).setVisibility(View.GONE);

            return;
        }
        splitt= email.substring(0,email.indexOf("@"));
        databaseReference = FirebaseDatabase.getInstance().getReference("/"+splitt);
        databaseReference.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot){
                if(snapshot.exists()){
                    data1 = snapshot.getValue().toString();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        Toast.makeText(this, splitt, Toast.LENGTH_LONG).show();

        findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            savePrivately();
                            findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                            savePrivately();
                            databaseReference = FirebaseDatabase.getInstance().getReference("/"+splitt);
         databaseReference.addValueEventListener(new ValueEventListener(){
@Override
public void onDataChange(@NonNull DataSnapshot snapshot){
        if(snapshot.exists()){
         data1 = snapshot.getValue().toString();


        }
        }

@Override
public void onCancelled(@NonNull DatabaseError error) {

        }
        });


                            showMainActivity();
                        } else {
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            Toast.setBackground(getResources().getDrawable(R.drawable.your_drawable_id));
                            findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                        }
                    }
                });
    }

    private void showMainActivity() {
        EditText editText = findViewById(R.id.etLoginPassword);
        String dataa = editText.getText().toString();

        Intent intent = new Intent(LoginActivity.this, MainActivity2.class);
        intent.putExtra("message2", data1);
        startActivity(intent);
        finish();



    }

    private void switchToRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }
    private void savePrivately(){
//        String editTextData = editText.getText().toString();

        // Creating folder with name GeekForGeeks
        File folder = getExternalFilesDir("AGRONOMIST");

        // Creating file with name gfg.txt
        File file = new File(folder, "agro.txt");
        writeTextData(file,data1);

//        editText.setText("");
    }
    private void writeTextData(File file, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes());
//            Toast.makeText(this, "Done" + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}






