package com.android.library.rmnlibrary.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.b.j;
import android.widget.MediaController;
import android.widget.VideoView;
import com.android.apps.config.util.CLog;
import com.android.library.rmnlibrary.AbstractNotification;
import com.android.library.rmnlibrary.a;
import com.android.library.rmnlibrary.b.f;
import com.google.android.gms.location.places.Place;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class RichMediaVideoActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ProgressDialog f2741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private VideoView f2742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BroadcastReceiver f2745e = new BroadcastReceiver() { // from class: com.android.library.rmnlibrary.activity.RichMediaVideoActivity.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RichMediaVideoActivity.this.f2744d = intent.getStringExtra("com.android.library.rmnlibrary.KEY_VIDEO_DURATION");
            CLog.b("RMNLibrary", "Duration played : " + RichMediaVideoActivity.this.f2744d);
        }
    };

    private void a() {
        this.f2741a.setMessage("Loading...");
        this.f2741a.setIndeterminate(false);
        this.f2741a.setCancelable(false);
        this.f2741a.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaPlayer mediaPlayer) {
        if (mediaPlayer.isPlaying()) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int duration = mediaPlayer.getDuration();
            this.f2744d = f.a(currentPosition);
            this.f2743c = f.a(duration);
            Intent intent = new Intent("com.android.library.rmnlibrary.INTENT_FILTER_VIDEO_DURATION");
            intent.putExtra("com.android.library.rmnlibrary.KEY_VIDEO_DURATION", this.f2744d);
            j.a(this).a(intent);
        }
    }

    private void a(AbstractNotification abstractNotification) {
        try {
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(this.f2742b);
            Uri uri = Uri.parse(abstractNotification.getResponse().getItem_url());
            this.f2742b.setMediaController(mediaController);
            this.f2742b.setVideoURI(uri);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f2742b.requestFocus();
        this.f2742b.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.android.library.rmnlibrary.activity.RichMediaVideoActivity.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(final MediaPlayer mediaPlayer) {
                RichMediaVideoActivity.this.f2741a.dismiss();
                RichMediaVideoActivity.this.f2742b.start();
                Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable() { // from class: com.android.library.rmnlibrary.activity.RichMediaVideoActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RichMediaVideoActivity.this.a(mediaPlayer);
                    }
                }, 100L, 5000L, TimeUnit.MILLISECONDS);
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f2742b.stopPlayback();
        CLog.b("RMNLibrary", "Duration played onBackPressed() : " + this.f2744d);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(Place.TYPE_SUBLOCALITY_LEVEL_2, Place.TYPE_SUBLOCALITY_LEVEL_2);
        setContentView(a.c.activity_video);
        this.f2742b = (VideoView) findViewById(a.b.vedio_view_rmn);
        this.f2741a = new ProgressDialog(this);
        a();
        a((AbstractNotification) getIntent().getExtras().getParcelable("Video"));
    }

    @Override // android.app.Activity
    protected void onPause() {
        j.a(this).a(this.f2745e);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        j.a(this).a(this.f2745e, new IntentFilter("com.android.library.rmnlibrary.INTENT_FILTER_VIDEO_DURATION"));
        super.onResume();
    }
}
