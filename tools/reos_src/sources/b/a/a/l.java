package b.a.a;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, List<k>> f1929a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Class<?>> f1930b = new ConcurrentHashMap();

    l(List<Class<?>> list) {
        if (list != null) {
            for (Class<?> cls : list) {
                this.f1930b.put(cls, cls);
            }
        }
    }

    List<k> a(Class<?> cls) {
        List<k> list;
        n nVar;
        String name = cls.getName();
        synchronized (f1929a) {
            list = f1929a.get(name);
        }
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            String name2 = superclass.getName();
            if (name2.startsWith("java.") || name2.startsWith("javax.") || name2.startsWith("android.")) {
                break;
            }
            for (Method method : superclass.getDeclaredMethods()) {
                String name3 = method.getName();
                if (name3.startsWith("onEvent")) {
                    int modifiers = method.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 1) {
                            String strSubstring = name3.substring("onEvent".length());
                            if (strSubstring.length() == 0) {
                                nVar = n.PostThread;
                            } else if (strSubstring.equals("MainThread")) {
                                nVar = n.MainThread;
                            } else if (strSubstring.equals("BackgroundThread")) {
                                nVar = n.BackgroundThread;
                            } else if (strSubstring.equals("Async")) {
                                nVar = n.Async;
                            } else if (!this.f1930b.containsKey(superclass)) {
                                throw new e("Illegal onEvent method, check for typos: " + method);
                            }
                            Class<?> cls2 = parameterTypes[0];
                            sb.setLength(0);
                            sb.append(name3);
                            sb.append('>').append(cls2.getName());
                            if (hashSet.add(sb.toString())) {
                                arrayList.add(new k(method, nVar, cls2));
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f1930b.containsKey(superclass)) {
                        Log.d(c.f1889a, "Skipping method (not public, static or abstract): " + superclass + "." + name3);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            throw new e("Subscriber " + cls + " has no public methods called onEvent");
        }
        synchronized (f1929a) {
            f1929a.put(name, arrayList);
        }
        return arrayList;
    }
}
