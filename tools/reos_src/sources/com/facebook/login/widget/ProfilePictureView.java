package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.aa;
import com.facebook.b.ad;
import com.facebook.b.p;
import com.facebook.b.q;
import com.facebook.b.r;
import com.facebook.b.v;
import com.facebook.k;
import com.facebook.u;

/* JADX INFO: loaded from: classes.dex */
public class ProfilePictureView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3988a = ProfilePictureView.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bitmap f3993f;
    private ImageView g;
    private int h;
    private q i;
    private a j;
    private Bitmap k;

    public interface a {
        void a(k kVar);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3990c = 0;
        this.f3991d = 0;
        this.f3992e = true;
        this.h = -1;
        this.k = null;
        a(context);
        a(attributeSet);
    }

    private void a(Context context) {
        removeAllViews();
        this.g = new ImageView(context);
        this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(this.g);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, aa.h.com_facebook_profile_picture_view);
        setPresetSize(typedArrayObtainStyledAttributes.getInt(aa.h.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
        this.f3992e = typedArrayObtainStyledAttributes.getBoolean(aa.h.com_facebook_profile_picture_view_com_facebook_is_cropped, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar) {
        if (rVar.a() == this.i) {
            this.i = null;
            Bitmap bitmapC = rVar.c();
            Exception excB = rVar.b();
            if (excB != null) {
                a aVar = this.j;
                if (aVar != null) {
                    aVar.a(new k("Error in downloading profile picture for profileId: " + getProfileId(), excB));
                    return;
                } else {
                    v.a(u.REQUESTS, 6, f3988a, excB.toString());
                    return;
                }
            }
            if (bitmapC != null) {
                setImageBitmap(bitmapC);
                if (rVar.d()) {
                    b(false);
                }
            }
        }
    }

    private void a(boolean z) {
        boolean zC = c();
        if (this.f3989b == null || this.f3989b.length() == 0 || (this.f3991d == 0 && this.f3990c == 0)) {
            b();
        } else if (zC || z) {
            b(true);
        }
    }

    private void b() {
        if (this.i != null) {
            p.b(this.i);
        }
        if (this.k == null) {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), a() ? aa.c.com_facebook_profile_picture_blank_square : aa.c.com_facebook_profile_picture_blank_portrait));
        } else {
            c();
            setImageBitmap(Bitmap.createScaledBitmap(this.k, this.f3991d, this.f3990c, false));
        }
    }

    private void b(boolean z) {
        q qVarA = new q.a(getContext(), q.a(this.f3989b, this.f3991d, this.f3990c)).a(z).a(this).a(new q.b() { // from class: com.facebook.login.widget.ProfilePictureView.1
            @Override // com.facebook.b.q.b
            public void a(r rVar) {
                ProfilePictureView.this.a(rVar);
            }
        }).a();
        if (this.i != null) {
            p.b(this.i);
        }
        this.i = qVarA;
        p.a(qVarA);
    }

    private int c(boolean z) {
        int i;
        switch (this.h) {
            case -4:
                i = aa.b.com_facebook_profilepictureview_preset_size_large;
                break;
            case -3:
                i = aa.b.com_facebook_profilepictureview_preset_size_normal;
                break;
            case -2:
                i = aa.b.com_facebook_profilepictureview_preset_size_small;
                break;
            case -1:
                if (!z) {
                    return 0;
                }
                i = aa.b.com_facebook_profilepictureview_preset_size_normal;
                break;
                break;
            default:
                return 0;
        }
        return getResources().getDimensionPixelSize(i);
    }

    private boolean c() {
        int i;
        boolean z = false;
        int height = getHeight();
        int width = getWidth();
        if (width >= 1 && height >= 1) {
            int iC = c(false);
            if (iC != 0) {
                height = iC;
            } else {
                iC = width;
            }
            if (iC <= height) {
                i = a() ? iC : 0;
            } else {
                iC = a() ? height : 0;
                i = height;
            }
            z = (iC == this.f3991d && i == this.f3990c) ? false : true;
            this.f3991d = iC;
            this.f3990c = i;
        }
        return z;
    }

    private void setImageBitmap(Bitmap bitmap) {
        if (this.g == null || bitmap == null) {
            return;
        }
        this.f3993f = bitmap;
        this.g.setImageBitmap(bitmap);
    }

    public final boolean a() {
        return this.f3992e;
    }

    public final a getOnErrorListener() {
        return this.j;
    }

    public final int getPresetSize() {
        return this.h;
    }

    public final String getProfileId() {
        return this.f3989b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iC;
        boolean z = true;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        boolean z2 = false;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i2) != 1073741824 && layoutParams.height == -2) {
            size = c(true);
            i2 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            z2 = true;
        }
        if (View.MeasureSpec.getMode(i) == 1073741824 || layoutParams.width != -2) {
            z = z2;
            iC = size2;
        } else {
            iC = c(true);
            i = View.MeasureSpec.makeMeasureSpec(iC, 1073741824);
        }
        if (!z) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(iC, size);
            measureChildren(i, i2);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("ProfilePictureView_superState"));
        this.f3989b = bundle.getString("ProfilePictureView_profileId");
        this.h = bundle.getInt("ProfilePictureView_presetSize");
        this.f3992e = bundle.getBoolean("ProfilePictureView_isCropped");
        this.f3991d = bundle.getInt("ProfilePictureView_width");
        this.f3990c = bundle.getInt("ProfilePictureView_height");
        setImageBitmap((Bitmap) bundle.getParcelable("ProfilePictureView_bitmap"));
        if (bundle.getBoolean("ProfilePictureView_refresh")) {
            a(true);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ProfilePictureView_superState", parcelableOnSaveInstanceState);
        bundle.putString("ProfilePictureView_profileId", this.f3989b);
        bundle.putInt("ProfilePictureView_presetSize", this.h);
        bundle.putBoolean("ProfilePictureView_isCropped", this.f3992e);
        bundle.putParcelable("ProfilePictureView_bitmap", this.f3993f);
        bundle.putInt("ProfilePictureView_width", this.f3991d);
        bundle.putInt("ProfilePictureView_height", this.f3990c);
        bundle.putBoolean("ProfilePictureView_refresh", this.i != null);
        return bundle;
    }

    public final void setCropped(boolean z) {
        this.f3992e = z;
        a(false);
    }

    public final void setDefaultProfilePicture(Bitmap bitmap) {
        this.k = bitmap;
    }

    public final void setOnErrorListener(a aVar) {
        this.j = aVar;
    }

    public final void setPresetSize(int i) {
        switch (i) {
            case -4:
            case -3:
            case -2:
            case -1:
                this.h = i;
                requestLayout();
                return;
            default:
                throw new IllegalArgumentException("Must use a predefined preset size");
        }
    }

    public final void setProfileId(String str) {
        boolean z = false;
        if (ad.a(this.f3989b) || !this.f3989b.equalsIgnoreCase(str)) {
            b();
            z = true;
        }
        this.f3989b = str;
        a(z);
    }
}
