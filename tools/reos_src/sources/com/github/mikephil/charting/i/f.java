package com.github.mikephil.charting.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static DisplayMetrics f5070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f5071b = 50;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f5072c = 8000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f5073d = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Rect f5074e = new Rect();

    public static float a(double d2) {
        float fPow = (float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d2 < 0.0d ? -d2 : d2))));
        return Math.round(((double) fPow) * d2) / fPow;
    }

    public static float a(float f2) {
        if (f5070a != null) {
            return f2 * (f5070a.densityDpi / 160.0f);
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f2;
    }

    public static float a(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static int a() {
        return f5071b;
    }

    public static int a(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static int a(List<c> list, float f2, com.github.mikephil.charting.c.g.a aVar) {
        int i = 0;
        int i2 = -2147483647;
        float f3 = Float.MAX_VALUE;
        while (true) {
            int i3 = i;
            if (i3 >= list.size()) {
                return i2;
            }
            c cVar = list.get(i3);
            if (aVar == null || cVar.f5064c.s() == aVar) {
                float fAbs = Math.abs(cVar.f5062a - f2);
                if (fAbs < f3) {
                    i2 = list.get(i3).f5063b;
                    f3 = fAbs;
                }
            }
            i = i3 + 1;
        }
    }

    public static PointF a(PointF pointF, float f2, float f3) {
        return new PointF((float) (((double) pointF.x) + (((double) f2) * Math.cos(Math.toRadians(f3)))), (float) (((double) pointF.y) + (((double) f2) * Math.sin(Math.toRadians(f3)))));
    }

    public static a a(float f2, float f3, float f4) {
        return b(f2, f3, 0.017453292f * f4);
    }

    public static void a(Context context) {
        if (context == null) {
            f5071b = ViewConfiguration.getMinimumFlingVelocity();
            f5072c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            f5071b = viewConfiguration.getScaledMinimumFlingVelocity();
            f5072c = viewConfiguration.getScaledMaximumFlingVelocity();
            f5070a = context.getResources().getDisplayMetrics();
        }
    }

    public static void a(Canvas canvas, String str, float f2, float f3, Paint paint, PointF pointF, float f4) {
        paint.getTextBounds(str, 0, str.length(), f5074e);
        float fWidth = BitmapDescriptorFactory.HUE_RED - f5074e.left;
        float fHeight = BitmapDescriptorFactory.HUE_RED - f5074e.top;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f4 != BitmapDescriptorFactory.HUE_RED) {
            float fWidth2 = fWidth - (f5074e.width() * 0.5f);
            float fHeight2 = fHeight - (f5074e.height() * 0.5f);
            if (pointF.x != 0.5f || pointF.y != 0.5f) {
                a aVarA = a(f5074e.width(), f5074e.height(), f4);
                f2 -= aVarA.f5058a * (pointF.x - 0.5f);
                f3 -= aVarA.f5059b * (pointF.y - 0.5f);
            }
            canvas.save();
            canvas.translate(f2, f3);
            canvas.rotate(f4);
            canvas.drawText(str, fWidth2, fHeight2, paint);
            canvas.restore();
        } else {
            if (pointF.x != BitmapDescriptorFactory.HUE_RED || pointF.y != BitmapDescriptorFactory.HUE_RED) {
                fWidth -= f5074e.width() * pointF.x;
                fHeight -= f5074e.height() * pointF.y;
            }
            canvas.drawText(str, fWidth + f2, fHeight + f3, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static void a(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, f5072c);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            if (i != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i);
                if ((velocityTracker.getYVelocity(pointerId2) * yVelocity) + (velocityTracker.getXVelocity(pointerId2) * xVelocity) < BitmapDescriptorFactory.HUE_RED) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(10L);
        }
    }

    public static int[] a(List<Integer> list) {
        int[] iArr = new int[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return iArr;
            }
            iArr[i2] = list.get(i2).intValue();
            i = i2 + 1;
        }
    }

    public static double b(double d2) {
        if (d2 == Double.POSITIVE_INFINITY) {
            return d2;
        }
        double d3 = d2 + 0.0d;
        return Double.longBitsToDouble((d3 >= 0.0d ? 1L : -1L) + Double.doubleToRawLongBits(d3));
    }

    public static float b(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.bottom + (fontMetrics.ascent - fontMetrics.top);
    }

    public static float b(List<c> list, float f2, com.github.mikephil.charting.c.g.a aVar) {
        int i = 0;
        float f3 = Float.MAX_VALUE;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return f3;
            }
            c cVar = list.get(i2);
            if (cVar.f5064c.s() == aVar) {
                float fAbs = Math.abs(cVar.f5062a - f2);
                if (fAbs < f3) {
                    f3 = fAbs;
                }
            }
            i = i2 + 1;
        }
    }

    public static int b() {
        return f5072c;
    }

    public static int b(float f2) {
        return ((int) Math.ceil(-Math.log10(a(f2)))) + 2;
    }

    public static int b(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static a b(float f2, float f3, float f4) {
        return new a(Math.abs(((float) Math.cos(f4)) * f2) + Math.abs(((float) Math.sin(f4)) * f3), Math.abs(((float) Math.sin(f4)) * f2) + Math.abs(((float) Math.cos(f4)) * f3));
    }

    public static String[] b(List<String> list) {
        String[] strArr = new String[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return strArr;
            }
            strArr[i2] = list.get(i2);
            i = i2 + 1;
        }
    }

    public static float c(float f2) {
        while (f2 < BitmapDescriptorFactory.HUE_RED) {
            f2 += 360.0f;
        }
        return f2 % 360.0f;
    }

    public static a c(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return new a(rect.width(), rect.height());
    }
}
