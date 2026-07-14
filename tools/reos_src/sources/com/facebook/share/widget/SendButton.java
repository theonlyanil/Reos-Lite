package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.aa;
import com.facebook.b.f;
import com.facebook.b.j;
import com.facebook.share.model.ShareContent;

/* JADX INFO: loaded from: classes.dex */
public final class SendButton extends b {
    public SendButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, "fb_send_button_create", "fb_send_button_did_tap");
    }

    @Override // com.facebook.g
    protected int getDefaultRequestCode() {
        return f.b.Message.a();
    }

    @Override // com.facebook.g
    protected int getDefaultStyleResource() {
        return aa.g.com_facebook_button_send;
    }

    @Override // com.facebook.share.widget.b
    protected j<ShareContent, com.facebook.share.a.C0072a> getDialog() {
        if (getFragment() != null) {
            return new a(getFragment(), getRequestCode());
        }
        return getNativeFragment() != null ? new a(getNativeFragment(), getRequestCode()) : new a(getActivity(), getRequestCode());
    }
}
