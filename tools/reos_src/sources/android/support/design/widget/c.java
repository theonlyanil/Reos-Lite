package android.support.design.widget;

import android.graphics.Outline;

/* JADX INFO: loaded from: classes.dex */
class c extends b {
    c() {
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        copyBounds(this.f417b);
        outline.setOval(this.f417b);
    }
}
