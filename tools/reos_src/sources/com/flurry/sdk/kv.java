package com.flurry.sdk;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class kv {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f4656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    LinkedHashMap<String, List<String>> f4657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f4655d = kv.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer f4654a = 50;

    public kv(String str) throws Throwable {
        a(str);
    }

    private synchronized void a(String str, List<String> list, String str2) {
        lt.b();
        kg.a(5, f4655d, "Saving Index File for " + str + " file name:" + js.a().c().getFileStreamPath(g(str)));
        jz jzVar = new jz(js.a().c().getFileStreamPath(g(str)), str2, 1, new le<List<kw>>() { // from class: com.flurry.sdk.kv.7
            @Override // com.flurry.sdk.le
            public lb<List<kw>> a(int i) {
                return new la(new kw.a());
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new kw(it.next()));
        }
        jzVar.a(arrayList);
    }

    private synchronized void a(String str, byte[] bArr) {
        lt.b();
        kg.a(5, f4655d, "Saving Block File for " + str + " file name:" + js.a().c().getFileStreamPath(ku.a(str)));
        new jz(js.a().c().getFileStreamPath(ku.a(str)), ".yflurrydatasenderblock.", 1, new le<ku>() { // from class: com.flurry.sdk.kv.6
            @Override // com.flurry.sdk.le
            public lb<ku> a(int i) {
                return new ku.a();
            }
        }).a(new ku(bArr));
    }

    private synchronized void c() {
        LinkedList linkedList = new LinkedList(this.f4657c.keySet());
        b();
        if (!linkedList.isEmpty()) {
            a(this.f4656b, linkedList, this.f4656b);
        }
    }

    private void e(String str) throws Throwable {
        this.f4657c = new LinkedHashMap<>();
        ArrayList<String> arrayList = new ArrayList();
        if (j(str)) {
            List<String> listK = k(str);
            if (listK != null && listK.size() > 0) {
                arrayList.addAll(listK);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    f((String) it.next());
                }
            }
            i(str);
        } else {
            List list = (List) new jz(js.a().c().getFileStreamPath(g(this.f4656b)), str, 1, new le<List<kw>>() { // from class: com.flurry.sdk.kv.1
                @Override // com.flurry.sdk.le
                public lb<List<kw>> a(int i) {
                    return new la(new kw.a());
                }
            }).a();
            if (list == null) {
                kg.c(f4655d, "New main file also not found. returning..");
                return;
            } else {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((kw) it2.next()).a());
                }
            }
        }
        for (String str2 : arrayList) {
            List<String> listH = h(str2);
            if (listH != null) {
                this.f4657c.put(str2, listH);
            }
        }
    }

    private void f(String str) throws Throwable {
        List<String> listK = k(str);
        if (listK == null) {
            kg.c(f4655d, "No old file to replace");
            return;
        }
        for (String str2 : listK) {
            byte[] bArrM = m(str2);
            if (bArrM == null) {
                kg.a(6, f4655d, "File does not exist");
            } else {
                a(str2, bArrM);
                l(str2);
            }
        }
        if (listK != null) {
            a(str, listK, ".YFlurrySenderIndex.info.");
            i(str);
        }
    }

    private String g(String str) {
        return ".YFlurrySenderIndex.info." + str;
    }

    private synchronized List<String> h(String str) {
        ArrayList arrayList;
        lt.b();
        kg.a(5, f4655d, "Reading Index File for " + str + " file name:" + js.a().c().getFileStreamPath(g(str)));
        List list = (List) new jz(js.a().c().getFileStreamPath(g(str)), ".YFlurrySenderIndex.info.", 1, new le<List<kw>>() { // from class: com.flurry.sdk.kv.5
            @Override // com.flurry.sdk.le
            public lb<List<kw>> a(int i) {
                return new la(new kw.a());
            }
        }).a();
        arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((kw) it.next()).a());
        }
        return arrayList;
    }

    private void i(String str) {
        lt.b();
        kg.a(5, f4655d, "Deleting Index File for " + str + " file name:" + js.a().c().getFileStreamPath(".FlurrySenderIndex.info." + str));
        File fileStreamPath = js.a().c().getFileStreamPath(".FlurrySenderIndex.info." + str);
        if (fileStreamPath.exists()) {
            kg.a(5, f4655d, "Found file for " + str + ". Deleted - " + fileStreamPath.delete());
        }
    }

    private synchronized boolean j(String str) {
        File fileStreamPath;
        fileStreamPath = js.a().c().getFileStreamPath(".FlurrySenderIndex.info." + str);
        kg.a(5, f4655d, "isOldIndexFilePresent: for " + str + fileStreamPath.exists());
        return fileStreamPath.exists();
    }

    private synchronized List<String> k(String str) {
        ArrayList arrayList;
        DataInputStream dataInputStream;
        Throwable th;
        ArrayList arrayList2 = null;
        synchronized (this) {
            lt.b();
            kg.a(5, f4655d, "Reading Index File for " + str + " file name:" + js.a().c().getFileStreamPath(".FlurrySenderIndex.info." + str));
            File fileStreamPath = js.a().c().getFileStreamPath(".FlurrySenderIndex.info." + str);
            if (fileStreamPath.exists()) {
                kg.a(5, f4655d, "Reading Index File for " + str + " Found file.");
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                    try {
                        try {
                            int unsignedShort = dataInputStream.readUnsignedShort();
                            if (unsignedShort == 0) {
                                lt.a((Closeable) dataInputStream);
                            } else {
                                arrayList = new ArrayList(unsignedShort);
                                for (int i = 0; i < unsignedShort; i++) {
                                    try {
                                        int unsignedShort2 = dataInputStream.readUnsignedShort();
                                        kg.a(4, f4655d, "read iter " + i + " dataLength = " + unsignedShort2);
                                        byte[] bArr = new byte[unsignedShort2];
                                        dataInputStream.readFully(bArr);
                                        arrayList.add(new String(bArr));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        kg.a(6, f4655d, "Error when loading persistent file", th);
                                        lt.a((Closeable) dataInputStream);
                                        arrayList2 = arrayList;
                                        return arrayList2;
                                    }
                                }
                                if (dataInputStream.readUnsignedShort() == 0) {
                                }
                                lt.a((Closeable) dataInputStream);
                            }
                        } catch (Throwable th3) {
                            arrayList = null;
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        lt.a((Closeable) dataInputStream);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    dataInputStream = null;
                    lt.a((Closeable) dataInputStream);
                    throw th;
                }
            } else {
                kg.a(5, f4655d, "Agent cache file doesn't exist.");
                arrayList = null;
            }
            arrayList2 = arrayList;
        }
        return arrayList2;
    }

    private void l(String str) {
        lt.b();
        kg.a(5, f4655d, "Deleting  block File for " + str + " file name:" + js.a().c().getFileStreamPath(".flurrydatasenderblock." + str));
        File fileStreamPath = js.a().c().getFileStreamPath(".flurrydatasenderblock." + str);
        if (fileStreamPath.exists()) {
            kg.a(5, f4655d, "Found file for " + str + ". Deleted - " + fileStreamPath.delete());
        }
    }

    private byte[] m(String str) throws Throwable {
        DataInputStream dataInputStream;
        Throwable th;
        byte[] bArr = null;
        lt.b();
        kg.a(5, f4655d, "Reading block File for " + str + " file name:" + js.a().c().getFileStreamPath(".flurrydatasenderblock." + str));
        File fileStreamPath = js.a().c().getFileStreamPath(".flurrydatasenderblock." + str);
        if (fileStreamPath.exists()) {
            kg.a(5, f4655d, "Reading Index File for " + str + " Found file.");
            try {
                dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                try {
                    try {
                        int unsignedShort = dataInputStream.readUnsignedShort();
                        if (unsignedShort == 0) {
                            lt.a((Closeable) dataInputStream);
                        } else {
                            bArr = new byte[unsignedShort];
                            dataInputStream.readFully(bArr);
                            if (dataInputStream.readUnsignedShort() == 0) {
                            }
                            lt.a((Closeable) dataInputStream);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        kg.a(6, f4655d, "Error when loading persistent file", th);
                        lt.a((Closeable) dataInputStream);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    lt.a((Closeable) dataInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                dataInputStream = null;
                th = th4;
                lt.a((Closeable) dataInputStream);
                throw th;
            }
        } else {
            kg.a(4, f4655d, "Agent cache file doesn't exist.");
        }
        return bArr;
    }

    public List<String> a() {
        return new ArrayList(this.f4657c.keySet());
    }

    public synchronized void a(ku kuVar, String str) {
        List<String> linkedList;
        boolean z = false;
        synchronized (this) {
            kg.a(4, f4655d, "addBlockInfo" + str);
            String strA = kuVar.a();
            List<String> list = this.f4657c.get(str);
            if (list == null) {
                kg.a(4, f4655d, "New Data Key");
                linkedList = new LinkedList();
                z = true;
            } else {
                linkedList = list;
            }
            linkedList.add(strA);
            if (linkedList.size() > f4654a.intValue()) {
                b(linkedList.get(0));
                linkedList.remove(0);
            }
            this.f4657c.put(str, linkedList);
            a(str, linkedList, ".YFlurrySenderIndex.info.");
            if (z) {
                c();
            }
        }
    }

    void a(String str) throws Throwable {
        this.f4656b = str + "Main";
        e(this.f4656b);
    }

    public boolean a(String str, String str2) {
        List<String> list = this.f4657c.get(str2);
        boolean zRemove = false;
        if (list != null) {
            b(str);
            zRemove = list.remove(str);
        }
        if (list == null || list.isEmpty()) {
            d(str2);
        } else {
            this.f4657c.put(str2, list);
            a(str2, list, ".YFlurrySenderIndex.info.");
        }
        return zRemove;
    }

    void b() {
        new jz(js.a().c().getFileStreamPath(g(this.f4656b)), ".YFlurrySenderIndex.info.", 1, new le<List<kw>>() { // from class: com.flurry.sdk.kv.4
            @Override // com.flurry.sdk.le
            public lb<List<kw>> a(int i) {
                return new la(new kw.a());
            }
        }).b();
    }

    boolean b(String str) {
        return new jz(js.a().c().getFileStreamPath(ku.a(str)), ".yflurrydatasenderblock.", 1, new le<ku>() { // from class: com.flurry.sdk.kv.2
            @Override // com.flurry.sdk.le
            public lb<ku> a(int i) {
                return new ku.a();
            }
        }).b();
    }

    public List<String> c(String str) {
        return this.f4657c.get(str);
    }

    public synchronized boolean d(String str) {
        boolean zB;
        lt.b();
        jz jzVar = new jz(js.a().c().getFileStreamPath(g(str)), ".YFlurrySenderIndex.info.", 1, new le<List<kw>>() { // from class: com.flurry.sdk.kv.3
            @Override // com.flurry.sdk.le
            public lb<List<kw>> a(int i) {
                return new la(new kw.a());
            }
        });
        List<String> listC = c(str);
        if (listC != null) {
            kg.a(4, f4655d, "discardOutdatedBlocksForDataKey: notSentBlocks = " + listC.size());
            for (String str2 : listC) {
                b(str2);
                kg.a(4, f4655d, "discardOutdatedBlocksForDataKey: removed block = " + str2);
            }
        }
        this.f4657c.remove(str);
        zB = jzVar.b();
        c();
        return zB;
    }
}
