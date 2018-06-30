package com.example.tyrone.tracajalab.Fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tyrone.tracajalab.Domain.Exame;
import com.example.tyrone.tracajalab.R;

public class ExamesFragment extends ListFragment {

    private ArrayAdapter<Exame> adapter;

    private OnItemClick listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof  OnItemClick)) {
            throw new RuntimeException("Não implementa a interface OnItemClick");
        }
        listener = (OnItemClick) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);
        String[] exames = getActivity().getResources().getStringArray(R.array.exames);
        String[] orientacoes = getActivity().getResources().getStringArray(R.array.orientacoes);
        String[] jejum = getActivity().getResources().getStringArray(R.array.jejum);

        for (int i = 0; i < exames.length; i++) {
            Exame exame = new Exame(exames[i], orientacoes[i], jejum[i]);
            adapter.add(exame);
        }
        setListAdapter(adapter);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Exame exame = adapter.getItem(position);
        if (listener != null) {
            listener.onClickExame(exame);
        }
    }

    public interface OnItemClick {
        public void onClickExame (Exame exame);
    }

}
