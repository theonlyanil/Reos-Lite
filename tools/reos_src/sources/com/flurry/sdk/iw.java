package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class iw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f4386a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4391f;
    private long g;

    public iw(int i, String str, Map<String, String> map, long j, boolean z) {
        this.f4387b = i;
        this.f4388c = str;
        if (map != null) {
            this.f4386a.putAll(map);
        }
        this.f4389d = j;
        this.f4390e = z;
        if (this.f4390e) {
            this.f4391f = false;
        } else {
            this.f4391f = true;
        }
    }

    public void a(long j) {
        this.f4391f = true;
        this.g = j - this.f4389d;
        kg.a(3, "FlurryAgent", "Ended event '" + this.f4388c + "' (" + this.f4389d + ") after " + this.g + "ms");
    }

    public synchronized void a(Map<String, String> map) {
        if (map != null) {
            this.f4386a.putAll(map);
        }
    }

    public boolean a() {
        return this.f4390e;
    }

    public boolean a(String str) {
        return this.f4390e && this.g == 0 && this.f4388c.equals(str);
    }

    public synchronized void b(Map<String, String> map) {
        this.f4386a.clear();
        if (map != null) {
            this.f4386a.putAll(map);
        }
    }

    public boolean b() {
        return this.f4391f;
    }

    public synchronized Map<String, String> c() {
        return new HashMap(this.f4386a);
    }

    public int d() {
        return e().length;
    }

    public synchronized byte[] e() {
        DataOutputStream dataOutputStream;
        Throwable th;
        DataOutputStream dataOutputStream2;
        byte[] byteArray;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeShort(this.f4387b);
                    dataOutputStream.writeUTF(this.f4388c);
                    dataOutputStream.writeShort(this.f4386a.size());
                    for (Map.Entry<String, String> entry : this.f4386a.entrySet()) {
                        dataOutputStream.writeUTF(lt.b(entry.getKey()));
                        dataOutputStream.writeUTF(lt.b(entry.getValue()));
                    }
                    dataOutputStream.writeLong(this.f4389d);
                    dataOutputStream.writeLong(this.g);
                    dataOutputStream.flush();
                    byteArray = byteArrayOutputStream.toByteArray();
                    lt.a(dataOutputStream);
                } catch (IOException e2) {
                    dataOutputStream2 = dataOutputStream;
                    try {
                        byteArray = new byte[0];
                        lt.a(dataOutputStream2);
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream = dataOutputStream2;
                        lt.a(dataOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    lt.a(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        } catch (IOException e3) {
            dataOutputStream2 = null;
        } catch (Throwable th5) {
            dataOutputStream = null;
            th = th5;
        }
        return byteArray;
    }
}
