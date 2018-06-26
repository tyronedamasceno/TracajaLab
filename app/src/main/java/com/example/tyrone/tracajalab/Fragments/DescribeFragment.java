package com.example.tyrone.tracajalab.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tyrone.tracajalab.Domain.Exame;
import com.example.tyrone.tracajalab.R;

public class DescribeFragment extends Fragment {

    private TextView txt_title;
    private TextView txt_describe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_describe, container, false);
        txt_title = view.findViewById(R.id.txt_title_frag_desc);
        txt_describe = view.findViewById(R.id.txt_describe_frag_desc);
        return view;
    }

    public void changeExame(Exame exame) {
        txt_title.setText(exame.getNome());
        txt_describe.setText(exame.getDescricao());
    }
}
