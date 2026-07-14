package com.a.a.j;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import com.flurry.android.Constants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f2516a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f2517b = new char[64];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f2518c = new char[40];

    /* JADX INFO: renamed from: com.a.a.j.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2519a = new int[Bitmap.Config.values().length];

        static {
            try {
                f2519a[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2519a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2519a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2519a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static int a(int i, int i2, Bitmap.Config config) {
        return i * i2 * a(config);
    }

    private static int a(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        switch (AnonymousClass1.f2519a[config.ordinal()]) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            default:
                return 4;
        }
    }

    @TargetApi(19)
    public static int a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException e2) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static String a(byte[] bArr) {
        String strA;
        synchronized (f2517b) {
            strA = a(bArr, f2517b);
        }
        return strA;
    }

    private static String a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & Constants.UNKNOWN;
            cArr[i * 2] = f2516a[i2 >>> 4];
            cArr[(i * 2) + 1] = f2516a[i2 & 15];
        }
        return new String(cArr);
    }

    public static <T> List<T> a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <T> Queue<T> a(int i) {
        return new ArrayDeque(i);
    }

    public static void a() {
        if (!c()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean a(int i, int i2) {
        return b(i) && b(i2);
    }

    public static void b() {
        if (!d()) {
            throw new IllegalArgumentException("YOu must call this method on a background thread");
        }
    }

    private static boolean b(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean d() {
        return !c();
    }
}
