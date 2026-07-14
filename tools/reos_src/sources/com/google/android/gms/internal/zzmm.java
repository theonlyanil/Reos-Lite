package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public interface zzmm {

    public interface zza {
        void zzbz(int i);

        void zze(ConnectionResult connectionResult);

        void zzi(Bundle bundle);
    }

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    void connect();

    void disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    ConnectionResult getConnectionResult(Api<?> api);

    boolean isConnected();

    boolean isConnecting();

    <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T t);

    boolean zza(zzmp zzmpVar);

    <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T t);

    void zzoF();
}
