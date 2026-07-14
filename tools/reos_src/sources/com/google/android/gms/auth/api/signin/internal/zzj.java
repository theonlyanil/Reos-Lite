package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzlf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzj {
    private final Map<com.google.android.gms.auth.api.signin.zze, zzld> zzWf;

    public zzj(Activity activity, List<com.google.android.gms.auth.api.signin.zze> list, Map<com.google.android.gms.auth.api.signin.zze, List<String>> map) {
        zzx.zzy(activity);
        zzx.zzy(list);
        zzx.zzy(map);
        HashMap map2 = new HashMap();
        for (com.google.android.gms.auth.api.signin.zze zzeVar : list) {
            List<String> list2 = map.get(zzeVar);
            zzld zzldVarZza = zza(zzeVar, activity, list2 == null ? Collections.emptyList() : list2);
            if (zzldVarZza != null) {
                map2.put(zzeVar, zzldVarZza);
            }
        }
        this.zzWf = Collections.unmodifiableMap(map2);
    }

    private zzld zza(com.google.android.gms.auth.api.signin.zze zzeVar, Activity activity, List<String> list) {
        if (com.google.android.gms.auth.api.signin.zze.FACEBOOK.equals(zzeVar)) {
            return new zzlf(activity, list);
        }
        return null;
    }

    public zzld zza(com.google.android.gms.auth.api.signin.zze zzeVar) {
        zzx.zzy(zzeVar);
        return this.zzWf.get(zzeVar);
    }

    public Collection<zzld> zzmO() {
        return this.zzWf.values();
    }
}
