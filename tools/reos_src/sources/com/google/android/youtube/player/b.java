package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class b extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f5349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private YouTubePlayerView f5350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f5352d;

    private final class a implements YouTubePlayerView.b {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView) {
            if (b.this.f5350b != null && b.this.f5350b != youTubePlayerView) {
                b.this.f5350b.b(true);
            }
            b.this.f5350b = youTubePlayerView;
            if (b.this.f5351c > 0) {
                youTubePlayerView.a();
            }
            if (b.this.f5351c >= 2) {
                youTubePlayerView.b();
            }
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView, String str, d.a aVar) {
            youTubePlayerView.a(b.this, youTubePlayerView, str, aVar, b.this.f5352d);
            b.b(b.this);
        }
    }

    static /* synthetic */ Bundle b(b bVar) {
        bVar.f5352d = null;
        return null;
    }

    final YouTubePlayerView.b b() {
        return this.f5349a;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5349a = new a(this, (byte) 0);
        this.f5352d = bundle != null ? bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.f5350b != null) {
            this.f5350b.a(isFinishing());
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.f5351c = 1;
        if (this.f5350b != null) {
            this.f5350b.c();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f5351c = 2;
        if (this.f5350b != null) {
            this.f5350b.b();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", this.f5350b != null ? this.f5350b.e() : this.f5352d);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f5351c = 1;
        if (this.f5350b != null) {
            this.f5350b.a();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        this.f5351c = 0;
        if (this.f5350b != null) {
            this.f5350b.d();
        }
        super.onStop();
    }
}
