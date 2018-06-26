package com.example.tyrone.tracajalab.Fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tyrone.tracajalab.Domain.Exame;
import com.example.tyrone.tracajalab.Domain.TipoExame;

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
        String[] nomes = {"Hemograma", "Colesterol", "Glicose"};
        String[] descricao = {"Fazer em jejum", "Fazem sem jejum", "Fazer com ou sem jejum"};

        for (int i = 0; i < nomes.length; i++) {
            Exame exame = new Exame(nomes[i], descricao[i]);
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
