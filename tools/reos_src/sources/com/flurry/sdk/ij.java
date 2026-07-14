package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ij extends kr {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4308c = ij.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<ik> f4309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public in f4310b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4311d = 1000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4312e = 30000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f4313f;
    private final int g;
    private final int h;
    private final iq i;
    private final Map<String, String> j;
    private long k;
    private int l;
    private int m;
    private String n;
    private String o;
    private boolean p;

    public static class a implements lb<ij> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        la<ik> f4314a = new la<>(new ik.a());

        @Override // com.flurry.sdk.lb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ij b(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.ij.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            String utf = dataInputStream.readUTF();
            if (utf.equals("")) {
                utf = null;
            }
            String utf2 = dataInputStream.readUTF();
            long j = dataInputStream.readLong();
            int i = dataInputStream.readInt();
            long j2 = dataInputStream.readLong();
            int i2 = dataInputStream.readInt();
            int i3 = dataInputStream.readInt();
            iq iqVarA = iq.a(dataInputStream.readInt());
            HashMap map = null;
            int i4 = dataInputStream.readInt();
            if (i4 != 0) {
                map = new HashMap();
                for (int i5 = 0; i5 < i4; i5++) {
                    map.put(dataInputStream.readUTF(), dataInputStream.readUTF());
                }
            }
            long j3 = dataInputStream.readLong();
            int i6 = dataInputStream.readInt();
            int i7 = dataInputStream.readInt();
            String utf3 = dataInputStream.readUTF();
            if (utf3.equals("")) {
                utf3 = null;
            }
            boolean z = dataInputStream.readBoolean();
            ij ijVar = new ij(utf, j2, utf2, j, i2, i3, iqVarA, map, i6, i7, utf3);
            ijVar.k = j3;
            ijVar.p = z;
            ijVar.b(i);
            ijVar.f4309a = (ArrayList) this.f4314a.b(inputStream);
            ijVar.o();
            return ijVar;
        }

        @Override // com.flurry.sdk.lb
        public void a(OutputStream outputStream, ij ijVar) throws IOException {
            if (outputStream == null || ijVar == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.ij.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            if (ijVar.o != null) {
                dataOutputStream.writeUTF(ijVar.o);
            } else {
                dataOutputStream.writeUTF("");
            }
            if (ijVar.t() != null) {
                dataOutputStream.writeUTF(ijVar.t());
            } else {
                dataOutputStream.writeUTF("");
            }
            dataOutputStream.writeLong(ijVar.p());
            dataOutputStream.writeInt(ijVar.r());
            dataOutputStream.writeLong(ijVar.f4313f);
            dataOutputStream.writeInt(ijVar.g);
            dataOutputStream.writeInt(ijVar.h);
            dataOutputStream.writeInt(ijVar.i.a());
            Map map = ijVar.j;
            if (map != null) {
                dataOutputStream.writeInt(ijVar.j.size());
                for (String str : ijVar.j.keySet()) {
                    dataOutputStream.writeUTF(str);
                    dataOutputStream.writeUTF((String) map.get(str));
                }
            } else {
                dataOutputStream.writeInt(0);
            }
            dataOutputStream.writeLong(ijVar.k);
            dataOutputStream.writeInt(ijVar.l);
            dataOutputStream.writeInt(ijVar.m);
            if (ijVar.n != null) {
                dataOutputStream.writeUTF(ijVar.n);
            } else {
                dataOutputStream.writeUTF("");
            }
            dataOutputStream.writeBoolean(ijVar.p);
            dataOutputStream.flush();
            this.f4314a.a(outputStream, (List<ik>) ijVar.f4309a);
        }
    }

    public ij(String str, long j, String str2, long j2, int i, int i2, iq iqVar, Map<String, String> map, int i3, int i4, String str3) {
        a(str2);
        a(j2);
        a_();
        this.o = str;
        this.f4313f = j;
        c(i);
        this.g = i;
        this.h = i2;
        this.i = iqVar;
        this.j = map;
        this.l = i3;
        this.m = i4;
        this.n = str3;
        this.k = 30000L;
        this.f4309a = new ArrayList<>();
    }

    public void a(ik ikVar) {
        this.f4309a.add(ikVar);
    }

    public void a(in inVar) {
        this.f4310b = inVar;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public boolean a(int i) {
        return i > this.h;
    }

    @Override // com.flurry.sdk.kr
    public void a_() {
        super.a_();
        if (super.r() != 1) {
            this.k *= 3;
        }
    }

    public synchronized void b() {
        this.f4310b.g();
    }

    public boolean c() {
        return r() >= this.g;
    }

    public long e() {
        return this.f4313f;
    }

    public iq f() {
        return this.i;
    }

    public long g() {
        return this.k;
    }

    public Map<String, String> h() {
        return this.j;
    }

    public String i() {
        return this.o;
    }

    public int j() {
        return this.l;
    }

    public int k() {
        return this.m;
    }

    public String l() {
        return this.n;
    }

    public String m() {
        return this.f4310b.c();
    }

    public boolean n() {
        return this.p;
    }

    public void o() {
        Iterator<ik> it = this.f4309a.iterator();
        while (it.hasNext()) {
            it.next().l = this;
        }
    }
}
