package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class v extends android.support.v4.view.ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t f692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private w f693b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<Fragment.SavedState> f694c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<Fragment> f695d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Fragment f696e = null;

    public v(t tVar) {
        this.f692a = tVar;
    }

    @Override // android.support.v4.view.ac
    public Parcelable a() {
        Bundle bundle = null;
        if (this.f694c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f694c.size()];
            this.f694c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Bundle bundle2 = bundle;
        for (int i = 0; i < this.f695d.size(); i++) {
            Fragment fragment = this.f695d.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                this.f692a.a(bundle2, "f" + i, fragment);
            }
        }
        return bundle2;
    }

    public abstract Fragment a(int i);

    @Override // android.support.v4.view.ac
    public Object a(ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f695d.size() > i && (fragment = this.f695d.get(i)) != null) {
            return fragment;
        }
        if (this.f693b == null) {
            this.f693b = this.f692a.a();
        }
        Fragment fragmentA = a(i);
        if (this.f694c.size() > i && (savedState = this.f694c.get(i)) != null) {
            fragmentA.setInitialSavedState(savedState);
        }
        while (this.f695d.size() <= i) {
            this.f695d.add(null);
        }
        fragmentA.setMenuVisibility(false);
        fragmentA.setUserVisibleHint(false);
        this.f695d.set(i, fragmentA);
        this.f693b.a(viewGroup.getId(), fragmentA);
        return fragmentA;
    }

    @Override // android.support.v4.view.ac
    public void a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f694c.clear();
            this.f695d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f694c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i = Integer.parseInt(str.substring(1));
                    Fragment fragmentA = this.f692a.a(bundle, str);
                    if (fragmentA != null) {
                        while (this.f695d.size() <= i) {
                            this.f695d.add(null);
                        }
                        fragmentA.setMenuVisibility(false);
                        this.f695d.set(i, fragmentA);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // android.support.v4.view.ac
    public void a(ViewGroup viewGroup) {
    }

    @Override // android.support.v4.view.ac
    public void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f693b == null) {
            this.f693b = this.f692a.a();
        }
        while (this.f694c.size() <= i) {
            this.f694c.add(null);
        }
        this.f694c.set(i, fragment.isAdded() ? this.f692a.a(fragment) : null);
        this.f695d.set(i, null);
        this.f693b.a(fragment);
    }

    @Override // android.support.v4.view.ac
    public boolean a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // android.support.v4.view.ac
    public void b(ViewGroup viewGroup) {
        if (this.f693b != null) {
            this.f693b.b();
            this.f693b = null;
            this.f692a.b();
        }
    }

    @Override // android.support.v4.view.ac
    public void b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f696e) {
            if (this.f696e != null) {
                this.f696e.setMenuVisibility(false);
                this.f696e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f696e = fragment;
        }
    }
}
