package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes.dex */
public class CaptureActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f5813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CompoundBarcodeView f5814b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.google.b.b.a.f.c.zxing_capture);
        this.f5814b = (CompoundBarcodeView) findViewById(com.google.b.b.a.f.b.zxing_barcode_scanner);
        this.f5813a = new c(this, this.f5814b);
        this.f5813a.a(getIntent(), bundle);
        this.f5813a.b();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f5813a.e();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f5814b.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f5813a.d();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f5813a.c();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f5813a.a(bundle);
    }
}
