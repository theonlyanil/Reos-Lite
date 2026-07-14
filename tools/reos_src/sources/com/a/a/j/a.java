package com.a.a.j;

import android.util.Log;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f2501b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<byte[]> f2502a = h.a(0);

    private a() {
    }

    public static a a() {
        return f2501b;
    }

    public boolean a(byte[] bArr) {
        boolean z = false;
        if (bArr.length == 65536) {
            synchronized (this.f2502a) {
                if (this.f2502a.size() < 32) {
                    z = true;
                    this.f2502a.offer(bArr);
                }
            }
        }
        return z;
    }

    public byte[] b() {
        byte[] bArrPoll;
        synchronized (this.f2502a) {
            bArrPoll = this.f2502a.poll();
        }
        if (bArrPoll == null) {
            bArrPoll = new byte[65536];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return bArrPoll;
    }
}
