package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.InstanceID;
import java.io.IOException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class GcmPubSub {
    private static GcmPubSub zzaIQ;
    private static final Pattern zzaIS = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
    private InstanceID zzaIR;

    private GcmPubSub(Context context) {
        this.zzaIR = InstanceID.getInstance(context);
    }

    public static synchronized GcmPubSub getInstance(Context context) {
        if (zzaIQ == null) {
            zzaIQ = new GcmPubSub(context);
        }
        return zzaIQ;
    }

    public void subscribe(String str, String str2, Bundle bundle) throws IOException {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Invalid appInstanceToken: " + str);
        }
        if (str2 == null || !zzaIS.matcher(str2).matches()) {
            throw new IllegalArgumentException("Invalid topic name: " + str2);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("gcm.topic", str2);
        this.zzaIR.getToken(str, str2, bundle);
    }

    public void unsubscribe(String str, String str2) throws IOException {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", str2);
        this.zzaIR.zzb(str, str2, bundle);
    }
}
