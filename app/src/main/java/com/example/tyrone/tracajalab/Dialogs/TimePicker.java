package com.example.tyrone.tracajalab.Dialogs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

import java.util.Calendar;

public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private TimeSetListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof TimeSetListener)) {
            throw new RuntimeException("Não é TimeSetListner");
        }
        listener = (TimeSetListener) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        return new TimePickerDialog(getActivity(), this, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true);
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        if (listener != null) {
            listener.onTimeSet(hourOfDay, minute);
        }
    }

    public interface TimeSetListener {
        public void onTimeSet(int hourOfDay, int minute);
    }
}
