package android.support.v7.widget;

import android.graphics.Outline;

/* JADX INFO: loaded from: classes.dex */
class c extends b {
    public c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f1769a.f1311d) {
            if (this.f1769a.f1310c != null) {
                this.f1769a.f1310c.getOutline(outline);
            }
        } else if (this.f1769a.f1308a != null) {
            this.f1769a.f1308a.getOutline(outline);
        }
    }
}
