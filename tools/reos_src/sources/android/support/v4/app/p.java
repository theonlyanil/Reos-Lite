package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p extends k implements android.support.v4.app.a.InterfaceC0010a, c.a {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    android.support.v4.e.a.a mMediaController;
    int mNextCandidateRequestIndex;
    boolean mOptionsMenuInvalidated;
    android.support.v4.h.j<String> mPendingFragmentActivityResults;
    boolean mReallyStopped;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStartedActivityFromFragment;
    boolean mStopped;
    final Handler mHandler = new Handler() { // from class: android.support.v4.app.p.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (p.this.mStopped) {
                        p.this.doReallyStop(false);
                    }
                    break;
                case 2:
                    p.this.onResumeFragments();
                    p.this.mFragments.o();
                    break;
                default:
                    super.handleMessage(message);
                    break;
            }
        }
    };
    final r mFragments = r.a(new a());

    class a extends s<p> {
        public a() {
            super(p.this);
        }

        @Override // android.support.v4.app.s, android.support.v4.app.q
        public View a(int i) {
            return p.this.findViewById(i);
        }

        @Override // android.support.v4.app.s
        public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            p.this.startActivityFromFragment(fragment, intent, i, bundle);
        }

        @Override // android.support.v4.app.s
        public void a(Fragment fragment, String[] strArr, int i) {
            p.this.requestPermissionsFromFragment(fragment, strArr, i);
        }

        @Override // android.support.v4.app.s
        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            p.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // android.support.v4.app.s, android.support.v4.app.q
        public boolean a() {
            Window window = p.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // android.support.v4.app.s
        public boolean a(Fragment fragment) {
            return !p.this.isFinishing();
        }

        @Override // android.support.v4.app.s
        public boolean a(String str) {
            return android.support.v4.app.a.a((Activity) p.this, str);
        }

        @Override // android.support.v4.app.s
        public LayoutInflater b() {
            return p.this.getLayoutInflater().cloneInContext(p.this);
        }

        @Override // android.support.v4.app.s
        public void b(Fragment fragment) {
            p.this.onAttachFragment(fragment);
        }

        @Override // android.support.v4.app.s
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public p g() {
            return p.this;
        }

        @Override // android.support.v4.app.s
        public void d() {
            p.this.supportInvalidateOptionsMenu();
        }

        @Override // android.support.v4.app.s
        public boolean e() {
            return p.this.getWindow() != null;
        }

        @Override // android.support.v4.app.s
        public int f() {
            Window window = p.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<Fragment> f665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        android.support.v4.h.i<String, z> f666c;

        b() {
        }
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.b() >= MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.mPendingFragmentActivityResults.f(this.mNextCandidateRequestIndex) >= 0) {
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        }
        int i = this.mNextCandidateRequestIndex;
        this.mPendingFragmentActivityResults.b(i, fragment.mWho);
        this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        return i;
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(viewToString(view));
        if (!(view instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) view).getChildCount()) <= 0) {
            return;
        }
        String str2 = str + "  ";
        for (int i = 0; i < childCount; i++) {
            dumpViewHierarchy(str2, printWriter, viewGroup.getChildAt(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            android.support.v4.app.a.a(this, strArr, i);
        } else {
            if (((-65536) & i) != 0) {
                throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            }
            try {
                this.mRequestedPermissionsFromFragment = true;
                android.support.v4.app.a.a(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & i));
            } finally {
                this.mRequestedPermissionsFromFragment = false;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x00ed. Please report as an issue. */
    private static String viewToString(View view) {
        String resourcePackageName;
        StringBuilder sb = new StringBuilder(128);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view)));
        sb.append(' ');
        switch (view.getVisibility()) {
            case 0:
                sb.append('V');
                break;
            case 4:
                sb.append('I');
                break;
            case 8:
                sb.append('G');
                break;
            default:
                sb.append('.');
                break;
        }
        sb.append(view.isFocusable() ? 'F' : '.');
        sb.append(view.isEnabled() ? 'E' : '.');
        sb.append(view.willNotDraw() ? '.' : 'D');
        sb.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        sb.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        sb.append(view.isClickable() ? 'C' : '.');
        sb.append(view.isLongClickable() ? 'L' : '.');
        sb.append(' ');
        sb.append(view.isFocused() ? 'F' : '.');
        sb.append(view.isSelected() ? 'S' : '.');
        sb.append(view.isPressed() ? 'P' : '.');
        sb.append(' ');
        sb.append(view.getLeft());
        sb.append(',');
        sb.append(view.getTop());
        sb.append('-');
        sb.append(view.getRight());
        sb.append(',');
        sb.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            sb.append(" #");
            sb.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (id != 0 && resources != null) {
                switch ((-16777216) & id) {
                    case 16777216:
                        resourcePackageName = "android";
                        String resourceTypeName = resources.getResourceTypeName(id);
                        String resourceEntryName = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(resourcePackageName);
                        sb.append(":");
                        sb.append(resourceTypeName);
                        sb.append("/");
                        sb.append(resourceEntryName);
                        break;
                    case 2130706432:
                        resourcePackageName = "app";
                        String resourceTypeName2 = resources.getResourceTypeName(id);
                        String resourceEntryName2 = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(resourcePackageName);
                        sb.append(":");
                        sb.append(resourceTypeName2);
                        sb.append("/");
                        sb.append(resourceEntryName2);
                        break;
                    default:
                        try {
                            resourcePackageName = resources.getResourcePackageName(id);
                            String resourceTypeName3 = resources.getResourceTypeName(id);
                            String resourceEntryName3 = resources.getResourceEntryName(id);
                            sb.append(" ");
                            sb.append(resourcePackageName);
                            sb.append(":");
                            sb.append(resourceTypeName3);
                            sb.append("/");
                            sb.append(resourceEntryName3);
                        } catch (Resources.NotFoundException e2) {
                        }
                        break;
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // android.support.v4.app.i
    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.a(view, str, context, attributeSet);
    }

    void doReallyStop(boolean z) {
        if (this.mReallyStopped) {
            return;
        }
        this.mReallyStopped = true;
        this.mRetaining = z;
        this.mHandler.removeMessages(1);
        onReallyStop();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 11) {
        }
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        this.mFragments.a(str2, fileDescriptor, printWriter, strArr);
        this.mFragments.a().a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        dumpViewHierarchy(str + "  ", printWriter, getWindow().getDecorView());
    }

    public Object getLastCustomNonConfigurationInstance() {
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            return bVar.f664a;
        }
        return null;
    }

    public t getSupportFragmentManager() {
        return this.mFragments.a();
    }

    public z getSupportLoaderManager() {
        return this.mFragments.b();
    }

    public final android.support.v4.e.a.a getSupportMediaController() {
        return this.mMediaController;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.c();
        int i3 = i >> 16;
        if (i3 == 0) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        int i4 = i3 - 1;
        String strA = this.mPendingFragmentActivityResults.a(i4);
        this.mPendingFragmentActivityResults.c(i4);
        if (strA == null) {
            Log.w(TAG, "Activity result delivered for unknown Fragment.");
            return;
        }
        Fragment fragmentA = this.mFragments.a(strA);
        if (fragmentA == null) {
            Log.w(TAG, "Activity result no fragment exists for who: " + strA);
        } else {
            fragmentA.onActivityResult(65535 & i, i2, intent);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mFragments.a().c()) {
            return;
        }
        onBackPressedNotHandled();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.a(configuration);
    }

    @Override // android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.mFragments.a((Fragment) null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.mFragments.a(bVar.f666c);
        }
        if (bundle != null) {
            this.mFragments.a(bundle.getParcelable(FRAGMENTS_TAG), bVar != null ? bVar.f665b : null);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.mPendingFragmentActivityResults = new android.support.v4.h.j<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.mPendingFragmentActivityResults.b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new android.support.v4.h.j<>();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean zOnCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.mFragments.a(menu, getMenuInflater());
        if (Build.VERSION.SDK_INT >= 11) {
            return zOnCreatePanelMenu;
        }
        return true;
    }

    @Override // android.support.v4.app.k, android.app.Activity, android.view.LayoutInflater.Factory2
    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.support.v4.app.i, android.app.Activity, android.view.LayoutInflater.Factory
    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.m();
        this.mFragments.q();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.n();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.mFragments.a(menuItem);
            case 6:
                return this.mFragments.b(menuItem);
            default:
                return false;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.c();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.mFragments.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.j();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.o();
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.mOptionsMenuInvalidated) {
            this.mOptionsMenuInvalidated = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.a(menu);
    }

    void onReallyStop() {
        this.mFragments.a(this.mRetaining);
        this.mFragments.l();
    }

    @Override // android.app.Activity, android.support.v4.app.a.InterfaceC0010a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String strA = this.mPendingFragmentActivityResults.a(i3);
            this.mPendingFragmentActivityResults.c(i3);
            if (strA == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment fragmentA = this.mFragments.a(strA);
            if (fragmentA == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + strA);
            } else {
                fragmentA.onRequestPermissionsResult(i & 65535, strArr, iArr);
            }
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.o();
    }

    protected void onResumeFragments() {
        this.mFragments.i();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        List<Fragment> listE = this.mFragments.e();
        android.support.v4.h.i<String, z> iVarS = this.mFragments.s();
        if (listE == null && iVarS == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        b bVar = new b();
        bVar.f664a = objOnRetainCustomNonConfigurationInstance;
        bVar.f665b = listE;
        bVar.f666c = iVarS;
        return bVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable parcelableD = this.mFragments.d();
        if (parcelableD != null) {
            bundle.putParcelable(FRAGMENTS_TAG, parcelableD);
        }
        if (this.mPendingFragmentActivityResults.b() <= 0) {
            return;
        }
        bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
        int[] iArr = new int[this.mPendingFragmentActivityResults.b()];
        String[] strArr = new String[this.mPendingFragmentActivityResults.b()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mPendingFragmentActivityResults.b()) {
                bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
                bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
                return;
            } else {
                iArr[i2] = this.mPendingFragmentActivityResults.d(i2);
                strArr[i2] = this.mPendingFragmentActivityResults.e(i2);
                i = i2 + 1;
            }
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.g();
        }
        this.mFragments.c();
        this.mFragments.o();
        this.mFragments.p();
        this.mFragments.h();
        this.mFragments.r();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.c();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.k();
    }

    public void setEnterSharedElementCallback(av avVar) {
        android.support.v4.app.a.a(this, avVar);
    }

    public void setExitSharedElementCallback(av avVar) {
        android.support.v4.app.a.b(this, avVar);
    }

    public final void setSupportMediaController(android.support.v4.e.a.a aVar) {
        this.mMediaController = aVar;
        if (Build.VERSION.SDK_INT >= 21) {
            android.support.v4.app.b.a(this, aVar.a());
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.mStartedActivityFromFragment && i != -1 && ((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        try {
            if (i == -1) {
                android.support.v4.app.a.a(this, intent, -1, bundle);
                this.mStartedActivityFromFragment = false;
            } else {
                if (((-65536) & i) != 0) {
                    throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
                }
                android.support.v4.app.a.a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & i), bundle);
                this.mStartedActivityFromFragment = false;
            }
        } catch (Throwable th) {
            this.mStartedActivityFromFragment = false;
            throw th;
        }
    }

    public void supportFinishAfterTransition() {
        android.support.v4.app.a.b(this);
    }

    public void supportInvalidateOptionsMenu() {
        if (Build.VERSION.SDK_INT >= 11) {
            d.a(this);
        } else {
            this.mOptionsMenuInvalidated = true;
        }
    }

    public void supportPostponeEnterTransition() {
        android.support.v4.app.a.c(this);
    }

    public void supportStartPostponedEnterTransition() {
        android.support.v4.app.a.d(this);
    }

    @Override // android.support.v4.app.c.a
    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1 && ((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }
}
