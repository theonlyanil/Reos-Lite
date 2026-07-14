package android.support.v4.app;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class h extends w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    a f632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    a f633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f635f;
    int g;
    int h;
    int i;
    int j;
    int k;
    boolean l;
    String n;
    boolean o;
    int q;
    CharSequence r;
    int s;
    CharSequence t;
    ArrayList<String> u;
    ArrayList<String> v;
    boolean m = true;
    int p = -1;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Fragment f652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f653e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f654f;
        int g;
        int h;
        ArrayList<Fragment> i;

        a() {
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public android.support.v4.h.a<String, String> f655a = new android.support.v4.h.a<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<View> f656b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public x.a f657c = new x.a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f658d;

        public b() {
        }
    }

    static {
        f630a = Build.VERSION.SDK_INT >= 21;
    }

    public h(u uVar) {
        this.f631b = uVar;
    }

    private b a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        b bVar = new b();
        bVar.f658d = new View(this.f631b.o.i());
        int i = 0;
        boolean z2 = false;
        while (i < sparseArray.size()) {
            boolean z3 = a(sparseArray.keyAt(i), bVar, z, sparseArray, sparseArray2) ? true : z2;
            i++;
            z2 = z3;
        }
        for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
            int iKeyAt = sparseArray2.keyAt(i2);
            if (sparseArray.get(iKeyAt) == null && a(iKeyAt, bVar, z, sparseArray, sparseArray2)) {
                z2 = true;
            }
        }
        if (z2) {
            return bVar;
        }
        return null;
    }

    private android.support.v4.h.a<String, View> a(b bVar, Fragment fragment, boolean z) {
        android.support.v4.h.a<String, View> aVar = new android.support.v4.h.a<>();
        if (this.u != null) {
            x.a((Map<String, View>) aVar, fragment.getView());
            if (z) {
                aVar.a((Collection<?>) this.v);
            } else {
                aVar = a(this.u, this.v, aVar);
            }
        }
        if (z) {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.a(this.v, aVar);
            }
            a(bVar, aVar, false);
        } else {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.a(this.v, aVar);
            }
            b(bVar, aVar, false);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.support.v4.h.a<String, View> a(b bVar, boolean z, Fragment fragment) {
        android.support.v4.h.a<String, View> aVarB = b(bVar, fragment, z);
        if (z) {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.a(this.v, aVarB);
            }
            a(bVar, aVarB, true);
        } else {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.a(this.v, aVarB);
            }
            b(bVar, aVarB, true);
        }
        return aVarB;
    }

    private static android.support.v4.h.a<String, View> a(ArrayList<String> arrayList, ArrayList<String> arrayList2, android.support.v4.h.a<String, View> aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        android.support.v4.h.a<String, View> aVar2 = new android.support.v4.h.a<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = aVar.get(arrayList.get(i));
            if (view != null) {
                aVar2.put(arrayList2.get(i), view);
            }
        }
        return aVar2;
    }

    private static Object a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return x.b(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition());
    }

    private static Object a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return x.a(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object a(Object obj, Fragment fragment, ArrayList<View> arrayList, android.support.v4.h.a<String, View> aVar, View view) {
        return obj != null ? x.a(obj, fragment.getView(), arrayList, aVar, view) : obj;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        fragment.mFragmentManager = this.f631b;
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        a aVar = new a();
        aVar.f651c = i2;
        aVar.f652d = fragment;
        a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, int i, Object obj) {
        if (this.f631b.g != null) {
            for (int i2 = 0; i2 < this.f631b.g.size(); i2++) {
                Fragment fragment = this.f631b.g.get(i2);
                if (fragment.mView != null && fragment.mContainer != null && fragment.mContainerId == i) {
                    if (!fragment.mHidden) {
                        x.a(obj, fragment.mView, false);
                        bVar.f656b.remove(fragment.mView);
                    } else if (!bVar.f656b.contains(fragment.mView)) {
                        x.a(obj, fragment.mView, true);
                        bVar.f656b.add(fragment.mView);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Fragment fragment, Fragment fragment2, boolean z, android.support.v4.h.a<String, View> aVar) {
        av avVar = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
        if (avVar != null) {
            avVar.b(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
        }
    }

    private void a(b bVar, android.support.v4.h.a<String, View> aVar, boolean z) {
        int size = this.v == null ? 0 : this.v.size();
        for (int i = 0; i < size; i++) {
            String str = this.u.get(i);
            View view = aVar.get(this.v.get(i));
            if (view != null) {
                String strA = x.a(view);
                if (z) {
                    a(bVar.f655a, str, strA);
                } else {
                    a(bVar.f655a, strA, str);
                }
            }
        }
    }

    private void a(final b bVar, final View view, final Object obj, final Fragment fragment, final Fragment fragment2, final boolean z, final ArrayList<View> arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.v4.app.h.2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                if (obj == null) {
                    return true;
                }
                x.a(obj, (ArrayList<View>) arrayList);
                arrayList.clear();
                android.support.v4.h.a aVarA = h.this.a(bVar, z, fragment);
                x.a(obj, bVar.f658d, aVarA, (ArrayList<View>) arrayList);
                h.this.a((android.support.v4.h.a<String, View>) aVarA, bVar);
                h.this.a(bVar, fragment, fragment2, z, (android.support.v4.h.a<String, View>) aVarA);
                return true;
            }
        });
    }

    private static void a(b bVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            a(bVar.f655a, arrayList.get(i2), arrayList2.get(i2));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.support.v4.h.a<String, View> aVar, b bVar) {
        View view;
        if (this.v == null || aVar.isEmpty() || (view = aVar.get(this.v.get(0))) == null) {
            return;
        }
        bVar.f657c.f712a = view;
    }

    private static void a(android.support.v4.h.a<String, String> aVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        for (int i = 0; i < aVar.size(); i++) {
            if (str.equals(aVar.c(i))) {
                aVar.a(i, str2);
                return;
            }
        }
        aVar.put(str, str2);
    }

    private static void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        int i;
        if (fragment == null || (i = fragment.mContainerId) == 0 || fragment.isHidden()) {
            return;
        }
        if (fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
            sparseArray.put(i, fragment);
        }
        if (sparseArray2.get(i) == fragment) {
            sparseArray2.remove(i);
        }
    }

    private void a(final View view, final b bVar, final int i, final Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.v4.app.h.3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                h.this.a(bVar, i, obj);
                return true;
            }
        });
    }

    private boolean a(int i, b bVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Object obj;
        ViewGroup viewGroup = (ViewGroup) this.f631b.p.a(i);
        if (viewGroup == null) {
            return false;
        }
        final Fragment fragment = sparseArray2.get(i);
        Fragment fragment2 = sparseArray.get(i);
        Object objA = a(fragment, z);
        Object objA2 = a(fragment, fragment2, z);
        Object objB = b(fragment2, z);
        android.support.v4.h.a<String, View> aVarA = null;
        ArrayList<View> arrayList = new ArrayList<>();
        if (objA2 != null) {
            aVarA = a(bVar, fragment2, z);
            if (aVarA.isEmpty()) {
                aVarA = null;
                obj = null;
            } else {
                av avVar = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
                if (avVar != null) {
                    avVar.a(new ArrayList(aVarA.keySet()), new ArrayList(aVarA.values()), (List<View>) null);
                }
                a(bVar, viewGroup, objA2, fragment, fragment2, z, arrayList);
                obj = objA2;
            }
        } else {
            obj = objA2;
        }
        if (objA == null && obj == null && objB == null) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Object objA3 = a(objB, fragment2, (ArrayList<View>) arrayList2, aVarA, bVar.f658d);
        if (this.v != null && aVarA != null) {
            View view = aVarA.get(this.v.get(0));
            if (view != null) {
                if (objA3 != null) {
                    x.a(objA3, view);
                }
                if (obj != null) {
                    x.a(obj, view);
                }
            }
        }
        x.b bVar2 = new x.b() { // from class: android.support.v4.app.h.1
            @Override // android.support.v4.app.x.b
            public View a() {
                return fragment.getView();
            }
        };
        ArrayList arrayList3 = new ArrayList();
        android.support.v4.h.a aVar = new android.support.v4.h.a();
        boolean allowReturnTransitionOverlap = true;
        if (fragment != null) {
            allowReturnTransitionOverlap = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        Object objA4 = x.a(objA, objA3, obj, allowReturnTransitionOverlap);
        if (objA4 != null) {
            x.a(objA, obj, viewGroup, bVar2, bVar.f658d, bVar.f657c, bVar.f655a, (ArrayList<View>) arrayList3, aVarA, aVar, arrayList);
            a(viewGroup, bVar, i, objA4);
            x.a(objA4, bVar.f658d, true);
            a(bVar, i, objA4);
            x.a(viewGroup, objA4);
            x.a(viewGroup, bVar.f658d, objA, (ArrayList<View>) arrayList3, objA3, (ArrayList<View>) arrayList2, obj, arrayList, objA4, bVar.f656b, aVar);
        }
        return objA4 != null;
    }

    private android.support.v4.h.a<String, View> b(b bVar, Fragment fragment, boolean z) {
        android.support.v4.h.a<String, View> aVar = new android.support.v4.h.a<>();
        View view = fragment.getView();
        if (view == null || this.u == null) {
            return aVar;
        }
        x.a((Map<String, View>) aVar, view);
        if (z) {
            return a(this.u, this.v, aVar);
        }
        aVar.a((Collection<?>) this.v);
        return aVar;
    }

    private static Object b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return x.a(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private void b(b bVar, android.support.v4.h.a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String strB = aVar.b(i);
            String strA = x.a(aVar.c(i));
            if (z) {
                a(bVar.f655a, strB, strA);
            } else {
                a(bVar.f655a, strA, strB);
            }
        }
    }

    private void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f631b.p.a()) {
            for (a aVar = this.f632c; aVar != null; aVar = aVar.f649a) {
                switch (aVar.f651c) {
                    case 1:
                        b(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 2:
                        Fragment fragment = aVar.f652d;
                        if (this.f631b.g != null) {
                            int i = 0;
                            Fragment fragment2 = fragment;
                            while (true) {
                                int i2 = i;
                                if (i2 < this.f631b.g.size()) {
                                    Fragment fragment3 = this.f631b.g.get(i2);
                                    if (fragment2 == null || fragment3.mContainerId == fragment2.mContainerId) {
                                        if (fragment3 == fragment2) {
                                            fragment2 = null;
                                            sparseArray2.remove(fragment3.mContainerId);
                                        } else {
                                            a(sparseArray, sparseArray2, fragment3);
                                        }
                                    }
                                    i = i2 + 1;
                                }
                            }
                        }
                        b(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 3:
                        a(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 4:
                        a(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 5:
                        b(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 6:
                        a(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 7:
                        b(sparseArray, sparseArray2, aVar.f652d);
                        break;
                }
            }
        }
    }

    private void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0) {
                if (!fragment.isAdded()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.mState >= 1 || this.f631b.n < 1) {
                return;
            }
            this.f631b.d(fragment);
            this.f631b.a(fragment, 1, 0, 0, false);
        }
    }

    @Override // android.support.v4.app.w
    public int a() {
        return a(false);
    }

    int a(boolean z) {
        if (this.o) {
            throw new IllegalStateException("commit already called");
        }
        if (u.f674a) {
            Log.v("FragmentManager", "Commit: " + this);
            a("  ", (FileDescriptor) null, new PrintWriter(new android.support.v4.h.d("FragmentManager")), (String[]) null);
        }
        this.o = true;
        if (this.l) {
            this.p = this.f631b.a(this);
        } else {
            this.p = -1;
        }
        this.f631b.a(this, z);
        return this.p;
    }

    public b a(boolean z, b bVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (u.f674a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            a("  ", (FileDescriptor) null, new PrintWriter(new android.support.v4.h.d("FragmentManager")), (String[]) null);
        }
        if (f630a && this.f631b.n >= 1) {
            if (bVar == null) {
                if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                    bVar = a(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                a(bVar, this.v, this.u);
            }
        }
        a(-1);
        int i = bVar != null ? 0 : this.k;
        int i2 = bVar != null ? 0 : this.j;
        for (a aVar = this.f633d; aVar != null; aVar = aVar.f650b) {
            int i3 = bVar != null ? 0 : aVar.g;
            int i4 = bVar != null ? 0 : aVar.h;
            switch (aVar.f651c) {
                case 1:
                    Fragment fragment = aVar.f652d;
                    fragment.mNextAnim = i4;
                    this.f631b.a(fragment, u.c(i2), i);
                    break;
                case 2:
                    Fragment fragment2 = aVar.f652d;
                    if (fragment2 != null) {
                        fragment2.mNextAnim = i4;
                        this.f631b.a(fragment2, u.c(i2), i);
                    }
                    if (aVar.i != null) {
                        for (int i5 = 0; i5 < aVar.i.size(); i5++) {
                            Fragment fragment3 = aVar.i.get(i5);
                            fragment3.mNextAnim = i3;
                            this.f631b.a(fragment3, false);
                        }
                    }
                    break;
                case 3:
                    Fragment fragment4 = aVar.f652d;
                    fragment4.mNextAnim = i3;
                    this.f631b.a(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = aVar.f652d;
                    fragment5.mNextAnim = i3;
                    this.f631b.c(fragment5, u.c(i2), i);
                    break;
                case 5:
                    Fragment fragment6 = aVar.f652d;
                    fragment6.mNextAnim = i4;
                    this.f631b.b(fragment6, u.c(i2), i);
                    break;
                case 6:
                    Fragment fragment7 = aVar.f652d;
                    fragment7.mNextAnim = i3;
                    this.f631b.e(fragment7, u.c(i2), i);
                    break;
                case 7:
                    Fragment fragment8 = aVar.f652d;
                    fragment8.mNextAnim = i3;
                    this.f631b.d(fragment8, u.c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f651c);
            }
        }
        if (z) {
            this.f631b.a(this.f631b.n, u.c(i2), i, true);
            bVar = null;
        }
        if (this.p >= 0) {
            this.f631b.b(this.p);
            this.p = -1;
        }
        return bVar;
    }

    @Override // android.support.v4.app.w
    public w a(int i, Fragment fragment) {
        a(i, fragment, (String) null, 1);
        return this;
    }

    @Override // android.support.v4.app.w
    public w a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    @Override // android.support.v4.app.w
    public w a(Fragment fragment) {
        a aVar = new a();
        aVar.f651c = 3;
        aVar.f652d = fragment;
        a(aVar);
        return this;
    }

    @Override // android.support.v4.app.w
    public w a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    void a(int i) {
        if (this.l) {
            if (u.f674a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (a aVar = this.f632c; aVar != null; aVar = aVar.f649a) {
                if (aVar.f652d != null) {
                    aVar.f652d.mBackStackNesting += i;
                    if (u.f674a) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f652d + " to " + aVar.f652d.mBackStackNesting);
                    }
                }
                if (aVar.i != null) {
                    for (int size = aVar.i.size() - 1; size >= 0; size--) {
                        Fragment fragment = aVar.i.get(size);
                        fragment.mBackStackNesting += i;
                        if (u.f674a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    void a(a aVar) {
        if (this.f632c == null) {
            this.f633d = aVar;
            this.f632c = aVar;
        } else {
            aVar.f650b = this.f633d;
            this.f633d.f649a = aVar;
            this.f633d = aVar;
        }
        aVar.f653e = this.f635f;
        aVar.f654f = this.g;
        aVar.g = this.h;
        aVar.h = this.i;
        this.f634e++;
    }

    public void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f631b.p.a()) {
            for (a aVar = this.f633d; aVar != null; aVar = aVar.f650b) {
                switch (aVar.f651c) {
                    case 1:
                        a(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 2:
                        if (aVar.i != null) {
                            for (int size = aVar.i.size() - 1; size >= 0; size--) {
                                b(sparseArray, sparseArray2, aVar.i.get(size));
                            }
                        }
                        a(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 3:
                        b(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 4:
                        b(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 5:
                        a(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 6:
                        b(sparseArray, sparseArray2, aVar.f652d);
                        break;
                    case 7:
                        a(sparseArray, sparseArray2, aVar.f652d);
                        break;
                }
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.n);
            printWriter.print(" mIndex=");
            printWriter.print(this.p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.o);
            if (this.j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.k));
            }
            if (this.f635f != 0 || this.g != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f635f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.h != 0 || this.i != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.i));
            }
            if (this.q != 0 || this.r != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.r);
            }
            if (this.s != 0 || this.t != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.t);
            }
        }
        if (this.f632c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int i = 0;
            a aVar = this.f632c;
            while (aVar != null) {
                switch (aVar.f651c) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f651c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f652d);
                if (z) {
                    if (aVar.f653e != 0 || aVar.f654f != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f653e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f654f));
                    }
                    if (aVar.g != 0 || aVar.h != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.h));
                    }
                }
                if (aVar.i != null && aVar.i.size() > 0) {
                    for (int i2 = 0; i2 < aVar.i.size(); i2++) {
                        printWriter.print(str3);
                        if (aVar.i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str3);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(aVar.i.get(i2));
                    }
                }
                aVar = aVar.f649a;
                i++;
            }
        }
    }

    @Override // android.support.v4.app.w
    public int b() {
        return a(true);
    }

    public String c() {
        return this.n;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVarA;
        Fragment fragment;
        if (u.f674a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (this.l && this.p < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        a(1);
        if (!f630a || this.f631b.n < 1) {
            bVarA = null;
        } else {
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            b(sparseArray, sparseArray2);
            bVarA = a(sparseArray, sparseArray2, false);
        }
        int i = bVarA != null ? 0 : this.k;
        int i2 = bVarA != null ? 0 : this.j;
        for (a aVar = this.f632c; aVar != null; aVar = aVar.f649a) {
            int i3 = bVarA != null ? 0 : aVar.f653e;
            int i4 = bVarA != null ? 0 : aVar.f654f;
            switch (aVar.f651c) {
                case 1:
                    Fragment fragment2 = aVar.f652d;
                    fragment2.mNextAnim = i3;
                    this.f631b.a(fragment2, false);
                    break;
                case 2:
                    Fragment fragment3 = aVar.f652d;
                    int i5 = fragment3.mContainerId;
                    if (this.f631b.g != null) {
                        int size = this.f631b.g.size() - 1;
                        while (size >= 0) {
                            Fragment fragment4 = this.f631b.g.get(size);
                            if (u.f674a) {
                                Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment3 + " old=" + fragment4);
                            }
                            if (fragment4.mContainerId != i5) {
                                fragment = fragment3;
                            } else if (fragment4 == fragment3) {
                                fragment = null;
                                aVar.f652d = null;
                            } else {
                                if (aVar.i == null) {
                                    aVar.i = new ArrayList<>();
                                }
                                aVar.i.add(fragment4);
                                fragment4.mNextAnim = i4;
                                if (this.l) {
                                    fragment4.mBackStackNesting++;
                                    if (u.f674a) {
                                        Log.v("FragmentManager", "Bump nesting of " + fragment4 + " to " + fragment4.mBackStackNesting);
                                    }
                                }
                                this.f631b.a(fragment4, i2, i);
                                fragment = fragment3;
                            }
                            size--;
                            fragment3 = fragment;
                        }
                    }
                    if (fragment3 != null) {
                        fragment3.mNextAnim = i3;
                        this.f631b.a(fragment3, false);
                    }
                    break;
                case 3:
                    Fragment fragment5 = aVar.f652d;
                    fragment5.mNextAnim = i4;
                    this.f631b.a(fragment5, i2, i);
                    break;
                case 4:
                    Fragment fragment6 = aVar.f652d;
                    fragment6.mNextAnim = i4;
                    this.f631b.b(fragment6, i2, i);
                    break;
                case 5:
                    Fragment fragment7 = aVar.f652d;
                    fragment7.mNextAnim = i3;
                    this.f631b.c(fragment7, i2, i);
                    break;
                case 6:
                    Fragment fragment8 = aVar.f652d;
                    fragment8.mNextAnim = i4;
                    this.f631b.d(fragment8, i2, i);
                    break;
                case 7:
                    Fragment fragment9 = aVar.f652d;
                    fragment9.mNextAnim = i3;
                    this.f631b.e(fragment9, i2, i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f651c);
            }
        }
        this.f631b.a(this.f631b.n, i2, i, true);
        if (this.l) {
            this.f631b.b(this);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.p >= 0) {
            sb.append(" #");
            sb.append(this.p);
        }
        if (this.n != null) {
            sb.append(" ");
            sb.append(this.n);
        }
        sb.append("}");
        return sb.toString();
    }
}
