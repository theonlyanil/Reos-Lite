package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import java.io.FileNotFoundException;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class i extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3864a = i.class.getName();

    public static String a(String str, UUID uuid, String str2) {
        return String.format("%s%s/%s/%s", "content://com.facebook.app.FacebookContentProvider", str, uuid.toString(), str2);
    }

    Pair<UUID, String> a(Uri uri) {
        try {
            String[] strArrSplit = uri.getPath().substring(1).split("/");
            String str = strArrSplit[0];
            return new Pair<>(UUID.fromString(str), strArrSplit[1]);
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        Pair<UUID, String> pairA = a(uri);
        if (pairA == null) {
            throw new FileNotFoundException();
        }
        try {
            return ParcelFileDescriptor.open(com.facebook.b.x.a((UUID) pairA.first, (String) pairA.second), 268435456);
        } catch (FileNotFoundException e2) {
            Log.e(f3864a, "Got unexpected exception:" + e2);
            throw e2;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
