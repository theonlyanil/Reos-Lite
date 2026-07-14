package com.google.b.b.a;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5416a = d.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f5417b = Pattern.compile(",");

    private d() {
    }

    public static Map<com.google.b.e, Object> a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(com.google.b.e.class);
        for (com.google.b.e eVar : com.google.b.e.values()) {
            if (eVar != com.google.b.e.CHARACTER_SET && eVar != com.google.b.e.NEED_RESULT_POINT_CALLBACK && eVar != com.google.b.e.POSSIBLE_FORMATS) {
                String strName = eVar.name();
                if (extras.containsKey(strName)) {
                    if (eVar.a().equals(Void.class)) {
                        enumMap.put(eVar, Boolean.TRUE);
                    } else {
                        Object obj = extras.get(strName);
                        if (eVar.a().isInstance(obj)) {
                            enumMap.put(eVar, obj);
                        } else {
                            Log.w(f5416a, "Ignoring hint " + eVar + " because it is not assignable from " + obj);
                        }
                    }
                }
            }
        }
        Log.i(f5416a, "Hints from the Intent: " + enumMap);
        return enumMap;
    }
}
