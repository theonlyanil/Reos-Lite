package com.cube26.iota.smartlite.Apps;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.o;
import android.widget.TimePicker;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class b extends o implements TimePickerDialog.OnTimeSetListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3007c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f3005a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3009e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3008d = 0;

    public interface a {
        void a(int i, int i2, int i3);
    }

    public b(int i, boolean z) {
        this.f3007c = true;
        this.f3006b = i;
        this.f3007c = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.o, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof a) {
            this.f3005a = (a) activity;
        }
    }

    @Override // android.support.v4.app.o
    public Dialog onCreateDialog(Bundle bundle) {
        Calendar calendar = Calendar.getInstance();
        if (!this.f3007c) {
            this.f3008d = calendar.get(11);
            this.f3009e = calendar.get(12);
        }
        return new TimePickerDialog(getActivity(), this, this.f3008d, this.f3009e, this.f3007c);
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        if (this.f3005a != null) {
            this.f3005a.a(this.f3006b, i, i2);
        }
    }
}
