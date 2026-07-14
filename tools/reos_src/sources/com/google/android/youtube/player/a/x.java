package com.google.android.youtube.player.a;

import android.os.IBinder;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class x<T> extends w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f5348a;

    private x(T t) {
        this.f5348a = t;
    }

    public static <T> w a(T t) {
        return new x(t);
    }

    public static <T> T a(w wVar) {
        if (wVar instanceof x) {
            return ((x) wVar).f5348a;
        }
        IBinder iBinderAsBinder = wVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        if (declaredFields.length != 1) {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        Field field = declaredFields[0];
        if (field.isAccessible()) {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(iBinderAsBinder);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
        } catch (IllegalArgumentException e3) {
            throw new IllegalArgumentException("remoteBinder is the wrong class.", e3);
        } catch (NullPointerException e4) {
            throw new IllegalArgumentException("Binder object is null.", e4);
        }
    }
}
