package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zze {
    public static final zze zzaiV = zza("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000 \u180e ").zza(zza(8192, 8202));
    public static final zze zzaiW = zza("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").zza(zza(8192, 8198)).zza(zza(8200, 8202));
    public static final zze zzaiX = zza(0, 127);
    public static final zze zzaiY;
    public static final zze zzaiZ;
    public static final zze zzaja;
    public static final zze zzajb;
    public static final zze zzajc;
    public static final zze zzajd;
    public static final zze zzaje;
    public static final zze zzajf;
    public static final zze zzajg;
    public static final zze zzajh;
    public static final zze zzaji;
    public static final zze zzajj;

    private static class zza extends zze {
        List<zze> zzajq;

        zza(List<zze> list) {
            this.zzajq = list;
        }

        @Override // com.google.android.gms.common.internal.zze
        public zze zza(zze zzeVar) {
            ArrayList arrayList = new ArrayList(this.zzajq);
            arrayList.add(zzx.zzy(zzeVar));
            return new zza(arrayList);
        }

        @Override // com.google.android.gms.common.internal.zze
        public boolean zzd(char c2) {
            Iterator<zze> it = this.zzajq.iterator();
            while (it.hasNext()) {
                if (it.next().zzd(c2)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        zze zzeVarZza = zza('0', '9');
        zze zzeVarZza2 = zzeVarZza;
        for (char c2 : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            zzeVarZza2 = zzeVarZza2.zza(zza(c2, (char) (c2 + '\t')));
        }
        zzaiY = zzeVarZza2;
        zzaiZ = zza('\t', '\r').zza(zza((char) 28, ' ')).zza(zzc((char) 5760)).zza(zzc((char) 6158)).zza(zza((char) 8192, (char) 8198)).zza(zza((char) 8200, (char) 8203)).zza(zza((char) 8232, (char) 8233)).zza(zzc((char) 8287)).zza(zzc((char) 12288));
        zzaja = new zze() { // from class: com.google.android.gms.common.internal.zze.1
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c3) {
                return Character.isDigit(c3);
            }
        };
        zzajb = new zze() { // from class: com.google.android.gms.common.internal.zze.5
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c3) {
                return Character.isLetter(c3);
            }
        };
        zzajc = new zze() { // from class: com.google.android.gms.common.internal.zze.6
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c3) {
                return Character.isLetterOrDigit(c3);
            }
        };
        zzajd = new zze() { // from class: com.google.android.gms.common.internal.zze.7
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c3) {
                return Character.isUpperCase(c3);
            }
        };
        zzaje = new zze() { // from class: com.google.android.gms.common.internal.zze.8
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c3) {
                return Character.isLowerCase(c3);
            }
        };
        zzajf = zza((char) 0, (char) 31).zza(zza((char) 127, (char) 159));
        zzajg = zza((char) 0, ' ').zza(zza((char) 127, (char) 160)).zza(zzc((char) 173)).zza(zza((char) 1536, (char) 1539)).zza(zza("\u06dd\u070f\u1680឴឵\u180e")).zza(zza((char) 8192, (char) 8207)).zza(zza((char) 8232, (char) 8239)).zza(zza((char) 8287, (char) 8292)).zza(zza((char) 8298, (char) 8303)).zza(zzc((char) 12288)).zza(zza((char) 55296, (char) 63743)).zza(zza("\ufeff\ufff9\ufffa\ufffb"));
        zzajh = zza((char) 0, (char) 1273).zza(zzc((char) 1470)).zza(zza((char) 1488, (char) 1514)).zza(zzc((char) 1523)).zza(zzc((char) 1524)).zza(zza((char) 1536, (char) 1791)).zza(zza((char) 1872, (char) 1919)).zza(zza((char) 3584, (char) 3711)).zza(zza((char) 7680, (char) 8367)).zza(zza((char) 8448, (char) 8506)).zza(zza((char) 64336, (char) 65023)).zza(zza((char) 65136, (char) 65279)).zza(zza((char) 65377, (char) 65500));
        zzaji = new zze() { // from class: com.google.android.gms.common.internal.zze.9
            @Override // com.google.android.gms.common.internal.zze
            public zze zza(zze zzeVar) {
                zzx.zzy(zzeVar);
                return this;
            }

            @Override // com.google.android.gms.common.internal.zze
            public boolean zzb(CharSequence charSequence) {
                zzx.zzy(charSequence);
                return true;
            }

            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c3) {
                return true;
            }
        };
        zzajj = new zze() { // from class: com.google.android.gms.common.internal.zze.10
            @Override // com.google.android.gms.common.internal.zze
            public zze zza(zze zzeVar) {
                return (zze) zzx.zzy(zzeVar);
            }

            @Override // com.google.android.gms.common.internal.zze
            public boolean zzb(CharSequence charSequence) {
                return charSequence.length() == 0;
            }

            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c3) {
                return false;
            }
        };
    }

    public static zze zza(final char c2, final char c3) {
        zzx.zzab(c3 >= c2);
        return new zze() { // from class: com.google.android.gms.common.internal.zze.4
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c4) {
                return c2 <= c4 && c4 <= c3;
            }
        };
    }

    public static zze zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return zzajj;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                final char cCharAt = charSequence.charAt(0);
                final char cCharAt2 = charSequence.charAt(1);
                return new zze() { // from class: com.google.android.gms.common.internal.zze.2
                    @Override // com.google.android.gms.common.internal.zze
                    public boolean zzd(char c2) {
                        return c2 == cCharAt || c2 == cCharAt2;
                    }
                };
            default:
                final char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new zze() { // from class: com.google.android.gms.common.internal.zze.3
                    @Override // com.google.android.gms.common.internal.zze
                    public boolean zzd(char c2) {
                        return Arrays.binarySearch(charArray, c2) >= 0;
                    }
                };
        }
    }

    public static zze zzc(final char c2) {
        return new zze() { // from class: com.google.android.gms.common.internal.zze.11
            @Override // com.google.android.gms.common.internal.zze
            public zze zza(zze zzeVar) {
                return zzeVar.zzd(c2) ? zzeVar : super.zza(zzeVar);
            }

            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c3) {
                return c3 == c2;
            }
        };
    }

    public zze zza(zze zzeVar) {
        return new zza(Arrays.asList(this, (zze) zzx.zzy(zzeVar)));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c2);
}
