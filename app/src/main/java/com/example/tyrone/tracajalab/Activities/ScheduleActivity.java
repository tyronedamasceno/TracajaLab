package com.example.tyrone.tracajalab.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.tyrone.tracajalab.Domain.Exame;
import com.example.tyrone.tracajalab.Fragments.DescribeFragment;
import com.example.tyrone.tracajalab.Fragments.ExamesFragment;
import com.example.tyrone.tracajalab.R;

public class ScheduleActivity extends Activity implements ExamesFragment.OnItemClick {

    private DescribeFragment describeFragment;

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

    }
}
