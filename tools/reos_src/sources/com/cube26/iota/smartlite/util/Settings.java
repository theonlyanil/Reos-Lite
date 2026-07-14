package com.cube26.iota.smartlite.util;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.R;
import com.flurry.android.FlurryAgent;

/* JADX INFO: loaded from: classes.dex */
public class Settings extends android.support.v7.a.f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f3440a;

    private void g() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.about_support);
        TextView textView = (TextView) findViewById(R.id.about_about_us);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.about_privacy);
        ImageView imageView = (ImageView) findViewById(R.id.about_lite_fb_share);
        ImageView imageView2 = (ImageView) findViewById(R.id.about_lite_insta_share);
        ImageView imageView3 = (ImageView) findViewById(R.id.about_lite_twitter_share);
        ImageView imageView4 = (ImageView) findViewById(R.id.about_lite_youtube_share);
        ImageView imageView5 = (ImageView) findViewById(R.id.about_lite_medium_share);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.about_terms_n_conditions);
        TextView textView2 = (TextView) findViewById(R.id.about_about_blog);
        this.f3440a = (WebView) findViewById(R.id.about_iota_lite);
        linearLayout.setOnClickListener(this);
        textView.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        textView2.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView4.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Uri uri = null;
        switch (view.getId()) {
            case R.id.about_about_us /* 2131624261 */:
                uri = Uri.parse("https://www.getreos.com/about_us/");
                break;
            case R.id.about_about_blog /* 2131624262 */:
                uri = Uri.parse("http://getreos.com/blog");
                break;
            case R.id.about_support /* 2131624263 */:
                startActivity(new Intent(this, (Class<?>) SupportPage.class));
                return;
            case R.id.about_terms_n_conditions /* 2131624264 */:
                uri = Uri.parse("https://www.getreos.com/tnc");
                break;
            case R.id.about_privacy /* 2131624265 */:
                FlurryAgent.logEvent("privacy_page_opened");
                uri = Uri.parse("https://www.getreos.com/privacypolicy");
                break;
            case R.id.about_lite_youtube_share /* 2131624266 */:
                uri = Uri.parse("https://www.youtube.com/channel/UCSmAdqbR2oIEyZRA2WLjsZg");
                break;
            case R.id.about_lite_medium_share /* 2131624267 */:
                uri = Uri.parse("https://medium.com/@getreos");
                break;
            case R.id.about_lite_fb_share /* 2131624268 */:
                FlurryAgent.logEvent("fb_share_tapped");
                uri = Uri.parse("https://www.facebook.com/GetReos");
                break;
            case R.id.about_lite_insta_share /* 2131624269 */:
                FlurryAgent.logEvent("instagram_share_tapped");
                uri = Uri.parse("https://www.instagram.com/getreos/");
                break;
            case R.id.about_lite_twitter_share /* 2131624270 */:
                FlurryAgent.logEvent("twitter_share_tapped");
                uri = Uri.parse("https://twitter.com/getreos");
                break;
        }
        CLog.a("IOTA", "gotourl :: " + uri);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Missing internet browser", 0).show();
        }
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_about);
        c().a(Html.fromHtml("<font color='#596475'>About</font>"));
        c().b(true);
        c().a(true);
        g();
        this.f3440a.loadData(String.valueOf(Html.fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222; \">" + getResources().getString(R.string.about_iota_lite) + "</body>]]>")), "text/html", "utf-8");
        this.f3440a.setPadding(24, 24, 24, 24);
        this.f3440a.setBackgroundColor(Color.rgb(248, 247, 247));
    }
}
