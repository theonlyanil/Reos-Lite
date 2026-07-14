package android.support.v7.a;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ah;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class d {
    private TextView A;
    private TextView B;
    private View C;
    private ListAdapter D;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private Handler M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f1059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Window f1060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharSequence f1061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f1062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ListView f1063f;
    private View g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private Button n;
    private CharSequence o;
    private Message p;
    private Button q;
    private CharSequence r;
    private Message s;
    private Button t;
    private CharSequence u;
    private Message v;
    private NestedScrollView w;
    private Drawable y;
    private ImageView z;
    private boolean m = false;
    private int x = 0;
    private int E = -1;
    private int L = 0;
    private final View.OnClickListener N = new View.OnClickListener() { // from class: android.support.v7.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            if (view == d.this.n && d.this.p != null) {
                messageObtain = Message.obtain(d.this.p);
            } else if (view != d.this.q || d.this.s == null) {
                messageObtain = (view != d.this.t || d.this.v == null) ? null : Message.obtain(d.this.v);
            } else {
                messageObtain = Message.obtain(d.this.s);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            d.this.M.obtainMessage(1, d.this.f1059b).sendToTarget();
        }
    };

    public static class a {
        public int A;
        public boolean[] C;
        public boolean D;
        public boolean E;
        public DialogInterface.OnMultiChoiceClickListener G;
        public Cursor H;
        public String I;
        public String J;
        public AdapterView.OnItemSelectedListener K;
        public InterfaceC0028a L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f1078b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f1080d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f1082f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public DialogInterface.OnClickListener j;
        public CharSequence k;
        public DialogInterface.OnClickListener l;
        public CharSequence m;
        public DialogInterface.OnClickListener n;
        public DialogInterface.OnCancelListener p;
        public DialogInterface.OnDismissListener q;
        public DialogInterface.OnKeyListener r;
        public CharSequence[] s;
        public ListAdapter t;
        public DialogInterface.OnClickListener u;
        public int v;
        public View w;
        public int x;
        public int y;
        public int z;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1079c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1081e = 0;
        public boolean B = false;
        public int F = -1;
        public boolean M = true;
        public boolean o = true;

        /* JADX INFO: renamed from: android.support.v7.a.d$a$a, reason: collision with other inner class name */
        public interface InterfaceC0028a {
            void a(ListView listView);
        }

        public a(Context context) {
            this.f1077a = context;
            this.f1078b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(final d dVar) {
            ListAdapter cVar;
            int i = R.id.text1;
            boolean z = false;
            final ListView listView = (ListView) this.f1078b.inflate(dVar.H, (ViewGroup) null);
            if (this.D) {
                cVar = this.H == null ? new ArrayAdapter<CharSequence>(this.f1077a, dVar.I, i, this.s) { // from class: android.support.v7.a.d.a.1
                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public View getView(int i2, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i2, view, viewGroup);
                        if (a.this.C != null && a.this.C[i2]) {
                            listView.setItemChecked(i2, true);
                        }
                        return view2;
                    }
                } : new CursorAdapter(this.f1077a, this.H, z) { // from class: android.support.v7.a.d.a.2

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    private final int f1088d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    private final int f1089e;

                    {
                        Cursor cursor = getCursor();
                        this.f1088d = cursor.getColumnIndexOrThrow(a.this.I);
                        this.f1089e = cursor.getColumnIndexOrThrow(a.this.J);
                    }

                    @Override // android.widget.CursorAdapter
                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f1088d));
                        listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1089e) == 1);
                    }

                    @Override // android.widget.CursorAdapter
                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return a.this.f1078b.inflate(dVar.I, viewGroup, false);
                    }
                };
            } else {
                int i2 = this.E ? dVar.J : dVar.K;
                if (this.H != null) {
                    cVar = new SimpleCursorAdapter(this.f1077a, i2, this.H, new String[]{this.I}, new int[]{R.id.text1});
                } else {
                    cVar = this.t != null ? this.t : new c(this.f1077a, i2, R.id.text1, this.s);
                }
            }
            if (this.L != null) {
                this.L.a(listView);
            }
            dVar.D = cVar;
            dVar.E = this.F;
            if (this.u != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.a.d.a.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        a.this.u.onClick(dVar.f1059b, i3);
                        if (a.this.E) {
                            return;
                        }
                        dVar.f1059b.dismiss();
                    }
                });
            } else if (this.G != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.a.d.a.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        if (a.this.C != null) {
                            a.this.C[i3] = listView.isItemChecked(i3);
                        }
                        a.this.G.onClick(dVar.f1059b, i3, listView.isItemChecked(i3));
                    }
                });
            }
            if (this.K != null) {
                listView.setOnItemSelectedListener(this.K);
            }
            if (this.E) {
                listView.setChoiceMode(1);
            } else if (this.D) {
                listView.setChoiceMode(2);
            }
            dVar.f1063f = listView;
        }

        public void a(d dVar) {
            if (this.g != null) {
                dVar.b(this.g);
            } else {
                if (this.f1082f != null) {
                    dVar.a(this.f1082f);
                }
                if (this.f1080d != null) {
                    dVar.a(this.f1080d);
                }
                if (this.f1079c != 0) {
                    dVar.b(this.f1079c);
                }
                if (this.f1081e != 0) {
                    dVar.b(dVar.c(this.f1081e));
                }
            }
            if (this.h != null) {
                dVar.b(this.h);
            }
            if (this.i != null) {
                dVar.a(-1, this.i, this.j, (Message) null);
            }
            if (this.k != null) {
                dVar.a(-2, this.k, this.l, (Message) null);
            }
            if (this.m != null) {
                dVar.a(-3, this.m, this.n, (Message) null);
            }
            if (this.s != null || this.H != null || this.t != null) {
                b(dVar);
            }
            if (this.w == null) {
                if (this.v != 0) {
                    dVar.a(this.v);
                }
            } else if (this.B) {
                dVar.a(this.w, this.x, this.y, this.z, this.A);
            } else {
                dVar.c(this.w);
            }
        }
    }

    private static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f1095a;

        public b(DialogInterface dialogInterface) {
            this.f1095a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick(this.f1095a.get(), message.what);
                    break;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    break;
            }
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public d(Context context, n nVar, Window window) {
        this.f1058a = context;
        this.f1059b = nVar;
        this.f1060c = window;
        this.M = new b(nVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, android.support.v7.b.a.k.AlertDialog, android.support.v7.b.a.C0029a.alertDialogStyle, 0);
        this.F = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.AlertDialog_android_layout, 0);
        this.G = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.AlertDialog_buttonPanelSideLayout, 0);
        this.H = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.AlertDialog_listLayout, 0);
        this.I = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.AlertDialog_multiChoiceItemLayout, 0);
        this.J = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.AlertDialog_singleChoiceItemLayout, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.AlertDialog_listItemLayout, 0);
        typedArrayObtainStyledAttributes.recycle();
        nVar.a(1);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    private void a(ViewGroup viewGroup) {
        View viewInflate;
        if (this.g != null) {
            viewInflate = this.g;
        } else {
            viewInflate = this.h != 0 ? LayoutInflater.from(this.f1058a).inflate(this.h, viewGroup, false) : null;
        }
        boolean z = viewInflate != null;
        if (!z || !a(viewInflate)) {
            this.f1060c.setFlags(131072, 131072);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f1060c.findViewById(android.support.v7.b.a.f.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.m) {
            frameLayout.setPadding(this.i, this.j, this.k, this.l);
        }
        if (this.f1063f != null) {
            ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = BitmapDescriptorFactory.HUE_RED;
        }
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        final View view2 = null;
        final View viewFindViewById = this.f1060c.findViewById(android.support.v7.b.a.f.scrollIndicatorUp);
        View viewFindViewById2 = this.f1060c.findViewById(android.support.v7.b.a.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ah.a(view, i, i2);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (i & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 == null || (i & 2) != 0) {
            view2 = viewFindViewById2;
        } else {
            viewGroup.removeView(viewFindViewById2);
        }
        if (viewFindViewById == null && view2 == null) {
            return;
        }
        if (this.f1062e != null) {
            this.w.setOnScrollChangeListener(new NestedScrollView.b() { // from class: android.support.v7.a.d.2
                @Override // android.support.v4.widget.NestedScrollView.b
                public void a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                    d.b(nestedScrollView, viewFindViewById, view2);
                }
            });
            this.w.post(new Runnable() { // from class: android.support.v7.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.b(d.this.w, viewFindViewById, view2);
                }
            });
        } else {
            if (this.f1063f != null) {
                this.f1063f.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: android.support.v7.a.d.4
                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                        d.b(absListView, viewFindViewById, view2);
                    }

                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScrollStateChanged(AbsListView absListView, int i3) {
                    }
                });
                this.f1063f.post(new Runnable() { // from class: android.support.v7.a.d.5
                    @Override // java.lang.Runnable
                    public void run() {
                        d.b(d.this.f1063f, viewFindViewById, view2);
                    }
                });
                return;
            }
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
        }
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private int b() {
        if (this.G != 0 && this.L == 1) {
            return this.G;
        }
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(ah.b(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(ah.b(view, 1) ? 0 : 4);
        }
    }

    private void b(ViewGroup viewGroup) {
        if (this.C != null) {
            viewGroup.addView(this.C, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f1060c.findViewById(android.support.v7.b.a.f.title_template).setVisibility(8);
            return;
        }
        this.z = (ImageView) this.f1060c.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f1061d))) {
            this.f1060c.findViewById(android.support.v7.b.a.f.title_template).setVisibility(8);
            this.z.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.A = (TextView) this.f1060c.findViewById(android.support.v7.b.a.f.alertTitle);
        this.A.setText(this.f1061d);
        if (this.x != 0) {
            this.z.setImageResource(this.x);
        } else if (this.y != null) {
            this.z.setImageDrawable(this.y);
        } else {
            this.A.setPadding(this.z.getPaddingLeft(), this.z.getPaddingTop(), this.z.getPaddingRight(), this.z.getPaddingBottom());
            this.z.setVisibility(8);
        }
    }

    private void c() {
        View viewFindViewById;
        View viewFindViewById2 = this.f1060c.findViewById(android.support.v7.b.a.f.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(android.support.v7.b.a.f.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(android.support.v7.b.a.f.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(android.support.v7.b.a.f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(android.support.v7.b.a.f.customPanel);
        a(viewGroup);
        View viewFindViewById6 = viewGroup.findViewById(android.support.v7.b.a.f.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(android.support.v7.b.a.f.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(android.support.v7.b.a.f.buttonPanel);
        ViewGroup viewGroupA = a(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupA2 = a(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupA3 = a(viewFindViewById8, viewFindViewById5);
        c(viewGroupA2);
        d(viewGroupA3);
        b(viewGroupA);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (viewGroupA == null || viewGroupA.getVisibility() == 8) ? false : true;
        boolean z3 = (viewGroupA3 == null || viewGroupA3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupA2 != null && (viewFindViewById = viewGroupA2.findViewById(android.support.v7.b.a.f.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (z2 && this.w != null) {
            this.w.setClipToPadding(true);
        }
        if (!z) {
            View view = this.f1063f != null ? this.f1063f : this.w;
            if (view != null) {
                a(viewGroupA2, view, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.f1063f;
        if (listView == null || this.D == null) {
            return;
        }
        listView.setAdapter(this.D);
        int i = this.E;
        if (i > -1) {
            listView.setItemChecked(i, true);
            listView.setSelection(i);
        }
    }

    private void c(ViewGroup viewGroup) {
        this.w = (NestedScrollView) this.f1060c.findViewById(android.support.v7.b.a.f.scrollView);
        this.w.setFocusable(false);
        this.w.setNestedScrollingEnabled(false);
        this.B = (TextView) viewGroup.findViewById(R.id.message);
        if (this.B == null) {
            return;
        }
        if (this.f1062e != null) {
            this.B.setText(this.f1062e);
            return;
        }
        this.B.setVisibility(8);
        this.w.removeView(this.B);
        if (this.f1063f == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.w.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.w);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f1063f, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void d(ViewGroup viewGroup) {
        int i;
        this.n = (Button) viewGroup.findViewById(R.id.button1);
        this.n.setOnClickListener(this.N);
        if (TextUtils.isEmpty(this.o)) {
            this.n.setVisibility(8);
            i = 0;
        } else {
            this.n.setText(this.o);
            this.n.setVisibility(0);
            i = 1;
        }
        this.q = (Button) viewGroup.findViewById(R.id.button2);
        this.q.setOnClickListener(this.N);
        if (TextUtils.isEmpty(this.r)) {
            this.q.setVisibility(8);
        } else {
            this.q.setText(this.r);
            this.q.setVisibility(0);
            i |= 2;
        }
        this.t = (Button) viewGroup.findViewById(R.id.button3);
        this.t.setOnClickListener(this.N);
        if (TextUtils.isEmpty(this.u)) {
            this.t.setVisibility(8);
        } else {
            this.t.setText(this.u);
            this.t.setVisibility(0);
            i |= 4;
        }
        if (i != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void a() {
        this.f1059b.setContentView(b());
        c();
    }

    public void a(int i) {
        this.g = null;
        this.h = i;
        this.m = false;
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.u = charSequence;
                this.v = message;
                return;
            case -2:
                this.r = charSequence;
                this.s = message;
                return;
            case -1:
                this.o = charSequence;
                this.p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void a(Drawable drawable) {
        this.y = drawable;
        this.x = 0;
        if (this.z != null) {
            if (drawable == null) {
                this.z.setVisibility(8);
            } else {
                this.z.setVisibility(0);
                this.z.setImageDrawable(drawable);
            }
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.g = view;
        this.h = 0;
        this.m = true;
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
    }

    public void a(CharSequence charSequence) {
        this.f1061d = charSequence;
        if (this.A != null) {
            this.A.setText(charSequence);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return this.w != null && this.w.a(keyEvent);
    }

    public void b(int i) {
        this.y = null;
        this.x = i;
        if (this.z != null) {
            if (i == 0) {
                this.z.setVisibility(8);
            } else {
                this.z.setVisibility(0);
                this.z.setImageResource(this.x);
            }
        }
    }

    public void b(View view) {
        this.C = view;
    }

    public void b(CharSequence charSequence) {
        this.f1062e = charSequence;
        if (this.B != null) {
            this.B.setText(charSequence);
        }
    }

    public boolean b(int i, KeyEvent keyEvent) {
        return this.w != null && this.w.a(keyEvent);
    }

    public int c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f1058a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void c(View view) {
        this.g = view;
        this.h = 0;
        this.m = false;
    }
}
