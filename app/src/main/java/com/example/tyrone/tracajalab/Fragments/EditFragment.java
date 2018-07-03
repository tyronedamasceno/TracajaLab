package com.example.tyrone.tracajalab.Fragments;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tyrone.tracajalab.Domain.Exame;
import com.example.tyrone.tracajalab.Domain.MyDate;
import com.example.tyrone.tracajalab.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class EditFragment extends ListFragment{

    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    private DatabaseReference pacientReference;

    private ArrayAdapter<Exame> adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        pacientReference = database.getReference("pacientes");

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);

        seedList();
    }

    public void seedList() {
        pacientReference.child(currentUser.getUid()).child("exames").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue() != null) {
                            Map<String, Object> exams = (Map<String, Object>) dataSnapshot.getValue();

                            for (Map.Entry<String, Object> entry : exams.entrySet()) {
                                Map singleExam = (Map) entry.getValue();
                                Map singleDate = (Map) singleExam.get("data");

                                MyDate date = new MyDate(
                                        ((Long)singleDate.get("year")).intValue(),
                                        ((Long)singleDate.get("month")).intValue(),
                                        ((Long)singleDate.get("dayOfMonth")).intValue());

                                Exame exame = new Exame((String)singleExam.get("nome"), date);
                                adapter.add(exame);
                            }
                            setListAdapter(adapter);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }
        );
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getContext(), "Ainda não é possível alterar datas de exame", Toast.LENGTH_LONG).show();
    }
}
