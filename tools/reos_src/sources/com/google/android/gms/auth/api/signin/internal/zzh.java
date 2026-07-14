package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzh {
    public static void zza(SignInConfiguration signInConfiguration, List<com.google.android.gms.auth.api.signin.zze> list, Map<com.google.android.gms.auth.api.signin.zze, List<String>> map) {
        zzx.zzy(signInConfiguration);
        zzx.zzy(list);
        zzx.zzy(map);
        GoogleSignInOptions googleSignInOptionsZzmR = signInConfiguration.zzmR();
        if (googleSignInOptionsZzmR != null) {
            list.add(com.google.android.gms.auth.api.signin.zze.GOOGLE);
            LinkedList linkedList = new LinkedList();
            Iterator<Scope> it = googleSignInOptionsZzmR.zzmu().iterator();
            while (it.hasNext()) {
                linkedList.add(it.next().zzoM());
            }
            map.put(com.google.android.gms.auth.api.signin.zze.GOOGLE, linkedList);
        }
        FacebookSignInOptions facebookSignInOptionsZzmS = signInConfiguration.zzmS();
        if (facebookSignInOptionsZzmS != null) {
            list.add(com.google.android.gms.auth.api.signin.zze.FACEBOOK);
            LinkedList linkedList2 = new LinkedList();
            Iterator<String> it2 = facebookSignInOptionsZzmS.zzmu().iterator();
            while (it2.hasNext()) {
                linkedList2.add(it2.next());
            }
            map.put(com.google.android.gms.auth.api.signin.zze.FACEBOOK, linkedList2);
        }
    }
}
