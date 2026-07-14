package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class ax implements Iterable<Intent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<Intent> f626b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f627c;

    public interface a {
        Intent a();
    }

    interface b {
    }

    static class c implements b {
        c() {
        }
    }

    static class d implements b {
        d() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f625a = new d();
        } else {
            f625a = new c();
        }
    }

    private ax(Context context) {
        this.f627c = context;
    }

    public static ax a(Context context) {
        return new ax(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ax a(Activity activity) {
        Intent intentA = activity instanceof a ? ((a) activity).a() : null;
        Intent intentA2 = intentA == null ? ab.a(activity) : intentA;
        if (intentA2 != null) {
            ComponentName component = intentA2.getComponent();
            if (component == null) {
                component = intentA2.resolveActivity(this.f627c.getPackageManager());
            }
            a(component);
            a(intentA2);
        }
        return this;
    }

    public ax a(ComponentName componentName) {
        int size = this.f626b.size();
        try {
            Intent intentA = ab.a(this.f627c, componentName);
            while (intentA != null) {
                this.f626b.add(size, intentA);
                intentA = ab.a(this.f627c, intentA.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public ax a(Intent intent) {
        this.f626b.add(intent);
        return this;
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (this.f626b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f626b.toArray(new Intent[this.f626b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (android.support.v4.b.b.a(this.f627c, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f627c.startActivity(intent);
    }

    @Override // java.lang.Iterable
    public Iterator<Intent> iterator() {
        return this.f626b.iterator();
    }
}
