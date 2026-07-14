package com.flurry.sdk;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.security.DigestOutputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4392a = ix.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f4393b;

    public ix(String str, String str2, boolean z, boolean z2, long j, long j2, List<iz> list, Map<jn, byte[]> map, Map<String, List<String>> map2, Map<String, List<String>> map3, Map<String, Map<String, String>> map4, long j3) throws Throwable {
        DataOutputStream dataOutputStream;
        byte[] byteArray;
        this.f4393b = null;
        DataOutputStream dataOutputStream2 = null;
        try {
            jy jyVar = new jy();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DigestOutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, jyVar);
            dataOutputStream = new DataOutputStream(digestOutputStream);
            try {
                dataOutputStream.writeShort(30);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeLong(0L);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(3);
                dataOutputStream.writeShort(jt.a());
                dataOutputStream.writeLong(j3);
                dataOutputStream.writeUTF(str);
                dataOutputStream.writeUTF(str2);
                dataOutputStream.writeShort(map.size());
                for (Map.Entry<jn, byte[]> entry : map.entrySet()) {
                    dataOutputStream.writeShort(entry.getKey().f4497d);
                    byte[] value = entry.getValue();
                    dataOutputStream.writeShort(value.length);
                    dataOutputStream.write(value);
                }
                dataOutputStream.writeByte(0);
                dataOutputStream.writeBoolean(z);
                dataOutputStream.writeBoolean(z2);
                dataOutputStream.writeLong(j);
                dataOutputStream.writeLong(j2);
                dataOutputStream.writeShort(6);
                dataOutputStream.writeUTF("device.model");
                dataOutputStream.writeUTF(Build.MODEL);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.brand");
                dataOutputStream.writeUTF(Build.BRAND);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.id");
                dataOutputStream.writeUTF(Build.ID);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("version.release");
                dataOutputStream.writeUTF(Build.VERSION.RELEASE);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.device");
                dataOutputStream.writeUTF(Build.DEVICE);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.product");
                dataOutputStream.writeUTF(Build.PRODUCT);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeShort(map2 != null ? map2.keySet().size() : 0);
                if (map2 != null) {
                    kg.a(3, f4392a, "sending referrer values because it exists");
                    for (Map.Entry<String, List<String>> entry2 : map2.entrySet()) {
                        kg.a(3, f4392a, "Referrer Entry:  " + entry2.getKey() + "=" + entry2.getValue());
                        dataOutputStream.writeUTF(entry2.getKey());
                        kg.a(3, f4392a, "referrer key is :" + entry2.getKey());
                        dataOutputStream.writeShort(entry2.getValue().size());
                        for (String str3 : entry2.getValue()) {
                            dataOutputStream.writeUTF(str3);
                            kg.a(3, f4392a, "referrer value is :" + str3);
                        }
                    }
                }
                dataOutputStream.writeBoolean(false);
                int size = map3 != null ? map3.keySet().size() : 0;
                kg.a(3, f4392a, "optionsMapSize is:  " + size);
                dataOutputStream.writeShort(size);
                if (map3 != null) {
                    kg.a(3, f4392a, "sending launch options");
                    for (Map.Entry<String, List<String>> entry3 : map3.entrySet()) {
                        kg.a(3, f4392a, "Launch Options Key:  " + entry3.getKey());
                        dataOutputStream.writeUTF(entry3.getKey());
                        dataOutputStream.writeShort(entry3.getValue().size());
                        for (String str4 : entry3.getValue()) {
                            dataOutputStream.writeUTF(str4);
                            kg.a(3, f4392a, "Launch Options value is :" + str4);
                        }
                    }
                }
                int size2 = map4 != null ? map4.keySet().size() : 0;
                kg.a(3, f4392a, "numOriginAttributions is:  " + size);
                dataOutputStream.writeShort(size2);
                if (map4 != null) {
                    for (Map.Entry<String, Map<String, String>> entry4 : map4.entrySet()) {
                        kg.a(3, f4392a, "Origin Atttribute Key:  " + entry4.getKey());
                        dataOutputStream.writeUTF(entry4.getKey());
                        dataOutputStream.writeShort(entry4.getValue().size());
                        kg.a(3, f4392a, "Origin Attribute Map Size for " + entry4.getKey() + ":  " + entry4.getValue().size());
                        for (Map.Entry<String, String> entry5 : entry4.getValue().entrySet()) {
                            kg.a(3, f4392a, "Origin Atttribute for " + entry4.getKey() + ":  " + entry5.getKey() + ":" + entry5.getValue());
                            dataOutputStream.writeUTF(entry5.getKey() != null ? entry5.getKey() : "");
                            dataOutputStream.writeUTF(entry5.getValue() != null ? entry5.getValue() : "");
                        }
                    }
                }
                dataOutputStream.writeUTF(lq.c(js.a().c()));
                int size3 = list.size();
                dataOutputStream.writeShort(size3);
                for (int i = 0; i < size3; i++) {
                    dataOutputStream.write(list.get(i).a());
                }
                dataOutputStream.writeShort(0);
                digestOutputStream.on(false);
                dataOutputStream.write(jyVar.a());
                dataOutputStream.close();
                byteArray = byteArrayOutputStream.toByteArray();
                lt.a(dataOutputStream);
            } catch (Throwable th) {
                th = th;
                lt.a(dataOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream = null;
        }
        this.f4393b = byteArray;
    }

    public byte[] a() {
        return this.f4393b;
    }
}
