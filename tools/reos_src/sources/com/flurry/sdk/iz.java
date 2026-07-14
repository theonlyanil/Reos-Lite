package com.flurry.sdk;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class iz {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4403b = iz.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    byte[] f4404a;

    public static class a implements lb<iz> {
        @Override // com.flurry.sdk.lb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public iz b(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.iz.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            iz izVar = new iz();
            int unsignedShort = dataInputStream.readUnsignedShort();
            if (unsignedShort > 0) {
                byte[] bArr = new byte[unsignedShort];
                dataInputStream.readFully(bArr);
                izVar.f4404a = bArr;
            }
            return izVar;
        }

        @Override // com.flurry.sdk.lb
        public void a(OutputStream outputStream, iz izVar) throws IOException {
            if (outputStream == null || izVar == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.iz.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            int length = izVar.f4404a != null ? izVar.f4404a.length : 0;
            dataOutputStream.writeShort(length);
            if (length > 0) {
                dataOutputStream.write(izVar.f4404a);
            }
            dataOutputStream.flush();
        }
    }

    private iz() {
    }

    public iz(ja jaVar) throws Throwable {
        DataOutputStream dataOutputStream;
        int i;
        DataOutputStream dataOutputStream2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(7);
                dataOutputStream.writeUTF(jaVar.a());
                dataOutputStream.writeLong(jaVar.b());
                dataOutputStream.writeLong(jaVar.c());
                dataOutputStream.writeLong(jaVar.d());
                dataOutputStream.writeBoolean(true);
                dataOutputStream.writeByte(-1);
                if (TextUtils.isEmpty(jaVar.f())) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeUTF(jaVar.f());
                }
                if (TextUtils.isEmpty(jaVar.g())) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeUTF(jaVar.g());
                }
                Map<String, String> mapH = jaVar.h();
                if (mapH == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(mapH.size());
                    for (Map.Entry<String, String> entry : mapH.entrySet()) {
                        dataOutputStream.writeUTF(entry.getKey());
                        dataOutputStream.writeUTF(entry.getValue());
                    }
                }
                Map<String, String> mapE = jaVar.e();
                if (mapE == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(mapE.size());
                    for (Map.Entry<String, String> entry2 : mapE.entrySet()) {
                        dataOutputStream.writeUTF(entry2.getKey());
                        dataOutputStream.writeUTF(entry2.getValue());
                        dataOutputStream.writeByte(0);
                    }
                }
                dataOutputStream.writeUTF(jaVar.i());
                dataOutputStream.writeUTF(jaVar.j());
                dataOutputStream.writeByte(jaVar.k());
                dataOutputStream.writeByte(jaVar.l());
                dataOutputStream.writeUTF(jaVar.m());
                if (jaVar.n() == null) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeDouble(lt.a(jaVar.n().getLatitude(), 3));
                    dataOutputStream.writeDouble(lt.a(jaVar.n().getLongitude(), 3));
                    dataOutputStream.writeFloat(jaVar.n().getAccuracy());
                }
                dataOutputStream.writeInt(jaVar.o());
                dataOutputStream.writeByte(-1);
                dataOutputStream.writeByte(-1);
                dataOutputStream.writeByte(jaVar.p());
                if (jaVar.q() == null) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeLong(jaVar.q().longValue());
                }
                Map<String, iv> mapR = jaVar.r();
                if (mapR == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(mapR.size());
                    for (Map.Entry<String, iv> entry3 : mapR.entrySet()) {
                        dataOutputStream.writeUTF(entry3.getKey());
                        dataOutputStream.writeInt(entry3.getValue().f4385a);
                    }
                }
                List<iw> listS = jaVar.s();
                if (listS == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(listS.size());
                    Iterator<iw> it = listS.iterator();
                    while (it.hasNext()) {
                        dataOutputStream.write(it.next().e());
                    }
                }
                dataOutputStream.writeBoolean(jaVar.t());
                List<iu> listV = jaVar.v();
                if (listV != null) {
                    int i2 = 0;
                    int iA = 0;
                    int i3 = 0;
                    while (true) {
                        if (i2 >= listV.size()) {
                            i = i3;
                            break;
                        }
                        iA += listV.get(i2).a();
                        if (iA > 160000) {
                            kg.a(5, f4403b, "Error Log size exceeded. No more event details logged.");
                            i = i3;
                            break;
                        } else {
                            i3++;
                            i2++;
                        }
                    }
                } else {
                    i = 0;
                }
                dataOutputStream.writeInt(jaVar.u());
                dataOutputStream.writeShort(i);
                for (int i4 = 0; i4 < i; i4++) {
                    dataOutputStream.write(listV.get(i4).b());
                }
                dataOutputStream.writeInt(-1);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(0);
                this.f4404a = byteArrayOutputStream.toByteArray();
                lt.a(dataOutputStream);
            } catch (IOException e2) {
                e = e2;
                dataOutputStream2 = dataOutputStream;
                try {
                    kg.a(6, f4403b, "", e);
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

    public iz(byte[] bArr) {
        this.f4404a = bArr;
    }

    public byte[] a() {
        return this.f4404a;
    }
}
