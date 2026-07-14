package com.cube26.iota.smartlite.c;

import a.a.a.b.g;
import a.a.a.b.i;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.audiofx.Visualizer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.neonmusic.visualizer.VisualizerView;
import com.cube26.iota.smartlite.util.h;
import com.flurry.android.Constants;
import com.flurry.android.FlurryAgent;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.l;
import com.github.mikephil.charting.data.m;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class d extends Fragment {
    private static Activity A;
    private static boolean B;
    private static Handler C;
    private static LineChart E;
    private static a.a.a.a F;
    private static a.a.a.c G;
    private static HandlerThread H;
    private static Visualizer I;
    private static int J;
    private static float[] K;
    private static com.cube26.iota.smartlite.util.f L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LinearLayout f3304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static LinearLayout f3305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static LinearLayout f3306c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Button f3308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Switch f3309f;
    static Context g;
    static Button h;
    public static Switch i;
    public static Switch k;
    static int l;
    static boolean m;
    public static int u;
    private LinearLayout D;
    String p;
    Button q;
    private long w;
    private long x;
    private RelativeLayout y;
    private LinearLayout z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f3307d = true;
    public static final BroadcastReceiver n = new BroadcastReceiver() { // from class: com.cube26.iota.smartlite.c.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("cube26.musicplayer.intentplaypause") || intent.getExtras() == null) {
                return;
            }
            d.f3307d = intent.getExtras().getBoolean("cube26.musicplayer.pauseaction");
        }
    };
    public static final BroadcastReceiver o = new BroadcastReceiver() { // from class: com.cube26.iota.smartlite.c.d.6
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("cube26.musicplayer.intentcolor") || intent.getExtras() == null) {
                return;
            }
            d.l = intent.getExtras().getInt("cube26.musicplayer.colorname");
            d.m = intent.getExtras().getBoolean("cube26.musicplayer.strokeeffect");
            CLog.a("IOTA", " enable strobe " + d.m);
            if (d.f3307d || !d.f3309f.isChecked() || h.N) {
                return;
            }
            for (int i2 = 0; i2 < h.v.size(); i2++) {
                if (d.l == -256) {
                    if (!d.m) {
                        h.b(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 25, i2, "wheel");
                    } else if (h.v.get(i2) != null && h.v.get(i2).o() != null && h.v.get(i2).o().equals("1.04")) {
                        h.a(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 25, i2, "wheel");
                    }
                } else if (d.l == -65536) {
                    if (!d.m) {
                        h.b(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 15, i2, "wheel");
                    } else if (h.v.get(i2) != null && h.v.get(i2).o() != null && h.v.get(i2).o().equals("1.04")) {
                        h.a(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 15, i2, "wheel");
                    }
                } else if (d.l == -16711936) {
                    if (!d.m) {
                        h.b(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 75, i2, "wheel");
                    } else if (h.v.get(i2) != null && h.v.get(i2).o() != null && h.v.get(i2).o().equals("1.04")) {
                        h.a(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 75, i2, "wheel");
                    }
                } else if (d.l == -16776961) {
                    if (!d.m) {
                        h.b(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 100, i2, "wheel");
                    } else if (h.v.get(i2) != null && h.v.get(i2).o() != null && h.v.get(i2).o().equals("1.04")) {
                        h.a(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 100, i2, "wheel");
                    }
                } else if (d.l == -16711681) {
                    if (!d.m) {
                        h.b(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 50, i2, "wheel");
                    } else if (h.v.get(i2) != null && h.v.get(i2).o() != null && h.v.get(i2).o().equals("1.04")) {
                        h.a(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 50, i2, "wheel");
                    }
                } else if (d.l == -65281) {
                    if (!d.m) {
                        h.b(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 125, i2, "wheel");
                    } else if (h.v.get(i2) != null && h.v.get(i2).o() != null && h.v.get(i2).o().equals("1.04")) {
                        h.a(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 125, i2, "wheel");
                    }
                } else if (d.l == -458804) {
                    if (!d.m) {
                        h.b(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 140, i2, "wheel");
                    } else if (h.v.get(i2) != null && h.v.get(i2).o() != null && h.v.get(i2).o().equals("1.04")) {
                        h.a(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 140, i2, "wheel");
                    }
                } else if (d.l == -12344977) {
                    if (!d.m) {
                        h.b(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 165, i2, "wheel");
                    } else if (h.v.get(i2) != null && h.v.get(i2).o() != null && h.v.get(i2).o().equals("1.04")) {
                        h.a(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 165, i2, "wheel");
                    }
                } else if (d.l == -13064) {
                    if (!d.m) {
                        h.b(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 185, i2, "wheel");
                    } else if (h.v.get(i2) != null && h.v.get(i2).o() != null && h.v.get(i2).o().equals("1.04")) {
                        h.a(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 185, i2, "wheel");
                    }
                } else if (d.l == -10496) {
                    if (!d.m) {
                        h.b(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 195, i2, "wheel");
                    } else if (h.v.get(i2) != null && h.v.get(i2).o() != null && h.v.get(i2).o().equals("1.04")) {
                        h.a(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 195, i2, "wheel");
                    }
                } else if (!d.m) {
                    h.b(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 200, i2, "wheel");
                } else if (h.v.get(i2) != null && h.v.get(i2).o() != null && h.v.get(i2).o().equals("1.04")) {
                    h.a(h.a(d.l)[0], h.a(d.l)[1], h.a(d.l)[2], 200, i2, "wheel");
                }
            }
        }
    };
    static float s = -1.0f;
    protected static final short[] t = new short[Place.TYPE_SUBLOCALITY_LEVEL_2];
    private static int[] M = {16711680, 16744448, 16776960, 8453888, 65280, 65408, 65535, 33023, 255, 8388863, 16711935, 16711808};
    private static double N = 0.0d;
    public static final BroadcastReceiver v = new BroadcastReceiver() { // from class: com.cube26.iota.smartlite.c.d.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CLog.a("IOTA", " effect receiver Intent action" + intent.getAction());
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("cube26.musicplayer.intentaction") || intent.getExtras() == null) {
                return;
            }
            CLog.a("IOTA", "Getting byte array of data");
            try {
                CLog.a("IOTA", " has extra " + intent.hasExtra("cube26.musicplayer.media_session_id"));
                if (intent.hasExtra("cube26.musicplayer.media_session_id")) {
                    d.u = intent.getIntExtra("cube26.musicplayer.media_session_id", -1);
                    CLog.a("IOTA", " media session id  :: " + d.u);
                    com.cube26.iota.smartlite.util.f unused = d.L = new com.cube26.iota.smartlite.util.f(-72.17907406590533d, 400, 2.0d);
                    d.c(d.u);
                } else {
                    intent.getExtras().getByteArray("cube26.musicplayer.bytestream");
                    if (h.G == 1 && intent.getExtras().getByteArray("cube26.musicplayer.bytestream") != null) {
                        h.I.a(intent.getExtras().getByteArray("cube26.musicplayer.bytestream"));
                    }
                }
                d.f3308e.setText(intent.getExtras().getString("cube26.musicplayer.songname"));
            } catch (Exception e2) {
                CLog.a("IOTA", "exception");
                e2.printStackTrace();
            }
        }
    };
    public boolean j = false;
    boolean r = false;

    private static class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            CLog.a("IOTA", " device scan thread on looper prepared");
            Handler unused = d.C = new Handler(getLooper()) { // from class: com.cube26.iota.smartlite.c.d.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                }
            };
            d.C.post(d.F);
        }
    }

    public static void a() {
        q();
        try {
            g.unregisterReceiver(o);
            g.unregisterReceiver(v);
            g.unregisterReceiver(n);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    private static void a(double d2) {
        CLog.a("IOTA", "scale :: " + d2);
        if (N >= 11.0d) {
            N = 0.0d;
        }
        N += 0.1d;
        int i2 = M[(int) N];
        if (d2 < 30.0d) {
            for (int i3 = 0; i3 < h.v.size(); i3++) {
                h.b(0, 0, 0, h.H, i3, "off");
            }
            return;
        }
        double dNextInt = (d2 <= 30.0d || d2 >= 50.0d) ? (d2 <= 50.0d || d2 >= 100.0d) ? 20.0d + d2 : ((double) new Random().nextInt(50)) + d2 : d2 / 2.0d;
        CLog.a("metertable", " scale : " + dNextInt);
        if (h.f3467a) {
            h.b(Color.red(i2), Color.green(i2), Color.blue(i2), (int) dNextInt, 0, "wheel");
            return;
        }
        for (int i4 = 0; i4 < h.v.size(); i4++) {
            h.a(Color.red(i2), Color.green(i2), Color.blue(i2), (int) dNextInt, i4, 1, "", "Fade in");
        }
    }

    public static void a(float f2) {
        CLog.a("IOTA", "Flash pitch" + f2);
        for (int i2 = 0; i2 < h.v.size(); i2++) {
            h.a(0, 0, 0, h.H, i2, "phone", "Flash Alert");
        }
    }

    public static void a(float f2, float f3) {
        int[] iArrA = h.a(f3);
        CLog.a("IOTA", "pitch color :: " + iArrA[0] + "G:" + iArrA[1] + "B:" + iArrA[2]);
        CLog.a("IOTA", "pitch" + f2);
        for (int i2 = 0; i2 < h.v.size(); i2++) {
            h.b(iArrA[0], iArrA[1], iArrA[2], h.H, i2, "wheel");
        }
    }

    private static float[] a(byte[] bArr, int i2, float[] fArr, int i3, int i4) {
        int i5 = 0;
        while (i5 < i4) {
            fArr[i3] = ((bArr[i2] & Constants.UNKNOWN) - 127) * 0.007874016f;
            i5++;
            i3++;
            i2++;
        }
        return fArr;
    }

    public static void b() {
        try {
            if (b.f3259d.equals("off")) {
                b.f3257b.setChecked(false);
                b.f3257b.setBackgroundResource(R.drawable.on);
            }
            g.registerReceiver(v, new IntentFilter(String.valueOf("cube26.musicplayer.intentaction")));
            g.registerReceiver(n, new IntentFilter(String.valueOf("cube26.musicplayer.intentplaypause")));
            g.registerReceiver(o, new IntentFilter(String.valueOf("cube26.musicplayer.intentcolor")));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2, float f2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add((i3 + 1990) + "");
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < i2; i4++) {
            arrayList2.add(new Entry(((float) (((double) (1.0f + f2)) * Math.random())) + 20.0f, i4));
        }
        m mVar = new m(arrayList2, "DataSet 1");
        mVar.c(true);
        mVar.b(0.2f);
        mVar.b(false);
        mVar.d(1.8f);
        mVar.c(4.0f);
        mVar.h(A.getResources().getColor(R.color.navtabselectedcolor));
        mVar.a(Color.rgb(255, 255, 255));
        mVar.e(A.getResources().getColor(R.color.navtabselectedcolor));
        mVar.i(A.getResources().getColor(R.color.navtabselectedcolor));
        mVar.j(100);
        mVar.d(false);
        mVar.a(new com.github.mikephil.charting.d.e() { // from class: com.cube26.iota.smartlite.c.d.8
            @Override // com.github.mikephil.charting.d.e
            public float a(m mVar2, com.github.mikephil.charting.f.f fVar) {
                return -10.0f;
            }
        });
        l lVar = new l(arrayList, mVar);
        lVar.a(9.0f);
        lVar.a(false);
        E.setData(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Intent intent = new Intent("notify_music_sync_filter");
        intent.putExtra("notify_music_sync_flag", z);
        getActivity().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(byte[] bArr) {
        double d2 = 0.0d;
        try {
            K = new float[bArr.length];
            K = a(bArr, 0, K, 0, bArr.length);
            for (float f2 : K) {
                d2 = f2 * f2;
            }
            a(L.a(Math.log10(Math.sqrt(d2 / 1024.0d)) * 20.0d) * 1000.0d);
        } catch (Exception e2) {
            CLog.a("IOTA", " error ");
        }
    }

    public static void c() {
        CLog.a("IOTA", "setUpAudioDispatcherLayout");
        B = true;
        E.b(BitmapDescriptorFactory.HUE_RED, 20.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        E.setBackgroundColor(Color.rgb(248, 247, 247));
        E.getXAxis().b(false);
        E.getAxisRight().b(false);
        E.getLegend().b(false);
        E.setNoDataText("");
        E.setBorderColor(Color.rgb(248, 247, 247));
        E.setBorderWidth(BitmapDescriptorFactory.HUE_RED);
        E.setDescription("");
        E.setPinchZoom(false);
        E.setNoDataTextDescription("");
        E.setGridBackgroundColor(Color.rgb(248, 247, 247));
        E.offsetTopAndBottom(0);
        E.setDrawGridBackground(true);
        E.setBackgroundColor(Color.rgb(248, 247, 247));
        E.setBorderColor(Color.rgb(248, 247, 247));
        E.getAxisLeft().a(false);
        E.setDoubleTapToZoomEnabled(false);
        E.setScaleEnabled(false);
        E.getXAxis().h();
        E.getAxisLeft().h();
        E.getAxisRight().h();
        E.invalidate();
        if (G == null) {
            G = new i(i.a.FFT_YIN, 22050.0f, Place.TYPE_SUBLOCALITY_LEVEL_2, new a.a.a.b.f() { // from class: com.cube26.iota.smartlite.c.d.7
                @Override // a.a.a.b.f
                public void a(g gVar, a.a.a.b bVar) {
                    final float fA = gVar.a();
                    d.A.runOnUiThread(new Runnable() { // from class: com.cube26.iota.smartlite.c.d.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.s = BitmapDescriptorFactory.HUE_RED;
                            d.b(60, (int) fA);
                            d.E.invalidate();
                            if (fA < BitmapDescriptorFactory.HUE_RED) {
                                for (int i2 = 0; i2 < h.v.size(); i2++) {
                                    h.b(0, 0, 0, h.H, i2, "off");
                                }
                                return;
                            }
                            if (fA > BitmapDescriptorFactory.HUE_RED && fA < 50.0f) {
                                d.s = (fA * 4.0f) + 245.0f;
                                d.a(fA, d.s);
                                return;
                            }
                            if (fA >= 50.0f && fA < 120.0f) {
                                d.s = (fA * 4.0f) + 150.0f;
                                d.a(fA, d.s);
                                return;
                            }
                            if (fA >= 120.0f && fA < 200.0f) {
                                d.s = (fA * 3.0f) + 50.0f;
                                d.a(fA, d.s);
                                return;
                            }
                            if (fA >= 200.0f && fA < 300.0f) {
                                d.s = (fA * 2.0f) - 30.0f;
                                d.a(fA, d.s);
                            } else if (fA >= 300.0f && fA < 380.0f) {
                                d.s = (fA * 2.0f) - 130.0f;
                                d.a(fA, d.s);
                            } else if (fA >= 782.0f) {
                                d.a(fA);
                            } else {
                                d.a(fA, fA);
                            }
                        }
                    });
                }
            });
        }
        if (F == null) {
            F = a.a.a.a.a.b.a(22050, Place.TYPE_SUBLOCALITY_LEVEL_2, 0);
            F.a(G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i2) {
        CLog.a("IOTA", "initMusicVisualizer");
        q();
        if (I == null) {
            I = new Visualizer(i2);
            I.setEnabled(false);
            I.setScalingMode(0);
            I.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);
            I.setDataCaptureListener(new Visualizer.OnDataCaptureListener() { // from class: com.cube26.iota.smartlite.c.d.4
                @Override // android.media.audiofx.Visualizer.OnDataCaptureListener
                public void onFftDataCapture(Visualizer visualizer, byte[] bArr, int i3) {
                }

                @Override // android.media.audiofx.Visualizer.OnDataCaptureListener
                public void onWaveFormDataCapture(Visualizer visualizer, byte[] bArr, int i3) {
                    CLog.a("IOTA", " on waveform data capture ");
                    CLog.a("IOTA", " timestamp " + d.J);
                    d.J += 100;
                    if (d.J == 1000000) {
                        int unused = d.J = 0;
                    }
                    if (d.J % 1000 == 0) {
                        CLog.a("IOTA", " updating ");
                        h.I.a(bArr);
                    }
                    d.b(bArr);
                }
            }, Visualizer.getMaxCaptureRate() / 2, true, false);
            I.setEnabled(true);
        }
    }

    public static void d() {
        H = new a("AudioDispatcherThread");
        H.start();
    }

    public static void e() {
        try {
            if (F != null) {
                C.removeCallbacksAndMessages(null);
                H.quit();
                H = null;
                F.a();
                F.b(G);
                G = null;
                F = null;
            }
        } catch (IllegalStateException e2) {
        }
    }

    private void l() {
        m();
        try {
            if (h.I.isEnabled()) {
                h.I.setEnabled(false);
            }
            n();
        } catch (Exception e2) {
        }
    }

    private void m() {
        if (com.cube26.iota.smartlite.neonmusic.b.a(g)) {
        }
    }

    private void n() {
        Paint paint = new Paint();
        paint.setStrokeWidth(42.0f);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.argb(55, 69, 55, 200));
        h.I.a(new com.cube26.iota.smartlite.neonmusic.visualizer.a.a(16, paint, false, g));
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(12.0f);
        paint2.setAntiAlias(true);
        paint2.setColor(Color.argb(200, 185, 201, 200));
        h.I.a(new com.cube26.iota.smartlite.neonmusic.visualizer.a.a(4, paint2, true, g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        new Handler().postDelayed(new Runnable() { // from class: com.cube26.iota.smartlite.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                Random random = new Random();
                for (int i2 = 0; i2 < h.v.size(); i2++) {
                    int[] iArr = h.K;
                    int[] iArr2 = h.J;
                    int iNextInt = random.nextInt(255);
                    iArr2[0] = iNextInt;
                    iArr[0] = iNextInt;
                    int[] iArr3 = h.K;
                    int[] iArr4 = h.J;
                    int iNextInt2 = random.nextInt(255);
                    iArr4[1] = iNextInt2;
                    iArr3[1] = iNextInt2;
                    int[] iArr5 = h.K;
                    int[] iArr6 = h.J;
                    int iNextInt3 = random.nextInt(255);
                    iArr6[2] = iNextInt3;
                    iArr5[2] = iNextInt3;
                    h.b(0, 0, 0, random.nextInt(200), i2, "on");
                }
            }
        }, 100L);
    }

    private void p() {
        this.p = h.c(g);
        if (this.p.contains("com.cube26.osp.music")) {
            f3305b.setVisibility(8);
            f3304a.setVisibility(0);
            this.y.setVisibility(8);
        } else {
            f3305b.setVisibility(0);
            f3304a.setVisibility(8);
            B = false;
            this.y.setVisibility(0);
        }
    }

    private static void q() {
        CLog.a("IOTA", " disable visualizer ");
        if (I != null) {
            I.setEnabled(false);
            I.release();
            I = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        A = getActivity();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        g = activity.getApplicationContext();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View viewInflate = layoutInflater.inflate(R.layout.fragment_three, viewGroup, false);
        this.p = h.c(g);
        CLog.a("IOTA", "Installed Apps list" + this.p);
        f3305b = (LinearLayout) viewInflate.findViewById(R.id.uninstall_container);
        f3304a = (LinearLayout) viewInflate.findViewById(R.id.musiccontainer);
        h = (Button) viewInflate.findViewById(R.id.playnow);
        f3308e = (Button) viewInflate.findViewById(R.id.currenttrackname);
        f3309f = (Switch) viewInflate.findViewById(R.id.syncmusic);
        f3306c = (LinearLayout) viewInflate.findViewById(R.id.play_music_layout);
        i = (Switch) viewInflate.findViewById(R.id.syncMicrophone);
        this.D = (LinearLayout) viewInflate.findViewById(R.id.mic_input_view);
        this.y = (RelativeLayout) viewInflate.findViewById(R.id.un_sync_mic_layout);
        k = (Switch) viewInflate.findViewById(R.id.sync_microphone_un);
        this.z = (LinearLayout) viewInflate.findViewById(R.id.mic_input_view_layout);
        this.D.setVisibility(8);
        this.y.setVisibility(8);
        k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.c.d.9
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (h.N) {
                    CLog.a("IOTA", " activated mode true");
                    if (c.f3272c.equals(c.f3273d)) {
                        h.a(0, 0, 0);
                    }
                    if (z) {
                        FlurryAgent.logEvent("microphone_enabled");
                        CLog.a("IOTA", " mic checked");
                        if (Build.VERSION.SDK_INT <= 22) {
                            CLog.a("IOTA", " mic checked");
                            d.f3309f.setChecked(false);
                            d.f3304a.setVisibility(8);
                            d.this.z.setVisibility(0);
                            d.f3306c.setVisibility(4);
                            if (!d.B) {
                                LineChart unused = d.E = (LineChart) viewInflate.findViewById(R.id.mic_chart_un);
                                d.c();
                                d.d();
                            }
                        } else {
                            if (d.this.getActivity().checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                                CLog.a("IOTA", "requesting microphone permission");
                                d.this.j = true;
                                android.support.v4.app.a.a(d.this.getActivity(), new String[]{"android.permission.RECORD_AUDIO"}, 109);
                                compoundButton.setChecked(false);
                                return;
                            }
                            CLog.a("IOTA", " mic checked");
                            d.f3309f.setChecked(false);
                            d.f3304a.setVisibility(8);
                            d.this.z.setVisibility(0);
                            d.f3306c.setVisibility(4);
                            if (!d.B) {
                                LineChart unused2 = d.E = (LineChart) viewInflate.findViewById(R.id.mic_chart_un);
                                d.c();
                                d.d();
                            }
                        }
                    } else {
                        CLog.a("IOTA", " mic unchecked");
                        d.this.z.setVisibility(8);
                        d.f3306c.setVisibility(0);
                        d.e();
                        boolean unused3 = d.B = false;
                        if (!h.g) {
                            d.this.o();
                        }
                    }
                } else {
                    CLog.a("IOTA", " activated mode false");
                    if (z) {
                        if (b.f3259d.equals("off")) {
                            b.f3257b.setChecked(false);
                            b.f3257b.setBackgroundResource(R.drawable.on);
                        }
                        if (h.N && c.f3272c.equals(c.f3273d)) {
                            try {
                                h.B.removeCallbacksAndMessages(null);
                            } catch (Exception e2) {
                                e2.printStackTrace();
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
                        }
                        FlurryAgent.logEvent("microphone_enabled");
                        if (Build.VERSION.SDK_INT <= 22) {
                            CLog.a("IOTA", " mic checked");
                            d.f3309f.setChecked(false);
                            d.f3304a.setVisibility(8);
                            d.this.z.setVisibility(0);
                            d.f3306c.setVisibility(4);
                            if (!d.B) {
                                LineChart unused4 = d.E = (LineChart) viewInflate.findViewById(R.id.mic_chart_un);
                                d.c();
                                d.d();
                            }
                        } else {
                            if (d.this.getActivity().checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                                CLog.a("IOTA", "requesting microphone permission");
                                d.this.j = true;
                                android.support.v4.app.a.a(d.this.getActivity(), new String[]{"android.permission.RECORD_AUDIO"}, 109);
                                compoundButton.setChecked(false);
                                return;
                            }
                            CLog.a("IOTA", " mic checked");
                            d.f3309f.setChecked(false);
                            d.f3304a.setVisibility(8);
                            d.this.z.setVisibility(0);
                            d.f3306c.setVisibility(4);
                            if (!d.B) {
                                LineChart unused5 = d.E = (LineChart) viewInflate.findViewById(R.id.mic_chart_un);
                                d.c();
                                d.d();
                            }
                        }
                    } else {
                        CLog.a("IOTA", " mic unchecked");
                        d.this.z.setVisibility(8);
                        d.f3306c.setVisibility(0);
                        d.e();
                        boolean unused6 = d.B = false;
                        if (!h.g) {
                            d.this.o();
                        }
                    }
                }
                CLog.a("IOTA", " on resume");
                d.this.onResume();
            }
        });
        i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.c.d.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (h.N) {
                    CLog.a("IOTA", " activated mode true");
                    if (c.f3272c.equals(c.f3273d)) {
                        h.a(0, 0, 0);
                    }
                    if (!z) {
                        CLog.a("IOTA", " mic unchecked");
                        d.this.D.setVisibility(8);
                        d.f3306c.setVisibility(0);
                        d.e();
                        boolean unused = d.B = false;
                        if (!h.g) {
                            d.this.o();
                        }
                    } else if (Build.VERSION.SDK_INT <= 22) {
                        CLog.a("IOTA", " mic checked");
                        d.f3309f.setChecked(false);
                        d.f3304a.setVisibility(8);
                        d.this.D.setVisibility(0);
                        d.f3306c.setVisibility(4);
                        if (!d.B) {
                            LineChart unused2 = d.E = (LineChart) viewInflate.findViewById(R.id.micChart);
                            d.c();
                            d.d();
                        }
                    } else {
                        if (d.this.getActivity().checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                            CLog.a("IOTA", "requesting microphone permission");
                            d.this.j = true;
                            android.support.v4.app.a.a(d.this.getActivity(), new String[]{"android.permission.RECORD_AUDIO"}, 109);
                            compoundButton.setChecked(false);
                            return;
                        }
                        CLog.a("IOTA", " mic checked");
                        d.f3309f.setChecked(false);
                        d.f3304a.setVisibility(8);
                        d.this.D.setVisibility(0);
                        d.f3306c.setVisibility(4);
                        if (!d.B) {
                            LineChart unused3 = d.E = (LineChart) viewInflate.findViewById(R.id.micChart);
                            d.c();
                            d.d();
                        }
                    }
                } else {
                    CLog.a("IOTA", " activated mode false");
                    if (z) {
                        if (b.f3259d.equals("off")) {
                            b.f3257b.setChecked(false);
                            b.f3257b.setBackgroundResource(R.drawable.on);
                        }
                        if (h.N && c.f3272c.equals(c.f3273d)) {
                            try {
                                h.B.removeCallbacksAndMessages(null);
                            } catch (Exception e2) {
                                e2.printStackTrace();
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
                        }
                        FlurryAgent.logEvent("microphone_enabled");
                        if (Build.VERSION.SDK_INT <= 22) {
                            CLog.a("IOTA", " mic checked");
                            d.f3309f.setChecked(false);
                            d.f3304a.setVisibility(8);
                            d.this.D.setVisibility(0);
                            d.f3306c.setVisibility(4);
                            if (!d.B) {
                                LineChart unused4 = d.E = (LineChart) viewInflate.findViewById(R.id.micChart);
                                d.c();
                                d.d();
                            }
                        } else {
                            if (d.this.getActivity().checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                                CLog.a("IOTA", "requesting microphone permission");
                                d.this.j = true;
                                android.support.v4.app.a.a(d.this.getActivity(), new String[]{"android.permission.RECORD_AUDIO"}, 109);
                                compoundButton.setChecked(false);
                                return;
                            }
                            CLog.a("IOTA", " mic checked");
                            d.f3309f.setChecked(false);
                            d.f3304a.setVisibility(8);
                            d.this.D.setVisibility(0);
                            d.f3306c.setVisibility(4);
                            if (!d.B) {
                                LineChart unused5 = d.E = (LineChart) viewInflate.findViewById(R.id.micChart);
                                d.c();
                                d.d();
                            }
                        }
                    } else {
                        CLog.a("IOTA", " mic unchecked");
                        d.this.D.setVisibility(8);
                        d.f3306c.setVisibility(0);
                        d.e();
                        boolean unused6 = d.B = false;
                        if (!h.g) {
                            d.this.o();
                        }
                    }
                }
                d.this.onResume();
            }
        });
        h.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.d.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.c(d.g).contains("com.cube26.osp.music")) {
                    try {
                        Intent launchIntentForPackage = d.g.getPackageManager().getLaunchIntentForPackage("com.cube26.osp.music");
                        if (launchIntentForPackage != null) {
                            d.this.startActivity(launchIntentForPackage);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        f3309f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.c.d.12
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                d.this.b(z);
                if (h.N) {
                    if (z) {
                        d.b();
                        if (Build.VERSION.SDK_INT > 22 && d.this.getActivity().checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                            CLog.a("IOTA", "requesting microphone permission");
                            d.this.j = true;
                            android.support.v4.app.a.a(d.this.getActivity(), new String[]{"android.permission.RECORD_AUDIO"}, 2002);
                            compoundButton.setChecked(false);
                            return;
                        }
                    }
                    d.this.w = System.currentTimeMillis();
                    h.b();
                    if (c.f3272c.equals(c.f3273d)) {
                        h.a(0, 0, 0);
                        return;
                    }
                    return;
                }
                if (!z) {
                    d.this.x = System.currentTimeMillis();
                    if (d.this.x - d.this.w > 10) {
                        CLog.a("IOTA", "music sync enabled for more than 10 sec event");
                        new HashMap().put("song_title", d.f3308e.getText().toString());
                        FlurryAgent.logEvent("music_sync_enabled");
                    }
                    d.f3307d = true;
                    d.a();
                    return;
                }
                if (Build.VERSION.SDK_INT <= 22 || d.this.getActivity().checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
                    h.b();
                    d.b();
                    d.f3307d = false;
                } else {
                    CLog.a("IOTA", "requesting microphone permission");
                    d.this.j = true;
                    android.support.v4.app.a.a(d.this.getActivity(), new String[]{"android.permission.RECORD_AUDIO"}, 2002);
                    compoundButton.setChecked(false);
                }
            }
        });
        if (this.p.contains("com.cube26.osp.music")) {
            CLog.a("IOTA", "Neon Music is installed");
            f3305b.setVisibility(8);
            f3304a.setVisibility(0);
            this.y.setVisibility(8);
            h.I = (VisualizerView) viewInflate.findViewById(R.id.musicvisualizer);
            l();
            if (!f3307d) {
                h.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.d.13
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Intent launchIntentForPackage = d.g.getPackageManager().getLaunchIntentForPackage("com.cube26.osp.music");
                        if (launchIntentForPackage != null) {
                            d.g.startActivity(launchIntentForPackage);
                        }
                    }
                });
            }
        } else {
            f3304a.setVisibility(8);
        }
        this.q = (Button) viewInflate.findViewById(R.id.download);
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CLog.a("IOTA", "download on click");
                FlurryAgent.logEvent("rhythm_play_download_clicked");
                try {
                    CLog.a("IOTA", "download on click :: market");
                    d.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.cube26.osp.music")));
                } catch (ActivityNotFoundException e2) {
                    CLog.a("IOTA", "download on click :: anfe");
                    d.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.cube26.osp.music")));
                } catch (Exception e3) {
                    CLog.a("IOTA", " download on click ::  e");
                }
            }
        });
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        CLog.a("IOTA", " on pause");
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        CLog.a("IOTA", " on resume");
        p();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (!this.p.contains("com.cube26.osp.music") || f3307d) {
            return;
        }
        CLog.a("IOTA", "View is visible");
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.p.contains("com.cube26.osp.music")) {
            f3304a.setVisibility(8);
        }
    }
}
