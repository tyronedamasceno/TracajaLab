package com.example.tyrone.tracajalab.Activities;

import android.app.Activity;
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

public class SignUpActivity extends Activity {

    private EditText edt_email_signup;
    private EditText edt_password_signup;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edt_email_signup = findViewById(R.id.edt_email_signup);
        edt_password_signup = findViewById(R.id.edt_password_signup);

        mAuth = FirebaseAuth.getInstance();
    }

    public void cadastrar(View view) {
        String email = edt_email_signup.getText().toString();
        String password = edt_password_signup.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser currentUser = mAuth.getCurrentUser();
                            if (currentUser != null) {
                                Toast.makeText(getApplication(), "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplication(), "Falha na criação do usuário", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
}
