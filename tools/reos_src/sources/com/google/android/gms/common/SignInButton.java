package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzg;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private Scope[] zzaem;
    private View zzaen;
    private View.OnClickListener zzaeo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzaeo = null;
        zza(context, attributeSet);
        setStyle(this.mSize, this.mColor, this.zzaem);
    }

    private static Button zza(Context context, int i, int i2, Scope[] scopeArr) {
        zzac zzacVar = new zzac(context);
        zzacVar.zza(context.getResources(), i, i2, scopeArr);
        return zzacVar;
    }

    private void zza(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SignInButton, 0, 0);
        try {
            this.mSize = typedArrayObtainStyledAttributes.getInt(R.styleable.SignInButton_buttonSize, 0);
            this.mColor = typedArrayObtainStyledAttributes.getInt(R.styleable.SignInButton_colorScheme, 2);
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.SignInButton_scopeUris);
            if (string == null) {
                this.zzaem = null;
            } else {
                String[] strArrSplit = string.trim().split("\\s+");
                this.zzaem = new Scope[strArrSplit.length];
                for (int i = 0; i < strArrSplit.length; i++) {
                    this.zzaem[i] = new Scope(strArrSplit[i].toString());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void zzaq(Context context) {
        if (this.zzaen != null) {
            removeView(this.zzaen);
        }
        try {
            this.zzaen = zzab.zzb(context, this.mSize, this.mColor, this.zzaem);
        } catch (zzg.zza e2) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.zzaen = zza(context, this.mSize, this.mColor, this.zzaem);
        }
        addView(this.zzaen);
        this.zzaen.setEnabled(isEnabled());
        this.zzaen.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.zzaeo == null || view != this.zzaen) {
            return;
        }
        this.zzaeo.onClick(this);
    }

    public void setColorScheme(int i) {
        setStyle(this.mSize, i, this.zzaem);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.zzaen.setEnabled(z);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzaeo = onClickListener;
        if (this.zzaen != null) {
            this.zzaen.setOnClickListener(this);
        }
    }

    public void setScopes(Scope[] scopeArr) {
        setStyle(this.mSize, this.mColor, scopeArr);
    }

    public void setSize(int i) {
        setStyle(i, this.mColor, this.zzaem);
    }

    public void setStyle(int i, int i2) {
        setStyle(i, i2, this.zzaem);
    }

    public void setStyle(int i, int i2, Scope[] scopeArr) {
        this.mSize = i;
        this.mColor = i2;
        this.zzaem = scopeArr;
        zzaq(getContext());
    }
}
