package com.facebook.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3713a = c.class.getCanonicalName();
    private static c g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3718f;

    private static final class a implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f3719a;

        a(IBinder iBinder) {
            this.f3719a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f3719a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f3719a;
        }

        public boolean b() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(1);
                this.f3719a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    private static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AtomicBoolean f3720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BlockingQueue<IBinder> f3721b;

        private b() {
            this.f3720a = new AtomicBoolean(false);
            this.f3721b = new LinkedBlockingDeque();
        }

        public IBinder a() throws InterruptedException {
            if (this.f3720a.compareAndSet(true, true)) {
                throw new IllegalStateException("Binder already consumed");
            }
            return this.f3721b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f3721b.put(iBinder);
            } catch (InterruptedException e2) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00ed  */
    public static c a(Context context) throws Throwable {
        Cursor cursorQuery;
        Uri uri;
        Cursor cursor = null;
        if (g != null && System.currentTimeMillis() - g.f3718f < 3600000) {
            return g;
        }
        c cVarB = b(context);
        try {
            try {
                String[] strArr = {"aid", "androidid", "limit_tracking"};
                if (context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0) != null) {
                    uri = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
                } else {
                    uri = context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0) != null ? Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider") : null;
                }
                String strE = e(context);
                if (strE != null) {
                    cVarB.f3716d = strE;
                }
                if (uri == null) {
                    c cVarA = a(cVarB);
                    if (0 == 0) {
                        return cVarA;
                    }
                    cursor.close();
                    return cVarA;
                }
                cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int columnIndex = cursorQuery.getColumnIndex("aid");
                            int columnIndex2 = cursorQuery.getColumnIndex("androidid");
                            int columnIndex3 = cursorQuery.getColumnIndex("limit_tracking");
                            cVarB.f3714b = cursorQuery.getString(columnIndex);
                            if (columnIndex2 > 0 && columnIndex3 > 0 && cVarB.b() == null) {
                                cVarB.f3715c = cursorQuery.getString(columnIndex2);
                                cVarB.f3717e = Boolean.parseBoolean(cursorQuery.getString(columnIndex3));
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return a(cVarB);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        Log.d(f3713a, "Caught unexpected exception in getAttributionId(): " + e.toString());
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                }
                c cVarA2 = a(cVarB);
                if (cursorQuery == null) {
                    return cVarA2;
                }
                cursorQuery.close();
                return cVarA2;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private static c a(c cVar) {
        cVar.f3718f = System.currentTimeMillis();
        g = cVar;
        return cVar;
    }

    private static c b(Context context) {
        c cVarC = c(context);
        if (cVarC != null) {
            return cVarC;
        }
        c cVarD = d(context);
        return cVarD == null ? new c() : cVarD;
    }

    private static c c(Context context) {
        Object objA;
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new com.facebook.k("getAndroidId cannot be called on the main thread.");
            }
            Method methodA = ad.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
            if (methodA == null) {
                return null;
            }
            Object objA2 = ad.a((Object) null, methodA, context);
            if (!(objA2 instanceof Integer) || ((Integer) objA2).intValue() != 0) {
                return null;
            }
            Method methodA2 = ad.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
            if (methodA2 != null && (objA = ad.a((Object) null, methodA2, context)) != null) {
                Method methodA3 = ad.a(objA.getClass(), "getId", (Class<?>[]) new Class[0]);
                Method methodA4 = ad.a(objA.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                if (methodA3 == null || methodA4 == null) {
                    return null;
                }
                c cVar = new c();
                cVar.f3715c = (String) ad.a(objA, methodA3, new Object[0]);
                cVar.f3717e = ((Boolean) ad.a(objA, methodA4, new Object[0])).booleanValue();
                return cVar;
            }
            return null;
        } catch (Exception e2) {
            ad.a("android_id", e2);
            return null;
        }
    }

    private static c d(Context context) {
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (context.bindService(intent, bVar, 1)) {
                a aVar = new a(bVar.a());
                c cVar = new c();
                cVar.f3715c = aVar.a();
                cVar.f3717e = aVar.b();
                return cVar;
            }
        } catch (Exception e2) {
            ad.a("android_id", e2);
        } finally {
            context.unbindService(bVar);
        }
        return null;
    }

    private static String e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }

    public String a() {
        return this.f3714b;
    }

    public String b() {
        return this.f3715c;
    }

    public String c() {
        return this.f3716d;
    }

    public boolean d() {
        return this.f3717e;
    }
}
