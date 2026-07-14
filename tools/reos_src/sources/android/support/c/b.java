package android.support.c;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a(this);
    }
}
