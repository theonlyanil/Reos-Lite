package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.h.f;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.zzmx;
import com.google.android.gms.internal.zznx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class ImageManager {
    private static final Object zzahR = new Object();
    private static HashSet<Uri> zzahS = new HashSet<>();
    private static ImageManager zzahT;
    private static ImageManager zzahU;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzahV = Executors.newFixedThreadPool(4);
    private final zzb zzahW;
    private final zzmx zzahX;
    private final Map<com.google.android.gms.common.images.zza, ImageReceiver> zzahY;
    private final Map<Uri, ImageReceiver> zzahZ;
    private final Map<Uri, Long> zzaia;

    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<com.google.android.gms.common.images.zza> zzaib;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.zzaib = new ArrayList<>();
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.zzahV.execute(ImageManager.this.new zzc(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzb(com.google.android.gms.common.images.zza zzaVar) {
            com.google.android.gms.common.internal.zzb.zzcx("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzaib.add(zzaVar);
        }

        public void zzc(com.google.android.gms.common.images.zza zzaVar) {
            com.google.android.gms.common.internal.zzb.zzcx("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzaib.remove(zzaVar);
        }

        public void zzpU() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class zzb extends f<com.google.android.gms.common.images.zza.C0093zza, Bitmap> {
        public zzb(Context context) {
            super(zzar(context));
        }

        private static int zzar(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((((context.getApplicationInfo().flags & 1048576) != 0) && zznx.zzrN()) ? zza.zza(activityManager) : activityManager.getMemoryClass()) * 1048576 * 0.33f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.h.f
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public int sizeOf(com.google.android.gms.common.images.zza.C0093zza c0093zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.h.f
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z, com.google.android.gms.common.images.zza.C0093zza c0093zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c0093zza, bitmap, bitmap2);
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        private final ParcelFileDescriptor zzaid;

        public zzc(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.zzaid = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.common.internal.zzb.zzcy("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmapDecodeFileDescriptor = null;
            if (this.zzaid != null) {
                try {
                    bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(this.zzaid.getFileDescriptor());
                } catch (OutOfMemoryError e2) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e2);
                    z = true;
                }
                try {
                    this.zzaid.close();
                } catch (IOException e3) {
                    Log.e("ImageManager", "closed failed", e3);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(ImageManager.this.new zzf(this.mUri, bitmapDecodeFileDescriptor, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e4) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class zzd implements Runnable {
        private final com.google.android.gms.common.images.zza zzaie;

        public zzd(com.google.android.gms.common.images.zza zzaVar) {
            this.zzaie = zzaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.common.internal.zzb.zzcx("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzahY.get(this.zzaie);
            if (imageReceiver != null) {
                ImageManager.this.zzahY.remove(this.zzaie);
                imageReceiver.zzc(this.zzaie);
            }
            com.google.android.gms.common.images.zza.C0093zza c0093zza = this.zzaie.zzaig;
            if (c0093zza.uri == null) {
                this.zzaie.zza(ImageManager.this.mContext, ImageManager.this.zzahX, true);
                return;
            }
            Bitmap bitmapZza = ImageManager.this.zza(c0093zza);
            if (bitmapZza != null) {
                this.zzaie.zza(ImageManager.this.mContext, bitmapZza, true);
                return;
            }
            Long l = (Long) ImageManager.this.zzaia.get(c0093zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzaie.zza(ImageManager.this.mContext, ImageManager.this.zzahX, true);
                    return;
                }
                ImageManager.this.zzaia.remove(c0093zza.uri);
            }
            this.zzaie.zza(ImageManager.this.mContext, ImageManager.this.zzahX);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zzahZ.get(c0093zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = ImageManager.this.new ImageReceiver(c0093zza.uri);
                ImageManager.this.zzahZ.put(c0093zza.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.zzaie);
            if (!(this.zzaie instanceof com.google.android.gms.common.images.zza.zzc)) {
                ImageManager.this.zzahY.put(this.zzaie, imageReceiver2);
            }
            synchronized (ImageManager.zzahR) {
                if (!ImageManager.zzahS.contains(c0093zza.uri)) {
                    ImageManager.zzahS.add(c0093zza.uri);
                    imageReceiver2.zzpU();
                }
            }
        }
    }

    private static final class zze implements ComponentCallbacks2 {
        private final zzb zzahW;

        public zze(zzb zzbVar) {
            this.zzahW = zzbVar;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            this.zzahW.evictAll();
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.zzahW.evictAll();
            } else if (i >= 20) {
                this.zzahW.trimToSize(this.zzahW.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private boolean zzaif;
        private final CountDownLatch zzpy;

        public zzf(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzaif = z;
            this.zzpy = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList arrayList = imageReceiver.zzaib;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.google.android.gms.common.images.zza zzaVar = (com.google.android.gms.common.images.zza) arrayList.get(i);
                if (z) {
                    zzaVar.zza(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    ImageManager.this.zzaia.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zzaVar.zza(ImageManager.this.mContext, ImageManager.this.zzahX, false);
                }
                if (!(zzaVar instanceof com.google.android.gms.common.images.zza.zzc)) {
                    ImageManager.this.zzahY.remove(zzaVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.common.internal.zzb.zzcx("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.zzahW != null) {
                if (this.zzaif) {
                    ImageManager.this.zzahW.evictAll();
                    System.gc();
                    this.zzaif = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                }
                if (z) {
                    ImageManager.this.zzahW.put(new com.google.android.gms.common.images.zza.C0093zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzahZ.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzpy.countDown();
            synchronized (ImageManager.zzahR) {
                ImageManager.zzahS.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        if (z) {
            this.zzahW = new zzb(this.mContext);
            if (zznx.zzrQ()) {
                zzpR();
            }
        } else {
            this.zzahW = null;
        }
        this.zzahX = new zzmx();
        this.zzahY = new HashMap();
        this.zzahZ = new HashMap();
        this.zzaia = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzc(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap zza(com.google.android.gms.common.images.zza.C0093zza c0093zza) {
        if (this.zzahW == null) {
            return null;
        }
        return this.zzahW.get(c0093zza);
    }

    public static ImageManager zzc(Context context, boolean z) {
        if (z) {
            if (zzahU == null) {
                zzahU = new ImageManager(context, true);
            }
            return zzahU;
        }
        if (zzahT == null) {
            zzahT = new ImageManager(context, false);
        }
        return zzahT;
    }

    private void zzpR() {
        this.mContext.registerComponentCallbacks(new zze(this.zzahW));
    }

    public void loadImage(ImageView imageView, int i) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        com.google.android.gms.common.images.zza.zzb zzbVar = new com.google.android.gms.common.images.zza.zzb(imageView, uri);
        zzbVar.zzbN(i);
        zza(zzbVar);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        com.google.android.gms.common.images.zza.zzc zzcVar = new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri);
        zzcVar.zzbN(i);
        zza(zzcVar);
    }

    public void zza(com.google.android.gms.common.images.zza zzaVar) {
        com.google.android.gms.common.internal.zzb.zzcx("ImageManager.loadImage() must be called in the main thread");
        new zzd(zzaVar).run();
    }
}
