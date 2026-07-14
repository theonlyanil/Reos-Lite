package android.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.support.v7.widget.ap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements f.b, m, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1239a = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f1240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1241c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ap apVarA = ap.a(context, attributeSet, f1239a, i, 0);
        if (apVarA.f(0)) {
            setBackgroundDrawable(apVarA.a(0));
        }
        if (apVarA.f(1)) {
            setDivider(apVarA.a(1));
        }
        apVarA.a();
    }

    @Override // android.support.v7.view.menu.m
    public void a(f fVar) {
        this.f1240b = fVar;
    }

    @Override // android.support.v7.view.menu.f.b
    public boolean a(h hVar) {
        return this.f1240b.a(hVar, 0);
    }

    public int getWindowAnimations() {
        return this.f1241c;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((h) getAdapter().getItem(i));
    }
}
