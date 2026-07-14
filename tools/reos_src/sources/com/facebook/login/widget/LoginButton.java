package com.facebook.login.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.a.f;
import com.facebook.aa;
import com.facebook.b.ad;
import com.facebook.b.w;
import com.facebook.d;
import com.facebook.g;
import com.facebook.m;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LoginButton extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3963a = LoginButton.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f3967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f3968f;
    private boolean g;
    private com.facebook.login.widget.a.b h;
    private c i;
    private long j;
    private com.facebook.login.widget.a k;
    private d l;
    private com.facebook.login.g m;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.facebook.login.a f3975a = com.facebook.login.a.FRIENDS;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f3976b = Collections.emptyList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private w f3977c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.facebook.login.d f3978d = com.facebook.login.d.NATIVE_WITH_FALLBACK;

        a() {
        }

        public com.facebook.login.a a() {
            return this.f3975a;
        }

        public void a(com.facebook.login.a aVar) {
            this.f3975a = aVar;
        }

        public void a(com.facebook.login.d dVar) {
            this.f3978d = dVar;
        }

        public void a(List<String> list) {
            if (w.PUBLISH.equals(this.f3977c)) {
                throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
            }
            this.f3976b = list;
            this.f3977c = w.READ;
        }

        List<String> b() {
            return this.f3976b;
        }

        public void b(List<String> list) {
            if (w.READ.equals(this.f3977c)) {
                throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
            }
            if (ad.a(list)) {
                throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
            }
            this.f3976b = list;
            this.f3977c = w.PUBLISH;
        }

        public com.facebook.login.d c() {
            return this.f3978d;
        }
    }

    protected class b implements View.OnClickListener {
        protected b() {
        }

        protected com.facebook.login.g a() {
            com.facebook.login.g gVarC = com.facebook.login.g.c();
            gVarC.a(LoginButton.this.getDefaultAudience());
            gVarC.a(LoginButton.this.getLoginBehavior());
            return gVarC;
        }

        protected void a(Context context) {
            final com.facebook.login.g gVarA = a();
            if (!LoginButton.this.f3964b) {
                gVarA.d();
                return;
            }
            String string = LoginButton.this.getResources().getString(aa.f.com_facebook_loginview_log_out_action);
            String string2 = LoginButton.this.getResources().getString(aa.f.com_facebook_loginview_cancel_action);
            Profile profileA = Profile.a();
            String string3 = (profileA == null || profileA.c() == null) ? LoginButton.this.getResources().getString(aa.f.com_facebook_loginview_logged_in_using_facebook) : String.format(LoginButton.this.getResources().getString(aa.f.com_facebook_loginview_logged_in_as), profileA.c());
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(string3).setCancelable(true).setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: com.facebook.login.widget.LoginButton.b.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    gVarA.d();
                }
            }).setNegativeButton(string2, (DialogInterface.OnClickListener) null);
            builder.create().show();
        }

        protected void b() {
            com.facebook.login.g gVarA = a();
            if (w.PUBLISH.equals(LoginButton.this.f3967e.f3977c)) {
                if (LoginButton.this.getFragment() != null) {
                    gVarA.b(LoginButton.this.getFragment(), LoginButton.this.f3967e.f3976b);
                    return;
                } else if (LoginButton.this.getNativeFragment() != null) {
                    gVarA.b(LoginButton.this.getNativeFragment(), LoginButton.this.f3967e.f3976b);
                    return;
                } else {
                    gVarA.b(LoginButton.this.getActivity(), LoginButton.this.f3967e.f3976b);
                    return;
                }
            }
            if (LoginButton.this.getFragment() != null) {
                gVarA.a(LoginButton.this.getFragment(), LoginButton.this.f3967e.f3976b);
            } else if (LoginButton.this.getNativeFragment() != null) {
                gVarA.a(LoginButton.this.getNativeFragment(), LoginButton.this.f3967e.f3976b);
            } else {
                gVarA.a(LoginButton.this.getActivity(), LoginButton.this.f3967e.f3976b);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginButton.this.a(view);
            AccessToken accessTokenA = AccessToken.a();
            if (accessTokenA != null) {
                a(LoginButton.this.getContext());
            } else {
                b();
            }
            f fVarA = f.a(LoginButton.this.getContext());
            Bundle bundle = new Bundle();
            bundle.putInt("logging_in", accessTokenA != null ? 0 : 1);
            fVarA.a(LoginButton.this.f3968f, (Double) null, bundle);
        }
    }

    public enum c {
        AUTOMATIC("automatic", 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f3986e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f3987f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static c f3985d = AUTOMATIC;

        c(String str, int i) {
            this.f3986e = str;
            this.f3987f = i;
        }

        public static c a(int i) {
            for (c cVar : values()) {
                if (cVar.a() == i) {
                    return cVar;
                }
            }
            return null;
        }

        public int a() {
            return this.f3987f;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f3986e;
        }
    }

    public LoginButton(Context context) {
        super(context, null, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
        this.f3967e = new a();
        this.f3968f = "fb_login_view_usage";
        this.h = com.facebook.login.widget.a.b.BLUE;
        this.j = 6000L;
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
        this.f3967e = new a();
        this.f3968f = "fb_login_view_usage";
        this.h = com.facebook.login.widget.a.b.BLUE;
        this.j = 6000L;
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0, "fb_login_button_create", "fb_login_button_did_tap");
        this.f3967e = new a();
        this.f3968f = "fb_login_view_usage";
        this.h = com.facebook.login.widget.a.b.BLUE;
        this.j = 6000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ad.b bVar) {
        if (bVar != null && bVar.c() && getVisibility() == 0) {
            b(bVar.b());
        }
    }

    private void b() {
        switch (this.i) {
            case AUTOMATIC:
                final String strA = ad.a(getContext());
                m.d().execute(new Runnable() { // from class: com.facebook.login.widget.LoginButton.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final ad.b bVarA = ad.a(strA, false);
                        LoginButton.this.getActivity().runOnUiThread(new Runnable() { // from class: com.facebook.login.widget.LoginButton.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LoginButton.this.a(bVarA);
                            }
                        });
                    }
                });
                break;
            case DISPLAY_ALWAYS:
                b(getResources().getString(aa.f.com_facebook_tooltip_default));
                break;
        }
    }

    private void b(Context context, AttributeSet attributeSet, int i, int i2) {
        this.i = c.f3985d;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, aa.h.com_facebook_login_view, i, i2);
        try {
            this.f3964b = typedArrayObtainStyledAttributes.getBoolean(aa.h.com_facebook_login_view_com_facebook_confirm_logout, true);
            this.f3965c = typedArrayObtainStyledAttributes.getString(aa.h.com_facebook_login_view_com_facebook_login_text);
            this.f3966d = typedArrayObtainStyledAttributes.getString(aa.h.com_facebook_login_view_com_facebook_logout_text);
            this.i = c.a(typedArrayObtainStyledAttributes.getInt(aa.h.com_facebook_login_view_com_facebook_tooltip_mode, c.f3985d.a()));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void b(String str) {
        this.k = new com.facebook.login.widget.a(str, this);
        this.k.a(this.h);
        this.k.a(this.j);
        this.k.a();
    }

    private int c(String str) {
        return a(str) + getCompoundPaddingLeft() + getCompoundDrawablePadding() + getCompoundPaddingRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Resources resources = getResources();
        if (!isInEditMode() && AccessToken.a() != null) {
            setText(this.f3966d != null ? this.f3966d : resources.getString(aa.f.com_facebook_loginview_log_out_button));
            return;
        }
        if (this.f3965c != null) {
            setText(this.f3965c);
            return;
        }
        String string = resources.getString(aa.f.com_facebook_loginview_log_in_button_long);
        int width = getWidth();
        if (width != 0 && c(string) > width) {
            string = resources.getString(aa.f.com_facebook_loginview_log_in_button);
        }
        setText(string);
    }

    public void a() {
        if (this.k != null) {
            this.k.b();
            this.k = null;
        }
    }

    @Override // com.facebook.g
    protected void a(Context context, AttributeSet attributeSet, int i, int i2) {
        super.a(context, attributeSet, i, i2);
        setInternalOnClickListener(getNewLoginClickListener());
        b(context, attributeSet, i, i2);
        if (isInEditMode()) {
            setBackgroundColor(getResources().getColor(aa.a.com_facebook_blue));
            this.f3965c = "Log in with Facebook";
        } else {
            this.l = new d() { // from class: com.facebook.login.widget.LoginButton.2
                @Override // com.facebook.d
                protected void a(AccessToken accessToken, AccessToken accessToken2) {
                    LoginButton.this.c();
                }
            };
        }
        c();
    }

    public com.facebook.login.a getDefaultAudience() {
        return this.f3967e.a();
    }

    @Override // com.facebook.g
    protected int getDefaultRequestCode() {
        return com.facebook.b.f.b.Login.a();
    }

    @Override // com.facebook.g
    protected int getDefaultStyleResource() {
        return aa.g.com_facebook_loginview_default_style;
    }

    public com.facebook.login.d getLoginBehavior() {
        return this.f3967e.c();
    }

    com.facebook.login.g getLoginManager() {
        if (this.m == null) {
            this.m = com.facebook.login.g.c();
        }
        return this.m;
    }

    protected b getNewLoginClickListener() {
        return new b();
    }

    List<String> getPermissions() {
        return this.f3967e.b();
    }

    public long getToolTipDisplayTime() {
        return this.j;
    }

    public c getToolTipMode() {
        return this.i;
    }

    @Override // com.facebook.g, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l == null || this.l.c()) {
            return;
        }
        this.l.a();
        c();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.l != null) {
            this.l.b();
        }
        a();
    }

    @Override // com.facebook.g, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.g || isInEditMode()) {
            return;
        }
        this.g = true;
        b();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        int compoundPaddingBottom = getCompoundPaddingBottom() + ((int) Math.ceil(Math.abs(fontMetrics.bottom) + Math.abs(fontMetrics.top))) + getCompoundPaddingTop();
        Resources resources = getResources();
        String string = this.f3965c;
        if (string == null) {
            string = resources.getString(aa.f.com_facebook_loginview_log_in_button_long);
            int iC = c(string);
            if (resolveSize(iC, i) < iC) {
                string = resources.getString(aa.f.com_facebook_loginview_log_in_button);
            }
        }
        int iC2 = c(string);
        String string2 = this.f3966d;
        if (string2 == null) {
            string2 = resources.getString(aa.f.com_facebook_loginview_log_out_button);
        }
        setMeasuredDimension(resolveSize(Math.max(iC2, c(string2)), i), compoundPaddingBottom);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            a();
        }
    }

    public void setDefaultAudience(com.facebook.login.a aVar) {
        this.f3967e.a(aVar);
    }

    public void setLoginBehavior(com.facebook.login.d dVar) {
        this.f3967e.a(dVar);
    }

    void setLoginManager(com.facebook.login.g gVar) {
        this.m = gVar;
    }

    void setProperties(a aVar) {
        this.f3967e = aVar;
    }

    public void setPublishPermissions(List<String> list) {
        this.f3967e.b(list);
    }

    public void setPublishPermissions(String... strArr) {
        this.f3967e.b(Arrays.asList(strArr));
    }

    public void setReadPermissions(List<String> list) {
        this.f3967e.a(list);
    }

    public void setReadPermissions(String... strArr) {
        this.f3967e.a(Arrays.asList(strArr));
    }

    public void setToolTipDisplayTime(long j) {
        this.j = j;
    }

    public void setToolTipMode(c cVar) {
        this.i = cVar;
    }

    public void setToolTipStyle(com.facebook.login.widget.a.b bVar) {
        this.h = bVar;
    }
}
