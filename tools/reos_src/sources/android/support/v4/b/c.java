package android.support.v4.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class c {
    public static Drawable a(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File a(Context context) {
        return context.getNoBackupFilesDir();
    }
}
