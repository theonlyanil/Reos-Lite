package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmv;
import com.google.android.gms.internal.zzmw;
import com.google.android.gms.internal.zzmx;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class zza {
    final C0093zza zzaig;
    protected int zzaii;
    protected ImageManager.OnImageLoadedListener zzaik;
    protected int zzaio;
    protected int zzaih = 0;
    protected boolean zzaij = false;
    private boolean zzail = true;
    private boolean zzaim = false;
    private boolean zzain = true;

    /* JADX INFO: renamed from: com.google.android.gms.common.images.zza$zza, reason: collision with other inner class name */
    static final class C0093zza {
        public final Uri uri;

        public C0093zza(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0093zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return zzw.equal(((C0093zza) obj).uri, this.uri);
        }

        public int hashCode() {
            return zzw.hashCode(this.uri);
        }
    }

    public static final class zzb extends zza {
        private WeakReference<ImageView> zzaip;

        public zzb(ImageView imageView, int i) {
            super(null, i);
            com.google.android.gms.common.internal.zzb.zzu(imageView);
            this.zzaip = new WeakReference<>(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzu(imageView);
            this.zzaip = new WeakReference<>(imageView);
        }

        private void zza(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            boolean z4 = (z2 || z3) ? false : true;
            if (z4 && (imageView instanceof zzmw)) {
                int iZzpX = ((zzmw) imageView).zzpX();
                if (this.zzaii != 0 && iZzpX == this.zzaii) {
                    return;
                }
            }
            boolean zZzb = zzb(z, z2);
            Drawable drawableNewDrawable = (!this.zzaij || drawable == null) ? drawable : drawable.getConstantState().newDrawable();
            if (zZzb) {
                drawableNewDrawable = zza(imageView.getDrawable(), drawableNewDrawable);
            }
            imageView.setImageDrawable(drawableNewDrawable);
            if (imageView instanceof zzmw) {
                zzmw zzmwVar = (zzmw) imageView;
                zzmwVar.zzm(z3 ? this.zzaig.uri : null);
                zzmwVar.zzbP(z4 ? this.zzaii : 0);
            }
            if (zZzb) {
                ((zzmu) drawableNewDrawable).startTransition(250);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = this.zzaip.get();
            ImageView imageView2 = ((zzb) obj).zzaip.get();
            return (imageView2 == null || imageView == null || !zzw.equal(imageView2, imageView)) ? false : true;
        }

        public int hashCode() {
            return 0;
        }

        @Override // com.google.android.gms.common.images.zza
        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = this.zzaip.get();
            if (imageView != null) {
                zza(imageView, drawable, z, z2, z3);
            }
        }
    }

    public static final class zzc extends zza {
        private WeakReference<ImageManager.OnImageLoadedListener> zzaiq;

        public zzc(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzu(onImageLoadedListener);
            this.zzaiq = new WeakReference<>(onImageLoadedListener);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzcVar = (zzc) obj;
            ImageManager.OnImageLoadedListener onImageLoadedListener = this.zzaiq.get();
            ImageManager.OnImageLoadedListener onImageLoadedListener2 = zzcVar.zzaiq.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && zzw.equal(onImageLoadedListener2, onImageLoadedListener) && zzw.equal(zzcVar.zzaig, this.zzaig);
        }

        public int hashCode() {
            return zzw.hashCode(this.zzaig);
        }

        @Override // com.google.android.gms.common.images.zza
        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageManager.OnImageLoadedListener onImageLoadedListener;
            if (z2 || (onImageLoadedListener = this.zzaiq.get()) == null) {
                return;
            }
            onImageLoadedListener.onImageLoaded(this.zzaig.uri, drawable, z3);
        }
    }

    public zza(Uri uri, int i) {
        this.zzaii = 0;
        this.zzaig = new C0093zza(uri);
        this.zzaii = i;
    }

    private Drawable zza(Context context, zzmx zzmxVar, int i) {
        Resources resources = context.getResources();
        if (this.zzaio <= 0) {
            return resources.getDrawable(i);
        }
        zzmx.zza zzaVar = new zzmx.zza(i, this.zzaio);
        Drawable drawable = zzmxVar.get(zzaVar);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = resources.getDrawable(i);
        if ((this.zzaio & 1) != 0) {
            drawable2 = zza(resources, drawable2);
        }
        zzmxVar.put(zzaVar, drawable2);
        return drawable2;
    }

    protected Drawable zza(Resources resources, Drawable drawable) {
        return zzmv.zza(resources, drawable);
    }

    protected zzmu zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzmu) {
            drawable = ((zzmu) drawable).zzpV();
        }
        return new zzmu(drawable, drawable2);
    }

    void zza(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzu(bitmap);
        if ((this.zzaio & 1) != 0) {
            bitmap = zzmv.zza(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.zzaik != null) {
            this.zzaik.onImageLoaded(this.zzaig.uri, bitmapDrawable, true);
        }
        zza(bitmapDrawable, z, false, true);
    }

    void zza(Context context, zzmx zzmxVar) {
        if (this.zzain) {
            zza(this.zzaih != 0 ? zza(context, zzmxVar, this.zzaih) : null, false, true, false);
        }
    }

    void zza(Context context, zzmx zzmxVar, boolean z) {
        Drawable drawableZza = this.zzaii != 0 ? zza(context, zzmxVar, this.zzaii) : null;
        if (this.zzaik != null) {
            this.zzaik.onImageLoaded(this.zzaig.uri, drawableZza, false);
        }
        zza(drawableZza, z, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    protected boolean zzb(boolean z, boolean z2) {
        return this.zzail && !z2 && (!z || this.zzaim);
    }

    public void zzbN(int i) {
        this.zzaii = i;
    }
}
