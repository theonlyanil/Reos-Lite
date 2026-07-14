package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.aa;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<View> f3996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f3997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0071a f3998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PopupWindow f3999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f4000f = b.BLUE;
    private long g = 6000;
    private final ViewTreeObserver.OnScrollChangedListener h = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.facebook.login.widget.a.1
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (a.this.f3996b.get() == null || a.this.f3999e == null || !a.this.f3999e.isShowing()) {
                return;
            }
            if (a.this.f3999e.isAboveAnchor()) {
                a.this.f3998d.b();
            } else {
                a.this.f3998d.a();
            }
        }
    };

    /* JADX INFO: renamed from: com.facebook.login.widget.a$a, reason: collision with other inner class name */
    private class C0071a extends FrameLayout {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ImageView f4005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ImageView f4006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private View f4007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ImageView f4008e;

        public C0071a(Context context) {
            super(context);
            c();
        }

        private void c() {
            LayoutInflater.from(getContext()).inflate(aa.e.com_facebook_tooltip_bubble, this);
            this.f4005b = (ImageView) findViewById(aa.d.com_facebook_tooltip_bubble_view_top_pointer);
            this.f4006c = (ImageView) findViewById(aa.d.com_facebook_tooltip_bubble_view_bottom_pointer);
            this.f4007d = findViewById(aa.d.com_facebook_body_frame);
            this.f4008e = (ImageView) findViewById(aa.d.com_facebook_button_xout);
        }

        public void a() {
            this.f4005b.setVisibility(0);
            this.f4006c.setVisibility(4);
        }

        public void b() {
            this.f4005b.setVisibility(4);
            this.f4006c.setVisibility(0);
        }
    }

    public enum b {
        BLUE,
        BLACK
    }

    public a(String str, View view) {
        this.f3995a = str;
        this.f3996b = new WeakReference<>(view);
        this.f3997c = view.getContext();
    }

    private void c() {
        if (this.f3999e == null || !this.f3999e.isShowing()) {
            return;
        }
        if (this.f3999e.isAboveAnchor()) {
            this.f3998d.b();
        } else {
            this.f3998d.a();
        }
    }

    private void d() {
        e();
        if (this.f3996b.get() != null) {
            this.f3996b.get().getViewTreeObserver().addOnScrollChangedListener(this.h);
        }
    }

    private void e() {
        if (this.f3996b.get() != null) {
            this.f3996b.get().getViewTreeObserver().removeOnScrollChangedListener(this.h);
        }
    }

    public void a() {
        if (this.f3996b.get() != null) {
            this.f3998d = new C0071a(this.f3997c);
            ((TextView) this.f3998d.findViewById(aa.d.com_facebook_tooltip_bubble_view_text_body)).setText(this.f3995a);
            if (this.f4000f == b.BLUE) {
                this.f3998d.f4007d.setBackgroundResource(aa.c.com_facebook_tooltip_blue_background);
                this.f3998d.f4006c.setImageResource(aa.c.com_facebook_tooltip_blue_bottomnub);
                this.f3998d.f4005b.setImageResource(aa.c.com_facebook_tooltip_blue_topnub);
                this.f3998d.f4008e.setImageResource(aa.c.com_facebook_tooltip_blue_xout);
            } else {
                this.f3998d.f4007d.setBackgroundResource(aa.c.com_facebook_tooltip_black_background);
                this.f3998d.f4006c.setImageResource(aa.c.com_facebook_tooltip_black_bottomnub);
                this.f3998d.f4005b.setImageResource(aa.c.com_facebook_tooltip_black_topnub);
                this.f3998d.f4008e.setImageResource(aa.c.com_facebook_tooltip_black_xout);
            }
            View decorView = ((Activity) this.f3997c).getWindow().getDecorView();
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            d();
            this.f3998d.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
            this.f3999e = new PopupWindow(this.f3998d, this.f3998d.getMeasuredWidth(), this.f3998d.getMeasuredHeight());
            this.f3999e.showAsDropDown(this.f3996b.get());
            c();
            if (this.g > 0) {
                this.f3998d.postDelayed(new Runnable() { // from class: com.facebook.login.widget.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b();
                    }
                }, this.g);
            }
            this.f3999e.setTouchable(true);
            this.f3998d.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.login.widget.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.b();
                }
            });
        }
    }

    public void a(long j) {
        this.g = j;
    }

    public void a(b bVar) {
        this.f4000f = bVar;
    }

    public void b() {
        e();
        if (this.f3999e != null) {
            this.f3999e.dismiss();
        }
    }
}
