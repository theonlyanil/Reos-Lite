package com.google.b.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class b implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5404a = b.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Activity f5405b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5408e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5409f = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediaPlayer f5406c = null;

    public b(Activity activity) {
        this.f5405b = activity;
        a();
    }

    private MediaPlayer a(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = context.getResources().openRawResourceFd(f.d.zxing_beep);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                assetFileDescriptorOpenRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                return mediaPlayer;
            } catch (Throwable th) {
                assetFileDescriptorOpenRawResourceFd.close();
                throw th;
            }
        } catch (IOException e2) {
            Log.w(f5404a, e2);
            mediaPlayer.release();
            return null;
        }
    }

    private static boolean a(boolean z, Context context) {
        if (!z || ((AudioManager) context.getSystemService("audio")).getRingerMode() == 2) {
            return z;
        }
        return false;
    }

    public synchronized void a() {
        this.f5407d = a(this.f5408e, this.f5405b);
        if (this.f5407d && this.f5406c == null) {
            this.f5405b.setVolumeControlStream(3);
            this.f5406c = a(this.f5405b);
        }
    }

    public void a(boolean z) {
        this.f5408e = z;
    }

    public synchronized void b() {
        if (this.f5407d && this.f5406c != null) {
            this.f5406c.start();
        }
        if (this.f5409f) {
            ((Vibrator) this.f5405b.getSystemService("vibrator")).vibrate(200L);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f5406c != null) {
            this.f5406c.release();
            this.f5406c = null;
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.seekTo(0);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public synchronized boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            if (i == 100) {
                this.f5405b.finish();
            } else {
                mediaPlayer.release();
                this.f5406c = null;
                a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }
}
