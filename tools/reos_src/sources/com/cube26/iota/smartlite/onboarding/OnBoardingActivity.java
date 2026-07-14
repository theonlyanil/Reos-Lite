package com.cube26.iota.smartlite.onboarding;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.t;
import android.support.v4.app.v;
import android.support.v4.view.ViewPager;
import android.support.v7.a.f;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.MainActivity;
import com.cube26.iota.smartlite.R;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class OnBoardingActivity extends f implements ViewPager.f, ViewPager.g, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f3389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f3391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f3392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f3393e;
    private Fragment[] g;
    private ViewPager h;
    private a i;
    private int j;
    private ImageView[] k;
    private LinearLayout l;
    private VectorDrawable n;
    private android.support.b.a.f o;
    private FrameLayout p;
    private AppCompatImageView q;
    private TextView u;
    private int v;
    private int w;
    private HashMap<Integer, b> m = new HashMap<>();
    private final int r = 97;
    private final int s = 175;
    private int[] t = {Color.parseColor("#fd6a21"), Color.parseColor("#76abff"), Color.parseColor("#09ccc6"), Color.parseColor("#ff6c6c")};
    private int x = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3394f = 0;

    private class a extends v {
        public a(t tVar) {
            super(tVar);
        }

        @Override // android.support.v4.app.v
        public Fragment a(int i) {
            switch (i) {
                case 0:
                    return OnBoardingActivity.this.g[0];
                case 1:
                    return OnBoardingActivity.this.g[1];
                case 2:
                    return OnBoardingActivity.this.g[2];
                case 3:
                    return OnBoardingActivity.this.g[3];
                default:
                    return null;
            }
        }

        @Override // android.support.v4.app.v, android.support.v4.view.ac
        public Object a(ViewGroup viewGroup, int i) {
            return super.a(viewGroup, i);
        }

        @Override // android.support.v4.app.v, android.support.v4.view.ac
        public void a(ViewGroup viewGroup, int i, Object obj) {
            super.a(viewGroup, i, obj);
        }

        @Override // android.support.v4.view.ac
        public int b() {
            return 4;
        }
    }

    private class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f3398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f3399c;

        public b(float f2, float f3) {
            this.f3398b = f2;
            this.f3399c = f3;
        }

        public float a() {
            return this.f3398b;
        }

        public float b() {
            return this.f3399c;
        }
    }

    public static int a(int i, int i2, float f2) {
        float f3 = 1.0f - f2;
        return Color.rgb((int) ((Color.red(i2) * f2) + (Color.red(i) * f3)), (int) ((Color.green(i2) * f2) + (Color.green(i) * f3)), (int) ((f3 * Color.blue(i)) + (Color.blue(i2) * f2)));
    }

    private void c(int i) {
        b bVar;
        b bVar2;
        int i2;
        if (this.x == 0) {
            this.x++;
            return;
        }
        CLog.a("IOTA", " position :: " + i);
        if (i >= 0 && i < 100) {
            b bVar3 = this.m.get(0);
            bVar = this.m.get(1);
            bVar2 = bVar3;
            i2 = 0;
        } else if (i < 100 || i >= 200) {
            b bVar4 = this.m.get(2);
            bVar = this.m.get(3);
            bVar2 = bVar4;
            i2 = 200;
        } else {
            b bVar5 = this.m.get(1);
            bVar = this.m.get(2);
            bVar2 = bVar5;
            i2 = 100;
        }
        CLog.a("IOTA", " threshold " + i2);
        float fA = bVar2.a();
        float fB = bVar2.b();
        CLog.a("IOTA", " current ::  x :: " + fA + " y :: " + fB);
        float fA2 = bVar.a();
        float fB2 = bVar.b();
        CLog.a("IOTA", " nextPoint ::  x :: " + fA2 + " y :: " + fB2);
        float fSqrt = (float) Math.sqrt(((fA2 - fA) * (fA2 - fA)) + ((fB2 - fB) * (fB2 - fB)));
        CLog.a("IOTA", " distance :: " + fSqrt);
        float f2 = (fSqrt / 100.0f) * (i - i2);
        CLog.a("IOTA", " hypdistance :: " + f2);
        float f3 = (fB2 - fB) / (fA2 - fA);
        CLog.a("IOTA", " slope :: " + f3);
        float fCos = ((float) Math.cos(Math.atan(f3))) * f2;
        float fSin = ((float) Math.sin(Math.atan(f3))) * f2;
        CLog.a("IOTA", " dx :: " + fCos + " dy :: " + fSin);
        if (fA2 < fA) {
            this.p.setX(fA - fCos);
        } else {
            this.p.setX(fA + fCos);
        }
        if (fB2 < fB) {
            this.p.setY(fB - fSin);
        } else {
            this.p.setY(fB + fSin);
        }
        CLog.a("IOTA", " x :: " + this.p.getX() + " y :: " + this.p.getY());
        if (i2 == 0 && f2 != BitmapDescriptorFactory.HUE_RED) {
            CLog.a("IOTA", " hypo");
            this.p.getLayoutParams().width = (int) (this.v * (1.0f - (f2 / (2.0f * fSqrt))));
            this.p.getLayoutParams().height = (int) (this.w * (1.0f - (f2 / (2.0f * fSqrt))));
            this.p.invalidate();
            this.p.requestLayout();
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (i2 == 0) {
                this.n.setTint(a(this.t[0], this.t[1], f2 / fSqrt));
                return;
            } else if (i2 == 100) {
                this.n.setTint(a(this.t[1], this.t[2], f2 / fSqrt));
                return;
            } else {
                this.n.setTint(a(this.t[2], this.t[3], f2 / fSqrt));
                return;
            }
        }
        if (i2 == 0) {
            this.o.setTint(a(this.t[0], this.t[1], f2 / fSqrt));
        } else if (i2 == 100) {
            this.o.setTint(a(this.t[1], this.t[2], f2 / fSqrt));
        } else {
            this.o.setTint(a(this.t[2], this.t[3], f2 / fSqrt));
        }
    }

    private void g() {
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.onboarding.OnBoardingActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OnBoardingActivity.this.u.getText().toString().equalsIgnoreCase("Done")) {
                    OnBoardingActivity.this.getSharedPreferences("walkthrough_shared_prefs", 0).edit().putBoolean("is_completed", true).commit();
                    OnBoardingActivity.this.startActivity(new Intent(OnBoardingActivity.this, (Class<?>) MainActivity.class));
                    OnBoardingActivity.this.finish();
                }
            }
        });
    }

    private void h() {
        this.f3389a = getWindowManager().getDefaultDisplay().getWidth();
        this.f3390b = getWindowManager().getDefaultDisplay().getHeight();
        this.f3391c = getResources().getDisplayMetrics().density;
        CLog.a("IOTA", " density :: " + this.f3391c + " : " + getResources().getDisplayMetrics().densityDpi + " : " + getResources().getDisplayMetrics().scaledDensity);
        this.v = (int) (97.0f * this.f3391c);
        this.w = (int) (175.0f * this.f3391c);
        this.f3392d = (this.f3389a / 6) - ((int) (16.0f * this.f3391c));
        this.f3393e = this.f3389a / 3;
        this.m.put(0, new b((this.f3389a / 2) - (48.0f * this.f3391c), 100.0f * this.f3391c));
        this.m.put(1, new b(this.f3392d, 150.0f));
        this.m.put(2, new b(this.f3392d + this.f3393e, 150.0f));
        this.m.put(3, new b(this.f3392d + (this.f3393e * 2), 150.0f));
    }

    private void i() {
        this.p = (FrameLayout) findViewById(R.id.lite_view_layout);
        this.q = (AppCompatImageView) findViewById(R.id.lite_cover);
        if (Build.VERSION.SDK_INT >= 23) {
            this.n = (VectorDrawable) this.q.getDrawable();
        } else {
            this.o = (android.support.b.a.f) this.q.getDrawable();
        }
        this.u = (TextView) findViewById(R.id.skip_view);
        this.u.setVisibility(8);
    }

    private void j() {
        this.j = 4;
        this.k = new ImageView[4];
        this.l = (LinearLayout) findViewById(R.id.view_pager_indicator_dots);
        for (int i = 0; i < this.j; i++) {
            this.k[i] = new ImageView(this);
            this.k[i].setImageDrawable(getResources().getDrawable(R.drawable.selected_item_dot));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(16, 0, 16, 0);
            this.l.addView(this.k[i], layoutParams);
        }
        this.k[0].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot));
    }

    private void k() {
        this.h = (ViewPager) findViewById(R.id.intro_view_pager);
        this.i = new a(getSupportFragmentManager());
        this.h.setAdapter(this.i);
        this.h.setOffscreenPageLimit(4);
        this.h.a(this);
        this.h.a(false, (ViewPager.g) this);
    }

    private void l() {
        this.g = new Fragment[4];
        this.g[0] = new com.cube26.iota.smartlite.onboarding.a();
        this.g[1] = new d();
        this.g[2] = new e();
        this.g[3] = new com.cube26.iota.smartlite.onboarding.b();
    }

    @Override // android.support.v4.view.ViewPager.f
    public void a(int i) {
    }

    @Override // android.support.v4.view.ViewPager.f
    public void a(int i, float f2, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.g
    public void a(View view, float f2) {
        if (this.f3394f != 3) {
            this.f3394f++;
            return;
        }
        this.f3394f = 0;
        CLog.a("IOTA", " transform page :: " + f2);
        if (Build.VERSION.SDK_INT <= 19) {
            c((int) ((f2 - 3.0f) * (-100.0f)));
        } else {
            c((int) (f2 * (-100.0f)));
        }
    }

    @Override // android.support.v4.view.ViewPager.f
    public void b(int i) {
        for (int i2 = 0; i2 < this.j; i2++) {
            this.k[i2].setImageDrawable(getResources().getDrawable(R.drawable.selected_item_dot));
        }
        this.k[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot));
        if (i != 3) {
            this.u.setVisibility(8);
        } else {
            this.u.setVisibility(0);
            this.u.setText("Done");
        }
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_on_boarding);
        i();
        l();
        k();
        j();
        h();
        g();
    }
}
