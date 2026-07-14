package com.cube26.iota.smartlite.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class RoundedImageView extends ImageView {
    public RoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, int i3) {
        if (bitmap.getWidth() != i || bitmap.getHeight() != i) {
            float width = (i * 1.0f) / bitmap.getWidth();
            float height = (i * 1.0f) / bitmap.getHeight();
            if (width >= height) {
                height = width;
            }
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * height), (int) (height * bitmap.getHeight()), false);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));
        float f2 = i2 / 2;
        float f3 = i3 / 2;
        if (i2 >= i3) {
            i2 = i3;
        }
        canvas.drawCircle(f2, f3, i2 / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        Bitmap bitmapCopy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
        int width = getWidth();
        int height = getHeight();
        canvas.drawBitmap(a(bitmapCopy, width < height ? width : height, width, height), BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
    }
}
