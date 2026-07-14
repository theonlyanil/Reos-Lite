package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ActionBarContainer f1769a;

    public b(ActionBarContainer actionBarContainer) {
        this.f1769a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1769a.f1311d) {
            if (this.f1769a.f1310c != null) {
                this.f1769a.f1310c.draw(canvas);
            }
        } else {
            if (this.f1769a.f1308a != null) {
                this.f1769a.f1308a.draw(canvas);
            }
            if (this.f1769a.f1309b == null || !this.f1769a.f1312e) {
                return;
            }
            this.f1769a.f1309b.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
