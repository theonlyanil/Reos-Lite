package com.facebook.a;

import android.content.Context;
import android.util.Log;
import com.facebook.b.ad;
import com.facebook.m;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3580a = e.class.getName();

    private static class a extends ObjectInputStream {
        public a(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
            ObjectStreamClass classDescriptor = super.readClassDescriptor();
            if (classDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                return ObjectStreamClass.lookup(com.facebook.a.a.C0068a.class);
            }
            return classDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1") ? ObjectStreamClass.lookup(b.a.class) : classDescriptor;
        }
    }

    e() {
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002f A[Catch: all -> 0x003f, TRY_ENTER, TRY_LEAVE, TryCatch #10 {, blocks: (B:4:0x0004, B:7:0x0021, B:8:0x0024, B:10:0x002f, B:14:0x0037, B:36:0x007e, B:37:0x0081, B:38:0x008a, B:40:0x008c, B:30:0x0065, B:31:0x0068, B:34:0x0074, B:21:0x0044, B:22:0x0047, B:25:0x0053), top: B:49:0x0004, inners: #2, #6, #7, #9 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static synchronized j a() {
        a aVar;
        a aVar2;
        j jVar;
        Object obj;
        ?? r2 = 0;
        synchronized (e.class) {
            try {
                b();
                ?? F = m.f();
                try {
                    aVar = new a(new BufferedInputStream(F.openFileInput("AppEventsLogger.persistedevents")));
                    try {
                        jVar = (j) aVar.readObject();
                        ad.a((Closeable) aVar);
                        try {
                            File fileStreamPath = F.getFileStreamPath("AppEventsLogger.persistedevents");
                            fileStreamPath.delete();
                            obj = fileStreamPath;
                            F = F;
                        } catch (Exception e2) {
                            Log.w(f3580a, "Got unexpected exception when removing events file: ", e2);
                            obj = e2;
                            F = "Got unexpected exception when removing events file: ";
                        }
                    } catch (FileNotFoundException e3) {
                        aVar2 = aVar;
                        ad.a((Closeable) aVar2);
                        try {
                            F.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                            jVar = null;
                        } catch (Exception e4) {
                            Log.w(f3580a, "Got unexpected exception when removing events file: ", e4);
                            jVar = null;
                        }
                        if (jVar == null) {
                            jVar = new j();
                        }
                        return jVar;
                    } catch (Exception e5) {
                        e = e5;
                        Log.w(f3580a, "Got unexpected exception while reading events: ", e);
                        ad.a((Closeable) aVar);
                        try {
                            F.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                            jVar = null;
                            obj = aVar;
                            F = F;
                        } catch (Exception e6) {
                            String str = f3580a;
                            Log.w(str, "Got unexpected exception when removing events file: ", e6);
                            jVar = null;
                            obj = str;
                            F = "Got unexpected exception when removing events file: ";
                        }
                    }
                } catch (FileNotFoundException e7) {
                    aVar2 = null;
                } catch (Exception e8) {
                    e = e8;
                    aVar = null;
                } catch (Throwable th) {
                    th = th;
                    ad.a((Closeable) r2);
                    try {
                        F.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception e9) {
                        Log.w(f3580a, "Got unexpected exception when removing events file: ", e9);
                    }
                    throw th;
                }
                if (jVar == null) {
                    jVar = new j();
                }
            } catch (Throwable th2) {
                th = th2;
                r2 = obj;
            }
        }
        return jVar;
    }

    public static synchronized void a(com.facebook.a.a aVar, k kVar) {
        b();
        j jVarA = a();
        if (jVarA.b(aVar)) {
            jVarA.a(aVar).addAll(kVar.b());
        } else {
            jVarA.a(aVar, kVar.b());
        }
        a(jVarA);
    }

    private static void a(j jVar) throws Throwable {
        ObjectOutputStream objectOutputStream;
        Context contextF = m.f();
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(contextF.openFileOutput("AppEventsLogger.persistedevents", 0)));
            try {
                try {
                    objectOutputStream.writeObject(jVar);
                    ad.a(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    Log.w(f3580a, "Got unexpected exception while persisting events: ", e);
                    try {
                        contextF.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception e3) {
                    }
                    ad.a(objectOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                ad.a(objectOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            objectOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = null;
            ad.a(objectOutputStream);
            throw th;
        }
    }

    private static void b() {
    }
}
