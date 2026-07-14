package com.cube26.iota.smartlite.util;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButtonBehavior extends CoordinatorLayout.b<FloatingActionButton> {
    public FloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        return view instanceof Snackbar.SnackbarLayout;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean c(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        floatingActionButton.setTranslationY(Math.min(BitmapDescriptorFactory.HUE_RED, view.getTranslationY() - view.getHeight()));
        return true;
    }
}
