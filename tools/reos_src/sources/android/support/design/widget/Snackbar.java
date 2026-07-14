package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ah;
import android.support.v4.view.bf;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public final class Snackbar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f315a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: android.support.design.widget.Snackbar.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((Snackbar) message.obj).d();
                    return true;
                case 1:
                    ((Snackbar) message.obj).b(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewGroup f316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SnackbarLayout f318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f320f;
    private final AccessibilityManager g;
    private final q.a h = new q.a() { // from class: android.support.design.widget.Snackbar.4
        @Override // android.support.design.widget.q.a
        public void a() {
            Snackbar.f315a.sendMessage(Snackbar.f315a.obtainMessage(0, Snackbar.this));
        }

        @Override // android.support.design.widget.q.a
        public void a(int i) {
            Snackbar.f315a.sendMessage(Snackbar.f315a.obtainMessage(1, i, 0, Snackbar.this));
        }
    };

    public static class SnackbarLayout extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Button f335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f337d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private b f338e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private a f339f;

        interface a {
            void a(View view);

            void b(View view);
        }

        interface b {
            void a(View view, int i, int i2, int i3, int i4);
        }

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.SnackbarLayout);
            this.f336c = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.SnackbarLayout_android_maxWidth, -1);
            this.f337d = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.SnackbarLayout_maxActionInlineWidth, -1);
            if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.SnackbarLayout_elevation)) {
                ah.d(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.SnackbarLayout_elevation, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(android.support.design.a.f.design_layout_snackbar_include, this);
            ah.d((View) this, 1);
            ah.c((View) this, 1);
        }

        private static void a(View view, int i, int i2) {
            if (ah.z(view)) {
                ah.b(view, ah.m(view), i, ah.n(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }

        private boolean a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.f334a.getPaddingTop() == i2 && this.f334a.getPaddingBottom() == i3) {
                return z;
            }
            a(this.f334a, i2, i3);
            return true;
        }

        void a(int i, int i2) {
            ah.c(this.f334a, BitmapDescriptorFactory.HUE_RED);
            ah.s(this.f334a).a(1.0f).a(i2).b(i).c();
            if (this.f335b.getVisibility() == 0) {
                ah.c(this.f335b, BitmapDescriptorFactory.HUE_RED);
                ah.s(this.f335b).a(1.0f).a(i2).b(i).c();
            }
        }

        void b(int i, int i2) {
            ah.c((View) this.f334a, 1.0f);
            ah.s(this.f334a).a(BitmapDescriptorFactory.HUE_RED).a(i2).b(i).c();
            if (this.f335b.getVisibility() == 0) {
                ah.c((View) this.f335b, 1.0f);
                ah.s(this.f335b).a(BitmapDescriptorFactory.HUE_RED).a(i2).b(i).c();
            }
        }

        Button getActionView() {
            return this.f335b;
        }

        TextView getMessageView() {
            return this.f334a;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f339f != null) {
                this.f339f.a(this);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f339f != null) {
                this.f339f.b(this);
            }
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f334a = (TextView) findViewById(android.support.design.a.e.snackbar_text);
            this.f335b = (Button) findViewById(android.support.design.a.e.snackbar_action);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f338e != null) {
                this.f338e.a(this, i, i2, i3, i4);
            }
        }

        /* JADX WARN: Code duplicated, block: B:27:0x006a  */
        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            boolean z;
            super.onMeasure(i, i2);
            if (this.f336c > 0 && getMeasuredWidth() > this.f336c) {
                i = View.MeasureSpec.makeMeasureSpec(this.f336c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(android.support.design.a.d.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(android.support.design.a.d.design_snackbar_padding_vertical);
            boolean z2 = this.f334a.getLayout().getLineCount() > 1;
            if (!z2 || this.f337d <= 0 || this.f335b.getMeasuredWidth() <= this.f337d) {
                if (!z2) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (a(0, dimensionPixelSize, dimensionPixelSize)) {
                    z = true;
                } else {
                    z = false;
                }
            } else if (a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                super.onMeasure(i, i2);
            }
        }

        void setOnAttachStateChangeListener(a aVar) {
            this.f339f = aVar;
        }

        void setOnLayoutChangeListener(b bVar) {
            this.f338e = bVar;
        }
    }

    final class a extends SwipeDismissBehavior<SnackbarLayout> {
        a() {
        }

        @Override // android.support.design.widget.SwipeDismissBehavior, android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.a(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        q.a().c(Snackbar.this.h);
                        break;
                    case 1:
                    case 3:
                        q.a().d(Snackbar.this.h);
                        break;
                }
            }
            return super.a(coordinatorLayout, snackbarLayout, motionEvent);
        }

        @Override // android.support.design.widget.SwipeDismissBehavior
        public boolean a(View view) {
            return view instanceof SnackbarLayout;
        }
    }

    public static abstract class b {
        public void a(Snackbar snackbar) {
        }

        public void a(Snackbar snackbar, int i) {
        }
    }

    private Snackbar(ViewGroup viewGroup) {
        this.f316b = viewGroup;
        this.f317c = viewGroup.getContext();
        t.a(this.f317c);
        this.f318d = (SnackbarLayout) LayoutInflater.from(this.f317c).inflate(android.support.design.a.f.design_layout_snackbar, this.f316b, false);
        this.g = (AccessibilityManager) this.f317c.getSystemService("accessibility");
    }

    public static Snackbar a(View view, CharSequence charSequence, int i) {
        Snackbar snackbar = new Snackbar(a(view));
        snackbar.a(charSequence);
        snackbar.a(i);
        return snackbar;
    }

    private static ViewGroup a(View view) {
        ViewGroup viewGroup = null;
        View view2 = view;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                Object parent = view2.getParent();
                view2 = parent instanceof View ? (View) parent : null;
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        q.a().a(this.h, i);
    }

    private void d(final int i) {
        if (Build.VERSION.SDK_INT >= 14) {
            ah.s(this.f318d).c(this.f318d.getHeight()).a(android.support.design.widget.a.f405b).a(250L).a(new bf() { // from class: android.support.design.widget.Snackbar.10
                @Override // android.support.v4.view.bf, android.support.v4.view.be
                public void a(View view) {
                    Snackbar.this.f318d.b(0, 180);
                }

                @Override // android.support.v4.view.bf, android.support.v4.view.be
                public void b(View view) {
                    Snackbar.this.e(i);
                }
            }).c();
            return;
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f318d.getContext(), android.support.design.a.C0007a.design_snackbar_out);
        animationLoadAnimation.setInterpolator(android.support.design.widget.a.f405b);
        animationLoadAnimation.setDuration(250L);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.design.widget.Snackbar.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Snackbar.this.e(i);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f318d.startAnimation(animationLoadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        q.a().a(this.h);
        if (this.f320f != null) {
            this.f320f.a(this, i);
        }
        ViewParent parent = this.f318d.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f318d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (Build.VERSION.SDK_INT >= 14) {
            ah.b(this.f318d, this.f318d.getHeight());
            ah.s(this.f318d).c(BitmapDescriptorFactory.HUE_RED).a(android.support.design.widget.a.f405b).a(250L).a(new bf() { // from class: android.support.design.widget.Snackbar.8
                @Override // android.support.v4.view.bf, android.support.v4.view.be
                public void a(View view) {
                    Snackbar.this.f318d.a(70, 180);
                }

                @Override // android.support.v4.view.bf, android.support.v4.view.be
                public void b(View view) {
                    Snackbar.this.g();
                }
            }).c();
            return;
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f318d.getContext(), android.support.design.a.C0007a.design_snackbar_in);
        animationLoadAnimation.setInterpolator(android.support.design.widget.a.f405b);
        animationLoadAnimation.setDuration(250L);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.design.widget.Snackbar.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Snackbar.this.g();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f318d.startAnimation(animationLoadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        q.a().b(this.h);
        if (this.f320f != null) {
            this.f320f.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return !this.g.isEnabled();
    }

    public Snackbar a(int i) {
        this.f319e = i;
        return this;
    }

    public Snackbar a(CharSequence charSequence) {
        this.f318d.getMessageView().setText(charSequence);
        return this;
    }

    public Snackbar a(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button actionView = this.f318d.getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
        } else {
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() { // from class: android.support.design.widget.Snackbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    Snackbar.this.c(1);
                }
            });
        }
        return this;
    }

    public void a() {
        q.a().a(this.f319e, this.h);
    }

    public void b() {
        c(3);
    }

    final void b(int i) {
        if (h() && this.f318d.getVisibility() == 0) {
            d(i);
        } else {
            e(i);
        }
    }

    public boolean c() {
        return q.a().e(this.h);
    }

    final void d() {
        if (this.f318d.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f318d.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                a aVar = new a();
                aVar.a(0.1f);
                aVar.b(0.6f);
                aVar.a(0);
                aVar.a(new SwipeDismissBehavior.a() { // from class: android.support.design.widget.Snackbar.5
                    @Override // android.support.design.widget.SwipeDismissBehavior.a
                    public void a(int i) {
                        switch (i) {
                            case 0:
                                q.a().d(Snackbar.this.h);
                                break;
                            case 1:
                            case 2:
                                q.a().c(Snackbar.this.h);
                                break;
                        }
                    }

                    @Override // android.support.design.widget.SwipeDismissBehavior.a
                    public void a(View view) {
                        view.setVisibility(8);
                        Snackbar.this.c(0);
                    }
                });
                ((CoordinatorLayout.e) layoutParams).a(aVar);
            }
            this.f316b.addView(this.f318d);
        }
        this.f318d.setOnAttachStateChangeListener(new SnackbarLayout.a() { // from class: android.support.design.widget.Snackbar.6
            @Override // android.support.design.widget.Snackbar.SnackbarLayout.a
            public void a(View view) {
            }

            @Override // android.support.design.widget.Snackbar.SnackbarLayout.a
            public void b(View view) {
                if (Snackbar.this.c()) {
                    Snackbar.f315a.post(new Runnable() { // from class: android.support.design.widget.Snackbar.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Snackbar.this.e(3);
                        }
                    });
                }
            }
        });
        if (!ah.D(this.f318d)) {
            this.f318d.setOnLayoutChangeListener(new SnackbarLayout.b() { // from class: android.support.design.widget.Snackbar.7
                @Override // android.support.design.widget.Snackbar.SnackbarLayout.b
                public void a(View view, int i, int i2, int i3, int i4) {
                    Snackbar.this.f318d.setOnLayoutChangeListener(null);
                    if (Snackbar.this.h()) {
                        Snackbar.this.f();
                    } else {
                        Snackbar.this.g();
                    }
                }
            });
        } else if (h()) {
            f();
        } else {
            g();
        }
    }
}
