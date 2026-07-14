package com.android.library.rmnlibrary;

/* JADX INFO: loaded from: classes.dex */
public class AbstractRMNResponse {
    private String error;
    private String message;
    private String status;

    public String getError() {
        return this.error;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStatus() {
        return this.status;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
