package com.android.library.rmnlibrary.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.b.j;
import com.android.apps.config.util.CLog;
import com.android.library.rmnlibrary.AbstractNotification;
import com.android.library.rmnlibrary.a;
import com.android.library.rmnlibrary.b.f;
import com.android.library.rmnlibrary.b.g;
import com.google.android.gms.location.places.Place;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.d;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class RichMediaYouTubeActivity extends YouTubeFailureRecoveryActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractNotification f2750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f2753d = new BroadcastReceiver() { // from class: com.android.library.rmnlibrary.activity.RichMediaYouTubeActivity.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RichMediaYouTubeActivity.this.f2751b = intent.getStringExtra("com.android.library.rmnlibrary.KEY_VIDEO_DURATION");
            CLog.b("RMNLibrary", "Duration played : " + RichMediaYouTubeActivity.this.f2751b);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        int iA = dVar.a();
        int iB = dVar.b();
        this.f2751b = f.a(iA);
        this.f2752c = f.a(iB);
        Intent intent = new Intent("com.android.library.rmnlibrary.INTENT_FILTER_VIDEO_DURATION");
        intent.putExtra("com.android.library.rmnlibrary.KEY_VIDEO_DURATION", this.f2751b);
        j.a(this).a(intent);
    }

    @Override // com.android.library.rmnlibrary.activity.YouTubeFailureRecoveryActivity
    protected d.b a() {
        return (YouTubePlayerView) findViewById(a.b.youtube_view);
    }

    @Override // com.google.android.youtube.player.d.a
    public void a(d.b bVar, final d dVar, boolean z) {
        if (!z) {
            dVar.a(this.f2750a.getResponse().getItem_url());
        }
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable() { // from class: com.android.library.rmnlibrary.activity.RichMediaYouTubeActivity.1
            @Override // java.lang.Runnable
            public void run() {
                RichMediaYouTubeActivity.this.a(dVar);
            }
        }, 100L, 5000L, TimeUnit.MILLISECONDS);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        CLog.b("RMNLibrary", "Duration played onBackPressed() for youtube : " + this.f2751b);
        finish();
    }

    @Override // com.google.android.youtube.player.b, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(Place.TYPE_SUBLOCALITY_LEVEL_2, Place.TYPE_SUBLOCALITY_LEVEL_2);
        setContentView(a.c.activity_youtube_player);
        ((YouTubePlayerView) findViewById(a.b.youtube_view)).a(g.a("sharedprefs.key.youtubekey", (String) null, this), this);
        this.f2750a = (AbstractNotification) getIntent().getExtras().getParcelable("Video");
    }

    @Override // com.google.android.youtube.player.b, android.app.Activity
    protected void onPause() {
        j.a(this).a(this.f2753d);
        super.onPause();
    }

    @Override // com.google.android.youtube.player.b, android.app.Activity
    protected void onResume() {
        j.a(this).a(this.f2753d, new IntentFilter("com.android.library.rmnlibrary.INTENT_FILTER_VIDEO_DURATION"));
        super.onResume();
    }
}
