package com.example.tyrone.tracajalab.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tyrone.tracajalab.Dialogs.ExitDialog;
import com.example.tyrone.tracajalab.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WelcomeActivity extends Activity implements ExitDialog.ExitListener{

    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    private DatabaseReference pacientReference;

    private TextView txt_welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();

        pacientReference = database.getReference("pacientes");
        pacientReference.child("Foo").setValue("Bar");
        txt_welcome = findViewById(R.id.txt_welcome);
        txt_welcome.setText(String.format("Olá %s, seja bem vindo!", currentUser.getEmail()));

        addUser();
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

    public void addUser() {
        pacientReference.child(currentUser.getUid()).child("email").setValue(currentUser.getEmail());
    }

}
