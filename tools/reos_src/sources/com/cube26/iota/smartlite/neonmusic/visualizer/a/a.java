package com.cube26.iota.smartlite.neonmusic.visualizer.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.R;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Paint f3383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f3384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f3385f;

    public a(int i, Paint paint, boolean z, Context context) {
        this.f3382c = i;
        this.f3383d = paint;
        this.f3384e = z;
        this.f3385f = context;
    }

    @Override // com.cube26.iota.smartlite.neonmusic.visualizer.a.b
    public void a(Canvas canvas, com.cube26.iota.smartlite.neonmusic.visualizer.a aVar, Rect rect) {
    }

    @Override // com.cube26.iota.smartlite.neonmusic.visualizer.a.b
    public void a(Canvas canvas, com.cube26.iota.smartlite.neonmusic.visualizer.b bVar, Rect rect) {
        for (int i = 0; i < bVar.f3388a.length / this.f3382c; i++) {
            this.f3387b[i * 4] = i * 4 * this.f3382c;
            this.f3387b[(i * 4) + 2] = i * 4 * this.f3382c;
            byte b2 = (byte) (bVar.f3388a[this.f3382c * i] - 128);
            byte b3 = (byte) (bVar.f3388a[(this.f3382c * i) + 1] - 128);
            int iLog10 = ((int) (10.0d * Math.log10((b2 * b2) + (b3 * b3)))) * 4;
            if (this.f3384e) {
                this.f3387b[(i * 4) + 1] = 0.0f;
                this.f3387b[(i * 4) + 3] = (iLog10 * 2) - 10;
            } else {
                this.f3387b[(i * 4) + 1] = rect.height();
                this.f3387b[(i * 4) + 3] = rect.height() - ((iLog10 * 2) - 10);
            }
        }
        CLog.a("fftpoint", "length: " + this.f3387b.length);
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.f3387b.length) {
            float[] fArr = new float[this.f3382c];
            int i4 = 0;
            while (i4 < this.f3382c) {
                fArr[i4] = this.f3387b[i2];
                i4++;
                i2++;
            }
            if (!this.f3384e) {
                float[] fArr2 = new float[this.f3382c / 4];
                float[] fArr3 = new float[this.f3382c / 4];
                float[] fArr4 = new float[this.f3382c / 4];
                float[] fArr5 = new float[this.f3382c / 4];
                int i5 = 0;
                for (int i6 = 0; i6 < this.f3382c / 4; i6++) {
                    fArr2[i5] = fArr[i6];
                    i5++;
                }
                int i7 = 0;
                for (int i8 = this.f3382c / 4; i8 < this.f3382c / 2; i8++) {
                    fArr3[i7] = fArr[i8];
                    i7++;
                }
                int i9 = 0;
                for (int i10 = this.f3382c / 2; i10 < (this.f3382c / 4) * 3; i10++) {
                    fArr4[i9] = fArr[i10];
                    i9++;
                }
                int i11 = 0;
                for (int i12 = (this.f3382c / 4) * 3; i12 < this.f3382c; i12++) {
                    fArr5[i11] = fArr[i12];
                    i11++;
                }
                this.f3383d.setColor(this.f3385f.getResources().getColor(R.color.navtabselectedcolor));
                canvas.drawLines(fArr2, this.f3383d);
                this.f3383d.setColor(this.f3385f.getResources().getColor(R.color.gridcolorblue));
                canvas.drawLines(fArr3, this.f3383d);
                this.f3383d.setColor(this.f3385f.getResources().getColor(R.color.gridcolorblue3));
                canvas.drawLines(fArr4, this.f3383d);
                this.f3383d.setColor(this.f3385f.getResources().getColor(R.color.gridcolorred));
                canvas.drawLines(fArr5, this.f3383d);
            } else if (this.f3382c == 2) {
                canvas.drawLines(this.f3387b, this.f3383d);
            } else {
                if (i3 % 7 == 0) {
                    this.f3383d.setColor(this.f3385f.getResources().getColor(R.color.navtabselectedcolor));
                }
                if (i3 % 7 == 1) {
                    this.f3383d.setColor(this.f3385f.getResources().getColor(R.color.gridcolorblue));
                }
                if (i3 % 7 == 2) {
                    this.f3383d.setColor(this.f3385f.getResources().getColor(R.color.gridcolorblue2));
                }
                if (i3 % 7 == 3) {
                    this.f3383d.setColor(this.f3385f.getResources().getColor(R.color.gridcolorred));
                }
                if (i3 % 7 == 4) {
                    this.f3383d.setColor(this.f3385f.getResources().getColor(R.color.gridcolorgreen));
                }
                if (i3 % 7 == 5) {
                    this.f3383d.setColor(this.f3385f.getResources().getColor(R.color.gridcolorblue3));
                }
                if (i3 % 7 == 6) {
                    this.f3383d.setColor(this.f3385f.getResources().getColor(R.color.gridcolorpink));
                }
                canvas.drawLines(fArr, this.f3383d);
            }
            i3 += this.f3382c;
        }
    }
}
