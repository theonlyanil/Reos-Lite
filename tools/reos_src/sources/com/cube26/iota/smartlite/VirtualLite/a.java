package com.cube26.iota.smartlite.VirtualLite;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.util.h;
import com.google.android.gms.location.places.Place;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f3210d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CountDownTimer f3211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Socket f3213c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f3214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f3215f;
    private DataOutputStream g;
    private DataInputStream h;
    private BufferedReader i;
    private b j;
    private HandlerThreadC0062a k;
    private String l;
    private int m;
    private String n;

    /* JADX INFO: renamed from: com.cube26.iota.smartlite.VirtualLite.a$a, reason: collision with other inner class name */
    private class HandlerThreadC0062a extends HandlerThread {
        public HandlerThreadC0062a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            a.this.f3215f = new Handler() { // from class: com.cube26.iota.smartlite.VirtualLite.a.a.1
                /* JADX WARN: Failed to build post-dominance tree
                java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
                	at jadx.core.dex.visitors.blocks.DominatorTree.build(DominatorTree.java:68)
                	at jadx.core.dex.visitors.blocks.PostDominatorTree.compute(PostDominatorTree.java:32)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:93)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
                 */
                /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getId()" because "imPostDom" is null
                    	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:190)
                    	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:72)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
                    	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
                    */
                @Override // android.os.Handler
                public void handleMessage(android.os.Message r6) {
                    /*
                        Method dump skipped, instruction units count: 276
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cube26.iota.smartlite.VirtualLite.a.HandlerThreadC0062a.AnonymousClass1.handleMessage(android.os.Message):void");
                }
            };
        }
    }

    private class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            a.this.f3214e = new Handler() { // from class: com.cube26.iota.smartlite.VirtualLite.a.b.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    switch (message.what) {
                        case 1:
                            CLog.a("IOTA", " handler connect");
                            Bundle bundle = (Bundle) message.obj;
                            a.this.b(bundle.getString("target_ip"), bundle.getInt("port"));
                            CLog.a("IOTA", " send data handler");
                            a.this.a(a.this.n);
                            break;
                        case 2:
                            a.this.f();
                            break;
                        case 3:
                            a.this.b((String) message.obj);
                            break;
                        case 4:
                            CLog.a("IOTA", " qr code ");
                            Message messageObtain = Message.obtain(a.this.f3214e);
                            messageObtain.what = 11;
                            messageObtain.arg1 = 4;
                            sendMessage(messageObtain);
                            break;
                        case 6:
                            CLog.a("IOTA", " session expired ");
                            Message messageObtain2 = Message.obtain(a.this.f3214e);
                            messageObtain2.what = 11;
                            messageObtain2.arg1 = 6;
                            sendMessage(messageObtain2);
                            break;
                        case 11:
                            CLog.a("IOTA", " exit virtual mode");
                            Message messageObtain3 = Message.obtain(h.f3470d);
                            messageObtain3.what = Place.TYPE_LOCALITY;
                            messageObtain3.arg1 = message.arg1;
                            h.f3470d.sendMessage(messageObtain3);
                            break;
                    }
                }
            };
            CLog.a("IOTA", "socket output thread started");
            a.this.a(a.this.l, a.this.m);
        }
    }

    private a() {
        b(this.l, this.m, this.n);
    }

    public static a a() {
        if (f3210d == null) {
            f3210d = new a();
        }
        return f3210d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.f3213c == null || !this.f3213c.isConnected() || this.g == null) {
            return;
        }
        try {
            this.g.write(str.getBytes("US-ASCII"));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i) {
        try {
            CLog.a("IOTA", " connect socket ");
            this.f3213c = new Socket(str, i);
            g();
            this.f3213c.setKeepAlive(true);
            this.g = new DataOutputStream(this.f3213c.getOutputStream());
            this.h = new DataInputStream(this.f3213c.getInputStream());
            this.i = new BufferedReader(new InputStreamReader(this.h));
            CLog.a("IOTA", "obtained io streams for socket");
            this.f3215f.sendEmptyMessage(7);
        } catch (IOException e2) {
            e2.printStackTrace();
            CLog.a("IOTA", " ioe ");
        }
    }

    private void b(String str, int i, String str2) {
        this.l = str;
        this.m = i;
        this.n = str2;
    }

    private void e() {
        CLog.a("IOTA", " quitting socket threads");
        if (this.k != null && this.k.isAlive()) {
            this.k.quit();
        }
        if (this.j == null || !this.j.isAlive()) {
            return;
        }
        this.j.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        CLog.a("IOTA", " socket disconnect");
        e();
        if (this.f3213c == null || !this.f3213c.isConnected()) {
            return;
        }
        try {
            this.f3213c.close();
            this.f3212b = 9;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        long j = 30000;
        CLog.a("IOTA", " starting timer");
        this.f3211a = new CountDownTimer(j, j) { // from class: com.cube26.iota.smartlite.VirtualLite.a.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (a.this.f3212b != 9) {
                    CLog.a("IOTA", " on finish ");
                    a.this.c();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        CLog.a("IOTA", " invalidating timer");
        if (this.f3211a != null) {
            this.f3211a.cancel();
        }
    }

    public void a(String str) {
        CLog.a("IOTA", " send data " + str);
        Message messageObtain = Message.obtain(this.f3214e, 3);
        messageObtain.obj = str;
        this.f3214e.sendMessage(messageObtain);
    }

    public void a(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("port", i);
        bundle.putString("target_ip", str);
        Message messageObtain = Message.obtain(this.f3214e, 1);
        messageObtain.obj = bundle;
        this.f3214e.sendMessage(messageObtain);
    }

    public void a(String str, int i, String str2) {
        this.l = str;
        this.m = i;
        this.n = str2;
        this.f3212b = 9;
    }

    public void b() {
        CLog.a("IOTA", " making connection");
        h.f3467a = true;
        this.j = new b(b.class.getName());
        this.k = new HandlerThreadC0062a(HandlerThreadC0062a.class.getName());
        this.j.start();
        this.k.start();
    }

    public void c() {
        this.f3214e.sendMessage(Message.obtain(this.f3214e, 2));
    }

    public boolean d() {
        return this.f3213c != null && this.f3213c.isConnected();
    }
}
