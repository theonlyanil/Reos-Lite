package com.google.android.youtube.player.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class r extends t<o> implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5329e;

    public r(Context context, String str, String str2, String str3, v.a aVar, v.b bVar) {
        super(context, aVar, bVar);
        this.f5326b = (String) c.a(str);
        this.f5327c = c.a(str2, (Object) "callingPackage cannot be null or empty");
        this.f5328d = c.a(str3, (Object) "callingAppVersion cannot be null or empty");
    }

    private final void k() {
        i();
        if (this.f5329e) {
            throw new IllegalStateException("Connection client has been released");
        }
    }

    @Override // com.google.android.youtube.player.a.e
    public final IBinder a() {
        k();
        try {
            return j().a();
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.google.android.youtube.player.a.t
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        return o.a.a(iBinder);
    }

    @Override // com.google.android.youtube.player.a.t
    protected final void a(l lVar, t.d dVar) throws RemoteException {
        lVar.a(dVar, 1202, this.f5327c, this.f5328d, this.f5326b, null);
    }

    @Override // com.google.android.youtube.player.a.e
    public final void a(boolean z) {
        if (f()) {
            try {
                j().a(z);
            } catch (RemoteException e2) {
            }
            this.f5329e = true;
        }
    }

    @Override // com.google.android.youtube.player.a.t
    protected final String b() {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    @Override // com.google.android.youtube.player.a.t
    protected final String c() {
        return "com.google.android.youtube.api.service.START";
    }

    @Override // com.google.android.youtube.player.a.t, com.google.android.youtube.player.a.v
    public final void d() {
        if (!this.f5329e) {
            a(true);
        }
        super.d();
    }
}
