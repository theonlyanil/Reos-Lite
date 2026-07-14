package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.b.j;
import com.facebook.g;
import com.facebook.m;
import com.facebook.share.model.ShareContent;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ShareContent f4131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4133c;

    protected b(Context context, AttributeSet attributeSet, int i, String str, String str2) {
        super(context, attributeSet, i, 0, str, str2);
        this.f4132b = 0;
        this.f4133c = false;
        this.f4132b = isInEditMode() ? 0 : getDefaultRequestCode();
        a(false);
    }

    private void a(boolean z) {
        setEnabled(z);
        this.f4133c = false;
    }

    @Override // com.facebook.g
    protected void a(Context context, AttributeSet attributeSet, int i, int i2) {
        super.a(context, attributeSet, i, i2);
        setInternalOnClickListener(getShareOnClickListener());
    }

    protected boolean a() {
        return getDialog().a(getShareContent());
    }

    protected abstract j<ShareContent, com.facebook.share.a.C0072a> getDialog();

    @Override // com.facebook.g
    public int getRequestCode() {
        return this.f4132b;
    }

    public ShareContent getShareContent() {
        return this.f4131a;
    }

    protected View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener() { // from class: com.facebook.share.widget.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.a(view);
                b.this.getDialog().b(b.this.getShareContent());
            }
        };
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f4133c = true;
    }

    protected void setRequestCode(int i) {
        if (m.b(i)) {
            throw new IllegalArgumentException("Request code " + i + " cannot be within the range reserved by the Facebook SDK.");
        }
        this.f4132b = i;
    }

    public void setShareContent(ShareContent shareContent) {
        this.f4131a = shareContent;
        if (this.f4133c) {
            return;
        }
        a(a());
    }
}
