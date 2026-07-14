package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements android.support.v7.view.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a f1590a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f1591c;
    private android.support.v4.widget.f A;
    private boolean B;
    private CharSequence C;
    private boolean D;
    private boolean E;
    private int F;
    private boolean G;
    private CharSequence H;
    private CharSequence I;
    private boolean J;
    private int K;
    private SearchableInfo L;
    private Bundle M;
    private final h N;
    private Runnable O;
    private final Runnable P;
    private Runnable Q;
    private final WeakHashMap<String, Drawable.ConstantState> R;
    private final View.OnClickListener S;
    private final TextView.OnEditorActionListener T;
    private final AdapterView.OnItemClickListener U;
    private final AdapterView.OnItemSelectedListener V;
    private TextWatcher W;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    View.OnKeyListener f1592b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SearchAutoComplete f1593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final View f1594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f1595f;
    private final View g;
    private final ImageView h;
    private final ImageView i;
    private final ImageView j;
    private final ImageView k;
    private final View l;
    private final ImageView m;
    private final Drawable n;
    private final int o;
    private final int p;
    private final Intent q;
    private final Intent r;
    private final CharSequence s;
    private c t;
    private b u;
    private View.OnFocusChangeListener v;
    private d w;
    private View.OnClickListener x;
    private boolean y;
    private boolean z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.SearchView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1608a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1608a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1608a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1608a));
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SearchView f1610b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, android.support.v7.b.a.C0029a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1609a = getThreshold();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f1609a <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1610b.d();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1610b.clearFocus();
                        this.f1610b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1610b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.a(getContext())) {
                    SearchView.f1590a.a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.f1610b = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1609a = i;
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f1611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f1612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f1613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Method f1614d;

        a() {
            try {
                this.f1611a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1611a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f1612b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1612b.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.f1613c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f1613c.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
            try {
                this.f1614d = InputMethodManager.class.getMethod("showSoftInputUnchecked", Integer.TYPE, ResultReceiver.class);
                this.f1614d.setAccessible(true);
            } catch (NoSuchMethodException e5) {
            }
        }

        void a(InputMethodManager inputMethodManager, View view, int i) {
            if (this.f1614d != null) {
                try {
                    this.f1614d.invoke(inputMethodManager, Integer.valueOf(i), null);
                    return;
                } catch (Exception e2) {
                }
            }
            inputMethodManager.showSoftInput(view, i);
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1611a != null) {
                try {
                    this.f1611a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e2) {
                }
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f1613c != null) {
                try {
                    this.f1613c.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception e2) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1612b != null) {
                try {
                    this.f1612b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e2) {
                }
            }
        }
    }

    public interface b {
        boolean a();
    }

    public interface c {
        boolean a(String str);

        boolean b(String str);
    }

    public interface d {
        boolean a(int i);

        boolean b(int i);
    }

    static {
        f1591c = Build.VERSION.SDK_INT >= 8;
        f1590a = new a();
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O = new Runnable() { // from class: android.support.v7.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) SearchView.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    SearchView.f1590a.a(inputMethodManager, SearchView.this, 0);
                }
            }
        };
        this.P = new Runnable() { // from class: android.support.v7.widget.SearchView.5
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.m();
            }
        };
        this.Q = new Runnable() { // from class: android.support.v7.widget.SearchView.6
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.A == null || !(SearchView.this.A instanceof aj)) {
                    return;
                }
                SearchView.this.A.a((Cursor) null);
            }
        };
        this.R = new WeakHashMap<>();
        this.S = new View.OnClickListener() { // from class: android.support.v7.widget.SearchView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SearchView.this.h) {
                    SearchView.this.s();
                    return;
                }
                if (view == SearchView.this.j) {
                    SearchView.this.r();
                    return;
                }
                if (view == SearchView.this.i) {
                    SearchView.this.p();
                } else if (view == SearchView.this.k) {
                    SearchView.this.t();
                } else if (view == SearchView.this.f1593d) {
                    SearchView.this.v();
                }
            }
        };
        this.f1592b = new View.OnKeyListener() { // from class: android.support.v7.widget.SearchView.11
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.L == null) {
                    return false;
                }
                if (SearchView.this.f1593d.isPopupShowing() && SearchView.this.f1593d.getListSelection() != -1) {
                    return SearchView.this.a(view, i2, keyEvent);
                }
                if (SearchView.this.f1593d.a() || !android.support.v4.view.g.a(keyEvent) || keyEvent.getAction() != 1 || i2 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView.this.a(0, (String) null, SearchView.this.f1593d.getText().toString());
                return true;
            }
        };
        this.T = new TextView.OnEditorActionListener() { // from class: android.support.v7.widget.SearchView.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.p();
                return true;
            }
        };
        this.U = new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.SearchView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.a(i2, 0, (String) null);
            }
        };
        this.V = new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.SearchView.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.a(i2);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.W = new TextWatcher() { // from class: android.support.v7.widget.SearchView.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.c(charSequence);
            }
        };
        this.N = h.a();
        ap apVarA = ap.a(context, attributeSet, android.support.v7.b.a.k.SearchView, i, 0);
        LayoutInflater.from(context).inflate(apVarA.g(android.support.v7.b.a.k.SearchView_layout, android.support.v7.b.a.h.abc_search_view), (ViewGroup) this, true);
        this.f1593d = (SearchAutoComplete) findViewById(android.support.v7.b.a.f.search_src_text);
        this.f1593d.setSearchView(this);
        this.f1594e = findViewById(android.support.v7.b.a.f.search_edit_frame);
        this.f1595f = findViewById(android.support.v7.b.a.f.search_plate);
        this.g = findViewById(android.support.v7.b.a.f.submit_area);
        this.h = (ImageView) findViewById(android.support.v7.b.a.f.search_button);
        this.i = (ImageView) findViewById(android.support.v7.b.a.f.search_go_btn);
        this.j = (ImageView) findViewById(android.support.v7.b.a.f.search_close_btn);
        this.k = (ImageView) findViewById(android.support.v7.b.a.f.search_voice_btn);
        this.m = (ImageView) findViewById(android.support.v7.b.a.f.search_mag_icon);
        this.f1595f.setBackgroundDrawable(apVarA.a(android.support.v7.b.a.k.SearchView_queryBackground));
        this.g.setBackgroundDrawable(apVarA.a(android.support.v7.b.a.k.SearchView_submitBackground));
        this.h.setImageDrawable(apVarA.a(android.support.v7.b.a.k.SearchView_searchIcon));
        this.i.setImageDrawable(apVarA.a(android.support.v7.b.a.k.SearchView_goIcon));
        this.j.setImageDrawable(apVarA.a(android.support.v7.b.a.k.SearchView_closeIcon));
        this.k.setImageDrawable(apVarA.a(android.support.v7.b.a.k.SearchView_voiceIcon));
        this.m.setImageDrawable(apVarA.a(android.support.v7.b.a.k.SearchView_searchIcon));
        this.n = apVarA.a(android.support.v7.b.a.k.SearchView_searchHintIcon);
        this.o = apVarA.g(android.support.v7.b.a.k.SearchView_suggestionRowLayout, android.support.v7.b.a.h.abc_search_dropdown_item_icons_2line);
        this.p = apVarA.g(android.support.v7.b.a.k.SearchView_commitIcon, 0);
        this.h.setOnClickListener(this.S);
        this.j.setOnClickListener(this.S);
        this.i.setOnClickListener(this.S);
        this.k.setOnClickListener(this.S);
        this.f1593d.setOnClickListener(this.S);
        this.f1593d.addTextChangedListener(this.W);
        this.f1593d.setOnEditorActionListener(this.T);
        this.f1593d.setOnItemClickListener(this.U);
        this.f1593d.setOnItemSelectedListener(this.V);
        this.f1593d.setOnKeyListener(this.f1592b);
        this.f1593d.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: android.support.v7.widget.SearchView.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.v != null) {
                    SearchView.this.v.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(apVarA.a(android.support.v7.b.a.k.SearchView_iconifiedByDefault, true));
        int iE = apVarA.e(android.support.v7.b.a.k.SearchView_android_maxWidth, -1);
        if (iE != -1) {
            setMaxWidth(iE);
        }
        this.s = apVarA.c(android.support.v7.b.a.k.SearchView_defaultQueryHint);
        this.C = apVarA.c(android.support.v7.b.a.k.SearchView_queryHint);
        int iA = apVarA.a(android.support.v7.b.a.k.SearchView_android_imeOptions, -1);
        if (iA != -1) {
            setImeOptions(iA);
        }
        int iA2 = apVarA.a(android.support.v7.b.a.k.SearchView_android_inputType, -1);
        if (iA2 != -1) {
            setInputType(iA2);
        }
        setFocusable(apVarA.a(android.support.v7.b.a.k.SearchView_android_focusable, true));
        apVarA.a();
        this.q = new Intent("android.speech.action.WEB_SEARCH");
        this.q.addFlags(268435456);
        this.q.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.r = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.r.addFlags(268435456);
        this.l = findViewById(this.f1593d.getDropDownAnchor());
        if (this.l != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                e();
            } else {
                f();
            }
        }
        a(this.y);
        n();
    }

    @TargetApi(8)
    private Intent a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private Intent a(Cursor cursor, int i, String str) {
        int position;
        String strA;
        try {
            String strA2 = aj.a(cursor, "suggest_intent_action");
            if (strA2 == null && Build.VERSION.SDK_INT >= 8) {
                strA2 = this.L.getSuggestIntentAction();
            }
            if (strA2 == null) {
                strA2 = "android.intent.action.SEARCH";
            }
            String strA3 = aj.a(cursor, "suggest_intent_data");
            if (f1591c && strA3 == null) {
                strA3 = this.L.getSuggestIntentData();
            }
            if (strA3 != null && (strA = aj.a(cursor, "suggest_intent_data_id")) != null) {
                strA3 = strA3 + "/" + Uri.encode(strA);
            }
            return a(strA2, strA3 == null ? null : Uri.parse(strA3), aj.a(cursor, "suggest_intent_extra_data"), aj.a(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e2) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException e3) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e2);
            return null;
        }
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.I);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.M != null) {
            intent.putExtra("app_data", this.M);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f1591c) {
            intent.setComponent(this.L.getSearchActivity());
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    private void a(boolean z) {
        int i = 8;
        this.z = z;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f1593d.getText());
        this.h.setVisibility(i2);
        b(z2);
        this.f1594e.setVisibility(z ? 8 : 0);
        if (this.m.getDrawable() != null && !this.y) {
            i = 0;
        }
        this.m.setVisibility(i);
        k();
        c(z2 ? false : true);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i) {
        if (this.w != null && this.w.a(i)) {
            return false;
        }
        e(i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, int i2, String str) {
        if (this.w != null && this.w.b(i)) {
            return false;
        }
        b(i, 0, null);
        setImeVisibility(false);
        q();
        return true;
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, int i, KeyEvent keyEvent) {
        if (this.L == null || this.A == null || keyEvent.getAction() != 0 || !android.support.v4.view.g.a(keyEvent)) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return a(this.f1593d.getListSelection(), 0, (String) null);
        }
        if (i != 21 && i != 22) {
            if (i != 19 || this.f1593d.getListSelection() != 0) {
            }
            return false;
        }
        this.f1593d.setSelection(i == 21 ? 0 : this.f1593d.length());
        this.f1593d.setListSelection(0);
        this.f1593d.clearListSelection();
        f1590a.a(this.f1593d, true);
        return true;
    }

    @TargetApi(8)
    private Intent b(Intent intent, SearchableInfo searchableInfo) {
        String string;
        String string2;
        String str;
        int voiceMaxResults;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.M != null) {
            bundle.putParcelable("app_data", this.M);
        }
        Intent intent3 = new Intent(intent);
        if (Build.VERSION.SDK_INT >= 8) {
            Resources resources = getResources();
            String string3 = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
            string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
            string = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
            if (searchableInfo.getVoiceMaxResults() != 0) {
                str = string3;
                voiceMaxResults = searchableInfo.getVoiceMaxResults();
            } else {
                str = string3;
                voiceMaxResults = 1;
            }
        } else {
            string = null;
            string2 = null;
            str = "free_form";
            voiceMaxResults = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private CharSequence b(CharSequence charSequence) {
        if (!this.y || this.n == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1593d.getTextSize()) * 1.25d);
        this.n.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.n), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void b(boolean z) {
        int i = 8;
        if (this.B && h() && hasFocus() && (z || !this.G)) {
            i = 0;
        }
        this.i.setVisibility(i);
    }

    private boolean b(int i, int i2, String str) {
        Cursor cursorA = this.A.a();
        if (cursorA == null || !cursorA.moveToPosition(i)) {
            return false;
        }
        a(a(cursorA, i2, str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CharSequence charSequence) {
        Editable text = this.f1593d.getText();
        this.I = text;
        boolean z = !TextUtils.isEmpty(text);
        b(z);
        c(z ? false : true);
        k();
        i();
        if (this.t != null && !TextUtils.equals(charSequence, this.H)) {
            this.t.b(charSequence.toString());
        }
        this.H = charSequence.toString();
    }

    private void c(boolean z) {
        int i;
        if (this.G && !c() && z) {
            i = 0;
            this.i.setVisibility(8);
        } else {
            i = 8;
        }
        this.k.setVisibility(i);
    }

    @TargetApi(11)
    private void e() {
        this.l.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: android.support.v7.widget.SearchView.8
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                SearchView.this.u();
            }
        });
    }

    private void e(int i) {
        Editable text = this.f1593d.getText();
        Cursor cursorA = this.A.a();
        if (cursorA == null) {
            return;
        }
        if (!cursorA.moveToPosition(i)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceC = this.A.c(cursorA);
        if (charSequenceC != null) {
            setQuery(charSequenceC);
        } else {
            setQuery(text);
        }
    }

    private void f() {
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.SearchView.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SearchView.this.u();
            }
        });
    }

    @TargetApi(8)
    private boolean g() {
        if (this.L == null || !this.L.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.L.getVoiceSearchLaunchWebSearch()) {
            intent = this.q;
        } else if (this.L.getVoiceSearchLaunchRecognizer()) {
            intent = this.r;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(android.support.v7.b.a.d.abc_search_view_preferred_width);
    }

    private boolean h() {
        return (this.B || this.G) && !c();
    }

    private void i() {
        int i = 8;
        if (h() && (this.i.getVisibility() == 0 || this.k.getVisibility() == 0)) {
            i = 0;
        }
        this.g.setVisibility(i);
    }

    private void k() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1593d.getText());
        if (!z2 && (!this.y || this.J)) {
            z = false;
        }
        this.j.setVisibility(z ? 0 : 8);
        Drawable drawable = this.j.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void l() {
        post(this.P);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        int[] iArr = this.f1593d.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.f1595f.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.g.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    private void n() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1593d;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(b(queryHint));
    }

    @TargetApi(8)
    private void o() {
        this.f1593d.setThreshold(this.L.getSuggestThreshold());
        this.f1593d.setImeOptions(this.L.getImeOptions());
        int inputType = this.L.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.L.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f1593d.setInputType(inputType);
        if (this.A != null) {
            this.A.a((Cursor) null);
        }
        if (this.L.getSuggestAuthority() != null) {
            this.A = new aj(getContext(), this, this.L, this.R);
            this.f1593d.setAdapter(this.A);
            ((aj) this.A).a(this.D ? 2 : 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Editable text = this.f1593d.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.t == null || !this.t.a(text.toString())) {
            if (this.L != null) {
                a(0, (String) null, text.toString());
            }
            setImeVisibility(false);
            q();
        }
    }

    private void q() {
        this.f1593d.dismissDropDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (!TextUtils.isEmpty(this.f1593d.getText())) {
            this.f1593d.setText("");
            this.f1593d.requestFocus();
            setImeVisibility(true);
        } else if (this.y) {
            if (this.u == null || !this.u.a()) {
                clearFocus();
                a(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        a(false);
        this.f1593d.requestFocus();
        setImeVisibility(true);
        if (this.x != null) {
            this.x.onClick(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImeVisibility(boolean z) {
        if (z) {
            post(this.O);
            return;
        }
        removeCallbacks(this.O);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f1593d.setText(charSequence);
        this.f1593d.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(8)
    public void t() {
        if (this.L == null) {
            return;
        }
        SearchableInfo searchableInfo = this.L;
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(a(this.q, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(b(this.r, searchableInfo));
            }
        } catch (ActivityNotFoundException e2) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        int dimensionPixelSize;
        if (this.l.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1595f.getPaddingLeft();
            Rect rect = new Rect();
            boolean zA = at.a(this);
            if (this.y) {
                dimensionPixelSize = resources.getDimensionPixelSize(android.support.v7.b.a.d.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(android.support.v7.b.a.d.abc_dropdownitem_icon_width);
            } else {
                dimensionPixelSize = 0;
            }
            this.f1593d.getDropDownBackground().getPadding(rect);
            this.f1593d.setDropDownHorizontalOffset(zA ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f1593d.setDropDownWidth((dimensionPixelSize + ((this.l.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        f1590a.a(this.f1593d);
        f1590a.b(this.f1593d);
    }

    @Override // android.support.v7.view.c
    public void a() {
        if (this.J) {
            return;
        }
        this.J = true;
        this.K = this.f1593d.getImeOptions();
        this.f1593d.setImeOptions(this.K | 33554432);
        this.f1593d.setText("");
        setIconified(false);
    }

    void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void a(CharSequence charSequence, boolean z) {
        this.f1593d.setText(charSequence);
        if (charSequence != null) {
            this.f1593d.setSelection(this.f1593d.length());
            this.I = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        p();
    }

    @Override // android.support.v7.view.c
    public void b() {
        a("", false);
        clearFocus();
        a(true);
        this.f1593d.setImeOptions(this.K);
        this.J = false;
    }

    public boolean c() {
        return this.z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.E = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1593d.clearFocus();
        this.E = false;
    }

    void d() {
        a(c());
        l();
        if (this.f1593d.hasFocus()) {
            v();
        }
    }

    public int getImeOptions() {
        return this.f1593d.getImeOptions();
    }

    public int getInputType() {
        return this.f1593d.getInputType();
    }

    public int getMaxWidth() {
        return this.F;
    }

    public CharSequence getQuery() {
        return this.f1593d.getText();
    }

    public CharSequence getQueryHint() {
        if (this.C != null) {
            return this.C;
        }
        return (!f1591c || this.L == null || this.L.getHintId() == 0) ? this.s : getContext().getText(this.L.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.p;
    }

    int getSuggestionRowLayout() {
        return this.o;
    }

    public android.support.v4.widget.f getSuggestionsAdapter() {
        return this.A;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.P);
        post(this.Q);
        super.onDetachedFromWindow();
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        if (c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                size = this.F <= 0 ? Math.min(getPreferredWidth(), size) : Math.min(this.F, size);
                break;
            case 0:
                size = this.F <= 0 ? getPreferredWidth() : this.F;
                break;
            case 1073741824:
                if (this.F > 0) {
                    size = Math.min(this.F, size);
                }
                break;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a(savedState.f1608a);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1608a = c();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.E || !isFocusable()) {
            return false;
        }
        if (c()) {
            return super.requestFocus(i, rect);
        }
        boolean zRequestFocus = this.f1593d.requestFocus(i, rect);
        if (zRequestFocus) {
            a(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.M = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            r();
        } else {
            s();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.y == z) {
            return;
        }
        this.y = z;
        a(z);
        n();
    }

    public void setImeOptions(int i) {
        this.f1593d.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f1593d.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.F = i;
        requestLayout();
    }

    public void setOnCloseListener(b bVar) {
        this.u = bVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.v = onFocusChangeListener;
    }

    public void setOnQueryTextListener(c cVar) {
        this.t = cVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.w = dVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.C = charSequence;
        n();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.D = z;
        if (this.A instanceof aj) {
            ((aj) this.A).a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.L = searchableInfo;
        if (this.L != null) {
            if (f1591c) {
                o();
            }
            n();
        }
        this.G = f1591c && g();
        if (this.G) {
            this.f1593d.setPrivateImeOptions("nm");
        }
        a(c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.B = z;
        a(c());
    }

    public void setSuggestionsAdapter(android.support.v4.widget.f fVar) {
        this.A = fVar;
        this.f1593d.setAdapter(this.A);
    }
}
