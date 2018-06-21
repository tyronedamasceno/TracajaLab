package com.example.tyrone.tracajalab.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tyrone.tracajalab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends Activity {

    private EditText edt_login;
    private EditText edt_password;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_login = findViewById(R.id.edt_login_login);
        edt_password = findViewById(R.id.edt_password_login);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        }

    }

    public void forgot(View view) {
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    public void signup(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void entrar(View view) {
        String login = edt_login.getText().toString();
        String password = edt_password.getText().toString();

        mAuth.signInWithEmailAndPassword(login, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplication(), "Login com sucesso.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplication(), WelcomeActivity.class);
                        } else {
                            Toast.makeText(getApplication(), "Email e/ou senha incorreto.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
