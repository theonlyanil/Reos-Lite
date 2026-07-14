package com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ViewfinderView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5821a = ViewfinderView.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f5822b = {0, 64, 128, 192, 255, 192, 128, 64};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f5823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f5824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f5825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f5826f;
    private final int g;
    private final int h;
    private int i;
    private List<o> j;
    private List<o> k;
    private CameraPreview l;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5823c = new Paint(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.google.b.b.a.f.C0201f.zxing_finder);
        this.f5825e = typedArrayObtainStyledAttributes.getColor(com.google.b.b.a.f.C0201f.zxing_finder_zxing_viewfinder_mask, resources.getColor(com.google.b.b.a.f.a.zxing_viewfinder_mask));
        this.f5826f = typedArrayObtainStyledAttributes.getColor(com.google.b.b.a.f.C0201f.zxing_finder_zxing_result_view, resources.getColor(com.google.b.b.a.f.a.zxing_result_view));
        this.g = typedArrayObtainStyledAttributes.getColor(com.google.b.b.a.f.C0201f.zxing_finder_zxing_viewfinder_laser, resources.getColor(com.google.b.b.a.f.a.zxing_viewfinder_laser));
        this.h = typedArrayObtainStyledAttributes.getColor(com.google.b.b.a.f.C0201f.zxing_finder_zxing_possible_result_points, resources.getColor(com.google.b.b.a.f.a.zxing_possible_result_points));
        typedArrayObtainStyledAttributes.recycle();
        this.i = 0;
        this.j = new ArrayList(5);
        this.k = null;
    }

    public void a(o oVar) {
        List<o> list = this.j;
        list.add(oVar);
        int size = list.size();
        if (size > 20) {
            list.subList(0, size - 10).clear();
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        if (this.l == null || this.l.getPreviewFramingRect() == null || this.l.getFramingRect() == null) {
            return;
        }
        Rect framingRect = this.l.getFramingRect();
        Rect previewFramingRect = this.l.getPreviewFramingRect();
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f5823c.setColor(this.f5824d != null ? this.f5826f : this.f5825e);
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, width, framingRect.top, this.f5823c);
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, framingRect.top, framingRect.left, framingRect.bottom + 1, this.f5823c);
        canvas.drawRect(framingRect.right + 1, framingRect.top, width, framingRect.bottom + 1, this.f5823c);
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, framingRect.bottom + 1, width, height, this.f5823c);
        if (this.f5824d != null) {
            this.f5823c.setAlpha(160);
            canvas.drawBitmap(this.f5824d, (Rect) null, framingRect, this.f5823c);
            return;
        }
        this.f5823c.setColor(this.g);
        this.f5823c.setAlpha(f5822b[this.i]);
        this.i = (this.i + 1) % f5822b.length;
        int iHeight = (framingRect.height() / 2) + framingRect.top;
        canvas.drawRect(framingRect.left + 2, iHeight - 1, framingRect.right - 1, iHeight + 2, this.f5823c);
        float fWidth = framingRect.width() / previewFramingRect.width();
        float fHeight = framingRect.height() / previewFramingRect.height();
        List<o> list = this.j;
        List<o> list2 = this.k;
        int i = framingRect.left;
        int i2 = framingRect.top;
        if (list.isEmpty()) {
            this.k = null;
        } else {
            this.j = new ArrayList(5);
            this.k = list;
            this.f5823c.setAlpha(160);
            this.f5823c.setColor(this.h);
            for (o oVar : list) {
                canvas.drawCircle(((int) (oVar.a() * fWidth)) + i, ((int) (oVar.b() * fHeight)) + i2, 6.0f, this.f5823c);
            }
        }
        if (list2 != null) {
            this.f5823c.setAlpha(80);
            this.f5823c.setColor(this.h);
            for (o oVar2 : list2) {
                canvas.drawCircle(((int) (oVar2.a() * fWidth)) + i, ((int) (oVar2.b() * fHeight)) + i2, 3.0f, this.f5823c);
            }
        }
        postInvalidateDelayed(80L, framingRect.left - 6, framingRect.top - 6, framingRect.right + 6, framingRect.bottom + 6);
    }

    public void setCameraPreview(CameraPreview cameraPreview) {
        this.l = cameraPreview;
        cameraPreview.a(new CameraPreview.a() { // from class: com.journeyapps.barcodescanner.ViewfinderView.1
            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void a() {
                ViewfinderView.this.invalidate();
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void a(Exception exc) {
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void b() {
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void c() {
            }
        });
    }
}
