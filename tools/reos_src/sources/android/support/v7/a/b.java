package android.support.v7.a;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class b implements DrawerLayout.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f1039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DrawerLayout f1040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f1041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f1042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1044f;
    private final int g;
    private final int h;
    private View.OnClickListener i;
    private boolean j;

    public interface a {
        Drawable a();

        void a(int i);

        void a(Drawable drawable, int i);

        Context b();

        boolean c();
    }

    /* JADX INFO: renamed from: android.support.v7.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0027b {
        a b();
    }

    static class c extends android.support.v7.d.a.b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f1046a;

        public c(Activity activity, Context context) {
            super(context);
            this.f1046a = activity;
        }

        @Override // android.support.v7.a.b.d
        public void a(float f2) {
            if (f2 == 1.0f) {
                b(true);
            } else if (f2 == BitmapDescriptorFactory.HUE_RED) {
                b(false);
            }
            d(f2);
        }
    }

    interface d {
        void a(float f2);
    }

    static class e implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Activity f1047a;

        e(Activity activity) {
            this.f1047a = activity;
        }

        @Override // android.support.v7.a.b.a
        public Drawable a() {
            return null;
        }

        @Override // android.support.v7.a.b.a
        public void a(int i) {
        }

        @Override // android.support.v7.a.b.a
        public void a(Drawable drawable, int i) {
        }

        @Override // android.support.v7.a.b.a
        public Context b() {
            return this.f1047a;
        }

        @Override // android.support.v7.a.b.a
        public boolean c() {
            return true;
        }
    }

    private static class f implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Activity f1048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        android.support.v7.a.c.a f1049b;

        private f(Activity activity) {
            this.f1048a = activity;
        }

        @Override // android.support.v7.a.b.a
        public Drawable a() {
            return android.support.v7.a.c.a(this.f1048a);
        }

        @Override // android.support.v7.a.b.a
        public void a(int i) {
            this.f1049b = android.support.v7.a.c.a(this.f1049b, this.f1048a, i);
        }

        @Override // android.support.v7.a.b.a
        public void a(Drawable drawable, int i) {
            this.f1048a.getActionBar().setDisplayShowHomeEnabled(true);
            this.f1049b = android.support.v7.a.c.a(this.f1049b, this.f1048a, drawable, i);
            this.f1048a.getActionBar().setDisplayShowHomeEnabled(false);
        }

        @Override // android.support.v7.a.b.a
        public Context b() {
            ActionBar actionBar = this.f1048a.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.f1048a;
        }

        @Override // android.support.v7.a.b.a
        public boolean c() {
            ActionBar actionBar = this.f1048a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }
    }

    private static class g implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Activity f1050a;

        private g(Activity activity) {
            this.f1050a = activity;
        }

        @Override // android.support.v7.a.b.a
        public Drawable a() {
            TypedArray typedArrayObtainStyledAttributes = b().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // android.support.v7.a.b.a
        public void a(int i) {
            ActionBar actionBar = this.f1050a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // android.support.v7.a.b.a
        public void a(Drawable drawable, int i) {
            ActionBar actionBar = this.f1050a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // android.support.v7.a.b.a
        public Context b() {
            ActionBar actionBar = this.f1050a.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.f1050a;
        }

        @Override // android.support.v7.a.b.a
        public boolean c() {
            ActionBar actionBar = this.f1050a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }
    }

    static class h implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Toolbar f1051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Drawable f1052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CharSequence f1053c;

        h(Toolbar toolbar) {
            this.f1051a = toolbar;
            this.f1052b = toolbar.getNavigationIcon();
            this.f1053c = toolbar.getNavigationContentDescription();
        }

        @Override // android.support.v7.a.b.a
        public Drawable a() {
            return this.f1052b;
        }

        @Override // android.support.v7.a.b.a
        public void a(int i) {
            if (i == 0) {
                this.f1051a.setNavigationContentDescription(this.f1053c);
            } else {
                this.f1051a.setNavigationContentDescription(i);
            }
        }

        @Override // android.support.v7.a.b.a
        public void a(Drawable drawable, int i) {
            this.f1051a.setNavigationIcon(drawable);
            a(i);
        }

        @Override // android.support.v7.a.b.a
        public Context b() {
            return this.f1051a.getContext();
        }

        @Override // android.support.v7.a.b.a
        public boolean c() {
            return true;
        }
    }

    public b(Activity activity, DrawerLayout drawerLayout, int i, int i2) {
        this(activity, null, drawerLayout, null, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T extends Drawable & d> b(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, T t, int i, int i2) {
        this.f1043e = true;
        this.j = false;
        if (toolbar != null) {
            this.f1039a = new h(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: android.support.v7.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.f1043e) {
                        b.this.c();
                    } else if (b.this.i != null) {
                        b.this.i.onClick(view);
                    }
                }
            });
        } else if (activity instanceof InterfaceC0027b) {
            this.f1039a = ((InterfaceC0027b) activity).b();
        } else if (Build.VERSION.SDK_INT >= 18) {
            this.f1039a = new g(activity);
        } else if (Build.VERSION.SDK_INT >= 11) {
            this.f1039a = new f(activity);
        } else {
            this.f1039a = new e(activity);
        }
        this.f1040b = drawerLayout;
        this.g = i;
        this.h = i2;
        if (t == null) {
            this.f1041c = new c(activity, this.f1039a.b());
        } else {
            this.f1041c = t;
        }
        this.f1042d = b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int iA = this.f1040b.a(8388611);
        if (this.f1040b.h(8388611) && iA != 2) {
            this.f1040b.f(8388611);
        } else if (iA != 1) {
            this.f1040b.e(8388611);
        }
    }

    public void a() {
        if (this.f1040b.g(8388611)) {
            this.f1041c.a(1.0f);
        } else {
            this.f1041c.a(BitmapDescriptorFactory.HUE_RED);
        }
        if (this.f1043e) {
            a((Drawable) this.f1041c, this.f1040b.g(8388611) ? this.h : this.g);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.f
    public void a(int i) {
    }

    public void a(Configuration configuration) {
        if (!this.f1044f) {
            this.f1042d = b();
        }
        a();
    }

    void a(Drawable drawable, int i) {
        if (!this.j && !this.f1039a.c()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.j = true;
        }
        this.f1039a.a(drawable, i);
    }

    @Override // android.support.v4.widget.DrawerLayout.f
    public void a(View view) {
        this.f1041c.a(1.0f);
        if (this.f1043e) {
            b(this.h);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.f
    public void a(View view, float f2) {
        this.f1041c.a(Math.min(1.0f, Math.max(BitmapDescriptorFactory.HUE_RED, f2)));
    }

    public boolean a(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f1043e) {
            return false;
        }
        c();
        return true;
    }

    Drawable b() {
        return this.f1039a.a();
    }

    void b(int i) {
        this.f1039a.a(i);
    }

    @Override // android.support.v4.widget.DrawerLayout.f
    public void b(View view) {
        this.f1041c.a(BitmapDescriptorFactory.HUE_RED);
        if (this.f1043e) {
            b(this.g);
        }
    }
}
