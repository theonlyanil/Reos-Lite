package com.google.b.b.a.a;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f5402a = Pattern.compile(";");

    @TargetApi(15)
    private static String a(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb.append(area.rect).append(':').append(area.weight).append(' ');
        }
        return sb.toString();
    }

    private static String a(String str, Collection<String> collection, String... strArr) {
        Log.i("CameraConfiguration", "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i("CameraConfiguration", "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i("CameraConfiguration", "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i("CameraConfiguration", "No supported values match");
        return null;
    }

    @TargetApi(15)
    private static List<Camera.Area> a(int i) {
        return Collections.singletonList(new Camera.Area(new Rect(-i, -i, i, i), 1));
    }

    @TargetApi(15)
    public static void a(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support focus areas");
            return;
        }
        Log.i("CameraConfiguration", "Old focus areas: " + a(parameters.getFocusAreas()));
        List<Camera.Area> listA = a(400);
        Log.i("CameraConfiguration", "Setting focus area to : " + a(listA));
        parameters.setFocusAreas(listA);
    }

    public static void a(Camera.Parameters parameters, boolean z) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String strA = z ? a("flash mode", supportedFlashModes, "torch", "on") : a("flash mode", supportedFlashModes, "off");
        if (strA != null) {
            if (strA.equals(parameters.getFlashMode())) {
                Log.i("CameraConfiguration", "Flash mode already set to " + strA);
            } else {
                Log.i("CameraConfiguration", "Setting flash mode to " + strA);
                parameters.setFlashMode(strA);
            }
        }
    }

    public static void a(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String strA = null;
        if (z) {
            strA = (z3 || z2) ? a("focus mode", supportedFocusModes, "auto") : a("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto");
        }
        if (!z3 && strA == null) {
            strA = a("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (strA != null) {
            if (strA.equals(parameters.getFocusMode())) {
                Log.i("CameraConfiguration", "Focus mode already set to " + strA);
            } else {
                parameters.setFocusMode(strA);
            }
        }
    }

    @TargetApi(15)
    public static void b(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support metering areas");
            return;
        }
        Log.i("CameraConfiguration", "Old metering areas: " + parameters.getMeteringAreas());
        List<Camera.Area> listA = a(400);
        Log.i("CameraConfiguration", "Setting metering area to : " + a(listA));
        parameters.setMeteringAreas(listA);
    }

    public static void b(Camera.Parameters parameters, boolean z) {
        float f2 = BitmapDescriptorFactory.HUE_RED;
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if ((minExposureCompensation == 0 && maxExposureCompensation == 0) || exposureCompensationStep <= BitmapDescriptorFactory.HUE_RED) {
            Log.i("CameraConfiguration", "Camera does not support exposure compensation");
            return;
        }
        if (!z) {
            f2 = 1.5f;
        }
        int iRound = Math.round(f2 / exposureCompensationStep);
        float f3 = exposureCompensationStep * iRound;
        int iMax = Math.max(Math.min(iRound, maxExposureCompensation), minExposureCompensation);
        if (parameters.getExposureCompensation() == iMax) {
            Log.i("CameraConfiguration", "Exposure compensation already set to " + iMax + " / " + f3);
        } else {
            Log.i("CameraConfiguration", "Setting exposure compensation to " + iMax + " / " + f3);
            parameters.setExposureCompensation(iMax);
        }
    }

    @TargetApi(15)
    public static void c(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            Log.i("CameraConfiguration", "This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            Log.i("CameraConfiguration", "Video stabilization already enabled");
        } else {
            Log.i("CameraConfiguration", "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static void d(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i("CameraConfiguration", "Barcode scene mode already set");
            return;
        }
        String strA = a("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (strA != null) {
            parameters.setSceneMode(strA);
        }
    }

    public static void e(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i("CameraConfiguration", "Negative effect already set");
            return;
        }
        String strA = a("color effect", parameters.getSupportedColorEffects(), "negative");
        if (strA != null) {
            parameters.setColorEffect(strA);
        }
    }
}
