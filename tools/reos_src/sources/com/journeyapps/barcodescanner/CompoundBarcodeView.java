package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.b.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CompoundBarcodeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BarcodeView f5815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewfinderView f5816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f5817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f5818d;

    public interface a {
        void a();

        void b();
    }

    private class b implements com.journeyapps.barcodescanner.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.journeyapps.barcodescanner.a f5820b;

        public b(com.journeyapps.barcodescanner.a aVar) {
            this.f5820b = aVar;
        }

        @Override // com.journeyapps.barcodescanner.a
        public void a(com.journeyapps.barcodescanner.b bVar) {
            this.f5820b.a(bVar);
        }

        @Override // com.journeyapps.barcodescanner.a
        public void a(List<o> list) {
            Iterator<o> it = list.iterator();
            while (it.hasNext()) {
                CompoundBarcodeView.this.f5816b.a(it.next());
            }
            this.f5820b.a(list);
        }
    }

    public CompoundBarcodeView(Context context) {
        super(context);
        e();
    }

    public CompoundBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public CompoundBarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.google.b.b.a.f.C0201f.zxing_view);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(com.google.b.b.a.f.C0201f.zxing_view_zxing_scanner_layout, com.google.b.b.a.f.c.zxing_barcode_scanner);
        typedArrayObtainStyledAttributes.recycle();
        inflate(getContext(), resourceId, this);
        this.f5815a = (BarcodeView) findViewById(com.google.b.b.a.f.b.zxing_barcode_surface);
        if (this.f5815a == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        this.f5816b = (ViewfinderView) findViewById(com.google.b.b.a.f.b.zxing_viewfinder_view);
        if (this.f5816b == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        this.f5816b.setCameraPreview(this.f5815a);
        this.f5817c = (TextView) findViewById(com.google.b.b.a.f.b.zxing_status_view);
    }

    private void e() {
        a((AttributeSet) null);
    }

    public void a() {
        this.f5815a.d();
    }

    public void a(Intent intent) {
        int intExtra;
        Set<com.google.b.a> setA = com.google.b.b.a.c.a(intent);
        Map<com.google.b.e, ?> mapA = com.google.b.b.a.d.a(intent);
        com.journeyapps.barcodescanner.a.d dVar = new com.journeyapps.barcodescanner.a.d();
        if (intent.hasExtra("SCAN_CAMERA_ID") && (intExtra = intent.getIntExtra("SCAN_CAMERA_ID", -1)) >= 0) {
            dVar.a(intExtra);
        }
        String stringExtra = intent.getStringExtra("PROMPT_MESSAGE");
        if (stringExtra != null) {
            setStatusText(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("CHARACTER_SET");
        new com.google.b.h().a(mapA);
        this.f5815a.setCameraSettings(dVar);
        this.f5815a.setDecoderFactory(new h(setA, mapA, stringExtra2));
    }

    public void a(com.journeyapps.barcodescanner.a aVar) {
        this.f5815a.a(new b(aVar));
    }

    public void b() {
        this.f5815a.e();
    }

    public void c() {
        this.f5815a.setTorch(true);
        if (this.f5818d != null) {
            this.f5818d.a();
        }
    }

    public void d() {
        this.f5815a.setTorch(false);
        if (this.f5818d != null) {
            this.f5818d.b();
        }
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(com.google.b.b.a.f.b.zxing_barcode_surface);
    }

    public TextView getStatusView() {
        return this.f5817c;
    }

    public ViewfinderView getViewFinder() {
        return this.f5816b;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 24:
                c();
                return true;
            case 25:
                d();
                return true;
            case 27:
            case 80:
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void setStatusText(String str) {
        if (this.f5817c != null) {
            this.f5817c.setText(str);
        }
    }

    public void setTorchListener(a aVar) {
        this.f5818d = aVar;
    }
}
