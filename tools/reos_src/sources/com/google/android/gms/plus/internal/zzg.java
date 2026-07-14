package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.plus.PlusOneDummyView;

/* JADX INFO: loaded from: classes.dex */
public final class zzg extends com.google.android.gms.dynamic.zzg<zzc> {
    private static final zzg zzaZd = new zzg();

    private zzg() {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    public static View zza(Context context, int i, int i2, String str, int i3) {
        try {
            if (str == null) {
                throw new NullPointerException();
            }
            return (View) com.google.android.gms.dynamic.zze.zzp(zzaZd.zzaA(context).zza(com.google.android.gms.dynamic.zze.zzB(context), i, i2, str, i3));
        } catch (Exception e2) {
            return new PlusOneDummyView(context, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzdO, reason: merged with bridge method [inline-methods] */
    public zzc zzd(IBinder iBinder) {
        return zzc.zza.zzdL(iBinder);
    }
}
