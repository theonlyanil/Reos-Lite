package com.cube26.iota.smartlite.Apps;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.a.e;
import android.support.v7.a.f;
import android.text.Html;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import b.a.a.c;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.util.ColorCodeChangeListener;
import com.cube26.iota.smartlite.util.d;
import com.cube26.iota.smartlite.util.h;
import com.flurry.android.Constants;
import com.flurry.android.FlurryAgent;
import com.google.android.gms.location.places.Place;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class SetScheduleActivity extends f implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2956a;
    private static final String[] n = {"Fade in", "Fade out", "Strobe", "Candle Flicker", "Kaleidoscope"};
    private TextView A;
    private TextView B;
    private Switch C;
    private CheckBox D;
    private Spinner E;
    private EditText G;
    private ImageView H;
    private ImageView I;
    private ImageButton J;
    private LinearLayout K;
    private ProgressDialog M;
    private e N;
    private Handler O;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private EditText f2957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EditText f2958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2961f;
    private String g;
    private Button h;
    private long i;
    private int j;
    private int k;
    private String m;
    private int o;
    private com.cube26.iota.smartlite.a.a p;
    private int r;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    private final ToggleButton[] l = new ToggleButton[7];
    private int q = 0;
    private int s = 1;
    private String t = "";
    private String u = "";
    private String[] F = {"Alert never", "Before 5 mins", "Before"};
    private int L = 0;
    private int P = 0;

    private String a(int i, int i2) {
        String str;
        switch (f2956a) {
            case 1:
                this.t = i + ":" + i2;
                break;
            case 2:
                this.u = i + ":" + i2;
                break;
        }
        CLog.a("IOTA", "24 hour format :: onTime :: " + this.t + " :: offTime :: " + this.u);
        Date date = new Date();
        date.setHours(i);
        date.setMinutes(i2);
        this.i = date.getTime();
        String str2 = i == 12 ? "PM" : "AM";
        if (i > 12) {
            i -= 12;
            str = "PM";
        } else {
            str = str2;
        }
        String str3 = i < 10 ? "0" + i + ":" : "" + i + ":";
        return i2 < 10 ? str3 + "0" + i2 + " " + str : str3 + i2 + " " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, int i) {
        byte b2;
        this.P++;
        CLog.a("IOTA", " set schedule receive tag:: " + i);
        String strQ = h.v.get(i).q();
        if (i >= 0 && (b2 = bArr[4]) > 0 && b2 < 5) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < b2) {
                byte b3 = bArr[(i3 * 15) + 5];
                byte b4 = bArr[(i3 * 15) + 6];
                byte b5 = bArr[(i3 * 15) + 7];
                byte b6 = bArr[(i3 * 15) + 8];
                int i4 = bArr[(i3 * 15) + 9] + 2000;
                int i5 = bArr[(i3 * 15) + 10] - 1;
                byte b7 = bArr[(i3 * 15) + 11];
                byte b8 = bArr[(i3 * 15) + 12];
                byte b9 = bArr[(i3 * 15) + 13];
                CLog.a("IOTA", " year :: " + i4 + " month :: " + i5 + " day :: " + ((int) b7));
                Calendar calendar = Calendar.getInstance();
                calendar.set(1, i4);
                calendar.set(2, i5);
                calendar.set(5, b7);
                calendar.set(11, b8);
                calendar.set(12, b9);
                CLog.a("IOTA", " schedule Rule id :: " + ((int) b3));
                CLog.a("IOTA", " set time :: " + calendar.getTime());
                CLog.a("IOTA", " repeat str :: " + String.format("%8s", Integer.toBinaryString(b6 & Constants.UNKNOWN)).replace(' ', '0'));
                if (!this.p.b(b3, strQ)) {
                    this.s = this.p.f() + 1;
                    if (!this.x.equals("Alert never")) {
                        h.a(this, this.s, calendar.getTimeInMillis() - ((long) ((this.j * 60) * 1000)));
                    }
                    CLog.a("IOTA", " inserted schedule notification id :: " + this.s);
                    CLog.a("IOTA", " adding schedule if not present :: " + this.w + " :: set response rule id :: " + ((int) b3));
                    this.p.a(b3, strQ, this.v, String.valueOf(calendar.getTimeInMillis()), this.o, this.w, this.r, b4, this.x, this.j);
                }
                i2++;
                i3++;
            }
        }
        h.l = true;
        if (this.P == this.L) {
            this.P = 0;
            this.L = 0;
            if (this.M.isShowing()) {
                this.M.dismiss();
            }
            h.l = true;
            h.f3471e = false;
            finish();
        }
    }

    private void c(Intent intent) {
        int i;
        String str;
        j();
        this.f2959d = intent.getIntExtra("scheduleRuleId", -1);
        this.g = intent.getStringExtra("scheduleLiteAddress");
        this.f2961f = intent.getBooleanExtra("scheduleValid", false) ? 1 : 0;
        CLog.a("IOTA", "row _id :: " + this.f2959d);
        Cursor cursorC = this.p.c(this.f2959d, this.g);
        cursorC.moveToFirst();
        String string = cursorC.getString(cursorC.getColumnIndex("schedule_name"));
        String string2 = cursorC.getString(cursorC.getColumnIndex("schedule_time"));
        int i2 = cursorC.getInt(cursorC.getColumnIndex("schedule_color"));
        String string3 = cursorC.getString(cursorC.getColumnIndex("schedule_repeat"));
        int i3 = cursorC.getInt(cursorC.getColumnIndex("schedule_mode"));
        this.k = cursorC.getInt(cursorC.getColumnIndex(com.android.library.userprofile.util.Constants.SMS_COLUMN_ID));
        String string4 = cursorC.getString(cursorC.getColumnIndex("schedule_notification_type"));
        int i4 = cursorC.getInt(cursorC.getColumnIndex("schedule_notification_mins"));
        this.C.setChecked(i3 == 1);
        int i5 = 0;
        while (i5 < this.F.length) {
            if (this.F[i5].equals(string4)) {
                this.E.setSelection(i5);
                break;
            }
            i5++;
        }
        if (i5 == 2) {
            this.G.setVisibility(0);
            this.B.setVisibility(0);
            this.G.setText(String.valueOf(i4));
        }
        this.q = i2;
        this.f2957b.setText(string);
        this.f2957b.setSelection(this.f2957b.getText().length());
        this.H.setBackground(d.a(this.q, 0, 1));
        CLog.a("IOTA", "repeat :: " + string3);
        if (string3.charAt(7) == '1') {
            this.l[6].setChecked(true);
        } else {
            this.l[6].setChecked(false);
        }
        for (int i6 = 1; i6 < string3.length() - 1; i6++) {
            if (string3.charAt(i6) == '1') {
                this.l[6 - i6].setChecked(true);
            } else {
                this.l[6 - i6].setChecked(false);
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(string2));
        Date time = calendar.getTime();
        int hours = time.getHours();
        int minutes = time.getMinutes();
        String str2 = hours == 12 ? "PM" : "AM";
        if (hours > 12) {
            i = hours - 12;
            str = "PM";
        } else {
            i = hours;
            str = str2;
        }
        String str3 = i < 10 ? "0" + i + ":" : "" + i + ":";
        this.A.setText(minutes < 10 ? str3 + "0" + minutes + " " + str : str3 + minutes + " " + str);
        this.y = String.valueOf(i);
        this.z = String.valueOf(minutes);
        this.i = calendar.getTimeInMillis();
    }

    private void h() {
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z;
                if (!h.a(SetScheduleActivity.this.f2957b.getText().toString())) {
                    SetScheduleActivity.this.f2957b.setError("Schedule name is required!");
                    return;
                }
                if (SetScheduleActivity.this.E.getSelectedItemPosition() == 2 && !h.a(SetScheduleActivity.this.G.getText().toString())) {
                    SetScheduleActivity.this.G.setError("Notification interval is required!");
                    return;
                }
                ToggleButton[] toggleButtonArr = SetScheduleActivity.this.l;
                int length = toggleButtonArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else {
                        if (toggleButtonArr[i].isChecked()) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
                if (!z) {
                    Date time = Calendar.getInstance().getTime();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(SetScheduleActivity.this.i);
                    if (time.after(calendar.getTime())) {
                        Toast.makeText(SetScheduleActivity.this, "Selected time must be ahead of current time!.", 0).show();
                        return;
                    }
                }
                SetScheduleActivity.this.v = SetScheduleActivity.this.f2957b.getText().toString();
                SetScheduleActivity.this.r = SetScheduleActivity.this.C.isChecked() ? 1 : 0;
                SetScheduleActivity.this.o = SetScheduleActivity.this.q;
                ArrayList arrayList = new ArrayList();
                for (ToggleButton toggleButton : SetScheduleActivity.this.l) {
                    if (toggleButton.isChecked()) {
                        arrayList.add(toggleButton.getText().toString());
                    }
                }
                SetScheduleActivity.this.w = h.a((ArrayList<String>) arrayList);
                SetScheduleActivity.this.x = (String) SetScheduleActivity.this.E.getSelectedItem();
                try {
                    SetScheduleActivity.this.j = Integer.parseInt(SetScheduleActivity.this.f2958c.getText().toString());
                    FlurryAgent.logEvent("local_notification_added");
                    if (SetScheduleActivity.this.E.getSelectedItemPosition() == 2) {
                        SetScheduleActivity.this.j = Integer.parseInt(SetScheduleActivity.this.f2958c.getText().toString());
                    } else if (SetScheduleActivity.this.E.getSelectedItemPosition() == 1) {
                        SetScheduleActivity.this.j = 5;
                    }
                    CLog.a("IOTA", "saving :: name :: " + SetScheduleActivity.this.v + " :: time :: " + SetScheduleActivity.this.y + " :: " + SetScheduleActivity.this.z + ":: color :: " + SetScheduleActivity.this.o + " :: repeat :: " + SetScheduleActivity.this.w + " :: schedule_lite_state :: " + SetScheduleActivity.this.r + " :: schedule_notification_type :: " + SetScheduleActivity.this.x + " :: schedule_notification_mins :: " + SetScheduleActivity.this.j + " :: schedule_notification_id :: 1");
                    SetScheduleActivity.this.f2960e = SetScheduleActivity.this.C.isChecked() ? 1 : 0;
                    if (SetScheduleActivity.this.m.equals("new")) {
                        SetScheduleActivity.this.g();
                        return;
                    }
                    h.a(h.b(SetScheduleActivity.this.g, h.v), SetScheduleActivity.this.f2959d, SetScheduleActivity.this.f2961f, SetScheduleActivity.this.r, Color.red(SetScheduleActivity.this.o), Color.green(SetScheduleActivity.this.o), Color.blue(SetScheduleActivity.this.o), 0, Byte.parseByte(SetScheduleActivity.this.y), Byte.parseByte(SetScheduleActivity.this.z), (byte) Integer.parseInt(SetScheduleActivity.this.w, 2));
                    CLog.a("IOTA", " updating schedule");
                    if (SetScheduleActivity.this.E.getSelectedItemPosition() != 0) {
                        long jB = h.b(SetScheduleActivity.this.w, Integer.parseInt(SetScheduleActivity.this.y), Integer.parseInt(SetScheduleActivity.this.z), SetScheduleActivity.this.j);
                        CLog.a("IOTA", " next set time :: " + jB);
                        h.a(SetScheduleActivity.this, SetScheduleActivity.this.k, jB - ((long) ((SetScheduleActivity.this.j * 60) * 1000)));
                    }
                    SetScheduleActivity.this.p.b(SetScheduleActivity.this.f2959d, SetScheduleActivity.this.g, SetScheduleActivity.this.v, String.valueOf(SetScheduleActivity.this.i), SetScheduleActivity.this.o, SetScheduleActivity.this.w, SetScheduleActivity.this.f2960e, SetScheduleActivity.this.f2961f, SetScheduleActivity.this.x, SetScheduleActivity.this.j);
                    h.l = true;
                    FlurryAgent.logEvent("schedule_set");
                    SetScheduleActivity.this.finish();
                } catch (Exception e2) {
                    SetScheduleActivity.this.G.setError("Invalid interval");
                }
            }
        });
        this.G.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2)});
        this.D.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                for (int i = 0; i < 7; i++) {
                    SetScheduleActivity.this.l[i].setChecked(z);
                }
                FlurryAgent.logEvent("repeat_interval_selected");
            }
        });
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetScheduleActivity.f2956a = 1;
                new b(SetScheduleActivity.f2956a, false).show(SetScheduleActivity.this.getSupportFragmentManager(), "timePicker");
            }
        });
        this.E.setAdapter((SpinnerAdapter) new ArrayAdapter(getApplicationContext(), R.layout.spinner_item, this.F));
        this.E.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.7
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 2) {
                    SetScheduleActivity.this.G.setVisibility(0);
                    SetScheduleActivity.this.B.setVisibility(0);
                } else {
                    SetScheduleActivity.this.G.setVisibility(4);
                    SetScheduleActivity.this.B.setVisibility(4);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SetScheduleActivity.this.K.setVisibility(0);
                } else {
                    SetScheduleActivity.this.K.setVisibility(8);
                }
            }
        });
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View viewInflate = LayoutInflater.from(SetScheduleActivity.this).inflate(R.layout.custom_dialog, (ViewGroup) null);
                e.a aVar = new e.a(SetScheduleActivity.this);
                aVar.b(viewInflate);
                final e eVarB = aVar.b();
                TextView textView = (TextView) viewInflate.findViewById(R.id.cancel_pick_color);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.confirm_pick_color);
                SetScheduleActivity.this.I = (ImageView) viewInflate.findViewById(R.id.preview_color);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.9.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.9.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                        SetScheduleActivity.this.H.setBackground(d.a(SetScheduleActivity.this.q, 0, 1));
                    }
                });
                eVarB.show();
            }
        });
    }

    private void i() {
        this.f2957b = (EditText) findViewById(R.id.scheduleName);
        this.A = (TextView) findViewById(R.id.scheduleTime);
        this.C = (Switch) findViewById(R.id.scheduleLiteState);
        this.D = (CheckBox) findViewById(R.id.scheduleEverydayCheck);
        this.E = (Spinner) findViewById(R.id.scheduleAlertSettings);
        this.G = (EditText) findViewById(R.id.scheduleAlertSettingsInterval);
        this.B = (TextView) findViewById(R.id.scheduleAlertSettingsIntervalText);
        this.H = (ImageView) findViewById(R.id.schedulePreviewColor);
        this.J = (ImageButton) findViewById(R.id.scheduleColorPicker);
        this.K = (LinearLayout) findViewById(R.id.scheduleColorPickerLayout);
        this.f2958c = (EditText) findViewById(R.id.scheduleAlertSettingsInterval);
        this.h = (Button) findViewById(R.id.scheduleSave);
        this.l[0] = (ToggleButton) findViewById(R.id.scheduleMon);
        this.l[1] = (ToggleButton) findViewById(R.id.scheduleTue);
        this.l[2] = (ToggleButton) findViewById(R.id.scheduleWed);
        this.l[3] = (ToggleButton) findViewById(R.id.scheduleThu);
        this.l[4] = (ToggleButton) findViewById(R.id.scheduleFri);
        this.l[5] = (ToggleButton) findViewById(R.id.scheduleSat);
        this.l[6] = (ToggleButton) findViewById(R.id.scheduleSun);
        this.f2957b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
    }

    private void j() {
        Calendar calendar = Calendar.getInstance();
        this.A.setText(a(calendar.get(11), calendar.get(12)));
        this.y = String.valueOf(calendar.get(11));
        this.z = String.valueOf(calendar.get(12));
        if (this.C.isChecked()) {
            this.K.setVisibility(0);
        } else {
            this.K.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.M = ProgressDialog.show(this, "Please wait ...", "Saving schedule ...", true);
        this.M.setCancelable(false);
        new Timer().schedule(new TimerTask() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SetScheduleActivity.this.runOnUiThread(new Runnable() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SetScheduleActivity.this.M == null || !SetScheduleActivity.this.M.isShowing()) {
                            return;
                        }
                        SetScheduleActivity.this.M.dismiss();
                        SetScheduleActivity.this.finish();
                        CLog.a("IOTA", " timer expire :: inflateLiteConfigurationLayout");
                    }
                });
            }
        }, 3000L);
    }

    private void l() {
        this.O = new Handler() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case Place.TYPE_SUBPREMISE /* 1028 */:
                        SetScheduleActivity.this.a(message.getData().getByteArray("EXTRA_DATA"), message.arg1);
                        break;
                }
            }
        };
        h.f3468b = this.O;
    }

    @Override // com.cube26.iota.smartlite.Apps.b.a
    public void a(int i, int i2, int i3) {
        this.y = String.valueOf(i2);
        this.z = String.valueOf(i3);
        String strA = a(i2, i3);
        switch (i) {
            case 1:
                this.A.setText(strA);
                break;
        }
    }

    public void g() {
        ArrayList<String> arrayListD = this.p.d();
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_lite_selection_dialog, (ViewGroup) null);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.lite_configuration_layout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.confirm_pick_lite);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.cancel_pick_lite);
        e.a aVar = new e.a(this);
        aVar.b(linearLayout);
        this.N = aVar.b();
        this.N.setCancelable(false);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (arrayList2.size() == 0) {
                    Toast.makeText(SetScheduleActivity.this, "Pick lites to set scheduler.", 0).show();
                    return;
                }
                for (int i = 0; i < arrayList2.size(); i++) {
                    CLog.a("IOTA", "schedule repeat :: " + SetScheduleActivity.this.w + " parsed byte :: " + ((int) ((byte) Integer.parseInt(SetScheduleActivity.this.w, 2))));
                    h.a(((Integer) arrayList2.get(i)).intValue(), SetScheduleActivity.this.f2960e, Color.red(SetScheduleActivity.this.o), Color.green(SetScheduleActivity.this.o), Color.blue(SetScheduleActivity.this.o), 0, Byte.parseByte(SetScheduleActivity.this.z), Byte.parseByte(SetScheduleActivity.this.y), (byte) Integer.parseInt(SetScheduleActivity.this.w, 2));
                }
                SetScheduleActivity.this.L = arrayList2.size();
                SetScheduleActivity.this.N.dismiss();
                h.f3471e = true;
                SetScheduleActivity.this.k();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetScheduleActivity.this.N.dismiss();
            }
        });
        CLog.a("IOTA", " savedlitelist size :: " + arrayListD.size());
        for (int i = 0; i < arrayListD.size(); i++) {
            String str = arrayListD.get(i);
            String strB = this.p.b(str);
            com.cube26.iota.smartlite.d.a aVar2 = new com.cube26.iota.smartlite.d.a();
            aVar2.d(strB);
            aVar2.e(str);
            CLog.a("IOTA", "lite address :: " + str + "  schedule count :: " + this.p.d(str));
            if (h.v.contains(aVar2) && h.v.get(h.v.indexOf(aVar2)).t() && this.p.d(str) < 4) {
                arrayList.add(strB);
                LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_lite_check_layout, (ViewGroup) null);
                CheckBox checkBox = (CheckBox) linearLayout3.findViewById(R.id.check_lite_name);
                int iB = h.b(str, h.v);
                checkBox.setTag(Integer.valueOf(iB));
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.12
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            arrayList2.add(new Integer(((Integer) compoundButton.getTag()).intValue()));
                        } else {
                            arrayList2.remove(new Integer(((Integer) compoundButton.getTag()).intValue()));
                        }
                    }
                });
                final ImageView imageView = (ImageView) linearLayout3.findViewById(R.id.lite_flash_effect);
                imageView.setTag(Integer.valueOf(iB));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.Apps.SetScheduleActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CLog.a("IOTA", " lite port :: " + ((Integer) imageView.getTag()).intValue());
                        h.a(0, 0, 0, 0, ((Integer) imageView.getTag()).intValue(), "Phone", "Flash Alert");
                    }
                });
                checkBox.setText(strB);
                linearLayout2.addView(linearLayout3);
            }
        }
        if (arrayList.size() > 0) {
            this.N.show();
        } else {
            Toast.makeText(this, "Can't set more than 4 schedules in a lite.", 0).show();
        }
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.schedule_creation);
        i();
        l();
        this.p = new com.cube26.iota.smartlite.a.a(this);
        c.a().a(this);
        c().c(true);
        c().a(true);
        c().b(true);
        Intent intent = getIntent();
        this.m = intent.getStringExtra("mode");
        h();
        if (this.m.equals("edit")) {
            c().a(Html.fromHtml("<font color='#596475'>Update schedule</font>"));
            c(intent);
        } else {
            c().a(Html.fromHtml("<font color='#596475'>New scheduler</font>"));
            j();
        }
    }

    public void onEvent(ColorCodeChangeListener colorCodeChangeListener) {
        int i;
        int i2;
        int i3 = 255;
        this.q = colorCodeChangeListener.f3421a;
        CLog.a("IOTA", " touched color :: " + this.q);
        int iRed = Color.red(this.q);
        int iGreen = Color.green(this.q);
        int iBlue = Color.blue(this.q);
        if (iRed < 235 || iGreen < 235 || iBlue < 235) {
            i3 = iBlue;
            i = iGreen;
            i2 = iRed;
        } else {
            this.q = Color.rgb(255, 255, 255);
            CLog.a("IOTA", " white color :: " + this.q);
            i = 255;
            i2 = 255;
        }
        CLog.a("IOTA", "Dialog " + ("R: " + i2 + " B: " + i3 + " G: " + i));
        if (this.I != null) {
            this.I.setBackground(d.a(colorCodeChangeListener.f3421a, 0, 1));
        }
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.app.Activity
    protected void onStop() {
        super.onStop();
    }
}
