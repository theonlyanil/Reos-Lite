package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class SignInConfiguration implements SafeParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzm();
    final int versionCode;
    private String zzVG;
    private final String zzWh;
    private EmailSignInOptions zzWi;
    private GoogleSignInOptions zzWj;
    private FacebookSignInOptions zzWk;
    private String zzWl;

    SignInConfiguration(int i, String str, String str2, EmailSignInOptions emailSignInOptions, GoogleSignInOptions googleSignInOptions, FacebookSignInOptions facebookSignInOptions, String str3) {
        this.versionCode = i;
        this.zzWh = zzx.zzcG(str);
        this.zzVG = str2;
        this.zzWi = emailSignInOptions;
        this.zzWj = googleSignInOptions;
        this.zzWk = facebookSignInOptions;
        this.zzWl = str3;
    }

    public SignInConfiguration(String str) {
        this(2, str, null, null, null, null, null);
    }

    private JSONObject zzms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consumerPackageName", this.zzWh);
            if (!TextUtils.isEmpty(this.zzVG)) {
                jSONObject.put("serverClientId", this.zzVG);
            }
            if (this.zzWi != null) {
                jSONObject.put("emailSignInOptions", this.zzWi.zzmr());
            }
            if (this.zzWj != null) {
                jSONObject.put("googleSignInOptions", this.zzWj.zzmr());
            }
            if (this.zzWk != null) {
                jSONObject.put("facebookSignInOptions", this.zzWk.zzmr());
            }
            if (!TextUtils.isEmpty(this.zzWl)) {
                jSONObject.put("apiKey", this.zzWl);
            }
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c A[Catch: ClassCastException -> 0x0097, TryCatch #0 {ClassCastException -> 0x0097, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:23:0x004a, B:25:0x004e, B:40:0x008a, B:37:0x007d, B:34:0x0070, B:31:0x0063, B:28:0x0056), top: B:46:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0036 A[Catch: ClassCastException -> 0x0097, TryCatch #0 {ClassCastException -> 0x0097, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:23:0x004a, B:25:0x004e, B:40:0x008a, B:37:0x007d, B:34:0x0070, B:31:0x0063, B:28:0x0056), top: B:46:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x003a A[Catch: ClassCastException -> 0x0097, TryCatch #0 {ClassCastException -> 0x0097, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:23:0x004a, B:25:0x004e, B:40:0x008a, B:37:0x007d, B:34:0x0070, B:31:0x0063, B:28:0x0056), top: B:46:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0040 A[Catch: ClassCastException -> 0x0097, TryCatch #0 {ClassCastException -> 0x0097, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:23:0x004a, B:25:0x004e, B:40:0x008a, B:37:0x007d, B:34:0x0070, B:31:0x0063, B:28:0x0056), top: B:46:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0044 A[Catch: ClassCastException -> 0x0097, TryCatch #0 {ClassCastException -> 0x0097, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:23:0x004a, B:25:0x004e, B:40:0x008a, B:37:0x007d, B:34:0x0070, B:31:0x0063, B:28:0x0056), top: B:46:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x004a A[Catch: ClassCastException -> 0x0097, TryCatch #0 {ClassCastException -> 0x0097, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:23:0x004a, B:25:0x004e, B:40:0x008a, B:37:0x007d, B:34:0x0070, B:31:0x0063, B:28:0x0056), top: B:46:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x004e A[Catch: ClassCastException -> 0x0097, TryCatch #0 {ClassCastException -> 0x0097, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:23:0x004a, B:25:0x004e, B:40:0x008a, B:37:0x007d, B:34:0x0070, B:31:0x0063, B:28:0x0056), top: B:46:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0063 A[Catch: ClassCastException -> 0x0097, TryCatch #0 {ClassCastException -> 0x0097, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:23:0x004a, B:25:0x004e, B:40:0x008a, B:37:0x007d, B:34:0x0070, B:31:0x0063, B:28:0x0056), top: B:46:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x006f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070 A[Catch: ClassCastException -> 0x0097, TryCatch #0 {ClassCastException -> 0x0097, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:23:0x004a, B:25:0x004e, B:40:0x008a, B:37:0x007d, B:34:0x0070, B:31:0x0063, B:28:0x0056), top: B:46:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x007c  */
    /* JADX WARN: Code duplicated, block: B:37:0x007d A[Catch: ClassCastException -> 0x0097, TryCatch #0 {ClassCastException -> 0x0097, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:23:0x004a, B:25:0x004e, B:40:0x008a, B:37:0x007d, B:34:0x0070, B:31:0x0063, B:28:0x0056), top: B:46:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    /* JADX WARN: Code duplicated, block: B:40:0x008a A[Catch: ClassCastException -> 0x0097, TRY_LEAVE, TryCatch #0 {ClassCastException -> 0x0097, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:23:0x004a, B:25:0x004e, B:40:0x008a, B:37:0x007d, B:34:0x0070, B:31:0x0063, B:28:0x0056), top: B:46:0x0004 }] */
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
                if (this.zzWh.equals(signInConfiguration.zzmP())) {
                    if (TextUtils.isEmpty(this.zzVG)) {
                        if (TextUtils.isEmpty(signInConfiguration.zzmB())) {
                            if (TextUtils.isEmpty(this.zzWl)) {
                                if (TextUtils.isEmpty(signInConfiguration.zzmT())) {
                                    if (this.zzWi == null) {
                                        if (signInConfiguration.zzmQ() == null) {
                                            if (this.zzWk == null) {
                                                if (signInConfiguration.zzmS() == null) {
                                                    if (this.zzWj == null ? this.zzWj.equals(signInConfiguration.zzmR()) : signInConfiguration.zzmR() == null) {
                                                    }
                                                }
                                            } else if (this.zzWk.equals(signInConfiguration.zzmS())) {
                                                z = this.zzWj == null ? true : true;
                                            }
                                        }
                                    } else if (this.zzWi.equals(signInConfiguration.zzmQ())) {
                                        if (this.zzWk == null) {
                                            if (signInConfiguration.zzmS() == null) {
                                                if (this.zzWj == null) {
                                                }
                                            }
                                        } else if (this.zzWk.equals(signInConfiguration.zzmS())) {
                                            if (this.zzWj == null) {
                                            }
                                        }
                                    }
                                }
                            } else if (this.zzWl.equals(signInConfiguration.zzmT())) {
                                if (this.zzWi == null) {
                                    if (signInConfiguration.zzmQ() == null) {
                                        if (this.zzWk == null) {
                                            if (signInConfiguration.zzmS() == null) {
                                                if (this.zzWj == null) {
                                                }
                                            }
                                        } else if (this.zzWk.equals(signInConfiguration.zzmS())) {
                                            if (this.zzWj == null) {
                                            }
                                        }
                                    }
                                } else if (this.zzWi.equals(signInConfiguration.zzmQ())) {
                                    if (this.zzWk == null) {
                                        if (signInConfiguration.zzmS() == null) {
                                            if (this.zzWj == null) {
                                            }
                                        }
                                    } else if (this.zzWk.equals(signInConfiguration.zzmS())) {
                                        if (this.zzWj == null) {
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.zzVG.equals(signInConfiguration.zzmB())) {
                        if (TextUtils.isEmpty(this.zzWl)) {
                            if (TextUtils.isEmpty(signInConfiguration.zzmT())) {
                                if (this.zzWi == null) {
                                    if (signInConfiguration.zzmQ() == null) {
                                        if (this.zzWk == null) {
                                            if (signInConfiguration.zzmS() == null) {
                                                if (this.zzWj == null) {
                                                }
                                            }
                                        } else if (this.zzWk.equals(signInConfiguration.zzmS())) {
                                            if (this.zzWj == null) {
                                            }
                                        }
                                    }
                                } else if (this.zzWi.equals(signInConfiguration.zzmQ())) {
                                    if (this.zzWk == null) {
                                        if (signInConfiguration.zzmS() == null) {
                                            if (this.zzWj == null) {
                                            }
                                        }
                                    } else if (this.zzWk.equals(signInConfiguration.zzmS())) {
                                        if (this.zzWj == null) {
                                        }
                                    }
                                }
                            }
                        } else if (this.zzWl.equals(signInConfiguration.zzmT())) {
                            if (this.zzWi == null) {
                                if (signInConfiguration.zzmQ() == null) {
                                    if (this.zzWk == null) {
                                        if (signInConfiguration.zzmS() == null) {
                                            if (this.zzWj == null) {
                                            }
                                        }
                                    } else if (this.zzWk.equals(signInConfiguration.zzmS())) {
                                        if (this.zzWj == null) {
                                        }
                                    }
                                }
                            } else if (this.zzWi.equals(signInConfiguration.zzmQ())) {
                                if (this.zzWk == null) {
                                    if (signInConfiguration.zzmS() == null) {
                                        if (this.zzWj == null) {
                                        }
                                    }
                                } else if (this.zzWk.equals(signInConfiguration.zzmS())) {
                                    if (this.zzWj == null) {
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (ClassCastException e2) {
            }
        }
        return z;
    }

    public int hashCode() {
        return new zze().zzo(this.zzWh).zzo(this.zzVG).zzo(this.zzWl).zzo(this.zzWi).zzo(this.zzWj).zzo(this.zzWk).zzmM();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public SignInConfiguration zzi(GoogleSignInOptions googleSignInOptions) {
        this.zzWj = (GoogleSignInOptions) zzx.zzb(googleSignInOptions, "GoogleSignInOptions cannot be null.");
        return this;
    }

    public String zzmB() {
        return this.zzVG;
    }

    public String zzmP() {
        return this.zzWh;
    }

    public EmailSignInOptions zzmQ() {
        return this.zzWi;
    }

    public GoogleSignInOptions zzmR() {
        return this.zzWj;
    }

    public FacebookSignInOptions zzmS() {
        return this.zzWk;
    }

    public String zzmT() {
        return this.zzWl;
    }

    public String zzmr() {
        return zzms().toString();
    }
}
