package com.example.tyrone.tracajalab.Firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseManipulator {

    FirebaseDatabase database;
    DatabaseReference pacientsReference;
    DatabaseReference examsReference;

    private DatabaseManipulator() {
        database = FirebaseDatabase.getInstance();
        pacientsReference = database.getReference("pacientes");
        examsReference = database.getReference("exames");
    }

    private DatabaseManipulator instance;

    public DatabaseManipulator getInstance() {
        if (instance == null) {
            instance = new DatabaseManipulator();
        }
        return instance;
    }


}
