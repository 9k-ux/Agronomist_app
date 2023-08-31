//package com.example.myapplication14;
package com.example.agronomistfinal;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.TimeUnit;
import android.Manifest;
import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.AuthResult;
import java.util.concurrent.TimeUnit;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class RegisterActivity extends AppCompatActivity {
    ImageView imageView;
    private FirebaseAuth mAuth;
    private FirebaseAuth mAuth2;
    private int EXTERNAL_STORAGE_PERMISSION_CODE = 23;
    String str34 = "deo";
    String editTextData;
    String splitt;
    EditText edtPhone;
    // variable for our text input
    // field for phone and OTP.
    private EditText  edtOTP;
    String number55;
    DatabaseReference databaseReference;
    Intent intent4 = getIntent();


    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText editText;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirebaseMessaging.getInstance().subscribeToTopic("notification");
        editText = findViewById(R.id.etFirstName);
        editText = (EditText) findViewById(R.id.etFirstName);
        edtPhone = findViewById(R.id.contact);
        edtOTP = findViewById(R.id.txt_input);



        savePublicly();
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        mAuth2 = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            finish();
            return;
        }
//        ImageView imageView7 = findViewById(R.id.imageView7);
//        imageView7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(RegisterActivity.this, ScanBarCodeActivity.class);
//                startActivity(intent);
//                finish();
////        Toast.makeText(RegisterActivity.this, "correct bro", Toast.LENGTH_SHORT).show();
//
//            }
//        });
        Button btnRegister = findViewById(R.id.btnRegister2);
        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(edtPhone.getText().toString())) {
                    // when mobile number text field is empty
                    // displaying a toast message.
                    Toast.makeText(RegisterActivity.this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show();
                } else {
                    // if the text field is not empty we are calling our
                    // send OTP method for getting OTP from Firebase.
                    String phone = "+91" + edtPhone.getText().toString();
                    findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
                    registerUser();
                    sendVerificationCode(phone);
                }

            }
        });

        TextView textViewSwitchToLogin = findViewById(R.id.tvSwitchToLogin);
        textViewSwitchToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToLogin();
            }
        });
    }

    private void registerUser() {
        EditText etFirstName = findViewById(R.id.etFirstName);
        EditText etLastName = findViewById(R.id.etLastName);
        EditText etRegisterEmail = findViewById(R.id.etRegisterEmail);
        EditText contact2 = findViewById(R.id.contact);
//        EditText password = findViewById(R.id.etRegisterPassword);

        EditText etRegisterPassword = findViewById(R.id.etRegisterPassword);
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String email = etRegisterEmail.getText().toString();
        String password = etRegisterPassword.getText().toString();
        String contact = contact2.getText().toString();
//


        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }
        str34 = etRegisterPassword.getText().toString();
        editTextData = etFirstName.getText().toString();
        splitt = email.substring(0, email.indexOf("@"));

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            databaseReference = FirebaseDatabase.getInstance().getReference("/" + splitt);
//                            String name = intent4.getStringExtra("message4");
                            databaseReference.setValue("namaskaar");
                            savePrivately();
                            User user = new User(firstName, lastName, email,password,contact);
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    showMainActivity();
                                }
                            });
                        } else {
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void showMainActivity() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(RegisterActivity.this, ScanBarCodeActivity.class);
        intent.putExtra("message4", splitt);
        startActivity(intent);
        finish();

        // now by putExtra method put the value in key, value pair
        // key is message_key by this key we will receive the value, and put the string


        // start the Intent

    }

    private void switchToLogin() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void savePublicly() {
        // Requesting Permission to access External Storage
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                EXTERNAL_STORAGE_PERMISSION_CODE);
//        editText = findViewById(R.id.etFirstName);


        // getExternalStoragePublicDirectory() represents root of external storage, we are using DOWNLOADS
        // We can use following directories: MUSIC, PODCASTS, ALARMS, RINGTONES, NOTIFICATIONS, PICTURES, MOVIES
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        // Storing the data in file with name as geeksData.txt
        File file = new File(folder, "geeksData.txt");
        writeTextData(file, "this is me hello");
