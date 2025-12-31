package b.a.a;

import android.bluetooth.BluetoothDevice;
import b.a.a.c.E;
import b.a.a.c.t;
import java.util.List;

public final class oa {

    /* renamed from: a  reason: collision with root package name */
    private final BluetoothDevice f1169a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1170b;
    private final String c;
    private final String d;
    private String e;
    private final int f;
    private final List<t> g;
    private final E h;
    private int i = za.dlr_name_text_color;

    public oa(BluetoothDevice bluetoothDevice, String str, String str2, String str3, int i2, List<t> list) {
        this.f1169a = bluetoothDevice;
        this.f1170b = str;
        this.c = str2;
        this.d = str3;
        this.f = i2;
        this.g = list;
        this.h = new E(list);
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public BluetoothDevice c() {
        return this.f1169a;
    }

    public String d() {
        return this.c;
    }

    public int e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa)) {
            return false;
        }
        return this.d.equals(((oa) obj).a());
    }

    public int f() {
        return this.f;
    }

    public List<t> g() {
        return this.g;
    }

    public E h() {
        return this.h;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public boolean i() {
        return this.f1169a.getType() == 1;
    }

    public boolean j() {
        return this.f1169a.getType() == 2;
    }

    public String toString() {
        return "\nCsValve { \n    Device: " + this.f1169a + 10 + "    Name: '" + this.f1170b + '\'' + 10 + "    Friendly Name: '" + this.c + '\'' + 10 + "    Address: '" + this.d + '\'' + 10 + "    Alias: '" + this.e + '\'' + 10 + "    RSSI: " + this.f + 10 + "    Scan Records: " + this.g + 10 + "    Valve Data: " + this.h.toString() + 10 + "    Name Color ID: " + this.i + 10 + "}";
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(int i2) {
        this.i = i2;
    }
}
