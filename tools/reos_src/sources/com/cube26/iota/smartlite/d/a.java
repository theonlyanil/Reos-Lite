package com.cube26.iota.smartlite.d;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.cube26.iota.smartlite.b.c;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3373f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String n;
    private boolean o;
    private int p;
    private boolean q;
    private int t;
    private int u;
    private boolean v;
    private byte[] w;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean r = false;
    private int s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattCharacteristic f3368a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattCharacteristic f3369b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothGattCharacteristic f3370c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothGattCharacteristic f3371d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BluetoothGatt f3372e = null;

    public void a() {
        this.f3373f++;
    }

    public void a(int i) {
        this.p = i;
    }

    public void a(BluetoothGatt bluetoothGatt) {
        this.f3372e = bluetoothGatt;
    }

    public void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f3368a = bluetoothGattCharacteristic;
    }

    public void a(String str) {
        this.n = str;
    }

    public void a(boolean z) {
        this.q = z;
    }

    public void a(byte[] bArr) {
        this.w = bArr;
    }

    public void b(int i) {
        this.f3373f = i;
    }

    public void b(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f3369b = bluetoothGattCharacteristic;
    }

    public void b(String str) {
        this.j = str;
    }

    public void b(boolean z) {
        this.m = z;
    }

    public boolean b() {
        return this.q;
    }

    public String c() {
        return this.n;
    }

    public void c(int i) {
        this.u = i;
    }

    public void c(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f3371d = bluetoothGattCharacteristic;
    }

    public void c(String str) {
        this.i = str;
    }

    public void c(boolean z) {
        this.l = z;
    }

    public int d() {
        return this.f3373f;
    }

    public void d(int i) {
        this.t = i;
    }

    public void d(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f3370c = bluetoothGattCharacteristic;
    }

    public void d(String str) {
        this.g = str;
    }

    public void d(boolean z) {
        this.v = z;
    }

    public void e(int i) {
        this.s = i;
        b(i == 2);
        e(i == 2);
    }

    public void e(String str) {
        this.h = str;
    }

    public void e(boolean z) {
        this.k = z;
    }

    public boolean e() {
        return this.m;
    }

    public boolean equals(Object obj) {
        c cVar = (c) obj;
        if (((a) cVar).q() == null) {
            return false;
        }
        return (cVar instanceof a) && this.h != null && this.h.equals(((a) cVar).q());
    }

    public boolean f() {
        return this.l;
    }

    @Override // com.cube26.iota.smartlite.b.c
    public boolean g() {
        return false;
    }

    @Override // com.cube26.iota.smartlite.b.c
    public boolean h() {
        return false;
    }

    public int i() {
        return this.u;
    }

    public int j() {
        return this.t;
    }

    public boolean k() {
        return this.v;
    }

    public byte[] l() {
        return this.w;
    }

    public boolean m() {
        return this.o;
    }

    public String n() {
        return this.j;
    }

    public String o() {
        return this.i;
    }

    public String p() {
        return this.g;
    }

    public String q() {
        return this.h;
    }

    public boolean r() {
        return this.k;
    }

    public int s() {
        return this.s;
    }

    public boolean t() {
        return this.s == 2;
    }

    public String toString() {
        return "name - " + this.g + " address - " + this.h + " selected - " + this.k + " available - " + this.m + " connected - " + t() + "";
    }

    public BluetoothGattCharacteristic u() {
        return this.f3369b;
    }

    public BluetoothGatt v() {
        return this.f3372e;
    }

    public BluetoothGattCharacteristic w() {
        return this.f3370c;
    }

    public void x() {
        this.f3373f = 0;
        this.o = true;
        this.s = 0;
        if (this.f3372e != null) {
            this.f3372e.disconnect();
            this.f3372e = null;
        }
    }
}
