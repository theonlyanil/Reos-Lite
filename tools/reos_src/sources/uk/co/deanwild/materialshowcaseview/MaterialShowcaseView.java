package uk.co.deanwild.materialshowcaseview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MaterialShowcaseView extends FrameLayout implements View.OnClickListener, View.OnTouchListener {
    private int A;
    private boolean B;
    private f C;
    private b D;
    private c E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<d> f6609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f6612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Canvas f6613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f6614f;
    private i g;
    private int h;
    private int i;
    private boolean j;
    private int k;
    private boolean l;
    private View m;
    private TextView n;
    private TextView o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private int u;
    private uk.co.deanwild.materialshowcaseview.a v;
    private boolean w;
    private long x;
    private Handler y;
    private long z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaterialShowcaseView f6618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Activity f6619b;

        public a(Activity activity) {
            this.f6619b = activity;
            this.f6618a = new MaterialShowcaseView(activity);
        }

        public a a(int i) {
            this.f6618a.setDismissTextColor(i);
            return this;
        }

        public a a(View view) {
            this.f6618a.setTarget(new j(view));
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f6618a.setDismissText(charSequence);
            return this;
        }

        public a a(String str) {
            this.f6618a.a(str);
            return this;
        }

        public a a(d dVar) {
            this.f6618a.a(dVar);
            return this;
        }

        public MaterialShowcaseView a() {
            return this.f6618a;
        }

        public a b(CharSequence charSequence) {
            this.f6618a.setContentText(charSequence);
            return this;
        }

        public MaterialShowcaseView b() {
            this.f6618a.a(this.f6619b);
            return this.f6618a;
        }
    }

    private class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MaterialShowcaseView.this.setTarget(MaterialShowcaseView.this.g);
        }
    }

    public MaterialShowcaseView(Context context) {
        super(context);
        this.j = false;
        this.k = 200;
        this.l = true;
        this.s = false;
        this.t = false;
        this.w = true;
        this.x = 300L;
        this.z = 0L;
        this.A = 0;
        this.B = false;
        a(context);
    }

    public MaterialShowcaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        this.k = 200;
        this.l = true;
        this.s = false;
        this.t = false;
        this.w = true;
        this.x = 300L;
        this.z = 0L;
        this.A = 0;
        this.B = false;
        a(context);
    }

    private void a(Context context) {
        setWillNotDraw(false);
        this.v = new uk.co.deanwild.materialshowcaseview.a();
        this.f6609a = new ArrayList();
        this.D = new b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.D);
        setOnTouchListener(this);
        this.u = Color.parseColor("#dd335075");
        setVisibility(4);
        View viewInflate = LayoutInflater.from(getContext()).inflate(g.b.showcase_content, (ViewGroup) this, true);
        this.m = viewInflate.findViewById(g.a.content_box);
        this.n = (TextView) viewInflate.findViewById(g.a.tv_content);
        this.o = (TextView) viewInflate.findViewById(g.a.tv_dismiss);
        this.o.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.B = true;
        this.C = new f(getContext(), str);
    }

    public static int b(Activity activity) {
        if (Build.VERSION.SDK_INT < 17) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            return i2 - i;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Iterator<d> it = this.f6609a.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void f() {
        if (this.f6609a != null) {
            Iterator<d> it = this.f6609a.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            this.f6609a.clear();
            this.f6609a = null;
        }
        if (this.E != null) {
            this.E.a(this, this.j);
        }
    }

    private void g() {
        boolean z = true;
        if (this.m == null || this.m.getLayoutParams() == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
        boolean z2 = false;
        if (layoutParams.bottomMargin != this.q) {
            layoutParams.bottomMargin = this.q;
            z2 = true;
        }
        if (layoutParams.topMargin != this.r) {
            layoutParams.topMargin = this.r;
            z2 = true;
        }
        if (layoutParams.gravity != this.p) {
            layoutParams.gravity = this.p;
        } else {
            z = z2;
        }
        if (z) {
            this.m.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentText(CharSequence charSequence) {
        if (this.n != null) {
            this.n.setText(charSequence);
        }
    }

    private void setContentTextColor(int i) {
        if (this.n != null) {
            this.n.setTextColor(i);
        }
    }

    private void setDelay(long j) {
        this.z = j;
    }

    private void setDismissOnTouch(boolean z) {
        this.s = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDismissText(CharSequence charSequence) {
        if (this.o != null) {
            this.o.setText(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDismissTextColor(int i) {
        if (this.o != null) {
            this.o.setTextColor(i);
        }
    }

    private void setFadeDuration(long j) {
        this.x = j;
    }

    private void setMaskColour(int i) {
        this.u = i;
    }

    private void setRadius(int i) {
        this.k = i;
    }

    private void setShouldRender(boolean z) {
        this.t = z;
    }

    private void setUseAutoRadius(boolean z) {
        this.l = z;
    }

    public void a() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (this.f6612d != null) {
            this.f6612d.recycle();
            this.f6612d = null;
        }
        this.f6614f = null;
        this.v = null;
        this.f6613e = null;
        this.y = null;
        getViewTreeObserver().removeGlobalOnLayoutListener(this.D);
        this.D = null;
        if (this.C != null) {
            this.C.e();
        }
        this.C = null;
    }

    void a(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    public void a(d dVar) {
        this.f6609a.add(dVar);
    }

    public boolean a(Activity activity) {
        if (this.B) {
            if (this.C.a()) {
                return false;
            }
            this.C.b();
        }
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this);
        setShouldRender(true);
        this.y = new Handler();
        this.y.postDelayed(new Runnable() { // from class: uk.co.deanwild.materialshowcaseview.MaterialShowcaseView.1
            @Override // java.lang.Runnable
            public void run() {
                if (MaterialShowcaseView.this.w) {
                    MaterialShowcaseView.this.c();
                } else {
                    MaterialShowcaseView.this.setVisibility(0);
                    MaterialShowcaseView.this.e();
                }
            }
        }, this.z);
        return true;
    }

    public void b() {
        this.j = true;
        if (this.w) {
            d();
        } else {
            a();
        }
    }

    public void c() {
        setVisibility(4);
        this.v.a(this, this.x, new uk.co.deanwild.materialshowcaseview.b.InterfaceC0214b() { // from class: uk.co.deanwild.materialshowcaseview.MaterialShowcaseView.2
            @Override // uk.co.deanwild.materialshowcaseview.b.InterfaceC0214b
            public void a() {
                MaterialShowcaseView.this.setVisibility(0);
                MaterialShowcaseView.this.e();
            }
        });
    }

    public void d() {
        this.v.a(this, this.x, new uk.co.deanwild.materialshowcaseview.b.a() { // from class: uk.co.deanwild.materialshowcaseview.MaterialShowcaseView.3
            @Override // uk.co.deanwild.materialshowcaseview.b.a
            public void a() {
                MaterialShowcaseView.this.setVisibility(4);
                MaterialShowcaseView.this.a();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.j && this.B && this.C != null) {
            this.C.d();
        }
        f();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.t) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (this.f6612d == null || this.f6613e == null || this.f6610b != measuredHeight || this.f6611c != measuredWidth) {
                if (this.f6612d != null) {
                    this.f6612d.recycle();
                }
                this.f6612d = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                this.f6613e = new Canvas(this.f6612d);
            }
            this.f6611c = measuredWidth;
            this.f6610b = measuredHeight;
            this.f6613e.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f6613e.drawColor(this.u);
            if (this.f6614f == null) {
                this.f6614f = new Paint();
                this.f6614f.setColor(-1);
                this.f6614f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                this.f6614f.setFlags(1);
            }
            this.f6613e.drawCircle(this.h, this.i, this.k, this.f6614f);
            canvas.drawBitmap(this.f6612d, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.s) {
            return true;
        }
        b();
        return true;
    }

    public void setConfig(h hVar) {
        setDelay(hVar.a());
        setFadeDuration(hVar.e());
        setContentTextColor(hVar.c());
        setDismissTextColor(hVar.d());
        setMaskColour(hVar.b());
    }

    void setDetachedListener(c cVar) {
        this.E = cVar;
    }

    void setPosition(Point point) {
        a(point.x, point.y);
    }

    public void setTarget(i iVar) {
        this.g = iVar;
        if (this.g != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.A = b((Activity) getContext());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != this.A) {
                    layoutParams.bottomMargin = this.A;
                }
            }
            Point pointA = this.g.a();
            setPosition(pointA);
            if (this.l) {
                setRadius(this.g.b());
            }
            int measuredHeight = getMeasuredHeight();
            int i = measuredHeight / 2;
            int i2 = pointA.y;
            if (i2 > i) {
                this.r = 0;
                this.q = (measuredHeight - i2) + this.k;
                this.p = 80;
            } else {
                this.r = i2 + this.k;
                this.q = 0;
                this.p = 48;
            }
        }
        g();
    }
}
