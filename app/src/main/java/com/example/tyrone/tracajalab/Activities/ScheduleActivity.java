package com.example.tyrone.tracajalab.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tyrone.tracajalab.Dialogs.TimePicker;
import com.example.tyrone.tracajalab.Domain.Exame;
import com.example.tyrone.tracajalab.Fragments.DescribeFragment;
import com.example.tyrone.tracajalab.Fragments.ExamesFragment;
import com.example.tyrone.tracajalab.Dialogs.DatePicker;
import com.example.tyrone.tracajalab.R;

public class ScheduleActivity extends Activity
        implements ExamesFragment.OnItemClick, DatePicker.DateSetListener, TimePicker.TimeSetListener {

    private DescribeFragment describeFragment;

    private int year;
    private int month;
    private int dayOfMonth;
    private int hourOfDay;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        describeFragment = (DescribeFragment) getFragmentManager().findFragmentById(R.id.frag_describe);
    }

    @Override
    public void onClickExame(Exame exame) {
        describeFragment.changeExame(exame);
    }

    public void scheduleExam(View view) {
        DatePicker datePicker = new DatePicker();
        datePicker.show(getFragmentManager(), "datePicker");

    }

    @Override
    public void onDateSet(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;

        TimePicker timePicker = new TimePicker();
        timePicker.show(getFragmentManager(), "timePicker");
    }

    @Override
    public void onTimeSet(int hourOfDay, int minute) {
        this.hourOfDay = hourOfDay;
        this.minute = minute;

        Toast.makeText(this, String.format("Exame agendado em %d/%d/%d as %d:%d",
                dayOfMonth, month, year, hourOfDay, minute), Toast.LENGTH_LONG).show();
    }
}
