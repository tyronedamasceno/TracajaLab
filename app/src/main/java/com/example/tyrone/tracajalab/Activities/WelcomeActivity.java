package com.example.tyrone.tracajalab.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tyrone.tracajalab.Dialogs.ExitDialog;
import com.example.tyrone.tracajalab.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends Activity implements ExitDialog.ExitListener{

    private TextView txt_welcome;
    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mAuth = FirebaseAuth.getInstance();

        currentUser = mAuth.getCurrentUser();

        txt_welcome = findViewById(R.id.txt_welcome);
        txt_welcome.setText(String.format("Olá %s, seja bem vindo!", currentUser.getEmail()));
    }

    public void schedule(View view) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }

    public void receiveResults(View view) {

    }

    public void changeSchedule(View view) {

    }

    @Override
    public void onBackPressed() {
        ExitDialog exitDialog = new ExitDialog();
        exitDialog.show(getFragmentManager(), "exitDialog");
    }

    @Override
    public void onExit() {
        mAuth.signOut();
        finish();
    }
}
