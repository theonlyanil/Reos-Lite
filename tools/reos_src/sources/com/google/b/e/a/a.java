package com.google.b.e.a;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.journeyapps.barcodescanner.CaptureActivity;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private final Activity g;
    private Fragment h;
    private android.support.v4.app.Fragment i;
    private final Map<String, Object> j = new HashMap(3);
    private Collection<String> k;
    private Class<?> l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f5527f = a.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collection<String> f5522a = a("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Collection<String> f5523b = a("UPC_A", "UPC_E", "EAN_8", "EAN_13", "CODE_39", "CODE_93", "CODE_128", "ITF", "RSS_14", "RSS_EXPANDED");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Collection<String> f5524c = Collections.singleton("QR_CODE");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Collection<String> f5525d = Collections.singleton("DATA_MATRIX");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Collection<String> f5526e = null;

    public a(Activity activity) {
        this.g = activity;
    }

    public static b a(int i, int i2, Intent intent) {
        if (i != 49374) {
            return null;
        }
        if (i2 != -1) {
            return new b();
        }
        String stringExtra = intent.getStringExtra("SCAN_RESULT");
        String stringExtra2 = intent.getStringExtra("SCAN_RESULT_FORMAT");
        byte[] byteArrayExtra = intent.getByteArrayExtra("SCAN_RESULT_BYTES");
        int intExtra = intent.getIntExtra("SCAN_RESULT_ORIENTATION", Integer.MIN_VALUE);
        return new b(stringExtra, stringExtra2, byteArrayExtra, intExtra != Integer.MIN_VALUE ? Integer.valueOf(intExtra) : null, intent.getStringExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL"));
    }

    private static List<String> a(String... strArr) {
        return Collections.unmodifiableList(Arrays.asList(strArr));
    }

    private void a(Intent intent) {
        for (Map.Entry<String, Object> entry : this.j.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                intent.putExtra(key, (Integer) value);
            } else if (value instanceof Long) {
                intent.putExtra(key, (Long) value);
            } else if (value instanceof Boolean) {
                intent.putExtra(key, (Boolean) value);
            } else if (value instanceof Double) {
                intent.putExtra(key, (Double) value);
            } else if (value instanceof Float) {
                intent.putExtra(key, (Float) value);
            } else if (value instanceof Bundle) {
                intent.putExtra(key, (Bundle) value);
            } else {
                intent.putExtra(key, value.toString());
            }
        }
    }

    protected Class<?> a() {
        return CaptureActivity.class;
    }

    protected void a(Intent intent, int i) {
        if (this.h != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.h.startActivityForResult(intent, i);
            }
        } else if (this.i != null) {
            this.i.startActivityForResult(intent, i);
        } else {
            this.g.startActivityForResult(intent, i);
        }
    }

    public Class<?> b() {
        if (this.l == null) {
            this.l = a();
        }
        return this.l;
    }

    public final void c() {
        a(d(), 49374);
    }

    public Intent d() {
        Intent intent = new Intent(this.g, b());
        intent.setAction("com.google.zxing.client.android.SCAN");
        if (this.k != null) {
            StringBuilder sb = new StringBuilder();
            for (String str : this.k) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(str);
            }
            intent.putExtra("SCAN_FORMATS", sb.toString());
        }
        intent.addFlags(67108864);
        intent.addFlags(524288);
        a(intent);
        return intent;
    }
}
