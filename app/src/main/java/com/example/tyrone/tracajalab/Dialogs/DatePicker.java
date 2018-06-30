package com.example.tyrone.tracajalab.Dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private DateSetListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof DateSetListener)) {
            throw new RuntimeException("Não é DateSetListener");
        }
        listener = (DateSetListener) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), this, 2018, 6, 1 );
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
        if (listener != null) {
            listener.onDateSet(year, month, dayOfMonth);
        }
    }

    public interface DateSetListener {
        public void onDateSet(int year, int month, int dayOfMonth);
    }
}
