package com.google.b.b.a.a.a;

import android.hardware.Camera;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5403a = a.class.getName();

    private a() {
    }

    public static int a(int i) {
        int i2;
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f5403a, "No cameras!");
            return -1;
        }
        boolean z = i >= 0;
        if (z) {
            i2 = i;
        } else {
            i2 = 0;
            while (i2 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i2++;
            }
        }
        if (i2 < numberOfCameras) {
            return i2;
        }
        return !z ? 0 : -1;
    }

    public static Camera b(int i) {
        int iA = a(i);
        if (iA == -1) {
            return null;
        }
        return Camera.open(iA);
    }
}
