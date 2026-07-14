package android.support.v4.app;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    public interface a<D> {
        android.support.v4.b.i<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(android.support.v4.b.i<D> iVar, D d2);

        void onLoaderReset(android.support.v4.b.i<D> iVar);
    }

    public abstract <D> android.support.v4.b.i<D> a(int i, Bundle bundle, a<D> aVar);

    public boolean a() {
        return false;
    }
}
