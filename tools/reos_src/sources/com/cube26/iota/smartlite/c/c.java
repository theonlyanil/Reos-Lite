package com.cube26.iota.smartlite.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.Alerts.IncomingCallIReceiver;
import com.cube26.iota.smartlite.ModeCreation;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.UpdateMode;
import com.cube26.iota.smartlite.util.h;
import com.flurry.android.FlurryAgent;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class c extends Fragment {
    private static float D;
    private static float E;
    private static float F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f3270a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f3272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f3273d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static SensorManager f3275f;
    static Vibrator j;
    private CoordinatorLayout J;
    private float K;
    private float L;
    private float M;
    private int O;
    ListView l;
    Context m;
    FloatingActionButton n;
    SharedPreferences o;
    SharedPreferences.Editor p;
    com.cube26.iota.smartlite.a.a q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f3271b = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f3274e = "color";
    static long g = 1;
    static int h = -1;
    static int i = -1;
    private static long C = 0;
    public static SensorEventListener B = new SensorEventListener() { // from class: com.cube26.iota.smartlite.c.c.5
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float f2 = sensorEvent.values[0];
                float f3 = sensorEvent.values[1];
                float f4 = sensorEvent.values[2];
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - c.C > 150) {
                    long j2 = jCurrentTimeMillis - c.C;
                    long unused = c.C = jCurrentTimeMillis;
                    if ((Math.abs(((((f2 + f3) + f4) - c.D) - c.E) - c.F) / j2) * 10000.0f > 1350.0f) {
                        CLog.a("IOTA", "Device is shaken");
                        if (c.f3274e.equalsIgnoreCase("shake")) {
                            c.j.vibrate(100L);
                            for (int i2 = 0; i2 < h.v.size(); i2++) {
                                h.b(c.b(h.E), c.b(h.E), c.b(h.E), h.H, i2, "wheel");
                            }
                        }
                    }
                    float unused2 = c.D = f2;
                    float unused3 = c.E = f3;
                    float unused4 = c.F = f4;
                }
            }
        }
    };
    private boolean G = true;
    private int H = -1;
    private boolean I = false;
    ArrayList<com.cube26.iota.smartlite.b.d> k = new ArrayList<>();
    int r = 5000;
    int s = 200;
    int[] t = new int[6];
    int[] u = new int[3];
    int[] v = new int[3];
    int[] w = new int[3];
    int[] x = new int[3];
    int[] y = new int[3];
    int[] z = new int[3];
    boolean A = false;
    private String N = "";

    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<com.cube26.iota.smartlite.b.d> f3294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private LayoutInflater f3295c;

        /* JADX INFO: renamed from: com.cube26.iota.smartlite.c.c$a$a, reason: collision with other inner class name */
        private class C0066a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            TextView f3298a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            TextView f3299b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            ImageView f3300c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            ImageView f3301d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            ImageView f3302e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            ImageView f3303f;
            ImageView g;
            ImageView h;
            ImageView i;
            ImageView j;

            private C0066a() {
            }
        }

        a(Context context, ArrayList<com.cube26.iota.smartlite.b.d> arrayList) {
            this.f3294b = arrayList;
            this.f3295c = LayoutInflater.from(context);
            CLog.a("IOTA", "Fragment mode" + this.f3294b.size());
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f3294b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f3294b.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            View view2;
            C0066a c0066a;
            View viewInflate;
            try {
                if (view == null) {
                    viewInflate = this.f3295c.inflate(R.layout.modesitem, (ViewGroup) null);
                    try {
                        C0066a c0066a2 = new C0066a();
                        c0066a2.f3298a = (TextView) viewInflate.findViewById(R.id.modename);
                        c0066a2.f3299b = (TextView) viewInflate.findViewById(R.id.modedescription);
                        c0066a2.f3300c = (ImageView) viewInflate.findViewById(R.id.modeview);
                        c0066a2.j = (ImageView) viewInflate.findViewById(R.id.edit);
                        c0066a2.f3301d = (ImageView) viewInflate.findViewById(R.id.colorchosen1);
                        c0066a2.f3302e = (ImageView) viewInflate.findViewById(R.id.colorchosen2);
                        c0066a2.f3303f = (ImageView) viewInflate.findViewById(R.id.colorchosen3);
                        c0066a2.g = (ImageView) viewInflate.findViewById(R.id.colorchosen4);
                        c0066a2.h = (ImageView) viewInflate.findViewById(R.id.colorchosen5);
                        c0066a2.i = (ImageView) viewInflate.findViewById(R.id.colorchosen6);
                        viewInflate.setTag(c0066a2);
                        c0066a = c0066a2;
                    } catch (Exception e2) {
                        e = e2;
                        view2 = viewInflate;
                        String string = e.getStackTrace().toString();
                        for (int i2 = 0; i2 <= string.length() / 1000; i2++) {
                            int i3 = i2 * 1000;
                            int length = (i2 + 1) * 1000;
                            if (length > string.length()) {
                                length = string.length();
                            }
                            CLog.a("IOTA", string.substring(i3, length));
                        }
                        return view2;
                    }
                } else {
                    c0066a = (C0066a) view.getTag();
                    viewInflate = view;
                }
                c0066a.f3298a.setText(this.f3294b.get(i).c());
                c0066a.f3299b.setText(this.f3294b.get(i).d());
                c0066a.f3300c.setImageResource(h.S[this.f3294b.get(i).e()].intValue());
                if (this.f3294b.get(i).c().equals(c.f3272c)) {
                    viewInflate.setBackgroundColor(c.this.getResources().getColor(R.color.navtabselectedcolor));
                    c0066a.j.setVisibility(4);
                    c0066a.f3300c.setColorFilter(Color.argb(255, 255, 255, 255));
                    c0066a.f3298a.setTextColor(-1);
                    c0066a.f3299b.setTextColor(-3355444);
                } else {
                    viewInflate.setBackgroundColor(c.this.getResources().getColor(R.color.colorPrimary));
                    c0066a.j.setVisibility(0);
                    c0066a.f3300c.setColorFilter(Color.argb(255, 117, 117, 117));
                    c0066a.f3298a.setTextColor(c.this.getResources().getColor(R.color.listmodeheading));
                    c0066a.f3299b.setTextColor(c.this.getResources().getColor(R.color.listmodesubheading));
                }
                if (this.f3294b.get(i).l().equalsIgnoreCase("candle") || this.f3294b.get(i).l().equalsIgnoreCase("strobe") || this.f3294b.get(i).l().equalsIgnoreCase("kldscp")) {
                    c0066a.f3301d.setVisibility(4);
                    c0066a.f3302e.setVisibility(4);
                    c0066a.f3303f.setVisibility(4);
                    c0066a.g.setVisibility(4);
                    c0066a.h.setVisibility(4);
                    c0066a.i.setVisibility(4);
                    c0066a.j.setVisibility(4);
                } else {
                    c0066a.f3301d.setVisibility(0);
                    Drawable background = c0066a.f3301d.getBackground();
                    if (background instanceof ShapeDrawable) {
                        ((ShapeDrawable) background).getPaint().setColor(this.f3294b.get(i).f());
                    } else if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setColor(this.f3294b.get(i).f());
                    }
                    c0066a.f3302e.setVisibility(0);
                    Drawable background2 = c0066a.f3302e.getBackground();
                    if (background2 instanceof ShapeDrawable) {
                        ((ShapeDrawable) background2).getPaint().setColor(this.f3294b.get(i).g());
                    } else if (background2 instanceof GradientDrawable) {
                        ((GradientDrawable) background2).setColor(this.f3294b.get(i).g());
                    }
                    c0066a.f3303f.setVisibility(0);
                    Drawable background3 = c0066a.f3303f.getBackground();
                    if (background3 instanceof ShapeDrawable) {
                        ((ShapeDrawable) background3).getPaint().setColor(this.f3294b.get(i).h());
                    } else if (background3 instanceof GradientDrawable) {
                        ((GradientDrawable) background3).setColor(this.f3294b.get(i).h());
                    }
                    c0066a.g.setVisibility(0);
                    Drawable background4 = c0066a.g.getBackground();
                    if (background4 instanceof ShapeDrawable) {
                        ((ShapeDrawable) background3).getPaint().setColor(this.f3294b.get(i).i());
                    } else if (background4 instanceof GradientDrawable) {
                        ((GradientDrawable) background4).setColor(this.f3294b.get(i).i());
                    }
                    c0066a.h.setVisibility(0);
                    Drawable background5 = c0066a.h.getBackground();
                    if (background5 instanceof ShapeDrawable) {
                        ((ShapeDrawable) background3).getPaint().setColor(this.f3294b.get(i).j());
                    } else if (background5 instanceof GradientDrawable) {
                        ((GradientDrawable) background5).setColor(this.f3294b.get(i).j());
                    }
                    c0066a.i.setVisibility(0);
                    Drawable background6 = c0066a.i.getBackground();
                    if (background6 instanceof ShapeDrawable) {
                        ((ShapeDrawable) background6).getPaint().setColor(this.f3294b.get(i).k());
                    } else if (background6 instanceof GradientDrawable) {
                        ((GradientDrawable) background6).setColor(this.f3294b.get(i).k());
                    }
                }
                c0066a.j.setId(i);
                c0066a.j.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.c.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        HashMap map = new HashMap();
                        map.put("edit_mode_name", ((com.cube26.iota.smartlite.b.d) a.this.f3294b.get(i)).c());
                        FlurryAgent.logEvent("mode_edited", map);
                        if (((com.cube26.iota.smartlite.b.d) a.this.f3294b.get(i)).c().equals(c.f3272c)) {
                            return;
                        }
                        Intent intent = new Intent(c.this.m, (Class<?>) UpdateMode.class);
                        intent.putExtra("UpdateMood", ((com.cube26.iota.smartlite.b.d) a.this.f3294b.get(view3.getId())).c());
                        c.this.startActivityForResult(intent, 6000);
                    }
                });
                return viewInflate;
            } catch (Exception e3) {
                e = e3;
                view2 = view;
            }
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            CLog.a("IOTA", " notify data set changed");
        }
    }

    public static void a() {
        f3270a.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        h.N = true;
        com.cube26.iota.smartlite.VirtualLite.a.a().a(str + " ON\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final int i2) {
        Random random = new Random();
        if (z) {
            h.K[0] = random.nextInt(255);
            h.K[1] = random.nextInt(255);
            h.K[2] = random.nextInt(255);
            h.b(0, 0, 0, random.nextInt(200), i2, "on");
            h.J[0] = random.nextInt(255);
            h.J[1] = random.nextInt(255);
            h.J[2] = random.nextInt(255);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.cube26.iota.smartlite.c.c.4
            @Override // java.lang.Runnable
            public void run() {
                CLog.a("IOTA", "TRANSITION Activated::Strobe");
                if (h.v.get(i2).o() == null || h.v.get(i2).o() == null || !(h.v.get(i2).o().equals("1.04") || h.v.get(i2).o().equals("1.01") || h.v.get(i2).o().equals("1.02"))) {
                    h.b(c.this.u[0], c.this.u[1], c.this.u[2], c.this.s, i2, "Strobe");
                } else {
                    h.a(h.J[0], h.J[1], h.J[2], 200, i2, "wheel");
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr, int i2, String str, int i3) {
        if (str.contains(String.valueOf(i2))) {
            f3274e = "Strobe";
            h.N = true;
            h.a(iArr[0], iArr[1], iArr[2], this.s, i3, "Wheel");
            return;
        }
        f3274e = "color";
        if (Color.rgb(iArr[0], iArr[1], iArr[2]) == -1) {
            com.cube26.iota.smartlite.d.a aVar = h.v.get(i3);
            CLog.a("IOTA", " lumin " + this.s);
            if (h.f3467a) {
                if (this.O == 3) {
                    this.s -= 50;
                }
                h.b(iArr[0], iArr[1], iArr[2], this.s, i3, "Wheel");
            } else if (aVar != null && aVar.c() != null) {
                Log.d("IOTA", " lite " + aVar.c());
                if (aVar.c().equalsIgnoreCase("LITE")) {
                    h.b(iArr[0], iArr[1], iArr[2], this.s, i3, "Wheel");
                    return;
                } else {
                    h.a(iArr[0], iArr[1], iArr[2], this.s, i3, 0);
                    return;
                }
            }
        }
        h.b(iArr[0], iArr[1], iArr[2], this.s, i3, "Wheel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Random random) {
        return random.nextInt(206) + 50;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        CLog.a("IOTA", " stop virtual mode " + str);
        com.cube26.iota.smartlite.VirtualLite.a.a().a(str + " OFF\r\n");
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        CLog.a("IOTA", "on Attach");
        this.m = activity.getApplicationContext();
        this.o = this.m.getSharedPreferences("Sticky", 0);
        this.p = this.o.edit();
        this.q = new com.cube26.iota.smartlite.a.a(this.m);
        j = (Vibrator) this.m.getSystemService("vibrator");
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CLog.a("IOTA", "On Create view");
        View viewInflate = layoutInflater.inflate(R.layout.fragment_two, viewGroup, false);
        this.k = this.q.a();
        this.l = (ListView) viewInflate.findViewById(R.id.list);
        f3270a = new a(getActivity(), this.k);
        this.l.setAdapter((ListAdapter) f3270a);
        this.l.setChoiceMode(1);
        this.J = (CoordinatorLayout) viewInflate.findViewById(R.id.moodfragment);
        f3275f = (SensorManager) this.m.getSystemService("sensor");
        f3275f.registerListener(B, f3275f.getDefaultSensor(1), 3);
        this.K = BitmapDescriptorFactory.HUE_RED;
        this.L = 9.80665f;
        this.M = 9.80665f;
        this.l.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.cube26.iota.smartlite.c.c.1
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i2, long j2) {
                String string = c.this.k.get(i2).c().toString();
                CLog.a("IOTA", " mode name :: " + c.this.k.get(i2).c() + " name :: " + c.this.N);
                if (c.this.k.get(i2).l().equals("strobe") || c.this.k.get(i2).l().equals("kldscp") || c.this.k.get(i2).l().equals("candle")) {
                    Snackbar.a(c.this.J, string + " cannot be deleted", 0).a("Ok", new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.c.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                        }
                    }).a();
                    return true;
                }
                if (!c.this.k.get(i2).c().equalsIgnoreCase(c.this.N)) {
                    final Snackbar snackbarA = Snackbar.a(c.this.J, "Delete Mode ? ", 0);
                    snackbarA.a("Agree", new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.c.1.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            c.this.q.f(c.this.k.get(i2).c());
                            c.this.k.remove(i2);
                            c.f3270a.notifyDataSetChanged();
                            snackbarA.b();
                        }
                    });
                    snackbarA.a();
                    return true;
                }
                if (h.N) {
                    Snackbar.a(c.this.J, "Turn off the mode to delete. ", 0).a("Ok", new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.c.1.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                        }
                    }).a();
                    return true;
                }
                final Snackbar snackbarA2 = Snackbar.a(c.this.J, "Delete Mode ? ", 0);
                snackbarA2.a("Agree", new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.c.1.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        c.this.q.f(c.this.k.get(i2).c());
                        c.this.k.remove(i2);
                        c.f3270a.notifyDataSetChanged();
                        snackbarA2.b();
                    }
                });
                snackbarA2.a();
                return true;
            }
        });
        this.l.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.cube26.iota.smartlite.c.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (h.B == null) {
                    h.B = new Handler();
                }
                c.this.N = c.this.k.get(i2).c();
                c.this.O = c.this.k.get(i2).b();
                if (i2 != c.this.H) {
                    FlurryAgent.endTimedEvent("mode_enabled");
                    c.this.G = true;
                    if (c.this.G) {
                        HashMap map = new HashMap();
                        map.put("mode_name", c.this.N);
                        FlurryAgent.logEvent("mode_enabled", (Map<String, String>) map, true);
                        c.this.G = false;
                    } else {
                        FlurryAgent.endTimedEvent("mode_enabled");
                        c.this.G = true;
                    }
                } else if (c.this.G) {
                    HashMap map2 = new HashMap();
                    map2.put("mode_name", c.this.N);
                    FlurryAgent.logEvent("mode_enabled", (Map<String, String>) map2, true);
                    c.this.G = false;
                } else {
                    FlurryAgent.endTimedEvent("mode_enabled");
                    c.this.G = true;
                }
                c.this.H = i2;
                if (!c.this.o.getBoolean("ListView", false)) {
                    android.support.v7.a.e.a aVar = new android.support.v7.a.e.a(c.this.getActivity(), R.style.AppCompatAlertDialogStyle);
                    aVar.a("Mood");
                    aVar.b("Your Mood is activated, Tap it Again to turn it off");
                    aVar.a("OK", (DialogInterface.OnClickListener) null);
                    aVar.a(false);
                    aVar.c();
                    c.this.p.putBoolean("ListView", true);
                    c.this.p.commit();
                }
                boolean z = false;
                if (d.k != null && d.k.isChecked()) {
                    z = true;
                }
                boolean z2 = (d.i == null || !d.i.isChecked()) ? z : true;
                h.b();
                if (d.f3307d) {
                    d.f3309f.setChecked(false);
                } else {
                    h.b(0, 0, 0);
                }
                c.this.N = c.this.k.get(i2).c();
                CLog.a("IOTA", "current mode :: " + c.this.N);
                c.f3272c = c.this.k.get(i2).c();
                c.i = i2;
                c.f3271b = 0;
                if (c.f3272c.equals(c.f3273d)) {
                    try {
                        h.B.removeCallbacksAndMessages(null);
                    } catch (Exception e2) {
                        CLog.a("IOTA", " canceling handler exception");
                        e2.printStackTrace();
                    }
                    h.N = false;
                    c.f3273d = "";
                    c.f3272c = "";
                    c.this.getActivity().runOnUiThread(new Runnable() { // from class: com.cube26.iota.smartlite.c.c.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.f3270a.notifyDataSetChanged();
                        }
                    });
                    CLog.a("IOTA", "Canceling Handlers" + c.f3274e + " " + h.f3467a);
                    if (!c.f3274e.equalsIgnoreCase("candle") && !c.f3274e.equalsIgnoreCase("Strobe") && !c.f3274e.equalsIgnoreCase("CandleFlicker") && !c.f3274e.equalsIgnoreCase("Kaleidoscope")) {
                        if (c.f3274e.equalsIgnoreCase("shake")) {
                            c.f3275f.unregisterListener(c.B);
                            return;
                        }
                        return;
                    } else {
                        if (h.f3467a) {
                            c.this.b(c.f3274e);
                            return;
                        }
                        for (int i3 = 0; i3 < h.v.size(); i3++) {
                            h.b(c.this.u[0], c.this.u[1], c.this.u[2], c.this.s, i3, "PhoneCancel");
                            c.g = 0L;
                        }
                        return;
                    }
                }
                CLog.a("IOTA", "Else Handlers");
                if (c.f3274e.equalsIgnoreCase("candle") || c.f3274e.equalsIgnoreCase("Strobe") || c.f3274e.equalsIgnoreCase("Kaleidoscope")) {
                    for (int i4 = 0; i4 < h.v.size(); i4++) {
                        h.b(c.this.u[0], c.this.u[1], c.this.u[2], c.this.s, i4, "PhoneCancel");
                        c.g = 0L;
                    }
                } else if (c.f3274e.equalsIgnoreCase("shake")) {
                    c.f3275f.unregisterListener(c.B);
                }
                c.f3273d = c.f3272c;
                if (c.h != c.i) {
                    try {
                        h.B.removeCallbacksAndMessages(null);
                        h.N = false;
                    } catch (Exception e3) {
                        CLog.a("IOTA", " canceling handler 2");
                        e3.printStackTrace();
                    }
                }
                c.h = i2;
                c.this.getActivity().runOnUiThread(new Runnable() { // from class: com.cube26.iota.smartlite.c.c.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.f3270a.notifyDataSetChanged();
                    }
                });
                if (c.this.k.get(i2).f() != 0) {
                    c.f3271b++;
                    c.this.t[0] = c.this.k.get(i2).f();
                    c.this.u = h.a(c.this.t[0]);
                }
                if (c.this.k.get(i2).g() != 0) {
                    c.f3271b++;
                    c.this.t[1] = c.this.k.get(i2).g();
                    c.this.v = h.a(c.this.t[1]);
                }
                if (c.this.k.get(i2).h() != 0) {
                    c.f3271b++;
                    c.this.t[2] = c.this.k.get(i2).h();
                    c.this.w = h.a(c.this.t[2]);
                }
                if (c.this.k.get(i2).i() != 0) {
                    c.f3271b++;
                    c.this.t[3] = c.this.k.get(i2).i();
                    c.this.x = h.a(c.this.t[3]);
                }
                if (c.this.k.get(i2).j() != 0) {
                    c.f3271b++;
                    c.this.t[4] = c.this.k.get(i2).j();
                    c.this.y = h.a(c.this.t[4]);
                }
                if (c.this.k.get(i2).k() != 0) {
                    c.f3271b++;
                    c.this.t[5] = c.this.k.get(i2).k();
                    c.this.z = h.a(c.this.t[5]);
                }
                if (c.this.k.get(i2).n() == 0) {
                    c.this.r = 300;
                }
                if (c.this.k.get(i2).n() == 10) {
                    c.this.r = 1000;
                } else if (c.this.k.get(i2).n() == 20) {
                    c.this.r = CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
                } else if (c.this.k.get(i2).n() == 30) {
                    c.this.r = CommonStatusCodes.AUTH_API_INVALID_CREDENTIALS;
                } else if (c.this.k.get(i2).n() == 40) {
                    c.this.r = 4000;
                } else if (c.this.k.get(i2).n() == 50) {
                    c.this.r = 5000;
                } else if (c.this.k.get(i2).n() == 60) {
                    c.this.r = 6000;
                } else if (c.this.k.get(i2).n() == 70) {
                    c.this.r = 7000;
                } else if (c.this.k.get(i2).n() == 80) {
                    c.this.r = 8000;
                } else if (c.this.k.get(i2).n() == 90) {
                    c.this.r = 9000;
                } else if (c.this.k.get(i2).n() == 100) {
                    c.this.r = 10000;
                }
                if (c.this.k.get(i2).m() == 0) {
                    c.this.s = 80;
                } else if (c.this.k.get(i2).m() == 10) {
                    c.this.s = 100;
                } else if (c.this.k.get(i2).m() == 20) {
                    c.this.s = 120;
                } else if (c.this.k.get(i2).m() == 30) {
                    c.this.s = 140;
                } else if (c.this.k.get(i2).m() == 40) {
                    c.this.s = 160;
                } else if (c.this.k.get(i2).m() == 50) {
                    c.this.s = 180;
                } else if (c.this.k.get(i2).m() == 60) {
                    c.this.s = 200;
                } else if (c.this.k.get(i2).m() == 70) {
                    c.this.s = 140;
                } else if (c.this.k.get(i2).m() == 80) {
                    c.this.s = 160;
                } else if (c.this.k.get(i2).m() == 90) {
                    c.this.s = 180;
                } else if (c.this.k.get(i2).m() == 100) {
                    c.this.s = 200;
                }
                for (int i5 = 0; i5 < h.v.size(); i5++) {
                    if (c.this.k.get(i2).l().equalsIgnoreCase("candle")) {
                        CLog.a("IOTA", "TRANSITION Activated::candle");
                        if (h.f3467a) {
                            c.f3274e = "CandleFlicker";
                            c.this.a("CandleFlicker");
                            return;
                        }
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e4) {
                            e4.printStackTrace();
                        }
                        if (z2) {
                            int[] iArr = h.K;
                            int[] iArr2 = h.K;
                            h.K[2] = 255;
                            iArr2[1] = 255;
                            iArr[0] = 255;
                            h.b(0, 0, 0, 200, i5, "on");
                            try {
                                Thread.sleep(100L);
                            } catch (InterruptedException e5) {
                                e5.printStackTrace();
                            }
                        }
                        h.b(c.this.u[0], c.this.u[1], c.this.u[2], 200, i5, "Candle Flicker");
                        c.f3274e = "candle";
                        h.N = true;
                    } else if (c.this.k.get(i2).l().equalsIgnoreCase("strobe")) {
                        if (h.f3467a) {
                            c.f3274e = "Strobe";
                            c.this.a("Strobe");
                            return;
                        }
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e6) {
                            e6.printStackTrace();
                        }
                        c.this.a(z2, i5);
                        c.f3274e = "Strobe";
                        h.N = true;
                    } else if (c.this.k.get(i2).l().equalsIgnoreCase("kldscp")) {
                        if (h.f3467a) {
                            c.f3274e = "Kaleidoscope";
                            c.this.a("Kaleidoscope");
                            return;
                        }
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e7) {
                            e7.printStackTrace();
                        }
                        if (z2) {
                            int[] iArr3 = h.K;
                            int[] iArr4 = h.K;
                            h.K[2] = 255;
                            iArr4[1] = 255;
                            iArr3[0] = 255;
                            h.b(0, 0, 0, 200, i5, "on");
                            try {
                                Thread.sleep(200L);
                            } catch (InterruptedException e8) {
                                e8.printStackTrace();
                            }
                        }
                        CLog.a("IOTA", "TRANSITION Activated::Kaleidoscope");
                        h.b(c.this.u[0], c.this.u[1], c.this.u[2], 200, i5, "Kaleidoscope");
                        c.f3274e = "Kaleidoscope";
                        h.N = true;
                    } else if (c.this.k.get(i2).c().equalsIgnoreCase("Shake")) {
                        CLog.a("IOTA", "Shake Mode::Activated");
                        c.f3274e = "Shake";
                        c.f3275f.registerListener(c.B, c.f3275f.getDefaultSensor(1), 3);
                        h.N = true;
                    }
                }
                if (b.f3259d.equals("off")) {
                    b.f3257b.setChecked(false);
                    b.f3257b.setBackgroundResource(R.drawable.on);
                }
                if (c.f3271b > 0) {
                    h.N = true;
                    if (c.this.k.get(i2).l().equalsIgnoreCase("color")) {
                        CLog.a("IOTA", " init cancel handler");
                        c.f3274e = "color";
                        final String strA = c.this.k.get(i2).a();
                        CLog.a("IOTA", " strobeSetPos :: " + strA);
                        h.B.postDelayed(new Runnable() { // from class: com.cube26.iota.smartlite.c.c.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                h.B.postDelayed(this, c.this.r);
                                CLog.a("IOTA", "Iterating ::" + c.f3271b);
                                if (IncomingCallIReceiver.f2954c) {
                                    c.this.A = true;
                                    return;
                                }
                                for (int i6 = 0; i6 < h.v.size(); i6++) {
                                    if (c.this.A) {
                                        h.b(c.this.u[0], c.this.u[1], c.this.u[2], c.this.s, i6, "off");
                                        c.this.A = false;
                                    }
                                    if (c.f3271b == 1) {
                                        c.this.a(c.this.u, 0, strA, i6);
                                        CLog.a("IOTA", "Timer mod 0 ::" + c.g);
                                    } else if (c.f3271b == 2) {
                                        if (c.g % 2 == 0) {
                                            c.this.a(c.this.u, 0, strA, i6);
                                            CLog.a("IOTA", "Timer mod 0 ::" + c.g);
                                        }
                                        if (c.g % 2 == 1) {
                                            c.this.a(c.this.v, 1, strA, i6);
                                            CLog.a("IOTA", "Timer mod 1 ::" + c.g);
                                        }
                                    } else if (c.f3271b == 3) {
                                        if (c.g % 3 == 0) {
                                            c.this.a(c.this.u, 0, strA, i6);
                                            CLog.a("IOTA", "Timer mod 0 ::" + c.g);
                                        }
                                        if (c.g % 3 == 1) {
                                            c.this.a(c.this.v, 1, strA, i6);
                                            CLog.a("IOTA", "Timer mod 1 ::" + c.g);
                                        }
                                        if (c.g % 3 == 2) {
                                            c.this.a(c.this.w, 2, strA, i6);
                                            CLog.a("IOTA", "Timer mod 2 ::" + c.g);
                                        }
                                    } else if (c.f3271b == 4) {
                                        if (c.g % 4 == 0) {
                                            c.this.a(c.this.u, 0, strA, i6);
                                            CLog.a("IOTA", "Timer mod 0 ::" + c.g);
                                        }
                                        if (c.g % 4 == 1) {
                                            c.this.a(c.this.v, 1, strA, i6);
                                            CLog.a("IOTA", "Timer mod 1 ::" + c.g);
                                        }
                                        if (c.g % 4 == 2) {
                                            c.this.a(c.this.w, 2, strA, i6);
                                            CLog.a("IOTA", "Timer mod 2 ::" + c.g);
                                        }
                                        if (c.g % 4 == 3) {
                                            c.this.a(c.this.x, 3, strA, i6);
                                            CLog.a("IOTA", "Timer mod 3 ::" + c.g);
                                        }
                                    } else if (c.f3271b == 5) {
                                        if (c.g % 5 == 0) {
                                            c.this.a(c.this.u, 0, strA, i6);
                                            CLog.a("IOTA", "Timer mod 0 ::" + c.g);
                                        }
                                        if (c.g % 5 == 1) {
                                            c.this.a(c.this.v, 1, strA, i6);
                                            CLog.a("IOTA", "Timer mod 1 ::" + c.g);
                                        }
                                        if (c.g % 5 == 2) {
                                            c.this.a(c.this.w, 2, strA, i6);
                                            CLog.a("IOTA", "Timer mod 2 ::" + c.g);
                                        }
                                        if (c.g % 5 == 3) {
                                            c.this.a(c.this.x, 3, strA, i6);
                                            CLog.a("IOTA", "Timer mod 3 ::" + c.g);
                                        }
                                        if (c.g % 5 == 4) {
                                            c.this.a(c.this.y, 4, strA, i6);
                                            CLog.a("IOTA", "Timer mod 4 ::" + c.g);
                                        }
                                    } else if (c.f3271b == 6) {
                                        if (c.g % 6 == 0) {
                                            c.this.a(c.this.u, 0, strA, i6);
                                            CLog.a("IOTA", "Timer mod 0 ::" + c.g);
                                        }
                                        if (c.g % 6 == 1) {
                                            c.this.a(c.this.v, 1, strA, i6);
                                            CLog.a("IOTA", "Timer mod 1 ::" + c.g);
                                        }
                                        if (c.g % 6 == 2) {
                                            c.this.a(c.this.w, 2, strA, i6);
                                            CLog.a("IOTA", "Timer mod 2 ::" + c.g);
                                        }
                                        if (c.g % 6 == 3) {
                                            c.this.a(c.this.x, 3, strA, i6);
                                            CLog.a("IOTA", "Timer mod 3 ::" + c.g);
                                        }
                                        if (c.g % 6 == 4) {
                                            c.this.a(c.this.y, 4, strA, i6);
                                            CLog.a("IOTA", "Timer mod 4 ::" + c.g);
                                        }
                                        if (c.g % 6 == 5) {
                                            c.this.a(c.this.z, 5, strA, i6);
                                            CLog.a("IOTA", "Timer mod 5 ::" + c.g);
                                        }
                                    }
                                }
                                c.g++;
                            }
                        }, c.this.r);
                    }
                }
            }
        });
        this.n = (FloatingActionButton) viewInflate.findViewById(R.id.normal_plus);
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CLog.a("IOTA", "Adding personalized Mode");
                FlurryAgent.logEvent("create_new_mode_opened");
                c.this.startActivity(new Intent(c.this.m, (Class<?>) ModeCreation.class));
            }
        });
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        f3270a.notifyDataSetChanged();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        CLog.a("IOTA", "Fragment is shown in on Start");
        if (f3270a == null || !this.q.getWritableDatabase().isOpen()) {
            return;
        }
        this.k = this.q.a();
        f3270a = new a(getActivity(), this.k);
        this.l.setAdapter((ListAdapter) f3270a);
        f3270a.notifyDataSetChanged();
        CLog.a("IOTA", "Fragment is shown");
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        CLog.a("IOTA", "Fragment is shown in on Stop");
    }
}
