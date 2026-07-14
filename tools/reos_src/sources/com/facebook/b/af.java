package com.facebook.b;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.library.userprofile.util.Constants;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class af extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f3680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WebView f3681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ProgressDialog f3682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ImageView f3683f;
    private FrameLayout g;
    private boolean h;
    private boolean i;
    private boolean j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f3688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f3690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f3691d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private c f3692e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Bundle f3693f;
        private AccessToken g;

        public a(Context context, String str, Bundle bundle) {
            this.g = AccessToken.a();
            if (this.g == null) {
                String strA = ad.a(context);
                if (strA == null) {
                    throw new com.facebook.k("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
                this.f3689b = strA;
            }
            a(context, str, bundle);
        }

        public a(Context context, String str, String str2, Bundle bundle) {
            str = str == null ? ad.a(context) : str;
            ae.a(str, "applicationId");
            this.f3689b = str;
            a(context, str2, bundle);
        }

        private void a(Context context, String str, Bundle bundle) {
            this.f3688a = context;
            this.f3690c = str;
            if (bundle != null) {
                this.f3693f = bundle;
            } else {
                this.f3693f = new Bundle();
            }
        }

        public a a(c cVar) {
            this.f3692e = cVar;
            return this;
        }

        public af a() {
            if (this.g != null) {
                this.f3693f.putString("app_id", this.g.h());
                this.f3693f.putString("access_token", this.g.b());
            } else {
                this.f3693f.putString("app_id", this.f3689b);
            }
            return new af(this.f3688a, this.f3690c, this.f3693f, this.f3691d, this.f3692e);
        }

        public String b() {
            return this.f3689b;
        }

        public Context c() {
            return this.f3688a;
        }

        public int d() {
            return this.f3691d;
        }

        public Bundle e() {
            return this.f3693f;
        }

        public c f() {
            return this.f3692e;
        }
    }

    private class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!af.this.i) {
                af.this.f3682e.dismiss();
            }
            af.this.g.setBackgroundColor(0);
            af.this.f3681d.setVisibility(0);
            af.this.f3683f.setVisibility(0);
            af.this.j = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ad.a("FacebookSDK.WebDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            if (af.this.i) {
                return;
            }
            af.this.f3682e.show();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            af.this.a(new com.facebook.j(str, i, str2));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            af.this.a(new com.facebook.j(null, -11, null));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int i;
            ad.a("FacebookSDK.WebDialog", "Redirect URL: " + str);
            if (!str.startsWith(af.this.f3679b)) {
                if (str.startsWith("fbconnect://cancel")) {
                    af.this.cancel();
                    return true;
                }
                if (str.contains("touch")) {
                    return false;
                }
                try {
                    af.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } catch (ActivityNotFoundException e2) {
                    return false;
                }
            }
            Bundle bundleA = af.this.a(str);
            String string = bundleA.getString("error");
            if (string == null) {
                string = bundleA.getString("error_type");
            }
            String string2 = bundleA.getString("error_msg");
            if (string2 == null) {
                string2 = bundleA.getString("error_message");
            }
            if (string2 == null) {
                string2 = bundleA.getString("error_description");
            }
            String string3 = bundleA.getString(Constants.SMS_COLUMN_ERROR_CODE);
            if (ad.a(string3)) {
                i = -1;
            } else {
                try {
                    i = Integer.parseInt(string3);
                } catch (NumberFormatException e3) {
                    i = -1;
                }
            }
            if (ad.a(string) && ad.a(string2) && i == -1) {
                af.this.a(bundleA);
            } else if ((string == null || !(string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) && i != 4201) {
                af.this.a(new com.facebook.o(new FacebookRequestError(i, string, string2), string2));
            } else {
                af.this.cancel();
            }
            return true;
        }
    }

    public interface c {
        void a(Bundle bundle, com.facebook.k kVar);
    }

    public af(Context context, String str) {
        this(context, str, com.facebook.m.l());
    }

    public af(Context context, String str, int i) {
        super(context, i == 0 ? com.facebook.m.l() : i);
        this.f3679b = "fbconnect://success";
        this.h = false;
        this.i = false;
        this.j = false;
        this.f3678a = str;
    }

    public af(Context context, String str, Bundle bundle, int i, c cVar) {
        super(context, i == 0 ? com.facebook.m.l() : i);
        this.f3679b = "fbconnect://success";
        this.h = false;
        this.i = false;
        this.j = false;
        bundle = bundle == null ? new Bundle() : bundle;
        bundle.putString("redirect_uri", "fbconnect://success");
        bundle.putString("display", "touch");
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", com.facebook.m.g()));
        this.f3678a = ad.a(ab.a(), ab.d() + "/dialog/" + str, bundle).toString();
        this.f3680c = cVar;
    }

    private int a(int i, float f2, int i2, int i3) {
        double d2 = 0.5d;
        int i4 = (int) (i / f2);
        if (i4 <= i2) {
            d2 = 1.0d;
        } else if (i4 < i3) {
            d2 = 0.5d + ((((double) (i3 - i4)) / ((double) (i3 - i2))) * 0.5d);
        }
        return (int) (d2 * ((double) i));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void a(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f3681d = new WebView(getContext().getApplicationContext()) { // from class: com.facebook.b.af.3
            @Override // android.webkit.WebView, android.view.View
            public void onWindowFocusChanged(boolean z) {
                try {
                    super.onWindowFocusChanged(z);
                } catch (NullPointerException e2) {
                }
            }
        };
        this.f3681d.setVerticalScrollBarEnabled(false);
        this.f3681d.setHorizontalScrollBarEnabled(false);
        this.f3681d.setWebViewClient(new b());
        this.f3681d.getSettings().setJavaScriptEnabled(true);
        this.f3681d.loadUrl(this.f3678a);
        this.f3681d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f3681d.setVisibility(4);
        this.f3681d.getSettings().setSavePassword(false);
        this.f3681d.getSettings().setSaveFormData(false);
        this.f3681d.setFocusable(true);
        this.f3681d.setFocusableInTouchMode(true);
        this.f3681d.setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.b.af.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f3681d);
        linearLayout.setBackgroundColor(-872415232);
        this.g.addView(linearLayout);
    }

    private void e() {
        this.f3683f = new ImageView(getContext());
        this.f3683f.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.b.af.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                af.this.cancel();
            }
        });
        this.f3683f.setImageDrawable(getContext().getResources().getDrawable(com.facebook.aa.c.com_facebook_close));
        this.f3683f.setVisibility(4);
    }

    protected Bundle a(String str) {
        Uri uri = Uri.parse(str);
        Bundle bundleC = ad.c(uri.getQuery());
        bundleC.putAll(ad.c(uri.getFragment()));
        return bundleC;
    }

    protected void a(Bundle bundle) {
        if (this.f3680c == null || this.h) {
            return;
        }
        this.h = true;
        this.f3680c.a(bundle, null);
        dismiss();
    }

    public void a(c cVar) {
        this.f3680c = cVar;
    }

    protected void a(Throwable th) {
        if (this.f3680c == null || this.h) {
            return;
        }
        this.h = true;
        this.f3680c.a(null, th instanceof com.facebook.k ? (com.facebook.k) th : new com.facebook.k(th));
        dismiss();
    }

    protected boolean a() {
        return this.h;
    }

    protected void b(String str) {
        this.f3679b = str;
    }

    protected boolean b() {
        return this.j;
    }

    protected WebView c() {
        return this.f3681d;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.f3680c == null || this.h) {
            return;
        }
        a(new com.facebook.l());
    }

    public void d() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        getWindow().setLayout(Math.min(a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f3681d != null) {
            this.f3681d.stopLoading();
        }
        if (!this.i && this.f3682e != null && this.f3682e.isShowing()) {
            this.f3682e.dismiss();
        }
        super.dismiss();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.i = false;
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3682e = new ProgressDialog(getContext());
        this.f3682e.requestWindowFeature(1);
        this.f3682e.setMessage(getContext().getString(com.facebook.aa.f.com_facebook_loading));
        this.f3682e.setCanceledOnTouchOutside(false);
        this.f3682e.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.b.af.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                af.this.cancel();
            }
        });
        requestWindowFeature(1);
        this.g = new FrameLayout(getContext());
        d();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        e();
        a((this.f3683f.getDrawable().getIntrinsicWidth() / 2) + 1);
        this.g.addView(this.f3683f, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.g);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.i = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cancel();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        d();
    }
}
