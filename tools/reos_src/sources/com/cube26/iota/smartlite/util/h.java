package com.cube26.iota.smartlite.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v4.app.ag;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.TextView;
import android.widget.Toast;
import com.android.library.userprofile.util.Constants;
import com.cube26.iota.smartlite.Alerts.IncomingCallIReceiver;
import com.cube26.iota.smartlite.BluetoothLeService;
import com.cube26.iota.smartlite.MainActivity;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.ScheduleNotificationAlertReceiver;
import com.cube26.iota.smartlite.neonmusic.visualizer.VisualizerView;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static boolean A;
    public static Handler B;
    public static Handler C;
    public static ArrayList<String> D;
    public static final Random E;
    public static Calendar F;
    public static int G;
    public static int H;
    public static VisualizerView I;
    public static final int[] J;
    public static final int[] K;
    public static volatile boolean L;
    public static boolean M;
    public static boolean N;
    public static final Map<String, String> O;
    public static String P;
    public static int Q;
    public static final Integer[] R;
    public static final Integer[] S;
    public static int T;
    public static int U;
    static ProgressDialog V;
    static byte[] W;
    private static int X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f3468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f3469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Handler f3470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f3471e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f3472f = false;
    public static boolean g = false;
    public static final int[] h = {R.drawable.callactivated, R.drawable.smsactivated, R.drawable.youtubeactivated, R.drawable.weatheractivated, R.drawable.whatsappactivated, R.drawable.hikeactivated, R.drawable.olaactivated, R.drawable.uberactivated, R.drawable.facebookactivated, R.drawable.facebookactivated, R.drawable.tinderactivated, R.drawable.dominosactivated, R.drawable.bigbasketactivated, R.drawable.grofersactivated, R.drawable.swiggyactivated};
    public static HashMap<String, Integer> i = new HashMap<>();
    public static HashMap<Integer, String> j = new HashMap<>();
    public static boolean k = false;
    public static boolean l;
    public static Object m;
    public static int n;
    public static HashMap<String, Boolean> o;
    public static boolean p;
    public static boolean q;
    public static int r;
    public static BluetoothAdapter s;
    public static BluetoothLeService t;
    public static BluetoothLeScanner u;
    public static ArrayList<com.cube26.iota.smartlite.d.a> v;
    public static ArrayList<com.cube26.iota.smartlite.d.a> w;
    public static ArrayList<String> x;
    public static com.cube26.iota.smartlite.util.a y;
    public static j z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f3473a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static String f3474b = "mobile/register";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static String f3475c = "mobile/verify";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static String f3476d = "add-user-data";
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f3477a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static String f3478b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static String f3479c = "android/latest-version/";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static String f3480d = "users/";
    }

    static {
        i.put("com.whatsapp", 5);
        i.put("com.bsb.hike", 6);
        i.put("com.olacabs.customer", 7);
        i.put("com.ubercab", 8);
        i.put("com.facebook.katana", 9);
        i.put("com.facebook.orca", 10);
        i.put("com.tinder", 11);
        i.put("com.Dominos", 12);
        i.put("com.bigbasket.mobileapp", 13);
        i.put("com.grofers.customerapp", 14);
        i.put("in.swiggy.android", 15);
        j.put(5, "com.whatsapp");
        j.put(6, "com.bsb.hike");
        j.put(7, "com.olacabs.customer");
        j.put(8, "com.ubercab");
        j.put(9, "com.facebook.katana");
        j.put(10, "com.facebook.orca");
        j.put(11, "com.tinder");
        j.put(12, "com.Dominos");
        j.put(13, "com.bigbasket.mobileapp");
        j.put(14, "com.grofers.customerapp");
        j.put(15, "in.swiggy.android");
        l = false;
        n = 0;
        o = new HashMap<>(7);
        p = true;
        q = false;
        r = -1;
        s = null;
        t = null;
        u = null;
        v = new ArrayList<>(7);
        w = new ArrayList<>(7);
        x = new ArrayList<>();
        y = null;
        z = null;
        A = true;
        D = new ArrayList<>();
        E = new Random();
        G = 0;
        H = 200;
        J = new int[3];
        K = new int[3];
        L = false;
        M = false;
        N = false;
        O = new HashMap();
        P = "MusicSyncOn";
        Q = 0;
        R = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 13, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 24, 24, 25, 25, 26, 27, 27, 28, 29, 29, 30, 31, 32, 32, 33, 34, 35, 35, 36, 37, 38, 39, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 50, 51, 52, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 66, 67, 68, 69, 70, 72, 73, 74, 75, 77, 78, 79, 81, 82, 83, 85, 86, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 107, 109, 110, 112, 114, 115, 117, 119, 120, 122, 124, 126, 127, 129, 131, 133, 135, 137, 138, 140, 142, 144, 146, 148, 150, 152, 154, 156, 158, 160, 162, 164, 167, 169, 171, 173, 175, 177, 180, 182, 184, 186, 189, 191, 193, 196, 198, 200, 203, 205, 208, 210, 213, 215, 218, 220, 223, 225, 228, 231, 233, 236, 239, 241, 244, 247, 249, 252, 255};
        S = new Integer[]{Integer.valueOf(R.drawable.mode_1), Integer.valueOf(R.drawable.mode_2), Integer.valueOf(R.drawable.mode_3), Integer.valueOf(R.drawable.mode_4), Integer.valueOf(R.drawable.mode_5), Integer.valueOf(R.drawable.mode_6), Integer.valueOf(R.drawable.mode_7), Integer.valueOf(R.drawable.mode_8), Integer.valueOf(R.drawable.mode_9), Integer.valueOf(R.drawable.mode_10), Integer.valueOf(R.drawable.mode_11), Integer.valueOf(R.drawable.mode_12), Integer.valueOf(R.drawable.mode_13), Integer.valueOf(R.drawable.mode_14), Integer.valueOf(R.drawable.mode_15), Integer.valueOf(R.drawable.mode_16), Integer.valueOf(R.drawable.mode_17), Integer.valueOf(R.drawable.mode_18), Integer.valueOf(R.drawable.mode_19), Integer.valueOf(R.drawable.mode_20), Integer.valueOf(R.drawable.mode_21), Integer.valueOf(R.drawable.mode_22), Integer.valueOf(R.drawable.mode_23), Integer.valueOf(R.drawable.mode_24), Integer.valueOf(R.drawable.mode_25)};
        T = -1;
        U = -1;
        X = 200;
    }

    public static Bitmap a(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        new Canvas(bitmapCreateBitmap).drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        com.cube26.iota.smartlite.util.b.a("IOTA", " circular bitmap width :: " + bitmapCreateBitmap.getWidth() + " :: height :: " + bitmapCreateBitmap.getHeight());
        return bitmapCreateBitmap;
    }

    public static Bitmap a(Bitmap bitmap, float f2) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i2 / height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        com.cube26.iota.smartlite.util.b.a("IOTA", " resized bitmap :: width :: " + bitmapCreateBitmap.getWidth() + " :: height :: " + bitmapCreateBitmap.getHeight());
        return bitmapCreateBitmap;
    }

    public static Bitmap a(Bitmap bitmap, String str) throws IOException {
        int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
        com.cube26.iota.smartlite.util.b.a("IOTA", " orientation :: " + attributeInt);
        switch (attributeInt) {
            case 2:
                return a(bitmap, true, false);
            case 3:
                return a(bitmap, 180.0f);
            case 4:
                return a(bitmap, false, true);
            case 5:
            case 7:
            default:
                return bitmap;
            case 6:
                return a(bitmap, 90.0f);
            case 8:
                return a(bitmap, 270.0f);
        }
    }

    public static Bitmap a(Bitmap bitmap, boolean z2, boolean z3) {
        Matrix matrix = new Matrix();
        matrix.preScale(z2 ? -1.0f : 1.0f, z3 ? -1.0f : 1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static String a() {
        String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
        try {
            return new UUID(str.hashCode(), Build.class.getField("SERIAL").get(null).toString().hashCode()).toString();
        } catch (Exception e2) {
            return new UUID(str.hashCode(), "serial".hashCode()).toString();
        }
    }

    public static String a(Context context, String str) {
        String string = null;
        Cursor cursorQuery = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name", Constants.SMS_COLUMN_ID}, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("display_name"));
                string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_ID));
            }
            cursorQuery.close();
        }
        return string;
    }

    public static String a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                inputStream.close();
                return str;
            }
            str = str + line;
        }
    }

    public static String a(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("Su");
        arrayList2.add("M");
        arrayList2.add("T");
        arrayList2.add("W");
        arrayList2.add("Th");
        arrayList2.add("F");
        arrayList2.add("S");
        Iterator<String> it = arrayList.iterator();
        byte bIndexOf = 0;
        while (it.hasNext()) {
            bIndexOf = (byte) ((1 << arrayList2.indexOf(it.next())) | bIndexOf);
        }
        String strReplace = String.format("%8s", Integer.toBinaryString(bIndexOf & com.flurry.android.Constants.UNKNOWN)).replace(' ', '0');
        com.cube26.iota.smartlite.util.b.a("IOTA", "parsedByteString  :: " + strReplace);
        return strReplace;
    }

    public static void a(int i2, byte b2) {
        int i3 = 1;
        com.cube26.iota.smartlite.util.b.a("IOTA", " check schedule " + i2);
        byte[] bArr = {15, 6, 20, 0, b2, 0, 0, 0, -1, -1};
        for (int i4 = 2; i4 < 7; i4++) {
            i3 += bArr[i4];
        }
        bArr[7] = (byte) (i3 & 255);
        a((Handler) null, 2004, i2, bArr);
    }

    public static void a(int i2, int i3) {
        int i4 = 1;
        byte[] bArr = {15, 13, 3, 0, (byte) J[0], (byte) J[1], (byte) J[2], (byte) H, (byte) i2, 1, 1, 0, 0, 0, 0, -1, -1};
        for (int i5 = 2; i5 < 14; i5++) {
            i4 += bArr[i5];
        }
        bArr[14] = (byte) (i4 & 255);
        a((Handler) null, 2004, i3, bArr);
    }

    public static void a(int i2, int i3, int i4) {
        try {
            B.removeCallbacksAndMessages(null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.cube26.iota.smartlite.util.b.a("IOTA", "Canceling " + com.cube26.iota.smartlite.c.c.f3272c + " OLD :: " + com.cube26.iota.smartlite.c.c.f3273d);
        N = false;
        com.cube26.iota.smartlite.c.c.f3273d = "";
        com.cube26.iota.smartlite.c.c.f3272c = "";
        com.cube26.iota.smartlite.util.b.a("IOTA", "Canceling Handlers from color");
        com.cube26.iota.smartlite.c.c.a();
        if (com.cube26.iota.smartlite.c.c.f3274e.equalsIgnoreCase("candle") || com.cube26.iota.smartlite.c.c.f3274e.equalsIgnoreCase("Strobe") || com.cube26.iota.smartlite.c.c.f3274e.equalsIgnoreCase("Kaleidoscope")) {
            for (int i5 = 0; i5 < v.size(); i5++) {
                b(0, 0, 0, 0, i5, "PhoneCancel");
            }
        } else if (com.cube26.iota.smartlite.c.c.f3274e.equalsIgnoreCase("shake")) {
            com.cube26.iota.smartlite.c.c.f3275f.unregisterListener(com.cube26.iota.smartlite.c.c.B);
        }
        if (i2 == 0 && i3 == 0 && i4 == 0) {
            for (int i6 = 0; i6 < v.size(); i6++) {
                b(com.cube26.iota.smartlite.c.b.f3256a[0], com.cube26.iota.smartlite.c.b.f3256a[1], com.cube26.iota.smartlite.c.b.f3256a[2], H, i6, "Wheel");
            }
        }
    }

    public static void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = 1;
        byte[] bArr = {15, 13, 3, 0, (byte) i2, (byte) i3, (byte) i4, (byte) i5, (byte) i7, 1, 1, 0, 0, 0, 0, -1, -1};
        for (int i9 = 2; i9 < 14; i9++) {
            i8 += bArr[i9];
        }
        bArr[14] = (byte) (i8 & 255);
        a((Handler) null, 2004, i6, bArr);
    }

    public static void a(int i2, int i3, int i4, int i5, int i6, int i7, byte b2, byte b3, byte b4) {
        com.cube26.iota.smartlite.util.b.a("IOTA", " setliteschedule tag :: " + i2);
        if (i3 == 1) {
            Calendar calendar = Calendar.getInstance();
            com.cube26.iota.smartlite.util.b.a("IOTA", "Scheduling your tasks for switching it on :: ");
            byte[] bArr = {15, 19, 19, 0, 0, 0, 1, 1, b4, (byte) (calendar.get(1) % CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE), (byte) (calendar.get(2) + 1), (byte) calendar.get(5), b3, b2, 0, 0, (byte) i4, (byte) i5, (byte) i6, -56, 0, -1, -1};
            int i8 = 1;
            for (int i9 = 2; i9 < 20; i9++) {
                i8 += bArr[i9];
            }
            bArr[20] = (byte) (i8 & 255);
            byte[] bArr2 = new byte[20];
            System.arraycopy(bArr, 0, bArr2, 0, 20);
            byte[] bArr3 = new byte[3];
            System.arraycopy(bArr, 20, bArr3, 0, 3);
            for (byte b5 : bArr) {
                com.cube26.iota.smartlite.util.b.a("IOTA", " on :: " + ((int) b5));
            }
            d(i2);
            try {
                Thread.sleep(50L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a((Handler) null, 2004, i2, bArr2);
            try {
                Thread.sleep(50L);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            a((Handler) null, 2004, i2, bArr3);
            try {
                Thread.sleep(50L);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            f(i2);
            return;
        }
        Calendar calendar2 = Calendar.getInstance();
        com.cube26.iota.smartlite.util.b.a("IOTA", "Scheduling your tasks for switching it off:: ");
        byte[] bArr4 = {15, 19, 19, 0, 0, 0, 1, 0, b4, (byte) (calendar2.get(1) % CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE), (byte) (calendar2.get(2) + 1), (byte) calendar2.get(5), b3, b2, 0, 0, 0, 0, 0, 0, 0, -1, -1};
        int i10 = 1;
        for (int i11 = 2; i11 < 20; i11++) {
            i10 += bArr4[i11];
        }
        bArr4[20] = (byte) (i10 & 255);
        byte[] bArr5 = new byte[20];
        System.arraycopy(bArr4, 0, bArr5, 0, 20);
        byte[] bArr6 = new byte[3];
        System.arraycopy(bArr4, 20, bArr6, 0, 3);
        for (byte b6 : bArr4) {
            com.cube26.iota.smartlite.util.b.a("IOTA", " off :: " + ((int) b6));
        }
        d(i2);
        try {
            Thread.sleep(50L);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        a((Handler) null, 2004, i2, bArr5);
        try {
            Thread.sleep(50L);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        a((Handler) null, 2004, i2, bArr6);
        try {
            Thread.sleep(50L);
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        f(i2);
    }

    public static void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, byte b2, byte b3, byte b4) {
        Calendar calendar = Calendar.getInstance();
        byte[] bArr = {15, 19, 19, 0, 1, (byte) i3, (byte) i4, (byte) i5, b4, (byte) (calendar.get(1) % CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE), (byte) (calendar.get(2) + 1), (byte) calendar.get(5), b2, b3, 0, 0, (byte) i6, (byte) i7, (byte) i8, -56, 0, -1, -1};
        int i10 = 1;
        for (int i11 = 2; i11 < 20; i11++) {
            i10 += bArr[i11];
        }
        bArr[20] = (byte) (i10 & 255);
        byte[] bArr2 = new byte[20];
        System.arraycopy(bArr, 0, bArr2, 0, 20);
        byte[] bArr3 = new byte[3];
        System.arraycopy(bArr, 20, bArr3, 0, 3);
        d(i2);
        a((Handler) null, 2004, i2, bArr2);
        try {
            Thread.sleep(50L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a((Handler) null, 2004, i2, bArr3);
        try {
            Thread.sleep(50L);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(int i2, int i3, int i4, int i5, int i6, int i7, String str, String str2) {
        int iIntValue = R[i2].intValue();
        int iIntValue2 = R[i3].intValue();
        int iIntValue3 = R[i4].intValue();
        if (str2.equals("Fade in")) {
            W = new byte[]{15, 10, 13, 0, (byte) iIntValue, (byte) iIntValue2, (byte) iIntValue3, (byte) i5, (byte) i7, 0, 0, 0, -1, -1};
            int i8 = 1;
            for (int i9 = 2; i9 < 11; i9++) {
                i8 += W[i9];
            }
            W[11] = (byte) (i8 & 255);
        } else {
            W = new byte[]{15, 10, 13, 0, (byte) iIntValue, (byte) iIntValue2, (byte) iIntValue3, -56, (byte) i7, 0, 0, 0, -1, -1};
            int i10 = 1;
            for (int i11 = 2; i11 < 11; i11++) {
                i10 += W[i11];
            }
            W[11] = (byte) (i10 & 255);
        }
        a((Handler) null, 5000, i6, W);
    }

    public static void a(int i2, int i3, int i4, int i5, int i6, String str) {
        if (i6 == 0) {
            for (int i7 = 0; i7 < 3; i7++) {
                K[i7] = J[i7];
            }
        }
        byte[] bArr = {15, 11, 18, 0, 3, 2, (byte) i2, (byte) i3, (byte) i4, (byte) i5, 0, 0, 0, -1, -1};
        int i8 = 1;
        for (int i9 = 2; i9 < 12; i9++) {
            i8 += bArr[i9];
        }
        bArr[12] = (byte) (i8 & 255);
        a((Handler) null, 5000, i6, bArr);
    }

    public static void a(int i2, int i3, int i4, int i5, int i6, String str, String str2) {
        int iIntValue = R[i2].intValue();
        int iIntValue2 = R[i3].intValue();
        int iIntValue3 = R[i4].intValue();
        if (i6 == 0) {
            K[0] = J[0];
            K[1] = J[1];
            K[2] = J[2];
        }
        if (str.equals("Phone")) {
            if (str2.equalsIgnoreCase("Single Flash Alert")) {
                com.cube26.iota.smartlite.util.b.b("IOTA", "flash alert");
                W = new byte[]{15, 12, 12, 0, 1, 0, 1, (byte) iIntValue, (byte) iIntValue2, (byte) iIntValue3, (byte) i5, 0, 0, 0, -1, -1};
                int i7 = 1;
                for (int i8 = 2; i8 < 13; i8++) {
                    i7 += W[i8];
                }
                W[13] = (byte) (i7 & 255);
            }
            if (str2.equalsIgnoreCase("Flash Alert")) {
                com.cube26.iota.smartlite.util.b.b("IOTA", "flash alert");
                W = new byte[]{15, 12, 12, 0, 5, 0, 1, (byte) iIntValue, (byte) iIntValue2, (byte) iIntValue3, (byte) i5, 0, 0, 0, -1, -1};
                int i9 = 1;
                for (int i10 = 2; i10 < 13; i10++) {
                    i9 += W[i10];
                }
                W[13] = (byte) (i9 & 255);
            }
            if (str2.equalsIgnoreCase("Fade in")) {
                com.cube26.iota.smartlite.util.b.b("IOTA", "fade in  r::" + iIntValue + " g :: " + iIntValue2 + "b ::" + iIntValue3);
                W = new byte[]{15, 10, 13, 0, (byte) iIntValue, (byte) iIntValue2, (byte) iIntValue3, 100, 5, 0, 0, 0, -1, -1};
                int i11 = 1;
                for (int i12 = 2; i12 < 11; i12++) {
                    i11 += W[i12];
                }
                W[11] = (byte) (i11 & 255);
            }
            if (str2.equalsIgnoreCase("Fade out")) {
                com.cube26.iota.smartlite.util.b.b("IOTA", "fade out");
                W = new byte[]{15, 10, 13, 0, (byte) iIntValue, (byte) iIntValue2, (byte) iIntValue3, -56, 5, 0, 0, 0, -1, -1};
                int i13 = 1;
                for (int i14 = 2; i14 < 11; i14++) {
                    i13 += W[i14];
                }
                W[11] = (byte) (i13 & 255);
            }
            if (str2.equalsIgnoreCase("Candle Flicker")) {
                com.cube26.iota.smartlite.util.b.a("IOTA", "Candle Flicker effect invoked");
                W = new byte[]{15, 11, 18, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0, -1, -1};
                int i15 = 1;
                for (int i16 = 2; i16 < 12; i16++) {
                    i15 += W[i16];
                }
                W[12] = (byte) (i15 & 255);
            }
            if (str2.equalsIgnoreCase("Strobe")) {
                J[0] = 255;
                J[1] = 0;
                J[2] = 255;
                com.cube26.iota.smartlite.util.b.a("IOTA", "Strobe effect invoked");
                W = new byte[]{15, 11, 18, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, -1, -1};
                int i17 = 1;
                for (int i18 = 2; i18 < 12; i18++) {
                    i17 += W[i18];
                }
                W[12] = (byte) (i17 & 255);
            }
            if (str2.equalsIgnoreCase("Kaleidoscope")) {
                com.cube26.iota.smartlite.util.b.a("IOTA", "Kaleidoscope effect invoked");
                J[0] = 255;
                J[1] = 0;
                J[2] = 0;
                W = new byte[]{15, 11, 18, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, -1, -1};
                int i19 = 1;
                for (int i20 = 2; i20 < 12; i20++) {
                    i19 += W[i20];
                }
                W[12] = (byte) (i19 & 255);
            }
            a((Handler) null, 5000, i6, W);
        }
    }

    public static void a(int i2, int i3, int i4, boolean z2) {
        if (!N && com.cube26.iota.smartlite.c.d.f3307d) {
            if (!z2) {
                for (int i5 = 0; i5 < v.size(); i5++) {
                    b(i2, i3, i4, H, i5, "Wheel");
                }
            }
            c();
        }
        if (N) {
            a(i2, i3, i4);
        }
        if (!com.cube26.iota.smartlite.c.d.f3307d) {
            b(i2, i3, i4);
        }
        if (com.cube26.iota.smartlite.c.d.i.isChecked() || com.cube26.iota.smartlite.c.d.k.isChecked()) {
            com.cube26.iota.smartlite.util.b.a("IOTA", " canceling microphone");
            b();
        }
    }

    public static void a(int i2, byte[] bArr) {
        if (i2 != -1) {
            try {
                if (i2 >= v.size()) {
                    return;
                }
                synchronized (z) {
                    if (v.get(i2).u() != null && v.get(i2).s() == 2) {
                        v.get(i2).u().setValue(bArr);
                        t.b(i2, v.get(i2).u());
                    }
                }
            } catch (NullPointerException e2) {
                com.cube26.iota.smartlite.util.b.a("IOTA", " npe ");
            }
        }
    }

    public static void a(Context context) {
        Toast.makeText(context, "This feature is not available in Virtual Mode.", 0).show();
    }

    public static void a(Context context, int i2) {
        Intent intent = new Intent(context, (Class<?>) ScheduleNotificationAlertReceiver.class);
        intent.putExtra("scheduleNotificationId", i2);
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, i2, intent, 0));
    }

    public static void a(Context context, int i2, long j2) {
        com.cube26.iota.smartlite.util.b.a("IOTA", "setNotificationAlert ");
        Intent intent = new Intent(context, (Class<?>) ScheduleNotificationAlertReceiver.class);
        intent.setAction("lite_schedule_notification");
        intent.putExtra("scheduleNotificationId", i2);
        ((AlarmManager) context.getSystemService("alarm")).set(0, j2, PendingIntent.getBroadcast(context, i2, intent, 0));
        com.cube26.iota.smartlite.util.b.a("IOTA", "alarmM set time :: " + j2);
    }

    public static void a(Context context, String str, PendingIntent pendingIntent) {
        System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        ag.d dVarB = new ag.d(context).a(R.drawable.lite).c(Color.parseColor("#F5B700")).a(context.getString(R.string.app_name)).b(str);
        if (pendingIntent != null) {
            dVarB.a(pendingIntent);
        }
        Notification notificationA = dVarB.a();
        new Intent(context, (Class<?>) MainActivity.class).setFlags(603979776);
        notificationA.flags |= 16;
        notificationA.defaults |= 1;
        notificationA.defaults |= 2;
        notificationManager.notify((int) (Math.random() * 10.0d), notificationA);
    }

    public static void a(Handler handler, int i2, int i3, byte[] bArr) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        message.obj = handler;
        message.arg1 = i3;
        message.what = i2;
        bundle.putByteArray("val", bArr);
        message.setData(bundle);
        if (y != null) {
            y.a().sendMessage(message);
        }
    }

    public static void a(String str, int i2, int i3, int i4) {
        int i5 = 1;
        byte b2 = str.equals("on") ? (byte) 1 : str.equals("off") ? (byte) 2 : (byte) 0;
        com.cube26.iota.smartlite.util.b.a("IOTA", "Delay set.static public final String s switch it off mofo's");
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, i2);
        calendar.add(12, i3);
        calendar.add(13, i4);
        byte[] bArr = {15, 15, 9, 0, b2, (byte) calendar.get(13), (byte) calendar.get(12), (byte) calendar.get(11), (byte) calendar.get(5), (byte) (calendar.get(2) + 1), (byte) (calendar.get(1) / 256), (byte) (calendar.get(1) % 256), (byte) K[0], (byte) K[1], (byte) K[2], -56, 0, -1, -1};
        com.cube26.iota.smartlite.util.b.a("IOTA", "Setting Off TimerSec" + calendar.get(13) + "Min" + calendar.get(12) + "Hour" + calendar.get(10) + "Day" + calendar.get(5) + "Month" + calendar.get(2) + "Year" + (calendar.get(1) / 256) + (calendar.get(1) % 256));
        for (int i6 = 2; i6 < 16; i6++) {
            i5 += bArr[i6];
        }
        bArr[16] = (byte) (i5 & 255);
        for (int i7 = 0; i7 < v.size(); i7++) {
            d(i7);
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            a((Handler) null, 2004, i7, bArr);
        }
    }

    public static final boolean a(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    public static boolean a(String str) {
        return (str == null || str.isEmpty() || str.trim().isEmpty()) ? false : true;
    }

    public static boolean a(String str, ArrayList<com.cube26.iota.smartlite.d.a> arrayList) {
        com.cube26.iota.smartlite.util.b.a("IOTA", " isexist :: " + str);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).q().equalsIgnoreCase(str)) {
                com.cube26.iota.smartlite.util.b.a("IOTA", " device already present in scanned device list");
                return true;
            }
        }
        return false;
    }

    public static byte[] a(Context context, long j2) {
        byte[] blob;
        Cursor cursorQuery = context.getContentResolver().query(Uri.withAppendedPath(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j2), "photo"), new String[]{"data15"}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (!cursorQuery.moveToFirst() || (blob = cursorQuery.getBlob(0)) == null) {
                return null;
            }
            cursorQuery.close();
            return blob;
        } finally {
            cursorQuery.close();
        }
    }

    public static int[] a(double d2) {
        double d3;
        double d4;
        double d5;
        double d6;
        if (d2 >= 380.0d && d2 < 440.0d) {
            d3 = 0.0d;
            d4 = (-(d2 - 440.0d)) / 60.0d;
            d5 = 1.0d;
        } else if (d2 >= 440.0d && d2 < 490.0d) {
            d3 = (d2 - 440.0d) / 50.0d;
            d4 = 0.0d;
            d5 = 1.0d;
        } else if (d2 >= 490.0d && d2 < 510.0d) {
            d3 = 1.0d;
            d4 = 0.0d;
            d5 = (-(d2 - 510.0d)) / 20.0d;
        } else if (d2 >= 510.0d && d2 < 580.0d) {
            d3 = 1.0d;
            d4 = (d2 - 510.0d) / 70.0d;
            d5 = 0.0d;
        } else if (d2 >= 580.0d && d2 < 645.0d) {
            d3 = (-(d2 - 645.0d)) / 65.0d;
            d4 = 1.0d;
            d5 = 0.0d;
        } else if (d2 < 645.0d || d2 >= 781.0d) {
            d3 = 0.0d;
            d4 = 0.0d;
            d5 = 0.0d;
        } else {
            d3 = 0.0d;
            d4 = 1.0d;
            d5 = 0.0d;
        }
        if (d2 >= 380.0d && d2 < 420.0d) {
            d6 = 0.3d + ((0.7d * (d2 - 380.0d)) / 40.0d);
        } else if (d2 < 420.0d || d2 >= 701.0d) {
            d6 = (d2 < 701.0d || d2 >= 781.0d) ? 0.0d : 0.3d + ((0.7d * (780.0d - d2)) / 80.0d);
        } else {
            d6 = 1.0d;
        }
        int[] iArr = new int[3];
        iArr[0] = d4 == 0.0d ? 0 : (int) Math.round(Math.pow(d4 * d6, 0.8d) * 255.0d);
        iArr[1] = d3 == 0.0d ? 0 : (int) Math.round(Math.pow(d3 * d6, 0.8d) * 255.0d);
        iArr[2] = d5 == 0.0d ? 0 : (int) Math.round(Math.pow(d6 * d5, 0.8d) * 255.0d);
        return iArr;
    }

    public static int[] a(int i2) {
        return new int[]{Color.red(i2), Color.green(i2), Color.blue(i2)};
    }

    public static int b(String str, ArrayList<com.cube26.iota.smartlite.d.a> arrayList) {
        int i2;
        com.cube26.iota.smartlite.util.b.a("IOTA", " isexist :: " + str);
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i2).q().equalsIgnoreCase(str)) {
                com.cube26.iota.smartlite.util.b.a("IOTA", " device already present in scanned device list");
                break;
            }
            i3 = i2 + 1;
        }
        return i2;
    }

    public static long b(String str, int i2, int i3, int i4) {
        com.cube26.iota.smartlite.util.b.a("IOTA", " getNextSetNotificationTime ");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, i4 * 60 * 1000);
        Date time = calendar.getTime();
        com.cube26.iota.smartlite.util.b.a("IOTA", " now date " + time);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, i2);
        calendar2.set(12, i3);
        Date time2 = calendar2.getTime();
        if (time2.after(time)) {
            return time2.getTime();
        }
        int i5 = 8 - calendar.get(7);
        int length = i5 + 1;
        while (str.charAt(length) != '1') {
            if (length == 1) {
                length = str.length() - 1;
            }
            length--;
        }
        long j2 = length - i5 > 0 ? 7 - (length - i5) : i5 - length;
        com.cube26.iota.smartlite.util.b.a("IOTA", " setDate :: " + time2.getTime() + (24 * j2 * 60 * 60 * 1000));
        return (j2 * 24 * 60 * 60 * 1000) + time2.getTime();
    }

    public static ProgressDialog b(Context context) {
        V = new ProgressDialog(context, R.style.IotaThemeDialog);
        V.setProgressStyle(android.R.style.Widget.Material.ProgressBar.Small);
        V.setMessage("Finding Reos Lite...");
        V.setIndeterminate(true);
        V.requestWindowFeature(1);
        V.setCanceledOnTouchOutside(false);
        V.setCancelable(true);
        V.show();
        ((TextView) V.findViewById(android.R.id.message)).setTextSize(15.0f);
        return V;
    }

    public static ProgressDialog b(Context context, String str) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(str);
        progressDialog.setProgressStyle(0);
        return progressDialog;
    }

    public static SpannableStringBuilder b(String str) {
        com.cube26.iota.smartlite.util.b.a("IOTA", " daysofweek :: " + str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append((CharSequence) Html.fromHtml("Su M T W Th F S"));
        if (str.equals("00000000")) {
            return spannableStringBuilder2;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        arrayList.add("Su");
        arrayList.add("M");
        arrayList.add("T");
        arrayList.add("W");
        arrayList.add("Th");
        arrayList.add("F");
        arrayList.add("S");
        for (int length = str.length() - 1; length > 0; length--) {
            if (str.charAt(length) == '1') {
                spannableStringBuilder.append((CharSequence) Html.fromHtml("<b> " + ((String) arrayList.get(8 - length)) + " </b>"));
            } else {
                spannableStringBuilder.append((CharSequence) Html.fromHtml(" " + ((String) arrayList.get(8 - length)) + " "));
            }
        }
        return spannableStringBuilder;
    }

    public static void b() {
        if (com.cube26.iota.smartlite.c.d.i != null && com.cube26.iota.smartlite.c.d.i.isChecked()) {
            com.cube26.iota.smartlite.c.d.i.setChecked(false);
        }
        if (com.cube26.iota.smartlite.c.d.k == null || !com.cube26.iota.smartlite.c.d.k.isChecked()) {
            return;
        }
        com.cube26.iota.smartlite.c.d.k.setChecked(false);
        com.cube26.iota.smartlite.c.d.e();
    }

    public static void b(int i2) {
        byte[] bArr = {15, 7, 5, 0, 0, 1, 1, 1, 0, -1, -1};
        int i3 = 1;
        for (int i4 = 2; i4 < 8; i4++) {
            i3 += bArr[i4];
        }
        bArr[8] = (byte) (i3 & 255);
        a((Handler) null, 2004, i2, bArr);
    }

    public static void b(int i2, int i3, int i4) {
        try {
            com.cube26.iota.smartlite.c.d.f3307d = true;
            com.cube26.iota.smartlite.c.d.f3309f.setChecked(false);
            com.cube26.iota.smartlite.c.d.a();
            if (i2 == 0 && i3 == 0 && i4 == 0) {
                for (int i5 = 0; i5 < v.size(); i5++) {
                    b(com.cube26.iota.smartlite.c.b.f3256a[0], com.cube26.iota.smartlite.c.b.f3256a[1], com.cube26.iota.smartlite.c.b.f3256a[2], H, i5, "wheel");
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            com.cube26.iota.smartlite.util.b.a("IOTA", "Exception caught while unregistering ::");
        }
    }

    public static void b(int i2, int i3, int i4, int i5, int i6, String str) {
        if (i6 == 0) {
            for (int i7 = 0; i7 < 3; i7++) {
                K[i7] = J[i7];
            }
        }
        if (f3467a) {
            if (str.equalsIgnoreCase("ON")) {
                i4 = 255;
                i3 = 255;
                i2 = 255;
            }
            String str2 = i2 + "," + i3 + "," + i4 + "," + i5;
            com.cube26.iota.smartlite.util.b.a("IOTA", " data  :: " + str2);
            com.cube26.iota.smartlite.VirtualLite.a.a().a(str2 + "\r\n");
            return;
        }
        if (str.equalsIgnoreCase("PhoneCancel")) {
            com.cube26.iota.smartlite.util.b.a("IOTA", " phonecancel");
            byte[] bArr = {15, 11, 18, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, -1, -1};
            int i8 = 1;
            for (int i9 = 2; i9 < 12; i9++) {
                i8 += bArr[i9];
            }
            bArr[12] = (byte) (i8 & 255);
            a((Handler) null, 5000, i6, bArr);
            com.cube26.iota.smartlite.c.c.f3274e = "color";
            byte[] bArr2 = {15, 10, 13, 0, (byte) J[0], (byte) J[1], (byte) J[2], (byte) i5, 2, 0, 0, 0, -1, -1};
            int i10 = 1;
            for (int i11 = 2; i11 < 11; i11++) {
                i10 += bArr2[i11];
            }
            bArr2[11] = (byte) (i10 & 255);
            a((Handler) null, 2004, i6, bArr2);
            return;
        }
        if (str.equalsIgnoreCase("PhoneCancelWait")) {
            byte[] bArr3 = {15, 11, 18, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, -1, -1};
            int i12 = 1;
            for (int i13 = 2; i13 < 12; i13++) {
                i12 += bArr3[i13];
            }
            bArr3[12] = (byte) (i12 & 255);
            a((Handler) null, 5000, i6, bArr3);
            com.cube26.iota.smartlite.util.b.a("IOTA", "TRANSITION ::" + com.cube26.iota.smartlite.c.c.f3274e);
            if (com.cube26.iota.smartlite.c.c.f3274e.equalsIgnoreCase("candle")) {
                b(255, 255, 0, H, i6, "PhoneCancel");
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                com.cube26.iota.smartlite.util.b.a("IOTA", "Candle Flicker effect resumed");
                byte[] bArr4 = {15, 11, 18, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0, -1, -1};
                int i14 = 1;
                for (int i15 = 2; i15 < 12; i15++) {
                    i14 += bArr4[i15];
                }
                bArr4[12] = (byte) (i14 & 255);
                a((Handler) null, 5000, i6, bArr4);
                com.cube26.iota.smartlite.c.c.f3274e = "candle";
            } else if (com.cube26.iota.smartlite.c.c.f3274e.equalsIgnoreCase("strobe")) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
                if (v.get(i6).o() == null || !v.get(i6).o().equals("1.04")) {
                    byte[] bArr5 = {15, 11, 18, 0, 3, 2, -1, -1, -1, -56, 0, 0, 0, -1, -1};
                    int i16 = 1;
                    for (int i17 = 2; i17 < 12; i17++) {
                        i16 += bArr5[i17];
                    }
                    bArr5[12] = (byte) (i16 & 255);
                    a((Handler) null, 5000, i6, bArr5);
                } else {
                    a(J[0], J[1], J[2], H, i6, "wheel");
                }
                com.cube26.iota.smartlite.c.c.f3274e = "Strobe";
            } else if (com.cube26.iota.smartlite.c.c.f3274e.equalsIgnoreCase("Kaleidoscope")) {
                com.cube26.iota.smartlite.util.b.a("IOTA", "Kaleidoscope effect resumed");
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
                byte[] bArr6 = {15, 11, 18, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, -1, -1};
                int i18 = 1;
                for (int i19 = 2; i19 < 12; i19++) {
                    i18 += bArr6[i19];
                }
                bArr6[12] = (byte) (i18 & 255);
                a((Handler) null, 5000, i6, bArr6);
                com.cube26.iota.smartlite.c.c.f3274e = "Kaleidoscope";
            } else {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
                byte[] bArr7 = {15, 10, 13, 0, (byte) J[0], (byte) J[1], (byte) J[2], (byte) H, 2, 0, 0, 0, -1, -1};
                int i20 = 1;
                for (int i21 = 2; i21 < 11; i21++) {
                    i20 += bArr7[i21];
                }
                bArr7[11] = (byte) (i20 & 255);
                a((Handler) null, 2004, i6, bArr7);
                IncomingCallIReceiver.f2954c = false;
            }
            IncomingCallIReceiver.f2954c = false;
            return;
        }
        if (str.equalsIgnoreCase("Sms")) {
            byte[] bArr8 = {15, 13, 3, 0, (byte) i2, (byte) i3, (byte) i4, (byte) i5, 0, 0, 0, 0, 0, 0, 0, -1, -1};
            int i22 = 1;
            for (int i23 = 2; i23 < 14; i23++) {
                i22 += bArr8[i23];
            }
            bArr8[14] = (byte) (i22 & 255);
            a((Handler) null, 5001, i6, bArr8);
            return;
        }
        if (str.equalsIgnoreCase("check")) {
            byte[] bArr9 = {15, 5, 10, 0, 0, 0, 0, -1, -1};
            int i24 = 1;
            for (int i25 = 2; i25 < 6; i25++) {
                i24 += bArr9[i25];
            }
            bArr9[6] = (byte) (i24 & 255);
            a((Handler) null, 2004, i6, bArr9);
            return;
        }
        if (str.equalsIgnoreCase("Schedule")) {
            Calendar calendar = Calendar.getInstance();
            calendar.get(12);
            calendar.add(12, 1);
            com.cube26.iota.smartlite.util.b.a("IOTA", "Scheduling your tasks :: ");
            byte[] bArr10 = {15, 19, 19, 0, 0, 0, 1, 0, 0, 15, (byte) (calendar.get(2) + 1), (byte) calendar.get(5), (byte) calendar.get(11), (byte) calendar.get(12), 0, 0, -1, 0, 0, -56, 0, -1, -1};
            int i26 = 1;
            for (int i27 = 2; i27 < 20; i27++) {
                i26 += bArr10[i27];
            }
            bArr10[20] = (byte) (i26 & 255);
            byte[] bArr11 = new byte[20];
            System.arraycopy(bArr10, 0, bArr11, 0, 20);
            a((Handler) null, 2004, i6, bArr11);
            try {
                Thread.sleep(50L);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            byte[] bArr12 = new byte[3];
            System.arraycopy(bArr10, 20, bArr12, 0, 3);
            a((Handler) null, 2004, i6, bArr12);
            return;
        }
        if (str.equalsIgnoreCase("timertest")) {
            com.cube26.iota.smartlite.util.b.a("IOTA", "Delay set.static public final String s switch it off mofo's");
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(13, 10);
            byte[] bArr13 = {15, 15, 9, 0, 2, (byte) calendar2.get(13), (byte) calendar2.get(12), (byte) calendar2.get(11), (byte) calendar2.get(5), (byte) (calendar2.get(2) + 1), (byte) (calendar2.get(1) / 256), (byte) (calendar2.get(1) % 256), 0, 0, 0, 0, 0, -1, -1};
            com.cube26.iota.smartlite.util.b.a("IOTA", "Setting Off TimerSec" + calendar2.get(13) + "Min" + calendar2.get(12) + "Hour" + calendar2.get(10) + "Day" + calendar2.get(5) + "Month" + calendar2.get(2) + "Year" + (calendar2.get(1) / 256) + (calendar2.get(1) % 256));
            int i28 = 1;
            for (int i29 = 2; i29 < 16; i29++) {
                i28 += bArr13[i29];
            }
            bArr13[16] = (byte) (i28 & 255);
            a((Handler) null, 2004, i6, bArr13);
            return;
        }
        if (str.equalsIgnoreCase("Reset")) {
            com.cube26.iota.smartlite.util.b.a("IOTA", "NFC Started");
            byte[] bArr14 = {15, 5, 11, 0, 0, 0, 0, -1, -1};
            int i30 = 1;
            for (int i31 = 2; i31 < 6; i31++) {
                i30 += bArr14[i31];
            }
            bArr14[6] = (byte) (i30 & 255);
            a((Handler) null, 2004, i6, bArr14);
            return;
        }
        if (str.equalsIgnoreCase("off")) {
            byte[] bArr15 = {15, 10, 13, 0, 0, 0, 0, 0, 5, 0, 0, 0, -1, -1};
            int i32 = 1;
            for (int i33 = 2; i33 < 11; i33++) {
                i32 += bArr15[i33];
            }
            bArr15[11] = (byte) (i32 & 255);
            a((Handler) null, 2004, i6, bArr15);
            return;
        }
        if (str.equalsIgnoreCase("on")) {
            byte[] bArr16 = {15, 10, 13, 0, (byte) K[0], (byte) K[1], (byte) K[2], (byte) H, 5, 0, 0, 0, -1, -1};
            int i34 = 1;
            for (int i35 = 2; i35 < 11; i35++) {
                i34 += bArr16[i35];
            }
            bArr16[11] = (byte) (i34 & 255);
            a((Handler) null, 2004, i6, bArr16);
            J[0] = K[0];
            J[1] = K[1];
            J[2] = K[2];
            return;
        }
        if (str.equalsIgnoreCase("timer")) {
            com.cube26.iota.smartlite.util.b.a("IOTA", "Setting TimerSec" + F.get(13) + "Min" + F.get(12) + "Hour" + F.get(11) + "Month" + F.get(2) + "Yer" + (F.get(1) / 256));
            byte[] bArr17 = {15, 11, 9, 0, 2, (byte) F.get(13), (byte) F.get(12), (byte) F.get(11), (byte) F.get(5), (byte) (F.get(2) + 1), (byte) (F.get(1) / 256), (byte) (F.get(1) % 256), 0, -1, -1};
            int i36 = 1;
            for (int i37 = 2; i37 < 12; i37++) {
                i36 += bArr17[i37];
            }
            bArr17[12] = (byte) (i36 & 255);
            a((Handler) null, 158, i6, bArr17);
            return;
        }
        if (str.equalsIgnoreCase("voice")) {
            W = new byte[]{15, 5, 17, 0, 0, 0, 0, -1, -1};
            int i38 = 1;
            for (int i39 = 2; i39 < 6; i39++) {
                i38 += W[i39];
            }
            W[6] = (byte) (i38 & 255);
            a((Handler) null, 2004, i6, W);
            return;
        }
        if (str.equalsIgnoreCase("Candle Flicker")) {
            com.cube26.iota.smartlite.util.b.a("IOTA", "Candle Flicker effect invoked");
            W = new byte[]{15, 11, 18, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0, -1, -1};
            int i40 = 1;
            for (int i41 = 2; i41 < 12; i41++) {
                i40 += W[i41];
            }
            W[12] = (byte) (i40 & 255);
            a((Handler) null, 5000, i6, W);
            return;
        }
        if (str.equalsIgnoreCase("Strobe")) {
            com.cube26.iota.smartlite.util.b.a("IOTA", "Strobe effect invoked");
            W = new byte[]{15, 11, 18, 0, 3, 2, -1, -1, -1, -56, 0, 0, 0, -1, -1};
            int i42 = 1;
            for (int i43 = 2; i43 < 12; i43++) {
                i42 += W[i43];
            }
            W[12] = (byte) (i42 & 255);
            a((Handler) null, 5000, i6, W);
            return;
        }
        if (str.equalsIgnoreCase("Kaleidoscope")) {
            com.cube26.iota.smartlite.util.b.a("IOTA", "Kaleidoscope effect invoked");
            W = new byte[]{15, 11, 18, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, -1, -1};
            int i44 = 1;
            for (int i45 = 2; i45 < 12; i45++) {
                i44 += W[i45];
            }
            W[12] = (byte) (i44 & 255);
            a((Handler) null, 5000, i6, W);
            return;
        }
        if (str.equalsIgnoreCase("Drawer")) {
            int iIntValue = R[i2].intValue();
            int iIntValue2 = R[i3].intValue();
            int iIntValue3 = R[i4].intValue();
            com.cube26.iota.smartlite.util.b.b("IOTA", "flash alert");
            W = new byte[]{15, 12, 12, 0, 5, 0, 5, (byte) iIntValue, (byte) iIntValue2, (byte) iIntValue3, (byte) i5, 0, 0, 0, -1, -1};
            int i46 = 1;
            for (int i47 = 2; i47 < 13; i47++) {
                i46 += W[i47];
            }
            W[13] = (byte) (i46 & 255);
            a((Handler) null, 2008, i6, W);
            return;
        }
        if (str.equalsIgnoreCase("scheduleOff")) {
            Calendar calendar3 = Calendar.getInstance();
            calendar3.get(12);
            calendar3.add(12, 1);
            com.cube26.iota.smartlite.util.b.a("IOTA", "Scheduling your tasks for switching it off:: ");
            byte[] bArr18 = {15, 19, 19, 0, 0, 0, 1, 0, 0, 15, (byte) (calendar3.get(2) + 1), (byte) calendar3.get(5), (byte) calendar3.get(11), (byte) calendar3.get(12), 0, 0, -1, 0, 0, -56, 0, -1, -1};
            int i48 = 1;
            for (int i49 = 2; i49 < 20; i49++) {
                i48 += bArr18[i49];
            }
            bArr18[20] = (byte) (i48 & 255);
            byte[] bArr19 = new byte[20];
            System.arraycopy(bArr18, 0, bArr19, 0, 20);
            a((Handler) null, 2004, i6, bArr19);
            try {
                Thread.sleep(50L);
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            byte[] bArr20 = new byte[3];
            System.arraycopy(bArr18, 20, bArr20, 0, 3);
            a((Handler) null, 2004, i6, bArr20);
            return;
        }
        if (!str.equalsIgnoreCase("scheduleOn")) {
            int iIntValue4 = R[i2].intValue();
            int iIntValue5 = R[i3].intValue();
            int iIntValue6 = R[i4].intValue();
            J[0] = iIntValue4;
            J[1] = iIntValue5;
            J[2] = iIntValue6;
            X = i5;
            byte[] bArr21 = {15, 13, 3, 0, (byte) iIntValue4, (byte) iIntValue5, (byte) iIntValue6, (byte) i5, 0, 0, 1, 0, 0, 0, 0, -1, -1};
            int i50 = 1;
            for (int i51 = 2; i51 < 14; i51++) {
                i50 += bArr21[i51];
            }
            bArr21[14] = (byte) (i50 & 255);
            a((Handler) null, 2004, i6, bArr21);
            return;
        }
        Calendar calendar4 = Calendar.getInstance();
        calendar4.get(12);
        calendar4.add(12, 1);
        com.cube26.iota.smartlite.util.b.a("IOTA", "Scheduling your tasks for switching it on :: ");
        byte[] bArr22 = {15, 19, 19, 0, 0, 0, 1, 1, 0, 15, (byte) (calendar4.get(2) + 1), (byte) calendar4.get(5), (byte) calendar4.get(11), (byte) calendar4.get(12), 0, 0, -1, -1, -1, -52, 0, -1, -1};
        int i52 = 1;
        for (int i53 = 2; i53 < 20; i53++) {
            i52 += bArr22[i53];
        }
        bArr22[20] = (byte) (i52 & 255);
        byte[] bArr23 = new byte[20];
        System.arraycopy(bArr22, 0, bArr23, 0, 20);
        a((Handler) null, 2004, i6, bArr23);
        try {
            Thread.sleep(50L);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        byte[] bArr24 = new byte[3];
        System.arraycopy(bArr22, 20, bArr24, 0, 3);
        a((Handler) null, 2004, i6, bArr24);
    }

    public static final boolean b(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence) && Pattern.compile("^[789]\\d{9}$").matcher(charSequence).matches();
    }

    public static String c(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList(listQueryIntentActivities.size());
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().activityInfo.packageName);
        }
        return arrayList.toString();
    }

    public static void c() {
        if (com.cube26.iota.smartlite.c.b.f3259d.equals("off")) {
            com.cube26.iota.smartlite.c.b.f3257b.setChecked(false);
            com.cube26.iota.smartlite.c.b.f3257b.setBackgroundResource(R.drawable.on);
        }
    }

    public static void c(int i2) {
        byte[] bArr = {15, 7, 5, 0, 0, 1, 0, 1, 0, -1, -1};
        int i3 = 1;
        for (int i4 = 2; i4 < 8; i4++) {
            i3 += bArr[i4];
        }
        bArr[8] = (byte) (i3 & 255);
        a((Handler) null, 2004, i2, bArr);
    }

    public static void d(int i2) {
        int i3 = 1;
        Calendar calendar = Calendar.getInstance();
        byte[] bArr = {15, 12, 1, 0, (byte) calendar.get(13), (byte) calendar.get(12), (byte) calendar.get(11), (byte) calendar.get(5), (byte) (calendar.get(2) + 1), (byte) (calendar.get(1) / 256), (byte) (calendar.get(1) % 256), 0, 0, 0, -1, -1};
        com.cube26.iota.smartlite.util.b.a("IOTA", " syn time :: " + calendar.getTime());
        for (int i4 = 2; i4 < 13; i4++) {
            i3 += bArr[i4];
        }
        bArr[13] = (byte) (i3 & 255);
        a(i2, bArr);
    }

    public static void d(Context context) {
        Toast.makeText(context, "Please check you have an active internet connection!", 0).show();
    }

    public static void e(int i2) {
        byte[] bArr = {15, 19, 19, 0, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -56, 0, -1, -1};
        int i3 = 1;
        for (int i4 = 2; i4 < 20; i4++) {
            i3 += bArr[i4];
        }
        bArr[20] = (byte) (i3 & 255);
        byte[] bArr2 = new byte[20];
        System.arraycopy(bArr, 0, bArr2, 0, 20);
        byte[] bArr3 = new byte[3];
        System.arraycopy(bArr, 20, bArr3, 0, 3);
        a((Handler) null, 2004, i2, bArr2);
        try {
            Thread.sleep(50L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a((Handler) null, 2004, i2, bArr3);
        try {
            Thread.sleep(50L);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        com.cube26.iota.smartlite.util.b.b("IOTA", "checking network status");
        com.cube26.iota.smartlite.util.b.b("IOTA", z2 + "");
        return z2;
    }

    public static ArrayList<String> f(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Account account : AccountManager.get(context).getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE)) {
                arrayList.add(account.name);
            }
        } catch (Exception e2) {
            com.cube26.iota.smartlite.util.b.b("Exception", "Exception:" + e2);
        }
        com.cube26.iota.smartlite.util.b.a("IOTA", "Google Accounts list is::" + arrayList);
        return arrayList;
    }

    public static void f(int i2) {
        com.cube26.iota.smartlite.util.b.a("IOTA", " checkschedule tag :: " + i2);
        byte[] bArr = {15, 6, 20, 0, 0, 0, 0, 0, -1, -1};
        int i3 = 1;
        for (int i4 = 2; i4 < 7; i4++) {
            i3 += bArr[i4];
        }
        bArr[7] = (byte) (i3 & 255);
        a((Handler) null, 2004, i2, bArr);
    }

    public static boolean g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LiteAutoConnectStatus", 0);
        com.cube26.iota.smartlite.util.b.a("IOTA", " Utility autoConnectEnabled status :: " + sharedPreferences.getInt("auto_connect_enabled_lite_count", 0));
        return sharedPreferences.getInt("auto_connect_enabled_lite_count", 0) != 0;
    }

    public static void h(Context context) {
        Toast.makeText(context, "Server is unreachable at this moment. Please try after some time.", 0).show();
    }
}
