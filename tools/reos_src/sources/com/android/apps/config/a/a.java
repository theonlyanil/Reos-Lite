package com.android.apps.config.a;

import android.util.Base64;
import android.util.Log;
import com.flurry.android.Constants;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f2532b = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2531a = false;

    public static String a(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec secretKeySpecA = a(str);
            c("message", str2);
            String strEncodeToString = Base64.encodeToString(a(secretKeySpecA, f2532b, str2.getBytes("UTF-8")), 2);
            c("Base64.NO_WRAP", strEncodeToString);
            return strEncodeToString;
        } catch (UnsupportedEncodingException e2) {
            if (f2531a) {
                Log.e("AESCrypt", "UnsupportedEncodingException ", e2);
            }
            throw new GeneralSecurityException(e2);
        }
    }

    private static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & Constants.UNKNOWN;
            cArr2[i * 2] = cArr[i2 >>> 4];
            cArr2[(i * 2) + 1] = cArr[i2 & 15];
        }
        return new String(cArr2);
    }

    private static SecretKeySpec a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        messageDigest.update(bytes, 0, bytes.length);
        byte[] bArrDigest = messageDigest.digest();
        a("SHA-256 key ", bArrDigest);
        return new SecretKeySpec(bArrDigest, "AES");
    }

    private static void a(String str, byte[] bArr) {
        if (f2531a) {
            Log.d("AESCrypt", str + "[" + bArr.length + "] [" + a(bArr) + "]");
        }
    }

    public static byte[] a(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        a("cipherText", bArrDoFinal);
        return bArrDoFinal;
    }

    public static String b(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec secretKeySpecA = a(str);
            c("base64EncodedCipherText", str2);
            byte[] bArrDecode = Base64.decode(str2, 2);
            a("decodedCipherText", bArrDecode);
            byte[] bArrB = b(secretKeySpecA, f2532b, bArrDecode);
            a("decryptedBytes", bArrB);
            String str3 = new String(bArrB, "UTF-8");
            c("message", str3);
            return str3;
        } catch (UnsupportedEncodingException e2) {
            if (f2531a) {
                Log.e("AESCrypt", "UnsupportedEncodingException ", e2);
            }
            throw new GeneralSecurityException(e2);
        }
    }

    public static byte[] b(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr));
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        a("decryptedBytes", bArrDoFinal);
        return bArrDoFinal;
    }

    private static void c(String str, String str2) {
        if (f2531a) {
            Log.d("AESCrypt", str + "[" + str2.length() + "] [" + str2 + "]");
        }
    }
}
