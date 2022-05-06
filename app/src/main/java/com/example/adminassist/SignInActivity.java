package com.example.adminassist;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private Button btnLogSignIn;
    private EditText edEmail, edPassword;
    private FirebaseAuth userAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Initialization();
    }

    private void Initialization(){
        userAuth = FirebaseAuth.getInstance();
        edEmail = findViewById(R.id.edLogEmail);
        edPassword = findViewById(R.id.edLogPassword);
        btnLogSignIn = findViewById(R.id.btnLogSignIn);
    }

    public void onClickSignIn(View view) {
        if (!TextUtils.isEmpty(edEmail.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString())) {
            userAuth.signInWithEmailAndPassword(edEmail.getText().toString(), edPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Intent i = new Intent(SignInActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"SignIn failed", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}