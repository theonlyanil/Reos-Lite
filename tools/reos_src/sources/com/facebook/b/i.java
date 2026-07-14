package com.facebook.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.FacebookActivity;

/* JADX INFO: loaded from: classes.dex */
public class i {

    public interface a {
        Bundle a();

        Bundle b();
    }

    public static void a(com.facebook.b.a aVar) {
        a(aVar, new com.facebook.k("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    public static void a(com.facebook.b.a aVar, Activity activity) {
        activity.startActivityForResult(aVar.b(), aVar.d());
        aVar.e();
    }

    public static void a(com.facebook.b.a aVar, a aVar2, h hVar) {
        Context contextF = com.facebook.m.f();
        String strA = hVar.a();
        int iB = b(hVar);
        if (iB == -1) {
            throw new com.facebook.k("Cannot present this dialog. This likely means that the Facebook app is not installed.");
        }
        Bundle bundleA = y.a(iB) ? aVar2.a() : aVar2.b();
        if (bundleA == null) {
            bundleA = new Bundle();
        }
        Intent intentA = y.a(contextF, aVar.c().toString(), strA, iB, bundleA);
        if (intentA == null) {
            throw new com.facebook.k("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        aVar.a(intentA);
    }

    public static void a(com.facebook.b.a aVar, o oVar) {
        oVar.a(aVar.b(), aVar.d());
        aVar.e();
    }

    public static void a(com.facebook.b.a aVar, com.facebook.k kVar) {
        b(aVar, kVar);
    }

    public static void a(com.facebook.b.a aVar, String str, Bundle bundle) {
        ae.b(com.facebook.m.f());
        ae.a(com.facebook.m.f());
        Bundle bundle2 = new Bundle();
        bundle2.putString("action", str);
        bundle2.putBundle("params", bundle);
        Intent intent = new Intent();
        y.a(intent, aVar.c().toString(), str, y.a(), bundle2);
        intent.setClass(com.facebook.m.f(), FacebookActivity.class);
        intent.setAction("FacebookDialogFragment");
        aVar.a(intent);
    }

    public static boolean a(h hVar) {
        return b(hVar) != -1;
    }

    private static int[] a(String str, String str2, h hVar) {
        ad.a aVarA = ad.a(str, str2, hVar.name());
        return aVarA != null ? aVarA.c() : new int[]{hVar.b()};
    }

    public static int b(h hVar) {
        String strI = com.facebook.m.i();
        String strA = hVar.a();
        return y.a(strA, a(strI, strA, hVar));
    }

    public static void b(com.facebook.b.a aVar, com.facebook.k kVar) {
        if (kVar == null) {
            return;
        }
        ae.b(com.facebook.m.f());
        Intent intent = new Intent();
        intent.setClass(com.facebook.m.f(), FacebookActivity.class);
        intent.setAction(FacebookActivity.f3499a);
        y.a(intent, aVar.c().toString(), (String) null, y.a(), y.a(kVar));
        aVar.a(intent);
    }
}
