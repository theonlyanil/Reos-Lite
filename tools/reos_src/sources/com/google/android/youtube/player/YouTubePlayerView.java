package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.google.android.youtube.player.a.aa;
import com.google.android.youtube.player.a.q;
import com.google.android.youtube.player.a.u;
import com.google.android.youtube.player.a.v;
import com.google.android.youtube.player.a.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class YouTubePlayerView extends ViewGroup implements d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f5291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<View> f5292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f5293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.google.android.youtube.player.a.e f5294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private u f5295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f5296f;
    private q g;
    private d.b h;
    private Bundle i;
    private d.a j;
    private boolean k;
    private boolean l;

    private final class a implements ViewTreeObserver.OnGlobalFocusChangeListener {
        private a() {
        }

        /* synthetic */ a(YouTubePlayerView youTubePlayerView, byte b2) {
            this();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View view, View view2) {
            if (YouTubePlayerView.this.f5295e == null || !YouTubePlayerView.this.f5292b.contains(view2) || YouTubePlayerView.this.f5292b.contains(view)) {
                return;
            }
            YouTubePlayerView.this.f5295e.i();
        }
    }

    interface b {
        void a(YouTubePlayerView youTubePlayerView);

        void a(YouTubePlayerView youTubePlayerView, String str, d.a aVar);
    }

    public YouTubePlayerView(Context context) {
        this(context, null);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, ((com.google.android.youtube.player.b) context).b());
        if (!(context instanceof com.google.android.youtube.player.b)) {
            throw new IllegalStateException("A YouTubePlayerView can only be created with an Activity  which extends YouTubeBaseActivity as its context.");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    YouTubePlayerView(Context context, AttributeSet attributeSet, int i, b bVar) {
        super((Context) com.google.android.youtube.player.a.c.a(context, "context cannot be null"), attributeSet, i);
        byte b2 = 0;
        this.f5293c = (b) com.google.android.youtube.player.a.c.a(bVar, "listener cannot be null");
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        setClipToPadding(false);
        this.g = new q(context);
        requestTransparentRegion(this.g);
        addView(this.g);
        this.f5292b = new HashSet();
        this.f5291a = new a(this, b2);
    }

    private void a(View view) {
        if (!(view == this.g || (this.f5295e != null && view == this.f5296f))) {
            throw new UnsupportedOperationException("No views can be added on top of the player");
        }
    }

    static /* synthetic */ void a(YouTubePlayerView youTubePlayerView, Activity activity) {
        try {
            youTubePlayerView.f5295e = new u(youTubePlayerView.f5294d, com.google.android.youtube.player.a.b.a().a(activity, youTubePlayerView.f5294d, youTubePlayerView.k));
            youTubePlayerView.f5296f = youTubePlayerView.f5295e.c();
            youTubePlayerView.addView(youTubePlayerView.f5296f);
            youTubePlayerView.removeView(youTubePlayerView.g);
            youTubePlayerView.f5293c.a(youTubePlayerView);
            if (youTubePlayerView.j != null) {
                boolean zA = false;
                if (youTubePlayerView.i != null) {
                    zA = youTubePlayerView.f5295e.a(youTubePlayerView.i);
                    youTubePlayerView.i = null;
                }
                youTubePlayerView.j.a(youTubePlayerView.h, youTubePlayerView.f5295e, zA);
                youTubePlayerView.j = null;
            }
        } catch (y.a e2) {
            aa.a("Error creating YouTubePlayerView", e2);
            youTubePlayerView.a(c.INTERNAL_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        this.f5295e = null;
        this.g.c();
        if (this.j != null) {
            this.j.a(this.h, cVar);
            this.j = null;
        }
    }

    static /* synthetic */ com.google.android.youtube.player.a.e b(YouTubePlayerView youTubePlayerView) {
        youTubePlayerView.f5294d = null;
        return null;
    }

    static /* synthetic */ View g(YouTubePlayerView youTubePlayerView) {
        youTubePlayerView.f5296f = null;
        return null;
    }

    static /* synthetic */ u h(YouTubePlayerView youTubePlayerView) {
        youTubePlayerView.f5295e = null;
        return null;
    }

    final void a() {
        if (this.f5295e != null) {
            this.f5295e.d();
        }
    }

    final void a(final Activity activity, d.b bVar, String str, d.a aVar, Bundle bundle) {
        if (this.f5295e == null && this.j == null) {
            com.google.android.youtube.player.a.c.a(activity, "activity cannot be null");
            this.h = (d.b) com.google.android.youtube.player.a.c.a(bVar, "provider cannot be null");
            this.j = (d.a) com.google.android.youtube.player.a.c.a(aVar, "listener cannot be null");
            this.i = bundle;
            this.g.b();
            this.f5294d = com.google.android.youtube.player.a.b.a().a(getContext(), str, new v.a() { // from class: com.google.android.youtube.player.YouTubePlayerView.1
                @Override // com.google.android.youtube.player.a.v.a
                public final void a() {
                    if (YouTubePlayerView.this.f5294d != null) {
                        YouTubePlayerView.a(YouTubePlayerView.this, activity);
                    }
                    YouTubePlayerView.b(YouTubePlayerView.this);
                }

                @Override // com.google.android.youtube.player.a.v.a
                public final void b() {
                    if (!YouTubePlayerView.this.l && YouTubePlayerView.this.f5295e != null) {
                        YouTubePlayerView.this.f5295e.h();
                    }
                    YouTubePlayerView.this.g.a();
                    if (YouTubePlayerView.this.indexOfChild(YouTubePlayerView.this.g) < 0) {
                        YouTubePlayerView.this.addView(YouTubePlayerView.this.g);
                        YouTubePlayerView.this.removeView(YouTubePlayerView.this.f5296f);
                    }
                    YouTubePlayerView.g(YouTubePlayerView.this);
                    YouTubePlayerView.h(YouTubePlayerView.this);
                    YouTubePlayerView.b(YouTubePlayerView.this);
                }
            }, new v.b() { // from class: com.google.android.youtube.player.YouTubePlayerView.2
                @Override // com.google.android.youtube.player.a.v.b
                public final void a(c cVar) {
                    YouTubePlayerView.this.a(cVar);
                    YouTubePlayerView.b(YouTubePlayerView.this);
                }
            });
            this.f5294d.e();
        }
    }

    @Override // com.google.android.youtube.player.d.b
    public final void a(String str, d.a aVar) {
        com.google.android.youtube.player.a.c.a(str, (Object) "Developer key cannot be null or empty");
        this.f5293c.a(this, str, aVar);
    }

    final void a(boolean z) {
        if (this.f5295e != null) {
            this.f5295e.b(z);
            b(z);
        }
    }

    @Override // android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i) {
        ArrayList<View> arrayList2 = new ArrayList<>();
        super.addFocusables(arrayList2, i);
        arrayList.addAll(arrayList2);
        this.f5292b.clear();
        this.f5292b.addAll(arrayList2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ArrayList<View> arrayList2 = new ArrayList<>();
        super.addFocusables(arrayList2, i, i2);
        arrayList.addAll(arrayList2);
        this.f5292b.clear();
        this.f5292b.addAll(arrayList2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        a(view);
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        a(view);
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, int i2) {
        a(view);
        super.addView(view, i, i2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        a(view);
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
        super.addView(view, layoutParams);
    }

    final void b() {
        if (this.f5295e != null) {
            this.f5295e.e();
        }
    }

    final void b(boolean z) {
        this.l = true;
        if (this.f5295e != null) {
            this.f5295e.a(z);
        }
    }

    final void c() {
        if (this.f5295e != null) {
            this.f5295e.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void clearChildFocus(View view) {
        if (hasFocusable()) {
            requestFocus();
        } else {
            super.clearChildFocus(view);
        }
    }

    final void d() {
        if (this.f5295e != null) {
            this.f5295e.g();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f5295e != null) {
            if (keyEvent.getAction() == 0) {
                return this.f5295e.a(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 1) {
                return this.f5295e.b(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    final Bundle e() {
        return this.f5295e == null ? this.i : this.f5295e.j();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void focusableViewAvailable(View view) {
        super.focusableViewAvailable(view);
        this.f5292b.add(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalFocusChangeListener(this.f5291a);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f5295e != null) {
            this.f5295e.a(configuration);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalFocusChangeListener(this.f5291a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            getChildAt(0).layout(0, 0, i3 - i, i4 - i2);
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        if (getChildCount() <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        View childAt = getChildAt(0);
        childAt.measure(i, i2);
        setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.f5292b.add(view2);
    }

    @Override // android.view.ViewGroup
    public final void setClipToPadding(boolean z) {
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
    }
}
