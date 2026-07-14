package com.flurry.sdk;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes.dex */
public final class ho {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4218a = ho.class.getSimpleName();

    public static jc a(File file) throws Throwable {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        jc jcVar;
        if (file == null || !file.exists()) {
            return null;
        }
        jc.a aVar = new jc.a();
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    dataInputStream = new DataInputStream(fileInputStream);
                    try {
                        if (dataInputStream.readUnsignedShort() != 46586) {
                            kg.a(3, f4218a, "Unexpected file type");
                            lt.a((Closeable) dataInputStream);
                            lt.a((Closeable) fileInputStream);
                            return null;
                        }
                        int unsignedShort = dataInputStream.readUnsignedShort();
                        if (unsignedShort != 2) {
                            kg.a(6, f4218a, "Unknown agent file version: " + unsignedShort);
                            lt.a((Closeable) dataInputStream);
                            lt.a((Closeable) fileInputStream);
                            return null;
                        }
                        jcVar = (jc) aVar.b(dataInputStream);
                        lt.a((Closeable) dataInputStream);
                        lt.a((Closeable) fileInputStream);
                        return jcVar;
                    } catch (Exception e2) {
                        e = e2;
                        kg.a(3, f4218a, "Error loading legacy agent data.", e);
                        lt.a((Closeable) dataInputStream);
                        lt.a((Closeable) fileInputStream);
                        jcVar = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    dataInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    lt.a((Closeable) 0);
                    lt.a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
            dataInputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }
}
