package com.a.a.d.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class i extends g<InputStream> {
    public i(Context context, Uri uri) {
        super(context, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.d.a.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InputStream b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openInputStream(uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.d.a.g
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }
}
