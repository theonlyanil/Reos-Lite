package android.support.v7.a;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.ah;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.am;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?>[] f1135a = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f1136b = {R.attr.onClick};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f1137c = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, Constructor<? extends View>> f1138d = new android.support.v4.h.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object[] f1139e = new Object[2];

    private static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f1140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f1141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f1142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f1143d;

        public a(View view, String str) {
            this.f1140a = view;
            this.f1141b = str;
        }

        private void a(Context context, String str) {
            Method method;
            Context baseContext = context;
            while (baseContext != null) {
                try {
                    if (!baseContext.isRestricted() && (method = baseContext.getClass().getMethod(this.f1141b, View.class)) != null) {
                        this.f1142c = method;
                        this.f1143d = baseContext;
                        return;
                    }
                } catch (NoSuchMethodException e2) {
                }
                baseContext = baseContext instanceof ContextWrapper ? ((ContextWrapper) baseContext).getBaseContext() : null;
            }
            int id = this.f1140a.getId();
            throw new IllegalStateException("Could not find method " + this.f1141b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f1140a.getClass() + (id == -1 ? "" : " with id '" + this.f1140a.getContext().getResources().getResourceEntryName(id) + "'"));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f1142c == null) {
                a(this.f1140a.getContext(), this.f1141b);
            }
            try {
                this.f1142c.invoke(this.f1143d, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    o() {
    }

    private static Context a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.View, 0, 0);
        int resourceId = z ? typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        int i = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        if (i != 0) {
            return ((context instanceof android.support.v7.view.d) && ((android.support.v7.view.d) context).a() == i) ? context : new android.support.v7.view.d(context, i);
        }
        return context;
    }

    private View a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f1139e[0] = context;
            this.f1139e[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return a(context, str, (String) null);
            }
            for (int i = 0; i < f1137c.length; i++) {
                View viewA = a(context, str, f1137c[i]);
                if (viewA != null) {
                    return viewA;
                }
            }
            return null;
        } catch (Exception e2) {
            return null;
        } finally {
            this.f1139e[0] = null;
            this.f1139e[1] = null;
        }
    }

    private View a(Context context, String str, String str2) throws InflateException, ClassNotFoundException {
        Constructor<? extends View> constructor = f1138d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f1135a);
                f1138d.put(str, constructor);
            } catch (Exception e2) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f1139e);
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || ah.G(view)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1136b);
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new a(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    public final View a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = am.a(context2);
        }
        View appCompatSeekBar = null;
        switch (str) {
            case "TextView":
                appCompatSeekBar = new AppCompatTextView(context2, attributeSet);
                break;
            case "ImageView":
                appCompatSeekBar = new AppCompatImageView(context2, attributeSet);
                break;
            case "Button":
                appCompatSeekBar = new AppCompatButton(context2, attributeSet);
                break;
            case "EditText":
                appCompatSeekBar = new AppCompatEditText(context2, attributeSet);
                break;
            case "Spinner":
                appCompatSeekBar = new AppCompatSpinner(context2, attributeSet);
                break;
            case "ImageButton":
                appCompatSeekBar = new AppCompatImageButton(context2, attributeSet);
                break;
            case "CheckBox":
                appCompatSeekBar = new AppCompatCheckBox(context2, attributeSet);
                break;
            case "RadioButton":
                appCompatSeekBar = new AppCompatRadioButton(context2, attributeSet);
                break;
            case "CheckedTextView":
                appCompatSeekBar = new AppCompatCheckedTextView(context2, attributeSet);
                break;
            case "AutoCompleteTextView":
                appCompatSeekBar = new AppCompatAutoCompleteTextView(context2, attributeSet);
                break;
            case "MultiAutoCompleteTextView":
                appCompatSeekBar = new AppCompatMultiAutoCompleteTextView(context2, attributeSet);
                break;
            case "RatingBar":
                appCompatSeekBar = new AppCompatRatingBar(context2, attributeSet);
                break;
            case "SeekBar":
                appCompatSeekBar = new AppCompatSeekBar(context2, attributeSet);
                break;
        }
        View viewA = (appCompatSeekBar != null || context == context2) ? appCompatSeekBar : a(context2, str, attributeSet);
        if (viewA != null) {
            a(viewA, attributeSet);
        }
        return viewA;
    }
}
