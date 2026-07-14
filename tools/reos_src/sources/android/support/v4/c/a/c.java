package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class c {
    public static Drawable a(Drawable drawable) {
        return !(drawable instanceof o) ? new j(drawable) : drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Drawable drawable, int i) {
        if (drawable instanceof o) {
            ((o) drawable).setTint(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof o) {
            ((o) drawable).setTintList(colorStateList);
        }
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        if (drawable instanceof o) {
            ((o) drawable).setTintMode(mode);
        }
    }
}
