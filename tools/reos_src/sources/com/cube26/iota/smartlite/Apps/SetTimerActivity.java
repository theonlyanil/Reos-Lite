package com.cube26.iota.smartlite.Apps;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.a.f;
import android.text.Html;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.util.ArcProgress;
import com.cube26.iota.smartlite.util.h;
import com.flurry.android.FlurryAgent;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class SetTimerActivity extends f implements b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static double f2982b = 0.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f2983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f2984d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArcProgress f2985a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ToggleButton f2986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Switch f2987f;
    private long g;
    private Date h;
    private SharedPreferences j;
    private TextView n;
    private Handler q;
    private String r;
    private long s;
    private boolean t;
    private long u;
    private boolean i = false;
    private final int k = 1000;
    private final int l = 1000;
    private final int m = 100;
    private String o = Html.fromHtml("<font color='#596475'>00h 00m 00s</font>").toString();
    private String p = "00 : 00";
    private Runnable v = new Runnable() { // from class: com.cube26.iota.smartlite.Apps.SetTimerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SetTimerActivity.f2982b += 1000.0d / (SetTimerActivity.this.g * 10);
            CLog.a("IOTA", " current progress :: " + SetTimerActivity.f2982b);
            if (SetTimerActivity.f2982b < 100.0d) {
                SetTimerActivity.this.f2985a.setProgress((int) SetTimerActivity.f2982b);
                long j = SetTimerActivity.this.u - SetTimerActivity.this.s;
                SetTimerActivity.this.u += 1000;
                SetTimerActivity.this.r = String.format("%d h %d m %d s", Long.valueOf(Math.abs(TimeUnit.MILLISECONDS.toHours(j))), Long.valueOf(Math.abs(TimeUnit.MILLISECONDS.toMinutes(j) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j)))), Long.valueOf(Math.abs(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))));
                CLog.a("IOTA", "timeleft : " + SetTimerActivity.this.r);
                SetTimerActivity.this.f2985a.setProgressText(SetTimerActivity.this.r);
                SetTimerActivity.this.q.postDelayed(this, 1000L);
                return;
            }
            CLog.a("IOTA", " current progress :: " + SetTimerActivity.f2982b);
            Message messageObtain = Message.obtain(h.f3470d);
            if (SetTimerActivity.this.f2987f.isChecked()) {
                messageObtain.what = 20;
            } else {
                messageObtain.what = 19;
            }
            h.f3470d.sendMessage(messageObtain);
            SetTimerActivity.this.f2986e.setChecked(false);
            SetTimerActivity.this.t = false;
            SetTimerActivity.this.j.edit().putBoolean("recreate", false).commit();
            SetTimerActivity.this.q.removeCallbacksAndMessages(null);
            h.g = false;
        }
    };
    private Runnable w = new Runnable() { // from class: com.cube26.iota.smartlite.Apps.SetTimerActivity.2
        @Override // java.lang.Runnable
        public void run() {
            if (SetTimerActivity.f2982b >= 100.0d) {
                CLog.a("IOTA", " current progress ");
                SetTimerActivity.this.f2986e.setChecked(false);
                SetTimerActivity.this.t = false;
                SetTimerActivity.this.j.edit().putBoolean("recreate", false).commit();
                SetTimerActivity.this.q.removeCallbacksAndMessages(null);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - SetTimerActivity.this.s;
            SetTimerActivity.this.r = String.format("%d h %d m %d s", Long.valueOf(Math.abs(TimeUnit.MILLISECONDS.toHours(jCurrentTimeMillis))), Long.valueOf(Math.abs(TimeUnit.MILLISECONDS.toMinutes(jCurrentTimeMillis))), Long.valueOf(Math.abs(TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(jCurrentTimeMillis)))));
            CLog.a("IOTA", "timeleft : " + SetTimerActivity.this.r);
            SetTimerActivity.this.f2985a.setProgressText(SetTimerActivity.this.r);
            SetTimerActivity.this.q.postDelayed(this, 1000L);
        }
    };
    private CompoundButton.OnCheckedChangeListener x = new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.Apps.SetTimerActivity.3
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CLog.a("IOTA", "checked change :: " + z);
            if (!SetTimerActivity.this.t && SetTimerActivity.this.n.getText().toString().equals(SetTimerActivity.this.p)) {
                Toast.makeText(SetTimerActivity.this, " Pick time.", 0).show();
                compoundButton.setChecked(z ? false : true);
                return;
            }
            if (!z) {
                SetTimerActivity.this.f2987f.setEnabled(true);
                SetTimerActivity.this.n.setEnabled(true);
                SetTimerActivity.this.i = false;
                SetTimerActivity.this.t = false;
                SetTimerActivity.this.j.edit().putBoolean("recreate", false).commit();
                h.a("reset", 0, 0, 0);
                SetTimerActivity.this.i();
                SetTimerActivity.this.k();
                FlurryAgent.logEvent("timer_reset");
                return;
            }
            h.g = true;
            h.b();
            h.a(1, 0, 0);
            h.b(1, 0, 0);
            FlurryAgent.logEvent("timer_set");
            SetTimerActivity.this.f2987f.setEnabled(false);
            SetTimerActivity.this.n.setEnabled(false);
            if (SetTimerActivity.this.t) {
                return;
            }
            String[] strArrSplit = SetTimerActivity.this.n.getText().toString().split(" : ");
            h.a(SetTimerActivity.this.f2987f.isChecked() ? "on" : "off", Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), 0);
            SetTimerActivity.this.i = true;
            SetTimerActivity.this.h();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.q.post(this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.q.removeCallbacksAndMessages(null);
        k();
    }

    private void j() {
        this.f2987f = (Switch) findViewById(R.id.lite_turn_state);
        this.n = (TextView) findViewById(R.id.time_picker);
        this.f2985a = (ArcProgress) findViewById(R.id.timerProgress);
        this.f2986e = (ToggleButton) findViewById(R.id.setTimer);
        this.f2985a.setMax(100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f2985a.setProgress(0);
        this.f2985a.setProgressText(this.o);
        this.n.setText(this.p);
        this.g = 0L;
        f2982b = 0.0d;
        this.f2987f.setChecked(false);
    }

    private void l() {
        this.j.edit().putString("pickerTime", this.n.getText().toString()).apply();
        this.j.edit().putBoolean("isTimerSet", this.i).apply();
        this.j.edit().putLong("setTime", this.g).apply();
        this.j.edit().putBoolean("liteState", this.f2987f.isChecked()).apply();
        this.j.edit().putLong("prevTimeStamp", System.currentTimeMillis()).apply();
        this.j.edit().putString("currentProgress", String.valueOf(f2982b)).apply();
        this.j.edit().putString("setDateInMs", String.valueOf(this.s)).apply();
        this.j.edit().putLong("timePickedTimeStamp", this.u).apply();
        CLog.a("IOTA", "saved progress :: " + String.valueOf(f2982b) + " istimerset flag :: " + this.i);
    }

    private void m() {
        this.i = this.j.getBoolean("isTimerSet", false);
        this.n.setText(this.j.getString("pickerTime", null));
        this.g = this.j.getLong("setTime", 0L);
        this.f2987f.setChecked(this.j.getBoolean("liteState", false));
        f2983c = this.j.getLong("prevTimeStamp", 0L);
        f2982b = Double.parseDouble(this.j.getString("currentProgress", "0.0"));
        f2984d = System.currentTimeMillis();
        f2982b += ((f2984d - f2983c) * 1.0d) / (this.g * 10);
        this.u = this.j.getLong("timePickedTimeStamp", 0L);
        if (this.i) {
            return;
        }
        f2982b = 0.0d;
        this.n.setText(this.p);
        this.f2985a.setProgressText(this.o);
    }

    @Override // com.cube26.iota.smartlite.Apps.b.a
    public void a(int i, int i2, int i3) {
        String str = i2 < 10 ? "0" + i2 + " : " : "" + i2 + " : ";
        String str2 = i3 < 10 ? str + "0" + i3 + "" : str + i3 + "";
        switch (i) {
            case 1:
                this.n.setText(str2);
                String[] strArrSplit = this.n.getText().toString().split(" : ");
                this.f2985a.setProgressText(strArrSplit[0] + " h " + strArrSplit[1] + " m 0 s");
                this.g = (Long.parseLong(strArrSplit[1]) * 60) + (Long.parseLong(strArrSplit[0]) * 60 * 60);
                CLog.a("IOTA", "setTime:: " + this.g);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis() + (this.g * 1000));
                this.h = calendar.getTime();
                CLog.a("IOTA", "setDate:: " + this.h);
                this.s = System.currentTimeMillis() + (this.g * 1000);
                CLog.a("IOTA", "setDateInMs :: " + this.s);
                this.u = System.currentTimeMillis();
                CLog.a("IOTA", " timePickedtimeStamp :: " + this.u);
                break;
        }
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CLog.a("IOTA", " on create");
        FlurryAgent.logEvent("timer_view_opened");
        setContentView(R.layout.activity_set_timer);
        this.j = getSharedPreferences("timer_data", 0);
        this.t = this.j.getBoolean("recreate", false);
        CLog.a("IOTA", " on create " + this.t);
        c().b(true);
        c().a(true);
        c().a(Html.fromHtml("<font color='#596475'>New Timer</font>"));
        j();
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.Apps.SetTimerActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new b(1, true).show(SetTimerActivity.this.getSupportFragmentManager(), "timePicker");
            }
        });
        this.f2986e.setOnCheckedChangeListener(this.x);
        this.q = new Handler();
        if (this.t) {
            CLog.a("IOTA", " is checked :: " + this.f2986e.isChecked());
            this.f2986e.setChecked(true);
        }
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onPause() {
        super.onPause();
        l();
        i();
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onResume() {
        super.onResume();
        CLog.a("IOTA", " on resume");
        m();
        if (this.t) {
            this.s = Long.parseLong(this.j.getString("setDateInMs", "0"));
            CLog.a("IOTA", " onresume setdatinms :: " + this.s);
        }
        if (this.i) {
            this.u += System.currentTimeMillis() - f2983c;
            CLog.a("IOTA", " onresume timepickedtimestamp :: " + this.u);
            h();
        }
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.i) {
            this.j.edit().putBoolean("recreate", true).commit();
        }
    }
}
