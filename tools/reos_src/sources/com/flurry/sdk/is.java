package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class is implements lb<hs> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4376a = is.class.getSimpleName();

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException, IOException {
        if (jSONObject == null) {
            throw new IOException("Null Json object");
        }
        if (str2 != null) {
            jSONObject.put(str, str2);
        } else {
            jSONObject.put(str, JSONObject.NULL);
        }
    }

    @Override // com.flurry.sdk.lb
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public hs b(InputStream inputStream) throws IOException {
        throw new IOException("Deserialize not supported for request");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00da */
    @Override // com.flurry.sdk.lb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.io.OutputStream r10, com.flurry.sdk.hs r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.is.a(java.io.OutputStream, com.flurry.sdk.hs):void");
    }
}
