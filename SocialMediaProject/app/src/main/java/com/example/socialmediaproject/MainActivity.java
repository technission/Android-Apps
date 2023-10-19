package com.example.socialmediaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private EditText signUpUsername, signUpEmail, signUpPassword;
    private TextView alreadySignUp;
    private Button signUpButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUpUsername = findViewById(R.id.signUpUsername);
        signUpEmail = findViewById(R.id.signUpEmail);
        signUpPassword = findViewById(R.id.signUpPassword);
        alreadySignUp = findViewById(R.id.alreadySignUp);
        signUpButton = findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (signUpUsername.getText().toString().isEmpty() || signUpEmail.getText().toString().isEmpty() || signUpPassword.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill out all fields.", Toast.LENGTH_SHORT).show();
                }else{
                    initiateSignUp();
                }
            }
        });


        alreadySignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });
    }
    private void initiateSignUp() {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(signUpEmail.getText().toString(), signUpPassword.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseDatabase.getInstance().getReference("user/"+FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(new User(signUpEmail.getText().toString(), signUpUsername.getText().toString(), signUpPassword.getText().toString()))
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                                            if(task.isSuccessful()) {

                                            }else {
                                                Toast.makeText(MainActivity.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                    });
                            startActivity(new Intent(MainActivity.this, MediaPage.class));
                            Toast.makeText(MainActivity.this, "Signed Up Succesfully", Toast.LENGTH_SHORT).show();
                            finish();

                        } else {
                            Toast.makeText(MainActivity.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}