package com.journeyapps.barcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.google.b.o;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BarcodeView extends CameraPreview {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f5791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.journeyapps.barcodescanner.a f5792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f5793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f5794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f5795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler.Callback f5796f;

    private enum a {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public BarcodeView(Context context) {
        super(context);
        this.f5791a = a.NONE;
        this.f5792b = null;
        this.f5796f = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.BarcodeView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == com.google.b.b.a.f.b.zxing_decode_succeeded) {
                    b bVar = (b) message.obj;
                    if (bVar != null && BarcodeView.this.f5792b != null && BarcodeView.this.f5791a != a.NONE) {
                        BarcodeView.this.f5792b.a(bVar);
                        if (BarcodeView.this.f5791a == a.SINGLE) {
                            BarcodeView.this.a();
                        }
                    }
                    return true;
                }
                if (message.what == com.google.b.b.a.f.b.zxing_decode_failed) {
                    return true;
                }
                if (message.what != com.google.b.b.a.f.b.zxing_possible_result_points) {
                    return false;
                }
                List<o> list = (List) message.obj;
                if (BarcodeView.this.f5792b != null && BarcodeView.this.f5791a != a.NONE) {
                    BarcodeView.this.f5792b.a(list);
                }
                return true;
            }
        };
        i();
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5791a = a.NONE;
        this.f5792b = null;
        this.f5796f = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.BarcodeView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == com.google.b.b.a.f.b.zxing_decode_succeeded) {
                    b bVar = (b) message.obj;
                    if (bVar != null && BarcodeView.this.f5792b != null && BarcodeView.this.f5791a != a.NONE) {
                        BarcodeView.this.f5792b.a(bVar);
                        if (BarcodeView.this.f5791a == a.SINGLE) {
                            BarcodeView.this.a();
                        }
                    }
                    return true;
                }
                if (message.what == com.google.b.b.a.f.b.zxing_decode_failed) {
                    return true;
                }
                if (message.what != com.google.b.b.a.f.b.zxing_possible_result_points) {
                    return false;
                }
                List<o> list = (List) message.obj;
                if (BarcodeView.this.f5792b != null && BarcodeView.this.f5791a != a.NONE) {
                    BarcodeView.this.f5792b.a(list);
                }
                return true;
            }
        };
        i();
    }

    public BarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5791a = a.NONE;
        this.f5792b = null;
        this.f5796f = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.BarcodeView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == com.google.b.b.a.f.b.zxing_decode_succeeded) {
                    b bVar = (b) message.obj;
                    if (bVar != null && BarcodeView.this.f5792b != null && BarcodeView.this.f5791a != a.NONE) {
                        BarcodeView.this.f5792b.a(bVar);
                        if (BarcodeView.this.f5791a == a.SINGLE) {
                            BarcodeView.this.a();
                        }
                    }
                    return true;
                }
                if (message.what == com.google.b.b.a.f.b.zxing_decode_failed) {
                    return true;
                }
                if (message.what != com.google.b.b.a.f.b.zxing_possible_result_points) {
                    return false;
                }
                List<o> list = (List) message.obj;
                if (BarcodeView.this.f5792b != null && BarcodeView.this.f5791a != a.NONE) {
                    BarcodeView.this.f5792b.a(list);
                }
                return true;
            }
        };
        i();
    }

    private void i() {
        this.f5794d = new h();
        this.f5795e = new Handler(this.f5796f);
    }

    private d j() {
        if (this.f5794d == null) {
            this.f5794d = b();
        }
        f fVar = new f();
        HashMap map = new HashMap();
        map.put(com.google.b.e.NEED_RESULT_POINT_CALLBACK, fVar);
        d dVarA = this.f5794d.a(map);
        fVar.a(dVarA);
        return dVarA;
    }

    private void k() {
        l();
        if (this.f5791a == a.NONE || !g()) {
            return;
        }
        this.f5793c = new g(getCameraInstance(), j(), this.f5795e);
        this.f5793c.a(getPreviewFramingRect());
        this.f5793c.a();
    }

    private void l() {
        if (this.f5793c != null) {
            this.f5793c.b();
            this.f5793c = null;
        }
    }

    public void a() {
        this.f5791a = a.NONE;
        this.f5792b = null;
        l();
    }

    public void a(com.journeyapps.barcodescanner.a aVar) {
        this.f5791a = a.SINGLE;
        this.f5792b = aVar;
        k();
    }

    protected e b() {
        return new h();
    }

    @Override // com.journeyapps.barcodescanner.CameraPreview
    protected void c() {
        super.c();
        k();
    }

    @Override // com.journeyapps.barcodescanner.CameraPreview
    public void d() {
        l();
        super.d();
    }

    public e getDecoderFactory() {
        return this.f5794d;
    }

    public void setDecoderFactory(e eVar) {
        m.a();
        this.f5794d = eVar;
        if (this.f5793c != null) {
            this.f5793c.a(j());
        }
    }
}
