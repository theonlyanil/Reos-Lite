package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.internal.zzg;

/* JADX INFO: loaded from: classes.dex */
public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int mSize;
    private String zzF;
    private View zzaYN;
    private int zzaYO;
    private int zzaYP;
    private OnPlusOneClickListener zzaYQ;

    protected class DefaultOnPlusOneClickListener implements View.OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener zzaYR;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
            this.zzaYR = onPlusOneClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.zzaYN.getTag();
            if (this.zzaYR != null) {
                this.zzaYR.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        @Override // com.google.android.gms.plus.PlusOneButton.OnPlusOneClickListener
        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if (!(context instanceof Activity) || intent == null) {
                return;
            }
            ((Activity) context).startActivityForResult(intent, PlusOneButton.this.zzaYP);
        }
    }

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSize = getSize(context, attributeSet);
        this.zzaYO = getAnnotation(context, attributeSet);
        this.zzaYP = -1;
        zzaq(getContext());
        if (isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attributeSet) {
        String strZza = zzaf.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attributeSet, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(strZza)) {
            return 2;
        }
        return !"NONE".equalsIgnoreCase(strZza) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attributeSet) {
        String strZza = zzaf.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attributeSet, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(strZza)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(strZza)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(strZza) ? 2 : 3;
    }

    private void zzaq(Context context) {
        if (this.zzaYN != null) {
            removeView(this.zzaYN);
        }
        this.zzaYN = zzg.zza(context, this.mSize, this.zzaYO, this.zzF, this.zzaYP);
        setOnPlusOneClickListener(this.zzaYQ);
        addView(this.zzaYN);
    }

    public void initialize(String str, int i) {
        zzx.zza(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.zzF = str;
        this.zzaYP = i;
        zzaq(getContext());
    }

    public void initialize(String str, OnPlusOneClickListener onPlusOneClickListener) {
        this.zzF = str;
        this.zzaYP = 0;
        zzaq(getContext());
        setOnPlusOneClickListener(onPlusOneClickListener);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.zzaYN.layout(0, 0, i3 - i, i4 - i2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.zzaYN;
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void plusOneClick() {
        this.zzaYN.performClick();
    }

    public void setAnnotation(int i) {
        this.zzaYO = i;
        zzaq(getContext());
    }

    public void setIntent(Intent intent) {
        this.zzaYN.setTag(intent);
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
        this.zzaYQ = onPlusOneClickListener;
        this.zzaYN.setOnClickListener(new DefaultOnPlusOneClickListener(onPlusOneClickListener));
    }

    public void setSize(int i) {
        this.mSize = i;
        zzaq(getContext());
    }
}
