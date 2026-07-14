package com.android.library.userprofile.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.ContactsContract;
import android.util.Log;
import com.android.apps.config.util.CLog;
import com.android.library.userprofile.a.a;
import com.google.android.gms.auth.GoogleAuthUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AccountInfoUtil {
    public static final String DEBUG_TAG = "UserProfileTag";

    public static ArrayList<a> getAccountDetails(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        ArrayList<a> arrayList = new ArrayList<>();
        Account[] accounts = accountManager.getAccounts();
        for (Account account : accounts) {
            arrayList.add(new a(account.name, account.type, account.describeContents(), account.hashCode()));
        }
        return arrayList;
    }

    public static ArrayList<String> getAllRegisteredAccounts(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Account account : AccountManager.get(context).getAccounts()) {
                arrayList.add(account.name);
            }
        } catch (Exception e2) {
            CLog.b("Exception", "Exception:" + e2);
        }
        Log.d("UserProfileTag", "All registered account is :: " + arrayList);
        return arrayList;
    }

    public static ArrayList<String> getGoogleAccounts(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Account account : AccountManager.get(context).getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE)) {
                arrayList.add(account.name);
            }
        } catch (Exception e2) {
            CLog.b("Exception", "Exception:" + e2);
        }
        Log.d("UserProfileTag", "Google Accounts list is::" + arrayList);
        return arrayList;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            Log.e("UserProfileTag", "***Not Available***");
            return false;
        }
        Log.e("UserProfileTag", "***Available***");
        return true;
    }

    public String getAccountName(Account account) {
        return "" != 0 ? account.name : "";
    }

    public String getAccountType(Account account) {
        return "" != 0 ? account.type : "";
    }

    public int getAccountdescribeContent(Account account) {
        return account.describeContents();
    }

    public int getAccounthashCode(Account account) {
        return account.hashCode();
    }

    public String getUserNameFromContact(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(ContactsContract.Profile.CONTENT_URI, null, null, null, null);
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
        cursorQuery.moveToFirst();
        cursorQuery.close();
        return string != null ? string : "";
    }
}
