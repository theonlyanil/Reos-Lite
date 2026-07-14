package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4344a = io.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4346c = System.currentTimeMillis();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ir f4348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4349f;
    private int g;
    private String h;
    private int i;
    private AtomicInteger j;
    private Map<Long, ij> k;

    public static class a implements lb<in> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        la<ij> f4350a = new la<>(new ij.a());

        @Override // com.flurry.sdk.lb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public in b(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.in.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            long j = dataInputStream.readLong();
            long j2 = dataInputStream.readLong();
            long j3 = dataInputStream.readLong();
            ir irVarA = ir.a(dataInputStream.readInt());
            boolean z = dataInputStream.readBoolean();
            int i = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            int i2 = dataInputStream.readInt();
            int i3 = dataInputStream.readInt();
            in inVar = new in(utf, z, j, j3, irVarA, null);
            inVar.f4346c = j2;
            inVar.g = i;
            inVar.i = i2;
            inVar.j = new AtomicInteger(i3);
            List<ij> listB = this.f4350a.b(inputStream);
            if (listB != null) {
                inVar.k = new HashMap();
                for (ij ijVar : listB) {
                    ijVar.f4310b = inVar;
                    inVar.k.put(Long.valueOf(ijVar.e()), ijVar);
                }
            }
            return inVar;
        }

        @Override // com.flurry.sdk.lb
        public void a(OutputStream outputStream, in inVar) throws IOException {
            if (outputStream == null || inVar == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.in.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            dataOutputStream.writeLong(inVar.f4345b);
            dataOutputStream.writeLong(inVar.f4346c);
            dataOutputStream.writeLong(inVar.f4347d);
            dataOutputStream.writeInt(inVar.f4348e.a());
            dataOutputStream.writeBoolean(inVar.f4349f);
            dataOutputStream.writeInt(inVar.g);
            if (inVar.h != null) {
                dataOutputStream.writeUTF(inVar.h);
            } else {
                dataOutputStream.writeUTF("");
            }
            dataOutputStream.writeInt(inVar.i);
            dataOutputStream.writeInt(inVar.j.intValue());
            dataOutputStream.flush();
            this.f4350a.a(outputStream, inVar.d());
        }
    }

    public in(String str, boolean z, long j, long j2, ir irVar, Map<Long, ij> map) {
        this.h = str;
        this.f4349f = z;
        this.f4345b = j;
        this.f4347d = j2;
        this.f4348e = irVar;
        this.k = map;
        if (map != null) {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                map.get(it.next()).a(this);
            }
            this.i = map.size();
        } else {
            this.i = 0;
        }
        this.j = new AtomicInteger(0);
    }

    public int a() {
        return this.g;
    }

    public void a(int i) {
        this.g = i;
    }

    public long b() {
        return this.f4345b;
    }

    public String c() {
        return this.h;
    }

    public List<ij> d() {
        return this.k != null ? new ArrayList(this.k.values()) : Collections.emptyList();
    }

    public Map<Long, ij> e() {
        return this.k;
    }

    public synchronized boolean f() {
        return this.j.intValue() >= this.i;
    }

    public synchronized void g() {
        this.j.incrementAndGet();
    }

    public byte[] h() throws Throwable {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(this.f4348e.a());
                dataOutputStream.writeLong(this.f4345b);
                dataOutputStream.writeLong(this.f4347d);
                dataOutputStream.writeBoolean(this.f4349f);
                if (this.f4349f) {
                    dataOutputStream.writeShort(this.g);
                    dataOutputStream.writeUTF(this.h);
                }
                dataOutputStream.writeShort(this.k.size());
                if (this.k != null) {
                    for (Map.Entry<Long, ij> entry : this.k.entrySet()) {
                        ij value = entry.getValue();
                        dataOutputStream.writeLong(entry.getKey().longValue());
                        dataOutputStream.writeUTF(value.t());
                        dataOutputStream.writeShort(value.f4309a.size());
                        for (ik ikVar : value.f4309a) {
                            dataOutputStream.writeShort(ikVar.f4317a);
                            dataOutputStream.writeLong(ikVar.f4318b);
                            dataOutputStream.writeLong(ikVar.f4319c);
                            dataOutputStream.writeBoolean(ikVar.f4320d);
                            dataOutputStream.writeShort(ikVar.f4321e);
                            dataOutputStream.writeShort(ikVar.f4322f.a());
                            if ((ikVar.f4321e < 200 || ikVar.f4321e >= 400) && ikVar.g != null) {
                                byte[] bytes = ikVar.g.getBytes();
                                dataOutputStream.writeShort(bytes.length);
                                dataOutputStream.write(bytes);
                            }
                            dataOutputStream.writeShort(ikVar.h);
                            dataOutputStream.writeInt((int) ikVar.k);
                        }
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                lt.a(dataOutputStream);
                return byteArray;
            } catch (IOException e2) {
                e = e2;
                dataOutputStream2 = dataOutputStream;
                try {
                    kg.a(6, f4344a, "Error when generating report", e);
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    lt.a(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                lt.a(dataOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
        }
    }
}
