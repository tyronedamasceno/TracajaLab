package com.example.tyrone.tracajalab.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tyrone.tracajalab.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends Activity {

    TextView txt_welcome;
    FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        txt_welcome = findViewById(R.id.txt_welcome);
        txt_welcome.setText(String.format("Olá %s, seja bem vindo!", currentUser.getEmail()));
    }

    public void schedule(View view) {
    }

    public void receiveResults(View view) {
    }

    public void changeSchedule(View view) {
    }
}
