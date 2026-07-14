package com.cube26.iota.smartlite.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cube26.iota.smartlite.R;
import com.flurry.android.FlurryAgent;

/* JADX INFO: loaded from: classes.dex */
public class SupportPage extends android.support.v7.a.f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f3443a = {"support@getreos.com"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f3444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f3445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f3446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f3447e;

    private void g() {
        this.f3445c = (TextView) findViewById(R.id.about_support_call);
        this.f3446d = (TextView) findViewById(R.id.about_support_faqs);
        this.f3444b = (ImageView) findViewById(R.id.mail_share);
        this.f3447e = (TextView) findViewById(R.id.about_support_whatsapp);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mail_share /* 2131624272 */:
                FlurryAgent.logEvent("email_drafted");
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.EMAIL", f3443a);
                intent.putExtra("android.intent.extra.SUBJECT", "Feedback");
                intent.putExtra("android.intent.extra.TEXT", "Hi iota lite team,\n");
                Intent.createChooser(intent, "Share with");
                if (intent.resolveActivity(getPackageManager()) == null) {
                    Toast.makeText(this, "", 0).show();
                } else {
                    startActivity(intent);
                }
                break;
            case R.id.about_support_call /* 2131624273 */:
                FlurryAgent.logEvent("call_helpline_tapped");
                Intent intent2 = new Intent("android.intent.action.DIAL");
                intent2.setData(Uri.parse("tel:18001030026"));
                Intent.createChooser(intent2, "Call using ");
                if (intent2.resolveActivity(getPackageManager()) == null) {
                    Toast.makeText(this, "Missing dialer", 0).show();
                } else {
                    startActivity(intent2);
                }
                break;
            case R.id.about_support_whatsapp /* 2131624274 */:
                FlurryAgent.logEvent("whatsapp_event-clickded");
                break;
            case R.id.about_support_faqs /* 2131624275 */:
                FlurryAgent.logEvent("faq_page_opened");
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse("https://getreos.com/support/#lite-faq"));
                Intent.createChooser(intent3, "Access using ");
                if (intent3.resolveActivity(getPackageManager()) == null) {
                    Toast.makeText(this, "No internet browser", 0).show();
                } else {
                    startActivity(intent3);
                }
                break;
        }
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FlurryAgent.logEvent("customer_care_page_opened");
        setContentView(R.layout.layout_support);
        c().a(Html.fromHtml("<font color='#596475'>Support</font>"));
        c().b(true);
        c().a(true);
        g();
        this.f3445c.setOnClickListener(this);
        this.f3446d.setOnClickListener(this);
        this.f3444b.setOnClickListener(this);
        this.f3447e.setOnClickListener(this);
    }
}
