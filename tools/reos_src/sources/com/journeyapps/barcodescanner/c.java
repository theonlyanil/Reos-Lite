package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.b.n;
import com.google.b.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5881a = c.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f5882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CompoundBarcodeView f5883c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.google.b.b.a.e f5886f;
    private com.google.b.b.a.b g;
    private Handler h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5884d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5885e = false;
    private a i = new a() { // from class: com.journeyapps.barcodescanner.c.1
        @Override // com.journeyapps.barcodescanner.a
        public void a(final b bVar) {
            c.this.f5883c.a();
            c.this.g.b();
            c.this.h.postDelayed(new Runnable() { // from class: com.journeyapps.barcodescanner.c.1.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar);
                }
            }, 150L);
        }

        @Override // com.journeyapps.barcodescanner.a
        public void a(List<o> list) {
        }
    };
    private final CameraPreview.a j = new CameraPreview.a() { // from class: com.journeyapps.barcodescanner.c.2
        @Override // com.journeyapps.barcodescanner.CameraPreview.a
        public void a() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.a
        public void a(Exception exc) {
            c.this.f();
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.a
        public void b() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.a
        public void c() {
        }
    };

    public c(Activity activity, CompoundBarcodeView compoundBarcodeView) {
        this.f5882b = activity;
        this.f5883c = compoundBarcodeView;
        compoundBarcodeView.getBarcodeView().a(this.j);
        this.h = new Handler();
        this.f5886f = new com.google.b.b.a.e(activity, new Runnable() { // from class: com.journeyapps.barcodescanner.c.3
            @Override // java.lang.Runnable
            public void run() {
                Log.d(c.f5881a, "Finishing due to inactivity");
                c.this.h();
            }
        });
        this.g = new com.google.b.b.a.b(activity);
    }

    public static Intent a(b bVar) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.addFlags(524288);
        intent.putExtra("SCAN_RESULT", bVar.toString());
        intent.putExtra("SCAN_RESULT_FORMAT", bVar.b().toString());
        byte[] bArrA = bVar.a();
        if (bArrA != null && bArrA.length > 0) {
            intent.putExtra("SCAN_RESULT_BYTES", bArrA);
        }
        Map<n, Object> mapC = bVar.c();
        if (mapC != null) {
            if (mapC.containsKey(n.UPC_EAN_EXTENSION)) {
                intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", mapC.get(n.UPC_EAN_EXTENSION).toString());
            }
            Number number = (Number) mapC.get(n.ORIENTATION);
            if (number != null) {
                intent.putExtra("SCAN_RESULT_ORIENTATION", number.intValue());
            }
            String str = (String) mapC.get(n.ERROR_CORRECTION_LEVEL);
            if (str != null) {
                intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str);
            }
            Iterable iterable = (Iterable) mapC.get(n.BYTE_SEGMENTS);
            if (iterable != null) {
                int i = 0;
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i, (byte[]) it.next());
                    i++;
                }
            }
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f5882b.finish();
    }

    protected void a() {
        int i = 0;
        if (this.f5884d == -1) {
            int rotation = this.f5882b.getWindowManager().getDefaultDisplay().getRotation();
            int i2 = this.f5882b.getResources().getConfiguration().orientation;
            if (i2 == 2) {
                if (rotation != 0 && rotation != 1) {
                    i = 8;
                }
            } else if (i2 == 1) {
                i = (rotation == 0 || rotation == 3) ? 1 : 9;
            }
            this.f5884d = i;
        }
        this.f5882b.setRequestedOrientation(this.f5884d);
    }

    public void a(Intent intent, Bundle bundle) {
        this.f5882b.getWindow().addFlags(128);
        if (bundle != null) {
            this.f5884d = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (this.f5884d == -1 && intent.getBooleanExtra("SCAN_ORIENTATION_LOCKED", true)) {
                a();
            }
            if ("com.google.zxing.client.android.SCAN".equals(intent.getAction())) {
                this.f5883c.a(intent);
            }
            if (intent.getBooleanExtra("BEEP_ENABLED", true)) {
                return;
            }
            this.g.a(false);
            this.g.a();
        }
    }

    public void a(Bundle bundle) {
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.f5884d);
    }

    public void b() {
        this.f5883c.a(this.i);
    }

    protected void b(b bVar) {
        this.f5882b.setResult(-1, a(bVar));
        h();
    }

    public void c() {
        this.f5883c.b();
        this.g.a();
        this.f5886f.b();
    }

    public void d() {
        this.f5883c.a();
        this.f5886f.c();
        this.g.close();
    }

    public void e() {
        this.f5885e = true;
        this.f5886f.c();
    }

    protected void f() {
        if (this.f5882b.isFinishing() || this.f5885e) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f5882b);
        builder.setTitle(this.f5882b.getString(com.google.b.b.a.f.e.zxing_app_name));
        builder.setMessage(this.f5882b.getString(com.google.b.b.a.f.e.zxing_msg_camera_framework_bug));
        builder.setPositiveButton(com.google.b.b.a.f.e.zxing_button_ok, new DialogInterface.OnClickListener() { // from class: com.journeyapps.barcodescanner.c.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                c.this.h();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.journeyapps.barcodescanner.c.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                c.this.h();
            }
        });
        builder.show();
    }
}
