package com.facebook.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3833a = y.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<d> f3834b = e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, List<d>> f3835c = f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f3836d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<Integer> f3837e = Arrays.asList(20160327, 20141218, 20141107, 20141028, 20141001, 20140701, 20140324, 20140204, 20131107, 20130618, 20130502, 20121101);

    private static class a extends d {
        private a() {
            super();
        }

        @Override // com.facebook.b.y.d
        protected String a() {
            return "com.facebook.lite";
        }

        @Override // com.facebook.b.y.d
        protected String b() {
            return "com.facebook.lite.platform.LoginGDPDialogActivity";
        }
    }

    private static class b extends d {
        private b() {
            super();
        }

        @Override // com.facebook.b.y.d
        protected String a() {
            return "com.facebook.katana";
        }

        @Override // com.facebook.b.y.d
        protected String b() {
            return "com.facebook.katana.ProxyAuth";
        }
    }

    private static class c extends d {
        private c() {
            super();
        }

        @Override // com.facebook.b.y.d
        protected String a() {
            return "com.facebook.orca";
        }

        @Override // com.facebook.b.y.d
        protected String b() {
            return null;
        }
    }

    private static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final HashSet<String> f3838a = d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TreeSet<Integer> f3839b;

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:6:0x0007 A[Catch: all -> 0x000f, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007), top: B:12:0x0003 }] */
        public synchronized void a(boolean z) {
            if (z) {
                this.f3839b = y.b(this);
            } else if (this.f3839b == null) {
                this.f3839b = y.b(this);
            }
        }

        private static HashSet<String> d() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
            hashSet.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
            hashSet.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
            return hashSet;
        }

        protected abstract String a();

        public boolean a(Context context, String str) {
            String str2 = Build.BRAND;
            int i = context.getApplicationInfo().flags;
            if (str2.startsWith("generic") && (i & 2) != 0) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                    return false;
                }
                Signature[] signatureArr = packageInfo.signatures;
                for (Signature signature : signatureArr) {
                    if (!f3838a.contains(ad.a(signature.toByteArray()))) {
                        return false;
                    }
                }
                return true;
            } catch (PackageManager.NameNotFoundException e2) {
                return false;
            }
        }

        protected abstract String b();

        public TreeSet<Integer> c() {
            if (this.f3839b == null) {
                a(false);
            }
            return this.f3839b;
        }
    }

    private static class e extends d {
        private e() {
            super();
        }

        @Override // com.facebook.b.y.d
        protected String a() {
            return "com.facebook.wakizashi";
        }

        @Override // com.facebook.b.y.d
        protected String b() {
            return "com.facebook.katana.ProxyAuth";
        }
    }

    public static final int a() {
        return f3837e.get(0).intValue();
    }

    public static int a(Intent intent) {
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    public static int a(String str, int[] iArr) {
        return a(f3835c.get(str), iArr);
    }

    private static int a(List<d> list, int[] iArr) {
        b();
        if (list == null) {
            return -1;
        }
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            int iA = a(it.next().c(), a(), iArr);
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    public static int a(TreeSet<Integer> treeSet, int i, int[] iArr) {
        int length = iArr.length - 1;
        Iterator<Integer> itDescendingIterator = treeSet.descendingIterator();
        int i2 = -1;
        int i3 = length;
        while (itDescendingIterator.hasNext()) {
            int iIntValue = itDescendingIterator.next().intValue();
            int iMax = Math.max(i2, iIntValue);
            int i4 = i3;
            while (i4 >= 0 && iArr[i4] > iIntValue) {
                i4--;
            }
            if (i4 < 0) {
                return -1;
            }
            if (iArr[i4] == iIntValue) {
                if (i4 % 2 == 0) {
                    return Math.min(iMax, i);
                }
                return -1;
            }
            i3 = i4;
            i2 = iMax;
        }
        return -1;
    }

    public static Intent a(Context context) {
        for (d dVar : f3834b) {
            Intent intentB = b(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(dVar.a()).addCategory("android.intent.category.DEFAULT"), dVar);
            if (intentB != null) {
                return intentB;
            }
        }
        return null;
    }

    static Intent a(Context context, Intent intent, d dVar) {
        ResolveInfo resolveInfoResolveActivity;
        if (intent == null || (resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null || !dVar.a(context, resolveInfoResolveActivity.activityInfo.packageName)) {
            return null;
        }
        return intent;
    }

    private static Intent a(Context context, String str, String str2) {
        List<d> list = f3835c.get(str2);
        if (list == null) {
            return null;
        }
        Intent intentA = null;
        for (d dVar : list) {
            intentA = a(context, new Intent().setAction(str).setPackage(dVar.a()).addCategory("android.intent.category.DEFAULT"), dVar);
            if (intentA != null) {
                return intentA;
            }
        }
        return intentA;
    }

    public static Intent a(Context context, String str, String str2, int i, Bundle bundle) {
        Intent intentA = a(context, "com.facebook.platform.PLATFORM_ACTIVITY", str2);
        if (intentA == null) {
            return null;
        }
        a(intentA, str, str2, i, bundle);
        return intentA;
    }

    public static Intent a(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, com.facebook.login.a aVar, String str3) {
        a aVar2 = new a();
        return a(context, a(aVar2, str, collection, str2, z, z2, aVar, str3), aVar2);
    }

    public static Intent a(Intent intent, Bundle bundle, com.facebook.k kVar) {
        UUID uuidB = b(intent);
        if (uuidB == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", a(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", uuidB.toString());
        if (kVar != null) {
            bundle2.putBundle("error", a(kVar));
        }
        intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
        if (bundle == null) {
            return intent2;
        }
        intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
        return intent2;
    }

    private static Intent a(d dVar, String str, Collection<String> collection, String str2, boolean z, boolean z2, com.facebook.login.a aVar, String str3) {
        String strB = dVar.b();
        if (strB == null) {
            return null;
        }
        Intent intentPutExtra = new Intent().setClassName(dVar.a(), strB).putExtra("client_id", str);
        if (!ad.a(collection)) {
            intentPutExtra.putExtra("scope", TextUtils.join(",", collection));
        }
        if (!ad.a(str2)) {
            intentPutExtra.putExtra("e2e", str2);
        }
        intentPutExtra.putExtra("state", str3);
        intentPutExtra.putExtra("response_type", "token,signed_request");
        intentPutExtra.putExtra("return_scopes", "true");
        if (z2) {
            intentPutExtra.putExtra("default_audience", aVar.a());
        }
        intentPutExtra.putExtra("legacy_override", "v2.7");
        intentPutExtra.putExtra("auth_type", "rerequest");
        return intentPutExtra;
    }

    public static Bundle a(com.facebook.k kVar) {
        if (kVar == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error_description", kVar.toString());
        if (!(kVar instanceof com.facebook.l)) {
            return bundle;
        }
        bundle.putString("error_type", "UserCanceled");
        return bundle;
    }

    public static com.facebook.k a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("error_type");
        if (string == null) {
            string = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        String string2 = bundle.getString("error_description");
        if (string2 == null) {
            string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        return (string == null || !string.equalsIgnoreCase("UserCanceled")) ? new com.facebook.k(string2) : new com.facebook.l(string2);
    }

    public static void a(Intent intent, String str, String str2, int i, Bundle bundle) {
        String strI = com.facebook.m.i();
        String strJ = com.facebook.m.j();
        intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", i).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", str2).putExtra("com.facebook.platform.extra.APPLICATION_ID", strI);
        if (!a(i)) {
            intent.putExtra("com.facebook.platform.protocol.CALL_ID", str);
            if (!ad.a(strJ)) {
                intent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", strJ);
            }
            intent.putExtras(bundle);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", str);
        ad.a(bundle2, "app_name", strJ);
        intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle);
    }

    public static boolean a(int i) {
        return f3837e.contains(Integer.valueOf(i)) && i >= 20140701;
    }

    public static int b(int i) {
        return a(f3834b, new int[]{i});
    }

    static Intent b(Context context, Intent intent, d dVar) {
        ResolveInfo resolveInfoResolveService;
        if (intent == null || (resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0)) == null || !dVar.a(context, resolveInfoResolveService.serviceInfo.packageName)) {
            return null;
        }
        return intent;
    }

    public static Intent b(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, com.facebook.login.a aVar, String str3) {
        for (d dVar : f3834b) {
            Intent intentA = a(context, a(dVar, str, collection, str2, z, z2, aVar, str3), dVar);
            if (intentA != null) {
                return intentA;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TreeSet<Integer> b(d dVar) throws Throwable {
        Cursor cursorQuery;
        TreeSet<Integer> treeSet = new TreeSet<>();
        ContentResolver contentResolver = com.facebook.m.f().getContentResolver();
        String[] strArr = {"version"};
        Uri uriC = c(dVar);
        try {
            if (com.facebook.m.f().getPackageManager().resolveContentProvider(dVar.a() + ".provider.PlatformProvider", 0) != null) {
                try {
                    cursorQuery = contentResolver.query(uriC, strArr, null, null, null);
                } catch (NullPointerException | SecurityException e2) {
                    Log.e(f3833a, "Failed to query content resolver.");
                    cursorQuery = null;
                }
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            treeSet.add(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("version"))));
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    }
                }
            } else {
                cursorQuery = null;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return treeSet;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    public static UUID b(Intent intent) {
        String stringExtra;
        if (intent == null) {
            return null;
        }
        if (a(a(intent))) {
            Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            stringExtra = bundleExtra != null ? bundleExtra.getString("action_id") : null;
        } else {
            stringExtra = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        }
        if (stringExtra == null) {
            return null;
        }
        try {
            return UUID.fromString(stringExtra);
        } catch (IllegalArgumentException e2) {
            return null;
        }
    }

    public static void b() {
        if (f3836d.compareAndSet(false, true)) {
            com.facebook.m.d().execute(new Runnable() { // from class: com.facebook.b.y.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Iterator it = y.f3834b.iterator();
                        while (it.hasNext()) {
                            ((d) it.next()).a(true);
                        }
                        y.f3836d.set(false);
                    } catch (Throwable th) {
                        y.f3836d.set(false);
                        throw th;
                    }
                }
            });
        }
    }

    private static Uri c(d dVar) {
        return Uri.parse("content://" + dVar.a() + ".provider.PlatformProvider/versions");
    }

    public static Bundle c(Intent intent) {
        if (a(a(intent))) {
            return intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        }
        return null;
    }

    public static Bundle d(Intent intent) {
        return !a(a(intent)) ? intent.getExtras() : intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
    }

    public static Bundle e(Intent intent) {
        int iA = a(intent);
        Bundle extras = intent.getExtras();
        return (!a(iA) || extras == null) ? extras : extras.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
    }

    private static List<d> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        arrayList.add(new e());
        return arrayList;
    }

    private static Map<String, List<d>> f() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c());
        map.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", f3834b);
        map.put("com.facebook.platform.action.request.FEED_DIALOG", f3834b);
        map.put("com.facebook.platform.action.request.LIKE_DIALOG", f3834b);
        map.put("com.facebook.platform.action.request.APPINVITES_DIALOG", f3834b);
        map.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList);
        map.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList);
        return map;
    }

    public static boolean f(Intent intent) {
        Bundle bundleC = c(intent);
        return bundleC != null ? bundleC.containsKey("error") : intent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
    }

    public static Bundle g(Intent intent) {
        if (!f(intent)) {
            return null;
        }
        Bundle bundleC = c(intent);
        return bundleC != null ? bundleC.getBundle("error") : intent.getExtras();
    }
}
