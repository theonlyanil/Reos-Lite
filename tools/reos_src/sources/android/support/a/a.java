package android.support.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.l;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f139b;

    /* JADX INFO: renamed from: android.support.a.a$a, reason: collision with other inner class name */
    public static final class C0003a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<Bundle> f141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bundle f142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ArrayList<Bundle> f143d;

        public C0003a() {
            this(null);
        }

        public C0003a(b bVar) {
            this.f140a = new Intent("android.intent.action.VIEW");
            this.f141b = null;
            this.f142c = null;
            this.f143d = null;
            if (bVar != null) {
                this.f140a.setPackage(bVar.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            l.a(bundle, "android.support.customtabs.extra.SESSION", bVar != null ? bVar.a() : null);
            this.f140a.putExtras(bundle);
        }

        public a a() {
            if (this.f141b != null) {
                this.f140a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.f141b);
            }
            if (this.f143d != null) {
                this.f140a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.f143d);
            }
            return new a(this.f140a, this.f142c);
        }
    }

    private a(Intent intent, Bundle bundle) {
        this.f138a = intent;
        this.f139b = bundle;
    }

    public void a(Activity activity, Uri uri) {
        this.f138a.setData(uri);
        android.support.v4.app.a.a(activity, this.f138a, this.f139b);
    }
}
