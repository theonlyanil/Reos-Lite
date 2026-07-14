package com.facebook.b;

import android.content.Intent;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f implements com.facebook.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Integer, a> f3725a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Integer, a> f3726b = new HashMap();

    public interface a {
        boolean a(int i, Intent intent);
    }

    public enum b {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8);

        private final int j;

        b(int i) {
            this.j = i;
        }

        public int a() {
            return com.facebook.m.n() + this.j;
        }
    }

    private static synchronized a a(Integer num) {
        return f3725a.get(num);
    }

    public static synchronized void a(int i, a aVar) {
        ae.a(aVar, "callback");
        if (!f3725a.containsKey(Integer.valueOf(i))) {
            f3725a.put(Integer.valueOf(i), aVar);
        }
    }

    private static boolean b(int i, int i2, Intent intent) {
        a aVarA = a(Integer.valueOf(i));
        if (aVarA != null) {
            return aVarA.a(i2, intent);
        }
        return false;
    }

    @Override // com.facebook.e
    public boolean a(int i, int i2, Intent intent) {
        a aVar = this.f3726b.get(Integer.valueOf(i));
        return aVar != null ? aVar.a(i2, intent) : b(i, i2, intent);
    }

    public void b(int i, a aVar) {
        ae.a(aVar, "callback");
        this.f3726b.put(Integer.valueOf(i), aVar);
    }
}
