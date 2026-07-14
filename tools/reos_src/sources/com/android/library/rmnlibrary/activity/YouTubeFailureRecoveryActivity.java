package com.android.library.rmnlibrary.activity;

import android.content.Intent;
import android.widget.Toast;
import com.android.library.rmnlibrary.a;
import com.android.library.rmnlibrary.b.g;
import com.google.android.youtube.player.b;
import com.google.android.youtube.player.c;
import com.google.android.youtube.player.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class YouTubeFailureRecoveryActivity extends b implements d.a {
    protected abstract d.b a();

    @Override // com.google.android.youtube.player.d.a
    public void a(d.b bVar, c cVar) {
        if (cVar.a()) {
            cVar.a(this, 1).show();
        } else {
            Toast.makeText(this, String.format(getString(a.d.error_player), cVar.toString()), 1).show();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            a().a(g.a("sharedprefs.key.youtubekey", (String) null, this), this);
        }
    }
}
