package android.support.v4.widget;

import android.os.Build;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static void a(ListView listView, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            p.a(listView, i);
        } else {
            o.a(listView, i);
        }
    }
}
