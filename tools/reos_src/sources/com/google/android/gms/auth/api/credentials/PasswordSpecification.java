package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class PasswordSpecification implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    public static final PasswordSpecification zzUO = new zza().zzh(12, 16).zzbD("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zze("abcdefghijkmnopqrstxyz", 1).zze("ABCDEFGHJKLMNPQRSTXY", 1).zze("3456789", 1).zzmj();
    public static final PasswordSpecification zzUP = new zza().zzh(12, 16).zzbD("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zze("abcdefghijklmnopqrstuvwxyz", 1).zze("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zze("1234567890", 1).zzmj();
    final int mVersionCode;
    final String zzUQ;
    final List<String> zzUR;
    final List<Integer> zzUS;
    final int zzUT;
    final int zzUU;
    private final int[] zzUV = zzmi();
    private final Random zzuj = new SecureRandom();

    public static class zza {
        private final TreeSet<Character> zzUW = new TreeSet<>();
        private final List<String> zzUR = new ArrayList();
        private final List<Integer> zzUS = new ArrayList();
        private int zzUT = 12;
        private int zzUU = 16;

        private void zzmk() {
            int i;
            int iIntValue = 0;
            Iterator<Integer> it = this.zzUS.iterator();
            while (true) {
                i = iIntValue;
                if (!it.hasNext()) {
                    break;
                } else {
                    iIntValue = it.next().intValue() + i;
                }
            }
            if (i > this.zzUU) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
        }

        private void zzml() {
            boolean[] zArr = new boolean[95];
            Iterator<String> it = this.zzUR.iterator();
            while (it.hasNext()) {
                for (char c2 : it.next().toCharArray()) {
                    if (zArr[c2 - ' ']) {
                        throw new zzb("character " + c2 + " occurs in more than one required character set");
                    }
                    zArr[c2 - ' '] = true;
                }
            }
        }

        private TreeSet<Character> zzr(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new zzb(str2 + " cannot be null or empty");
            }
            TreeSet<Character> treeSet = new TreeSet<>();
            for (char c2 : str.toCharArray()) {
                if (PasswordSpecification.zzb(c2, 32, 126)) {
                    throw new zzb(str2 + " must only contain ASCII printable characters");
                }
                treeSet.add(Character.valueOf(c2));
            }
            return treeSet;
        }

        public zza zzbD(String str) {
            this.zzUW.addAll(zzr(str, "allowedChars"));
            return this;
        }

        public zza zze(String str, int i) {
            if (i < 1) {
                throw new zzb("count must be at least 1");
            }
            this.zzUR.add(PasswordSpecification.zzb(zzr(str, "requiredChars")));
            this.zzUS.add(Integer.valueOf(i));
            return this;
        }

        public zza zzh(int i, int i2) {
            if (i < 1) {
                throw new zzb("minimumSize must be at least 1");
            }
            if (i > i2) {
                throw new zzb("maximumSize must be greater than or equal to minimumSize");
            }
            this.zzUT = i;
            this.zzUU = i2;
            return this;
        }

        public PasswordSpecification zzmj() {
            if (this.zzUW.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            zzmk();
            zzml();
            return new PasswordSpecification(1, PasswordSpecification.zzb(this.zzUW), this.zzUR, this.zzUS, this.zzUT, this.zzUU);
        }
    }

    public static class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    PasswordSpecification(int i, String str, List<String> list, List<Integer> list2, int i2, int i3) {
        this.mVersionCode = i;
        this.zzUQ = str;
        this.zzUR = Collections.unmodifiableList(list);
        this.zzUS = Collections.unmodifiableList(list2);
        this.zzUT = i2;
        this.zzUU = i3;
    }

    private int zza(char c2) {
        return c2 - ' ';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzb(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        Iterator<Character> it = collection.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return new String(cArr);
            }
            i = i2 + 1;
            cArr[i2] = it.next().charValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzb(int i, int i2, int i3) {
        return i < i2 || i > i3;
    }

    private int[] zzmi() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        Iterator<String> it = this.zzUR.iterator();
        int i = 0;
        while (it.hasNext()) {
            for (char c2 : it.next().toCharArray()) {
                iArr[zza(c2)] = i;
            }
            i++;
        }
        return iArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
