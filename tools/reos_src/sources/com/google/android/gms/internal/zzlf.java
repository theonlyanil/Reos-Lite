package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.zzx;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzlf extends zzle {
    public static final List<String> zzWA = Collections.singletonList(Scopes.EMAIL);
    private Class<?> zzWB;
    private Class<?> zzWC;
    private Object zzWD;
    private Object zzWE;

    public zzlf(Activity activity, List<String> list) {
        super(activity, zzWA, list);
    }

    public static void zzag(Context context) throws IllegalStateException {
        zzx.zzy(context);
        try {
            try {
                Class.forName("com.facebook.m").getDeclaredMethod("sdkInitialize", Context.class, Integer.TYPE).invoke(null, context.getApplicationContext(), 64206);
                Class<?> cls = Class.forName("com.facebook.login.g");
                cls.getDeclaredMethod("logOut", new Class[0]).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                Log.e("AuthSignInClient", "Facebook logout error.", e2);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            }
        } catch (ClassNotFoundException e3) {
            try {
                Class<?> cls2 = Class.forName("com.facebook.Session");
                Object objInvoke = cls2.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
                if (objInvoke != null) {
                    cls2.getDeclaredMethod("closeAndClearTokenInformation", new Class[0]).invoke(objInvoke, new Object[0]);
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
                Log.e("AuthSignInClient", "Facebook logout error.", e4);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            }
        }
    }

    private void zzne() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        if (this.zzWE != null) {
            Class.forName("com.facebook.login.g").getDeclaredMethod("logInWithReadPermissions", Activity.class, Collection.class).invoke(this.zzWE, this.mActivity, new ArrayList(zznb()));
            return;
        }
        Class<?> cls = Class.forName("com.facebook.Session$OpenRequest");
        Object objNewInstance = cls.getConstructor(Activity.class).newInstance(this.mActivity);
        cls.getDeclaredMethod("setPermissions", List.class).invoke(objNewInstance, new ArrayList(zznb()));
        cls.getDeclaredMethod("setRequestCode", Integer.TYPE).invoke(objNewInstance, 64206);
        Class<?> cls2 = Class.forName("com.facebook.Session");
        cls.getDeclaredMethod("setCallback", Class.forName("com.facebook.Session$StatusCallback")).invoke(objNewInstance, zzng());
        Object objNewInstance2 = cls2.getConstructor(Context.class).newInstance(this.mActivity);
        cls2.getDeclaredMethod("setActiveSession", cls2).invoke(null, objNewInstance2);
        cls2.getDeclaredMethod("openForRead", cls).invoke(objNewInstance2, objNewInstance);
    }

    private Object zznf() throws ClassNotFoundException {
        Class<?> cls = Class.forName("com.facebook.h");
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.google.android.gms.internal.zzlf.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                Class<?> cls2 = Class.forName("com.facebook.login.h");
                Class<?> cls3 = Class.forName("com.facebook.k");
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (method.getName().equals("onSuccess") && parameterTypes.length == 1 && objArr[0].getClass() == cls2) {
                    zzlf.this.zznc().zzk(zzlf.this.zza(IdpTokenType.zzWc, (String) Class.forName("com.facebook.AccessToken").getMethod("getToken", new Class[0]).invoke(cls2.getDeclaredMethod("getAccessToken", new Class[0]).invoke(objArr[0], new Object[0]), new Object[0]), zzlf.this.zznd()));
                    return null;
                }
                if (method.getName().equals("onCancel") && parameterTypes.length == 0) {
                    zzlf.this.zznc().zzmV();
                    return null;
                }
                if (!method.getName().equals("onError") || parameterTypes.length != 1 || parameterTypes[0] != cls3) {
                    throw new ExceptionInInitializerError("Method not supported!");
                }
                Log.e("AuthSignInClient", "facebook login error!", (Exception) objArr[0]);
                zzlf.this.zznc().zza((Exception) objArr[0]);
                return null;
            }
        });
    }

    private Object zzng() throws ClassNotFoundException {
        final Class<?> cls = Class.forName("com.facebook.Session");
        Class<?> cls2 = Class.forName("com.facebook.Session$StatusCallback");
        return Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.google.android.gms.internal.zzlf.2
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                Class<?> cls3 = Class.forName("com.facebook.SessionState");
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (!method.getName().equals("call") || parameterTypes.length != 3 || parameterTypes[0] != cls || parameterTypes[1] != cls3 || parameterTypes[2] != Exception.class) {
                    throw new ExceptionInInitializerError("Method not supported!");
                }
                if (!((Boolean) cls.getDeclaredMethod("isOpened", new Class[0]).invoke(objArr[0], new Object[0])).booleanValue()) {
                    return null;
                }
                zzlf.this.zznc().zzk(zzlf.this.zza(IdpTokenType.zzWc, (String) cls.getDeclaredMethod("getAccessToken", new Class[0]).invoke(objArr[0], new Object[0]), zzlf.this.zznd()));
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.zzld
    public void zza(zzld.zza zzaVar) {
        zzb(null, null, (zzld.zza) zzx.zzy(zzaVar));
        try {
            zzne();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.google.android.gms.internal.zzld
    public void zza(String str, zzld.zza zzaVar) {
        zzb((String) zzx.zzy(str), null, (zzld.zza) zzx.zzy(zzaVar));
        try {
            zzne();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.google.android.gms.internal.zzld
    public void zza(String str, String str2, zzld.zza zzaVar) {
        zzb((String) zzx.zzy(str), (String) zzx.zzy(str2), (zzld.zza) zzx.zzy(zzaVar));
        try {
            zzne();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.google.android.gms.internal.zzld
    public boolean zza(int i, int i2, Intent intent, zzld.zza zzaVar) {
        zzb(zzaVar);
        if (i != 64206 && this.zzWB == null) {
            return false;
        }
        if (this.zzWB != null && this.zzWC != null && this.zzWD != null) {
            try {
                if (((Boolean) this.zzWB.getDeclaredMethod("isFacebookRequestCode", Integer.TYPE).invoke(null, Integer.valueOf(i))).booleanValue()) {
                    return ((Boolean) this.zzWC.getDeclaredMethod("onActivityResult", Integer.TYPE, Integer.TYPE, Intent.class).invoke(this.zzWD, Integer.valueOf(i), Integer.valueOf(i2), intent)).booleanValue();
                }
                return false;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
        try {
            Class<?> cls = Class.forName("com.facebook.Session");
            Object objInvoke = cls.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
            Method declaredMethod = cls.getDeclaredMethod("onActivityResult", Activity.class, Integer.TYPE, Integer.TYPE, Intent.class);
            if (objInvoke == null) {
                return false;
            }
            return ((Boolean) declaredMethod.invoke(objInvoke, this.mActivity, Integer.valueOf(i), Integer.valueOf(i2), intent)).booleanValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public void zzaf(Context context) {
        zzx.zzy(context);
        try {
            this.zzWB = Class.forName("com.facebook.m");
            try {
                this.zzWB.getDeclaredMethod("sdkInitialize", Context.class, Integer.TYPE).invoke(null, context.getApplicationContext(), 64206);
                this.zzWD = Class.forName("com.facebook.e$a").getDeclaredMethod("create", new Class[0]).invoke(null, new Object[0]);
                Class<?> cls = Class.forName("com.facebook.login.g");
                this.zzWE = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                this.zzWC = Class.forName("com.facebook.e");
                cls.getDeclaredMethod("registerCallback", this.zzWC, Class.forName("com.facebook.h")).invoke(this.zzWE, this.zzWD, zznf());
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (ClassNotFoundException e3) {
            try {
                Class.forName("com.facebook.Session");
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("No supported Facebook sdk found.");
            }
        }
    }

    @Override // com.google.android.gms.internal.zzld
    public zze zzna() {
        return zze.FACEBOOK;
    }
}
