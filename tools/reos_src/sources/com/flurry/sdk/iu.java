package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class iu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Throwable f4384f;

    public iu(int i, long j, String str, String str2, String str3, Throwable th) {
        this.f4379a = i;
        this.f4380b = j;
        this.f4381c = str;
        this.f4382d = str2;
        this.f4383e = str3;
        this.f4384f = th;
    }

    public int a() {
        return b().length;
    }

    public byte[] b() throws Throwable {
        Throwable th;
        DataOutputStream dataOutputStream;
        byte[] byteArray;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeShort(this.f4379a);
                    dataOutputStream.writeLong(this.f4380b);
                    dataOutputStream.writeUTF(this.f4381c);
                    dataOutputStream.writeUTF(this.f4382d);
                    dataOutputStream.writeUTF(this.f4383e);
                    if (this.f4384f != null) {
                        if ("uncaught".equals(this.f4381c)) {
                            dataOutputStream.writeByte(3);
                        } else {
                            dataOutputStream.writeByte(2);
                        }
                        dataOutputStream.writeByte(2);
                        StringBuilder sb = new StringBuilder("");
                        String property = System.getProperty("line.separator");
                        for (StackTraceElement stackTraceElement : this.f4384f.getStackTrace()) {
                            sb.append(stackTraceElement);
                            sb.append(property);
                        }
                        if (this.f4384f.getCause() != null) {
                            sb.append(property);
                            sb.append("Caused by: ");
                            for (StackTraceElement stackTraceElement2 : this.f4384f.getCause().getStackTrace()) {
                                sb.append(stackTraceElement2);
                                sb.append(property);
                            }
                        }
                        byte[] bytes = sb.toString().getBytes();
                        dataOutputStream.writeInt(bytes.length);
                        dataOutputStream.write(bytes);
                    } else {
                        dataOutputStream.writeByte(1);
                        dataOutputStream.writeByte(0);
                    }
                    dataOutputStream.flush();
                    byteArray = byteArrayOutputStream.toByteArray();
                    lt.a(dataOutputStream);
                } catch (IOException e2) {
                    byteArray = new byte[0];
                    lt.a(dataOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                lt.a((Closeable) null);
                throw th;
            }
        } catch (IOException e3) {
            dataOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            lt.a((Closeable) null);
            throw th;
        }
        return byteArray;
    }

    public String c() {
        return this.f4381c;
    }
}
