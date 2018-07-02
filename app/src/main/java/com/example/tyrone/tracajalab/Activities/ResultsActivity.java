package com.example.tyrone.tracajalab.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tyrone.tracajalab.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultsActivity extends Activity {


    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    private DatabaseReference pacientReference;

    private LinearLayout resultsLayout;
    private CheckBox checkBox;
    private TextView txtMsg;

    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        resultsLayout = findViewById(R.id.linear_layout_results);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        pacientReference = database.getReference("pacientes");
        txtMsg = resultsLayout.findViewById(R.id.txt_msg_results);
        cleanLayout();
        seedLayout();
    }

    public void downloadResults(View view) {
        // TO-DO

        Toast.makeText(this, "Por enquanto não é possível fazer download dos resultados", Toast.LENGTH_LONG).show();
    }

    View.OnClickListener getOnClickDoSomething(final Button button) {
        return new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), button.getText().toString(), Toast.LENGTH_SHORT).show();
                Log.i("OnClick", button.getText().toString());
            }
        };
    }

    public void cleanLayout() {
        resultsLayout.removeAllViews();
    }

    public void seedLayout() {
        pacientReference.child(currentUser.getUid()).child("exames").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue() != null) {
                            Map<String, Object> exams = (Map<String, Object>) dataSnapshot.getValue();
                            list = new ArrayList<>();
                            for (Map.Entry<String, Object> entry : exams.entrySet()) {
                                list.add(entry.getKey());
                            };
                            for (int i = 0; i < list.size(); i++) {
                                checkBox = new CheckBox(getApplicationContext());
                                checkBox.setId(i);
                                checkBox.setText(list.get(i));
                                checkBox.setOnClickListener(getOnClickDoSomething(checkBox));
                                resultsLayout.addView(checkBox);
                            }
                        } else {

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }
        );

    }


}
