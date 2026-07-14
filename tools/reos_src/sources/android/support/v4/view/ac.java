package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSetObservable f884a = new DataSetObservable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DataSetObserver f885b;

    public int a(Object obj) {
        return -1;
    }

    public Parcelable a() {
        return null;
    }

    public Object a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object a(ViewGroup viewGroup, int i) {
        return a((View) viewGroup, i);
    }

    public void a(DataSetObserver dataSetObserver) {
        this.f884a.registerObserver(dataSetObserver);
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void a(View view) {
    }

    public void a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void a(ViewGroup viewGroup) {
        a((View) viewGroup);
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        a((View) viewGroup, i, obj);
    }

    public abstract boolean a(View view, Object obj);

    public abstract int b();

    public CharSequence b(int i) {
        return null;
    }

    public void b(DataSetObserver dataSetObserver) {
        this.f884a.unregisterObserver(dataSetObserver);
    }

    public void b(View view) {
    }

    public void b(View view, int i, Object obj) {
    }

    public void b(ViewGroup viewGroup) {
        b((View) viewGroup);
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        b((View) viewGroup, i, obj);
    }

    public float c(int i) {
        return 1.0f;
    }

    void c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f885b = dataSetObserver;
        }
    }
}
