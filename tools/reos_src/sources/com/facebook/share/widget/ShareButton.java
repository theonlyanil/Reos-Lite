package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.aa;
import com.facebook.b.f;
import com.facebook.b.j;
import com.facebook.share.model.ShareContent;

/* JADX INFO: loaded from: classes.dex */
public final class ShareButton extends b {
    public ShareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, "fb_share_button_create", "fb_share_button_did_tap");
    }

    @Override // com.facebook.g
    protected int getDefaultRequestCode() {
        return f.b.Share.a();
    }

    @Override // com.facebook.g
    protected int getDefaultStyleResource() {
        return aa.g.com_facebook_button_share;
    }

    @Override // com.facebook.share.widget.b
    protected j<ShareContent, com.facebook.share.a.C0072a> getDialog() {
        if (getFragment() != null) {
            return new c(getFragment(), getRequestCode());
        }
        return getNativeFragment() != null ? new c(getNativeFragment(), getRequestCode()) : new c(getActivity(), getRequestCode());
    }
}
