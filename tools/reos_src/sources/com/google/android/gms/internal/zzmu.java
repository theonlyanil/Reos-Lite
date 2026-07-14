package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzmu extends Drawable implements Drawable.Callback {
    private int mFrom;
    private long zzQj;
    private Drawable zzaiA;
    private boolean zzaiB;
    private boolean zzaiC;
    private boolean zzaiD;
    private int zzaiE;
    private boolean zzail;
    private int zzais;
    private int zzait;
    private int zzaiu;
    private int zzaiv;
    private int zzaiw;
    private boolean zzaix;
    private zzb zzaiy;
    private Drawable zzaiz;

    private static final class zza extends Drawable {
        private static final zza zzaiF = new zza();
        private static final C0118zza zzaiG = new C0118zza();

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzmu$zza$zza, reason: collision with other inner class name */
        private static final class C0118zza extends Drawable.ConstantState {
            private C0118zza() {
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public int getChangingConfigurations() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public Drawable newDrawable() {
                return zza.zzaiF;
            }
        }

        private zza() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable.ConstantState getConstantState() {
            return zzaiG;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    static final class zzb extends Drawable.ConstantState {
        int zzaiH;
        int zzaiI;

        zzb(zzb zzbVar) {
            if (zzbVar != null) {
                this.zzaiH = zzbVar.zzaiH;
                this.zzaiI = zzbVar.zzaiI;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.zzaiH;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new zzmu(this);
        }
    }

    public zzmu(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zza.zzaiF : drawable;
        this.zzaiz = drawable;
        drawable.setCallback(this);
        this.zzaiy.zzaiI |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? zza.zzaiF : drawable2;
        this.zzaiA = drawable2;
        drawable2.setCallback(this);
        this.zzaiy.zzaiI |= drawable2.getChangingConfigurations();
    }

    zzmu(zzb zzbVar) {
        this.zzais = 0;
        this.zzaiu = 255;
        this.zzaiw = 0;
        this.zzail = true;
        this.zzaiy = new zzb(zzbVar);
    }

    public boolean canConstantState() {
        if (!this.zzaiB) {
            this.zzaiC = (this.zzaiz.getConstantState() == null || this.zzaiA.getConstantState() == null) ? false : true;
            this.zzaiB = true;
        }
        return this.zzaiC;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        switch (this.zzais) {
            case 1:
                this.zzQj = SystemClock.uptimeMillis();
                this.zzais = 2;
                break;
            case 2:
                if (this.zzQj >= 0) {
                    float fUptimeMillis = (SystemClock.uptimeMillis() - this.zzQj) / this.zzaiv;
                    z = fUptimeMillis >= 1.0f;
                    if (z) {
                        this.zzais = 0;
                    }
                    this.zzaiw = (int) ((Math.min(fUptimeMillis, 1.0f) * (this.zzait - this.mFrom)) + this.mFrom);
                    break;
                }
            default:
                z2 = z;
                break;
        }
        int i = this.zzaiw;
        boolean z3 = this.zzail;
        Drawable drawable = this.zzaiz;
        Drawable drawable2 = this.zzaiA;
        if (z2) {
            if (!z3 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.zzaiu) {
                drawable2.setAlpha(this.zzaiu);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.zzaiu - i);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.zzaiu);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzaiu);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.zzaiy.zzaiH | this.zzaiy.zzaiI;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzaiy.zzaiH = getChangingConfigurations();
        return this.zzaiy;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.zzaiz.getIntrinsicHeight(), this.zzaiA.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.zzaiz.getIntrinsicWidth(), this.zzaiA.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (!this.zzaiD) {
            this.zzaiE = Drawable.resolveOpacity(this.zzaiz.getOpacity(), this.zzaiA.getOpacity());
            this.zzaiD = true;
        }
        return this.zzaiE;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback;
        if (!zznx.zzrN() || (callback = getCallback()) == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.zzaix && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.zzaiz.mutate();
            this.zzaiA.mutate();
            this.zzaix = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.zzaiz.setBounds(rect);
        this.zzaiA.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback;
        if (!zznx.zzrN() || (callback = getCallback()) == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.zzaiw == this.zzaiu) {
            this.zzaiw = i;
        }
        this.zzaiu = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.zzaiz.setColorFilter(colorFilter);
        this.zzaiA.setColorFilter(colorFilter);
    }

    public void startTransition(int i) {
        this.mFrom = 0;
        this.zzait = this.zzaiu;
        this.zzaiw = 0;
        this.zzaiv = i;
        this.zzais = 1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback;
        if (!zznx.zzrN() || (callback = getCallback()) == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public Drawable zzpV() {
        return this.zzaiA;
    }
}
