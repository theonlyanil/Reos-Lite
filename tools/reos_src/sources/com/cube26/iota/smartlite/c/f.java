package com.cube26.iota.smartlite.c;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.Apps.SetScheduleActivity;
import com.cube26.iota.smartlite.Apps.SetTimerActivity;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.b.g;
import com.cube26.iota.smartlite.util.h;
import com.flurry.android.Constants;
import com.flurry.android.FlurryAgent;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.location.places.Place;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class f extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.cube26.iota.smartlite.Apps.a f3353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.cube26.iota.smartlite.a.a f3354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Cursor f3355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FloatingActionButton f3356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FloatingActionButton f3357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ProgressDialog f3358f;
    private ArrayList<g> h;
    private CoordinatorLayout i;
    private TextView j;
    private Handler k;
    private int g = 0;
    private int l = 0;
    private int m = 0;

    private void a() {
        h.f3472f = true;
        this.h.clear();
        this.f3353a.notifyDataSetChanged();
        CLog.a("IOTA", "fetchSchedulesInSavedLites");
        b();
        for (String str : this.f3354b.d()) {
            int iB = h.b(str, h.v);
            if (h.a(str, h.v) && h.v.get(iB).s() == 2) {
                h.a(iB, (byte) 0);
                this.g++;
            }
        }
        if (this.g == 0) {
            this.f3358f.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, int i) {
        this.l++;
        String strQ = h.v.get(i).q();
        String strB = this.f3354b.b(strQ);
        if (i >= 0) {
            byte b2 = bArr[4];
            CLog.a("IOTA", " address :: " + strQ + " ruleamount :: " + ((int) b2) + " data size :: " + bArr.length);
            if (b2 > 0 && b2 < 5) {
                com.cube26.iota.smartlite.b.f fVar = new com.cube26.iota.smartlite.b.f(strB, strQ);
                if (!this.h.contains(fVar)) {
                    this.h.add(fVar);
                }
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    int i5 = i2;
                    if (i4 >= b2) {
                        break;
                    }
                    byte b3 = bArr[(i5 * 15) + 5];
                    byte b4 = bArr[(i5 * 15) + 6];
                    byte b5 = bArr[(i5 * 15) + 7];
                    byte b6 = bArr[(i5 * 15) + 8];
                    int i6 = bArr[(i5 * 15) + 9] + 2000;
                    byte b7 = bArr[(i5 * 15) + 10];
                    byte b8 = bArr[(i5 * 15) + 11];
                    byte b9 = bArr[(i5 * 15) + 12];
                    byte b10 = bArr[(i5 * 15) + 13];
                    byte b11 = bArr[(i5 * 15) + 16];
                    byte b12 = bArr[(i5 * 15) + 17];
                    byte b13 = bArr[(i5 * 15) + 18];
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(1, i6);
                    calendar.set(2, b7 - 1);
                    calendar.set(5, b8);
                    calendar.set(11, b9);
                    calendar.set(12, b10);
                    String strReplace = String.format("%8s", Integer.toBinaryString(b6 & Constants.UNKNOWN)).replace(' ', '0');
                    CLog.a("IOTA", " repeat str :: " + strReplace);
                    CLog.a("IOTA", " scheduleRuleid :: " + ((int) b3));
                    CLog.a("IOTA", " received time :: " + calendar.getTime());
                    Cursor cursorC = this.f3354b.c(b3, strQ);
                    CLog.a("IOTA", " cursor count :: " + cursorC.getCount());
                    if (cursorC.getCount() > 0) {
                        cursorC.moveToFirst();
                        CLog.a("IOTA", " fetched schedule already in db with rowid :: " + cursorC.getString(cursorC.getColumnIndex(com.android.library.userprofile.util.Constants.SMS_COLUMN_ID)));
                        String string = cursorC.getString(cursorC.getColumnIndex("schedule_name"));
                        cursorC.getString(cursorC.getColumnIndex("schedule_repeat"));
                        int i7 = cursorC.getInt(cursorC.getColumnIndex("schedule_notification_mins"));
                        String string2 = cursorC.getString(cursorC.getColumnIndex("schedule_notification_type"));
                        int i8 = cursorC.getInt(cursorC.getColumnIndex(com.android.library.userprofile.util.Constants.SMS_COLUMN_ID));
                        this.f3354b.b(b3, strQ, string, String.valueOf(calendar.getTimeInMillis()), Color.rgb((int) b11, (int) b12, (int) b13), strReplace, b5, b4, string2, i7);
                        CLog.a("IOTA", " address :: " + strQ + " name :: " + strB + " mode :: " + ((int) b5) + " repeat :: " + strReplace + " :: color :: " + Color.rgb((int) b11, (int) b12, (int) b13));
                        com.cube26.iota.smartlite.b.e eVar = new com.cube26.iota.smartlite.b.e(i8, b3, string, calendar.getTime(), strReplace, b5, b4, Color.rgb((int) b11, (int) b12, (int) b13), strQ, i7);
                        if (!this.h.contains(eVar)) {
                            this.h.add(eVar);
                        }
                    } else {
                        CLog.a("IOTA", " adding fetched schedule to db");
                        StringBuilder sbAppend = new StringBuilder().append("Schedule ");
                        int i9 = this.m + 1;
                        this.m = i9;
                        String string3 = sbAppend.append(i9).toString();
                        CLog.a("IOTA", " unSavedScheduleTime :: " + calendar.getTime() + " :: " + String.valueOf(calendar.getTimeInMillis()));
                        com.cube26.iota.smartlite.b.e eVar2 = new com.cube26.iota.smartlite.b.e(this.f3354b.f() + 1, b3, string3, calendar.getTime(), strReplace, b5, b4, Color.rgb((int) b11, (int) b12, (int) b13), strQ, 0);
                        if (!this.h.contains(eVar2)) {
                            this.h.add(eVar2);
                        }
                        this.f3354b.a(b3, strQ, string3, String.valueOf(calendar.getTimeInMillis()), Color.rgb((int) b11, (int) b12, (int) b13), strReplace, b5, b4, "Alert never", 0);
                        CLog.a("IOTA", " adding fetched schedule to db");
                    }
                    this.f3353a.notifyDataSetChanged();
                    i2 = i5 + 1;
                    i3 = i4 + 1;
                }
            }
        }
        if (this.l == this.g) {
            this.m = 0;
            this.l = 0;
            this.g = 0;
            if (this.f3358f.isShowing()) {
                this.f3358f.dismiss();
            }
            h.f3472f = false;
        }
        CLog.a("IOTA", " items size :: " + this.h.size());
        if (this.h.size() == 0) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    private void b() {
        this.f3358f = ProgressDialog.show(getActivity(), "Please wait ...", "Fetching schedules ...", true);
        this.f3358f.setCancelable(true);
        new Timer().schedule(new TimerTask() { // from class: com.cube26.iota.smartlite.c.f.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                f.this.getActivity().runOnUiThread(new Runnable() { // from class: com.cube26.iota.smartlite.c.f.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (f.this.f3358f == null || !f.this.f3358f.isShowing()) {
                            return;
                        }
                        f.this.f3358f.dismiss();
                        CLog.a("IOTA", " timer expire :: inflateLiteConfigurationLayout");
                    }
                });
            }
        }, 3000L);
    }

    private void c() {
        this.k = new Handler() { // from class: com.cube26.iota.smartlite.c.f.6
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case Place.TYPE_SYNTHETIC_GEOCODE /* 1029 */:
                        f.this.a(message.getData().getByteArray("EXTRA_DATA"), message.arg1);
                        break;
                }
            }
        };
        h.f3469c = this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        if (h.v.size() == 0) {
            Toast.makeText(getActivity(), "Select lites from saved lites", 0).show();
            return false;
        }
        ArrayList<String> arrayListD = this.f3354b.d();
        boolean z = false;
        for (int i = 0; i < arrayListD.size(); i++) {
            String str = arrayListD.get(i);
            String strB = this.f3354b.b(str);
            com.cube26.iota.smartlite.d.a aVar = new com.cube26.iota.smartlite.d.a();
            aVar.d(strB);
            aVar.e(str);
            if (h.v.contains(aVar)) {
                z = true;
            }
        }
        if (z) {
            return true;
        }
        Toast.makeText(getActivity(), "Select lites from saved lites", 0).show();
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = new ArrayList<>();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_five, viewGroup, false);
        this.f3356d = (FloatingActionButton) viewInflate.findViewById(R.id.add_scheduler);
        this.f3357e = (FloatingActionButton) viewInflate.findViewById(R.id.add_timer);
        this.i = (CoordinatorLayout) viewInflate.findViewById(R.id.scheduleFragment);
        this.j = (TextView) viewInflate.findViewById(R.id.emptyView);
        this.f3354b = new com.cube26.iota.smartlite.a.a(getActivity());
        this.f3355c = this.f3354b.e();
        c();
        ListView listView = (ListView) viewInflate.findViewById(R.id.scheduleList);
        this.f3353a = new com.cube26.iota.smartlite.Apps.a(getActivity().getApplicationContext(), this.h);
        listView.setAdapter((ListAdapter) this.f3353a);
        this.f3356d.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.f3467a) {
                    h.a(f.this.getActivity());
                } else if (f.this.d()) {
                    Intent intent = new Intent(f.this.getActivity(), (Class<?>) SetScheduleActivity.class);
                    intent.putExtra("mode", "new");
                    f.this.startActivity(intent);
                    FlurryAgent.logEvent("new_schedule_page_openned");
                }
            }
        });
        this.f3357e.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.f3467a) {
                    h.a(f.this.getActivity());
                } else if (f.this.d()) {
                    f.this.startActivity(new Intent(f.this.getActivity(), (Class<?>) SetTimerActivity.class));
                }
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.cube26.iota.smartlite.c.f.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                if (!(f.this.h.get(i) instanceof com.cube26.iota.smartlite.b.e)) {
                    return true;
                }
                Snackbar.a(f.this.i, "Delete Schedule ?", -1).a("Confirm", new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.f.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.cube26.iota.smartlite.b.e eVar = (com.cube26.iota.smartlite.b.e) f.this.h.get(i);
                        f.this.f3354b.c(eVar.f());
                        h.e(h.b(eVar.c(), h.v));
                        h.a((Context) f.this.getActivity(), eVar.f());
                        f.this.h.remove(i);
                        if (f.this.f3354b.d(eVar.c()) == 0) {
                            f.this.h.remove(new com.cube26.iota.smartlite.b.f(f.this.f3354b.b(eVar.c()), eVar.c()));
                        }
                        CLog.a("IOTA", " items size :: " + f.this.h.size());
                        if (f.this.h.size() == 0) {
                            f.this.j.setVisibility(0);
                        } else {
                            f.this.j.setVisibility(8);
                        }
                        f.this.f3353a.notifyDataSetChanged();
                        FlurryAgent.logEvent("schedule_delete");
                    }
                }).a();
                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.cube26.iota.smartlite.c.f.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (f.this.h.get(i) instanceof com.cube26.iota.smartlite.b.e) {
                    com.cube26.iota.smartlite.b.e eVar = (com.cube26.iota.smartlite.b.e) f.this.h.get(i);
                    Intent intent = new Intent(f.this.getActivity(), (Class<?>) SetScheduleActivity.class);
                    intent.putExtra("mode", "edit");
                    intent.putExtra("scheduleValid", eVar.k());
                    intent.putExtra("scheduleRuleId", eVar.b());
                    intent.putExtra("scheduleLiteAddress", eVar.c());
                    f.this.startActivity(intent);
                    FlurryAgent.logEvent("update_schedule_page_openned");
                }
            }
        });
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        FlurryAgent.logEvent("schedule_tab_opened");
        CLog.a("IOTA", "on resume schedule" + h.G + h.l);
        if (h.G == 4 && h.l) {
            setUserVisibleHint(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        CLog.a("IOTA", " isVisibletouser:: " + z);
        if (z) {
            CLog.a("IOTA", " schedule visible");
            if (h.l) {
                this.h.clear();
                CLog.a("IOTA", " updating schedule list");
                this.f3353a.notifyDataSetChanged();
                if (h.v.size() <= 0 || !h.l) {
                    return;
                }
                a();
                h.l = false;
            }
        }
    }
}
