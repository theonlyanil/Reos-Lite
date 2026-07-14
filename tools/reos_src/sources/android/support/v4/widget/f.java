package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.android.library.userprofile.util.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends BaseAdapter implements g.a, Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f1018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f1019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Cursor f1020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Context f1021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f1022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected a f1023f;
    protected DataSetObserver g;
    protected g h;
    protected FilterQueryProvider i;

    private class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            f.this.b();
        }
    }

    private class b extends DataSetObserver {
        private b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            f.this.f1018a = true;
            f.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            f.this.f1018a = false;
            f.this.notifyDataSetInvalidated();
        }
    }

    public f(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    @Override // android.support.v4.widget.g.a
    public Cursor a() {
        return this.f1020c;
    }

    @Override // android.support.v4.widget.g.a
    public Cursor a(CharSequence charSequence) {
        return this.i != null ? this.i.runQuery(charSequence) : this.f1020c;
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    void a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.f1019b = true;
        } else {
            this.f1019b = false;
        }
        boolean z = cursor != null;
        this.f1020c = cursor;
        this.f1018a = z;
        this.f1021d = context;
        this.f1022e = z ? cursor.getColumnIndexOrThrow(Constants.SMS_COLUMN_ID) : -1;
        if ((i & 2) == 2) {
            this.f1023f = new a();
            this.g = new b();
        } else {
            this.f1023f = null;
            this.g = null;
        }
        if (z) {
            if (this.f1023f != null) {
                cursor.registerContentObserver(this.f1023f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
        }
    }

    @Override // android.support.v4.widget.g.a
    public void a(Cursor cursor) {
        Cursor cursorB = b(cursor);
        if (cursorB != null) {
            cursorB.close();
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public Cursor b(Cursor cursor) {
        if (cursor == this.f1020c) {
            return null;
        }
        Cursor cursor2 = this.f1020c;
        if (cursor2 != null) {
            if (this.f1023f != null) {
                cursor2.unregisterContentObserver(this.f1023f);
            }
            if (this.g != null) {
                cursor2.unregisterDataSetObserver(this.g);
            }
        }
        this.f1020c = cursor;
        if (cursor == null) {
            this.f1022e = -1;
            this.f1018a = false;
            notifyDataSetInvalidated();
            return cursor2;
        }
        if (this.f1023f != null) {
            cursor.registerContentObserver(this.f1023f);
        }
        if (this.g != null) {
            cursor.registerDataSetObserver(this.g);
        }
        this.f1022e = cursor.getColumnIndexOrThrow(Constants.SMS_COLUMN_ID);
        this.f1018a = true;
        notifyDataSetChanged();
        return cursor2;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    protected void b() {
        if (!this.f1019b || this.f1020c == null || this.f1020c.isClosed()) {
            return;
        }
        this.f1018a = this.f1020c.requery();
    }

    @Override // android.support.v4.widget.g.a
    public CharSequence c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!this.f1018a || this.f1020c == null) {
            return 0;
        }
        return this.f1020c.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1018a) {
            return null;
        }
        this.f1020c.moveToPosition(i);
        if (view == null) {
            view = b(this.f1021d, this.f1020c, viewGroup);
        }
        a(view, this.f1021d, this.f1020c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.h == null) {
            this.h = new g(this);
        }
        return this.h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.f1018a || this.f1020c == null) {
            return null;
        }
        this.f1020c.moveToPosition(i);
        return this.f1020c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f1018a && this.f1020c != null && this.f1020c.moveToPosition(i)) {
            return this.f1020c.getLong(this.f1022e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1018a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f1020c.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        if (view == null) {
            view = a(this.f1021d, this.f1020c, viewGroup);
        }
        a(view, this.f1021d, this.f1020c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
