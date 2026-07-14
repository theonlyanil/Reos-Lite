package com.cube26.iota.smartlite.util;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.o;
import android.widget.DatePicker;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class c extends o implements DatePickerDialog.OnDateSetListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f3459a = null;

    public interface a {
        void a(int i, int i2, int i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.o, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof a) {
            this.f3459a = (a) activity;
        }
    }

    @Override // android.support.v4.app.o
    public Dialog onCreateDialog(Bundle bundle) {
        Calendar calendar = Calendar.getInstance();
        return new DatePickerDialog(getActivity(), this, calendar.get(1), calendar.get(2), calendar.get(5));
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.f3459a.a(i3, i2, i);
    }
}
