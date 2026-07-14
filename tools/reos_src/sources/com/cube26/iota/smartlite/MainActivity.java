package com.cube26.iota.smartlite;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.t;
import android.support.v4.app.v;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.a.f;
import android.text.Html;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.http.HTTPLibrary;
import com.android.library.userprofile.util.Constants;
import com.cube26.iota.smartlite.AlertViews.AlertSpecificActivity;
import com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity;
import com.cube26.iota.smartlite.VirtualLite.TryVirtualReosLiteActivity;
import com.cube26.iota.smartlite.c.b;
import com.cube26.iota.smartlite.c.c;
import com.cube26.iota.smartlite.c.d;
import com.cube26.iota.smartlite.c.e;
import com.cube26.iota.smartlite.util.Settings;
import com.cube26.iota.smartlite.util.h;
import com.flurry.android.FlurryAgent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import f.l;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends f implements HTTPLibrary.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3045a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f3046b = 0;
    private ListView A;
    private Handler C;
    private CoordinatorLayout E;
    private Intent H;
    private ProgressDialog I;
    private b J;
    private d K;
    private Rect L;
    private View N;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ProgressDialog f3050f;
    AsyncTask<Void, Void, Void> g;
    String h;
    SharedPreferences i;
    SharedPreferences.Editor j;
    View k;
    View l;
    private LinearLayout n;
    private TextView o;
    private TextView p;
    private e r;
    private AutoScanConnectService u;
    private DialogInterface.OnCancelListener w;
    private DrawerLayout x;
    private android.support.v7.a.b y;
    private ViewPager z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final IntentFilter f3047c = new IntentFilter("progress");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final SparseArray<Fragment> f3048d = new SparseArray<>();
    private final BroadcastReceiver q = new BroadcastReceiver() { // from class: com.cube26.iota.smartlite.MainActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CLog.a("IOTA", "message" + intent);
            String string = intent.getExtras().getString("message");
            com.cube26.iota.smartlite.e.a.a(MainActivity.this.getApplicationContext());
            CLog.a("IOTA", "New Message" + string);
            com.cube26.iota.smartlite.e.a.a();
        }
    };
    private ArrayList<com.cube26.iota.smartlite.d.a> s = new ArrayList<>();
    private ArrayList<com.cube26.iota.smartlite.b.a> t = new ArrayList<>();
    private final ServiceConnection v = new ServiceConnection() { // from class: com.cube26.iota.smartlite.MainActivity.12
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CLog.a("IOTA", " autoscanconnect service on service connected callback");
            MainActivity.this.u = ((AutoScanConnectService.c) iBinder).a();
            AutoScanConnectService.a();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CLog.a("IOTA", " on service disconnected");
            MainActivity.this.u = null;
        }
    };
    private boolean B = false;
    private boolean D = false;
    private boolean F = true;
    private final BroadcastReceiver G = new BroadcastReceiver() { // from class: com.cube26.iota.smartlite.MainActivity.23
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                CLog.a("IOTA", "No devices found");
                return;
            }
            switch (h.s.getState()) {
                case 10:
                case 13:
                    CLog.a("IOTA", "-- BluetoothAdapter STATE_OFF --");
                    MainActivity.this.t();
                    MainActivity.this.s();
                    MainActivity.this.n();
                    break;
                case 12:
                    CLog.a("IOTA", "-- BluetoothAdapter STATE_ON --");
                    CLog.a("IOTA", "bluetooth adapter state on receiver");
                    MainActivity.this.o();
                    break;
            }
        }
    };
    final BroadcastReceiver m = new BroadcastReceiver() { // from class: com.cube26.iota.smartlite.MainActivity.32
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CLog.a("IOTA", "on receive");
            if (intent.getStringExtra(Constants.SMS_COLUMN_STATUS).equals("connected") || intent.getStringExtra(Constants.SMS_COLUMN_STATUS).equals("disconnected")) {
                MainActivity.f3046b = intent.getIntExtra("port", -1) + 1;
            }
            if (MainActivity.f3046b == h.v.size() && MainActivity.this.f3050f != null && MainActivity.this.f3050f.isShowing()) {
                MainActivity.this.f3050f.dismiss();
                if (MainActivity.this.J != null) {
                    CLog.a("IOTA", "progressReceiver :: inflateLiteConfigurationLayout ");
                }
            }
        }
    };
    private View.OnClickListener M = new View.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.35
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FlurryAgent.logEvent("buy_iota_lite_tapped");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://goo.gl/AxTH1L"));
            if (intent.resolveActivity(MainActivity.this.getPackageManager()) != null) {
                MainActivity.this.startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Missing internet browser", 0).show();
            }
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final com.cube26.iota.smartlite.a.a f3049e = new com.cube26.iota.smartlite.a.a(this);

    public class a extends v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f3093a;

        public a(t tVar, int i) {
            super(tVar);
            this.f3093a = i;
        }

        @Override // android.support.v4.app.v
        public Fragment a(int i) {
            switch (i) {
                case 0:
                    MainActivity.this.J = new b();
                    return MainActivity.this.J;
                case 1:
                    MainActivity.this.K = new d();
                    return MainActivity.this.K;
                case 2:
                    return new c();
                case 3:
                    return new com.cube26.iota.smartlite.c.a(MainActivity.this);
                case 4:
                    return new com.cube26.iota.smartlite.c.f();
                default:
                    return null;
            }
        }

        @Override // android.support.v4.app.v, android.support.v4.view.ac
        public Object a(ViewGroup viewGroup, int i) {
            Fragment fragment = (Fragment) super.a(viewGroup, i);
            MainActivity.this.f3048d.put(i, fragment);
            return fragment;
        }

        @Override // android.support.v4.app.v, android.support.v4.view.ac
        public void a(ViewGroup viewGroup, int i, Object obj) {
            MainActivity.this.f3048d.remove(i);
            super.a(viewGroup, i, obj);
        }

        @Override // android.support.v4.view.ac
        public int b() {
            return this.f3093a;
        }
    }

    private void a(Context context, String str) {
        SharedPreferences sharedPreferencesC = c(context);
        int iB = b(context);
        CLog.b("IOTA", "Saving regId on app version " + iB);
        SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
        editorEdit.putString("registration_id", str);
        editorEdit.putInt("appVersion", iB);
        editorEdit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.cube26.iota.smartlite.d.a aVar) {
        for (com.cube26.iota.smartlite.b.a aVar2 : this.f3049e.c()) {
            if (aVar2.d().contains(aVar)) {
                CLog.a("IOTA", "getConcatenatedLitesAddress " + aVar2.i());
                if (aVar2.d().size() == 2) {
                    this.f3049e.b(aVar2.c());
                    this.r.c(aVar2);
                } else {
                    aVar2.a(aVar);
                    this.r.b(aVar2);
                    this.f3049e.a(aVar2.c(), aVar2.i());
                }
                CLog.a("IOTA", "updatedConcatenatedLitesAddress " + aVar2.i());
            }
        }
        this.r.notifyDataSetChanged();
    }

    private void a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.accumulate("authify_access_token", str);
            jSONObject.accumulate("device_id", h.a());
            jSONObject.accumulate("android_id", com.android.library.deviceData.c.a.e(getApplicationContext()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        HTTPLibrary.post(this, this, 10001, h.b.f3478b, "users/create", jSONObject, null);
    }

    private void a(int[] iArr, int i, final int i2) {
        CLog.a("IOTA", " open alert");
        if (iArr.length > 0 && iArr[0] == 0) {
            CLog.a("IOTA", "Permission Granted :D");
            Intent intent = new Intent(this, (Class<?>) AlertSpecificActivity.class);
            intent.putExtra("recipe_id", i);
            startActivity(intent);
            return;
        }
        if (shouldShowRequestPermissionRationale("android.permission.READ_PHONE_STATE")) {
            android.support.v7.a.e.a aVar = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
            aVar.a("Permission Error");
            aVar.b("From Android M onwards, we require Phone state permission to notify you the alerts. Please grant the permission for smooth functioning of the app or else you won't be able to recieve alerts.");
            aVar.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.25
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    MainActivity.this.requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, i2);
                }
            });
            aVar.a(false);
            aVar.c();
            return;
        }
        android.support.v7.a.e.a aVar2 = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
        aVar2.a("Permission Denial");
        aVar2.b("Phone state access has not been granted & we require phone state access for notifying you with alerts .Are you sure you want to deny the permission ?");
        aVar2.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.22
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", MainActivity.this.getPackageName(), null));
                MainActivity.this.startActivityForResult(intent2, 100);
            }
        });
        aVar2.b("I'M Sure", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.24
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
            }
        });
        aVar2.a(false);
        aVar2.c();
    }

    private static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Could not get package name: " + e2);
        }
    }

    private void b(Context context, String str) {
        SharedPreferences sharedPreferencesD = d(context);
        b(context);
        CLog.a("IOTA", "Saving user_id" + str);
        SharedPreferences.Editor editorEdit = sharedPreferencesD.edit();
        editorEdit.putString("user_id", str);
        editorEdit.commit();
    }

    private void b(String str) {
        h.a(this, str, PendingIntent.getActivity(this, new Random().nextInt(100), new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())), 134217728));
    }

    private SharedPreferences c(Context context) {
        return getSharedPreferences("GCMPrefs", 0);
    }

    private void c(Intent intent) {
        CLog.a("IOTA", " handleVirtualIntent ");
        if (intent == null || !intent.hasExtra("clientSessionId")) {
            return;
        }
        String str = intent.getStringExtra("clientSessionId") + "\r\n";
        CLog.a("IOTA", "clientSessionId  " + str);
        if (h.b.f3477a == null) {
            Toast.makeText(this, "Server is not reachable at this moment. Please try after some time.", 1).show();
            return;
        }
        CLog.a("IOTA", " url :: " + h.b.f3477a);
        int i = Integer.parseInt(h.b.f3477a.substring(h.b.f3477a.lastIndexOf(":") + 1, h.b.f3477a.length() - 1));
        String strSubstring = h.b.f3477a.substring(h.b.f3477a.indexOf(":") + 3, h.b.f3477a.length() - 6);
        CLog.a("IOTA", " port :: " + i + " url : " + strSubstring);
        com.cube26.iota.smartlite.VirtualLite.a aVarA = com.cube26.iota.smartlite.VirtualLite.a.a();
        aVarA.a(strSubstring, i, str);
        aVarA.b();
        if (this.x.g(3)) {
            this.x.f(3);
        }
        this.x.setDrawerLockMode(1);
        h.v.add(new com.cube26.iota.smartlite.d.a());
        invalidateOptionsMenu();
        CLog.a("IOTA", " invalidating optionsmenu ");
    }

    private void c(String str) {
        a(str);
    }

    private SharedPreferences d(Context context) {
        return getSharedPreferences("USERIDPrefs", 0);
    }

    private void k() {
        Config config = Config.getInstance(this);
        h.a.f3473a = config.get("authifyLib.authifyUrl");
        h.b.f3478b = config.get("lite.registrationUrl");
        h.b.f3477a = config.get("virtualBulb.socketUrl");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            ArrayList<com.cube26.iota.smartlite.d.a> arrayListA = this.r.a();
            synchronized (h.m) {
                try {
                    for (com.cube26.iota.smartlite.d.a aVar : h.v) {
                        if (arrayListA.contains(aVar)) {
                            com.cube26.iota.smartlite.d.a aVar2 = arrayListA.get(arrayListA.indexOf(aVar));
                            aVar2.b(aVar.e());
                            aVar2.e(aVar.t() ? 2 : 0);
                            aVar2.e(aVar.r());
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e2) {
        }
    }

    private void m() {
        this.o = (TextView) findViewById(R.id.try_virtual_reos_lite);
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, (Class<?>) TryVirtualReosLiteActivity.class));
            }
        });
        this.p = (TextView) findViewById(R.id.buy_reos_lite);
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.flipkart.com/reos-led-smart-bulb/p/itmehvmfhradshpp?pid=LLSEHVMFA2XBZHHG"));
                FlurryAgent.logEvent("buy_iota_lite_tapped");
                if (intent.resolveActivity(MainActivity.this.getPackageManager()) != null) {
                    MainActivity.this.startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Missing internet browser!", 0).show();
                }
            }
        });
        this.x = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.A = (ListView) findViewById(R.id.left_drawer);
        this.E = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        this.n = (LinearLayout) findViewById(R.id.emptyView);
        Button button = (Button) findViewById(R.id.search);
        this.r = new e(this);
        this.s = this.f3049e.b();
        CLog.a("IOTA", " saved lites count :: " + this.s.size());
        for (com.cube26.iota.smartlite.d.a aVar : this.s) {
            if (h.v.contains(aVar)) {
                this.r.a(h.v.get(h.v.indexOf(aVar)));
            } else {
                this.r.a(aVar);
            }
        }
        this.t = this.f3049e.c();
        this.r.a(this.t);
        this.A.setAdapter((ListAdapter) this.r);
        button.setText("Search Reos Lite");
        button.setAllCaps(false);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MainActivity.this.n() && MainActivity.this.j()) {
                    FlurryAgent.logEvent("refresh_or_scan_bulbs");
                    MainActivity.this.q();
                    MainActivity.this.s = MainActivity.this.f3049e.b();
                    for (com.cube26.iota.smartlite.d.a aVar2 : MainActivity.this.r.a()) {
                        if (!aVar2.t()) {
                            h.v.remove(aVar2);
                            aVar2.b(false);
                        }
                    }
                    h.v.removeAll(MainActivity.this.r.b());
                    MainActivity.this.r.c();
                    MainActivity.this.r.b().clear();
                    h.w.clear();
                    MainActivity.this.r.notifyDataSetChanged();
                    for (com.cube26.iota.smartlite.d.a aVar3 : h.v) {
                        if (!aVar3.t()) {
                            aVar3.x();
                            h.v.remove(aVar3);
                        }
                    }
                    AutoScanConnectService.a();
                }
            }
        });
        this.y = new android.support.v7.a.b(this, this.x, R.string.drawer_open, R.string.drawer_close) { // from class: com.cube26.iota.smartlite.MainActivity.3
            @Override // android.support.v7.a.b, android.support.v4.widget.DrawerLayout.f
            public void a(View view) {
                super.a(view);
                CLog.a("IOTA", " drawer opened callback");
                if (!MainActivity.this.x.g(3)) {
                    MainActivity.this.r.notifyDataSetChanged();
                }
                MainActivity.this.r.notifyDataSetChanged();
            }

            @Override // android.support.v7.a.b, android.support.v4.widget.DrawerLayout.f
            public void b(View view) {
                super.b(view);
                MainActivity.f3045a = false;
                MainActivity.this.F = false;
                CLog.a("IOTA", "drawer closed Utility.selectedDeviceList Iota's :: " + h.v.size());
                AutoScanConnectService.b();
                CLog.a("IOTA", "Utility.selectedDeviceList.size() ::" + h.v.size());
                if (h.G == 0) {
                    b.f3258c.b();
                }
            }
        };
        this.x.setDrawerListener(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        if (!getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            Toast.makeText(this, getResources().getString(R.string.unsupported), 0).show();
            finish();
            return false;
        }
        h.s = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        if (Build.VERSION.SDK_INT > 22) {
            h.u = h.s.getBluetoothLeScanner();
        }
        if (h.s == null) {
            Toast.makeText(this, getResources().getString(R.string.unsupported), 0).show();
            finish();
            return false;
        }
        if (h.s.isEnabled()) {
            CLog.a("IOTA", "Binding service as BLE is on");
            o();
            return true;
        }
        if (!h.s.isEnabled()) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
            this.F = false;
        }
        CLog.a("IOTA", "Binding service unsuccessful as ble was off & turning on");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        CLog.a("IOTA", " app initautoconnectservice");
        this.H = new Intent();
        this.H.setComponent(new ComponentName("com.cube26.iota.smartlite", "com.cube26.iota.smartlite.AutoScanConnectService"));
        startService(this.H);
        bindService(this.H, this.v, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        for (com.cube26.iota.smartlite.d.a aVar : h.w) {
            if (this.s.contains(aVar)) {
                ArrayList<com.cube26.iota.smartlite.d.a> arrayListA = this.r.a();
                arrayListA.get(arrayListA.indexOf(aVar)).a(aVar.c());
                arrayListA.get(arrayListA.indexOf(aVar)).b(true);
            } else {
                this.r.b(aVar);
            }
        }
        for (com.cube26.iota.smartlite.d.a aVar2 : h.v) {
            if (this.s.contains(aVar2)) {
                aVar2.d(this.s.get(this.s.indexOf(aVar2)).p());
                aVar2.a(this.s.get(this.s.indexOf(aVar2)).c());
                this.r.c(aVar2);
            }
        }
        h.f3470d.sendMessage(Message.obtain(h.f3470d, 16));
        this.r.notifyDataSetChanged();
        if (this.r.getCount() == 0) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.I = h.b(this);
        this.w = new DialogInterface.OnCancelListener() { // from class: com.cube26.iota.smartlite.MainActivity.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                AutoScanConnectService.b();
                MainActivity.this.p();
            }
        };
        this.I.setOnCancelListener(this.w);
        new Timer().schedule(new TimerTask() { // from class: com.cube26.iota.smartlite.MainActivity.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.cube26.iota.smartlite.MainActivity.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MainActivity.this.I == null || !MainActivity.this.I.isShowing()) {
                            return;
                        }
                        AutoScanConnectService.b();
                        MainActivity.this.p();
                        try {
                            if (MainActivity.this.I == null || !MainActivity.this.I.isShowing()) {
                                return;
                            }
                            MainActivity.this.I.dismiss();
                        } catch (IllegalArgumentException e2) {
                        }
                    }
                });
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        boolean z = getSharedPreferences("user_reg_shared_prefs", 0).getBoolean("is_completed", false);
        h.f3467a = false;
        com.cube26.iota.smartlite.VirtualLite.a.a().c();
        this.x.setDrawerLockMode(0);
        if (h.v.size() > 0) {
            h.v.clear();
        }
        invalidateOptionsMenu();
        if (z) {
            onResume();
        } else {
            startActivity(new Intent(this, (Class<?>) UserRegistrationActivity.class));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        h.v.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        CLog.a("IOTA", " clear scan device list ");
        h.w.clear();
        CLog.a("IOTA", " clear scan device list " + h.w.size());
    }

    private boolean u() {
        CLog.a("IOTA", "We already have permission");
        return ((LocationManager) getSystemService("location")).isProviderEnabled("gps");
    }

    private void v() {
        CLog.a("IOTA", "Building GPS Alert");
        android.support.v7.a.e.a aVar = new android.support.v7.a.e.a(this);
        aVar.b("To Scan the Lite, We require access to the location.Please Enable location to find the Lite?").a(false).a("Yes", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.31
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                MainActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        }).b("No", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.30
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        android.support.v7.a.e eVarB = aVar.b();
        if (eVarB.isShowing()) {
            return;
        }
        eVarB.show();
    }

    public boolean a(Context context) {
        String string = d(context).getString("user_id", "DEFAULT");
        if (!string.isEmpty() && !string.equals("DEFAULT")) {
            return true;
        }
        CLog.b("IOTA", "Registration not found.");
        return false;
    }

    public void g() {
        try {
            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent.putExtra("android.speech.extra.PROMPT", "Change Color to ?");
            CLog.a("IOTA", " starting voice recog activity");
            startActivityForResult(intent, 1234);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void h() {
        if (d.i != null && d.i.isChecked()) {
            d.i.setChecked(false);
        }
        if (d.k != null && d.k.isChecked()) {
            d.k.setChecked(false);
        }
        if (!h.N && d.f3307d) {
            g();
            return;
        }
        if (!h.N) {
            if (d.f3307d) {
                return;
            }
            try {
                d.f3307d = true;
                d.f3309f.setChecked(false);
                d.a();
                for (int i = 0; i < h.v.size(); i++) {
                    h.b(b.f3256a[0], b.f3256a[1], b.f3256a[2], h.H, i, "wheel");
                }
                g();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                g();
                CLog.a("IOTA", "Unregistering receiver :: exception caught");
                return;
            }
        }
        if (c.f3272c.equals(c.f3273d)) {
            try {
                h.B.removeCallbacksAndMessages(null);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            h.N = false;
            c.f3273d = "";
            c.f3272c = "";
            CLog.a("IOTA", "Canceling Handlers");
            c.a();
            if (c.f3274e.equalsIgnoreCase("candle") || c.f3274e.equalsIgnoreCase("Strobe") || c.f3274e.equalsIgnoreCase("Kaleidoscope")) {
                for (int i2 = 0; i2 < h.v.size(); i2++) {
                    h.b(200, 0, 200, 200, i2, "PhoneCancel");
                }
            }
            for (int i3 = 0; i3 < h.v.size(); i3++) {
                h.b(b.f3256a[0], b.f3256a[1], b.f3256a[2], h.H, i3, "wheel");
            }
            g();
        }
    }

    public void i() {
        if (h.c(getApplicationContext()).contains("com.cube26.osp.music")) {
            try {
                Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage("com.cube26.osp.music");
                if (launchIntentForPackage != null) {
                    startActivity(launchIntentForPackage);
                    return;
                }
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        android.support.v7.a.e.a aVar = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
        aVar.a("Get Reos Music");
        aVar.b("To enable music sync, download Reos Music from Google Playstore");
        aVar.a("Download", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.29
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.cube26.osp.music")));
                } catch (ActivityNotFoundException e3) {
                    MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.cube26.osp.music")));
                }
            }
        });
        aVar.b("Cancel", null);
        aVar.a(false);
        aVar.c();
    }

    public boolean j() {
        if (Build.VERSION.SDK_INT > 22) {
            if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                CLog.a("IOTA", "requesting location permission");
                requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 106);
                return false;
            }
            if (!u()) {
                v();
                return false;
            }
        }
        return true;
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        CLog.a("IOTA", "OnActivity Result");
        if (i == 1234 && i2 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= stringArrayListExtra.size()) {
                    break;
                }
                stringArrayListExtra.set(i4, stringArrayListExtra.get(i4).toLowerCase());
                CLog.a("IOTA", "Voice output" + stringArrayListExtra.get(i4));
                if (stringArrayListExtra.get(i4).contains("red")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: RED");
                    b.f3256a[0] = 255;
                    b.f3256a[1] = 0;
                    b.f3256a[2] = 0;
                    for (int i5 = 0; i5 < h.v.size(); i5++) {
                        h.b(255, 0, 0, h.H, i5, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("green")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: GREEN");
                    b.f3256a[0] = 0;
                    b.f3256a[1] = 255;
                    b.f3256a[2] = 0;
                    for (int i6 = 0; i6 < h.v.size(); i6++) {
                        h.b(0, 255, 0, h.H, i6, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("blue")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: BLUE");
                    b.f3256a[0] = 0;
                    b.f3256a[1] = 0;
                    b.f3256a[2] = 255;
                    for (int i7 = 0; i7 < h.v.size(); i7++) {
                        h.b(0, 0, 255, h.H, i7, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("yellow")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: YELLOW");
                    b.f3256a[0] = 255;
                    b.f3256a[1] = 255;
                    b.f3256a[2] = 0;
                    for (int i8 = 0; i8 < h.v.size(); i8++) {
                        h.b(255, 255, 0, h.H, i8, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("white")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: WHITE");
                    b.f3256a[0] = 255;
                    b.f3256a[1] = 255;
                    b.f3256a[2] = 255;
                    for (int i9 = 0; i9 < h.v.size(); i9++) {
                        h.b(255, 255, 255, h.H, i9, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("violet")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: violet");
                    b.f3256a[0] = 138;
                    b.f3256a[1] = 43;
                    b.f3256a[2] = 226;
                    for (int i10 = 0; i10 < h.v.size(); i10++) {
                        h.b(138, 43, 226, h.H, i10, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("pink")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: PINK");
                    b.f3256a[0] = 255;
                    b.f3256a[1] = 105;
                    b.f3256a[2] = 180;
                    for (int i11 = 0; i11 < h.v.size(); i11++) {
                        h.b(255, 105, 180, h.H, i11, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("aqua") || stringArrayListExtra.get(i4).contains("cyan")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: AQUA / CYAN");
                    b.f3256a[0] = 0;
                    b.f3256a[1] = 255;
                    b.f3256a[2] = 255;
                    for (int i12 = 0; i12 < h.v.size(); i12++) {
                        h.b(0, 255, 255, h.H, i12, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("magenta")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: magenta");
                    b.f3256a[0] = 238;
                    b.f3256a[1] = 0;
                    b.f3256a[2] = 238;
                    for (int i13 = 0; i13 < h.v.size(); i13++) {
                        h.b(238, 0, 238, h.H, i13, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("orange")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: orange");
                    b.f3256a[0] = 255;
                    b.f3256a[1] = 165;
                    b.f3256a[2] = 0;
                    for (int i14 = 0; i14 < h.v.size(); i14++) {
                        h.b(255, 165, 0, h.H, i14, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("navy blue")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: navy blue");
                    b.f3256a[0] = 0;
                    b.f3256a[1] = 0;
                    b.f3256a[2] = 128;
                    for (int i15 = 0; i15 < h.v.size(); i15++) {
                        h.b(0, 0, 128, h.H, i15, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("purple")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: purple");
                    b.f3256a[0] = 128;
                    b.f3256a[1] = 0;
                    b.f3256a[2] = 128;
                    for (int i16 = 0; i16 < h.v.size(); i16++) {
                        h.b(128, 0, 128, h.H, i16, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("indigo")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: indigo");
                    b.f3256a[0] = 39;
                    b.f3256a[1] = 64;
                    b.f3256a[2] = 139;
                    for (int i17 = 0; i17 < h.v.size(); i17++) {
                        h.b(39, 64, 139, h.H, i17, "Wheel");
                    }
                } else if (stringArrayListExtra.get(i4).contains("teal")) {
                    if (b.f3259d.equals("off")) {
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                    }
                    CLog.a("IOTA", "Its a match for :: teal");
                    b.f3256a[0] = 0;
                    b.f3256a[1] = 128;
                    b.f3256a[2] = 128;
                    for (int i18 = 0; i18 < h.v.size(); i18++) {
                        h.b(0, 128, 128, h.H, i18, "Wheel");
                    }
                } else if (!stringArrayListExtra.get(i4).equals("time")) {
                    if (stringArrayListExtra.get(i4).contains("plum")) {
                        if (b.f3259d.equals("off")) {
                            b.f3257b.setChecked(false);
                            b.f3257b.setBackgroundResource(R.drawable.on);
                        }
                        CLog.a("IOTA", "Its a match for :: plum");
                        b.f3256a[0] = 221;
                        b.f3256a[1] = 160;
                        b.f3256a[2] = 221;
                        for (int i19 = 0; i19 < h.v.size(); i19++) {
                            h.b(221, 160, 221, h.H, i19, "Wheel");
                        }
                    } else if (stringArrayListExtra.get(i4).contains("maroon")) {
                        if (b.f3259d.equals("off")) {
                            b.f3257b.setChecked(false);
                            b.f3257b.setBackgroundResource(R.drawable.on);
                        }
                        CLog.a("IOTA", "Its a match for :: maroon");
                        b.f3256a[0] = 205;
                        b.f3256a[1] = 41;
                        b.f3256a[2] = 144;
                        for (int i20 = 0; i20 < h.v.size(); i20++) {
                            h.b(205, 41, 144, h.H, i20, "Wheel");
                        }
                    } else if (stringArrayListExtra.get(i4).contains("crimson")) {
                        if (b.f3259d.equals("off")) {
                            b.f3257b.setChecked(false);
                            b.f3257b.setBackgroundResource(R.drawable.on);
                        }
                        CLog.a("IOTA", "Its a match for :: crimson");
                        b.f3256a[0] = 220;
                        b.f3256a[1] = 20;
                        b.f3256a[2] = 60;
                        for (int i21 = 0; i21 < h.v.size(); i21++) {
                            h.b(220, 20, 60, h.H, i21, "Wheel");
                        }
                    } else if (stringArrayListExtra.get(i4).contains("golden")) {
                        if (b.f3259d.equals("off")) {
                            b.f3257b.setChecked(false);
                            b.f3257b.setBackgroundResource(R.drawable.on);
                        }
                        CLog.a("IOTA", "Its a match for :: golden");
                        b.f3256a[0] = 218;
                        b.f3256a[1] = 165;
                        b.f3256a[2] = 32;
                        for (int i22 = 0; i22 < h.v.size(); i22++) {
                            h.b(218, 165, 32, h.H, i22, "Wheel");
                        }
                    } else if (stringArrayListExtra.get(i4).contains("turquoise")) {
                        if (b.f3259d.equals("off")) {
                            b.f3257b.setChecked(false);
                            b.f3257b.setBackgroundResource(R.drawable.on);
                        }
                        CLog.a("IOTA", "Its a match for :: turquoise");
                        b.f3256a[0] = 64;
                        b.f3256a[1] = 224;
                        b.f3256a[2] = 208;
                        for (int i23 = 0; i23 < h.v.size(); i23++) {
                            h.b(64, 224, 208, h.H, i23, "Wheel");
                        }
                    } else if (stringArrayListExtra.get(i4).contains("royalblue")) {
                        if (b.f3259d.equals("off")) {
                            b.f3257b.setChecked(false);
                            b.f3257b.setBackgroundResource(R.drawable.on);
                        }
                        CLog.a("IOTA", "Its a match for :: royalblue");
                        b.f3256a[0] = 65;
                        b.f3256a[1] = 105;
                        b.f3256a[2] = 255;
                        for (int i24 = 0; i24 < h.v.size(); i24++) {
                            h.b(65, 105, 255, h.H, i24, "Wheel");
                        }
                    } else if (stringArrayListExtra.get(i4).contains("on")) {
                        if (b.f3259d.equals("off")) {
                            CLog.a("IOTA", " device off ");
                            b.f3257b.setChecked(false);
                            b.f3257b.setBackgroundResource(R.drawable.on);
                            b.f3259d = "on";
                            CLog.a("IOTA", "Its a match for :: On");
                            for (int i25 = 0; i25 < h.v.size(); i25++) {
                                h.b(0, 0, 0, 200, i25, "on");
                            }
                        }
                    } else if (stringArrayListExtra.get(i4).contains("off")) {
                        b.f3257b.setChecked(true);
                        b.f3257b.setBackgroundResource(R.drawable.off);
                        CLog.a("IOTA", "Its a match for :: OFF");
                        for (int i26 = 0; i26 < h.v.size(); i26++) {
                            h.b(0, 0, 0, 0, i26, "OFF");
                        }
                    }
                }
                i3 = i4 + 1;
            }
        }
        if (i == 1 && i2 == 0) {
            CLog.a("IOTA", "Denied BLE request, So closing app");
            finish();
            return;
        }
        if (i == 1 && i2 == -1) {
            CLog.a("IOTA", "Ble Enabled");
            this.F = true;
            o();
        } else if (i == 6000 && i2 == 0) {
            CLog.a("IOTA", "Mode Updated");
            this.z.setCurrentItem(1);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.p, android.app.Activity
    public void onBackPressed() {
        CLog.a("IOTA", "Back button pressed");
        if (this.I != null && this.I.isShowing()) {
            AutoScanConnectService.b();
        }
        moveTaskToBack(true);
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.y.a(configuration);
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k();
        setContentView(R.layout.activity_main);
        m();
        Intent intent = getIntent();
        String string = getSharedPreferences("user_reg_shared_prefs", 0).getString("authify_access_token", null);
        if (string != null && !a((Context) this)) {
            c(string);
        }
        c(intent);
        if (h.m == null) {
            h.m = new Object();
        }
        CLog.a("IOTA", " list size :: " + h.v.size());
        this.i = getSharedPreferences("tut", 0);
        this.j = this.i.edit();
        c().c(true);
        c().a(BitmapDescriptorFactory.HUE_RED);
        c().b(true);
        c().a(Html.fromHtml("<font color='#596475'>Lite</font>"));
        c().a(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        if (h.y == null) {
            h.y = new com.cube26.iota.smartlite.util.a(this);
            h.y.start();
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.a(tabLayout.a().a("Color"));
        tabLayout.a(tabLayout.a().a("Music"));
        tabLayout.a(tabLayout.a().a("Mode"));
        tabLayout.a(tabLayout.a().a("Alerts"));
        tabLayout.a(tabLayout.a().a("Scheduler"));
        tabLayout.setTabGravity(0);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout.setOnTabSelectedListener(new TabLayout.a() { // from class: com.cube26.iota.smartlite.MainActivity.33
            @Override // android.support.design.widget.TabLayout.a
            public void a(TabLayout.d dVar) {
                viewPager.setCurrentItem(dVar.c());
                CLog.a("IOTA", "Tab Selected ::" + dVar.c());
                h.G = dVar.c();
                if (h.G == 1) {
                    if (!h.c(MainActivity.this.getApplicationContext()).contains("com.cube26.osp.music")) {
                        d.f3305b.setVisibility(0);
                        d.f3304a.setVisibility(4);
                    } else {
                        CLog.a("IOTA", "Neon Music is installed");
                        d.f3305b.setVisibility(8);
                        d.f3304a.setVisibility(0);
                    }
                }
            }

            @Override // android.support.design.widget.TabLayout.a
            public void b(TabLayout.d dVar) {
                CLog.a("IOTA", "Tab UnSelected ::" + dVar.c());
            }

            @Override // android.support.design.widget.TabLayout.a
            public void c(TabLayout.d dVar) {
                CLog.a("IOTA", "Tab ReSelected::" + dVar.c());
            }
        });
        viewPager.setAdapter(new a(getSupportFragmentManager(), tabLayout.getTabCount()));
        viewPager.a(new TabLayout.e(tabLayout));
        viewPager.setOffscreenPageLimit(5);
        registerReceiver(this.G, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        this.C = new Handler() { // from class: com.cube26.iota.smartlite.MainActivity.34
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 12:
                        com.cube26.iota.smartlite.d.a aVar = (com.cube26.iota.smartlite.d.a) message.obj;
                        aVar.c(true);
                        MainActivity.this.r.e(aVar);
                        MainActivity.this.r.a(aVar);
                        h.f3472f = true;
                        break;
                    case 13:
                        com.cube26.iota.smartlite.d.a aVar2 = (com.cube26.iota.smartlite.d.a) message.obj;
                        MainActivity.this.r.d(aVar2);
                        MainActivity.this.f3049e.c(aVar2.q());
                        h.v.remove(aVar2);
                        MainActivity.this.a(aVar2);
                        break;
                    case 14:
                        MainActivity.this.r.a((com.cube26.iota.smartlite.b.a) message.obj);
                        break;
                    case 15:
                        MainActivity.this.r.c((com.cube26.iota.smartlite.b.a) message.obj);
                        break;
                    case 16:
                        MainActivity.this.l();
                        MainActivity.this.runOnUiThread(new Runnable() { // from class: com.cube26.iota.smartlite.MainActivity.34.2
                            @Override // java.lang.Runnable
                            public void run() {
                                MainActivity.this.r.notifyDataSetChanged();
                            }
                        });
                        break;
                    case 17:
                        MainActivity.this.runOnUiThread(new Runnable() { // from class: com.cube26.iota.smartlite.MainActivity.34.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MainActivity.this.r.notifyDataSetChanged();
                            }
                        });
                        break;
                    case 18:
                        MainActivity.this.r.b((com.cube26.iota.smartlite.b.a) message.obj);
                        break;
                    case 19:
                        b.f3257b.setChecked(true);
                        b.f3257b.setBackgroundResource(R.drawable.off);
                        break;
                    case 20:
                        b.f3257b.setChecked(false);
                        b.f3257b.setBackgroundResource(R.drawable.on);
                        break;
                    case Place.TYPE_LOCALITY /* 1009 */:
                        int i = message.arg1;
                        CLog.a("IOTA", " main handler :: " + i);
                        switch (i) {
                            case 4:
                                Toast.makeText(MainActivity.this, "QR code has expired. Try refreshing the web page and scan again.", 0).show();
                                break;
                            case 6:
                                Toast.makeText(MainActivity.this, "Your session has expired. Try refreshing the web page and scan again.", 0).show();
                                break;
                            case 10:
                                Toast.makeText(MainActivity.this, "Your session has expired. Try refreshing the web page and scan again.", 0).show();
                                break;
                        }
                        MainActivity.this.r();
                        break;
                    case 14596:
                        MainActivity.this.L = (Rect) message.obj;
                        break;
                }
                MainActivity.this.r.notifyDataSetChanged();
            }
        };
        h.f3470d = this.C;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CLog.a("IOTA", "on destroy");
        h.k = false;
        h.m = null;
        if (this.v != null) {
            try {
                unbindService(this.v);
            } catch (IllegalArgumentException e2) {
            }
        }
        if (!h.f3467a) {
            s();
            t();
        }
        if (this.g != null) {
            this.g.cancel(true);
        }
        try {
            unregisterReceiver(this.q);
        } catch (Exception e3) {
            CLog.d("IOTA", "> " + e3.getMessage());
        }
        if (h.f3467a && com.cube26.iota.smartlite.VirtualLite.a.a().d()) {
            com.cube26.iota.smartlite.VirtualLite.a.a().c();
        }
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onError(int i, l<com.google.a.l> lVar) {
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onFailure(Throwable th) {
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (h.f3467a && menuItem.getItemId() == 16908332) {
            h.a(this);
            return true;
        }
        if (this.y.a(menuItem)) {
            return true;
        }
        CLog.a("IOTA", "item id ::" + menuItem.getItemId());
        switch (menuItem.getItemId()) {
            case 1234:
                FlurryAgent.logEvent("rhythm_play_opened_menu");
                CLog.a("IOTA", "Going to neon music ::");
                this.l = findViewById(menuItem.getItemId());
                new MaterialShowcaseView.a(this).a(this.l).a("Neon").a(new uk.co.deanwild.materialshowcaseview.d() { // from class: com.cube26.iota.smartlite.MainActivity.28
                    @Override // uk.co.deanwild.materialshowcaseview.d
                    public void a(MaterialShowcaseView materialShowcaseView) {
                    }

                    @Override // uk.co.deanwild.materialshowcaseview.d
                    public void b(MaterialShowcaseView materialShowcaseView) {
                        MainActivity.this.j.putBoolean("NeonTut", true);
                        MainActivity.this.j.commit();
                        MainActivity.this.i();
                    }
                }).a((CharSequence) "Got It").a(getResources().getColor(R.color.navtabselectedcolor)).b("Easy way to switch between Reos Music which can be used to sync the color of Lite with the beats").b();
                if (this.i.getBoolean("NeonTut", false)) {
                    i();
                }
                break;
            case 1235:
                this.N = findViewById(menuItem.getItemId());
                new MaterialShowcaseView.a(this).a(this.N).a("Reos").a(new uk.co.deanwild.materialshowcaseview.d() { // from class: com.cube26.iota.smartlite.MainActivity.26
                    @Override // uk.co.deanwild.materialshowcaseview.d
                    public void a(MaterialShowcaseView materialShowcaseView) {
                    }

                    @Override // uk.co.deanwild.materialshowcaseview.d
                    public void b(MaterialShowcaseView materialShowcaseView) {
                        MainActivity.this.j.putBoolean("VirtualModeExit", true).commit();
                    }
                }).a((CharSequence) "Got It").a(getResources().getColor(R.color.navtabselectedcolor)).b("You can exit the virtual mode from here and start using your lites.").b();
                if (this.i.getBoolean("VirtualModeExit", false)) {
                    r();
                }
                break;
            case android.R.id.home:
                return true;
            case R.id.action_settings /* 2131624439 */:
                FlurryAgent.logEvent("about_us_opened");
                startActivityForResult(new Intent(this, (Class<?>) Settings.class), 5);
                break;
            case R.id.voice /* 2131624440 */:
                FlurryAgent.logEvent("mic_search");
                this.k = findViewById(R.id.voice);
                new MaterialShowcaseView.a(this).a(this.k).b("Change Lite through voice commands. Just speak the color you want.").a(new uk.co.deanwild.materialshowcaseview.d() { // from class: com.cube26.iota.smartlite.MainActivity.27
                    @Override // uk.co.deanwild.materialshowcaseview.d
                    public void a(MaterialShowcaseView materialShowcaseView) {
                    }

                    @Override // uk.co.deanwild.materialshowcaseview.d
                    public void b(MaterialShowcaseView materialShowcaseView) {
                        MainActivity.this.j.putBoolean("VoiceTut", true);
                        MainActivity.this.j.commit();
                        MainActivity.this.h();
                    }
                }).a((CharSequence) "Got it").a(getResources().getColor(R.color.navtabselectedcolor)).a("VOICE").b();
                CLog.a("IOTA", "Voice click");
                if (this.i.getBoolean("VoiceTut", false)) {
                    h();
                }
                break;
            case R.id.try_virtual_lite_menu_option /* 2131624441 */:
                if (!menuItem.getTitle().toString().equalsIgnoreCase("Exit virtual mode")) {
                    startActivity(new Intent(this, (Class<?>) TryVirtualReosLiteActivity.class));
                } else {
                    r();
                }
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.G);
        this.F = false;
        unregisterReceiver(this.m);
    }

    @Override // android.support.v7.a.f, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.y.a();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (menu.findItem(1234) == null && h.c(this).contains("com.cube26.osp.music")) {
            menu.add(0, 1234, 196608, "Reos Music").setIcon(R.drawable.neon_rhythm).setShowAsAction(2);
        }
        if (h.f3467a) {
            if (menu.findItem(1234) != null) {
                menu.removeItem(1234);
            }
            if (menu.findItem(1235) == null) {
                menu.findItem(R.id.try_virtual_lite_menu_option).setTitle("Exit virtual mode");
                menu.add(0, 1235, 1, "Exit virtual mode").setIcon(R.drawable.exit_virtual_mode_icon).setShowAsAction(2);
            }
        } else {
            if (menu.findItem(1235) != null) {
                menu.removeItem(1235);
            }
            menu.findItem(R.id.try_virtual_lite_menu_option).setTitle("Try virtual mode");
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.p, android.app.Activity, android.support.v4.app.a.InterfaceC0010a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        CLog.a("IOTA", " activity on permissions result :: " + i);
        switch (i) {
            case 105:
                if (iArr.length > 0 && iArr[0] == 0) {
                    CLog.a("IOTA", "Permission Granted :D");
                    this.J.a();
                } else {
                    CLog.a("IOTA", " permission not granted");
                    if (!shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        CLog.a("IOTA", " permission denial ");
                        android.support.v7.a.e.a aVar = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
                        aVar.a("Permission Denial");
                        aVar.b("Storage access has not been granted & we require storage access for selecting photos .Are you sure you want to deny the permission?");
                        aVar.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.6
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.fromParts("package", MainActivity.this.getPackageName(), null));
                                MainActivity.this.startActivityForResult(intent, 100);
                            }
                        });
                        aVar.b("I'M Sure", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.7
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.dismiss();
                            }
                        });
                        aVar.a(false);
                        aVar.c();
                    } else {
                        CLog.a("IOTA", " permission error");
                        android.support.v7.a.e.a aVar2 = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
                        aVar2.a("Permission Error");
                        aVar2.b("From Android M onwards, we require Storage permission to read external storage on the device. Please grant the permission for smooth functioning of the app or else you won't be able to pick photos from your phone to use it as a color palette.");
                        aVar2.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.8
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                MainActivity.this.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 105);
                            }
                        });
                        aVar2.a(false);
                        aVar2.c();
                    }
                }
                break;
            case 106:
                if (iArr.length > 0 && iArr[0] == 0) {
                    if (u()) {
                        h.p = true;
                        AutoScanConnectService.a();
                        h.w.clear();
                        this.r.b().clear();
                    } else {
                        v();
                    }
                    CLog.a("IOTA", "Permission Granted :D");
                } else if (!shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
                    android.support.v7.a.e.a aVar3 = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar3.a("Permission Denial");
                    aVar3.b("Location access has not been granted & we require location for scanning nearby Lite .Are you sure you want to deny the permission & close the app?");
                    aVar3.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.9
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", MainActivity.this.getPackageName(), null));
                            MainActivity.this.startActivityForResult(intent, 100);
                        }
                    });
                    aVar3.b("I'M Sure", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.10
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            MainActivity.this.finish();
                        }
                    });
                    aVar3.a(false);
                    aVar3.c();
                } else {
                    android.support.v7.a.e.a aVar4 = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar4.a("Permission Error");
                    aVar4.b("From Android M onwards, we require Location permission to scan nearby Bluetooth devices. Please grant the permission for smooth functioning of the app or else you won't be able to connect Lite with the smartphone.");
                    aVar4.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.11
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            MainActivity.this.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 106);
                        }
                    });
                    aVar4.a(false);
                    aVar4.c();
                }
                break;
            case 107:
                a(iArr, 1, 107);
                break;
            case 108:
                a(iArr, 2, 108);
                break;
            case 109:
                if (iArr.length > 0 && iArr[0] == 0) {
                    CLog.a("IOTA", " microphone permission granted");
                    if (d.i != null && d.i.getVisibility() == 0) {
                        d.i.setChecked(true);
                    }
                    if (d.k != null && d.k.getVisibility() == 0) {
                        d.k.setChecked(true);
                    }
                    CLog.a("IOTA", "Permission Granted :D");
                } else {
                    d.i.setChecked(false);
                    if (!shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO")) {
                        android.support.v7.a.e.a aVar5 = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
                        aVar5.a("Permission Denial");
                        aVar5.b("Microphone access has not been granted & we require microphone for audio input .Are you sure you want to deny the permission?");
                        aVar5.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.13
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.fromParts("package", MainActivity.this.getPackageName(), null));
                                MainActivity.this.startActivityForResult(intent, 100);
                            }
                        });
                        aVar5.b("I'M Sure", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.14
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.dismiss();
                            }
                        });
                        aVar5.a(false);
                        aVar5.c();
                    } else {
                        android.support.v7.a.e.a aVar6 = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
                        aVar6.a("Permission Error");
                        aVar6.b("From Android M onwards, we require microphone permission to capture audio. Please grant the permission for functioning of this feature or else you won't be able to use audio feature.");
                        aVar6.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.15
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                MainActivity.this.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 109);
                            }
                        });
                        aVar6.a(false);
                        aVar6.c();
                    }
                }
                break;
            case 110:
                if (iArr.length > 0 && iArr[0] == 0) {
                    CLog.a("IOTA", " microphone permission granted");
                    this.J.b();
                    CLog.a("IOTA", "Permission Granted :D");
                } else if (!shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                    android.support.v7.a.e.a aVar7 = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar7.a("Permission Denial");
                    aVar7.b("Camera access has not been granted & we require camera to capture photo. Are you sure you want to deny the permission?");
                    aVar7.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.19
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", MainActivity.this.getPackageName(), null));
                            MainActivity.this.startActivityForResult(intent, 100);
                        }
                    });
                    aVar7.b("I'M Sure", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.20
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar7.a(false);
                    aVar7.c();
                } else {
                    android.support.v7.a.e.a aVar8 = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar8.a("Permission Error");
                    aVar8.b("From Android M onwards, we require camera permission to capture photos. Please grant the permission for functioning of this feature or else you won't be able to use this feature.");
                    aVar8.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.21
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            MainActivity.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 110);
                        }
                    });
                    aVar8.a(false);
                    aVar8.c();
                }
                break;
            case 2002:
                if (iArr.length > 0 && iArr[0] == 0) {
                    CLog.a("IOTA", " microphone permission granted");
                    if (d.f3309f != null && d.f3309f.getVisibility() == 0) {
                        d.f3309f.setChecked(true);
                    }
                    CLog.a("IOTA", "Permission Granted :D");
                } else {
                    d.f3309f.setChecked(false);
                    if (!shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO")) {
                        android.support.v7.a.e.a aVar9 = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
                        aVar9.a("Permission Denial");
                        aVar9.b("Microphone access has not been granted & we require microphone for music sync .Are you sure you want to deny the permission?");
                        aVar9.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.16
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.fromParts("package", MainActivity.this.getPackageName(), null));
                                MainActivity.this.startActivityForResult(intent, 100);
                            }
                        });
                        aVar9.b("I'M Sure", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.17
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.dismiss();
                            }
                        });
                        aVar9.a(false);
                        aVar9.c();
                    } else {
                        android.support.v7.a.e.a aVar10 = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
                        aVar10.a("Permission Error");
                        aVar10.b("From Android M onwards, we require microphone permission to capture music. Please grant the permission for functioning of this feature or else you won't be able to use audio feature.");
                        aVar10.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.MainActivity.18
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                MainActivity.this.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 2002);
                            }
                        });
                        aVar10.a(false);
                        aVar10.c();
                    }
                }
                break;
        }
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onResume() {
        super.onResume();
        CLog.a("IOTA", " on resume");
        if (getIntent() == null || !getIntent().hasExtra("clientSessionId")) {
            n();
            if (this.F) {
                this.r.notifyDataSetChanged();
                this.x.e(3);
                if (j()) {
                    q();
                }
            }
            if (this.r.getCount() == 0) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            this.r.notifyDataSetChanged();
        }
        invalidateOptionsMenu();
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        new IntentFilter("disconnect");
        registerReceiver(this.G, intentFilter);
        registerReceiver(this.m, this.f3047c);
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onSuccess(int i, l<com.google.a.l> lVar) {
        switch (i) {
            case 1999:
                try {
                    JSONObject jSONObject = new JSONObject(lVar.e().k().toString());
                    if (jSONObject.getBoolean(Constants.SMS_COLUMN_STATUS)) {
                        String string = jSONObject.getString("message");
                        CLog.a("IOTA", " messge " + string);
                        b(string);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 10001:
                try {
                    JSONObject jSONObject2 = new JSONObject(lVar.e().k().toString());
                    String string2 = jSONObject2.getString(Constants.SMS_COLUMN_STATUS);
                    CLog.a("IOTA", "Result " + string2);
                    if (string2.equals("200")) {
                        String string3 = jSONObject2.getJSONObject(Config.RESPONSE).getString("user_id");
                        CLog.a("IOTA", "Unique id ::" + string3);
                        b(this, string3);
                        a(this, this.h);
                    } else {
                        CLog.a("IOTA", "Unique id ::null");
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
        }
    }
}