//        editText.setText("");
    }

    private void savePrivately() {
//        String editTextData = editText.getText().toString();

        // Creating folder with name GeekForGeeks
        File folder = getExternalFilesDir("GeeksForGeeks");

        // Creating file with name gfg.txt
        File file = new File(folder, "gfg.txt");
        writeTextData(file, editTextData);
//        editText.setText("");
    }

    private void writeTextData(File file, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes());
//            Toast.makeText(this, "Done" + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sendVerificationCode(String number) {
        // this method is used for getting
        // OTP on user phone number.

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(number)            // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallBack)           // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks

            // initializing our callbacks for on
            // verification callback method.
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        // below method is used when
        // OTP is sent from Firebase

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            // when we receive the OTP it
            // contains a unique id which
            // we are storing in our string

//            showdialog(number55);



            // which we have already created.
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            // below line is used for getting OTP code
            // which is sent in phone auth credentials.
            final String code = phoneAuthCredential.getSmsCode();
            number55 = phoneAuthCredential.getSmsCode();
            // checking if the code
            // is null or not.
            if (code != null) {
                // if the code is not null then
                // we are setting that code to
                // our OTP edittext field.

//                setting text setting text

//                edtOTP.setText(code);
//                txt.setText("hello");
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);
                final EditText txt_inputText = (EditText) mView.findViewById(R.id.txt_input);
                txt_inputText.setText(code);
//                Toast.makeText(RegisterActivity.this, code, Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(RegisterActivity.this,MainActivity5.class);
//                intent.putExtra("name",code);
//                startActivity(intent);
//                finish();

                // after setting this code
                // to OTP edittext field we
                // are calling our verifycode method.


//                verifying code

                verifyCode(code);
            }
        }

        // this method is called when firebase doesn't
        // sends our OTP code due to any error or issue.
        @Override
        public void onVerificationFailed(FirebaseException e) {
            // displaying error message with firebase exception.
            findViewById(R.id.loadingPanel).setVisibility(View.GONE);
//            Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };


    private void verifyCode(String code) {
        // below line is used for getting
        // credentials from our verification id and code.
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

        // after getting credential we are
        // calling sign in method.

        signInWithCredential(credential);

    }
    private void signInWithCredential(PhoneAuthCredential credential) {
        // inside this method we are checking if
        // the code entered is correct or not.
        mAuth2.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            // if the code is correct and the task is successful
                            // we are sending our user to new activity.

//                            Toast.makeText(RegisterActivity.this, "welcome", Toast.LENGTH_SHORT).show();

//                            showMainActivity();
//                            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
//                            startActivity(i);
//                            finish();

                        } else {
                            // if the code is not correct then we are
                            // displaying an error message to the user.
                            findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                            Toast.makeText(RegisterActivity.this, "please try again", Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }

    private void showdialog(String numberrr){
        FirebaseAuth.getInstance().signOut();
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        final AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);

        final EditText txt_inputText = (EditText) mView.findViewById(R.id.txt_input);
//        txt_inputText.setText(number55);
        Button btn_cancel = (Button) mView.findViewById(R.id.btn_cancel);
        Button btn_okay = (Button) mView.findViewById(R.id.btn_okay);
        alert.setView(mView);
        final AlertDialog alertDialog = alert.create();
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the OTP text field is empty or not.
                if (TextUtils.isEmpty(txt_inputText.getText().toString())) {
                    // if the OTP text field is empty display
                    // a message to user to enter OTP
                    Toast.makeText(RegisterActivity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                } else {
                    // if OTP field is not empty calling

//                     method to verify the OTP.

                    verifyCode((txt_inputText.getText().toString()));
//                    Toast.makeText(RegisterActivity.this, txt_inputText.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        alertDialog.setCanceledOnTouchOutside(false);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });
//        btn_okay.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
////                myCustomMessage.setText(txt_inputText.getText().toString());
//
//
//                alertDialog.dismiss();
//            }
//        });
        alertDialog.show();

    }


}







































