package android.support.v4.app;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class u extends t implements android.support.v4.view.n {
    static final Interpolator A;
    static final Interpolator B;
    static final Interpolator C;
    static final Interpolator D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f674a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final boolean f675b;
    static Field r;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList<Runnable> f676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Runnable[] f677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<Fragment> f679f;
    ArrayList<Fragment> g;
    ArrayList<Integer> h;
    ArrayList<h> i;
    ArrayList<Fragment> j;
    ArrayList<h> k;
    ArrayList<Integer> l;
    ArrayList<t.a> m;
    s o;
    q p;
    Fragment q;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    int n = 0;
    Bundle x = null;
    SparseArray<Parcelable> y = null;
    Runnable z = new Runnable() { // from class: android.support.v4.app.u.1
        @Override // java.lang.Runnable
        public void run() {
            u.this.g();
        }
    };

    static class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Animation.AnimationListener f686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private View f688c;

        public a(View view, Animation animation) {
            this.f686a = null;
            this.f687b = false;
            this.f688c = null;
            if (view == null || animation == null) {
                return;
            }
            this.f688c = view;
        }

        public a(View view, Animation animation, Animation.AnimationListener animationListener) {
            this.f686a = null;
            this.f687b = false;
            this.f688c = null;
            if (view == null || animation == null) {
                return;
            }
            this.f686a = animationListener;
            this.f688c = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f688c != null && this.f687b) {
                this.f688c.post(new Runnable() { // from class: android.support.v4.app.u.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        android.support.v4.view.ah.a(a.this.f688c, 0, (Paint) null);
                    }
                });
            }
            if (this.f686a != null) {
                this.f686a.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            if (this.f686a != null) {
                this.f686a.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.f688c != null) {
                this.f687b = u.a(this.f688c, animation);
                if (this.f687b) {
                    this.f688c.post(new Runnable() { // from class: android.support.v4.app.u.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            android.support.v4.view.ah.a(a.this.f688c, 2, (Paint) null);
                        }
                    });
                }
            }
            if (this.f686a != null) {
                this.f686a.onAnimationStart(animation);
            }
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f691a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    static {
        f675b = Build.VERSION.SDK_INT >= 11;
        r = null;
        A = new DecelerateInterpolator(2.5f);
        B = new DecelerateInterpolator(1.5f);
        C = new AccelerateInterpolator(2.5f);
        D = new AccelerateInterpolator(1.5f);
    }

    u() {
    }

    static Animation a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(B);
        alphaAnimation.setDuration(220L);
        return alphaAnimation;
    }

    static Animation a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(A);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(B);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new android.support.v4.h.d("FragmentManager"));
        if (this.o != null) {
            try {
                this.o.a("  ", (FileDescriptor) null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            a("  ", (FileDescriptor) null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    static boolean a(View view, Animation animation) {
        return Build.VERSION.SDK_INT >= 19 && android.support.v4.view.ah.g(view) == 0 && android.support.v4.view.ah.y(view) && a(animation);
    }

    static boolean a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List<Animation> animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    public static int b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    private void b(View view, Animation animation) {
        Animation.AnimationListener animationListener;
        if (view == null || animation == null || !a(view, animation)) {
            return;
        }
        try {
            if (r == null) {
                r = Animation.class.getDeclaredField("mListener");
                r.setAccessible(true);
            }
            animationListener = (Animation.AnimationListener) r.get(animation);
        } catch (IllegalAccessException e2) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
            animationListener = null;
        } catch (NoSuchFieldException e3) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e3);
            animationListener = null;
        }
        animation.setAnimationListener(new a(view, animation, animationListener));
    }

    public static int c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void w() {
        if (this.t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.v);
        }
    }

    public int a(h hVar) {
        int size;
        synchronized (this) {
            if (this.l == null || this.l.size() <= 0) {
                if (this.k == null) {
                    this.k = new ArrayList<>();
                }
                size = this.k.size();
                if (f674a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + hVar);
                }
                this.k.add(hVar);
            } else {
                size = this.l.remove(this.l.size() - 1).intValue();
                if (f674a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + hVar);
                }
                this.k.set(size, hVar);
            }
        }
        return size;
    }

    @Override // android.support.v4.app.t
    public Fragment.SavedState a(Fragment fragment) {
        Bundle bundleG;
        if (fragment.mIndex < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0 || (bundleG = g(fragment)) == null) {
            return null;
        }
        return new Fragment.SavedState(bundleG);
    }

    public Fragment a(int i) {
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.g.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        if (this.f679f != null) {
            for (int size2 = this.f679f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f679f.get(size2);
                if (fragment2 != null && fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    @Override // android.support.v4.app.t
    public Fragment a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f679f.size()) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = this.f679f.get(i);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    @Override // android.support.v4.app.t
    public Fragment a(String str) {
        if (this.g != null && str != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.g.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (this.f679f != null && str != null) {
            for (int size2 = this.f679f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f679f.get(size2);
                if (fragment2 != null && str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    @Override // android.support.v4.app.t
    public w a() {
        return new h(this);
    }

    @Override // android.support.v4.view.n
    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f691a);
        String string = attributeValue == null ? typedArrayObtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string2 = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.o.i(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragmentA = resourceId != -1 ? a(resourceId) : null;
        if (fragmentA == null && string2 != null) {
            fragmentA = a(string2);
        }
        if (fragmentA == null && id != -1) {
            fragmentA = a(id);
        }
        if (f674a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + fragmentA);
        }
        if (fragmentA == null) {
            Fragment fragmentInstantiate = Fragment.instantiate(context, string);
            fragmentInstantiate.mFromLayout = true;
            fragmentInstantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentInstantiate.mContainerId = id;
            fragmentInstantiate.mTag = string2;
            fragmentInstantiate.mInLayout = true;
            fragmentInstantiate.mFragmentManager = this;
            fragmentInstantiate.mHost = this.o;
            fragmentInstantiate.onInflate(this.o.i(), attributeSet, fragmentInstantiate.mSavedFragmentState);
            a(fragmentInstantiate, true);
            fragment = fragmentInstantiate;
        } else {
            if (fragmentA.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
            }
            fragmentA.mInLayout = true;
            fragmentA.mHost = this.o;
            if (!fragmentA.mRetaining) {
                fragmentA.onInflate(this.o.i(), attributeSet, fragmentA.mSavedFragmentState);
            }
            fragment = fragmentA;
        }
        if (this.n >= 1 || !fragment.mFromLayout) {
            c(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }

    Animation a(Fragment fragment, int i, boolean z, int i2) {
        int iB;
        Animation animationLoadAnimation;
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(i, z, fragment.mNextAnim);
        if (animationOnCreateAnimation != null) {
            return animationOnCreateAnimation;
        }
        if (fragment.mNextAnim != 0 && (animationLoadAnimation = AnimationUtils.loadAnimation(this.o.i(), fragment.mNextAnim)) != null) {
            return animationLoadAnimation;
        }
        if (i != 0 && (iB = b(i, z)) >= 0) {
            switch (iB) {
                case 1:
                    return a(this.o.i(), 1.125f, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f);
                case 2:
                    return a(this.o.i(), 1.0f, 0.975f, 1.0f, BitmapDescriptorFactory.HUE_RED);
                case 3:
                    return a(this.o.i(), 0.975f, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f);
                case 4:
                    return a(this.o.i(), 1.0f, 1.075f, 1.0f, BitmapDescriptorFactory.HUE_RED);
                case 5:
                    return a(this.o.i(), BitmapDescriptorFactory.HUE_RED, 1.0f);
                case 6:
                    return a(this.o.i(), 1.0f, BitmapDescriptorFactory.HUE_RED);
                default:
                    if (i2 == 0 && this.o.e()) {
                        i2 = this.o.f();
                    }
                    return i2 == 0 ? null : null;
            }
        }
        return null;
    }

    @Override // android.support.v4.app.t
    public void a(final int i, final int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a(new Runnable() { // from class: android.support.v4.app.u.2
            @Override // java.lang.Runnable
            public void run() {
                u.this.a(u.this.o.j(), (String) null, i, i2);
            }
        }, false);
    }

    void a(int i, int i2, int i3, boolean z) {
        if (this.o == null && i != 0) {
            throw new IllegalStateException("No host");
        }
        if (z || this.n != i) {
            this.n = i;
            if (this.f679f != null) {
                int i4 = 0;
                boolean zA = false;
                while (i4 < this.f679f.size()) {
                    Fragment fragment = this.f679f.get(i4);
                    if (fragment != null) {
                        a(fragment, i, i2, i3, false);
                        if (fragment.mLoaderManager != null) {
                            zA |= fragment.mLoaderManager.a();
                        }
                    }
                    i4++;
                    zA = zA;
                }
                if (!zA) {
                    f();
                }
                if (this.s && this.o != null && this.n == 5) {
                    this.o.d();
                    this.s = false;
                }
            }
        }
    }

    public void a(int i, h hVar) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new ArrayList<>();
            }
            int size = this.k.size();
            if (i < size) {
                if (f674a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + hVar);
                }
                this.k.set(i, hVar);
            } else {
                while (size < i) {
                    this.k.add(null);
                    if (this.l == null) {
                        this.l = new ArrayList<>();
                    }
                    if (f674a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.l.add(Integer.valueOf(size));
                    size++;
                }
                if (f674a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + hVar);
                }
                this.k.add(hVar);
            }
        }
    }

    void a(int i, boolean z) {
        a(i, 0, 0, z);
    }

    public void a(Configuration configuration) {
        if (this.g == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                return;
            }
            Fragment fragment = this.g.get(i2);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
            i = i2 + 1;
        }
    }

    @Override // android.support.v4.app.t
    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    void a(Parcelable parcelable, List<Fragment> list) {
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f530a != null) {
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Fragment fragment = list.get(i);
                    if (f674a) {
                        Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                    }
                    FragmentState fragmentState = fragmentManagerState.f530a[fragment.mIndex];
                    fragmentState.k = fragment;
                    fragment.mSavedViewState = null;
                    fragment.mBackStackNesting = 0;
                    fragment.mInLayout = false;
                    fragment.mAdded = false;
                    fragment.mTarget = null;
                    if (fragmentState.j != null) {
                        fragmentState.j.setClassLoader(this.o.i().getClassLoader());
                        fragment.mSavedViewState = fragmentState.j.getSparseParcelableArray("android:view_state");
                        fragment.mSavedFragmentState = fragmentState.j;
                    }
                }
            }
            this.f679f = new ArrayList<>(fragmentManagerState.f530a.length);
            if (this.h != null) {
                this.h.clear();
            }
            for (int i2 = 0; i2 < fragmentManagerState.f530a.length; i2++) {
                FragmentState fragmentState2 = fragmentManagerState.f530a[i2];
                if (fragmentState2 != null) {
                    Fragment fragmentA = fragmentState2.a(this.o, this.q);
                    if (f674a) {
                        Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + fragmentA);
                    }
                    this.f679f.add(fragmentA);
                    fragmentState2.k = null;
                } else {
                    this.f679f.add(null);
                    if (this.h == null) {
                        this.h = new ArrayList<>();
                    }
                    if (f674a) {
                        Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                    }
                    this.h.add(Integer.valueOf(i2));
                }
            }
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    Fragment fragment2 = list.get(i3);
                    if (fragment2.mTargetIndex >= 0) {
                        if (fragment2.mTargetIndex < this.f679f.size()) {
                            fragment2.mTarget = this.f679f.get(fragment2.mTargetIndex);
                        } else {
                            Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.mTargetIndex);
                            fragment2.mTarget = null;
                        }
                    }
                }
            }
            if (fragmentManagerState.f531b != null) {
                this.g = new ArrayList<>(fragmentManagerState.f531b.length);
                for (int i4 = 0; i4 < fragmentManagerState.f531b.length; i4++) {
                    Fragment fragment3 = this.f679f.get(fragmentManagerState.f531b[i4]);
                    if (fragment3 == null) {
                        a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f531b[i4]));
                    }
                    fragment3.mAdded = true;
                    if (f674a) {
                        Log.v("FragmentManager", "restoreAllState: added #" + i4 + ": " + fragment3);
                    }
                    if (this.g.contains(fragment3)) {
                        throw new IllegalStateException("Already added!");
                    }
                    this.g.add(fragment3);
                }
            } else {
                this.g = null;
            }
            if (fragmentManagerState.f532c == null) {
                this.i = null;
                return;
            }
            this.i = new ArrayList<>(fragmentManagerState.f532c.length);
            for (int i5 = 0; i5 < fragmentManagerState.f532c.length; i5++) {
                h hVarA = fragmentManagerState.f532c[i5].a(this);
                if (f674a) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i5 + " (index " + hVarA.p + "): " + hVarA);
                    hVarA.a("  ", new PrintWriter(new android.support.v4.h.d("FragmentManager")), false);
                }
                this.i.add(hVarA);
                if (hVarA.p >= 0) {
                    a(hVarA.p, hVarA);
                }
            }
        }
    }

    public void a(Fragment fragment, int i, int i2) {
        if (f674a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            if (this.g != null) {
                this.g.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.s = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            a(fragment, z ? 0 : 1, i, i2, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:190:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0045 A[FALL_THROUGH, PHI: r12
      0x0045: PHI (r12v6 int) = 
      (r12v4 int)
      (r12v4 int)
      (r12v4 int)
      (r12v4 int)
      (r12v4 int)
      (r12v4 int)
      (r12v5 int)
      (r12v4 int)
      (r12v7 int)
      (r12v7 int)
     binds: [B:118:0x02ac, B:120:0x02b0, B:122:0x02b5, B:183:0x03f0, B:187:0x03fb, B:186:0x03f6, B:130:0x02ca, B:30:0x0042, B:108:0x0268, B:112:0x0286] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x0049  */
    void a(final Fragment fragment, int i, int i2, int i3, boolean z) {
        ViewGroup viewGroup;
        if ((!fragment.mAdded || fragment.mDetached) && i > 1) {
            i = 1;
        }
        if (fragment.mRemoving && i > fragment.mState) {
            i = fragment.mState;
        }
        if (fragment.mDeferStart && fragment.mState < 4 && i > 3) {
            i = 3;
        }
        if (fragment.mState < i) {
            if (fragment.mFromLayout && !fragment.mInLayout) {
                return;
            }
            if (fragment.mAnimatingAway != null) {
                fragment.mAnimatingAway = null;
                a(fragment, fragment.mStateAfterAnimating, 0, 0, true);
            }
            switch (fragment.mState) {
                case 0:
                    if (f674a) {
                        Log.v("FragmentManager", "moveto CREATED: " + fragment);
                    }
                    if (fragment.mSavedFragmentState != null) {
                        fragment.mSavedFragmentState.setClassLoader(this.o.i().getClassLoader());
                        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                        fragment.mTarget = a(fragment.mSavedFragmentState, "android:target_state");
                        if (fragment.mTarget != null) {
                            fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
                        }
                        fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
                        if (!fragment.mUserVisibleHint) {
                            fragment.mDeferStart = true;
                            if (i > 3) {
                                i = 3;
                            }
                        }
                    }
                    fragment.mHost = this.o;
                    fragment.mParentFragment = this.q;
                    fragment.mFragmentManager = this.q != null ? this.q.mChildFragmentManager : this.o.k();
                    fragment.mCalled = false;
                    fragment.onAttach(this.o.i());
                    if (!fragment.mCalled) {
                        throw new aw("Fragment " + fragment + " did not call through to super.onAttach()");
                    }
                    if (fragment.mParentFragment == null) {
                        this.o.b(fragment);
                    }
                    if (!fragment.mRetaining) {
                        fragment.performCreate(fragment.mSavedFragmentState);
                    }
                    fragment.mRetaining = false;
                    if (fragment.mFromLayout) {
                        fragment.mView = fragment.performCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
                        if (fragment.mView == null) {
                            fragment.mInnerView = null;
                        } else {
                            fragment.mInnerView = fragment.mView;
                            if (Build.VERSION.SDK_INT >= 11) {
                                android.support.v4.view.ah.b(fragment.mView, false);
                            } else {
                                fragment.mView = ad.a(fragment.mView);
                            }
                            if (fragment.mHidden) {
                                fragment.mView.setVisibility(8);
                            }
                            fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                        }
                    }
                    break;
                case 1:
                    if (i > 1) {
                        if (f674a) {
                            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
                        }
                        if (!fragment.mFromLayout) {
                            if (fragment.mContainerId != 0) {
                                viewGroup = (ViewGroup) this.p.a(fragment.mContainerId);
                                if (viewGroup == null && !fragment.mRestored) {
                                    a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + fragment.getResources().getResourceName(fragment.mContainerId) + ") for fragment " + fragment));
                                }
                            } else {
                                viewGroup = null;
                            }
                            fragment.mContainer = viewGroup;
                            fragment.mView = fragment.performCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), viewGroup, fragment.mSavedFragmentState);
                            if (fragment.mView != null) {
                                fragment.mInnerView = fragment.mView;
                                if (Build.VERSION.SDK_INT >= 11) {
                                    android.support.v4.view.ah.b(fragment.mView, false);
                                } else {
                                    fragment.mView = ad.a(fragment.mView);
                                }
                                if (viewGroup != null) {
                                    Animation animationA = a(fragment, i2, true, i3);
                                    if (animationA != null) {
                                        b(fragment.mView, animationA);
                                        fragment.mView.startAnimation(animationA);
                                    }
                                    viewGroup.addView(fragment.mView);
                                }
                                if (fragment.mHidden) {
                                    fragment.mView.setVisibility(8);
                                }
                                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                            } else {
                                fragment.mInnerView = null;
                            }
                        }
                        fragment.performActivityCreated(fragment.mSavedFragmentState);
                        if (fragment.mView != null) {
                            fragment.restoreViewState(fragment.mSavedFragmentState);
                        }
                        fragment.mSavedFragmentState = null;
                        break;
                    }
                case 2:
                case 3:
                    if (i > 3) {
                        if (f674a) {
                            Log.v("FragmentManager", "moveto STARTED: " + fragment);
                        }
                        fragment.performStart();
                        break;
                    }
                case 4:
                    if (i > 4) {
                        if (f674a) {
                            Log.v("FragmentManager", "moveto RESUMED: " + fragment);
                        }
                        fragment.performResume();
                        fragment.mSavedFragmentState = null;
                        fragment.mSavedViewState = null;
                        break;
                    }
                default:
                    if (fragment.mState != i) {
                        Log.w("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + i + " found " + fragment.mState);
                        fragment.mState = i;
                    }
            }
        } else if (fragment.mState > i) {
            switch (fragment.mState) {
                case 5:
                    if (i < 5) {
                        if (f674a) {
                            Log.v("FragmentManager", "movefrom RESUMED: " + fragment);
                        }
                        fragment.performPause();
                        break;
                    }
                case 4:
                    if (i < 4) {
                        if (f674a) {
                            Log.v("FragmentManager", "movefrom STARTED: " + fragment);
                        }
                        fragment.performStop();
                        break;
                    }
                case 3:
                    if (i < 3) {
                        if (f674a) {
                            Log.v("FragmentManager", "movefrom STOPPED: " + fragment);
                        }
                        fragment.performReallyStop();
                        break;
                    }
                case 2:
                    if (i < 2) {
                        if (f674a) {
                            Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                        }
                        if (fragment.mView != null && this.o.a(fragment) && fragment.mSavedViewState == null) {
                            f(fragment);
                        }
                        fragment.performDestroyView();
                        if (fragment.mView != null && fragment.mContainer != null) {
                            Animation animationA2 = (this.n <= 0 || this.u) ? null : a(fragment, i2, false, i3);
                            if (animationA2 != null) {
                                fragment.mAnimatingAway = fragment.mView;
                                fragment.mStateAfterAnimating = i;
                                animationA2.setAnimationListener(new a(fragment.mView, animationA2) { // from class: android.support.v4.app.u.3
                                    @Override // android.support.v4.app.u.a, android.view.animation.Animation.AnimationListener
                                    public void onAnimationEnd(Animation animation) {
                                        super.onAnimationEnd(animation);
                                        if (fragment.mAnimatingAway != null) {
                                            fragment.mAnimatingAway = null;
                                            u.this.a(fragment, fragment.mStateAfterAnimating, 0, 0, false);
                                        }
                                    }
                                });
                                fragment.mView.startAnimation(animationA2);
                            }
                            fragment.mContainer.removeView(fragment.mView);
                        }
                        fragment.mContainer = null;
                        fragment.mView = null;
                        fragment.mInnerView = null;
                        break;
                    }
                case 1:
                    if (i < 1) {
                        if (this.u && fragment.mAnimatingAway != null) {
                            View view = fragment.mAnimatingAway;
                            fragment.mAnimatingAway = null;
                            view.clearAnimation();
                        }
                        if (fragment.mAnimatingAway == null) {
                            if (f674a) {
                                Log.v("FragmentManager", "movefrom CREATED: " + fragment);
                            }
                            if (fragment.mRetaining) {
                                fragment.mState = 0;
                            } else {
                                fragment.performDestroy();
                            }
                            fragment.mCalled = false;
                            fragment.onDetach();
                            if (!fragment.mCalled) {
                                throw new aw("Fragment " + fragment + " did not call through to super.onDetach()");
                            }
                            if (!z) {
                                if (!fragment.mRetaining) {
                                    e(fragment);
                                } else {
                                    fragment.mHost = null;
                                    fragment.mParentFragment = null;
                                    fragment.mFragmentManager = null;
                                    fragment.mChildFragmentManager = null;
                                }
                            }
                        } else {
                            fragment.mStateAfterAnimating = i;
                            i = 1;
                        }
                        break;
                    }
                default:
                    if (fragment.mState != i) {
                        Log.w("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + i + " found " + fragment.mState);
                        fragment.mState = i;
                    }
            }
        }
        if (fragment.mState != i) {
            Log.w("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + i + " found " + fragment.mState);
            fragment.mState = i;
        }
    }

    public void a(Fragment fragment, boolean z) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        if (f674a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        d(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (this.g.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        this.g.add(fragment);
        fragment.mAdded = true;
        fragment.mRemoving = false;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            this.s = true;
        }
        if (z) {
            c(fragment);
        }
    }

    public void a(s sVar, q qVar, Fragment fragment) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = sVar;
        this.p = qVar;
        this.q = fragment;
    }

    public void a(Runnable runnable, boolean z) {
        if (!z) {
            w();
        }
        synchronized (this) {
            if (this.u || this.o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f676c == null) {
                this.f676c = new ArrayList<>();
            }
            this.f676c.add(runnable);
            if (this.f676c.size() == 1) {
                this.o.j().removeCallbacks(this.z);
                this.o.j().post(this.z);
            }
        }
    }

    @Override // android.support.v4.app.t
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        if (this.f679f != null && (size6 = this.f679f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size6; i++) {
                Fragment fragment = this.f679f.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        if (this.g != null && (size5 = this.g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                Fragment fragment2 = this.g.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        if (this.j != null && (size4 = this.j.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment3 = this.j.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        if (this.i != null && (size3 = this.i.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                h hVar = this.i.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(hVar.toString());
                hVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.k != null && (size2 = this.k.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj = (h) this.k.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.l != null && this.l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.l.toArray()));
            }
        }
        if (this.f676c != null && (size = this.f676c.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj2 = (Runnable) this.f676c.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.s);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
        if (this.h == null || this.h.size() <= 0) {
            return;
        }
        printWriter.print(str);
        printWriter.print("  mAvailIndices: ");
        printWriter.println(Arrays.toString(this.h.toArray()));
    }

    boolean a(Handler handler, String str, int i, int i2) {
        if (this.i == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.i.size() - 1;
            if (size < 0) {
                return false;
            }
            h hVarRemove = this.i.remove(size);
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            hVarRemove.a(sparseArray, sparseArray2);
            hVarRemove.a(true, (h.b) null, sparseArray, sparseArray2);
            h();
        } else {
            int i3 = -1;
            if (str != null || i >= 0) {
                int size2 = this.i.size() - 1;
                while (size2 >= 0) {
                    h hVar = this.i.get(size2);
                    if ((str != null && str.equals(hVar.c())) || (i >= 0 && i == hVar.p)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        h hVar2 = this.i.get(size2);
                        if ((str == null || !str.equals(hVar2.c())) && (i < 0 || i != hVar2.p)) {
                            break;
                        }
                        size2--;
                    }
                }
                i3 = size2;
            }
            if (i3 == this.i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int size3 = this.i.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.i.remove(size3));
            }
            int size4 = arrayList.size() - 1;
            SparseArray<Fragment> sparseArray3 = new SparseArray<>();
            SparseArray<Fragment> sparseArray4 = new SparseArray<>();
            for (int i4 = 0; i4 <= size4; i4++) {
                ((h) arrayList.get(i4)).a(sparseArray3, sparseArray4);
            }
            h.b bVarA = null;
            int i5 = 0;
            while (i5 <= size4) {
                if (f674a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i5));
                }
                i5++;
                bVarA = ((h) arrayList.get(i5)).a(i5 == size4, bVarA, sparseArray3, sparseArray4);
            }
            h();
        }
        return true;
    }

    public boolean a(Menu menu) {
        if (this.g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = this.g.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        ArrayList<Fragment> arrayList = null;
        if (this.g != null) {
            int i = 0;
            z = false;
            while (i < this.g.size()) {
                Fragment fragment = this.g.get(i);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                }
                i++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.j != null) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                Fragment fragment2 = this.j.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.j = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = this.g.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Fragment b(String str) {
        Fragment fragmentFindFragmentByWho;
        if (this.f679f != null && str != null) {
            for (int size = this.f679f.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f679f.get(size);
                if (fragment != null && (fragmentFindFragmentByWho = fragment.findFragmentByWho(str)) != null) {
                    return fragmentFindFragmentByWho;
                }
            }
        }
        return null;
    }

    public void b(int i) {
        synchronized (this) {
            this.k.set(i, null);
            if (this.l == null) {
                this.l = new ArrayList<>();
            }
            if (f674a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.l.add(Integer.valueOf(i));
        }
    }

    public void b(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.f678e) {
                this.w = true;
            } else {
                fragment.mDeferStart = false;
                a(fragment, this.n, 0, 0, false);
            }
        }
    }

    public void b(Fragment fragment, int i, int i2) {
        if (f674a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        if (fragment.mView != null) {
            Animation animationA = a(fragment, i, false, i2);
            if (animationA != null) {
                b(fragment.mView, animationA);
                fragment.mView.startAnimation(animationA);
            }
            fragment.mView.setVisibility(8);
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.s = true;
        }
        fragment.onHiddenChanged(true);
    }

    void b(h hVar) {
        if (this.i == null) {
            this.i = new ArrayList<>();
        }
        this.i.add(hVar);
        h();
    }

    public void b(Menu menu) {
        if (this.g == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                return;
            }
            Fragment fragment = this.g.get(i2);
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
            i = i2 + 1;
        }
    }

    @Override // android.support.v4.app.t
    public boolean b() {
        return g();
    }

    public boolean b(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = this.g.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void c(Fragment fragment) {
        a(fragment, this.n, 0, 0, false);
    }

    public void c(Fragment fragment, int i, int i2) {
        if (f674a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animation animationA = a(fragment, i, true, i2);
                if (animationA != null) {
                    b(fragment.mView, animationA);
                    fragment.mView.startAnimation(animationA);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.s = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    @Override // android.support.v4.app.t
    public boolean c() {
        w();
        b();
        return a(this.o.j(), (String) null, -1, 0);
    }

    @Override // android.support.v4.app.t
    public List<Fragment> d() {
        return this.f679f;
    }

    void d(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            return;
        }
        if (this.h == null || this.h.size() <= 0) {
            if (this.f679f == null) {
                this.f679f = new ArrayList<>();
            }
            fragment.setIndex(this.f679f.size(), this.q);
            this.f679f.add(fragment);
        } else {
            fragment.setIndex(this.h.remove(this.h.size() - 1).intValue(), this.q);
            this.f679f.set(fragment.mIndex, fragment);
        }
        if (f674a) {
            Log.v("FragmentManager", "Allocated fragment index " + fragment);
        }
    }

    public void d(Fragment fragment, int i, int i2) {
        if (f674a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (this.g != null) {
                if (f674a) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.g.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.s = true;
            }
            fragment.mAdded = false;
            a(fragment, 1, i, i2, false);
        }
    }

    void e(Fragment fragment) {
        if (fragment.mIndex < 0) {
            return;
        }
        if (f674a) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment);
        }
        this.f679f.set(fragment.mIndex, null);
        if (this.h == null) {
            this.h = new ArrayList<>();
        }
        this.h.add(Integer.valueOf(fragment.mIndex));
        this.o.b(fragment.mWho);
        fragment.initState();
    }

    public void e(Fragment fragment, int i, int i2) {
        if (f674a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            if (this.g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (f674a) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            this.g.add(fragment);
            fragment.mAdded = true;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.s = true;
            }
            a(fragment, this.n, i, i2, false);
        }
    }

    @Override // android.support.v4.app.t
    public boolean e() {
        return this.u;
    }

    void f() {
        if (this.f679f == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f679f.size()) {
                return;
            }
            Fragment fragment = this.f679f.get(i2);
            if (fragment != null) {
                b(fragment);
            }
            i = i2 + 1;
        }
    }

    void f(Fragment fragment) {
        if (fragment.mInnerView == null) {
            return;
        }
        if (this.y == null) {
            this.y = new SparseArray<>();
        } else {
            this.y.clear();
        }
        fragment.mInnerView.saveHierarchyState(this.y);
        if (this.y.size() > 0) {
            fragment.mSavedViewState = this.y;
            this.y = null;
        }
    }

    Bundle g(Fragment fragment) {
        Bundle bundle;
        if (this.x == null) {
            this.x = new Bundle();
        }
        fragment.performSaveInstanceState(this.x);
        if (this.x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.x;
            this.x = null;
        }
        if (fragment.mView != null) {
            f(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
    
        r6.f678e = true;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
    
        if (r1 >= r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008c, code lost:
    
        r6.f677d[r1].run();
        r6.f677d[r1] = null;
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g() {
        /*
            r6 = this;
            r0 = 1
            r2 = 0
            boolean r1 = r6.f678e
            if (r1 == 0) goto Le
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Recursive entry to executePendingTransactions"
            r0.<init>(r1)
            throw r0
        Le:
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.support.v4.app.s r3 = r6.o
            android.os.Handler r3 = r3.j()
            android.os.Looper r3 = r3.getLooper()
            if (r1 == r3) goto L26
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Must be called from main thread of process"
            r0.<init>(r1)
            throw r0
        L26:
            r1 = r2
        L27:
            monitor-enter(r6)
            java.util.ArrayList<java.lang.Runnable> r3 = r6.f676c     // Catch: java.lang.Throwable -> L9b
            if (r3 == 0) goto L34
            java.util.ArrayList<java.lang.Runnable> r3 = r6.f676c     // Catch: java.lang.Throwable -> L9b
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L9b
            if (r3 != 0) goto L5c
        L34:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L9b
            boolean r0 = r6.w
            if (r0 == 0) goto La9
            r3 = r2
            r4 = r2
        L3b:
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f679f
            int r0 = r0.size()
            if (r3 >= r0) goto La2
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f679f
            java.lang.Object r0 = r0.get(r3)
            android.support.v4.app.Fragment r0 = (android.support.v4.app.Fragment) r0
            if (r0 == 0) goto L58
            android.support.v4.app.aa r5 = r0.mLoaderManager
            if (r5 == 0) goto L58
            android.support.v4.app.aa r0 = r0.mLoaderManager
            boolean r0 = r0.a()
            r4 = r4 | r0
        L58:
            int r0 = r3 + 1
            r3 = r0
            goto L3b
        L5c:
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f676c     // Catch: java.lang.Throwable -> L9b
            int r3 = r1.size()     // Catch: java.lang.Throwable -> L9b
            java.lang.Runnable[] r1 = r6.f677d     // Catch: java.lang.Throwable -> L9b
            if (r1 == 0) goto L6b
            java.lang.Runnable[] r1 = r6.f677d     // Catch: java.lang.Throwable -> L9b
            int r1 = r1.length     // Catch: java.lang.Throwable -> L9b
            if (r1 >= r3) goto L6f
        L6b:
            java.lang.Runnable[] r1 = new java.lang.Runnable[r3]     // Catch: java.lang.Throwable -> L9b
            r6.f677d = r1     // Catch: java.lang.Throwable -> L9b
        L6f:
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f676c     // Catch: java.lang.Throwable -> L9b
            java.lang.Runnable[] r4 = r6.f677d     // Catch: java.lang.Throwable -> L9b
            r1.toArray(r4)     // Catch: java.lang.Throwable -> L9b
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f676c     // Catch: java.lang.Throwable -> L9b
            r1.clear()     // Catch: java.lang.Throwable -> L9b
            android.support.v4.app.s r1 = r6.o     // Catch: java.lang.Throwable -> L9b
            android.os.Handler r1 = r1.j()     // Catch: java.lang.Throwable -> L9b
            java.lang.Runnable r4 = r6.z     // Catch: java.lang.Throwable -> L9b
            r1.removeCallbacks(r4)     // Catch: java.lang.Throwable -> L9b
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L9b
            r6.f678e = r0
            r1 = r2
        L8a:
            if (r1 >= r3) goto L9e
            java.lang.Runnable[] r4 = r6.f677d
            r4 = r4[r1]
            r4.run()
            java.lang.Runnable[] r4 = r6.f677d
            r5 = 0
            r4[r1] = r5
            int r1 = r1 + 1
            goto L8a
        L9b:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L9b
            throw r0
        L9e:
            r6.f678e = r2
            r1 = r0
            goto L27
        La2:
            if (r4 != 0) goto La9
            r6.w = r2
            r6.f()
        La9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.u.g():boolean");
    }

    void h() {
        if (this.m == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.m.size()) {
                return;
            }
            this.m.get(i2).a();
            i = i2 + 1;
        }
    }

    ArrayList<Fragment> i() {
        ArrayList<Fragment> arrayList = null;
        if (this.f679f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f679f.size()) {
                    break;
                }
                Fragment fragment = this.f679f.get(i2);
                if (fragment != null && fragment.mRetainInstance) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                    fragment.mRetaining = true;
                    fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                    if (f674a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    Parcelable j() {
        int[] iArr;
        int size;
        int size2;
        boolean z;
        BackStackState[] backStackStateArr = null;
        g();
        if (f675b) {
            this.t = true;
        }
        if (this.f679f == null || this.f679f.size() <= 0) {
            return null;
        }
        int size3 = this.f679f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        int i = 0;
        boolean z2 = false;
        while (i < size3) {
            Fragment fragment = this.f679f.get(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState <= 0 || fragmentState.j != null) {
                    fragmentState.j = fragment.mSavedFragmentState;
                } else {
                    fragmentState.j = g(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                        }
                        if (fragmentState.j == null) {
                            fragmentState.j = new Bundle();
                        }
                        a(fragmentState.j, "android:target_state", fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.j.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                }
                if (f674a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.j);
                }
                z = true;
            } else {
                z = z2;
            }
            i++;
            z2 = z;
        }
        if (!z2) {
            if (!f674a) {
                return null;
            }
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
        if (this.g == null || (size2 = this.g.size()) <= 0) {
            iArr = null;
        } else {
            iArr = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                iArr[i2] = this.g.get(i2).mIndex;
                if (iArr[i2] < 0) {
                    a(new IllegalStateException("Failure saving state: active " + this.g.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (f674a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.g.get(i2));
                }
            }
        }
        if (this.i != null && (size = this.i.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new BackStackState(this.i.get(i3));
                if (f674a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.i.get(i3));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f530a = fragmentStateArr;
        fragmentManagerState.f531b = iArr;
        fragmentManagerState.f532c = backStackStateArr;
        return fragmentManagerState;
    }

    public void k() {
        this.t = false;
    }

    public void l() {
        this.t = false;
        a(1, false);
    }

    public void m() {
        this.t = false;
        a(2, false);
    }

    public void n() {
        this.t = false;
        a(4, false);
    }

    public void o() {
        this.t = false;
        a(5, false);
    }

    public void p() {
        a(4, false);
    }

    public void q() {
        this.t = true;
        a(3, false);
    }

    public void r() {
        a(2, false);
    }

    public void s() {
        a(1, false);
    }

    public void t() {
        this.u = true;
        g();
        a(0, false);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.q != null) {
            android.support.v4.h.c.a(this.q, sb);
        } else {
            android.support.v4.h.c.a(this.o, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public void u() {
        if (this.g == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                return;
            }
            Fragment fragment = this.g.get(i2);
            if (fragment != null) {
                fragment.performLowMemory();
            }
            i = i2 + 1;
        }
    }

    android.support.v4.view.n v() {
        return this;
    }
}
