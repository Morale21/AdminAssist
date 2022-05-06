package com.example.adminassist;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    private Button btnRegSignUp;
    private EditText edEmail, edName, edSecName, edPhone, edOffice, edPassword, edConfirmPassword;
    private Spinner spinLocation;
    private FirebaseAuth userAuth;
    private String USER_KEY = "User";
    private DatabaseReference userDataBase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Initialization();
    }

    private void Initialization() {
        userAuth = FirebaseAuth.getInstance();
        userDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);

        edEmail = findViewById(R.id.edRegEmail);
        edName = findViewById(R.id.edRegName);
        edSecName = findViewById(R.id.edRegSecondName);
        edPhone = findViewById(R.id.edRegPhone);
        spinLocation = findViewById(R.id.spinRegLocation);
        edOffice = findViewById(R.id.edRegOffice);
        edPassword = findViewById(R.id.edRegPassword);
        edConfirmPassword = findViewById(R.id.edRegConfirmPassword);

        btnRegSignUp = findViewById(R.id.btnRegSignUp);

        btnRegSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((!enteredDataIsEmpty(edEmail)) && (!enteredDataIsEmpty(edName)) && (!enteredDataIsEmpty(edSecName)) && (!enteredDataIsEmpty(edPhone)) && (!enteredDataIsEmpty(edOffice)) && (!enteredDataIsEmpty(edPassword)) && (!enteredDataIsEmpty(edConfirmPassword))) {
                    if (edPassword.getText().toString().equals(edConfirmPassword.getText().toString())) {
                        addNewUser();
                        addUserData();
                    }
                    else showRegError();
                }
                else showRegError();
            }
        });
    }

    private void addNewUser(){
        userAuth.createUserWithEmailAndPassword(edEmail.getText().toString(), edPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Что-то пошло не так", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void addUserData(){
        String id = userDataBase.getKey();
        String email = edEmail.getText().toString();
        String name = edName.getText().toString();
        String sec_name = edSecName.getText().toString();
        String phone = edPhone.getText().toString();
        String location = "Городской совет";
        String office = edOffice.getText().toString();
        User newUser = new User(id, email, name, sec_name, phone, location, office);
        userDataBase.push().setValue(newUser);
    }

    private boolean enteredDataIsEmpty(EditText enteredData){
        if (TextUtils.isEmpty(enteredData.getText().toString())){
            return true;
        }
        else return false;
    }

    private void showRegError() {
        TextView txtError = findViewById(R.id.txtErrorReg);
        txtError.setText("Заполните пустые поля");
        if (!edPassword.getText().toString().equals(edConfirmPassword.getText().toString())) {
            txtError.setText("Пароли не совпадают");
        }
    }

}