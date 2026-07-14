package com.flurry.sdk;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
public class io {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4353b = io.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static io f4354c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4355a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private jz<List<ip>> f4356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<ip> f4357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4358f;

    private io() {
    }

    public static synchronized io a() {
        if (f4354c == null) {
            f4354c = new io();
            f4354c.e();
        }
        return f4354c;
    }

    private void e() {
        this.f4356d = new jz<>(js.a().c().getFileStreamPath(f()), ".yflurrypulselogging.", 1, new le<List<ip>>() { // from class: com.flurry.sdk.io.1
            @Override // com.flurry.sdk.le
            public lb<List<ip>> a(int i) {
                return new la(new ip.a());
            }
        });
        this.f4358f = ((Boolean) lk.a().a("UseHttps")).booleanValue();
        kg.a(4, f4353b, "initSettings, UseHttps = " + this.f4358f);
        this.f4357e = this.f4356d.a();
        if (this.f4357e == null) {
            this.f4357e = new ArrayList();
        }
    }

    private String f() {
        return ".yflurrypulselogging." + Long.toString(lt.i(js.a().d()), 16);
    }

    private String g() {
        if (this.f4355a != null) {
            return this.f4355a;
        }
        return this.f4358f ? "https://data.flurry.com/pcr.do" : "https://data.flurry.com/pcr.do";
    }

    public synchronized void a(in inVar) {
        try {
            this.f4357e.add(new ip(inVar.h()));
            kg.a(4, f4353b, "Saving persistent Pulse logging data.");
            this.f4356d.a(this.f4357e);
        } catch (IOException e2) {
            kg.a(6, f4353b, "Error when generating pulse log report in addReport part");
        }
    }

    public void a(String str) {
        if (str != null && !str.endsWith(".do")) {
            kg.a(5, f4353b, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        this.f4355a = str;
    }

    public synchronized void a(byte[] bArr) {
        if (!jl.a().c()) {
            kg.a(5, f4353b, "Reports were not sent! No Internet connection!");
        } else if (bArr == null || bArr.length == 0) {
            kg.a(3, f4353b, "No report need be sent");
        } else {
            String strG = g();
            kg.a(4, f4353b, "PulseLoggingManager: start upload data " + Arrays.toString(bArr) + " to " + strG);
            kn knVar = new kn();
            knVar.a(strG);
            knVar.d(100000);
            knVar.a(kp.a.kPost);
            knVar.b(true);
            knVar.a("Content-Type", "application/octet-stream");
            knVar.a((lb) new kx());
            knVar.a(bArr);
            knVar.a((kn.a) new kn.a<byte[], Void>() { // from class: com.flurry.sdk.io.2
                @Override // com.flurry.sdk.kn.a
                public void a(kn<byte[], Void> knVar2, Void r7) throws Throwable {
                    int iH = knVar2.h();
                    if (iH <= 0) {
                        kg.e(io.f4353b, "Server Error: " + iH);
                        return;
                    }
                    if (iH < 200 || iH >= 300) {
                        kg.a(3, io.f4353b, "Pulse logging report sent unsuccessfully, HTTP response:" + iH);
                        return;
                    }
                    kg.a(3, io.f4353b, "Pulse logging report sent successfully HTTP response:" + iH);
                    io.this.f4357e.clear();
                    io.this.f4356d.a(io.this.f4357e);
                }
            });
            jq.a().a(this, knVar);
        }
    }

    public byte[] b() throws Throwable {
        DataOutputStream dataOutputStream;
        byte[] byteArray;
        DataOutputStream dataOutputStream2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                if (this.f4357e == null || this.f4357e.isEmpty()) {
                    byteArray = byteArrayOutputStream.toByteArray();
                    lt.a(dataOutputStream);
                } else {
                    dataOutputStream.writeShort(1);
                    dataOutputStream.writeShort(1);
                    dataOutputStream.writeLong(System.currentTimeMillis());
                    dataOutputStream.writeUTF(js.a().d());
                    dataOutputStream.writeUTF(jo.a().e());
                    dataOutputStream.writeShort(jt.a());
                    dataOutputStream.writeShort(3);
                    dataOutputStream.writeUTF(jo.a().d());
                    dataOutputStream.writeBoolean(jf.a().e());
                    ArrayList<hu> arrayList = new ArrayList();
                    for (Map.Entry<jn, byte[]> entry : jf.a().h().entrySet()) {
                        hu huVar = new hu();
                        huVar.f4248a = entry.getKey().f4497d;
                        if (entry.getKey().f4498e) {
                            huVar.f4249b = new String(entry.getValue());
                        } else {
                            huVar.f4249b = lt.b(entry.getValue());
                        }
                        arrayList.add(huVar);
                    }
                    dataOutputStream.writeShort(arrayList.size());
                    for (hu huVar2 : arrayList) {
                        dataOutputStream.writeShort(huVar2.f4248a);
                        byte[] bytes = huVar2.f4249b.getBytes();
                        dataOutputStream.writeShort(bytes.length);
                        dataOutputStream.write(bytes);
                    }
                    dataOutputStream.writeShort(6);
                    dataOutputStream.writeShort(ih.MODEL.a());
                    dataOutputStream.writeUTF(Build.MODEL);
                    dataOutputStream.writeShort(ih.BRAND.a());
                    dataOutputStream.writeUTF(Build.BOARD);
                    dataOutputStream.writeShort(ih.ID.a());
                    dataOutputStream.writeUTF(Build.ID);
                    dataOutputStream.writeShort(ih.DEVICE.a());
                    dataOutputStream.writeUTF(Build.DEVICE);
                    dataOutputStream.writeShort(ih.PRODUCT.a());
                    dataOutputStream.writeUTF(Build.PRODUCT);
                    dataOutputStream.writeShort(ih.VERSION_RELEASE.a());
                    dataOutputStream.writeUTF(Build.VERSION.RELEASE);
                    dataOutputStream.writeShort(this.f4357e.size());
                    Iterator<ip> it = this.f4357e.iterator();
                    while (it.hasNext()) {
                        dataOutputStream.write(it.next().a());
                    }
                    byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                    CRC32 crc32 = new CRC32();
                    crc32.update(byteArray2);
                    dataOutputStream.writeInt((int) crc32.getValue());
                    byteArray = byteArrayOutputStream.toByteArray();
                    lt.a(dataOutputStream);
                }
                return byteArray;
            } catch (IOException e2) {
                e = e2;
                dataOutputStream2 = dataOutputStream;
                try {
                    kg.a(6, f4353b, "Error when generating report", e);
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

    public synchronized void c() {
        try {
            a(b());
        } catch (IOException e2) {
            kg.a(6, f4353b, "Report not send due to exception in generate data");
        }
    }
}
