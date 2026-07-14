package com.cube26.iota.smartlite.util;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.cube26.iota.smartlite.R;
import com.flurry.android.FlurryAgent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LiteSettings extends android.support.v7.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f3429a = new Handler() { // from class: com.cube26.iota.smartlite.util.LiteSettings.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            b.a("IOTA", " settings handler ::  " + message.what + " ::  arg :: " + message.arg1);
            try {
                switch (message.what) {
                    case Place.TYPE_SUBLOCALITY_LEVEL_2 /* 1024 */:
                        if (message.arg1 == 2 || message.arg1 == 3) {
                            if (message.arg1 == 2) {
                                LiteSettings.this.r.dismiss();
                                HashMap map = new HashMap();
                                map.put("bulb_id", LiteSettings.this.n);
                                FlurryAgent.logEvent("upgrade_firmware_succeed", (Map<String, String>) map, false);
                                Toast.makeText(LiteSettings.this, " Upgrade successful.", 0).show();
                                LiteSettings.this.finish();
                            } else if (message.arg1 == 3) {
                                LiteSettings.this.r.dismiss();
                                HashMap map2 = new HashMap();
                                map2.put("bulb_id", LiteSettings.this.n);
                                FlurryAgent.logEvent("upgrade_firmware_failed", (Map<String, String>) map2, false);
                                Toast.makeText(LiteSettings.this, " Upgrade failed.", 0).show();
                            }
                        } else if (message.arg1 == 255) {
                            LiteSettings.this.r.dismiss();
                            HashMap map3 = new HashMap();
                            map3.put("bulb_id", LiteSettings.this.n);
                            FlurryAgent.logEvent("bulb_disconnected_while_upgradation", (Map<String, String>) map3, false);
                            Toast.makeText(LiteSettings.this, " Connection break.", 0).show();
                        }
                        h.q = false;
                        break;
                    case Place.TYPE_SUBLOCALITY_LEVEL_3 /* 1025 */:
                        if (LiteSettings.this.r != null && LiteSettings.this.r.isShowing()) {
                            LiteSettings.this.r.setProgress(message.arg1);
                            break;
                        }
                        break;
                }
            } catch (IndexOutOfBoundsException e2) {
            } catch (NullPointerException e3) {
            }
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f3430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f3431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f3432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f3433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f3434f;
    private TextView g;
    private int h;
    private int i;
    private SharedPreferences j;
    private Switch k;
    private Switch l;
    private com.cube26.iota.smartlite.a.a m;
    private String n;
    private String o;
    private EditText p;
    private com.cube26.iota.smartlite.d.a q;
    private ProgressDialog r;
    private String s;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.cube26.iota.smartlite.d.a aVar) {
        Intent intent = new Intent(this, (Class<?>) DbHelperService.class);
        intent.putExtra("liteAddress", aVar.q());
        intent.putExtra("liteName", aVar.p());
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        SharedPreferences sharedPreferences = getSharedPreferences("LiteAutoConnectStatus", 0);
        b.a("IOTA", "device address :: " + str);
        boolean z2 = sharedPreferences.getBoolean(str, false);
        sharedPreferences.edit().putBoolean(str, z).commit();
        int i = sharedPreferences.getInt("auto_connect_enabled_lite_count", 0);
        if (z) {
            FlurryAgent.logEvent("bulb_autoconnect_on");
            if (z2 != z) {
                sharedPreferences.edit().putInt("auto_connect_enabled_lite_count", i + 1).commit();
            }
        } else {
            FlurryAgent.logEvent("bulb_autoconnect_off");
            if (z2 != z) {
                sharedPreferences.edit().putInt("auto_connect_enabled_lite_count", i - 1).commit();
            }
        }
        b.a("IOTA", "AUTO_CONNECT_ENABLED_LITE_COUNT  " + sharedPreferences.getInt("auto_connect_enabled_lite_count", 0));
    }

    private void g() {
        this.p = (EditText) findViewById(R.id.lite_name);
        this.f3430b = (Button) findViewById(R.id.saveLite);
        this.f3431c = (TextView) findViewById(R.id.liteSerialNumber);
        this.f3432d = (TextView) findViewById(R.id.liteFirmwareVersion);
        this.f3433e = (TextView) findViewById(R.id.liteColorBehaviourText);
        this.k = (Switch) findViewById(R.id.liteColorBehaviour);
        this.l = (Switch) findViewById(R.id.liteAutoConnect);
        this.f3434f = (TextView) findViewById(R.id.resetLite);
        this.g = (TextView) findViewById(R.id.upgrade_lite_firmware);
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lite_settings);
        FlurryAgent.logEvent("settings_view_opened");
        h.C = this.f3429a;
        c().c(true);
        c().a(BitmapDescriptorFactory.HUE_RED);
        c().b(true);
        c().a(Html.fromHtml("<font color='#596475'>Edit Lite</font>"));
        c().a(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        this.m = new com.cube26.iota.smartlite.a.a(this);
        this.h = getIntent().getIntExtra("port", -1);
        this.i = getIntent().getIntExtra("editMode", -1);
        this.q = h.v.get(this.h);
        b.a("IOTA", " lite port :: " + this.h);
        this.n = this.q.q();
        b.a("IOTA", " lite address :: " + this.n);
        String strO = this.q.o();
        b.a("IOTA", " lite firmware version :: " + strO);
        String strN = this.q.n();
        b.a("IOTA", " lite serial number :: " + this.f3431c);
        g();
        this.o = this.q.p();
        this.p.setText(this.o);
        this.p.setSelection(this.p.getText().length());
        this.p.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
        if (strO != null) {
            this.f3432d.setText(strO);
        }
        if (strN != null) {
            this.f3431c.setText(strN);
        }
        if (this.q.c() == null) {
            this.q.a(this.q.p());
            this.s = this.q.p();
        }
        if (this.q.c() != null && this.q.o() != null) {
            if (!this.q.b() && !this.q.o().equals("1.04")) {
                this.g.setVisibility(0);
            }
            if (this.q.b() && !this.q.o().equals("1.02")) {
                this.g.setVisibility(0);
            }
        }
        this.j = getSharedPreferences("liteSettings", 0);
        boolean z = this.j.getBoolean(this.n, false);
        this.j = getSharedPreferences("LiteAutoConnectStatus", 0);
        boolean z2 = this.j.getBoolean(this.n, false);
        b.a("IOTA", " lite auto connect status :: " + z2);
        this.k.setChecked(z);
        this.l.setChecked(z2);
        if (z) {
            h.c(this.h);
            this.f3433e.setText(Html.fromHtml("The device will turn on with the <b>last color</b> set."));
        } else {
            h.b(this.h);
            this.f3433e.setText(Html.fromHtml("The device will turn on with the default <b>white color</b>."));
        }
        this.f3434f.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.util.LiteSettings.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FlurryAgent.logEvent("bulb_factory_reset");
                h.b(0, 0, 0, 0, LiteSettings.this.h, "reset");
                Toast.makeText(LiteSettings.this, "Lite reset successfully", 0).show();
                LiteSettings.this.k.setChecked(false);
                LiteSettings.this.l.setChecked(false);
                LiteSettings.this.m.e(LiteSettings.this.n);
                LiteSettings.this.finish();
            }
        });
        this.k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.util.LiteSettings.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                if (z3) {
                    FlurryAgent.logEvent("bulb_show_last_color_on");
                    h.c(LiteSettings.this.h);
                    LiteSettings.this.f3433e.setText(Html.fromHtml("The device will turn on with the <b>last color</b> set."));
                } else {
                    FlurryAgent.logEvent("bulb_show_last_color_off");
                    h.b(LiteSettings.this.h);
                    LiteSettings.this.f3433e.setText(Html.fromHtml("The device will turn on with the default <b>white color</b>."));
                }
            }
        });
        this.f3430b.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.util.LiteSettings.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiteSettings.this.o = LiteSettings.this.p.getText().toString();
                if (!h.a(LiteSettings.this.o)) {
                    LiteSettings.this.p.setError("Can't be empty");
                    return;
                }
                for (com.cube26.iota.smartlite.d.a aVar : LiteSettings.this.m.b()) {
                    if (aVar.p().equals(LiteSettings.this.o.trim()) && !aVar.q().equals(LiteSettings.this.n)) {
                        Toast.makeText(LiteSettings.this, "Lite with similar name already exists!", 0).show();
                        return;
                    }
                }
                LiteSettings.this.j = LiteSettings.this.getSharedPreferences("liteSettings", 0);
                LiteSettings.this.j.edit().putBoolean(LiteSettings.this.n, LiteSettings.this.k.isChecked()).commit();
                LiteSettings.this.a(LiteSettings.this.n, LiteSettings.this.l.isChecked());
                LiteSettings.this.m.a(LiteSettings.this.o, LiteSettings.this.n);
                LiteSettings.this.q.d(LiteSettings.this.o);
                LiteSettings.this.q.a(LiteSettings.this.s);
                if (LiteSettings.this.i == 0) {
                    LiteSettings.this.a(LiteSettings.this.q);
                    Message messageObtain = Message.obtain(h.f3470d);
                    messageObtain.what = 12;
                    messageObtain.obj = LiteSettings.this.q;
                    h.f3470d.sendMessage(messageObtain);
                }
                LiteSettings.this.finish();
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.util.LiteSettings.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!LiteSettings.this.q.t()) {
                    Toast.makeText(LiteSettings.this, "Lite is not connected", 0).show();
                    LiteSettings.this.finish();
                    return;
                }
                HashMap map = new HashMap();
                map.put("bulb_id", LiteSettings.this.n);
                FlurryAgent.logEvent("upgrade_firmware_start", (Map<String, String>) map, false);
                Message message = new Message();
                message.what = Place.TYPE_SUBLOCALITY;
                message.arg1 = 1;
                h.r = LiteSettings.this.h;
                h.y.a().sendMessage(message);
                LiteSettings.this.r = new ProgressDialog(LiteSettings.this);
                LiteSettings.this.r.setMax(100);
                LiteSettings.this.r.setMessage("Upgrading");
                LiteSettings.this.r.setTitle("Upgrading Firmware ...");
                LiteSettings.this.r.setProgressStyle(1);
                LiteSettings.this.r.setCancelable(false);
                LiteSettings.this.r.show();
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.saved_lite_menu, menu);
        if (this.i != 0) {
            return true;
        }
        menu.findItem(R.id.remove_lite).setVisible(false);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.remove_lite /* 2131624443 */:
                FlurryAgent.logEvent("bulb_deleted");
                this.q.x();
                this.m.c(this.n);
                a(this.n, false);
                Message messageObtain = Message.obtain(h.f3470d);
                messageObtain.obj = this.q;
                messageObtain.what = 13;
                h.f3470d.sendMessage(messageObtain);
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
