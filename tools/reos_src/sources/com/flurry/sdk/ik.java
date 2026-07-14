package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ik {
    private static final String m = ik.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4320d;
    public String g;
    public int h;
    public long i;
    public boolean j;
    public ij l;
    public long k = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4321e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public il f4322f = il.PENDING_COMPLETION;

    public static class a implements lb<ik> {
        @Override // com.flurry.sdk.lb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ik b(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.ik.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            int i = dataInputStream.readInt();
            long j = dataInputStream.readLong();
            long j2 = dataInputStream.readLong();
            boolean z = dataInputStream.readBoolean();
            int i2 = dataInputStream.readInt();
            il ilVarA = il.a(dataInputStream.readInt());
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            long j3 = dataInputStream.readLong();
            boolean z2 = dataInputStream.readBoolean();
            long j4 = dataInputStream.readLong();
            ik ikVar = new ik(null, j, j2, i);
            ikVar.f4320d = z;
            ikVar.f4321e = i2;
            ikVar.f4322f = ilVarA;
            ikVar.g = utf;
            ikVar.h = i3;
            ikVar.i = j3;
            ikVar.j = z2;
            ikVar.k = j4;
            return ikVar;
        }

        @Override // com.flurry.sdk.lb
        public void a(OutputStream outputStream, ik ikVar) throws IOException {
            if (outputStream == null || ikVar == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.ik.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            dataOutputStream.writeInt(ikVar.f4317a);
            dataOutputStream.writeLong(ikVar.f4318b);
            dataOutputStream.writeLong(ikVar.f4319c);
            dataOutputStream.writeBoolean(ikVar.f4320d);
            dataOutputStream.writeInt(ikVar.f4321e);
            dataOutputStream.writeInt(ikVar.f4322f.a());
            if (ikVar.g != null) {
                dataOutputStream.writeUTF(ikVar.g);
            } else {
                dataOutputStream.writeUTF("");
            }
            dataOutputStream.writeInt(ikVar.h);
            dataOutputStream.writeLong(ikVar.i);
            dataOutputStream.writeBoolean(ikVar.j);
            dataOutputStream.writeLong(ikVar.k);
            dataOutputStream.flush();
        }
    }

    public ik(ij ijVar, long j, long j2, int i) {
        this.l = ijVar;
        this.f4318b = j;
        this.f4319c = j2;
        this.f4317a = i;
    }

    public void a() {
        this.l.a(this);
        if (this.f4320d) {
            this.l.a(true);
        }
    }

    public void a(int i) {
        if (i >= 0) {
            this.k += (long) i;
        } else if (this.k <= 0) {
            this.k = 0L;
        }
    }

    public void a(String str) {
        this.l.c(str);
    }

    public boolean b() {
        return this.l.c();
    }

    public boolean c() {
        return this.l.a(this.h);
    }

    public String d() {
        return this.l.m();
    }

    public String e() {
        return this.l.i();
    }

    public String f() {
        return this.l.t();
    }

    public void g() {
        this.l.b();
    }
}
