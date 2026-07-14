package com.google.android.youtube.player.a;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class d extends b {
    @Override // com.google.android.youtube.player.a.b
    public final e a(Context context, String str, v.a aVar, v.b bVar) {
        return new r(context, str, context.getPackageName(), ab.d(context), aVar, bVar);
    }

    @Override // com.google.android.youtube.player.a.b
    public final g a(Activity activity, e eVar, boolean z) throws y.a {
        return y.a(activity, eVar.a(), z);
    }
}
