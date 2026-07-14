package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
class zzlc implements ProxyApi.ProxyResult {
    private Status zzTA;
    private ProxyResponse zzVn;

    public zzlc(ProxyResponse proxyResponse) {
        this.zzVn = proxyResponse;
        this.zzTA = Status.zzaeX;
    }

    public zzlc(Status status) {
        this.zzTA = status;
    }

    @Override // com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult
    public ProxyResponse getResponse() {
        return this.zzVn;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzTA;
    }
}
